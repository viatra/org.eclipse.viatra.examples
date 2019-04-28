/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Akos Menyhert, Tamas Borbas, Zoltan Ujhelyi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.generator.tests

import java.util.Random
import org.eclipse.viatra.examples.cps.generator.dtos.scenario.impl.BasicScenario
import org.junit.Test
import org.junit.Ignore

class IntegrationTestScenario extends TestBase {

	/**
	 * 1K ==> 866, 333ms
	 * 2K ==> 2757, 658ms
	 * 7K ==> 10894, 1770ms
	 * 40K ==> 101758, 4241ms
	 * 190K ==> 1,083M EObjects, 97mp 
	 */
	@Ignore
	@Test
	def basicScenario(){
		val seed = 11111
		val Random rand = new Random(seed);
		val BasicScenario bs = new BasicScenario(rand);
		val const = bs.getConstraintsFor(1000);		
		runGeneratorOn(const, seed)
	
		return;
	}
	
}