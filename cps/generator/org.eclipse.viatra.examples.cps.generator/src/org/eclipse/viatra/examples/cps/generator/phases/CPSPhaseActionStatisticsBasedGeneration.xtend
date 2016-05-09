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

import com.google.common.collect.Lists
import com.google.common.collect.Sets
import org.apache.log4j.Logger
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.StateMachine
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition
import org.eclipse.viatra.examples.cps.generator.dtos.CPSFragment
import org.eclipse.viatra.examples.cps.generator.operations.ActionGenerationOperation
import org.eclipse.viatra.examples.cps.generator.queries.PossibleReceiverTypeMatcher
import org.eclipse.viatra.examples.cps.generator.queries.ReachableAppTypesMatcher
import org.eclipse.viatra.examples.cps.generator.queries.ReceiverTransitionMatcher
import org.eclipse.viatra.examples.cps.generator.queries.TransitionsMatcher
import org.eclipse.viatra.examples.cps.planexecutor.api.IPhase
import org.eclipse.viatra.examples.cps.generator.operations.DeleteTransitionWithoutAction

class CPSPhaseActionStatisticsBasedGeneration implements IPhase<CPSFragment>{
	
	private extension Logger logger = Logger.getLogger("cps.generator.impl.CPSPhaseActionGeneration");
	
	public static String WAIT_METHOD_NAME = CPSPhaseActionGeneration.WAIT_METHOD_NAME;
	public static String SEND_METHOD_NAME = CPSPhaseActionGeneration.SEND_METHOD_NAME;
	
	override getOperations(CPSFragment fragment) {
		val operations = Lists.newArrayList();
		
		val matcher = PossibleReceiverTypeMatcher.on(fragment.engine)
		val receiverTransitionMatcher = ReceiverTransitionMatcher.on(fragment.engine)

		val suppliedWithAction = Sets.<Transition>newHashSet
		
		matcher.allValuesOfSender.forEach [ senderTransition, index |
			
			val reachableTypeIds = matcher.getAllValuesOfReceiverAppTypeId(senderTransition)
			var boolean success = false;
			for(typeId : reachableTypeIds){
				
				if(!success) {
					 
					val receiverMatches = receiverTransitionMatcher.getAllMatches(typeId, null, null)
					var Transition firstReceiver = null
					var StateMachine firstSM = null
					var Transition secondReceiver = null
					
					
					// Find receiver pairs, there will be 1 or 2
					for(receiverMatch : receiverMatches){
						if(firstReceiver == null){
							if(!suppliedWithAction.contains(receiverMatch.transition)){
								firstReceiver = receiverMatch.transition
								firstSM = receiverMatch.SM
							}
						} else if(secondReceiver == null && receiverMatch.SM != firstSM){
							if(!suppliedWithAction.contains(receiverMatch.transition)){
								secondReceiver = receiverMatch.transition
							}					
						}
					}
					if(!suppliedWithAction.contains(senderTransition) && firstReceiver != null /* && !suppliedWithAction.contains(firstReceiver) <- this condition is implied by the firstReceiver !=null*/){
						// Successfully found pairable transitions
						success = true
						suppliedWithAction.add(senderTransition) 
						// Create send action
						val senderAction = SEND_METHOD_NAME + "(" + typeId + ", "+ index + ")"
						debug(senderAction)
						operations.add(new ActionGenerationOperation(senderAction, senderTransition));
						 
						// Create the receivers (1 or 2)
						/*if(firstReceiver != null){  <-  This condition is true due to the outer if*/
						suppliedWithAction.add(firstReceiver) 
						val receiverAction1 = WAIT_METHOD_NAME + "(" + index + ")";
						debug(receiverAction1)
						operations.add(new ActionGenerationOperation(receiverAction1, firstReceiver));
						/* } <- end of if that is always true here */
						if(secondReceiver != null){
							suppliedWithAction.add(secondReceiver) 
							val receiverAction2 = WAIT_METHOD_NAME + "(" + index + ")";
							debug(receiverAction2)
							operations.add(new ActionGenerationOperation(receiverAction2, secondReceiver));
						} 
					}
					
					if(index >= fragment.numberOfSignals){		
						debug("#Warning: more signal was generated than it is set in fragment.numberOfSignals");
					}
				}	
			}
		]
		
		operations.add(new DeleteTransitionWithoutAction(fragment))
		
		return operations;
	}
	
	def getTransitionsOf(ApplicationType type, CPSFragment fragment) {
		TransitionsMatcher.on(fragment.engine).getAllValuesOft(type.behavior);
	}
	
	def getPossibleAppTypesOf(ApplicationType type, CPSFragment fragment) {
		ReachableAppTypesMatcher.on(fragment.engine).getAllValuesOfTo(type);
	}
	
}