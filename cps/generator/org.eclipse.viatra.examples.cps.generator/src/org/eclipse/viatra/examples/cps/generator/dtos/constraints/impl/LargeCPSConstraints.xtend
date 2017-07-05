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

class LargeCPSConstraints implements ICPSConstraints {
	
	val hostClass1 = new HostClass(
						"HostClass_1",
						new MinMaxData(10, 50), // HostTypes
						new MinMaxData(40, 70), // HostInstances
						new MinMaxData(1, 30) // CommLines
						,new HashMap
					)
	val hostClass2 = new HostClass(
					"HostClass_2",
					new MinMaxData(30, 35), // HostTypes
					new MinMaxData(40, 50), // HostInstances
					new MinMaxData(1, 30) // CommLines
					,new HashMap
				)
	val hostClass3 = new HostClass(
					"HostClass_3",
					new MinMaxData(10, 30), // HostTypes
					new MinMaxData(30, 30), // HostInstances
					new MinMaxData(1, 5) // CommLines
					,new HashMap	
				)
	
	
	override getNumberOfSignals() {
		new MinMaxData(1, 100);
	}
	
	override getApplicationClasses() {
		val firstAppClassAllocations = new HashMap();
		firstAppClassAllocations.put(hostClass1, 1);
		firstAppClassAllocations.put(hostClass2, 3);
		firstAppClassAllocations.put(hostClass3, 3);
		
		val secondAppClassAllocations = new HashMap();
		secondAppClassAllocations.put(hostClass1, 1);
		secondAppClassAllocations.put(hostClass2, 5);
		
		#[
			new AppClass(
				"FirstAppClass",
				new MinMaxData(10, 30), // AppTypes
				new MinMaxData(30, 70), // AppInstances
				new MinMaxData(20, 50), // States
				new MinMaxData(10, 20) // Transitions
				, new Percentage(80)
				, firstAppClassAllocations
				, new Percentage(100)
				, new Percentage(50)
			),
			
			new AppClass(
				"SecondAppClass",
				new MinMaxData(30, 50), // AppTypes       
				new MinMaxData(25, 40), // AppInstances  
				new MinMaxData(10, 55), // States         
				new MinMaxData(15, 35) // Transitions
				, new Percentage(100)
				, secondAppClassAllocations
				, new Percentage(100)
				, new Percentage(50) 		
			)
	];
	}
	
	override getHostClasses() {
		#[
			hostClass1,
			hostClass2,
			hostClass3
		];
	}
	
	override getName() {
		return this.class.simpleName;
	}
	
}