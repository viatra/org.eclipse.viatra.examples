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
 package org.eclipse.viatra.examples.cps.generator.operations

import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance
import org.eclipse.viatra.examples.cps.generator.dtos.CPSFragment
import org.eclipse.viatra.examples.cps.generator.utils.CPSModelBuilderUtil
import org.eclipse.viatra.examples.cps.generator.utils.RandomUtils
import org.eclipse.viatra.examples.cps.planexecutor.api.IOperation

class HostInstanceCommunicatesWithOperation implements IOperation<CPSFragment> {
	val HostInstance sourceHost;
	val HostInstance targetHost;
	
	private extension CPSModelBuilderUtil modelBuilder;
	private extension RandomUtils randUtil
	
	new(HostInstance sourceHost, HostInstance targetHost){
		this.sourceHost = sourceHost;
		this.targetHost = targetHost;
		modelBuilder = new CPSModelBuilderUtil;
		randUtil = new RandomUtils;
	}
	
	override execute(CPSFragment fragment) {
		// Generate Connection between instances
		sourceHost.prepareCommunication(targetHost);

		true;
	}
	
}