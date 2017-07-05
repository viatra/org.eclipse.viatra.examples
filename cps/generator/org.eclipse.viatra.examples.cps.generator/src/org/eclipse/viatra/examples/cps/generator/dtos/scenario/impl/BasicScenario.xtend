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
package org.eclipse.viatra.examples.cps.generator.dtos.scenario.impl

import com.google.common.collect.ImmutableList
import com.google.common.collect.Lists
import java.util.HashMap
import java.util.Map
import java.util.Random
import org.apache.log4j.Logger
import org.eclipse.viatra.examples.cps.generator.dtos.AppClass
import org.eclipse.viatra.examples.cps.generator.dtos.BuildableCPSConstraint
import org.eclipse.viatra.examples.cps.generator.dtos.HostClass
import org.eclipse.viatra.examples.cps.generator.dtos.MinMaxData
import org.eclipse.viatra.examples.cps.generator.dtos.Percentage
import org.eclipse.viatra.examples.cps.generator.dtos.scenario.IScenario
import org.eclipse.viatra.examples.cps.generator.utils.RandomUtils

/**
 * |HC| &#8776; |AC|</br>
 * |HT| &#8776; |AT|</br>
 * |T| &#8776; |S|/2</br>
 * |T| = C * 10</br>
 * |I| = T * 10 => F<sub>I</sub> = 10</br>
 * |S| = |AT| * 5 = 50 * C</br>
 * |Sig| = C/2</br>
 * |Hcom| = I / 3</br>
 * AllocRatio 1 for each HostClass
 * 
 */
class BasicScenario implements IScenario {
	
	protected extension Logger logger = Logger.getLogger("cps.generator.Tests.BasicScenario")
	protected extension RandomUtils randUtil = new RandomUtils;
	
	Random rand;
	int C;
	
	double Ssig = 0.0; // Scattering of Signals
	double Shc = 0.0;
	double Sac = 0.0;
	
	Iterable<HostClass> hostClasses = ImmutableList.of();
	
	new(Random rand){
		this.rand = rand;
	}
	
	override getConstraintsFor(int countOfElements) {
		C = Math.round(0.05726 * Math.sqrt(countOfElements)) as int; // xxx
		info("--> Element count = " + countOfElements);
		info("--> C = " + C);
		
		this.hostClasses = createHostClassList()
		
		val min = Math.round(C/2*(1-Ssig)) as int;
		val max = Math.round(C/2*(1+Ssig)) as int;
		val BuildableCPSConstraint cons = new BuildableCPSConstraint(
			"Basic Scenario",
			new MinMaxData<Integer>(min, max), // Sig
			createAppClassList(),
			this.hostClasses	
		);
		
		return cons;
	}
	
	def Iterable<HostClass> createHostClassList() {
		val hostClasses = Lists.<HostClass>newArrayList;
		
		val min = (C*(1-Shc)) as int
		val max = (C*(1+Shc)) as int
		val hostClassCount = new MinMaxData<Integer>(min, max).randInt(rand);
		info("--> HostClass count = " + hostClassCount);
		
		val typCount = hostClassCount*5;
		info("--> HostType count = " + typCount);
		val instCount = hostClassCount*5;
		info("--> HostInstance count = " + instCount);
		val comCount = instCount / 3;
		info("--> Host comm count = " + comCount);
		
		for(i : 0 ..< hostClassCount){
			hostClasses.add(
				new HostClass(
					"HC"+i, // name
					new MinMaxData(typCount, typCount),// Type
					new MinMaxData(instCount, instCount), //Instance
					new MinMaxData(comCount, comCount), //ComLines
					new HashMap
				)
			);
		}
		
		return hostClasses;
	}
	
	private def Iterable<AppClass> createAppClassList() {
		val appClasses = Lists.<AppClass>newArrayList;
		
		val min = (C*(1-Sac)) as int
		val max = (C*(1+Sac)) as int
		val appClassCount = new MinMaxData<Integer>(min, max).randInt(rand);
		info("--> AppClass count = " + appClassCount);
		var Map<HostClass, Integer> allocRatios = new HashMap();
		
		// alloc ratios
		for(hc : this.hostClasses){
			allocRatios.put(hc, 1);
		}
		
		for(i : 0 ..< appClassCount){
			appClasses.add(
				new AppClass(
					"AC" + i,
					new MinMaxData(appClassCount*5, appClassCount*8), // AppTypes
					new MinMaxData(appClassCount*5, appClassCount*8), // AppInstances
					new MinMaxData(5, 5), // States
					new MinMaxData(7, 7), // Transitions
					new Percentage(80), // Alloc 
					allocRatios,
					new Percentage(75), // Action
					new Percentage(30) // Send
				)
			);
		}
		
		return appClasses;
	}
	
}