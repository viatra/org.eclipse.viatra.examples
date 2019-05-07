/*******************************************************************************
 * Copyright (c) 2014-2019 Geza Kulcsar, Akos Horvath, Abel Hegedus, Zoltan Ujhelyi, Daniel Segesdi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

package org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries

import org.eclipse.viatra.examples.cps.deployment.DeploymentBehavior
import org.eclipse.viatra.examples.cps.deployment.DeploymentFactory
import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment
import org.eclipse.viatra.examples.cps.traceability.TraceabilityFactory
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.debug.configuration.TransformationDebuggerConfiguration
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.SimpleModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformation
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformation.BatchTransformationBuilder
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformationStatements

import static org.eclipse.viatra.query.runtime.matchers.util.Preconditions.*

class CPS2DeploymentIncrPureGraTra {
    val extension CpsXformM2M cpsXformM2M = CpsXformM2M.instance
    val CPSToDeployment cps2dep

    /** EMF metamodels **/
    protected extension DeploymentFactory depFactory = DeploymentFactory.eINSTANCE
    protected extension TraceabilityFactory traceFactory = TraceabilityFactory.eINSTANCE

    /* Transformation-related extensions */
    extension BatchTransformation transformation
    extension BatchTransformationStatements statements

    /* Transformation rule-related extensions */
    extension BatchTransformationRuleFactory = new BatchTransformationRuleFactory
    extension IModelManipulations manipulation

    protected ViatraQueryEngine engine
    
    new(CPSToDeployment cps2dep, ViatraQueryEngine engine, boolean isDebuggable, String debugName) {
        checkArgument(cps2dep !== null, "Mapping cannot be null!")
        checkArgument(cps2dep.cps !== null, "CPS not defined in mapping!")
        checkArgument(cps2dep.deployment !== null, "Deployment not defined in mapping!")
        checkArgument(engine !== null, "Engine cannot be null!")
        
        this.cps2dep = cps2dep
        this.engine = engine
        prepare(engine)
        
        createTransformation(isDebuggable, debugName)
    }
    
    def void execute() {
        fireWhilePossible
    }

    private def void createTransformation(boolean isDebuggable, String debugName) {
        // Create VIATRA model manipulations
        this.manipulation = new SimpleModelManipulations(engine)
        // Create VIATRA Batch transformation
        val transformationBuilder = BatchTransformation.forEngine(engine)

        if (isDebuggable) {
            val debuggerConfig = new TransformationDebuggerConfiguration(debugName ?:
                "CPS2DeploymentTransformationViatra")
            transformationBuilder.addAdapterConfiguration(debuggerConfig)
        }

        transformation = transformationBuilder
            .addHostRules
            .addApplicationInstanceRules
            .addStateMachineRules
            .addStateRules
            .addTransitionRules
            .addActionMappingRules
            .addRule(createRule(danglingCps2DepTrace).name("DanglingTraceRule").action [
                    // This rule is necessary to remove traces whose deployment element was
                    // already removed (e.g. because of the removal of their containers)
                    cps2dep.traces -= trace
                ].build)
            .addRule(createRule(renamedElement).name("ChangeApplicationIdRule").action [
                depElement.description = expectedId
            ].build).build

        statements = transformation.transformationStatements
    }

    private def addHostRules(BatchTransformationBuilder transformationBuilder) {
        transformationBuilder.addRule(createRule(hostInstance).name("HostRule").action [
            val hostInstance = it.hostInstance;
            val nodeIp = hostInstance.nodeIp;

            val depHost = createDeploymentHost => [ip = nodeIp;]

            cps2dep.deployment.hosts += depHost
            cps2dep.traces += createCPS2DeploymentTrace => [
                cpsElements += hostInstance
                deploymentElements += depHost
            ]
        ].build).addRule(createRule(changeHostIp).name("ChangeHostIpRule").action [
            depHost.ip = hostInstance.nodeIp
        ].build).addRule(createRule(missingDepHost).name("HostRuleDel").action [
            depHost.remove
            trace.remove
        ].build)
    }

    private def addApplicationInstanceRules(BatchTransformationBuilder transformationBuilder) {
        transformationBuilder.addRule(createRule(appInstanceWithDepHost).name("ApplicationRule").action [
            val appInstance = it.appInstance
            val depApp = createDeploymentApplication

            depHost.applications += depApp

            cps2dep.traces += createCPS2DeploymentTrace => [
                cpsElements += appInstance
                deploymentElements += depApp
            ]
        ].build).addRule(createRule(appInstanceWithChangedHost).name("ReallocAppRule").action [
            depHost1.applications -= depApp
            depHost2.applications += depApp

        ].build).addRule(createRule(missingAppInstance).name("AppRuleDel").action [
            depApp.remove
            trace.remove

        ].build).addRule(createRule(missingHostForAppInstance).name("AppRuleMissingHostDel").action [
            appInstance.remove
            depApp.remove
            trace.remove

        ].build).addRule(createRule(renamedApplication).name("ChangeApplicationIdRule").action [
            depApplication.id = expectedId
        ].build)
    }

    private def addStateMachineRules(BatchTransformationBuilder transformationBuilder) {
        transformationBuilder.addRule(
            createRule(appInstanceWithStateMachine_noTrace).name("StateMachineNoTraceRule").action [
                val sm = it.stateMachine
                val depBehavior = createDeploymentBehavior
                depApp.behavior = depBehavior

                cps2dep.traces += createCPS2DeploymentTrace => [
                    cpsElements += sm
                    deploymentElements += depBehavior
                ]
            ].build).addRule(
            createRule(appInstanceWithStateMachine_withTrace).name("StateMachineWithTraceRule").action [
                val depBehavior = createDeploymentBehavior
                depApp.behavior = depBehavior
                trace.deploymentElements += depBehavior
            ].build).addRule(createRule(stateMachineDel).name("StateMachineDel").action [
            depBehavior.remove
            trace.remove
        ].build)
    }

    private def addStateRules(BatchTransformationBuilder transformationBuilder) {
        transformationBuilder.addRule(createRule(appInstanceWithState_noTrace).name("StateNoTraceRule").action [
            val state = it.state
            val behState = createBehaviorState

            depBehavior.states += behState

            cps2dep.traces += createCPS2DeploymentTrace => [
                cpsElements += state
                deploymentElements += behState
            ]
        ].build).addRule(createRule(appInstanceWithState_withTrace).name("StateWithTraceRule").action [
            val behState = createBehaviorState
            depBehavior.states += behState
            trace.deploymentElements += behState
        ].build).addRule(createRule(incorrectlyMappedInitialState).name("InitialStateRule").action [
            depBehavior.current = expectedCurrentState
        ].build).addRule(createRule(incorrectlyMappedUnsetInitialState).name("UnsetInitialStateRule").action [
            depBehavior.current = null
        ].build).addRule(createRule(stateDel).name("StateDel").action [
            val depBehavior = behState.eContainer as DeploymentBehavior
            if (depBehavior.current == behState) {
                depBehavior.current = null
            }

            behState.remove
            trace.remove
        ].build)
    }

    private def addTransitionRules(BatchTransformationBuilder transformationBuilder) {
        transformationBuilder.addRule(createRule(transition_noTrace).name("TransitionNoTraceRule").action [
            val transition = it.transition
            val behTransition = createBehaviorTransition
            depBehavior.transitions += behTransition
            depSource.outgoing += behTransition

            behTransition.to = depTarget

            cps2dep.traces += createCPS2DeploymentTrace => [
                cpsElements += transition
                deploymentElements += behTransition
            ]
        ].build).addRule(createRule(transition_withTrace).name("TransitionWithTraceRule").action [
            val behTransition = createBehaviorTransition
            depBehavior.transitions += behTransition
            depSource.outgoing += behTransition

            behTransition.to = depTarget

            trace.deploymentElements += behTransition
        ].build).addRule(createRule(transitionWithMovedSource).name("TransitionWithTraceRule").action [
            depBehavior.transitions += behTransition
            expectedSource.outgoing += behTransition
            actualSource.outgoing -= behTransition
        ].build).addRule(createRule(transitionWithMovedTarget).name("TransitionWithTraceRule").action [
            behTransition.to = expectedTarget
        ].build).addRule(createRule(transitionDel).name("TransitionDel").action [
            behTransition.remove
            trace.remove
        ].build)
    }

    private def addActionMappingRules(BatchTransformationBuilder transformationBuilder) {
        transformationBuilder.addRule(createRule(behTriggerPair).name("TriggerRule").action [
            behTrigger.trigger += behTarget
        ].build).addRule(createRule(behTriggerToRemove).name("TriggerRemoval").action [
            behTrigger.trigger -= behTarget
        ].build).addRule(createRule(behTriggerToBeRemoved).name("DanglingTriggerRule").action [
            behTrigger.trigger -= behTarget
        ].build)
    }

    def void dispose() {
        if (transformation !== null) {
            transformation.ruleEngine.dispose
            transformation = null
        }
    }
}