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
import java.util.Map;

import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.api.TransformationRule;
import org.eclipse.viatra.dse.api.TransformationRule.ActivationCostProcessor;
import org.eclipse.viatra.dse.examples.bpmn.genetic.BpmnGeneticTestRunner;
import org.eclipse.viatra.dse.examples.bpmn.patterns.CreateResourceMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.CreateResourceMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.CreateResourceProcessor;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.CreateResourceQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.problems.BpmnProblems;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnFactory;

/**
 * This rule creates resource instance.
 * 
 * @author Andras Szabolcs Nagy
 */
public class CreateResourceRule {

    public static TransformationRule<CreateResourceMatch, CreateResourceMatcher> createRule() throws IncQueryException {
        TransformationRule<CreateResourceMatch, CreateResourceMatcher> rule = new TransformationRule<CreateResourceMatch, CreateResourceMatcher>(
                CreateResourceQuerySpecification.instance(), new CreateResourceProcessor() {

                    @Override
                    public void process(ResourceTypeVariant pRTV) {
                        pRTV.getInstances().add(SimplifiedbpmnFactory.eINSTANCE.createResourceInstance());
                    }

                });
        rule.setActivationCostProcessor(new ActivationCostProcessor<CreateResourceMatch>() {
            @Override
            public Map<String, Double> process(CreateResourceMatch match) {
                String name = match.getRTV().getName();
                Double d;
                if (name.equals(BpmnProblems.NOSQL_FAST)) {
                    d = 5d;
                } else if (name.equals(BpmnProblems.NOSQL_MEDIUM)) {
                    d = 3d;
                } else if (name.equals(BpmnProblems.NOSQL_SLOW)) {
                    d = 1.5d;
                } else if (name.equals(BpmnProblems.SQL_FAST)) {
                    d = 5d;
                } else if (name.equals(BpmnProblems.SQL_MEDIUM)) {
                    d = 3d;
                } else if (name.equals(BpmnProblems.SQL_SLOW)) {
                    d = 1.5d;
                } else if (name.equals(BpmnProblems.WS)) {
                    d = 1d;
                } else {
                    d = 0d;
                }
                Map<String, Double> result = new HashMap<String, Double>(1);
                result.put(BpmnGeneticTestRunner.COST, d);
                return result;
            }
        });
        return rule;
    }
}
