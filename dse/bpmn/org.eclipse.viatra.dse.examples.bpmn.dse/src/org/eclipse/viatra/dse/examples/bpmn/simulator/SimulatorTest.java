/*******************************************************************************
 * Copyright (c) 2010-2015, Andras Szabolcs Nagy, Abel Hegedus, Akos Horvath, Zoltan Ujhelyi and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Andras Szabolcs Nagy - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.dse.examples.bpmn.simulator;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.viatra.dse.examples.bpmn.problems.BpmnProblems;
import org.junit.Test;

public class SimulatorTest {

    @Test
    public void test() {
        
        BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.ERROR);
        Logger.getLogger(Simulator.class.getSimpleName()).setLevel(Level.DEBUG);
        
        Simulator simulator = new Simulator(BpmnProblems.createWebShopProblem(true, true), 100, 10);
        simulator.simulate();
        
    }
    
}
