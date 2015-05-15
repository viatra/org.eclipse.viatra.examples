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

import org.eclipse.emf.common.util.EList;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.api.DSETransformationRule;
import org.eclipse.viatra.dse.examples.bpmn.patterns.MakeSequentialMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.MakeSequentialMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.MakeSequentialProcessor;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.MakeSequentialQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.problems.SimplifiedBpmnBuilder;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.BaseElement;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.Task;

/**
 * This rule makes two parallel task sequential.
 * 
 * @author Andras Szabolcs Nagy
 */
public class MakeSequentialRule {

    public static DSETransformationRule<MakeSequentialMatch, MakeSequentialMatcher> createRule() throws IncQueryException {
        DSETransformationRule<MakeSequentialMatch, MakeSequentialMatcher> rule = new DSETransformationRule<MakeSequentialMatch, MakeSequentialMatcher>(
                MakeSequentialQuerySpecification.instance(), new MakeSequentialProcessor() {

                    @Override
                    public void process(Task pT1, Task pT2, SimplifiedBPMN pRoot) {

                        EList<SequenceFlow> flows = pT1.getInFlows();
                        BaseElement divergingGateway = flows.get(0).getSource();
                        pRoot.getParallelGateways().remove(divergingGateway);
                        pRoot.getSequenceFlows().removeAll(flows);
                        flows.clear();
                        flows = pT2.getInFlows();
                        pRoot.getSequenceFlows().removeAll(flows);
                        flows.clear();
                        flows = pT1.getOutFlows();
                        pRoot.getSequenceFlows().removeAll(flows);
                        flows.clear();
                        flows = pT2.getOutFlows();
                        BaseElement convergingGateway = flows.get(0).getTarget();
                        pRoot.getParallelGateways().remove(convergingGateway);
                        pRoot.getSequenceFlows().removeAll(flows);
                        flows.clear();

                        flows = divergingGateway.getInFlows();
                        while (!flows.isEmpty()) {
                            SequenceFlow flow = flows.get(0);
                            flow.setTarget(pT1);
                        }
                        flows = convergingGateway.getOutFlows();
                        while (!flows.isEmpty()) {
                            SequenceFlow flow = flows.get(0);
                            flow.setSource(pT2);
                        }

                        new SimplifiedBpmnBuilder(pRoot).createFlow(pT1, pT2);
                    }
                });
        return rule;
    }
}
