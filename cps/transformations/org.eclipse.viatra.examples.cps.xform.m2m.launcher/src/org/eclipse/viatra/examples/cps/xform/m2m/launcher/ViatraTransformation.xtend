/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Tamas Borbas, Marton Bur, Zoltan Ujhelyi, Robert Doczi, Daniel Segesdi, Peter Lunk, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

package org.eclipse.viatra.examples.cps.xform.m2m.launcher

import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment
import org.eclipse.viatra.examples.cps.xform.m2m.incr.viatra.CPS2DeploymentTransformationViatra
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine
import org.eclipse.viatra.query.runtime.emf.EMFScope

class ViatraTransformation extends CPSViatraTransformationWrapper {
	
	CPS2DeploymentTransformationViatra xform 
	AdvancedViatraQueryEngine engine
    
    override initializeDebuggableTransformation(CPSToDeployment cps2dep, boolean isDebuggable, String debugName) {
		engine = AdvancedViatraQueryEngine.createUnmanagedEngine(new EMFScope(cps2dep.eResource.resourceSet));
		xform = new CPS2DeploymentTransformationViatra
		xform.initialize(cps2dep, engine, isDebuggable, debugName)
	}
	
	override executeTransformation() {
		
		xform.execute
		debug("VIATRA based Query Result Traceability transformation is incremental")
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
		true
	}
	
}
