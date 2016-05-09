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
package org.eclipse.viatra.examples.cps.xform.m2m.batch.viatra

import com.google.common.base.Stopwatch
import java.util.concurrent.TimeUnit
import org.apache.log4j.Logger
import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment
import org.eclipse.viatra.examples.cps.xform.m2m.batch.viatra.patterns.CpsXformM2M
import org.eclipse.viatra.examples.cps.xform.m2m.batch.viatra.rules.RuleProvider
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformation
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformationStatements

import static com.google.common.base.Preconditions.*

class CPS2DeploymentBatchViatra {
	extension Logger logger = Logger.getLogger("cps.xform.m2m.batch.viatra")
    
    /* Transformation-related extensions */

    extension CpsXformM2M cpsXformM2M = CpsXformM2M.instance
    extension RuleProvider ruleProvider
    extension BatchTransformation transformation
    extension BatchTransformationStatements statements
    
    CPSToDeployment mapping
    ViatraQueryEngine engine
    
    private var initialized = false;

    def initialize(CPSToDeployment cps2dep, ViatraQueryEngine engine) {
        checkArgument(cps2dep != null, "Mapping cannot be null!")
        checkArgument(cps2dep.cps != null, "CPS not defined in mapping!")
        checkArgument(cps2dep.deployment != null, "Deployment not defined in mapping!")
        checkArgument(engine != null, "Engine cannot be null!")
        
        if (!initialized) {
            this.mapping = cps2dep
            this.engine = engine
            ruleProvider = new RuleProvider(engine, cps2dep)
            
            transformation = BatchTransformation.forEngine(engine).build
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
        if(transformation != null){
            transformation.ruleEngine.dispose
        }
        transformation = null
        return
    }
}