/*******************************************************************************
 * Copyright (c) 2010-2015, Andras Szabolcs Nagy and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Andras Szabolcs Nagy - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.dse.examples.bpmn.objectives;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.dse.base.DesignSpaceManager;
import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.designspace.api.IState;
import org.eclipse.viatra.dse.examples.bpmn.simulator.Simulator;
import org.eclipse.viatra.dse.examples.bpmn.simulator.Simulator.ResourceInstanceData;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN;

/**
 * This objective simulates the BPMN model with the {@link Simulator} class and retrieves the average response time of
 * the system and the min resource usage.
 * 
 * If the BPMN model cannot be simulated the average response time will infinity and resource usage will be -1. In this
 * case the hard objective won't be satisfied.
 * 
 * @author Andras Szabolcs Nagy
 */
public class RunSimulationOnModel {

    private static Map<Notifier, RunSimulationOnModel> sims = new HashMap<Notifier, RunSimulationOnModel>();
    
    public static synchronized RunSimulationOnModel create(ThreadContext context) {
        EObject modelRoot = context.getModelRoot();
        RunSimulationOnModel sim = sims.get(modelRoot);
        if (sim == null) {
            sim = new RunSimulationOnModel();
            sim.init(context);
            sims.put(modelRoot, sim);
        }
        return sim;
    }

    private double minUtilization;
    private double avgResponseTime;
    private SimplifiedBPMN modelRoot;
    private IState lastState = null;
    private DesignSpaceManager dsm;

    private RunSimulationOnModel() {}
    
    private void init(ThreadContext context) {
        modelRoot = (SimplifiedBPMN) context.getModelRoot();
        dsm = context.getDesignSpaceManager();
    }
    
    public void runSimulation() {
        if (dsm.getCurrentState().getId().equals(lastState)) {
            return;
        }
        
        Simulator simulator = new Simulator(modelRoot, 100, 20);
        if (simulator.canSimulate()) {
            simulator.simulate();

            // avg response time
            int sumResponseTimes = 0;
            for (Simulator.Token token : simulator.getTokens()) {
                sumResponseTimes += token.endTime - token.startTime;
            }
            avgResponseTime = ((double) sumResponseTimes) / simulator.getTokens().size();

            // min resource usage
            HashMap<ResourceTypeVariant, Integer> sumBusyTime = new HashMap<ResourceTypeVariant, Integer>();
            for (ResourceInstanceData resource : simulator.getResourceDatas().values()) {
                ResourceTypeVariant rtv = resource.resource.getResourceTypeVariant();
                Integer sum = sumBusyTime.get(rtv);
                if (sum == null) {
                    sum = new Integer(0);
                }
                sumBusyTime.put(rtv, sum + resource.timeUsed);
            }
            minUtilization = Double.MAX_VALUE;
            for (ResourceTypeVariant key : sumBusyTime.keySet()) {
                double utilization = sumBusyTime.get(key).doubleValue()
                        / (simulator.getElapsedTime() * key.getInstances().size());
                if (utilization < minUtilization) {
                    minUtilization = utilization;
                }
            }

        } else {
            minUtilization = -1d;
            avgResponseTime =  Double.POSITIVE_INFINITY;
        }
    }
    
    public double getAvgResponseTime() {
        return avgResponseTime;
    }
    
    public double getMinUtilization() {
        return minUtilization;
    }
}
