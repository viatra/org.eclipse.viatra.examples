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
import org.eclipse.viatra.examples.cps.xform.m2m.incr.qrt.CPS2DeploymentTransformationQrt
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine
import org.eclipse.viatra.query.runtime.emf.EMFScope

class QueryResultTraceability extends CPSTransformationWrapper {
	
	CPS2DeploymentTransformationQrt xform 
	AdvancedViatraQueryEngine engine
	
	override initializeTransformation(CPSToDeployment cps2dep) {
		engine = AdvancedViatraQueryEngine.createUnmanagedEngine(new EMFScope(cps2dep.eResource.resourceSet));
		xform = new CPS2DeploymentTransformationQrt
		xform.initialize(cps2dep, engine)
	}
	
	override executeTransformation() {
		xform.execute
		debug("Query Result Traceability transformation is incremental")
	}
	
	override cleanupTransformation() {
		if(xform !== null){
			xform.dispose
		}
		if(engine !== null){
			engine.dispose
		}
		engine = null
		xform = null
	}
	
	override isIncremental() {
		true
	}
	
}
