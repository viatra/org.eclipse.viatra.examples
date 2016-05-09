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

import org.eclipse.viatra.examples.cps.deployment.BehaviorState
import org.eclipse.viatra.examples.cps.xform.m2m.incr.expl.queries.DeletedStateMatch
import org.eclipse.viatra.examples.cps.xform.m2m.incr.expl.queries.MonitoredStateMatch
import org.eclipse.viatra.examples.cps.xform.m2m.incr.expl.queries.UnmappedStateMatch
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.evm.specific.Jobs
import org.eclipse.viatra.transformation.evm.specific.Lifecycles
import org.eclipse.viatra.transformation.evm.specific.Rules
import org.eclipse.viatra.transformation.evm.specific.crud.CRUDActivationStateEnum

class StateRules {
	static def getRules(ViatraQueryEngine engine) {
		#{
			new StateMapping(engine).specification
			,new StateUpdate(engine).specification
			,new StateRemoval(engine).specification
		}
	}
}

class StateMapping extends AbstractRule<UnmappedStateMatch> {
	
	new(ViatraQueryEngine engine) {
		super(engine)
	}
	
	override getSpecification() {
		Rules.newMatcherRuleSpecification(
			unmappedState,
			Lifecycles.getDefault(false, false),
			#{appearedJob}
		)
	}
	
	private def getAppearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.CREATED, [UnmappedStateMatch match |
			val state = match.state
			val stateId = state.identifier
			debug('''Mapping state with ID: «stateId»''')
			val depState = createBehaviorState => [
				description = stateId
			]
			match.depBehavior.states += depState
			if(match.stateMachine.initial == state){
				match.depBehavior.current = depState
			}
			val traces = engine.cps2depTrace.getAllValuesOftrace(null, state, null)
			if(traces.empty){
				trace('''Creating new trace for state ''')
				rootMapping.traces += createCPS2DeploymentTrace => [
					cpsElements += state
					deploymentElements += depState
				]
			} else {
				trace('''Adding new state to existing trace''')
				traces.head.deploymentElements += depState
			}
			debug('''Mapped state with ID: «stateId»''')
		])
	}
}

class StateUpdate extends AbstractRule<MonitoredStateMatch> {
	
	new(ViatraQueryEngine engine) {
		super(engine)
	}
	
	override getSpecification() {
		Rules.newMatcherRuleSpecification(
			monitoredState,
			Lifecycles.getDefault(true, true),
			#{appearedJob, disappearedJob, updatedJob}
		)
	}
	
	private def getAppearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.CREATED, [MonitoredStateMatch match |
			val stateId = match.state.identifier
			debug('''Starting monitoring mapped state with ID: «stateId»''')
		])
	}
	
	private def getDisappearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.DELETED, [MonitoredStateMatch match |
			val stateId = match.state.identifier
			debug('''Stopped monitoring mapped state with ID: «stateId»''')
		])
	}
	
	private def getUpdatedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.UPDATED, [MonitoredStateMatch match |
			val state = match.state
			val stateId = state.identifier
			debug('''Updating mapped state with ID: «stateId»''')
			val depStateMatches = getMappedState(engine).getAllMatches(state, null, null, null)
			depStateMatches.forEach[
				val oldDesc = depState.description
				if(oldDesc != stateId){
					trace('''ID changed to «stateId»''')
					depState.description = stateId
				}
				val initState = stateMachine.initial
				if(state == initState){
					val currentState = depBehavior.current 
					if(currentState != depState){
						trace('''Current state changed to «stateId»''')
						depBehavior.current = depState
					}
				}
			]
			debug('''Updated mapped state with ID: «stateId»''')
		])
	}
}

class StateRemoval extends AbstractRule<DeletedStateMatch> {
	
	new(ViatraQueryEngine engine) {
		super(engine)
	}
	
	override getSpecification() {
		Rules.newMatcherRuleSpecification(
			deletedState,
			Lifecycles.getDefault(false, false),
			#{appearedJob}
		)
	}
	
	private def getAppearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.CREATED, [DeletedStateMatch match |
			val depState = match.depState as BehaviorState
			val stateId = depState.description
			logger.debug('''Removing state with ID: «stateId»''')
			val stateMachines = engine.behaviorState.getAllValuesOfdepBehavior(depState)
			if(!stateMachines.empty){
				val sm = stateMachines.head
				sm.states -= depState
				if(sm.current == depState){
					sm.current = null
				}
			}
			val smTrace = match.trace
			smTrace.deploymentElements -= depState
			if(smTrace.deploymentElements.empty){
				trace('''Removing empty trace''')
				rootMapping.traces -= smTrace
			}
			logger.debug('''Removed state with ID: «stateId»''')
		])
	} 
}