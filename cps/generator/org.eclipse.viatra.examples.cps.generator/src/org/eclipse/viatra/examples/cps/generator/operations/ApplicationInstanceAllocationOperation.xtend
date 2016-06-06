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

import com.google.common.collect.Multimap
import org.apache.log4j.Logger
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance
import org.eclipse.viatra.examples.cps.generator.dtos.CPSFragment
import org.eclipse.viatra.examples.cps.generator.utils.CPSModelBuilderUtil
import org.eclipse.viatra.examples.cps.planexecutor.api.IOperation

class ApplicationInstanceAllocationOperation implements IOperation<CPSFragment> {
	
	Multimap<HostInstance, ApplicationInstance> allocationMap
	private extension CPSModelBuilderUtil modelBuilder;
	
	protected extension Logger logger = Logger.getLogger("cps.generator.impl.ApplicationInstanceAllocationOperation")
	
	new(Multimap<HostInstance, ApplicationInstance> allocationMap) {
		this.modelBuilder = new CPSModelBuilderUtil;
		this.allocationMap = allocationMap;
	}
	
	override execute(CPSFragment fragment) {
		
		for(host : allocationMap.keySet){
			for(app: allocationMap.get(host)){
				app.setAllocatedTo(host);
			}
		}
		
		return true;	
	}

}