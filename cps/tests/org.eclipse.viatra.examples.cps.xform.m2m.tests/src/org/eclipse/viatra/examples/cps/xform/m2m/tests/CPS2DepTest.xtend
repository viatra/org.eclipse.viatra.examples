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

package org.eclipse.viatra.examples.cps.xform.m2m.tests

import com.google.common.collect.ImmutableSet
import org.eclipse.viatra.examples.cps.tests.PropertiesUtil
import org.eclipse.viatra.examples.cps.xform.m2m.tests.wrappers.CPSTransformationWrapper
import org.eclipse.viatra.examples.cps.xform.m2m.tests.wrappers.TransformationType
import org.junit.runners.Parameterized.Parameters

class CPS2DepTest extends CPS2DepTestWithoutParameters {

	new(CPSTransformationWrapper wrapper, String wrapperType) {
		super(wrapper, wrapperType)
	}
	
	@Parameters(name = "{index}: {1}")
    public static def transformations() {
        
		xforms.map[
			#[it.wrapper, it.name].toArray
		]
    }
    
    static def getXforms() {
		val xformsBuilder = ImmutableSet.builder
		TransformationType.values.forEach[xformsBuilder.add(it)]
        val allXforms = xformsBuilder.build
		val disabledXforms = PropertiesUtil.disabledM2MTransformations
		
		return allXforms.filter[!disabledXforms.contains(it.name)].toSet
	}
}
