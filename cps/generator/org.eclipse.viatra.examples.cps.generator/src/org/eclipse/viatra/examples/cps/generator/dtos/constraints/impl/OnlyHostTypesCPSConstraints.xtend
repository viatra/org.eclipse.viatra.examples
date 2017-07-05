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

import com.google.common.collect.ImmutableList
import org.eclipse.viatra.examples.cps.generator.dtos.HostClass
import org.eclipse.viatra.examples.cps.generator.dtos.MinMaxData
import org.eclipse.viatra.examples.cps.generator.dtos.constraints.ICPSConstraints
import java.util.HashMap

class OnlyHostTypesCPSConstraints implements ICPSConstraints {
	
	public String name = "OnlyHostTypes";
	
	override getNumberOfSignals() {
		new MinMaxData(1, 1);
	}
	
	override getApplicationClasses() {
		ImmutableList.of();
	}
	
	override getHostClasses() {
		#[
			new HostClass(
						"FirstHostClass",
						new MinMaxData(2, 2), // HostTypes
						new MinMaxData(0, 0), // HostInstances
						new MinMaxData(0, 0) // CommLines
						,new HashMap
					)
		];
	}
	
	override getName() {
		return this.class.simpleName;
	}
	
}