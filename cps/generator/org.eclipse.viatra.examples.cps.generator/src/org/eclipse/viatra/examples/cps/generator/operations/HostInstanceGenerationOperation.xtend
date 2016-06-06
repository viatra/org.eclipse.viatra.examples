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

import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostType
import org.eclipse.viatra.examples.cps.generator.dtos.CPSFragment
import org.eclipse.viatra.examples.cps.generator.dtos.HostClass
import org.eclipse.viatra.examples.cps.generator.utils.CPSModelBuilderUtil
import org.eclipse.viatra.examples.cps.generator.utils.RandomUtils
import org.eclipse.viatra.examples.cps.planexecutor.api.IOperation
import org.apache.log4j.Logger

class HostInstanceGenerationOperation implements IOperation<CPSFragment> {
	
	protected extension Logger logger = Logger.getLogger("cps.generator.impl.CPSPhaseApplicationAllocation")
	
	val HostClass hostClass;
	val HostType hostType;
	private extension CPSModelBuilderUtil modelBuilder;
	private extension RandomUtils randUtil
	
	new(HostClass hostClass, HostType type){
		this.hostClass = hostClass;
		this.hostType = type;
		modelBuilder = new CPSModelBuilderUtil;
		randUtil = new RandomUtils;
	}
	
	override execute(CPSFragment fragment) {
		// Generate Host Instances
		val numberOfHostInstances = hostClass.numberOfHostInstances.randInt(fragment.random);
		debug(" --> HostInstances of " + hostClass.name + " = " +numberOfHostInstances)
		for(i : 0 ..< numberOfHostInstances){
			// TODO generate valid IP addresses 
			hostType.prepareHostInstanceWithIP(hostType.identifier + ".inst"+i, hostType.identifier + ".inst"+i);
		}

		true;
	}
	
}