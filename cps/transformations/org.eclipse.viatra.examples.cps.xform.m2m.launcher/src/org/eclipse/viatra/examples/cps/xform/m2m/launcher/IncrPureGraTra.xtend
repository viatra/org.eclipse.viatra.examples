/*******************************************************************************
 * Copyright (c) 2014-2019 Geza Kulcsar, Akos Horvath, Abel Hegedus, Tamas Borbas, Marton Bur, Zoltan Ujhelyi, Robert Doczi, Daniel Segesdi, Peter Lunk, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

package org.eclipse.viatra.examples.cps.xform.m2m.launcher

import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine
import org.eclipse.viatra.query.runtime.emf.EMFScope
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.CPS2DeploymentIncrPureGraTra
import org.eclipse.viatra.query.runtime.base.api.BaseIndexOptions

class IncrPureGraTra extends CPSViatraTransformationWrapper {
    
    CPS2DeploymentIncrPureGraTra xform 
    AdvancedViatraQueryEngine engine
    
    override initializeDebuggableTransformation(CPSToDeployment cps2dep, boolean isDebuggable, String debugName) {
        val options = new BaseIndexOptions().withDanglingFreeAssumption(false)
        engine = AdvancedViatraQueryEngine.createUnmanagedEngine(new EMFScope(cps2dep.eResource.resourceSet, options));
        xform = new CPS2DeploymentIncrPureGraTra(cps2dep, engine, isDebuggable, debugName)
    }
    
    override executeTransformation() {
        xform.execute
    }
    
    override cleanupTransformation() {
        if(xform !== null){
            xform.dispose
        }
        if(engine !== null){
            engine.dispose
        }
        xform = null
        engine = null
    }
    
    override isIncremental() {
        false
    }
    
    
}