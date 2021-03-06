/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Akos Menyhert, Zoltan Ujhelyi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
 package org.eclipse.viatra.examples.cps.generator.operations

import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType
import org.eclipse.viatra.examples.cps.generator.dtos.AppClass
import org.eclipse.viatra.examples.cps.generator.dtos.CPSFragment
import org.eclipse.viatra.examples.cps.generator.utils.CPSModelBuilderUtil
import org.eclipse.viatra.examples.cps.generator.utils.RandomUtils
import org.eclipse.viatra.examples.cps.planexecutor.api.IOperation
import org.apache.log4j.Logger

class ApplicationInstanceGenerationOperation implements IOperation<CPSFragment> {
	protected extension Logger logger = Logger.getLogger("cps.generator.impl.ApplicationInstanceGenerationOperation")
	
	val AppClass applicationClass;
	val ApplicationType appType;
	extension CPSModelBuilderUtil modelBuilder;
	extension RandomUtils randUtil
	
	new(AppClass applicationClass, ApplicationType appType){
		this.applicationClass = applicationClass;
		this.appType = appType;
		modelBuilder = new CPSModelBuilderUtil;
		randUtil = new RandomUtils;
	}
	
	override execute(CPSFragment fragment) {
		// Generate ApplicationInstances
		val numberOfAppInstances = applicationClass.numberOfAppInstances.randInt(fragment.random);
		debug("--> AppInstances of " + appType.identifier + " = " +numberOfAppInstances)
		for(i : 0 ..< numberOfAppInstances){
			appType.prepareApplicationInstanceWithId(appType.identifier + ".inst" + i);
		}

		true;
	}
	
}