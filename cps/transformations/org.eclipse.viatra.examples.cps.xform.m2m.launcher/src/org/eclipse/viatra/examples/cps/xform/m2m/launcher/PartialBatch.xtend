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
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine
import org.eclipse.viatra.examples.cps.xform.m2m.incr.aggr.CPS2DeploymentPartialBatchTransformation
import org.eclipse.viatra.query.runtime.emf.EMFScope

class PartialBatch extends CPSTransformationWrapper {

	CPS2DeploymentPartialBatchTransformation xform
	AdvancedViatraQueryEngine engine

	override initializeTransformation(CPSToDeployment cps2dep) {
		engine = AdvancedViatraQueryEngine.createUnmanagedEngine(new EMFScope(cps2dep.eResource.resourceSet));
		xform = new CPS2DeploymentPartialBatchTransformation(cps2dep, engine)
	}

	override executeTransformation() {
		xform.execute
	}

	override cleanupTransformation() {
		if(xform !== null){
			xform.dispose
		}
		if (engine !== null) {
			engine.dispose
		}
		engine = null
		xform = null
	}
	
	override isIncremental() {
		true
	}

}
