/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Akos Menyhert, Zoltan Ujhelyi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.generator.dtos

import org.eclipse.viatra.examples.cps.generator.dtos.bases.GeneratorInput
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystem
import org.eclipse.viatra.examples.cps.generator.dtos.constraints.IConstraints

class CPSGeneratorInput extends GeneratorInput<CyberPhysicalSystem> {
	
	new(long seed, IConstraints constraints, CyberPhysicalSystem modelRoot) {
		super(seed, constraints, modelRoot)
	}
	
	override getInitialFragment() {
		return new CPSFragment(this);
	}
	
}