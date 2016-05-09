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

import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.StateMachine
import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication
import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment
import org.eclipse.viatra.examples.cps.xform.m2m.tests.CPS2DepTest
import org.eclipse.viatra.examples.cps.xform.m2m.tests.wrappers.CPSTransformationWrapper
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

import static org.junit.Assert.*

@RunWith(Parameterized)
class StateMachineMappingTest extends CPS2DepTest {
	
	new(CPSTransformationWrapper wrapper, String wrapperType) {
		super(wrapper,wrapperType)
	}
	
	@Test
	def singleStateMachine() {
		val testId = "singleStateMachine"
		startTest(testId)
		
		val cps2dep = prepareEmptyModel(testId)
		val hostInstance = cps2dep.prepareHostInstance
		val appInstance = cps2dep.prepareAppInstance(hostInstance)
		val sm = prepareStateMachine(appInstance.type, "simple.cps.sm")
		
		cps2dep.initializeTransformation
		executeTransformation

		cps2dep.assertStateMachineMapping(sm)
		
		endTest(testId)
	}
	
	def assertStateMachineMapping(CPSToDeployment cps2dep, StateMachine sm) {
		val application = cps2dep.deployment.hosts.head.applications.head
		assertNotNull("State machine not transformed", application.behavior)
		val behavior = application.behavior
		val trace = cps2dep.traces.findFirst[cpsElements.contains(sm)]
		assertNotNull("Trace not created", trace)
		assertEquals("Trace is not complete (cpsElements)", #[sm], trace.cpsElements)
		assertEquals("Trace is not complete (depElements)", #[behavior], trace.deploymentElements)
		assertEquals("ID not copied", sm.identifier, behavior.description)
	}
	
	@Test
	def stateMachineIncremental() {
		val testId = "stateMachineIncremental"
		startTest(testId)
		
		val cps2dep = prepareEmptyModel(testId)
		val hostInstance = cps2dep.prepareHostInstance
		val appInstance = cps2dep.prepareAppInstance(hostInstance)
				
		cps2dep.initializeTransformation
		executeTransformation

		val sm = prepareStateMachine(appInstance.type, "simple.cps.sm")
		executeTransformation
		
		cps2dep.assertStateMachineMapping(sm)
		
		endTest(testId)
	}
	
	@Test
	def removeStateMachine() {
		val testId = "removeStateMachine"
		startTest(testId)
		
		val cps2dep = prepareEmptyModel(testId)
		val hostInstance = cps2dep.prepareHostInstance
		val appInstance = cps2dep.prepareAppInstance(hostInstance)
		val sm = prepareStateMachine(appInstance.type, "simple.cps.sm")
				
		cps2dep.initializeTransformation
		executeTransformation

		cps2dep.assertStateMachineMapping(sm)
		
		info("Removing state machine from app type.")
		appInstance.type.behavior = null
		executeTransformation
		
		val application = cps2dep.deployment.hosts.head.applications.head
		assertNull("Behavior not removed from deployment", application.behavior)
		val trace = cps2dep.traces.findFirst[cpsElements.contains(sm)]
		assertNull("Trace not removed", trace)
		
		endTest(testId)
	}
	
	@Test
	def changeStateMachineId() {
		val testId = "changeStateMachineId"
		startTest(testId)
		
		val cps2dep = prepareEmptyModel(testId)
		val hostInstance = cps2dep.prepareHostInstance
		val appInstance = cps2dep.prepareAppInstance(hostInstance)
		val sm = prepareStateMachine(appInstance.type, "simple.cps.sm")
		
		cps2dep.initializeTransformation
		executeTransformation

		info("Changing state machine ID.")
		sm.identifier = "simple.cps.sm2"
		executeTransformation
		
		val application = cps2dep.deployment.hosts.head.applications.head
		assertEquals("Id not changed in deployment", sm.identifier, application.behavior.description)
		
		endTest(testId)
	}
	
	@Test
	def addApplicationInstance() {
		val testId = "addApplicationInstance"
		startTest(testId)
		
		val cps2dep = prepareEmptyModel(testId)
		val hostInstance = cps2dep.prepareHostInstance
		val appInstance = cps2dep.prepareAppInstance(hostInstance)
		val sm = prepareStateMachine(appInstance.type, "simple.cps.sm")
		
		cps2dep.initializeTransformation
		executeTransformation

		prepareApplicationInstanceWithId(appInstance.type, "simple.cps.app.inst2", hostInstance)
		executeTransformation
		
		val applications = cps2dep.deployment.hosts.head.applications
		applications.forEach[
			assertNotNull("State machine not created in deployment", it.behavior)
		]
		val traces = cps2dep.traces.filter[cpsElements.contains(sm)]
		assertEquals("Incorrect number of traces created", 1, traces.size)
		assertEquals("Trace is not complete (depElements)", 2, traces.head.deploymentElements.size)
		
		endTest(testId)
	}
	
	@Test
	def removeApplicationInstance() {
		val testId = "removeApplicationInstance"
		startTest(testId)
		
		val cps2dep = prepareEmptyModel(testId)
		val hostInstance = cps2dep.prepareHostInstance
		val appInstance = cps2dep.prepareAppInstance(hostInstance)
		val sm = prepareStateMachine(appInstance.type, "simple.cps.sm")
				
		cps2dep.initializeTransformation
		executeTransformation

		cps2dep.assertStateMachineMapping(sm)
		
		info("Removing instance from type")
		appInstance.type.instances -= appInstance
		executeTransformation
		
		val traces = cps2dep.traces.filter[cpsElements.contains(sm)]
		assertTrue("Trace not removed", traces.empty)

		endTest(testId)
	}
	
	@Test
	def moveStateMachine() {
		val testId = "moveStateMachine"
		startTest(testId)
		
		val cps2dep = prepareEmptyModel(testId)
		val hostInstance = cps2dep.prepareHostInstance
		val appInstance = cps2dep.prepareAppInstance(hostInstance)
		val appType2 = cps2dep.prepareApplicationTypeWithId("simple.cps.app2")
		appType2.prepareApplicationInstanceWithId("simple.cps.app2.instance", hostInstance)
		val sm = prepareStateMachine(appInstance.type, "simple.cps.sm")
				
		cps2dep.initializeTransformation
		executeTransformation

		info("Moving state machine")
		appType2.behavior = sm
		executeTransformation
		
		val traces = cps2dep.traces.filter[cpsElements.contains(sm)]
		assertFalse("Trace for state machine does not exist", traces.empty)
		val depBehavior = traces.head.deploymentElements.head
		val appTraces = cps2dep.traces.filter[deploymentElements.filter(typeof(DeploymentApplication)).exists[behavior == depBehavior]]
		assertFalse("State machine not moved", appTraces.empty)
		
		endTest(testId)
	}
	
	@Test
	def moveApplicationInstance() {
		val testId = "moveApplicationInstance"
		startTest(testId)
		
		val cps2dep = prepareEmptyModel(testId)
		val hostInstance = cps2dep.prepareHostInstance
		val appInstance = cps2dep.prepareAppInstance(hostInstance)
		val sm = prepareStateMachine(appInstance.type, "simple.cps.sm")
		val appType2 = cps2dep.prepareApplicationTypeWithId("simple.cps.app2")
		val sm2 = prepareStateMachine(appType2, "simple.cps.sm2")
				
		cps2dep.initializeTransformation
		executeTransformation

		info("Moving application instance")
		appInstance.type = appType2
		executeTransformation
		
		val smTraces = cps2dep.traces.filter[cpsElements.contains(sm)]
		assertTrue("Behavior not moved", smTraces.empty)
		val sm2Traces = cps2dep.traces.filter[cpsElements.contains(sm2)]
		assertFalse("Behavior not moved", sm2Traces.empty)
		val depBehavior = sm2Traces.head.deploymentElements.head
		val appTraces = cps2dep.traces.filter[deploymentElements.filter(typeof(DeploymentApplication)).exists[behavior == depBehavior]]
		assertFalse("Behavior not in app", appTraces.empty)
		
		endTest(testId)
	}
	
	@Test
	def removeHostInstanceOfBehavior() {
		val testId = "removeHostInstanceOfBehavior"
		startTest(testId)
		
		val cps2dep = prepareEmptyModel(testId)
		val hostInstance = cps2dep.prepareHostInstance
		val appInstance = cps2dep.prepareAppInstance(hostInstance)
		val sm = prepareStateMachine(appInstance.type, "simple.cps.sm")
				
		cps2dep.initializeTransformation
		executeTransformation
	
		cps2dep.assertStateMachineMapping(sm)
		
		info("Deleting host instance")
		cps2dep.cps.hostTypes.head.instances -= hostInstance
		executeTransformation
		
		val traces = cps2dep.traces.filter[cpsElements.contains(sm)]
		assertTrue("Traces not removed", traces.empty)
		
		endTest(testId)
	}
}