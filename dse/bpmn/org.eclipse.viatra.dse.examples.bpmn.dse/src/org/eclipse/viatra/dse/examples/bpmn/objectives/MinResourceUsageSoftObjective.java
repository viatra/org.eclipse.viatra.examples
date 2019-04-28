/*******************************************************************************
 * Copyright (c) 2010-2015, Andras Szabolcs Nagy, Abel Hegedus, Akos Horvath, Zoltan Ujhelyi and Daniel Varro
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.dse.examples.bpmn.objectives;

import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.objectives.Comparators;
import org.eclipse.viatra.dse.objectives.IObjective;
import org.eclipse.viatra.dse.objectives.impl.BaseObjective;

/**
 * This class represents the min. resource usage objective.
 * 
 * @author Andras Szabolcs Nagy
 *
 */
public class MinResourceUsageSoftObjective extends BaseObjective {

    protected static final String DEFAUL_NAME = "MinResourceUsage";
    private RunSimulationOnModel sim;

    public MinResourceUsageSoftObjective() {
        super(DEFAUL_NAME);
        comparator = Comparators.HIGHER_IS_BETTER;
    }

    @Override
    public void init(ThreadContext context) {
        super.init(context);
        sim = RunSimulationOnModel.create(context);
    }

    @Override
    public Double getFitness(ThreadContext context) {
        sim.runSimulation();
        return sim.getMinUtilization();
    }

    @Override
    public IObjective createNew() {
        MinResourceUsageSoftObjective objective = new MinResourceUsageSoftObjective();
        if (isThereFitnessConstraint) {
            objective.withHardConstraintOnFitness(fitnessConstraint, fitnessConstraintComparator);
        }
        return objective.withLevel(level);
    }
}
