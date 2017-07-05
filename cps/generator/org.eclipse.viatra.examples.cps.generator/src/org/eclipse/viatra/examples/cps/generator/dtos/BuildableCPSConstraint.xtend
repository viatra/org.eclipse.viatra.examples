/*******************************************************************************
 * Copyright (c) 2014-2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Akos Menyhert, Zoltan Ujhelyi - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.generator.dtos

import org.eclipse.viatra.examples.cps.generator.dtos.constraints.ICPSConstraints
import org.eclipse.viatra.examples.cps.generator.dtos.MinMaxData
import org.eclipse.viatra.examples.cps.generator.dtos.AppClass
import org.eclipse.viatra.examples.cps.generator.dtos.HostClass

/**
 * Simple implementation of {@link ICPSConstraints}. Every data shall be passed to the constructor. 
 *
 */
class BuildableCPSConstraint implements ICPSConstraints {
	
	val String name;
	val MinMaxData<Integer> numberOfSignals;
	val Iterable<AppClass> applicationClasses;
	val Iterable<HostClass> hostClasses;
	
	new(String name, MinMaxData<Integer> numberOfSignals, Iterable<AppClass> applicationClasses, Iterable<HostClass> hostClasses){
		this.name = name;
		this.numberOfSignals = numberOfSignals;
		this.applicationClasses = applicationClasses;
		this.hostClasses = hostClasses;
	}
	
	override getNumberOfSignals() {
		return numberOfSignals;
	}
	
	override getApplicationClasses() {
		return applicationClasses;
	}
	
	override getHostClasses() {
		return hostClasses;
	}
	
	override getName() {
		return name;
	}
	
}