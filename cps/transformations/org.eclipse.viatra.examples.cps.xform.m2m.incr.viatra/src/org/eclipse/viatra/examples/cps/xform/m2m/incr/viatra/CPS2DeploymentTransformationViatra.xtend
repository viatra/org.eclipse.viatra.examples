/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Zoltan Ujhelyi, Peter Lunk, Istvan David, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2m.incr.viatra

import com.google.common.base.Stopwatch
import java.util.concurrent.TimeUnit
import org.apache.log4j.Logger
import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment
import org.eclipse.viatra.examples.cps.xform.m2m.incr.viatra.patterns.CpsXformM2M
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.evm.api.Scheduler.ISchedulerFactory
import org.eclipse.viatra.transformation.runtime.emf.transformation.eventdriven.EventDrivenTransformation

import static org.eclipse.viatra.query.runtime.matchers.util.Preconditions.*
import org.eclipse.viatra.transformation.debug.configuration.TransformationDebuggerConfiguration
import org.eclipse.viatra.transformation.evm.specific.resolver.InvertedDisappearancePriorityConflictResolver
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations
import org.eclipse.viatra.examples.cps.deployment.DeploymentPackage
import org.eclipse.viatra.examples.cps.traceability.TraceabilityPackage
import org.eclipse.viatra.transformation.runtime.emf.rules.eventdriven.EventDrivenTransformationRuleFactory
import org.eclipse.viatra.transformation.evm.specific.crud.CRUDActivationStateEnum
import org.eclipse.viatra.examples.cps.deployment.BehaviorTransition
import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication
import org.eclipse.viatra.transformation.evm.specific.Lifecycles
import org.eclipse.viatra.examples.cps.xform.m2m.incr.viatra.patterns.TriggerPair
import org.eclipse.viatra.examples.cps.xform.m2m.incr.viatra.patterns.Transition
import org.eclipse.viatra.examples.cps.xform.m2m.incr.viatra.patterns.State
import org.eclipse.viatra.examples.cps.deployment.DeploymentBehavior
import org.eclipse.viatra.examples.cps.xform.m2m.incr.viatra.patterns.StateMachine
import org.eclipse.viatra.examples.cps.deployment.DeploymentHost
import org.eclipse.viatra.examples.cps.xform.m2m.incr.viatra.patterns.ApplicationInstance
import org.eclipse.viatra.examples.cps.xform.m2m.incr.viatra.patterns.HostInstance
import org.eclipse.viatra.examples.cps.deployment.BehaviorState
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.SimpleModelManipulations

class CPS2DeploymentTransformationViatra {

    extension Logger logger = Logger.getLogger("cps.xform.m2m.incr.viatra")
    extension CpsXformM2M cpsXformM2M = CpsXformM2M.instance

    extension IModelManipulations manipulation
    extension DeploymentPackage depPackage = DeploymentPackage::eINSTANCE
    extension TraceabilityPackage trPackage = TraceabilityPackage::eINSTANCE
    extension EventDrivenTransformationRuleFactory ruleFactory = new EventDrivenTransformationRuleFactory

    CPSToDeployment cps2dep
    ViatraQueryEngine engine
    EventDrivenTransformation transform
    ISchedulerFactory factory;

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
            this.cps2dep = cps2dep
            this.engine = engine

            debug("Preparing queries on engine.")
            var watch = Stopwatch.createStarted
            prepare(engine)
            manipulation = new SimpleModelManipulations(engine)
            info('''Prepared queries on engine («watch.elapsed(TimeUnit.MILLISECONDS)» ms)''')

