/*******************************************************************************
 * Copyright (c) 2014, 2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Akos Menyhert, Tamas Borbas, Marton Bur, Zoltan Ujhelyi - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2t.tests.util

//import org.apache.log4j.Logger

import org.apache.log4j.Logger
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.viatra.examples.cps.deployment.Deployment
import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication
import org.eclipse.viatra.examples.cps.deployment.DeploymentBehavior
import org.eclipse.viatra.examples.cps.deployment.DeploymentElement
import org.eclipse.viatra.examples.cps.deployment.DeploymentFactory
import org.eclipse.viatra.examples.cps.deployment.DeploymentHost
import org.eclipse.viatra.examples.cps.xform.m2t.monitor.DeploymentChangeMonitor
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine
import org.eclipse.viatra.query.runtime.emf.EMFScope
import org.junit.After
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

import static org.junit.Assert.*
import org.eclipse.viatra.examples.cps.xform.m2t.monitor.AbstractDeploymentChangeMonitor

/**
 * Test cases for the DeploymentChangeMonitor. The cases should cover every rule defined for tracing
 * model changes at least once.
 */
class DeploymentChangeMonitorTest {

	Deployment deployment
	AdvancedViatraQueryEngine engine
	AbstractDeploymentChangeMonitor monitor
	extension Logger logger = Logger.getLogger("cps.DeploymentChangeMonitor")

	static String ELEMENT_MISSING = "Element not found in the deltas"
	static String INCORRECT_NUMBER_OF_DELTAS = "Incorrect number of deltas!"

	@Before
	def void setupModel() {

		deployment = DeploymentFactory.eINSTANCE.createDeployment

		val host1 = prepareHost("host1", "1.1.1.1", deployment)
		val application1 = prepareApplication("description_app1", "app1", host1)
		val behavior1 = prepareDefaultBehavior(application1)

		val host2 = prepareHost("host2", "1.1.1.2", deployment)
		val application2 = prepareApplication("description_app2", "app2", host2)
		val copier = new EcoreUtil.Copier
		val behavior2 = copier.copy(behavior1) as DeploymentBehavior
		application2.behavior = behavior2

		behavior1.transitions.head.trigger += behavior2.transitions.head

		info("Prepared model for testing deployment change monitor")

		engine = AdvancedViatraQueryEngine.createUnmanagedEngine(new EMFScope(deployment))
		info("Created unmanaged IncQuery engine")
 
		monitor = new DeploymentChangeMonitor(deployment,engine)
		info("Created deployment change monitor")
	}

	@After
	def void tearDownEngine() {
		engine.dispose
		info("IncQuery engine disposed")
	}

	def prepareDefaultBehavior(DeploymentApplication application) {
		val behavior = DeploymentFactory.eINSTANCE.createDeploymentBehavior
		application.behavior = behavior
		val state1 = DeploymentFactory.eINSTANCE.createBehaviorState
		val state2 = DeploymentFactory.eINSTANCE.createBehaviorState
		behavior.current = state1
		behavior.states += #[state1, state2]
		val transition = DeploymentFactory.eINSTANCE.createBehaviorTransition
		behavior.transitions += transition
		state1.outgoing += transition
		transition.to = state2
		return behavior
	}

	def prepareApplication(String description, String id, DeploymentHost host) {
		val app = DeploymentFactory.eINSTANCE.createDeploymentApplication
		app.description = description
		app.id = id
		host.applications += app
		return app
	}

	def prepareHost(String description, String ip, Deployment deployment) {
		val host = DeploymentFactory.eINSTANCE.createDeploymentHost
		host.description = description
		host.ip = ip
		deployment.hosts += host
		return host
	}

	private def void assertContainments(DeploymentElement appeared, DeploymentElement updated,
		DeploymentElement disappeared, int appearedCount, int updatedCount, int disappearedCount) {
		if (appeared != null) {
			assertTrue(ELEMENT_MISSING, monitor.deltaSinceLastCheckpoint.appeared.contains(appeared))
		}
		if (updated != null) {
			assertTrue(ELEMENT_MISSING, monitor.deltaSinceLastCheckpoint.updated.contains(updated))
		}
		if (disappeared != null) {
			assertTrue(ELEMENT_MISSING, monitor.deltaSinceLastCheckpoint.disappeared.contains(disappeared))
		}
		if (appearedCount >= 0) {
			assertTrue(DeploymentChangeMonitorTest.INCORRECT_NUMBER_OF_DELTAS, monitor.deltaSinceLastCheckpoint.appeared.size == appearedCount)
		}
		if (updatedCount >= 0) {
			assertTrue(DeploymentChangeMonitorTest.INCORRECT_NUMBER_OF_DELTAS, monitor.deltaSinceLastCheckpoint.updated.size == updatedCount)
		}
		if (disappearedCount >= 0) {
			assertTrue(DeploymentChangeMonitorTest.INCORRECT_NUMBER_OF_DELTAS, monitor.deltaSinceLastCheckpoint.disappeared.size == disappearedCount)
		}
	}

