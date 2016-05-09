/*******************************************************************************
 * Copyright (c) 2014, 2016, IncQuery Labs Ltd. 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Akos Horvath, Abel Hegedus, Tamas Borbas, Marton Bur, Zoltan Ujhelyi, Robert Doczi, Daniel Segesdi, Peter Lunk - initial API and implementation
 *******************************************************************************/

package org.eclipse.viatra.examples.cps.xform.m2m.tests.mappings

import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.State
import org.eclipse.viatra.examples.cps.deployment.DeploymentBehavior
import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment
import org.eclipse.viatra.examples.cps.xform.m2m.tests.CPS2DepTest
import org.eclipse.viatra.examples.cps.xform.m2m.tests.wrappers.CPSTransformationWrapper
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

import static org.junit.Assert.*
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.StateMachine

@RunWith(Parameterized)
class StateMappingTest extends CPS2DepTest {
	
	new(CPSTransformationWrapper wrapper, String wrapperType) {
		super(wrapper,wrapperType)
	}
	
	@Test
	def singleState() {
		val testId = "singleState"
		startTest(testId)
		
		val cps2dep = prepareEmptyModel(testId)
		val hostInstance = cps2dep.prepareHostInstance
		val appInstance = cps2dep.prepareAppInstance(hostInstance)
		val sm = prepareStateMachine(appInstance.type, "simple.cps.sm")
		val state = sm.prepareState("simple.cps.sm.s1")
				
		cps2dep.initializeTransformation
		executeTransformation

		cps2dep.assertStateMapping(state)
		
		endTest(testId)
	}
	