            info("Preparing transformation rules.")
            watch = Stopwatch.createStarted
            createTransformation(isDebuggable, debugName)
            info('''Prepared transformation rules («watch.elapsed(TimeUnit.MILLISECONDS)» ms)''')
            initialized = true
        }
    }

    def execute() {
        debug('''Executing transformation on: Cyber-physical system: «cps2dep.cps.identifier»''')
        if(factory === null){
            transform.executionSchema.startUnscheduledExecution
        }
    }
    
    def setScheduler(ISchedulerFactory factory){
        this.factory = factory
    }
    

    private def createTransformation(boolean isDebuggable, String debugName) {
        val fixedPriorityResolver = new InvertedDisappearancePriorityConflictResolver
        fixedPriorityResolver.setPriority(hostRule.ruleSpecification, 1)
        fixedPriorityResolver.setPriority(applicationRule.ruleSpecification, 2)
        fixedPriorityResolver.setPriority(stateMachineRule.ruleSpecification, 3)
        fixedPriorityResolver.setPriority(stateRule.ruleSpecification, 4)
        fixedPriorityResolver.setPriority(transitionRule.ruleSpecification, 5)
        fixedPriorityResolver.setPriority(triggerRule.ruleSpecification, 6)

        val builder =  EventDrivenTransformation.forEngine(engine)
             .setConflictResolver(fixedPriorityResolver)
             .addRule(hostRule)
             .addRule(applicationRule)
             .addRule(stateMachineRule)
             .addRule(stateRule)
             .addRule(transitionRule)
             .addRule(triggerRule)
        if (factory !== null) {
            builder.schedulerFactory = factory
        }
        if (isDebuggable) {
            val debuggerConfig = new TransformationDebuggerConfiguration(debugName ?:
                "CPS2DeploymentTransformationViatra")
            builder.addAdapterConfiguration(debuggerConfig)
        }

        transform = builder.build
    }

    def dispose() {
        if (transform !== null) {
            transform.executionSchema.dispose
        }
        transform = null
        return
    }
    
    val hostRule = createRule(HostInstance.instance).name("HostRule").action(
                CRUDActivationStateEnum.CREATED) [  
                debug('''Mapping host with IP: «hostInstance.nodeIp»''')
            
                val deploymentHost = cps2dep.deployment.createChild(deployment_Hosts, deploymentHost)
                deploymentHost.set(deploymentHost_Ip, hostInstance.nodeIp)
                
                val hostTrace = cps2dep.createChild(CPSToDeployment_Traces, CPS2DeploymentTrace)
                hostTrace.addTo(CPS2DeploymentTrace_CpsElements, hostInstance)
                hostTrace.addTo(CPS2DeploymentTrace_DeploymentElements, deploymentHost)
                
            ].action(CRUDActivationStateEnum.UPDATED) [
                // Optional.get should be always work here
                val depHost = engine.cps2depTrace.getOneArbitraryMatch(cps2dep, null, hostInstance, null).get.depElement as DeploymentHost
                debug('''Updating mapped host with IP: «depHost.ip»''')
                depHost.set(deploymentHost_Ip, hostInstance.nodeIp)
                debug('''Updated mapped host with IP: «depHost.ip»''')
            ].action(CRUDActivationStateEnum.DELETED) [
                engine.cps2depTrace.getOneArbitraryMatch(cps2dep, null, hostInstance, null).ifPresent[traceMatch |
                        logger.debug('''Removing host with IP: «hostInstance.nodeIp»''')
                        cps2dep.deployment.remove(deployment_Hosts, traceMatch.depElement)
                        cps2dep.remove(CPSToDeployment_Traces, traceMatch.trace)
                        logger.debug('''Removed host with IP: «hostInstance.nodeIp»''')
                ]
            ].addLifeCycle(Lifecycles.getDefault(true, true))
            .build
    val applicationRule = createRule(ApplicationInstance.instance).name("ApplicationRule").action(
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
                val depApp = engine.cps2depTrace.getOneArbitraryMatch(cps2dep, null, appInstance, null).get.depElement as DeploymentApplication
                if (depApp.id != appInstance.identifier)
                    depApp.set(deploymentApplication_Id, appInstance.identifier)
            ].action(CRUDActivationStateEnum.DELETED) [
                val trace = engine.cps2depTrace.getAllValuesOftrace(null, appInstance, null).head
                val depApp = trace.deploymentElements.head as DeploymentApplication
                engine.allocatedDeploymentApplication.getAllValuesOfdepHost(depApp).head.remove(deploymentHost_Applications, depApp)
                cps2dep.remove(CPSToDeployment_Traces, trace)
            ].addLifeCycle(Lifecycles.getDefault(true, true))
            .build
    val stateMachineRule = createRule(StateMachine.instance).name("StateMachineRule").action(
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
            ].addLifeCycle(Lifecycles.getDefault(true, true))
            .build
    val stateRule = createRule(State.instance).name("StateRule").action(
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
                if (depBehavior !== null) {
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
            ].addLifeCycle(Lifecycles.getDefault(true, true))
            .build
    val transitionRule = createRule(Transition.instance).name("TransitionRule").action(
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
            ].addLifeCycle(Lifecycles.getDefault(true, true))
            .build
    val triggerRule = createRule(TriggerPair.instance).name("TriggerRule").action(
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
            ].addLifeCycle(Lifecycles.getDefault(true, true))
            .build
    
}
