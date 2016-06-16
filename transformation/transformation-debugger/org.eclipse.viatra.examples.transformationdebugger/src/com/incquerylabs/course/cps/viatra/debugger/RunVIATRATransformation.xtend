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
package com.incquerylabs.course.cps.viatra.debugger

import com.incquerylabs.course.cps.viatra.debugger.example.CPSBatchTransformation
import com.incquerylabs.course.cps.viatra.debugger.example.CPSEventDrivenTransformation
import com.incquerylabs.course.cps.viatra.debugger.example.CPSModelInitializer
import com.incquerylabs.course.cps.viatra.debugger.example.CPSTransformation
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