/*******************************************************************************
 * Copyright (c) 2014, 2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Akos Menyhert, Zoltan Ujhelyi - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.generator.phases

import com.google.common.collect.ImmutableList
import com.google.common.collect.Lists
import org.apache.log4j.Logger
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType
import org.eclipse.viatra.examples.cps.generator.dtos.CPSFragment
import org.eclipse.viatra.examples.cps.generator.operations.ActionGenerationOperation
import org.eclipse.viatra.examples.cps.generator.queries.ReachableAppTypesMatcher
import org.eclipse.viatra.examples.cps.generator.queries.TransitionsMatcher
import org.eclipse.viatra.examples.cps.generator.utils.RandomUtils
import org.eclipse.viatra.examples.cps.planexecutor.api.IPhase

class CPSPhaseActionGeneration implements IPhase<CPSFragment>{
	
	private extension RandomUtils randUtil = new RandomUtils;
	private extension Logger logger = Logger.getLogger("cps.generator.impl.CPSPhaseActionGeneration");
	
	public static String WAIT_METHOD_NAME = "waitForSignal";
	public static String SEND_METHOD_NAME = "sendSignal";
	
	override getOperations(CPSFragment fragment) {
		val operations = Lists.newArrayList();
		
		for(appClass : fragment.applicationTypes.keySet){
			var appTypes = fragment.applicationTypes.get(appClass);
			if(appTypes != null){
				for(appType : appTypes){
					for(transition : getTransitionsOf(appType, fragment)){
						// Generate Action or not
						if(appClass.probabilityOfActionGeneration.randBooleanWithPercentageOfTrue(fragment.random)){
							// Generate action
							if(appClass.probabilityOfSendAction.randBooleanWithPercentageOfTrue(fragment.random)){
								// Generate SendSignal(AppTypeID, SignalID)
								val signalNumber = fragment.numberOfSignals.randIntOneToMax(fragment.random);
								val possibleTypeList = getPossibleAppTypesOf(appType, fragment).toList
								
								val targetAppType = possibleTypeList.randElementExcept(ImmutableList.of(appType), fragment.random);

								if(targetAppType != null){
									val action = SEND_METHOD_NAME + "(" + targetAppType.identifier + ", "+ signalNumber + ")";
									debug(action)
									operations.add(new ActionGenerationOperation(action, transition));
								}else{
									debug("#Warning: Cannot find target application type for Action of " + appType.identifier);
								}
							}else{
								// Generate WaitSignal(SignalID)
								val signalNumber = fragment.numberOfSignals.randIntOneToMax(fragment.random);
								val action = WAIT_METHOD_NAME + "(" + signalNumber + ")";
								debug(action)
								operations.add(new ActionGenerationOperation(action, transition));
							}
						}
					}
				}
			}
		}
		
		return operations;
	}
	
	def getTransitionsOf(ApplicationType type, CPSFragment fragment) {
		TransitionsMatcher.on(fragment.engine).getAllValuesOft(type.behavior);
	}
	
	def getPossibleAppTypesOf(ApplicationType type, CPSFragment fragment) {
		ReachableAppTypesMatcher.on(fragment.engine).getAllValuesOfTo(type);
	}
	
}