/*******************************************************************************
 * Copyright (c) 2014-2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Marton Bur, Zoltan Ujhelyi, Balazs Grill - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2m.batch.simple

import com.google.common.collect.ImmutableList
import java.util.ArrayList
import org.apache.log4j.Logger
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Identifiable
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.State
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.StateMachine
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition
import org.eclipse.viatra.examples.cps.deployment.BehaviorState
import org.eclipse.viatra.examples.cps.deployment.BehaviorTransition
import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication
import org.eclipse.viatra.examples.cps.deployment.DeploymentBehavior
import org.eclipse.viatra.examples.cps.deployment.DeploymentElement
import org.eclipse.viatra.examples.cps.deployment.DeploymentFactory
import org.eclipse.viatra.examples.cps.deployment.DeploymentHost
import org.eclipse.viatra.examples.cps.traceability.CPS2DeploymentTrace
import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment
import org.eclipse.viatra.examples.cps.traceability.TraceabilityFactory

import static com.google.common.base.Preconditions.*
import static extension org.eclipse.viatra.examples.cps.xform.m2m.util.SignalUtil.*
import static extension org.eclipse.viatra.examples.cps.xform.m2m.util.NamingUtil.*

class CPS2DeploymentBatchTransformationSimple {

	extension Logger logger = Logger.getLogger("cps.xform.m2m.batch.simple")

	private def traceBegin(String method) {
		trace('''Executing «method» BEGIN''')
	}

	private def traceEnd(String method) {
		trace('''Executing «method» END''')
	}

	CPSToDeployment mapping;

	/**
	 * Creates a new transformation instance. The input cyber physical system model is given in the mapping
	 * @param mapping the traceability model root
	 */
	new(CPSToDeployment mapping) {
		traceBegin("constructor")

		checkNotNull(mapping, "Mapping cannot be null!")
		checkArgument(mapping.cps !== null, "CPS not defined in mapping!")
		checkArgument(mapping.deployment !== null, "Deployment not defined in mapping!")

		this.mapping = mapping;

		traceEnd("constructor")
	}

	/**
	 * Executes the simple batch transformation. The transformed model is placed in the traceability model set in the constructor 
	 */
	def void execute() {
		traceBegin("execute()")

		info(
			'''
			Executing transformation on:
				Cyber-physical system: «mapping.cps.identifier»''')
		
		
		mapping.traces.clear
		mapping.deployment.hosts.clear

		// Transform host instances
		val hosts = mapping.cps.hostTypes.map[instances].flatten
		val deploymentHosts = ImmutableList.copyOf(hosts.map[transform])
		mapping.deployment.hosts += deploymentHosts

		assignTriggers
		traceEnd("execute()")
	}

	/**
	 * Sets the <code>triggers</code> reference of the behavior transitions according to the transitions action.
	 * <br>
	 * Call this method only after the all the model elements (nodes) are transformed and exist in the target model.
	 */
	private def assignTriggers() {
		traceBegin("assignTriggers()")

		val transitionMappings = mapping.traces.filter[deploymentElements.head instanceof BehaviorTransition]
		val senderTransitionMappings = transitionMappings.filter[isTraceForSender]
		senderTransitionMappings.forEach[findAndAssignReceivers]

		traceEnd("assignTriggers()")
	}

	/**
	 * After finding the traces that contains the corresponding transitions, finds and assigns 
	 * triggered behavior transition
	 * @param senderTrace the trace that contains the sender transition
	 */
	private def findAndAssignReceivers(CPS2DeploymentTrace senderTrace) {
		traceBegin('''findReceivers(«senderTrace.name»)''')

		var receiverTraces = mapping.traces.filter[deploymentElements.head instanceof BehaviorTransition]
		receiverTraces.forEach[setTriggerIfConnected(senderTrace)]

		traceEnd('''findReceivers(«senderTrace.name»)''')
	}

	/**
	 * Sets the trigger reference for the sender behavior transition if 
	 * <li> the transition is waiting for the same type of message as the sender sends and
	 * <li> the receiving transition is in a deployed application that runs on a reachable host
	 * 
	 * @param senderTrace the trace that contains the sender transition
	 * @param receiverTrace the trace that contains the receiver transition
	 */
	private def void setTriggerIfConnected(CPS2DeploymentTrace receiverTrace, CPS2DeploymentTrace senderTrace) {
		traceBegin('''setTriggerIfConnected(«receiverTrace.name»,«senderTrace.name»)''')

		if (!isTraceForReceiver(receiverTrace))
			return;

		// a trace here refers to BehaviorTransitions
		for (i : receiverTrace.deploymentElements) {
			for (j : senderTrace.deploymentElements) {
				val receiverBehaviorTransition = i as BehaviorTransition
				val receiverDeploymentApp = receiverBehaviorTransition.eContainer.eContainer as DeploymentApplication
				val receiverDeploymentHost = receiverDeploymentApp.eContainer as DeploymentHost
				val receiverHostInstance = mapping.traces.findFirst[it.deploymentElements.head == receiverDeploymentHost].
					cpsElements.head as HostInstance

				val senderBehaviorTransition = j as BehaviorTransition
				val senderDeploymentApp = senderBehaviorTransition.eContainer.eContainer as DeploymentApplication
				val senderDeploymentHost = senderDeploymentApp.eContainer as DeploymentHost
				val senderHostInstance = mapping.traces.findFirst[it.deploymentElements.head == senderDeploymentHost].
					cpsElements.head as HostInstance

				val appInstance = mapping.traces.findFirst[deploymentElements.head == receiverDeploymentApp].cpsElements.
					head as ApplicationInstance
				val appTypeId = appInstance.type.identifier
				var senderTransition = senderTrace.cpsElements.head as Transition
				val appId1 = getAppId(senderTransition.action)
				if (appTypeId == appId1 && getSignalId((senderTrace.cpsElements.head as Transition).action) ==
					getSignalId((receiverTrace.cpsElements.head as Transition).action)) {

					// Only hosts has to be checked now
					if (isConnectedTo(senderHostInstance, receiverHostInstance)) {
						val sender = senderBehaviorTransition
						val receiver = receiverBehaviorTransition
						sender.trigger += receiver
					}

				}
			}
		}

		traceEnd('''setTriggerIfConnected(«receiverTrace.name»,«senderTrace.name»)''')
	}

	/**
	 * Returns if a trace contains a transition that sends a message
	 * @param trace the trace that links transitions and behavior transitions
	 */
	private def isTraceForSender(CPS2DeploymentTrace trace) {
		traceBegin('''isTraceForSender«trace.name»''')
		var isSender = false;
		var elements = trace.cpsElements
		for (t : elements) {
			isSender = isSender || (t as Transition).isTransitionSender
		}
		traceEnd('''isTraceForSender«trace.name»''')
		return isSender
	}

	/**
	 * Returns if a transition sends a message
	 * @param transition the transitions whose action is inspected
	 */
	private def isTransitionSender(Transition transition) {
		traceBegin('''isTransitionSender(«transition.name»)''')
		if (transition.action === null) {
			return false
		}

		if (isSend(transition.action)) {
			return true
		}

		traceEnd('''isTransitionSender(«transition.name»)''')
		return false
	}

	/**
	 * Returns if a trace contains a transition that waits for a message
	 * @param trace the trace that links transitions and behavior transitions
	 */
	private def isTraceForReceiver(CPS2DeploymentTrace trace) {
		traceBegin('''isTraceForReceiver(«trace.name»)''')
		var isReceiver = false;
		var elements = trace.cpsElements
		for (t : elements) {
			isReceiver = isReceiver || (t as Transition).isTransitionReceiver
		}
		traceEnd('''isTraceForReceiver(«trace.name»)''')
		return isReceiver
	}

	/**
	 * Returns if a transition waits for a message
	 * @param transition the transitions whose action is inspected
	 */
	private def isTransitionReceiver(Transition transition) {
		traceBegin('''isTransitionReceiver(«transition.name»)''')
		if (transition.action === null) {
			return false
		}

		if (isWait(transition.action)) {
			return true
		}

		traceEnd('''isTransitionReceiver(«transition.name»)''')
		return false
	}

	/**
	 * Checks whether the two given hosts are connected via the communicatesWith relation. 
	 * Also checks transitive communication capability. The communicatesWith relation is non-reflexive by default
	 * @param src the source host
	 * @param dst the target host
	 */
	private def isConnectedTo(HostInstance src, HostInstance dst) {
		traceBegin('''isConnectedTo(«src.name», «dst.name»)''')
		
		val communicates = src == dst || src.communicateWith.contains(dst)

		traceEnd('''isConnectedTo(«src.name», «dst.name»)''')
		return communicates;
	}

	/**
	 * Transforms a host instance to a deployment host. Sets deployment description to host ID. 
	 * @param hostInstance the host instance to transform
	 */
	private def DeploymentHost transform(HostInstance hostInstance) {
		traceBegin('''transform(«hostInstance.name»)''')
		var deploymentHost = DeploymentFactory.eINSTANCE.createDeploymentHost
		deploymentHost.ip = hostInstance.nodeIp

		hostInstance.createOrAddTrace(deploymentHost)

		// Transform application instances
		val liveApplications = hostInstance.applications.filter[type?.cps == mapping.cps]
		var deploymentApps = liveApplications.map[transform]
		deploymentHost.applications += deploymentApps

		traceEnd('''transform(«hostInstance.name»)''')
		return deploymentHost
	}

	/**
	 * Transforms an application instance to a deployment application. Sets deployment application description to application instance ID.
	 * @param appInstance the application instance to transform
	 */
	private def DeploymentApplication transform(ApplicationInstance appInstance) {
		traceBegin('''transform(«appInstance.name»)''')
		var deploymentApp = DeploymentFactory.eINSTANCE.createDeploymentApplication()
		deploymentApp.id = appInstance.identifier

		appInstance.createOrAddTrace(deploymentApp)

		// Transform state machines
		if (appInstance.type.behavior !== null)
			deploymentApp.behavior = appInstance.type.behavior.transform

		traceEnd('''transform(«appInstance.name»)''')
		return deploymentApp
	}

	/**
	 * Transforms a given state machine to a deployment behavior. Sets deployment behavior description to state machine ID.
	 * @param stateMachine the state machine to transform
	 */
	private def DeploymentBehavior transform(StateMachine stateMachine) {
		traceBegin('''transform(«stateMachine.name»)''')
		val behavior = DeploymentFactory.eINSTANCE.createDeploymentBehavior
		behavior.description = stateMachine.identifier

		stateMachine.createOrAddTrace(behavior)

		// Transform states
		val behaviorStates = stateMachine.states.map[transform]
		behavior.states += behaviorStates

		// Transform transitions
		var behaviorTransitions = new ArrayList<BehaviorTransition>
		for (state : stateMachine.states) {
			val stateMapping = mapping.traces.findFirst[it.cpsElements.contains(state)]
			val parentBehaviorState = stateMapping.deploymentElements.filter(BehaviorState).findFirst[
				behavior.states.contains(it)
			]
			behaviorTransitions.addAll(
				state.outgoingTransitions.filter[targetState !== null].filter [ transition |
					mapping.traces.findFirst [
						it.cpsElements.contains(transition.targetState)
					] !== null && /* Need to check, if it is in the model */ transition.targetState !== null
				].map [
					transform(parentBehaviorState)
				]
			)
		}

		behavior.transitions += behaviorTransitions

		setCurrentState(stateMachine, behavior)

		traceEnd('''transform(«stateMachine.name»)''')
		return behavior
	}

	/**
	 * Transforms a state to behavior state. Sets behavior state to state id.
	 * @param state the state to transform
	 */
	private def BehaviorState transform(State state) {
		traceBegin('''transform(«state.name»)''')
		val behaviorState = DeploymentFactory.eINSTANCE.createBehaviorState
		behaviorState.description = state.identifier

		state.createOrAddTrace(behaviorState)

		traceEnd('''transform(«state.name»)''')
		behaviorState
	}

	/**
	 * Transforms a transition to behavior transition. 
	 * @param transition the transition to transofrm
	 * @param behaviorState the state that shall be set as the origin of the transformed behavior transition 
	 */
	private def BehaviorTransition transform(Transition transition, BehaviorState behaviorState) {
		traceBegin('''transform(«transition.name», «behaviorState.name»)''')

		val behaviorTransition = DeploymentFactory.eINSTANCE.createBehaviorTransition

		val targetStateMapping = mapping.traces.findFirst[
			it.cpsElements.contains(transition.targetState)
		]
		val dep = targetStateMapping.deploymentElements
		val targetBehaviorState = dep.filter(BehaviorState).findFirst[
			it.eContainer.equals(behaviorState.eContainer)
		]
		behaviorTransition.to = targetBehaviorState
		behaviorState.outgoing += behaviorTransition
		behaviorTransition.description = transition.identifier

		transition.createOrAddTrace(behaviorTransition)

		traceEnd('''transform(«transition.name», «behaviorState.name»)''')
		return behaviorTransition
	}

	/**
	 * Sets the value of the current state based on the state machine
	 * @param stateMachine the state machine that describes the behavior
	 * @param behavior realizes the state machine in the target model
	 */
	private def setCurrentState(StateMachine stateMachine, DeploymentBehavior behavior) {
		traceBegin('''transform(«stateMachine.name», «behavior.name»)''')
		val initial = stateMachine.states.findFirst[stateMachine.initial == it]
		if (initial !== null) {
			val mappingForInitialState = mapping.traces.findFirst[it.cpsElements.contains(initial)]

			val initialBehaviorState = mappingForInitialState.deploymentElements.findFirst[behavior.states.contains(it)]

			behavior.current = initialBehaviorState as BehaviorState
		}
		traceEnd('''transform(«stateMachine.name», «behavior.name»)''')
	}

	/**
	 * Creates or adds trace between the given identifiable and deployment element. It also stores the created trace in the traceability model
	 * @param identifiable the left hand side of the mapping 
	 * @param deploymentElement the right hand side of the mapping 
	 */
	private def createOrAddTrace(Identifiable identifiable, DeploymentElement deploymentElement) {
		traceBegin('''createOrAddTrace(«identifiable.name», «deploymentElement.name»)''')
		val trace = mapping.traces.filter[it.cpsElements.contains(identifiable)]
		if (trace.empty) {
			identifiable.createTrace(deploymentElement)
		} else {
			trace.head.deploymentElements += deploymentElement
			if (!trace.tail.empty) {
				throw new IllegalStateException(
				'''More than one mapping was created to state machine with Id '«identifiable.identifier»'.''')
			}
		}

		traceEnd('''createOrAddTrace(«identifiable.name», «deploymentElement.name»)''')
	}

	/** Creates trace between the given identifiable and deployment element. It also stores the created trace in the traceability model
	 * @param identifiable the left hand side of the mapping 
	 * @param deploymentElement the right hand side of the mapping 
	 */
	private def createTrace(Identifiable identifiable, DeploymentElement deploymentElement) {
		traceBegin('''createTrace(«identifiable.name», «deploymentElement.name»)''')

		var trace = TraceabilityFactory.eINSTANCE.createCPS2DeploymentTrace
		trace.cpsElements += identifiable
		trace.deploymentElements += deploymentElement
		mapping.traces += trace

		traceBegin('''createTrace(«identifiable.name», «deploymentElement.name»)''')
	}

	/**
	 * Cleans up the transformation
	 */
	def dispose() {
		traceBegin("dispose()")
		traceEnd("dispose()")
	}
}
