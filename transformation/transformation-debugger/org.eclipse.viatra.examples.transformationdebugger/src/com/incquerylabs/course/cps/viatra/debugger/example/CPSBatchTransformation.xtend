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
import com.incquerylabs.course.cps.viatra.debugger.patterns.batch.ApplicationInstanceMatch
import com.incquerylabs.course.cps.viatra.debugger.patterns.batch.ApplicationInstanceMatcher
import com.incquerylabs.course.cps.viatra.debugger.patterns.batch.BatchPatterns
import com.incquerylabs.course.cps.viatra.debugger.patterns.batch.HostInstanceMatch
import com.incquerylabs.course.cps.viatra.debugger.patterns.batch.HostInstanceMatcher
import java.util.concurrent.TimeUnit
import org.apache.log4j.Logger
import org.eclipse.viatra.examples.cps.deployment.DeploymentFactory
import org.eclipse.viatra.examples.cps.deployment.DeploymentHost
import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment
import org.eclipse.viatra.examples.cps.traceability.TraceabilityFactory
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.query.runtime.emf.EMFScope
import org.eclipse.viatra.transformation.debug.configuration.TransformationDebuggerConfiguration
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.SimpleModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRule
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformation
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformationStatements

class CPSBatchTransformation implements CPSTransformation {
    extension Logger logger = Logger.getLogger("cps.xform.m2m.batch.viatra")

    /* Transformation-related extensions */
    extension BatchPatterns patterns = BatchPatterns.instance
    extension BatchTransformation transformation
    extension BatchTransformationStatements statements
    /* Transformation rule-related extensions */
    extension BatchTransformationRuleFactory = new BatchTransformationRuleFactory
    extension IModelManipulations manipulation
    protected extension DeploymentFactory depFactory = DeploymentFactory.eINSTANCE
    protected extension TraceabilityFactory traceFactory = TraceabilityFactory.eINSTANCE

    protected CPSToDeployment mapping
    protected ViatraQueryEngine engine

    protected BatchTransformationRule<HostInstanceMatch, HostInstanceMatcher> hostRule
    protected BatchTransformationRule<ApplicationInstanceMatch, ApplicationInstanceMatcher> applicationRule
    protected BatchTransformationRule<ApplicationInstanceMatch, ApplicationInstanceMatcher> applicationDummyRule

    new(CPSToDeployment cps2dep) {
        this.mapping = cps2dep
        // Create EMF scope and EMF IncQuery engine based on the loaded model
        val scope = new EMFScope(cps2dep.eResource.getResourceSet())

        engine = ViatraQueryEngine.on(scope);

        debug("Preparing queries on engine.")
        var watch = Stopwatch.createStarted
        prepare(engine)
        ViewersPatterns.instance.prepare(engine)


        info('''Prepared queries on engine («watch.elapsed(TimeUnit.MILLISECONDS)» ms)''')

        info("Preparing transformation rules.")
        watch = Stopwatch.createStarted
        createTransformation
        info('''Prepared transformation rules («watch.elapsed(TimeUnit.MILLISECONDS)» ms)''')

    }

    override execute() {
        debug('''Executing transformation on: Cyber-physical system: «mapping.cps.identifier»''')
        mapping.traces.clear
        mapping.deployment.hosts.clear

        getHostRule.fireAllCurrent
        getApplicationRule.fireAllCurrent
    }

    private def createTransformation() {
        this.manipulation = new SimpleModelManipulations(engine)
        transformation = BatchTransformation.forEngine(engine).addAdapterConfiguration(
            new TransformationDebuggerConfiguration()).build
        statements = transformation.transformationStatements
    }

    private def getHostRule() {
        if (hostRule == null) {
            hostRule = createRule.name("HostRule").precondition(HostInstanceMatcher.querySpecification).action [
                getApplicationDummyRule.fireAllCurrent
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
        return hostRule;
    }

    private def getApplicationRule() {
        if (applicationRule == null) {
            applicationRule = createRule.name("AppRule").precondition(ApplicationInstanceMatcher.querySpecification).
                action [

                    val cpsApplicationInstance = it.appInstance
                    val appId = it.appInstance.identifier

                    val cpsHostInstance = cpsApplicationInstance.allocatedTo
                    val depHost = engine.cps2depTrace.getAllValuesOfdepElement(null, null, cpsHostInstance).filter(
                        DeploymentHost).head

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
        return applicationRule;
    }

    private def getApplicationDummyRule() {
        if (applicationDummyRule == null) {
            applicationDummyRule = createRule.name("AppDUMMYRule").precondition(
                ApplicationInstanceMatcher.querySpecification).action [
                // Do nothing
            ].build
        }
        return applicationDummyRule
    }

    override dispose() {
        if (transformation != null) {
            transformation.dispose
        }
        transformation = null
        return
    }
}
