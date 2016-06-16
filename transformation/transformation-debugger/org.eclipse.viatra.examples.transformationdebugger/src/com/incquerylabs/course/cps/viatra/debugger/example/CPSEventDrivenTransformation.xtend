/**
 * Copyright (c) 2010-2016, Peter Lunk, IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Peter Lunk - initial API and implementation
 */
package com.incquerylabs.course.cps.viatra.debugger.example

import com.google.common.base.Stopwatch
import com.incquerylabs.course.cps.viatra.debugger.patterns.ViewersPatterns
import com.incquerylabs.course.cps.viatra.debugger.patterns.eventdriven.ApplicationInstanceMatcher
import com.incquerylabs.course.cps.viatra.debugger.patterns.eventdriven.EventDrivenPatterns
import com.incquerylabs.course.cps.viatra.debugger.patterns.eventdriven.HostInstanceMatcher
import java.util.concurrent.TimeUnit
import org.apache.log4j.Logger
import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication
import org.eclipse.viatra.examples.cps.deployment.DeploymentFactory
import org.eclipse.viatra.examples.cps.deployment.DeploymentHost
import org.eclipse.viatra.examples.cps.deployment.DeploymentPackage
import org.eclipse.viatra.examples.cps.traceability.CPS2DeploymentTrace
import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment
import org.eclipse.viatra.examples.cps.traceability.TraceabilityFactory
import org.eclipse.viatra.examples.cps.traceability.TraceabilityPackage
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.query.runtime.emf.EMFScope
import org.eclipse.viatra.transformation.debug.configuration.TransformationDebuggerConfiguration
import org.eclipse.viatra.transformation.evm.specific.Lifecycles
import org.eclipse.viatra.transformation.evm.specific.crud.CRUDActivationStateEnum
import org.eclipse.viatra.transformation.evm.specific.resolver.FixedPriorityConflictResolver
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.SimpleModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.rules.eventdriven.EventDrivenTransformationRule
import org.eclipse.viatra.transformation.runtime.emf.rules.eventdriven.EventDrivenTransformationRuleFactory
import org.eclipse.viatra.transformation.runtime.emf.transformation.eventdriven.EventDrivenTransformation

public class CPSEventDrivenTransformation implements CPSTransformation {
    extension Logger logger = Logger.getLogger("cps.xform.m2m.eventdriven.viatra")

    /* Transformation-related extensions */
    extension EventDrivenPatterns patterns = EventDrivenPatterns.instance
    extension EventDrivenTransformation transformation
    /* Transformation rule-related extensions */
    extension EventDrivenTransformationRuleFactory = new EventDrivenTransformationRuleFactory
    extension IModelManipulations manipulation
    protected extension DeploymentFactory depFactory = DeploymentFactory.eINSTANCE
    protected extension TraceabilityFactory traceFactory = TraceabilityFactory.eINSTANCE
    protected extension DeploymentPackage depPackage = DeploymentPackage::eINSTANCE
    protected extension TraceabilityPackage trPackage = TraceabilityPackage::eINSTANCE

    protected ViatraQueryEngine engine
    protected CPSToDeployment mapping
    protected EventDrivenTransformationRule<?,?> hostRule
    protected EventDrivenTransformationRule<?,?> applicationRule

    new(CPSToDeployment cps2dep) {
        this.mapping = cps2dep
        // Create EMF scope and EMF IncQuery engine based on the loaded model
        val scope = new EMFScope(cps2dep.eResource.getResourceSet())

        engine = ViatraQueryEngine.on(scope);
        manipulation = new SimpleModelManipulations(engine)
        debug("Preparing queries on engine.")
        var watch = Stopwatch.createStarted
        prepare(engine)

        ViewersPatterns.instance.prepare(engine)

        engine.getMatcher(ViewersPatterns.instance.hostTypeViewers)
        engine.getMatcher(ViewersPatterns.instance.hostInstanceViewers)
        engine.getMatcher(ViewersPatterns.instance.appInstanceViewers)
        engine.getMatcher(ViewersPatterns.instance.hostTypeInstanceLinkViewers)
        engine.getMatcher(ViewersPatterns.instance.hostAppLinkViewers)
        engine.getMatcher(ViewersPatterns.instance.deploymentHostViewers)
        engine.getMatcher(ViewersPatterns.instance.deploymentAppViewers)
        engine.getMatcher(ViewersPatterns.instance.traceRelationViewers)
        info('''Prepared queries on engine («watch.elapsed(TimeUnit.MILLISECONDS)» ms)''')

        info("Preparing transformation rules.")
        watch = Stopwatch.createStarted
        createTransformation
        info('''Prepared transformation rules («watch.elapsed(TimeUnit.MILLISECONDS)» ms)''')
    }

