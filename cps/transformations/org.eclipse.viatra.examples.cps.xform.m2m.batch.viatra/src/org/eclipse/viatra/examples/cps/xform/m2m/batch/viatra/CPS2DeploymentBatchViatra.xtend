/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Zoltan Ujhelyi, Daniel Segesdi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2m.batch.viatra

import com.google.common.base.Stopwatch
import java.util.concurrent.TimeUnit
import org.apache.log4j.Logger
import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment
import org.eclipse.viatra.examples.cps.xform.m2m.batch.viatra.patterns.CpsXformM2M
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformation
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformationStatements

import static org.eclipse.viatra.query.runtime.matchers.util.Preconditions.*
import org.eclipse.viatra.transformation.debug.configuration.TransformationDebuggerConfiguration
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Identifiable
import org.eclipse.viatra.examples.cps.traceability.CPS2DeploymentTrace
import org.eclipse.viatra.examples.cps.deployment.BehaviorTransition
import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication
import org.eclipse.viatra.examples.cps.xform.m2m.batch.viatra.patterns.ActionPair
import org.eclipse.viatra.examples.cps.xform.m2m.batch.viatra.patterns.HostInstance
import org.eclipse.viatra.examples.cps.xform.m2m.batch.viatra.patterns.ApplicationInstance
import org.eclipse.viatra.examples.cps.xform.m2m.batch.viatra.patterns.AppInstanceWithStateMachine
import org.eclipse.viatra.examples.cps.xform.m2m.batch.viatra.patterns.State
import org.eclipse.viatra.examples.cps.xform.m2m.batch.viatra.patterns.Transition
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory
import org.eclipse.viatra.examples.cps.deployment.DeploymentFactory
import org.eclipse.viatra.examples.cps.traceability.TraceabilityFactory
import org.eclipse.viatra.examples.cps.deployment.DeploymentHost

class CPS2DeploymentBatchViatra {
	extension Logger logger = Logger.getLogger("cps.xform.m2m.batch.viatra")
    
    /* Transformation-related extensions */

    extension CpsXformM2M cpsXformM2M = CpsXformM2M.instance
    extension BatchTransformation transformation
    extension BatchTransformationStatements statements
    
    extension BatchTransformationRuleFactory = new BatchTransformationRuleFactory
    protected extension DeploymentFactory depFactory = DeploymentFactory.eINSTANCE
    protected extension TraceabilityFactory traceFactory = TraceabilityFactory.eINSTANCE
    
    CPSToDeployment mapping
    ViatraQueryEngine engine
    
    var initialized = false;

    def initialize(CPSToDeployment cps2dep, ViatraQueryEngine engine) {
        initialize(cps2dep, engine, false, null)
    }
    
    def initialize(CPSToDeployment cps2dep, ViatraQueryEngine engine, boolean isDebuggable, String debugName) {
        checkArgument(cps2dep !== null, "Mapping cannot be null!")
        checkArgument(cps2dep.cps !== null, "CPS not defined in mapping!")
        checkArgument(cps2dep.deployment !== null, "Deployment not defined in mapping!")
        checkArgument(engine !== null, "Engine cannot be null!")
        
        if (!initialized) {
            this.mapping = cps2dep
            this.engine = engine
            
            val transformationBuilder = BatchTransformation.forEngine(engine)

            if (isDebuggable) {
                val debuggerConfig = new TransformationDebuggerConfiguration(debugName ?: "CPS2DeploymentBatchViatra")
                transformationBuilder.addAdapterConfiguration(debuggerConfig)
            }

            transformation = transformationBuilder.build
            statements = transformation.transformationStatements
            
            debug("Preparing queries on engine.")
            var watch = Stopwatch.createStarted
            prepare(engine)
            debug('''Prepared queries on engine («watch.elapsed(TimeUnit.MILLISECONDS)» ms''')
            
            debug('''Preparing transformation rules.''')
            watch = Stopwatch.createStarted
            
            debug('''Prepared transformation rules («watch.elapsed(TimeUnit.MILLISECONDS)» ms)''')
            initialized = true
        }
        
    }
    
    def execute(){
        debug('''Executing transformation on: Cyber-physical system: «mapping.cps.identifier»''')
        mapping.traces.clear
        mapping.deployment.hosts.clear
    
        hostRule.fireAllCurrent
        applicationRule.fireAllCurrent
        stateMachineRule.fireAllCurrent
        stateRule.fireAllCurrent
        transitionRule.fireAllCurrent
        actionRule.fireAllCurrent   
    }
    
    
    def dispose(){
        if(transformation !== null){
            transformation.ruleEngine.dispose
        }
        transformation = null
        return
    }
    
    val hostRule = createRule(HostInstance.instance).name("HostRule").action[
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
    val applicationRule = createRule(ApplicationInstance.instance).name("ApplicationRule").action[
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
    val stateMachineRule = createRule(AppInstanceWithStateMachine.instance).name("StateMachineRule").action[
                val cpsApplicationInstance = it.appInstance
                val cpsStateMachine = it.stateMachine
                
                val depApplication = engine.cps2depTrace.getAllValuesOfdepElement(null, null, cpsApplicationInstance).filter(DeploymentApplication).head
                debug('''Mapping state machine with ID: «cpsStateMachine.identifier»''')
                val depBehavior = createDeploymentBehavior => [
                    description = cpsStateMachine.identifier
                ]
                depApplication.behavior = depBehavior
                
                val trace = getTraceForCPSElement(cpsStateMachine)
                if (trace === null){
                    mapping.traces += createCPS2DeploymentTrace => [
                        cpsElements += cpsStateMachine
                        deploymentElements += depBehavior
                    ]
                } else {
                    trace.deploymentElements += depBehavior
                }
                
            ].build
    val stateRule = createRule(State.instance).name("StateRule").action[
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
                if (trace === null) {
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
    val transitionRule = createRule(Transition.instance).name("TransitionRule").action[
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
                if (trace === null){
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
    val actionRule = createRule(ActionPair.instance).name("ActionRule").action[
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
    
    def getTraceForCPSElement(Identifiable cpsElement) {
        engine.cps2depTrace.getAllValuesOftrace(null, cpsElement, null).filter(CPS2DeploymentTrace).head
    }
}