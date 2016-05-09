/*******************************************************************************
 * Copyright (c) 2014, 2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Marton Bur, Zoltan Ujhelyi - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2m.incr.qrt.rules

import org.eclipse.viatra.examples.cps.deployment.BehaviorState
import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication
import org.eclipse.viatra.examples.cps.xform.m2m.incr.qrt.queries.StateMatch
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.evm.specific.Jobs
import org.eclipse.viatra.transformation.evm.specific.Lifecycles
import org.eclipse.viatra.transformation.evm.specific.Rules
import org.eclipse.viatra.transformation.evm.specific.crud.CRUDActivationStateEnum

class StateRules {
	static def getRules(ViatraQueryEngine engine) {
		#{
			new StateMapping(engine).specification
		}
	}
}

class StateMapping extends AbstractRule<StateMatch> {
	new(ViatraQueryEngine engine) {
		super(engine)
	}

	override getSpecification() {
		createPriorityRuleSpecification => [
			ruleSpecification = Rules.newMatcherRuleSpecification(state, Lifecycles.getDefault(true, true),
				#{appearedJob, updateJob, disappearedJob})
			priority = 4
		]
	}

	private def getAppearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.CREATED,
			[ StateMatch match |
				val depApp = engine.cps2depTrace.getAllValuesOfdepElement(null, null, match.appInstance).head as DeploymentApplication
				val depBehavior = depApp.behavior
				val state = match.state
				val stateId = state.identifier
				debug('''Mapping state with ID: «stateId»''')
				val depState = createBehaviorState => [
					description = stateId
				]
				depBehavior.states += depState
				if (match.stateMachine.initial == state) {
					depBehavior.current = depState
				}
				val traces = engine.cps2depTrace.getAllValuesOftrace(null, state, null)
				if (traces.empty) {
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

	private def getUpdateJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.UPDATED,
			[ StateMatch match |
				val state = match.state
				val stateId = state.identifier
				debug('''Updating mapped state with ID: «stateId»''')
				val depApp = engine.cps2depTrace.getAllValuesOfdepElement(null, null, match.appInstance).filter(
					DeploymentApplication).head
				val depState = engine.cps2depTrace.getAllValuesOfdepElement(null, null, match.state).filter(
					BehaviorState).findFirst[depApp.behavior.states.contains(it)]
				val depBehavior = depApp.behavior
				val oldDesc = depState.description
				if (oldDesc != stateId) {
					trace('''ID changed to «stateId»''')
					depState.description = stateId
				}
				val initState = match.stateMachine.initial
				if (state == initState) {
					val currentState = depBehavior.current
					if (currentState != depState) {
						trace('''Current state changed to «stateId»''')
						depBehavior.current = depState
					}
				}
				debug('''Updated mapped state with ID: «stateId»''')
			])
	}

	private def getDisappearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.DELETED,
			[ StateMatch match |
				val depApp = engine.cps2depTrace.getAllValuesOfdepElement(null, null, match.appInstance).head as DeploymentApplication
				val depBehavior = depApp.behavior
				val depState = engine.cps2depTrace.getAllValuesOfdepElement(null, null, match.state).filter(
					BehaviorState).findFirst[depApp.behavior.states.contains(it)];
				val stateId = depState.description
				logger.debug('''Removing state with ID: «stateId»''')
				if (depBehavior != null) {
					depBehavior.states -= depState
					if (depBehavior.current == depState) {
						depBehavior.current = null
					}
				}
				val smTrace = engine.cps2depTrace.getAllValuesOftrace(null, match.state, null).head
				smTrace.deploymentElements -= depState
				if (smTrace.deploymentElements.empty) {
					trace('''Removing empty trace''')
					rootMapping.traces -= smTrace
				}
				logger.debug('''Removed state with ID: «stateId»''')
			])
	}

}
