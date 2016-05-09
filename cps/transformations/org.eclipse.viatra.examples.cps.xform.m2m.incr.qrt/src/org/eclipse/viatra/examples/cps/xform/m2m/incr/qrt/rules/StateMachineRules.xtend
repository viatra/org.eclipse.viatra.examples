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

import org.eclipse.viatra.examples.cps.xform.m2m.incr.qrt.queries.StateMachineMatch
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.evm.specific.Jobs
import org.eclipse.viatra.transformation.evm.specific.Lifecycles
import org.eclipse.viatra.transformation.evm.specific.Rules
import org.eclipse.viatra.transformation.evm.specific.crud.CRUDActivationStateEnum
import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication
import org.eclipse.viatra.examples.cps.deployment.DeploymentBehavior
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance

class StateMachineRules {
	static def getRules(ViatraQueryEngine engine) {
		#{
			new StateMachineMapping(engine).specification
		}
	}
}

class StateMachineMapping extends AbstractRule<StateMachineMatch> {
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
			[ StateMachineMatch match |
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
			[ StateMachineMatch match |
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
			[ StateMachineMatch match |
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
