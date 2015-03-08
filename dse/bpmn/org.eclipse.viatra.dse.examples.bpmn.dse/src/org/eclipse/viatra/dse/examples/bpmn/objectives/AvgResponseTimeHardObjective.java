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

import java.util.HashMap;

import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.examples.bpmn.simulator.Simulator;
import org.eclipse.viatra.dse.examples.bpmn.simulator.Simulator.ResourceInstanceData;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN;
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
public class AvgResponseTimeHardObjective extends BaseObjective {

    public static final String DEFAULT_NAME = "AvgResponseTime";
    private MinResourceUsageSoftObjective minResourceUsageSoftObjective;

    public AvgResponseTimeHardObjective(MinResourceUsageSoftObjective minResourceUsageSoftObjective) {
        super(DEFAULT_NAME);
        this.minResourceUsageSoftObjective = minResourceUsageSoftObjective;
    }

    public Double getFitness(ThreadContext context) {
        Simulator simulator = new Simulator((SimplifiedBPMN) context.getModelRoot(), 10, 20);
        if (simulator.canSimulate()) {
            simulator.simulate();

            int sumResponseTimes = 0;
            for (Simulator.Token token : simulator.getTokens()) {
                sumResponseTimes += token.endTime - token.startTime;
            }
            double avgResponseTime = ((double) sumResponseTimes) / simulator.getTokens().size();

            HashMap<ResourceTypeVariant, Integer> sumBusyTime = new HashMap<ResourceTypeVariant, Integer>();
            for (ResourceInstanceData resource : simulator.getResourceDatas().values()) {
                ResourceTypeVariant rtv = resource.resource.getResourceTypeVariant();
                Integer sum = sumBusyTime.get(rtv);
                if (sum == null) {
                    sum = new Integer(0);
                }
                sumBusyTime.put(rtv, sum + resource.timeUsed);
            }
            double minUtilization = Double.MAX_VALUE;
            for (ResourceTypeVariant key : sumBusyTime.keySet()) {
                double utilization = sumBusyTime.get(key).doubleValue()
                        / (simulator.getElapsedTime() * key.getInstances().size());
                if (utilization < minUtilization) {
                    minUtilization = utilization;
                }
            }
            minResourceUsageSoftObjective.setFitness(minUtilization);

            return avgResponseTime;
        } else {
            minResourceUsageSoftObjective.setFitness(-1d);
            return Double.POSITIVE_INFINITY;
        }
    }

    @Override
    public void init(ThreadContext context) {
    }

    @Override
    public IObjective createNew() {
        return this;
    }

    @Override
    public boolean isHardObjective() {
        return true;
    }

    @Override
    public boolean satisifiesHardObjective(Double fitness) {
        return fitness < Double.POSITIVE_INFINITY;
    }

}
