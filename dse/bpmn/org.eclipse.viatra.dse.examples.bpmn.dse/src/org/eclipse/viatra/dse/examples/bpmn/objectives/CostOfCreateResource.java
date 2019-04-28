/*******************************************************************************
 * Copyright (c) 2010-2015, Andras Szabolcs Nagy, Abel Hegedus, Akos Horvath, Zoltan Ujhelyi and Daniel Varro
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.dse.examples.bpmn.objectives;

import org.eclipse.viatra.dse.examples.bpmn.patterns.CreateResource;
import org.eclipse.viatra.dse.examples.bpmn.problems.BpmnProblems;
import org.eclipse.viatra.dse.objectives.ActivationFitnessProcessor;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;

/**
 * Costs of the different resource instances.
 */
public final class CostOfCreateResource implements ActivationFitnessProcessor {
    @Override
    public double process(IPatternMatch match) {
        CreateResource.Match m = (CreateResource.Match) match;
        String name = m.getRTV().getName();
        Double result;
        if (name.equals(BpmnProblems.NOSQL_FAST)) {
            result = 5d;
        } else if (name.equals(BpmnProblems.NOSQL_MEDIUM)) {
            result = 3d;
        } else if (name.equals(BpmnProblems.NOSQL_SLOW)) {
            result = 1.5d;
        } else if (name.equals(BpmnProblems.SQL_FAST)) {
            result = 5d;
        } else if (name.equals(BpmnProblems.SQL_MEDIUM)) {
            result = 3d;
        } else if (name.equals(BpmnProblems.SQL_SLOW)) {
            result = 1.5d;
        } else if (name.equals(BpmnProblems.WS)) {
            result = 1d;
        } else
            result = 0d;
        return result;
    }
}