    override execute() {
        transformation.executionSchema.startUnscheduledExecution
    }

    // Dispose model transformation
    override dispose() {
        if (transformation != null) {
            transformation.dispose
        }
        transformation = null
        return
    }

    // Create a conflict resolver that establishes a priority order among transformation rules
    private def FixedPriorityConflictResolver createConflictResolver() {
        val resolver = new PerJobFixedPriorityConflictResolver
        resolver.setPriority(getHostRule.ruleSpecification, 1)
        resolver.setPriority(getApplicationRule.ruleSpecification, 2)
        return resolver
    }

    private def createTransformation() {
        transformation = EventDrivenTransformation.forEngine(engine).setConflictResolver(createConflictResolver).
            addRule(getHostRule).addRule(getApplicationRule) // Create a debug adapter
            .addAdapterConfiguration(new TransformationDebuggerConfiguration())
            .build
    }

    public def getHostRule() {
        if (hostRule == null) {
            hostRule = createRule.name("Host_Rule").precondition(HostInstanceMatcher.querySpecification).action(
                CRUDActivationStateEnum.CREATED) [
                debug('''Mapping host with IP: «hostInstance.nodeIp»''')

                val deploymentHost = mapping.deployment.createChild(deployment_Hosts, deploymentHost)
                deploymentHost.set(deploymentHost_Ip, hostInstance.nodeIp)

                val hostTrace = mapping.createChild(CPSToDeployment_Traces, CPS2DeploymentTrace)
                hostTrace.addTo(CPS2DeploymentTrace_CpsElements, hostInstance)
                hostTrace.addTo(CPS2DeploymentTrace_DeploymentElements, deploymentHost)

            ].action(CRUDActivationStateEnum.UPDATED) [
                val depHost = engine.cps2depTrace.getOneArbitraryMatch(mapping, null, hostInstance, null).
                    depElement as DeploymentHost
                debug('''Updating mapped host with IP: «depHost.ip»''')
                depHost.set(deploymentHost_Ip, hostInstance.nodeIp)
                debug('''Updated mapped host with IP: «depHost.ip»''')
            ].action(CRUDActivationStateEnum.DELETED) [
                val traceMatch = engine.cps2depTrace.getOneArbitraryMatch(mapping, null, hostInstance, null)
                logger.debug('''Removing host with IP: «hostInstance.nodeIp»''')
                mapping.deployment.remove(deployment_Hosts, traceMatch.depElement)
                mapping.remove(CPSToDeployment_Traces, traceMatch.trace)
                logger.debug('''Removed host with IP: «hostInstance.nodeIp»''')
            ].addLifeCycle(Lifecycles.getDefault(true, true)).build
        }
        return hostRule
    }

    public def getApplicationRule() {
        if (applicationRule == null) {
            applicationRule = createRule.name("App_Rule").precondition(ApplicationInstanceMatcher.querySpecification).
                action(CRUDActivationStateEnum.CREATED) [
                    val depHost = engine.cps2depTrace.getAllValuesOfdepElement(null, null, appInstance.allocatedTo).
                        filter(DeploymentHost).head
                    debug('''Mapping application with ID: «appInstance.identifier»''')
                    val deploymentApplication = depHost.createChild(deploymentHost_Applications, deploymentApplication)
                    deploymentApplication.set(deploymentApplication_Id, appInstance.identifier)

                    val hostTrace = mapping.createChild(CPSToDeployment_Traces, CPS2DeploymentTrace)
                    hostTrace.addTo(CPS2DeploymentTrace_CpsElements, appInstance)
                    hostTrace.addTo(CPS2DeploymentTrace_DeploymentElements, deploymentApplication)
                    debug('''Mapped application with ID: «appInstance.identifier»''')
                ].action(CRUDActivationStateEnum.UPDATED) [
                    val depApp = engine.cps2depTrace.getOneArbitraryMatch(mapping, null, appInstance, null).
                        depElement as DeploymentApplication
                    if (depApp.id != appInstance.identifier)
                        depApp.set(deploymentApplication_Id, appInstance.identifier)
                ].action(CRUDActivationStateEnum.DELETED) [
                    val trace = engine.cps2depTrace.getAllValuesOftrace(null, appInstance, null).
                        head as CPS2DeploymentTrace
                    val depApp = trace.deploymentElements.head as DeploymentApplication
                    engine.allocatedDeploymentApplication.getAllValuesOfdepHost(depApp).head.remove(
                        deploymentHost_Applications, depApp)
                    mapping.remove(CPSToDeployment_Traces, trace)
                ].addLifeCycle(Lifecycles.getDefault(true, true)).build
        }
        return applicationRule
    }
}
