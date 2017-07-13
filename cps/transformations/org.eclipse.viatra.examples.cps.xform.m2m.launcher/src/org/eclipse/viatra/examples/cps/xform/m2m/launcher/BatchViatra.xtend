/*******************************************************************************
 * Copyright (c) 2014-2016, IncQuery Labs Ltd. 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Akos Horvath, Abel Hegedus, Tamas Borbas, Marton Bur, Zoltan Ujhelyi, Robert Doczi, Daniel Segesdi, Peter Lunk - initial API and implementation
 *******************************************************************************/

package org.eclipse.viatra.examples.cps.xform.m2m.launcher

import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment
import org.eclipse.viatra.examples.cps.xform.m2m.batch.viatra.CPS2DeploymentBatchViatra
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine
import org.eclipse.viatra.query.runtime.emf.EMFScope

class BatchViatra extends CPSViatraTransformationWrapper {
	
	CPS2DeploymentBatchViatra xform 
	AdvancedViatraQueryEngine engine
    
    override initializeDebuggableTransformation(CPSToDeployment cps2dep, boolean isDebuggable, String debugName) {
        engine = AdvancedViatraQueryEngine.createUnmanagedEngine(new EMFScope(cps2dep.eResource.resourceSet));
        xform = new CPS2DeploymentBatchViatra
        xform.initialize(cps2dep, engine, isDebuggable, debugName)
    }
	
	override executeTransformation() {
		xform.execute
	}
	
	override cleanupTransformation() {
		if(xform != null){
			xform.dispose
		}
		if(engine != null){
			engine.dispose
		}
		xform = null
		engine = null
	}
	
	override isIncremental() {
		false
	}
	
}
