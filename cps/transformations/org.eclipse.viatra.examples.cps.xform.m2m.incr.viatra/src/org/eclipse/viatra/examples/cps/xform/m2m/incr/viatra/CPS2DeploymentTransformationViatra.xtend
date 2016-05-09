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
package org.eclipse.viatra.examples.cps.xform.m2m.incr.viatra

import com.google.common.base.Stopwatch
import java.util.concurrent.TimeUnit
import org.apache.log4j.Logger
import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment
import org.eclipse.viatra.examples.cps.xform.m2m.incr.viatra.patterns.CpsXformM2M
import org.eclipse.viatra.examples.cps.xform.m2m.incr.viatra.rules.RuleProvider
import org.eclipse.viatra.examples.cps.xform.m2m.incr.viatra.util.PerJobFixedPriorityConflictResolver
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.evm.api.Executor
import org.eclipse.viatra.transformation.evm.api.Scheduler.ISchedulerFactory
import org.eclipse.viatra.transformation.runtime.emf.transformation.eventdriven.EventDrivenTransformation

import static com.google.common.base.Preconditions.*

class CPS2DeploymentTransformationViatra {

    extension Logger logger = Logger.getLogger("cps.xform.m2m.incr.viatra")
    extension CpsXformM2M cpsXformM2M = CpsXformM2M.instance
    extension RuleProvider ruleProvider

    CPSToDeployment cps2dep
    ViatraQueryEngine engine
    EventDrivenTransformation transform
    ISchedulerFactory factory;

    private var initialized = false;

    def initialize(CPSToDeployment cps2dep, ViatraQueryEngine engine) {
        checkArgument(cps2dep != null, "Mapping cannot be null!")
        checkArgument(cps2dep.cps != null, "CPS not defined in mapping!")
        checkArgument(cps2dep.deployment != null, "Deployment not defined in mapping!")
        checkArgument(engine != null, "Engine cannot be null!")

        if (!initialized) {
            this.cps2dep = cps2dep
            this.engine = engine

            debug("Preparing queries on engine.")
            var watch = Stopwatch.createStarted
            prepare(engine)
            info('''Prepared queries on engine («watch.elapsed(TimeUnit.MILLISECONDS)» ms)''')

            info("Preparing transformation rules.")
            watch = Stopwatch.createStarted
            ruleProvider = new RuleProvider(engine, cps2dep)
            createTransformation
            info('''Prepared transformation rules («watch.elapsed(TimeUnit.MILLISECONDS)» ms)''')
            initialized = true
        }
    }

    def execute() {
        debug('''Executing transformation on: Cyber-physical system: «cps2dep.cps.identifier»''')
        if(factory == null){
            transform.executionSchema.startUnscheduledExecution
        }
    }
    
    def setScheduler(ISchedulerFactory factory){
        this.factory = factory
    }
    

    private def createTransformation() {
        val fixedPriorityResolver = new PerJobFixedPriorityConflictResolver
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
         if(factory!=null){
             builder.schedulerFactory = factory
         }
         
         transform = builder.build 
       }

    def dispose() {
        if (transform != null) {
            transform.executionSchema.dispose
        }
        transform = null
        return
    }
}
