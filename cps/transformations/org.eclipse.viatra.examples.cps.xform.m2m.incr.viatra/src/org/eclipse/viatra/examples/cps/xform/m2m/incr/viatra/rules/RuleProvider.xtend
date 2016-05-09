/*******************************************************************************
 * Copyright (c) 2014, 2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Zoltan Ujhelyi, Peter Lunk, Istvan David - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2m.incr.viatra.rules

import org.apache.log4j.Logger
import org.eclipse.viatra.examples.cps.deployment.BehaviorState
import org.eclipse.viatra.examples.cps.deployment.BehaviorTransition
import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication
import org.eclipse.viatra.examples.cps.deployment.DeploymentBehavior
import org.eclipse.viatra.examples.cps.deployment.DeploymentHost
import org.eclipse.viatra.examples.cps.deployment.DeploymentPackage
import org.eclipse.viatra.examples.cps.traceability.CPS2DeploymentTrace
import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment
import org.eclipse.viatra.examples.cps.traceability.TraceabilityPackage
import org.eclipse.viatra.examples.cps.xform.m2m.incr.viatra.patterns.ApplicationInstanceMatcher
import org.eclipse.viatra.examples.cps.xform.m2m.incr.viatra.patterns.CpsXformM2M
import org.eclipse.viatra.examples.cps.xform.m2m.incr.viatra.patterns.HostInstanceMatcher
import org.eclipse.viatra.examples.cps.xform.m2m.incr.viatra.patterns.StateMachineMatcher
import org.eclipse.viatra.examples.cps.xform.m2m.incr.viatra.patterns.StateMatcher
import org.eclipse.viatra.examples.cps.xform.m2m.incr.viatra.patterns.TransitionMatcher
import org.eclipse.viatra.examples.cps.xform.m2m.incr.viatra.patterns.TriggerPairMatcher
import org.eclipse.viatra.query.runtime.api.IPatternMatch
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.query.runtime.api.ViatraQueryMatcher
import org.eclipse.viatra.transformation.evm.specific.Lifecycles
import org.eclipse.viatra.transformation.evm.specific.crud.CRUDActivationStateEnum
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.SimpleModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.rules.eventdriven.EventDrivenTransformationRule
import org.eclipse.viatra.transformation.runtime.emf.rules.eventdriven.EventDrivenTransformationRuleFactory

public class RuleProvider {

	extension Logger logger = Logger.getLogger("cps.xform.m2m.incr.viatra")
	extension CpsXformM2M cpsXformM2M = CpsXformM2M.instance
	extension IModelManipulations manipulation
	extension DeploymentPackage depPackage = DeploymentPackage::eINSTANCE
	extension TraceabilityPackage trPackage = TraceabilityPackage::eINSTANCE
	extension EventDrivenTransformationRuleFactory factory = new EventDrivenTransformationRuleFactory
	CPSToDeployment cps2dep
	ViatraQueryEngine engine

	EventDrivenTransformationRule<? extends IPatternMatch, ? extends ViatraQueryMatcher<?>> hostRule
	EventDrivenTransformationRule<? extends IPatternMatch, ? extends ViatraQueryMatcher<?>> applicationRule
	EventDrivenTransformationRule<? extends IPatternMatch, ? extends ViatraQueryMatcher<?>> stateMachineRule
	EventDrivenTransformationRule<? extends IPatternMatch, ? extends ViatraQueryMatcher<?>> stateRule
	EventDrivenTransformationRule<? extends IPatternMatch, ? extends ViatraQueryMatcher<?>> transitionRule
	EventDrivenTransformationRule<? extends IPatternMatch, ? extends ViatraQueryMatcher<?>> triggerRule

	new(ViatraQueryEngine engine, CPSToDeployment cps2dep) {
		this.engine = engine
		this.cps2dep = cps2dep
		manipulation = new SimpleModelManipulations(engine)
	}

	public def getHostRule() {
		if (hostRule == null) {
			hostRule = createRule.precondition(HostInstanceMatcher.querySpecification).action(
				CRUDActivationStateEnum.CREATED) [	
				debug('''Mapping host with IP: «hostInstance.nodeIp»''')
			
				val deploymentHost = cps2dep.deployment.createChild(deployment_Hosts, deploymentHost)
				deploymentHost.set(deploymentHost_Ip, hostInstance.nodeIp)
				
				val hostTrace = cps2dep.createChild(CPSToDeployment_Traces, CPS2DeploymentTrace)
				hostTrace.addTo(CPS2DeploymentTrace_CpsElements, hostInstance)
				hostTrace.addTo(CPS2DeploymentTrace_DeploymentElements, deploymentHost)
				
			].action(CRUDActivationStateEnum.UPDATED) [
				val depHost = engine.cps2depTrace.getOneArbitraryMatch(cps2dep, null, hostInstance, null).depElement as DeploymentHost
				debug('''Updating mapped host with IP: «depHost.ip»''')
				depHost.set(deploymentHost_Ip, hostInstance.nodeIp)
				debug('''Updated mapped host with IP: «depHost.ip»''')
			].action(CRUDActivationStateEnum.DELETED) [
				val traceMatch = engine.cps2depTrace.getOneArbitraryMatch(cps2dep, null, hostInstance, null)
				logger.debug('''Removing host with IP: «hostInstance.nodeIp»''')
				cps2dep.deployment.remove(deployment_Hosts, traceMatch.depElement)
				cps2dep.remove(CPSToDeployment_Traces, traceMatch.trace)
				logger.debug('''Removed host with IP: «hostInstance.nodeIp»''')
			].addLifeCycle(Lifecycles.getDefault(true, true)).build

		}
		return hostRule
	}

	public def getApplicationRule() {
		if (applicationRule == null) {

			applicationRule = createRule.precondition(ApplicationInstanceMatcher.querySpecification).action(
				CRUDActivationStateEnum.CREATED) [
				val depHost = engine.cps2depTrace.getAllValuesOfdepElement(null, null, appInstance.allocatedTo).
					filter(DeploymentHost).head
				debug('''Mapping application with ID: «appInstance.identifier»''')
				val deploymentApplication = depHost.createChild(deploymentHost_Applications, deploymentApplication)
				deploymentApplication.set(deploymentApplication_Id, appInstance.identifier)
				
				val hostTrace = cps2dep.createChild(CPSToDeployment_Traces, CPS2DeploymentTrace)
				hostTrace.addTo(CPS2DeploymentTrace_CpsElements, appInstance)
				hostTrace.addTo(CPS2DeploymentTrace_DeploymentElements, deploymentApplication)
				debug('''Mapped application with ID: «appInstance.identifier»''')
			].action(CRUDActivationStateEnum.UPDATED) [
				val depApp = engine.cps2depTrace.getOneArbitraryMatch(cps2dep, null, appInstance, null).depElement as DeploymentApplication
				if (depApp.id != appInstance.identifier)
					depApp.set(deploymentApplication_Id, appInstance.identifier)
			].action(CRUDActivationStateEnum.DELETED) [
				val trace = engine.cps2depTrace.getAllValuesOftrace(null, appInstance, null).head as CPS2DeploymentTrace
				val depApp = trace.deploymentElements.head as DeploymentApplication
				engine.allocatedDeploymentApplication.getAllValuesOfdepHost(depApp).head.remove(deploymentHost_Applications, depApp)
				cps2dep.remove(CPSToDeployment_Traces, trace)
			].addLifeCycle(Lifecycles.getDefault(true, true)).build

		}
		return applicationRule
	}

	public def getStateMachineRule() {
		if (stateMachineRule == null) {
			stateMachineRule = createRule.precondition(StateMachineMatcher.querySpecification).action(
				CRUDActivationStateEnum.CREATED) [
				val depApp = engine.cps2depTrace.getAllValuesOfdepElement(null, null, appInstance).filter(
					DeploymentApplication).head
				debug('''Mapping state machine with ID: «stateMachine.identifier»''')
				val behavior = depApp.createChild(deploymentApplication_Behavior, deploymentBehavior) as DeploymentBehavior
				behavior.set(deploymentElement_Description, stateMachine.identifier)
				depApp.set(deploymentApplication_Behavior, behavior)
				val traces = engine.cps2depTrace.getAllValuesOftrace(null, stateMachine, null)
				if (traces.empty) {
					trace('''Creating new trace for state machine''')
					val trace = cps2dep.createChild(CPSToDeployment_Traces, CPS2DeploymentTrace)
					trace.addTo(CPS2DeploymentTrace_CpsElements, stateMachine)
					trace.addTo(CPS2DeploymentTrace_DeploymentElements, behavior)

				} else {
					trace('''Adding new behavior to existing trace''')
					traces.head.addTo(CPS2DeploymentTrace_DeploymentElements, behavior)
				}
				debug('''Mapped state machine with ID: «stateMachine.identifier»''')
			].action(CRUDActivationStateEnum.UPDATED) [
				val smId = stateMachine.identifier
				debug('''Updating mapped state machine with ID: «smId»''')
				val depSMs = engine.cps2depTrace.getAllValuesOfdepElement(null, null, stateMachine).filter(
					DeploymentBehavior)
				depSMs.forEach [
					if (description != smId) {
						trace('''ID changed to «smId»''')
						set(deploymentElement_Description, smId)
					}
				]
				debug('''Updated mapped state machine with ID: «smId»''')
			].action(CRUDActivationStateEnum.DELETED) [
				val depApp = engine.cps2depTrace.getAllValuesOfdepElement(null, null, appInstance).head as DeploymentApplication;
				val depBehavior = depApp.behavior
				val smId = depBehavior.description

				logger.debug('''Removing state machine with ID: «smId»''')
				depApp.set(deploymentApplication_Behavior, null)

				val smTrace = engine.cps2depTrace.getAllValuesOftrace(null, stateMachine, null).head
				smTrace.remove(CPS2DeploymentTrace_DeploymentElements, depBehavior)
				if (smTrace.deploymentElements.empty) {
					trace('''Removing empty trace''')
					cps2dep.remove(CPSToDeployment_Traces, smTrace)
				}
				logger.debug('''Removed state machine with ID: «smId»''')
			].addLifeCycle(Lifecycles.getDefault(true, true)).build

		}
		return stateMachineRule
	}

	public def getStateRule() {
		if (stateRule == null) {
			stateRule = createRule.precondition(StateMatcher.querySpecification).action(
				CRUDActivationStateEnum.CREATED) [
				val depApp = engine.cps2depTrace.getAllValuesOfdepElement(null, null, appInstance).head as DeploymentApplication
				debug('''Mapping state with ID: «state.identifier»''')
				val depState = depApp.behavior.createChild(deploymentBehavior_States, behaviorState)
				depState.set(deploymentElement_Description, state.identifier)
				if (stateMachine.initial == state) {
					depApp.behavior.set(deploymentBehavior_Current, depState)
				}
				
				val traces = engine.cps2depTrace.getAllValuesOftrace(null, state, null)
				if (traces.empty) {
					trace('''Creating new trace for state ''')
					val trace = cps2dep.createChild(CPSToDeployment_Traces, CPS2DeploymentTrace)
					trace.addTo(CPS2DeploymentTrace_CpsElements, state)
					trace.addTo(CPS2DeploymentTrace_DeploymentElements, depState)
				} else {
					trace('''Adding new state to existing trace''')
					traces.head.addTo(CPS2DeploymentTrace_DeploymentElements, depState)
				}
				debug('''Mapped state with ID: «state.identifier»''')
			].action(CRUDActivationStateEnum.UPDATED) [
				debug('''Updating mapped state with ID: «state.identifier»''')
				val depApp = engine.cps2depTrace.getAllValuesOfdepElement(null, null, appInstance).filter(
					DeploymentApplication).head
				val depState = engine.cps2depTrace.getAllValuesOfdepElement(null, null, state).filter(BehaviorState).
					findFirst[depApp.behavior.states.contains(it)]	
				val depBehavior = depApp.behavior
				
				if (depState.description != state.identifier) {
					trace('''ID changed to «state.identifier»''')
					depState.set(deploymentElement_Description, state.identifier)
				}
				
				if (state == stateMachine.initial) {
					if (depBehavior.current != depState) {
						trace('''Current state changed to «state.identifier»''')
						depBehavior.set(deploymentBehavior_Current, depState)
					}
				}
				debug('''Updated mapped state with ID: «state.identifier»''')
			].action(CRUDActivationStateEnum.DELETED) [
				val depApp = engine.cps2depTrace.getAllValuesOfdepElement(null, null, appInstance).head as DeploymentApplication
				val depBehavior = depApp.behavior
				val depState = engine.cps2depTrace.getAllValuesOfdepElement(null, null, state).filter(BehaviorState).
					findFirst[depApp.behavior.states.contains(it)];
				val stateId = depState.description
				
				logger.debug('''Removing state with ID: «stateId»''')
				if (depBehavior != null) {
					depBehavior.remove(deploymentBehavior_States, depState)
					if (depBehavior.current == depState) {
						depBehavior.set(deploymentBehavior_Current, null)
					}
				}
				val smTrace = engine.cps2depTrace.getAllValuesOftrace(null, state, null).head
				smTrace.remove(CPS2DeploymentTrace_DeploymentElements, depState)
				if (smTrace.deploymentElements.empty) {
					trace('''Removing empty trace''')
					cps2dep.remove(CPSToDeployment_Traces, smTrace)
				}
				logger.debug('''Removed state with ID: «stateId»''')
			].addLifeCycle(Lifecycles.getDefault(true, true)).build

		}
		return stateRule
	}

	public def getTransitionRule() {
		if (transitionRule == null) {
			transitionRule = createRule.precondition(TransitionMatcher.querySpecification).action(
				CRUDActivationStateEnum.CREATED) [
				val depApp = engine.cps2depTrace.getAllValuesOfdepElement(null, null, appInstance).filter(
					DeploymentApplication).head
				val transition = transition
				val transitionId = transition.identifier
				
				debug('''Mapping transition with ID: «transitionId»''')
				val depTransition = depApp.behavior.createChild(deploymentBehavior_Transitions, behaviorTransition)
				depTransition.set(deploymentElement_Description, transitionId)

				val tempDepSources = engine.cps2depTrace.getAllValuesOfdepElement(null, null, srcState);
				val depSource = depApp.behavior.states.findFirst[tempDepSources.contains(it)]

				depSource.addTo(behaviorState_Outgoing, depTransition)
				val tempDepTargets = engine.cps2depTrace.getAllValuesOfdepElement(null, null, transition.targetState);
				val depTarget = depApp.behavior.states.findFirst[tempDepTargets.contains(it)]
				
				depTransition.set(behaviorTransition_To, depTarget)
				val traces = engine.cps2depTrace.getAllValuesOftrace(null, transition, null)
				if (traces.empty) {
					trace('''Creating new trace for transition ''')
					val trace = cps2dep.createChild(CPSToDeployment_Traces, CPS2DeploymentTrace)
					trace.addTo(CPS2DeploymentTrace_CpsElements, transition)
					trace.addTo(CPS2DeploymentTrace_DeploymentElements, depTransition)
				} else {
					trace('''Adding new transition to existing trace''')
					traces.head.addTo(CPS2DeploymentTrace_DeploymentElements, depTransition)
				}
				debug('''Mapped transition with ID: «transitionId»''')
			].action(CRUDActivationStateEnum.UPDATED) [
				val transition = transition
				val trId = transition.identifier
				debug('''Updating mapped transition with ID: «trId»''')
				
				val depApp = engine.cps2depTrace.getAllValuesOfdepElement(null, null, appInstance).filter(
					DeploymentApplication).head
				val depTransitions = engine.cps2depTrace.getAllValuesOfdepElement(null, null, transition).filter(
					BehaviorTransition).toSet
				val depTransition = depApp.behavior.transitions.findFirst[depTransitions.contains(it)]
				val oldDesc = depTransition.description
				if (oldDesc != trId) {
					trace('''ID changed to «oldDesc»''')
					depTransition.set(deploymentElement_Description, trId)
				}
				val tempDepSources = engine.cps2depTrace.getAllValuesOfdepElement(null, null, srcState)
				val depSource = depApp.behavior.states.findFirst[tempDepSources.contains(it)]
				val tempDepTargets = engine.cps2depTrace.getAllValuesOfdepElement(null, null, transition.targetState);
				val depTarget = depApp.behavior.states.findFirst[tempDepTargets.contains(it)]
				
				if (!depSource.outgoing.contains(depTransition)) {
					trace('''Source state changed to «depSource.description»''')
					depSource.addTo(behaviorState_Outgoing, depTransition)
				}
				if (depTransition.to != depTarget) {
					trace('''Target state changed to «depTarget.description»''')
					depTransition.set(behaviorTransition_To, depTarget)
				}
				debug('''Updated mapped transition with ID: «trId»''')
			].action(CRUDActivationStateEnum.DELETED) [
				val transition = transition
				val depApp = engine.cps2depTrace.getAllValuesOfdepElement(null, null, appInstance).filter(
					DeploymentApplication).head
				val depTransitions = engine.cps2depTrace.getAllValuesOfdepElement(null, null, transition).filter(
					BehaviorTransition).toSet
				val depTransition = engine.depBehaviorsStateAndTransitions.
					getAllValuesOfdepTransition(depApp.behavior, null).findFirst[depTransitions.contains(it)]
				val trId = depTransition.description
				logger.debug('''Removing transition with ID: «trId»''')
				depTransition.set(behaviorTransition_To, null)
				val tempDepSources = engine.cps2depTrace.getAllValuesOfdepElement(null, null, srcState)
				val depSource = depApp.behavior.states.findFirst[tempDepSources.contains(it)]
				depSource?.remove(behaviorState_Outgoing, depTransition)
				depApp.behavior.remove(deploymentBehavior_Transitions, depTransition)
				val smTrace = engine.cps2depTrace.getAllValuesOftrace(null, transition, null).head
				smTrace.remove(CPS2DeploymentTrace_DeploymentElements, depTransition)
				if (smTrace.deploymentElements.empty) {
					trace('''Removing empty trace''')
					cps2dep.remove(CPSToDeployment_Traces, smTrace)
				}
				logger.debug('''Removed transition with ID: «trId»''')
			].addLifeCycle(Lifecycles.getDefault(true, true)).build

		}
		return transitionRule
	}

	public def getTriggerRule() {
		if (triggerRule == null) {
			triggerRule = createRule.precondition(TriggerPairMatcher.querySpecification).action(
				CRUDActivationStateEnum.CREATED) [
				val depAppTrigger = engine.cps2depTrace.getAllValuesOfdepElement(null, null, appInstanceTrigger).
					filter(DeploymentApplication).head
				val depAppTarget = engine.cps2depTrace.getAllValuesOfdepElement(null, null, appInstanceTarget).
					filter(DeploymentApplication).head
				val sendTr = engine.cps2depTrace.getAllValuesOfdepElement(null, null, cpsTrigger).filter(
					BehaviorTransition).findFirst[depAppTrigger.behavior.transitions.contains(it)]
				val waitTr = engine.cps2depTrace.getAllValuesOfdepElement(null, null, cpsTarget).filter(
					BehaviorTransition).findFirst[depAppTarget.behavior.transitions.contains(it)]
				debug('''Mapping trigger between «sendTr.description» and «waitTr.description»''')
				if (!sendTr.trigger.contains(waitTr)) {
					trace('''Adding new trigger''')
					sendTr.addTo(behaviorTransition_Trigger, waitTr)
				}
				debug('''Mapped trigger between «sendTr.description» and «waitTr.description»''')
			].action(CRUDActivationStateEnum.DELETED) [
				val depAppTrigger = engine.cps2depTrace.getAllValuesOfdepElement(null, null, appInstanceTrigger).
					filter(DeploymentApplication).head
				val depAppTarget = engine.cps2depTrace.getAllValuesOfdepElement(null, null, appInstanceTarget).
					filter(DeploymentApplication).head
				val sendTr = engine.cps2depTrace.getAllValuesOfdepElement(null, null, cpsTrigger).filter(
					BehaviorTransition).findFirst[depAppTrigger.behavior.transitions.contains(it)]
				val waitTr = engine.cps2depTrace.getAllValuesOfdepElement(null, null, cpsTarget).filter(
					BehaviorTransition).findFirst[depAppTarget.behavior.transitions.contains(it)]
				debug('''Removing trigger between «sendTr.description» and «waitTr.description»''')
				if (sendTr.trigger.contains(waitTr)) {
					trace('''Removing existing trigger''')
					sendTr.remove(behaviorTransition_Trigger, waitTr)
				}
				debug('''Removed trigger between «sendTr.description» and «waitTr.description»''')
			].addLifeCycle(Lifecycles.getDefault(true, true)).build

		}
		return triggerRule
	}
}
