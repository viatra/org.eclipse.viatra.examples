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

import java.util.Map
//import org.eclipse.xtend.lib.annotations.Data

@Data
class AppClass {
	
	public String name;
	
	public MinMaxData<Integer> numberOfAppTypes;
	public MinMaxData<Integer> numberOfAppInstances;
	public MinMaxData<Integer> numberOfStates;
	public MinMaxData<Integer> numberOfTrannsitions;
	public Percentage percentOfAllocatedInstances;
	public Map<HostClass, Integer> allocationRatios;
	public Percentage probabilityOfActionGeneration;
	public Percentage probabilityOfSendAction;
	
}