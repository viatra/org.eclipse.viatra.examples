/*******************************************************************************
 * Copyright (c) 2014, 2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Zoltan Ujhelyi, Denes Harmath - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2m.incr.expl.rules

import org.eclipse.viatra.examples.cps.deployment.BehaviorTransition
import org.eclipse.viatra.examples.cps.xform.m2m.incr.expl.queries.DeletedTransitionMatch
import org.eclipse.viatra.examples.cps.xform.m2m.incr.expl.queries.MonitoredTransitionMatch
import org.eclipse.viatra.examples.cps.xform.m2m.incr.expl.queries.UnmappedTransitionMatch
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.evm.specific.Jobs
import org.eclipse.viatra.transformation.evm.specific.Lifecycles
import org.eclipse.viatra.transformation.evm.specific.Rules
import org.eclipse.viatra.transformation.evm.specific.crud.CRUDActivationStateEnum

class TransitionRules {
	static def getRules(ViatraQueryEngine engine) {
		#{
			new TransitionMapping(engine).specification
			,new TransitionUpdate(engine).specification
			,new TransitionRemoval(engine).specification
		}
	}
}

class TransitionMapping extends AbstractRule<UnmappedTransitionMatch> {
	
	new(ViatraQueryEngine engine) {
		super(engine)
	}
	
	override getSpecification() {
		Rules.newMatcherRuleSpecification(
			unmappedTransition,
			Lifecycles.getDefault(false, false),
			#{appearedJob}
		)
	}
	
	private def getAppearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.CREATED, [UnmappedTransitionMatch match |
			val transition = match.transition
			val transitionId = transition.identifier
			debug('''Mapping transition with ID: «transitionId»''')
			val depTransition = createBehaviorTransition => [
				description = transitionId
			]
			match.depBehavior.transitions += depTransition
			
			val matches = engine.mappedTransitionSourceTarget.getAllMatches(transition, null, null, match.depBehavior)
			if(!matches.empty){
				val sourceTargetMatch = matches.head
				sourceTargetMatch.depSource.outgoing += depTransition
				depTransition.to = sourceTargetMatch.depTarget
			}
			
			val traces = engine.cps2depTrace.getAllValuesOftrace(null, transition, null)
			if(traces.empty){
				trace('''Creating new trace for transition ''')
				rootMapping.traces += createCPS2DeploymentTrace => [
					cpsElements += transition
					deploymentElements += depTransition
				]
			} else {
				trace('''Adding new transition to existing trace''')
				traces.head.deploymentElements += depTransition
			}

			debug('''Mapped transition with ID: «transitionId»''')
		])
	}
}

class TransitionUpdate extends AbstractRule<MonitoredTransitionMatch> {
	
	new(ViatraQueryEngine engine) {
		super(engine)
	}
	
	override getSpecification() {
		Rules.newMatcherRuleSpecification(
			monitoredTransition,
			Lifecycles.getDefault(true, true),
			#{appearedJob, disappearedJob, updatedJob}
		)
	}
	
	private def getAppearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.CREATED, [MonitoredTransitionMatch match |
			val trId = match.transition.identifier
			debug('''Starting monitoring mapped transition with ID: «trId»''')
		])
	}
	
	private def getDisappearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.DELETED, [MonitoredTransitionMatch match |
			val trId = match.transition.identifier
			debug('''Stopped monitoring mapped transition with ID: «trId»''')
		])
	}
	
	private def getUpdatedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.UPDATED, [MonitoredTransitionMatch match |
			val transition = match.transition
			val trId = transition.identifier
			debug('''Updating mapped transition with ID: «trId»''')
			val depTransitionMatches = getMappedTransition(engine).getAllMatches(transition, null, null)
			depTransitionMatches.forEach[
				val oldDesc = depTransition.description
				if(oldDesc != trId){
					trace('''ID changed to «oldDesc»''')
					depTransition.description = trId
				}
				
				val matches = engine.mappedTransitionSourceTarget.getAllMatches(transition, null, null, depBehavior)
				if(!matches.empty){
					val sourceTargetMatch = matches.head
					val newSource = sourceTargetMatch.depSource
					if(!newSource.outgoing.contains(depTransition)){
						trace('''Source state changed to «newSource.description»''')
						newSource.outgoing += depTransition
					}
					val newTarget = sourceTargetMatch.depTarget
					if(depTransition.to != newTarget){
						trace('''Target state changed to «newTarget.description»''')
						depTransition.to = newTarget
					}
				}
				
			]
			
			debug('''Updated mapped transition with ID: «trId»''')
		])
	}
}

class TransitionRemoval extends AbstractRule<DeletedTransitionMatch> {
	
	new(ViatraQueryEngine engine) {
		super(engine)
	}
	
	override getSpecification() {
		Rules.newMatcherRuleSpecification(
			deletedTransition,
			Lifecycles.getDefault(false, false),
			#{appearedJob}
		)
	}
	
	private def getAppearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.CREATED, [DeletedTransitionMatch match |
			val depTransition = match.depTransition as BehaviorTransition
			val trId = depTransition.description
			logger.debug('''Removing transition with ID: «trId»''')
			depTransition.to = null
			val sources = engine.behaviorStateOutgoing.getAllValuesOfdepState(depTransition)
			if(!sources.empty){
				val source = sources.head
				source.outgoing -= depTransition
			}
			val stateMachines = engine.behaviorTransition.getAllValuesOfdepBehavior(depTransition)
			if(!stateMachines.empty){
				val sm = stateMachines.head
				sm.transitions -= depTransition
			}
			val smTrace = match.trace
			smTrace.deploymentElements -= depTransition
			if(smTrace.deploymentElements.empty){
				trace('''Removing empty trace''')
				rootMapping.traces -= smTrace
			}
			logger.debug('''Removed transition with ID: «trId»''')
		])
	} 
}