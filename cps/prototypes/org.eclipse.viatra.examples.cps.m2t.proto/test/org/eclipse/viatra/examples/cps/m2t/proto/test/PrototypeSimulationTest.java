/*******************************************************************************
 * Copyright (c) 2014, 2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Marton Bur, Zoltan Ujhelyi - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.m2t.proto.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.viatra.examples.cps.m2t.proto.elements.Application;
import org.eclipse.viatra.examples.cps.m2t.proto.simulation.Simulator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PrototypeSimulationTest {

	Simulator simulator;
	private List<Application> applications;
	private Application ibmSystemStorage;
	private Application cameraApp;
	private Application alarmApp;
	private Application smokeDetectorApp;
	
	@Parameters(name = "Simulation steps: {0}")
    public static Collection<Object[]> data() {
    	//formatter:off
        return Arrays.asList(new Object[][] {     
               { 0, new int[]{0,0,0,0} }
             , { 1, new int[]{0,0,0,0} }
             , { 2, new int[]{1,1,0,0} }
             , { 3, new int[]{1,1,0,0} }
             , { 5, new int[]{0,1,0,0} }
             , { 7, new int[]{1,0,1,0} }
             , { 8, new int[]{1,0,1,0} }
             , { 9, new int[]{0,0,1,0} }
             , { 10, new int[]{1,1,1,0} }
             , { 12, new int[]{1,1,0,0} }
             , { 13, new int[]{0,1,0,0} }
        });
        //formatter:on
    }

    @Parameter
    public int stepCount;

    @Parameter(value = 1)
    public int[] stateIndices;
	
	@Before
	public void init(){
		simulator = new Simulator();
		simulator.initDeployment();
		applications = simulator.getApplications();
		ibmSystemStorage = applications.get(0);
		cameraApp = applications.get(1);
		alarmApp = applications.get(2);
		smokeDetectorApp = applications.get(3);
	}
	
	@Test
	public void do_1_step() {
		doSteps(stepCount);
		
		assertStateIndices(stateIndices);
	}
	
	private void doSteps(int k) {
		for (int i = 0; i < k; i++) {			
			simulator.stepSimulation();
		}
	}

	private void assertStateIndices(int[] stateNos) {
		int issStateNo = stateNos[0];
		int cameraStateNo = stateNos[1]; 
		int alarmStateNo = stateNos[2];
		int smokeDetectorStateNo = stateNos[3];
		
		assertEquals(ibmSystemStorage.getCurrentState(), ibmSystemStorage.getStates().get(issStateNo));
		assertEquals(cameraApp.getCurrentState(), cameraApp.getStates().get(cameraStateNo));
		assertEquals(alarmApp.getCurrentState(), alarmApp.getStates().get(alarmStateNo));
		assertEquals(smokeDetectorApp.getCurrentState(), smokeDetectorApp.getStates().get(smokeDetectorStateNo));
	}

}
