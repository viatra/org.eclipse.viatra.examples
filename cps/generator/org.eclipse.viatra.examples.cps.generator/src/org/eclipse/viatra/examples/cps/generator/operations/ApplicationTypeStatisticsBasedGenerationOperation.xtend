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

import com.google.common.collect.Lists
import java.util.List
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.State
import org.eclipse.viatra.examples.cps.generator.dtos.AppClass
import org.eclipse.viatra.examples.cps.generator.dtos.CPSFragment
import org.eclipse.viatra.examples.cps.generator.dtos.MinMaxData
import org.eclipse.viatra.examples.cps.generator.utils.CPSModelBuilderUtil
import org.eclipse.viatra.examples.cps.generator.utils.RandomUtils
import org.eclipse.viatra.examples.cps.planexecutor.api.IOperation

class ApplicationTypeStatisticsBasedGenerationOperation implements IOperation<CPSFragment> {
	val AppClass applicationClass;
	private extension CPSModelBuilderUtil modelBuilder;
	private extension RandomUtils randUtil
	
	
	new(AppClass applicationClass){
		this.applicationClass = applicationClass;
		modelBuilder = new CPSModelBuilderUtil;
		randUtil = new RandomUtils;
	}
	
	override execute(CPSFragment fragment) {
		// Generate ApplicationTypes
		val numberOfAppTypes = applicationClass.numberOfAppTypes.randInt(fragment.random);
		
		
			for(i : 0 ..< numberOfAppTypes){
				
				val appTypeId = "simple.cps.app." + applicationClass.name + i;
				val appType = fragment.modelRoot.prepareApplicationTypeWithId(appTypeId);
				fragment.addApplicationType(applicationClass, appType);
				
				// Create state machine only when it is not stateless
				if(applicationClass.numberOfStates.randInt(fragment.random) > 0){
					
					// Add StateMachine to ApplicationType
					val stateName = appTypeId + ".sm"+i;
					val sm = appType.prepareStateMachine(stateName);
				
					// States
					val numberOfStates = applicationClass.numberOfStates.randInt(fragment.random);
					val List<State> states = Lists.newArrayList();
					for(s : 0 ..< numberOfStates){
						states.add(sm.prepareState(stateName + ".s"+s));
					}
					
					// Initial State
					if(states.get(0) !== null && sm !== null){
						var initState = states.get(0)
						sm.setInitial(initState)
					}
					
					// Transitions
					val numberOfTransactions = applicationClass.numberOfTrannsitions.randInt(fragment.random);
					for(t : 0 ..< numberOfTransactions){
						val startNode = new MinMaxData(0, numberOfStates-1).randInt(fragment.random);
						val endNode = new MinMaxData(0, numberOfStates-1).randIntExcept(startNode, fragment.random);
						
						states.get(startNode).prepareTransition(states.get(startNode).identifier + ".t"+t, states.get(endNode));
					}
				}
			}
		true;
	}
	
}