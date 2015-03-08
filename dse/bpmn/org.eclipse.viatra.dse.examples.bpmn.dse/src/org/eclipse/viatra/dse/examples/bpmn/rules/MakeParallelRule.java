/*******************************************************************************
 * Copyright (c) 2010-2015, Andras Szabolcs Nagy, Abel Hegedus, Akos Horvath, Zoltan Ujhelyi and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Andras Szabolcs Nagy - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.dse.examples.bpmn.rules;

import java.util.HashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.api.TransformationRule;
import org.eclipse.viatra.dse.examples.bpmn.genetic.BpmnGeneticTestRunner;
import org.eclipse.viatra.dse.examples.bpmn.patterns.MakeParallelMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.MakeParallelProcessor;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.MakeParallelQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.problems.SimplifiedBpmnBuilder;
import org.eclipse.viatra.dse.examples.bpmn.serializer.BpmnSerializer;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ParallelGateway;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.Task;

/**
 *  This rule makes two sequential task parallel.
 * @author Andras Szabolcs Nagy
 */
public class MakeParallelRule {

    public static TransformationRule<MakeParallelMatch> createRule() throws IncQueryException {
        TransformationRule<MakeParallelMatch> rule = new TransformationRule<MakeParallelMatch>(MakeParallelQuerySpecification.instance(),
                new MakeParallelProcessor() {
                    @Override
                    public void process(Task pT1, Task pT2, SimplifiedBPMN pRoot) {
                        String name = BpmnSerializer.createOrderedString(pT1.getName(), pT2.getName());
                        
                        SimplifiedBpmnBuilder builder = new SimplifiedBpmnBuilder(pRoot);
                        
                        ParallelGateway divergingGateway = builder.createParallelGateway("Diverging:" + name, true);
                        ParallelGateway convergingGateway = builder.createParallelGateway("Converging:" + name, false);

                        EList<SequenceFlow> flows = pT1.getInFlows();
                        while (!flows.isEmpty()) {
                            SequenceFlow flow = flows.get(0);
                            flow.setTarget(divergingGateway);
                        }
                        flows = pT2.getOutFlows();
                        while (!flows.isEmpty()) {
                            SequenceFlow flow = flows.get(0);
                            flow.setSource(convergingGateway);
                        }
                        
                        SequenceFlow flow = pT1.getOutFlows().get(0);
                        pRoot.getSequenceFlows().remove(flow);
                        flow.setTarget(null);
                        flow.setSource(null);
                        
                        builder.createFlow(divergingGateway, pT1);
                        builder.createFlow(divergingGateway, pT2);
                        builder.createFlow(pT1, convergingGateway);
                        builder.createFlow(pT2, convergingGateway);
                        
                    }

                });
        HashMap<String, Double> costs = new HashMap<String, Double>(1);
        costs.put(BpmnGeneticTestRunner.COST, 1d);
        rule.setCosts(costs);
        return rule;
    }
}
