/*******************************************************************************
 * Copyright (c) 2014, 2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Marton Bur, Zoltan Ujhelyi, Zsolt Kovari - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.m2t.proto.distributed.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.HostRunner;
import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.applications.Application;
import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.applications.statemachines.State;
import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.communicationlayer.CommunicationNetwork;
import org.eclipse.viatra.examples.cps.m2t.proto.distributed.generated.hosts.Host152661025;
import org.eclipse.viatra.examples.cps.m2t.proto.distributed.generated.hosts.Host152661026;
import org.eclipse.viatra.examples.cps.m2t.proto.distributed.generated.hosts.statemachines.BehaviorCameraB;
import org.eclipse.viatra.examples.cps.tests.CPSTestBase;
import org.junit.Test;

import com.google.common.collect.Iterables;

public class IntegrationTest extends CPSTestBase {
	
	@Test
	public void sendTriggerTest(){
		
		CommunicationNetwork network = new CommunicationNetwork();
		
		// Create Hosts
		Host152661025 hostStorage = new Host152661025(network);
		Host152661026 hostSenders = new Host152661026(network);
		
		// Create HostRunners
		HostRunner hostRunnerStorage = new HostRunner(hostStorage);
		HostRunner hostRunnerSenders = new HostRunner(hostSenders);
		
		// Add hosts to network
		network.addHost("152.66.102.5", hostRunnerStorage);
		network.addHost("152.66.102.6", hostRunnerSenders);
		
		assertTrue(Iterables.isEmpty(hostStorage.calculatePossibleNextStates()));
		
		Application appCamera = hostSenders.getApplications().iterator().next();
		appCamera.stepToState(BehaviorCameraB.CSent);
		
		assertTrue(!Iterables.isEmpty(hostStorage.calculatePossibleNextStates()));
		
	}
	
	@Test
	public void stepSenderAndNeutralStateTest(){
		CommunicationNetwork network = new CommunicationNetwork();
		Host152661026 hostSenders = new Host152661026(network);
		
		Application appCamera = hostSenders.getApplications().iterator().next();
		
		State<?> currentState = appCamera.getCurrentState();
		
		// SendStep
		assertEquals(BehaviorCameraB.CInit, currentState);
		
		appCamera.stepToState(BehaviorCameraB.CSent);
		
		assertTrue(appCamera.getCurrentState() != currentState);
		
		assertEquals(BehaviorCameraB.CSent, appCamera.getCurrentState());
		
		// Neutral step
		appCamera.stepToState(BehaviorCameraB.CInit);
		
		assertTrue(appCamera.getCurrentState() != BehaviorCameraB.CSent);
		
		assertEquals(BehaviorCameraB.CInit, appCamera.getCurrentState());
	}
	
	@Test
	public void threadTest() throws InterruptedException{
		
		CommunicationNetwork network = new CommunicationNetwork();
		
		// Create Hosts
		Host152661025 hostStorage = new Host152661025(network);
		Host152661026 hostSenders = new Host152661026(network);
		
		// Create HostRunners
		HostRunner hostRunnerStorage = new HostRunner(hostStorage);
		HostRunner hostRunnerSenders = new HostRunner(hostSenders);
		
		// Add hosts to network
		network.addHost("152.66.102.5", hostRunnerStorage);
		network.addHost("152.66.102.6", hostRunnerSenders);
		
		(new Thread(hostRunnerStorage)).start();
		(new Thread(hostRunnerSenders)).start();
		
		Thread.sleep(15000);
	}
	
}
