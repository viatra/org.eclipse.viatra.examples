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

import com.google.common.collect.HashMultimap
import com.google.common.collect.Lists
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance
import org.eclipse.viatra.examples.cps.generator.dtos.CPSFragment
import org.eclipse.viatra.examples.cps.generator.dtos.HostClass
import org.eclipse.viatra.examples.cps.generator.operations.HostInstanceCommunicatesWithOperation
import org.eclipse.viatra.examples.cps.generator.utils.RandomUtils
import org.eclipse.viatra.examples.cps.planexecutor.api.IPhase
import org.eclipse.viatra.examples.cps.generator.utils.CPSModelBuilderUtil

class CPSPhaseHostCommunication implements IPhase<CPSFragment>{
	
	private extension RandomUtils randUtil = new RandomUtils;
	
	override getOperations(CPSFragment fragment) {
		val operations = Lists.newArrayList();
	
		// Calculate hostclass to host instance map
		val hostClassToInstanceMap = CPSModelBuilderUtil.calculateHostInstancesToHostClassMap(fragment);

		// Generate communications
		for(hostClass : fragment.hostTypes.keySet){ // HostClasses store the configuration
			val possibleTargetInstances = calculatePossibleTargetInstances(hostClass, hostClassToInstanceMap)
			
			for(hostType : fragment.hostTypes.get(hostClass)){ // Every HostInstance
				for(hostInstance : hostType.instances){
				    val possibleTargetCopy = Lists.newArrayList(possibleTargetInstances)
					possibleTargetCopy.remove(hostInstance);
					// Calculate the number of new communication links
					val numberOfCommLinks = hostClass.numberOfCommunicationLines.randInt(fragment.random); 
					// Create communication links
					for(i : 0 ..< numberOfCommLinks){
						// Randomize target node
						if(!possibleTargetCopy.empty){
    						val targetHostInstance = possibleTargetCopy.randElement(fragment.random);
    						if(targetHostInstance !== null){
    							possibleTargetCopy.remove(targetHostInstance);
    							operations.add(new HostInstanceCommunicatesWithOperation(hostInstance, targetHostInstance));
    						}
						}
					}
				}
			}
		}
		
		return operations;
	}
	
	def calculatePossibleTargetInstances(HostClass sourceClass, HashMultimap<HostClass, HostInstance> hostClassToInstances) {
		var minRatio = sourceClass.communicationRatios.values.fold(Integer.MAX_VALUE)[min, act| 
			if(act < min && act != 0){
				act
			}else{
				min
			}
		];
		
		val possibleInstances = Lists.<HostInstance>newArrayList;
		for(targetHClass : sourceClass.communicationRatios.keySet){
			val targetRatio = sourceClass.communicationRatios.get(targetHClass);
			val normRatio = Math.round(targetRatio as float / minRatio as float); //?
			for(i : 0 ..< normRatio){
				possibleInstances.addAll(hostClassToInstances.get(targetHClass));
			}
		}
		return possibleInstances;
	}
	
}