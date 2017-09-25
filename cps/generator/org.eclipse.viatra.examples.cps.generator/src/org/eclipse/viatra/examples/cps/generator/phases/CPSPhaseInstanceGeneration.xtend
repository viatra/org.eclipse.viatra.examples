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
package org.eclipse.viatra.examples.cps.generator.phases

import com.google.common.collect.Lists
import org.eclipse.viatra.examples.cps.generator.dtos.CPSFragment
import org.eclipse.viatra.examples.cps.generator.operations.ApplicationInstanceGenerationOperation
import org.eclipse.viatra.examples.cps.generator.operations.HostInstanceGenerationOperation
import org.eclipse.viatra.examples.cps.planexecutor.api.IPhase
import org.apache.log4j.Logger

class CPSPhaseInstanceGeneration implements IPhase<CPSFragment>{
	
	protected extension Logger logger = Logger.getLogger("cps.generator.impl.CPSPhaseInstanceGeneration")
	
	override getOperations(CPSFragment fragment) {
		val operations = Lists.newArrayList();
		
		// ApplicationInstances
		for(appClass : fragment.applicationTypes.keySet){
			var sumAppType = 0
			val appTypes = fragment.applicationTypes.get(appClass);
			if(appTypes !== null){
				for(appType : appTypes){
					operations.add(new ApplicationInstanceGenerationOperation(appClass, appType));
					sumAppType++
				}			
			}
			debug(" --> AppTypes of " + appClass.name + " = " +sumAppType)
		}

		
		// Generate Host Instances
		// HostClasses
		for(hostClass : fragment.hostTypes.keySet){
			val types = fragment.hostTypes.get(hostClass);
			// HostTypes
			if(types !== null){
				for(type : types){
					operations.add(new HostInstanceGenerationOperation(hostClass, type));
				}
			}
			
		}
		
		return operations;
	}
	
}