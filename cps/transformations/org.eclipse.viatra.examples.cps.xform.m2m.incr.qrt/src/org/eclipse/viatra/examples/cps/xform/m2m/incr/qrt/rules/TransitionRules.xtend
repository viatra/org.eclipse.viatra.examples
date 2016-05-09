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

import org.eclipse.viatra.examples.cps.xform.m2m.incr.qrt.queries.TransitionMatch
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.evm.specific.Jobs
import org.eclipse.viatra.transformation.evm.specific.Lifecycles
import org.eclipse.viatra.transformation.evm.specific.Rules
import org.eclipse.viatra.transformation.evm.specific.crud.CRUDActivationStateEnum
import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication
import org.eclipse.viatra.examples.cps.deployment.BehaviorTransition

class TransitionRules {
	static def getRules(ViatraQueryEngine engine) {
		#{
			new TransitionMapping(engine).specification
		}
	}
}

class TransitionMapping extends AbstractRule<TransitionMatch> {

	new(ViatraQueryEngine engine) {
		super(engine)
	}

	override getSpecification() {
		createPriorityRuleSpecification => [
			ruleSpecification = Rules.newMatcherRuleSpecification(transition, Lifecycles.getDefault(true, true),
				#{appearedJob, updateJob, disappearedJob})
			priority = 5
		]
	}

	private def getAppearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.CREATED,
			[ TransitionMatch match |
				addTransition(match)
			])
	}

	private def addTransition(TransitionMatch match) {
			val depApp = engine.cps2depTrace.getAllValuesOfdepElement(null, null, match.appInstance).filter(
				DeploymentApplication).head
			val transition = match.transition
			val transitionId = transition.identifier
			debug('''Mapping transition with ID: «transitionId»''')
			val depTransition = createBehaviorTransition => [
				description = transitionId
			]
			depApp.behavior.transitions += depTransition
			val tempDepSources = engine.cps2depTrace.getAllValuesOfdepElement(null, null, match.srcState);
			val depSource = depApp.behavior.states.findFirst[tempDepSources.contains(it)]
			depSource.outgoing += depTransition

			val tempDepTargets = engine.cps2depTrace.getAllValuesOfdepElement(null, null,
				match.transition.targetState);
			val depTarget = depApp.behavior.states.findFirst[tempDepTargets.contains(it)]
			depTransition.to = depTarget

			val traces = engine.cps2depTrace.getAllValuesOftrace(null, transition, null)
			if (traces.empty) {
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
	}

	private def getUpdateJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.UPDATED,
			[ TransitionMatch match |
				val transition = match.transition
				val trId = transition.identifier
				debug('''Updating mapped transition with ID: «trId»''')
				val depApp = engine.cps2depTrace.getAllValuesOfdepElement(null, null, match.appInstance).filter(
					DeploymentApplication).head
				val depTransitions = engine.cps2depTrace.getAllValuesOfdepElement(null, null, transition).filter(
					BehaviorTransition).toSet
				val depTransition = depApp.behavior.transitions.findFirst[depTransitions.contains(it)]
				val oldDesc = depTransition.description
				if (oldDesc != trId) {
					trace('''ID changed to «oldDesc»''')
					depTransition.description = trId
				}
				val tempDepSources = engine.cps2depTrace.getAllValuesOfdepElement(null, null, match.srcState)
				val depSource = depApp.behavior.states.findFirst[tempDepSources.contains(it)]
				val tempDepTargets = engine.cps2depTrace.getAllValuesOfdepElement(null, null,
					match.transition.targetState);
				val depTarget = depApp.behavior.states.findFirst[tempDepTargets.contains(it)]
				if (!depSource.outgoing.contains(depTransition)) {
					trace('''Source state changed to «depSource.description»''')
					depSource.outgoing += depTransition
				}
				if (depTransition.to != depTarget) {
					trace('''Target state changed to «depTarget.description»''')
					depTransition.to = depTarget
				}
				debug('''Updated mapped transition with ID: «trId»''')
			])
	}

	private def getDisappearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.DELETED,
			[ TransitionMatch match |
				deleteTransition(match)
			])
	}

	private def deleteTransition(TransitionMatch match) {
		val transition = match.transition
		val depApp = engine.cps2depTrace.getAllValuesOfdepElement(null, null, match.appInstance).filter(
			DeploymentApplication).head
		val depTransitions = engine.cps2depTrace.getAllValuesOfdepElement(null, null, transition).filter(
			BehaviorTransition).toSet
		val depTransition = engine.depBehaviorsStateAndTransitions.getAllValuesOfdepTransition(depApp.behavior, null).
			findFirst[depTransitions.contains(it)]
		val trId = depTransition.description
		logger.debug('''Removing transition with ID: «trId»''')
		depTransition.to = null
		val tempDepSources = engine.cps2depTrace.getAllValuesOfdepElement(null, null, match.srcState)
		val depSource = depApp.behavior.states.findFirst[tempDepSources.contains(it)]
		depSource?.outgoing -= depTransition;
		depApp.behavior.transitions -= depTransition
		val smTrace = engine.cps2depTrace.getAllValuesOftrace(null, transition, null).head
		smTrace.deploymentElements -= depTransition
		if (smTrace.deploymentElements.empty) {
			trace('''Removing empty trace''')
			rootMapping.traces -= smTrace
		}
		logger.debug('''Removed transition with ID: «trId»''')
	}
}
