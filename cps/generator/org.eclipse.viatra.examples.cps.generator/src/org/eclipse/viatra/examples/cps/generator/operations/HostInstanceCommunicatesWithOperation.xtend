/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Akos Menyhert, Zoltan Ujhelyi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
 package org.eclipse.viatra.examples.cps.generator.operations

import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance
import org.eclipse.viatra.examples.cps.generator.dtos.CPSFragment
import org.eclipse.viatra.examples.cps.generator.utils.CPSModelBuilderUtil
import org.eclipse.viatra.examples.cps.planexecutor.api.IOperation

class HostInstanceCommunicatesWithOperation implements IOperation<CPSFragment> {
	val HostInstance sourceHost;
	val HostInstance targetHost;
	
	extension CPSModelBuilderUtil modelBuilder;
	
	new(HostInstance sourceHost, HostInstance targetHost){
		this.sourceHost = sourceHost;
		this.targetHost = targetHost;
		modelBuilder = new CPSModelBuilderUtil;
	}
	
	override execute(CPSFragment fragment) {
		// Generate Connection between instances
		sourceHost.prepareCommunication(targetHost);

		true;
	}
	
}