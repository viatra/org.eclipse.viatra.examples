/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Akos Menyhert, Zoltan Ujhelyi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.generator.dtos

import java.util.Map
import org.eclipse.xtend.lib.annotations.Data


/*
 * If this DTO class was annotated with @{@link Data}, then this would potentially cause a StackOverflowException 
 * when calculating hash code for the conatined communicationRation maps, for this map might contain 
 * a HostClass instance, whose communicationRatios map contains the container map's HostClass instance
 */ 
class HostClass {
		
	public String name;
	
	public MinMaxData<Integer> numberOfHostTypes;
	public MinMaxData<Integer> numberOfHostInstances;
	public MinMaxData<Integer> numberOfCommunicationLines;
	public Map<HostClass, Integer> communicationRatios;
	
	new(String name,
		MinMaxData<Integer> numberOfHostTypes,
		MinMaxData<Integer> numberOfHostInstances,
		MinMaxData<Integer> numberOfCommunicationLines,
		Map<HostClass, Integer> communicationRatios
	){
		this.name = name;
		this.numberOfHostTypes = numberOfHostTypes
		this.numberOfHostInstances = numberOfHostInstances
		this.numberOfCommunicationLines = numberOfCommunicationLines
		this.communicationRatios = communicationRatios
	}
	
}