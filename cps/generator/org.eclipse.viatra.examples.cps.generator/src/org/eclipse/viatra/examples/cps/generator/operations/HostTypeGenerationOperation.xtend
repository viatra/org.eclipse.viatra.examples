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

import org.eclipse.viatra.examples.cps.generator.dtos.CPSFragment
import org.eclipse.viatra.examples.cps.generator.dtos.HostClass
import org.eclipse.viatra.examples.cps.generator.utils.CPSModelBuilderUtil
import org.eclipse.viatra.examples.cps.generator.utils.RandomUtils
import org.eclipse.viatra.examples.cps.planexecutor.api.IOperation

class HostTypeGenerationOperation implements IOperation<CPSFragment> {
	val HostClass hostClass;
	private extension CPSModelBuilderUtil modelBuilder;
	private extension RandomUtils randUtil
	
	
	new(HostClass applicationClass){
		this.hostClass = applicationClass;
		modelBuilder = new CPSModelBuilderUtil;
		randUtil = new RandomUtils;
	}
	
	override execute(CPSFragment fragment) {
		// Generate ApplicationTypes
		val numberOfHostTypes = hostClass.numberOfHostTypes.randInt(fragment.random);
		
		for(i : 0 ..< numberOfHostTypes){
			val hostTypeId = "simple.cps.host." + hostClass.name + i;
			val hostType = fragment.modelRoot.prepareHostTypeWithId(hostTypeId);
			fragment.addHostType(hostClass, hostType);
		}

		true;
	}
	
}