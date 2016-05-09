/*******************************************************************************
 * Copyright (c) 2014, 2016, IncQuery Labs Ltd. 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Akos Horvath, Abel Hegedus, Tamas Borbas, Marton Bur, Zoltan Ujhelyi, Robert Doczi, Daniel Segesdi, Peter Lunk - initial API and implementation
 *******************************************************************************/

package org.eclipse.viatra.examples.cps.xform.m2m.tests.mappings

import org.eclipse.viatra.examples.cps.xform.m2m.tests.CPS2DepTest
import org.eclipse.viatra.examples.cps.xform.m2m.tests.wrappers.CPSTransformationWrapper
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

import static org.junit.Assert.*

@RunWith(Parameterized)
class TransformationApiTest extends CPS2DepTest {
	
	new(CPSTransformationWrapper wrapper, String wrapperType) {
		super(wrapper, wrapperType)
	}
	
	@Test(expected = NullPointerException)
	def noMapping() {
		val testId = "noMapping"
		startTest(testId)
		
		initializeTransformation(null)
		
		endTest(testId)
	}
	
	@Test(expected = IllegalArgumentException)
	def nullCPS() {
		val testId = "nullCPS"
		startTest(testId)
		
		val cps2dep = prepareEmptyModel(testId)
		cps2dep.cps = null
		initializeTransformation(cps2dep)
		
		endTest(testId)
	}
	
	@Test(expected = IllegalArgumentException)
	def nullDeployment() {
		val testId = "nullDeployment"
		startTest(testId)
		
		val cps2dep = prepareEmptyModel(testId)
		cps2dep.deployment = null
		initializeTransformation(cps2dep)
		
		endTest(testId)
	}
	
	@Test
	def emptyModel() {
		val testId = "emptyModel"
		startTest(testId)
		
		val cps2dep = prepareEmptyModel(testId)
		initializeTransformation(cps2dep)
		executeTransformation
		
		assertTrue("Empty model modified (traces added)", cps2dep.traces.empty)
		
		endTest(testId)
	}
	

}