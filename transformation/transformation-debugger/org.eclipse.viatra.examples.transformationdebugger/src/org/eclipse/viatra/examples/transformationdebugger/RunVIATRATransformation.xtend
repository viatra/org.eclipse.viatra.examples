/*******************************************************************************
 * Copyright (c) 2010-2016, Peter Lunk, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.transformationdebugger

import org.eclipse.viatra.examples.transformationdebugger.example.CPSBatchTransformation
import org.eclipse.viatra.examples.transformationdebugger.example.CPSEventDrivenTransformation
import org.eclipse.viatra.examples.transformationdebugger.example.CPSModelInitializer
import org.eclipse.viatra.examples.transformationdebugger.example.CPSTransformation
import org.junit.Test

class RunVIATRATransformation {
	extension CPSTransformation transformation

	@Test
	def void runEventDrivenTransformation() {
		//Load the CPS model
		val init = new CPSModelInitializer()
		val cps2dep = init.loadModel("output/example.cyberphysicalsystem")
		
		//Initialize CPS to Deployment Transformation 
		transformation = new CPSEventDrivenTransformation(cps2dep)
		//Execute the transformation and observe the effects of the selected adapter
		transformation.execute
	}
	
	@Test
    def void runBatchTransformation() {
        //Load the CPS model
        val init = new CPSModelInitializer()
        val cps2dep = init.loadModel("output/example.cyberphysicalsystem")
        
        //Initialize CPS to Deployment Transformation 
        transformation = new CPSBatchTransformation(cps2dep)
        //Execute the transformation and observe the effects of the selected adapter
        transformation.execute
    }

}
