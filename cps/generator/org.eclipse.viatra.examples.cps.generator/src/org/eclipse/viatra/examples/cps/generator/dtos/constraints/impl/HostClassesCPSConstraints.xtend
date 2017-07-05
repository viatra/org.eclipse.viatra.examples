/*******************************************************************************
 * Copyright (c) 2014-2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Akos Menyhert, Tamas Borbas, Zoltan Ujhelyi - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.generator.dtos.constraints.impl

import org.eclipse.viatra.examples.cps.generator.dtos.HostClass
import org.eclipse.viatra.examples.cps.generator.dtos.MinMaxData
import org.eclipse.viatra.examples.cps.generator.dtos.constraints.ICPSConstraints
import java.util.HashMap

class HostClassesCPSConstraints implements ICPSConstraints {
	
	public String name = "HostClasses";
	
	val hostClass = new HostClass(
						"FirstHostClass",
						new MinMaxData(2, 2), // HostTypes
						new MinMaxData(2, 2), // HostInstances
						new MinMaxData(1, 1) // CommLines
						,new HashMap
					)
	
	
	override getNumberOfSignals() {
		new MinMaxData(1, 10);
	}
	
	override getApplicationClasses() {
		#[
		];
	}
	
	override getHostClasses() {
		#[
			hostClass
		];
	}
	
	override getName() {
		return this.class.simpleName;
	}
	
}