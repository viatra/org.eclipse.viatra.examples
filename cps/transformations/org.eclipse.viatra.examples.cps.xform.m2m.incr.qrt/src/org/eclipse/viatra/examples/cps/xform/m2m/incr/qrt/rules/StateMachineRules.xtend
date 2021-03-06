/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Marton Bur, Zoltan Ujhelyi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2m.incr.qrt.rules

import org.eclipse.viatra.examples.cps.xform.m2m.incr.qrt.queries.StateMachine
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.evm.specific.Jobs
import org.eclipse.viatra.transformation.evm.specific.Lifecycles
import org.eclipse.viatra.transformation.evm.specific.Rules
import org.eclipse.viatra.transformation.evm.specific.crud.CRUDActivationStateEnum
import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication
import org.eclipse.viatra.examples.cps.deployment.DeploymentBehavior

class StateMachineRules {
	static def getRules(ViatraQueryEngine engine) {
		#{
			new StateMachineMapping(engine).specification
		}
	}
}

class StateMachineMapping extends AbstractRule<StateMachine.Match> {
	new(ViatraQueryEngine engine) {
		super(engine)
	}

	override getSpecification() {
		createPriorityRuleSpecification => [
			ruleSpecification = Rules.newMatcherRuleSpecification(stateMachine, Lifecycles.getDefault(true, true),
				#{appearedJob, updateJob, disappearedJob})
			priority = 3
		]
	}

	private def getAppearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.CREATED,
			[ StateMachine.Match match |
				val depApp = engine.cps2depTrace.getAllValuesOfdepElement(null, null, match.appInstance).filter(
					DeploymentApplication).head
				val smId = match.stateMachine.identifier
				debug('''Mapping state machine with ID: «smId»''')
				val behavior = createDeploymentBehavior => [
					description = smId
				]
				depApp.behavior = behavior
				val traces = engine.cps2depTrace.getAllValuesOftrace(null, match.stateMachine, null)
				if (traces.empty) {
					trace('''Creating new trace for state machine''')
					rootMapping.traces += createCPS2DeploymentTrace => [
						cpsElements += match.stateMachine
						deploymentElements += behavior
					]
				} else {
					trace('''Adding new behavior to existing trace''')
					traces.head.deploymentElements += behavior
				}
				debug('''Mapped state machine with ID: «smId»''')
			])
	}

	private def getUpdateJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.UPDATED,
			[ StateMachine.Match match |
				val smId = match.stateMachine.identifier
				debug('''Updating mapped state machine with ID: «smId»''')
				val depSMs = engine.cps2depTrace.getAllValuesOfdepElement(null, null, match.stateMachine).filter(
					DeploymentBehavior)
				depSMs.forEach [
					if (description != smId) {
						trace('''ID changed to «smId»''')
						description = smId
					}
				]
				debug('''Updated mapped state machine with ID: «smId»''')
			])
	}

	private def getDisappearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.DELETED,
			[ StateMachine.Match match |
				val depApp = engine.cps2depTrace.getAllValuesOfdepElement(null, null, match.appInstance).head as DeploymentApplication;
				val depBehavior = depApp.behavior
				val smId = depBehavior.description
				logger.debug('''Removing state machine with ID: «smId»''')
				depApp.behavior = null;
				val smTrace = engine.cps2depTrace.getAllValuesOftrace(null, match.stateMachine, null).head
				smTrace.deploymentElements -= depBehavior
				if (smTrace.deploymentElements.empty) {
					trace('''Removing empty trace''')
					rootMapping.traces -= smTrace
				}
				logger.debug('''Removed state machine with ID: «smId»''')
			])
	}

}
