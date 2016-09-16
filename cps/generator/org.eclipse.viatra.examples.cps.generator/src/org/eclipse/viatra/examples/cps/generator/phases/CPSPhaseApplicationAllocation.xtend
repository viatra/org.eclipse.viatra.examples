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
import java.util.HashMap
import org.apache.log4j.Logger
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance
import org.eclipse.viatra.examples.cps.generator.dtos.AppClass
import org.eclipse.viatra.examples.cps.generator.dtos.CPSFragment
import org.eclipse.viatra.examples.cps.generator.dtos.HostClass
import org.eclipse.viatra.examples.cps.generator.dtos.Percentage
import org.eclipse.viatra.examples.cps.generator.exceptions.ModelGeneratorException
import org.eclipse.viatra.examples.cps.generator.operations.ApplicationInstanceAllocationOperation
import org.eclipse.viatra.examples.cps.generator.utils.CPSModelBuilderUtil
import org.eclipse.viatra.examples.cps.generator.utils.MapUtil
import org.eclipse.viatra.examples.cps.generator.utils.RandomUtils
import org.eclipse.viatra.examples.cps.planexecutor.api.IPhase

class CPSPhaseApplicationAllocation implements IPhase<CPSFragment>{
	
	private extension RandomUtils randUtil = new RandomUtils;
	protected extension Logger logger = Logger.getLogger("cps.generator.impl.CPSPhaseApplicationAllocation")
	
	override getOperations(CPSFragment fragment) {
		val operations = Lists.newArrayList(); 
		
		// Calculate HostInstances to HostCallses
		val hostInstacesToClass = CPSModelBuilderUtil.calculateHostInstancesToHostClassMap(fragment);
		
		
		// Add operations for Allocate applicationInstances to HostInstances
		for(appClass : fragment.applicationTypes.keySet){
			val appInstances = collectApplicationInstancesByAppClass(appClass, fragment);
			if(!appInstances.empty){
				var sumRatio = calculateSumRatio(appClass);
				if(sumRatio != 0){
					val allocNumbers = new HashMap<HostClass, Integer> 
					var sumAllocatedApps = 0;
					// TODO keySet is not ordered...
					for(targetHostClass : appClass.allocationRatios.keySet){
						val hcRatio = appClass.allocationRatios.get(targetHostClass)
						val div = sumRatio as double / appInstances.size as double
						val hcAllocNumber = Math.floor(hcRatio / div) as int
						allocNumbers.put(targetHostClass, hcAllocNumber);
						sumAllocatedApps += hcAllocNumber;
					}			
					
					val sortedAllocNumbersMap = MapUtil.entriesSortedByValues(allocNumbers)
					
					// Remainders
					if(sumAllocatedApps < appInstances.size){
						val sortedIterator = sortedAllocNumbersMap.iterator
						while(sortedIterator.hasNext && ((appInstances.size - sumAllocatedApps) != 0)){
							val act = sortedIterator.next
							// TODO order is changed during the loop...?
							allocNumbers.put(act.key, act.value + 1)
							sumAllocatedApps += 1
						}
					}
					
					val allocationMap = HashMultimap.<HostInstance, ApplicationInstance>create
					
					// Create allocation map
					val appInstanceCopy = Lists.newArrayList(appInstances)
					for(targetHc : allocNumbers.keySet){
						for(i : 0 ..< allocNumbers.get(targetHc)) {
							val app = appInstanceCopy.randElement(fragment.random);
							appInstanceCopy.remove(app)
							val hostInstance = hostInstacesToClass.get(targetHc).toList.randElement(fragment.random)
							
							debug(app.identifier + " --> " + hostInstance.identifier)
							
							allocationMap.put(hostInstance, app);
						}
					}
					
					operations.add(new ApplicationInstanceAllocationOperation(allocationMap));
				}else{
					debug("!!! Error: Sum ratio is zero");
					throw new ModelGeneratorException("Sum ratio is zero");
				}
			}else{
				debug("#Warning#: ApplicationInstancesForAllocation is empty");
			}
			
		}
		
		return operations;
	}
	
	def normalizeRatios(HashMap<HostClass, Double> ratios, int sumRatio, int appsSize) {
		var HashMap<HostClass, Integer> normalizedRatios = new HashMap;
		// Floor allocation count
		var sumAllocCount = 0;
		for(hostClass : ratios.keySet){
			val allocCount = Math.floor(ratios.get(hostClass)) as int
			normalizedRatios.put(hostClass, allocCount);
			sumAllocCount += allocCount;
		}
		
		// Partition remainders
		debug("SumApp: " + appsSize + ", FlooredAlloc: " + sumAllocCount);
		if(sumAllocCount < appsSize){
			for(hostClass : ratios.keySet){
				var value = ratios.get(hostClass);
				var fraction = value - ((value as double) as long);
				ratios.put(hostClass, fraction);
			}
			
			var remainder = appsSize - sumAllocCount;
			val sortedMapEntires = MapUtil.entriesSortedByValues(ratios);
			
			if(remainder > normalizedRatios.size){
				debug("#Warning#: The remainder is greater than the size of targets.")	
			}
			
			for(index : 0 ..< remainder){
				val actualValue = normalizedRatios.get(sortedMapEntires.get(index).key);
				normalizedRatios.put(sortedMapEntires.get(index).key, actualValue + 1);
			}
		}
		
		return normalizedRatios;
	}
	
	def calculateSumRatio(AppClass appClass) {
		var sumRatio = 0;
		for(hostClass : appClass.allocationRatios.keySet){
			sumRatio += appClass.allocationRatios.get(hostClass);
		}
		return sumRatio;
	}
	
	def collectApplicationInstancesByAppClass(AppClass appClass, CPSFragment fragment) {
		val appTypes = fragment.applicationTypes.get(appClass);
		val appsForAllocateByAppClass = newArrayList;
		for(appType : appTypes){
			appsForAllocateByAppClass.addAll(collectApplicationsForAllocation(appType, appClass, fragment));
		}
		return appsForAllocateByAppClass;
	}
	
	def collectApplicationsForAllocation(ApplicationType appType, AppClass appClass, CPSFragment fragment) {
		var numberOfAllocations = Math.round(Percentage.value(appType.instances.size, appClass.percentOfAllocatedInstances)) as int;
		var appsForAllocate = newArrayList;
		val instances = Lists.newArrayList(appType.instances)
		for(i : 0 ..< numberOfAllocations){
			val app = instances.randElement(fragment.random)
            appsForAllocate.add(app);
			instances.remove(app)
		}
		return appsForAllocate;
	}
	
}