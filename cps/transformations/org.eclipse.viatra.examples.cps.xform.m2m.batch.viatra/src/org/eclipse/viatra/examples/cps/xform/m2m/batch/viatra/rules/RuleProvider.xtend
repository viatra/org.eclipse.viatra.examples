/*******************************************************************************
 * Copyright (c) 2014, 2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Zoltan Ujhelyi, Daniel Segesdi - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2m.batch.viatra.rules

import org.apache.log4j.Logger
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Identifiable
import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication
import org.eclipse.viatra.examples.cps.deployment.DeploymentFactory
import org.eclipse.viatra.examples.cps.deployment.DeploymentHost
import org.eclipse.viatra.examples.cps.traceability.CPS2DeploymentTrace
import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment
import org.eclipse.viatra.examples.cps.traceability.TraceabilityFactory
import org.eclipse.viatra.examples.cps.xform.m2m.batch.viatra.patterns.ActionPairMatcher
import org.eclipse.viatra.examples.cps.xform.m2m.batch.viatra.patterns.AppInstanceWithStateMachineMatcher
import org.eclipse.viatra.examples.cps.xform.m2m.batch.viatra.patterns.ApplicationInstanceMatcher
import org.eclipse.viatra.examples.cps.xform.m2m.batch.viatra.patterns.CpsXformM2M
import org.eclipse.viatra.examples.cps.xform.m2m.batch.viatra.patterns.HostInstanceMatcher
import org.eclipse.viatra.examples.cps.xform.m2m.batch.viatra.patterns.StateMatcher
import org.eclipse.viatra.examples.cps.xform.m2m.batch.viatra.patterns.TransitionMatcher
import org.eclipse.viatra.query.runtime.api.IPatternMatch
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.query.runtime.api.ViatraQueryMatcher
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.SimpleModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRule
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory
import org.eclipse.viatra.examples.cps.deployment.BehaviorTransition

class RuleProvider {
	extension Logger logger = Logger.getLogger("cps.xform.m2m.batch.viatra")
	extension CpsXformM2M cpsXformM2M = CpsXformM2M.instance
	extension BatchTransformationRuleFactory = new BatchTransformationRuleFactory
	extension IModelManipulations manipulation
	protected extension DeploymentFactory depFactory = DeploymentFactory.eINSTANCE
	protected extension TraceabilityFactory traceFactory = TraceabilityFactory.eINSTANCE
	CPSToDeployment mapping
	ViatraQueryEngine engine
	
	BatchTransformationRule<? extends IPatternMatch, ? extends ViatraQueryMatcher<?>> hostRule
	BatchTransformationRule<? extends IPatternMatch, ? extends ViatraQueryMatcher<?>> applicationRule
	BatchTransformationRule<? extends IPatternMatch, ? extends ViatraQueryMatcher<?>> stateMachineRule
	BatchTransformationRule<? extends IPatternMatch, ? extends ViatraQueryMatcher<?>> stateRule
	BatchTransformationRule<? extends IPatternMatch, ? extends ViatraQueryMatcher<?>> transitionRule
	BatchTransformationRule<? extends IPatternMatch, ? extends ViatraQueryMatcher<?>> actionRule
	
	new(ViatraQueryEngine engine, CPSToDeployment deployment) {
		this.mapping = deployment
		this.engine = engine
		manipulation = new SimpleModelManipulations(engine)
	}
	
	
	public def getHostRule() {
		if (hostRule == null) {
			hostRule = createRule.precondition(HostInstanceMatcher.querySpecification).action[
				val cpsHostInstance = it.hostInstance
				val nodeIp = it.hostInstance.nodeIp
				debug('''Mapping host with IP: «nodeIp»''')
				val deploymentHost = createDeploymentHost => [
					ip = nodeIp
				]
				mapping.deployment.hosts += deploymentHost
				mapping.traces += createCPS2DeploymentTrace => [
					cpsElements += cpsHostInstance
					deploymentElements += deploymentHost
				]
			].build
		}
		return hostRule
	}
	
	public def getApplicationRule() {
		if (applicationRule == null) {
			applicationRule = createRule.precondition(ApplicationInstanceMatcher.querySpecification).action[
				val cpsApplicationInstance = it.appInstance
				val appId = it.appInstance.identifier
				
				val cpsHostInstance = cpsApplicationInstance.allocatedTo
				val depHost = engine.cps2depTrace.getAllValuesOfdepElement(null, null, cpsHostInstance).filter(DeploymentHost).head
				
				debug('''Mapping application with ID: «appId»''')
				val deploymentApplication = createDeploymentApplication => [
					id = appId
				]
				
				
				mapping.traces += createCPS2DeploymentTrace => [
					cpsElements += cpsApplicationInstance
					deploymentElements += deploymentApplication
				]
				depHost.applications += deploymentApplication
				debug('''Mapped application with ID: «appId»''')
			].build
		}
		return applicationRule
	}
	
	public def getStateMachineRule() {
		if (stateMachineRule == null) {
			stateMachineRule = createRule.precondition(AppInstanceWithStateMachineMatcher.querySpecification).action[
				val cpsApplicationInstance = it.appInstance
				val cpsStateMachine = it.stateMachine
				
				val depApplication = engine.cps2depTrace.getAllValuesOfdepElement(null, null, cpsApplicationInstance).filter(DeploymentApplication).head
				debug('''Mapping state machine with ID: «cpsStateMachine.identifier»''')
				val depBehavior = createDeploymentBehavior => [
					description = cpsStateMachine.identifier
				]
				depApplication.behavior = depBehavior
				
				val trace = getTraceForCPSElement(cpsStateMachine)
				if (trace == null){
					mapping.traces += createCPS2DeploymentTrace => [
						cpsElements += cpsStateMachine
						deploymentElements += depBehavior
					]
				} else {
					trace.deploymentElements += depBehavior
				}
				
			].build
		}
		return stateMachineRule
	}
	
	public def getStateRule() {
		if (stateRule == null) {
			stateRule = createRule.precondition(StateMatcher.querySpecification).action[
				val cpsStateMachine = it.stateMachine
				val cpsAppInstance = it.appInstance
				val cpsState = it.state
				
				debug('''Mapping state with ID: «cpsState.identifier»''')
				val behaviorState = createBehaviorState => [
					description = cpsState.identifier
				]
				
				val appInstanceTrace = getTraceForCPSElement(cpsAppInstance)
				val depApplication = appInstanceTrace.deploymentElements.filter(DeploymentApplication).head
				val depBehavior = depApplication.behavior
				depBehavior.states += behaviorState
				
				val trace = getTraceForCPSElement(cpsState)
				if (trace == null) {
					mapping.traces += createCPS2DeploymentTrace => [
						cpsElements += cpsState
						deploymentElements += behaviorState
					]
				} else {
					trace.deploymentElements += behaviorState
				}
				
				if (cpsStateMachine.initial == cpsState) {
					depBehavior.current = behaviorState
				}
			].build
		}
		return stateRule
	}
	
	public def getTransitionRule() {
		if (transitionRule == null) {
			transitionRule = createRule.precondition(TransitionMatcher.querySpecification).action[
				val cpsAppInstance = it.appInstance
				val cpsState = it.sourceState
				val cpsTargetState = it.targetState
				val cpsTransition = it.transition  
				
				debug('''Mapping transition with ID: «cpsTransition.identifier»''')
				val behaviorTransition = createBehaviorTransition => [
					description = cpsTransition.identifier
				]
				
				val appInstanceTrace = getTraceForCPSElement(cpsAppInstance)
				val depApplication = appInstanceTrace.deploymentElements.filter(DeploymentApplication).head
				val depBehavior = depApplication.behavior
				depBehavior.transitions += behaviorTransition
				
				val trace = getTraceForCPSElement(cpsTransition)
				if (trace == null){
					mapping.traces += createCPS2DeploymentTrace => [
						cpsElements += cpsTransition
						deploymentElements += behaviorTransition
					]
				} else {
					trace.deploymentElements += behaviorTransition
				}
				
				val depTargetState = depBehavior.states.filter[description == cpsTargetState.identifier].head
				val depSourceState = depBehavior.states.filter[description == cpsState.identifier].head
				
				depSourceState.outgoing += behaviorTransition
				behaviorTransition.to = depTargetState
			].build
		}
		return transitionRule
	}
	
	public def getActionRule() {
		if (actionRule == null) {
			actionRule = createRule.precondition(ActionPairMatcher.querySpecification).action[
				val cpsSendTransition = sendTransition
				val cpsSendAppInstance = sendAppInstance
				val cpsWaitTransition = waitTransition
				val cpsWaitAppInstance = waitAppInstance
				
				debug('''Mapping trigger between transitions: «cpsSendTransition.identifier» and «cpsWaitTransition.identifier»''')
				val sendTransitionTrace = getTraceForCPSElement(cpsSendTransition)
				val sendAppInstanceTrace = getTraceForCPSElement(cpsSendAppInstance)
				
				val depSendApp = sendAppInstanceTrace.deploymentElements.filter(DeploymentApplication).head
				val depSendTransition = sendTransitionTrace.deploymentElements.filter(BehaviorTransition).findFirst[
					depSendApp == it.eContainer.eContainer
				]
				
				val waitTransitionTrace = getTraceForCPSElement(cpsWaitTransition)
				val waitAppInstanceTrace = getTraceForCPSElement(cpsWaitAppInstance)
				
				val depWaitApp = waitAppInstanceTrace.deploymentElements.filter(DeploymentApplication).head
				val depWaitTransition = waitTransitionTrace.deploymentElements.filter(BehaviorTransition).findFirst[
					depWaitApp == it.eContainer.eContainer
				]
				
				depSendTransition.trigger += depWaitTransition
			].build
		}
		return actionRule
	}
	
	def getTraceForCPSElement(Identifiable cpsElement) {
		engine.cps2depTrace.getAllValuesOftrace(null, cpsElement, null).filter(CPS2DeploymentTrace).head
	}
}