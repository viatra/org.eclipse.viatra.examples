/*******************************************************************************
 * Copyright (c) 2010-2015, Andras Szabolcs Nagy, Abel Hegedus, Akos Horvath, Zoltan Ujhelyi and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Andras Szabolcs Nagy - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.dse.examples.bpmn.objectives;

import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.examples.bpmn.simulator.Simulator;
import org.eclipse.viatra.dse.objectives.Comparators;
import org.eclipse.viatra.dse.objectives.IObjective;
import org.eclipse.viatra.dse.objectives.impl.BaseObjective;

/**
 * This objective simulates the BPMN model with the {@link Simulator} class and retrieves the average response time of
 * the system. It also retrieves the minimum of the resource usages and sets it to the given
 * {@link MinResourceUsageSoftObjective} objective.
 * 
 * If the BPMN model cannot be simulated the average response time will infinity and resource usage will be -1. In this
 * case the hard objective won't be satisfied.
 * 
 * @author Andras Szabolcs Nagy
 */
public class AvgResponseTimeSoftObjective extends BaseObjective {

    public static final String DEFAULT_NAME = "AvgResponseTime";
    private RunSimulationOnModel sim;

    public AvgResponseTimeSoftObjective() {
        super(DEFAULT_NAME);
        comparator = Comparators.LOWER_IS_BETTER;
    }

    @Override
    public void init(ThreadContext context) {
        super.init(context);
        sim = RunSimulationOnModel.create(context);
    }

    @Override
    public Double getFitness(ThreadContext context) {
        sim.runSimulation();
        return sim.getAvgResponseTime();
    }

    @Override
    public IObjective createNew() {
        AvgResponseTimeSoftObjective objective = new AvgResponseTimeSoftObjective();
        if (isThereFitnessConstraint) {
            objective.withHardConstraintOnFitness(fitnessConstraint, fitnessConstraintComparator);
        }
        return objective.withLevel(level);
    }
}