	def assertStateMapping(CPSToDeployment cps2dep, State state) {
		val behavior = cps2dep.deployment.hosts.head.applications.head.behavior
		assertFalse("State not transformed", behavior.states.empty)
		val depState = behavior.states.head
		val trace = cps2dep.traces.findFirst[cpsElements.contains(state)]
		assertNotNull("Trace not created", trace)
		assertEquals("Trace is not complete (cpsElements)", #[state], trace.cpsElements)
		assertEquals("Trace is not complete (depElements)", #[depState], trace.deploymentElements)
		assertEquals("ID not copied", state.identifier, depState.description)
	}
	
	@Test
	def stateIncremental() {
		val testId = "stateIncremental"
		startTest(testId)
		
		val cps2dep = prepareEmptyModel(testId)
		val hostInstance = cps2dep.prepareHostInstance
		val appInstance = cps2dep.prepareAppInstance(hostInstance)
		val sm = prepareStateMachine(appInstance.type, "simple.cps.sm")
				
		cps2dep.initializeTransformation
		executeTransformation

		val state = sm.prepareState("simple.cps.sm.s1")
		executeTransformation
		
		cps2dep.assertStateMapping(state)
		
		endTest(testId)
	}
	
	@Test
	def initialState() {
		val testId = "initialState"
		startTest(testId)
		
		val cps2dep = prepareEmptyModel(testId)
		val hostInstance = cps2dep.prepareHostInstance
		val appInstance = cps2dep.prepareAppInstance(hostInstance)
		val sm = prepareStateMachine(appInstance.type, "simple.cps.sm")
		val state = sm.prepareState("simple.cps.sm.s1")
		sm.initial = state
				
		cps2dep.initializeTransformation
		executeTransformation

		val behavior = cps2dep.deployment.hosts.head.applications.head.behavior
		val trace = cps2dep.traces.findFirst[cpsElements.contains(state)]
		assertNotNull("Trace is not created", trace)
		assertEquals("Initial property not transformed", trace.deploymentElements.head, behavior.current)
		
		endTest(testId)
	}
		
	@Test
	def changeInitialState() {
		val testId = "changeInitialState"
		startTest(testId)
		
		val cps2dep = prepareEmptyModel(testId)
		val hostInstance = cps2dep.prepareHostInstance
		val appInstance = cps2dep.prepareAppInstance(hostInstance)
		val sm = prepareStateMachine(appInstance.type, "simple.cps.sm")
		val state = sm.prepareState("simple.cps.sm.s1")
		sm.initial = state
				
		cps2dep.initializeTransformation
		executeTransformation

		val state2 = sm.prepareState("simple.cps.sm.s2")
		sm.initial = state2
		executeTransformation

		val behavior = cps2dep.deployment.hosts.head.applications.head.behavior
		val trace = cps2dep.traces.findFirst[cpsElements.contains(state2)]
		assertNotNull("Trace is not created", trace)
		assertEquals("Initial property not changed", trace.deploymentElements.head, behavior.current)
		
		endTest(testId)
	}
	
	@Test
	def changeStateId() {
		val testId = "changeStateId"
		startTest(testId)
		
		val cps2dep = prepareEmptyModel(testId)
		val hostInstance = cps2dep.prepareHostInstance
		val appInstance = cps2dep.prepareAppInstance(hostInstance)
		val sm = prepareStateMachine(appInstance.type, "simple.cps.sm")
		val state = sm.prepareState("simple.cps.sm.s1")
				
		cps2dep.initializeTransformation
		executeTransformation

		info("Changing state  ID.")
		state.identifier = "simple.cps.sm.s2"
		executeTransformation
		
		val behavior = cps2dep.deployment.hosts.head.applications.head.behavior
		val depState = behavior.states.head
		assertNotNull("State not transformed", depState)
		assertEquals("Id not changed in deployment", state.identifier, depState.description)
		
		endTest(testId)
	}
	
	@Test
	def removeState() {
		val testId = "removeState"
		startTest(testId)
		
		val cps2dep = prepareEmptyModel(testId)
		val hostInstance = cps2dep.prepareHostInstance
		val appInstance = cps2dep.prepareAppInstance(hostInstance)
		val sm = prepareStateMachine(appInstance.type, "simple.cps.sm")
		val state = sm.prepareState("simple.cps.sm.s1")
				
		cps2dep.initializeTransformation
		executeTransformation

		cps2dep.assertStateMapping(state)
		
		sm.states -= state
		executeTransformation
		
		val behavior = cps2dep.deployment.hosts.head.applications.head.behavior
		assertTrue("State not removed", behavior.states.empty)
		val trace = cps2dep.traces.findFirst[cpsElements.contains(state)]
		assertNull("Trace not removed", trace)
		
		endTest(testId)
	}
	
	@Test
	def removeInitialState() {
		val testId = "removeInitialState"
		startTest(testId)
		
		val cps2dep = prepareEmptyModel(testId)
		val hostInstance = cps2dep.prepareHostInstance
		val appInstance = cps2dep.prepareAppInstance(hostInstance)
		val sm = prepareStateMachine(appInstance.type, "simple.cps.sm")
		val state = sm.prepareState("simple.cps.sm.s1")
		sm.initial = state
				
		cps2dep.initializeTransformation
		executeTransformation

		cps2dep.assertStateMapping(state)

		sm.states -= state
		executeTransformation
		
		val behavior = cps2dep.deployment.hosts.head.applications.head.behavior
		assertNull("Current state not removed", behavior.current)
		
		endTest(testId)
	}
	
	@Test
	def removeStateMachineOfState() {
		val testId = "removeStateMachineOfState"
		startTest(testId)
		
		val cps2dep = prepareEmptyModel(testId)
		val hostInstance = cps2dep.prepareHostInstance
		val appInstance = cps2dep.prepareAppInstance(hostInstance)
		val sm = prepareStateMachine(appInstance.type, "simple.cps.sm")
		val state = sm.prepareState("simple.cps.sm.s1")
				
		cps2dep.initializeTransformation
		executeTransformation

		cps2dep.assertStateMapping(state)

		info("Removing state machine from app type.")
		appInstance.type.behavior = null
		executeTransformation
		
		val trace = cps2dep.traces.findFirst[cpsElements.contains(state)]
		assertNull("Trace not removed", trace)
		
		endTest(testId)
	}
	
	@Test
	def addApplicationInstanceOfState() {
		val testId = "addApplicationInstanceOfState"
		startTest(testId)
		
		val cps2dep = prepareEmptyModel(testId)
		val hostInstance = cps2dep.prepareHostInstance
		val appInstance = cps2dep.prepareAppInstance(hostInstance)
		val sm = prepareStateMachine(appInstance.type, "simple.cps.sm")
		val state = sm.prepareState("simple.cps.sm.s1")
				
		cps2dep.initializeTransformation
		executeTransformation

		prepareApplicationInstanceWithId(appInstance.type, "simple.cps.app.inst2", hostInstance)
		executeTransformation
		
		val applications = cps2dep.deployment.hosts.head.applications
		applications.forEach[
			assertNotNull("State not created in deployment", it.behavior.states.head)
		]
		val traces = cps2dep.traces.filter[cpsElements.contains(state)]
		assertEquals("Incorrect number of traces created", 1, traces.size)
		assertEquals("Trace is not complete (depElements)", 2, traces.head.deploymentElements.size)
		
		endTest(testId)
	}
	
	@Test
	def deleteApplicationInstanceOfState() {
		val testId = "deleteApplicationInstanceOfState"
		startTest(testId)
		
		val cps2dep = prepareEmptyModel(testId)
		val hostInstance = cps2dep.prepareHostInstance
		val appInstance = cps2dep.prepareAppInstance(hostInstance)
		val sm = prepareStateMachine(appInstance.type, "simple.cps.sm")
		val state = sm.prepareState("simple.cps.sm.s1")
				
		cps2dep.initializeTransformation
		executeTransformation
		
		cps2dep.assertStateMapping(state)

		info("Removing instance from type")
		appInstance.type.instances -= appInstance
		executeTransformation
		
		val traces = cps2dep.traces.filter[cpsElements.contains(state)]
		assertTrue("Trace not removed", traces.empty)

		endTest(testId)
	}
	
	@Test
	def moveStateMachineOfState() {
		val testId = "moveStateMachine"
		startTest(testId)
		
		val cps2dep = prepareEmptyModel(testId)
		val hostInstance = cps2dep.prepareHostInstance
		val appInstance = cps2dep.prepareAppInstance(hostInstance)
		val appType2 = cps2dep.prepareApplicationTypeWithId("simple.cps.app2")
		appType2.prepareApplicationInstanceWithId("simple.cps.app2.instance", hostInstance)
		
		val sm = prepareStateMachine(appInstance.type, "simple.cps.sm")
		val state = sm.prepareState("simple.cps.sm.s1")
				
		cps2dep.initializeTransformation
		executeTransformation

		info("Moving state machine")
		appType2.behavior = sm
		executeTransformation
		
		val traces = cps2dep.traces.filter[cpsElements.contains(state)]
		assertFalse("Trace for state does not exist", traces.empty)
		val depState = traces.head.deploymentElements.head
		val behaviorTraces = cps2dep.traces.filter[deploymentElements.filter(typeof(DeploymentBehavior)).exists[states.contains(depState)]]
		assertFalse("State not moved", behaviorTraces.empty)
		
		endTest(testId)
	}
	
	@Test
	def moveApplicationInstanceOfState() {
		val testId = "moveApplicationInstance"
		startTest(testId)
		
		val cps2dep = prepareEmptyModel(testId)
		val hostInstance = cps2dep.prepareHostInstance
		val appInstance = cps2dep.prepareAppInstance(hostInstance)
		val sm = prepareStateMachine(appInstance.type, "simple.cps.sm")
		val state = sm.prepareState("simple.cps.sm1.s")
		
		val appType2 = cps2dep.prepareApplicationTypeWithId("simple.cps.app2")
		val sm2 = prepareStateMachine(appType2, "simple.cps.sm2")
		val state2 = sm2.prepareState("simple.cps.sm2.s")
				
		cps2dep.initializeTransformation
		executeTransformation

		info("Moving application instance")
		appInstance.type = appType2
		executeTransformation
		
		val stateTraces = cps2dep.traces.filter[cpsElements.contains(state)]
		assertTrue("State not moved", stateTraces.empty)
		val state2Traces = cps2dep.traces.filter[cpsElements.contains(state2)]
		assertFalse("State not moved", state2Traces.empty)
		val depState = state2Traces.head.deploymentElements.head
		val behaviorTraces = cps2dep.traces.filter[
			deploymentElements.filter(typeof(DeploymentBehavior)).exists[states.contains(depState)]
		]
		assertFalse("State not in app", behaviorTraces.empty)
		
		endTest(testId)
	}
	
	@Test
	def removeHostInstanceOfState() {
		val testId = "removeHostInstanceOfState"
		startTest(testId)
		
		val cps2dep = prepareEmptyModel(testId)
		val hostInstance = cps2dep.prepareHostInstance
		val appInstance = cps2dep.prepareAppInstance(hostInstance)
		val sm = prepareStateMachine(appInstance.type, "simple.cps.sm")
		val state = sm.prepareState("simple.cps.sm.s1")
				
		cps2dep.initializeTransformation
		executeTransformation
		
		cps2dep.assertStateMapping(state)

		info("Deleting host instance")
		cps2dep.cps.hostTypes.head.instances -= hostInstance
		executeTransformation
		
		val traces = cps2dep.traces.filter[cpsElements.contains(state)]
		assertTrue("Traces not removed", traces.empty)
		
		endTest(testId)
	}	
	
	@Test
	def initialStatesMultipleAppInstance() {
		val testId = "initialStatesMultipleAppInstance"
		startTest(testId)

		
		val cps2dep = prepareEmptyModel(testId)
		val hostInstance = cps2dep.prepareHostInstance

		val appType = cps2dep.prepareApplicationTypeWithId("simple.cps.app2")

		appType.prepareApplicationInstanceWithId("simple.cps.app.instance1",hostInstance)
		appType.prepareApplicationInstanceWithId("simple.cps.app.instance2",hostInstance)
		
		val sm = prepareStateMachine(appType, "simple.cps.sm")
		val state = sm.prepareState("simple.cps.sm1.s")
		sm.initial = state
			
		cps2dep.initializeTransformation
		executeTransformation
		
		info("Adding new application instance")
		appType.prepareApplicationInstanceWithId("simple.cps.app.instance3",hostInstance)
	
		executeTransformation
		
		val deploymentBehaviorTraces = cps2dep.traces.filter[it.cpsElements.head instanceof StateMachine]
		val behaviorDescriptions = deploymentBehaviorTraces.head.deploymentElements
		
		val current1 = (behaviorDescriptions.get(0) as DeploymentBehavior).current
		val current2 = (behaviorDescriptions.get(1) as DeploymentBehavior).current
		val current3 = (behaviorDescriptions.get(2) as DeploymentBehavior).current
		
		assertNotEquals(current1,current2)
		assertNotEquals(current1,current3)
		assertNotEquals(current2,current3)
		
		endTest(testId)
	}
}