	// Test for pattern deploymentHostsChange
	// @Ignore
	@Test
	def void hostAdditionAndRemoval() {
		monitor.startMonitoring()

		// Addition
		val newHost = prepareHost("host3", "1.1.1.3", deployment)
		info("Host added to the deployment")

		// Removal
		val iterator = deployment.hosts.iterator;
		val removedHost = iterator.next
		iterator.remove

		// The application and its behavior on the host is also removed
		assertContainments(newHost, null, removedHost, 1, 0, 3);
	}

	// Test for pattern deploymentHostIpChange and hostIpChange
	// @Ignore
	@Test
	def void changeHostIPAddress() {
		monitor.startMonitoring()

		// Update
		val iterator = deployment.hosts.iterator;
		
		val host1 = iterator.next
		host1.ip = "2.2.2.2"
		info("Updated ip for a host")
		assertContainments(null,host1,null,0,1,0);

		val host2 = iterator.next
		host2.ip = "2.2.2.4"
		info("Updated ip for an another host")
		assertContainments(null,host2,null,0,2,0);
		// Check stored original IP address
		assertEquals(monitor.deltaSinceLastCheckpoint.oldNamesForDeletion.get(host2),"1.1.1.2")
	}

	// Test for pattern hostApplicationsChange
	// @Ignore
	@Test
	def void changeAppllicationsOnHost() {
		monitor.startMonitoring()

		val host = deployment.hosts.iterator.next
		val app = host.applications.head
		host.applications.remove(app)

		// Behavior also disappeared, and the host is updated
		assertContainments(null,host,app,0,1,2);
	}

	// Test for pattern applicationIdChange
	// @Ignore
	@Test
	def void changeApplicationID() {
		monitor.startMonitoring()
		val host = deployment.hosts.head
		val app = host.applications.head

		app.id = "newID"
		
		assertContainments(null,app,null,0,1,0)
	}

	// Test for pattern applicationBehaviorChange
	// @Ignore
	@Test
	def void changeCurrentStateForApplication() {
		monitor.startMonitoring()
		val app = deployment.hosts.head.applications.head
		val behavior = app.behavior

		behavior.current = behavior.states.get(0)

		// Due to rules for behavior, it is also in the update list
		// This could be fixed, but might not worth the overhead and complexity
		assertContainments(null,app,null,0,2,0)
	}

	// Test for pattern behaviorChange
	// @Ignore
	@Test
	def void addStateToABehavior() {
		monitor.startMonitoring()
		val behavior = deployment.hosts.head.applications.head.behavior

		behavior.states += DeploymentFactory.eINSTANCE.createBehaviorState

		// Due to rules for application, it is also in the update list
		// This could be fixed, but might not worth the overhead and complexity
		assertContainments(null,behavior,null,0,2,0);
	}

	// Test for pattern transitionChange
	// @Ignore
	@Test
	def void removeStateFromABehavior() {
		monitor.startMonitoring()
		val behavior = deployment.hosts.head.applications.head.behavior

		behavior.states.remove(0)

		// Due to rules for application, it is also in the update list
		// This could be fixed, but might not worth the overhead and complexity
		assertContainments(null,behavior,null,0,2,0);
	}

	// Test for pattern transitionChange
	// @Ignore
	@Test
	def void modifyTransitionListOfBehavior() {
		monitor.startMonitoring()
		val behavior = deployment.hosts.head.applications.head.behavior

		val newTransition = DeploymentFactory.eINSTANCE.createBehaviorTransition

		behavior.transitions += newTransition

		// Due to rules for application, it is also in the update list
		// This could be fixed, but might not worth the overhead and complexity
		assertContainments(null,behavior,null,0,2,0)

		behavior.transitions -= newTransition

		// It is already in the updated list, after additional modifications it should still be there
		assertContainments(null,behavior,null,0,2,0)
	}

	// Test for pattern transitionChange
	@Ignore
	@Test
	def void removeTransitionFromBehavior() {
		monitor.startMonitoring()
		val behavior = deployment.hosts.head.applications.head.behavior

		val transition = behavior.transitions.head

		behavior.transitions -= transition

		// It is already in the appeared list, after additional modifications it should still be there
		assertTrue("Behavior not found in the deltas", monitor.deltaSinceLastCheckpoint.updated.contains(behavior))

		// Due to rules for application, it is also in the update list
		// This could be fixed, but might not worth the overhead and complexity
		assertTrue("Too many deltas stored", monitor.deltaSinceLastCheckpoint.updated.size == 2)
	}

	// Test for pattern triggerChange
	// @Ignore
	@Test
	def void addTriggerToTransition() {
		monitor.startMonitoring()
		val behavior = deployment.hosts.head.applications.head.behavior

		behavior.transitions.head.trigger += behavior.transitions.head;

		assertTrue("Behavior not found in the deltas", monitor.deltaSinceLastCheckpoint.updated.contains(behavior))
		assertTrue("Too many deltas stored", monitor.deltaSinceLastCheckpoint.updated.size == 1)
	}

}
