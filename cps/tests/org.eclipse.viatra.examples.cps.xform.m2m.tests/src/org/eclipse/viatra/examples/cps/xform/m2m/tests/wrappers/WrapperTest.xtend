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

package org.eclipse.viatra.examples.cps.xform.m2m.tests.wrappers

import org.apache.log4j.Logger
import org.eclipse.viatra.examples.cps.generator.utils.CPSModelBuilderUtil
import org.eclipse.viatra.examples.cps.tests.CPSTestBase
import org.eclipse.viatra.examples.cps.xform.m2m.incr.expl.CPS2DeploymentTransformation
import org.junit.Test

class WrapperTest extends CPSTestBase {
	protected extension Logger logger = Logger.getLogger("cps.xform.WrapperTest")
	
	@Test(expected = IllegalArgumentException)
	def explicitTraceabilityNullEngine() {
		
		val testId = "explicitTraceabilityNullEngine"
		info("START TEST: " + testId)
		
		val xform = new CPS2DeploymentTransformation
		val cps2dep = new CPSModelBuilderUtil().prepareEmptyModel(testId)
		xform.initialize(cps2dep, null)
		
		info("END TEST: " + testId)
	}
	
}
