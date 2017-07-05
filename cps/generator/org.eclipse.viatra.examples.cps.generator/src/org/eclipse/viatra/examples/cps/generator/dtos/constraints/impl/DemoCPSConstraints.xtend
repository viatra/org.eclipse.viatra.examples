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

import java.util.HashMap
import org.eclipse.viatra.examples.cps.generator.dtos.AppClass
import org.eclipse.viatra.examples.cps.generator.dtos.HostClass
import org.eclipse.viatra.examples.cps.generator.dtos.MinMaxData
import org.eclipse.viatra.examples.cps.generator.dtos.Percentage
import org.eclipse.viatra.examples.cps.generator.dtos.constraints.ICPSConstraints
import java.util.Map

class DemoCPSConstraints implements ICPSConstraints {
	
	val hostClass1 = new HostClass(
						"FirstHostClass",
						new MinMaxData(1, 1), // HostTypes
						new MinMaxData(5, 5), // HostInstances
						new MinMaxData(2, 2) // CommLines
						,getHc1Ratios
					)
	
	val hostClass2 = new HostClass(
					"SecondHostClass",
					new MinMaxData(1, 1), // HostTypes
					new MinMaxData(5, 5), // HostInstances
					new MinMaxData(5, 5) // CommLines		
					,hc2Ratios
				)
	
	def Map<HostClass, Integer> getHc1Ratios() {
		val hc1Ratio = new HashMap<HostClass, Integer>
		hc1Ratio.put(hostClass1, 1);
		hc1Ratio.put(hostClass2, 5);
		return hc1Ratio;
	}
	
	def Map<HostClass, Integer> getHc2Ratios() {
		val hc1Ratio = new HashMap<HostClass, Integer>
		hc1Ratio.put(hostClass1, 2);
		return hc1Ratio;
	}
	
	
	override getNumberOfSignals() {
		new MinMaxData(1, 10);
	}
	
	override getApplicationClasses() {
		val firstAppClassAllocations = new HashMap();
		firstAppClassAllocations.put(hostClass1, 1);
		firstAppClassAllocations.put(hostClass2, 3);
		
		val secondAppClassAllocations = new HashMap();
		secondAppClassAllocations.put(hostClass1, 1);
		secondAppClassAllocations.put(hostClass2, 1);
		
		#[
			new AppClass(
				"FirstAppClass",
				new MinMaxData(1, 1), // AppTypes
				new MinMaxData(1, 1), // AppInstances
				new MinMaxData(3, 5), // States
				new MinMaxData(3, 5) // Transitions
				, new Percentage(100)
				, firstAppClassAllocations
				, new Percentage(100)
				, new Percentage(50)
			),
			
			new AppClass(
				"SecondAppClass",
				new MinMaxData(1, 1), // AppTypes
				new MinMaxData(1, 1), // AppInstances
				new MinMaxData(3, 5), // States
				new MinMaxData(3, 5) // Transitions
				, new Percentage(100)
				, firstAppClassAllocations
				, new Percentage(100)
				, new Percentage(50)	
			)
	];
	}
	
	override getHostClasses() {
		#[
			hostClass1,
			hostClass2
		];
	}
	
	override getName() {
		return this.class.simpleName;
	}
	
}