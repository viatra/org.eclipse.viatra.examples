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

import org.eclipse.viatra.examples.cps.xform.m2m.incr.qrt.queries.TriggerPairMatch
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.evm.specific.Jobs
import org.eclipse.viatra.transformation.evm.specific.Lifecycles
import org.eclipse.viatra.transformation.evm.specific.Rules
import org.eclipse.viatra.transformation.evm.specific.crud.CRUDActivationStateEnum
import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication
import org.eclipse.viatra.examples.cps.deployment.BehaviorTransition

class TriggerRules {
	static def getRules(ViatraQueryEngine engine) {
		#{
			new TriggerMapping(engine).specification
		}
	}
}

class TriggerMapping extends AbstractRule<TriggerPairMatch> {
	new(ViatraQueryEngine engine) {
		super(engine)
	}

	override getSpecification() {
		createPriorityRuleSpecification => [
			ruleSpecification = Rules.newMatcherRuleSpecification(triggerPair, Lifecycles.getDefault(true, true),
				#{appearedJob, disappearedJob})
			priority = 6
		]
	}

	private def getAppearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.CREATED,
			[ TriggerPairMatch match |
				val depAppTrigger = engine.cps2depTrace.getAllValuesOfdepElement(null, null, match.appInstanceTrigger).
					filter(DeploymentApplication).head
				val depAppTarget = engine.cps2depTrace.getAllValuesOfdepElement(null, null, match.appInstanceTarget).
					filter(DeploymentApplication).head
				val sendTr = engine.cps2depTrace.getAllValuesOfdepElement(null, null, match.cpsTrigger).filter(
					BehaviorTransition).findFirst[depAppTrigger.behavior.transitions.contains(it)]
				val waitTr = engine.cps2depTrace.getAllValuesOfdepElement(null, null, match.cpsTarget).filter(
					BehaviorTransition).findFirst[depAppTarget.behavior.transitions.contains(it)]
				debug('''Mapping trigger between «sendTr.description» and «waitTr.description»''')
				if (!sendTr.trigger.contains(waitTr)) {
					trace('''Adding new trigger''')
					sendTr.trigger += waitTr
				}
				debug('''Mapped trigger between «sendTr.description» and «waitTr.description»''')
			])
	}

	private def getDisappearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.DELETED,
			[ TriggerPairMatch match |
				val depAppTrigger = engine.cps2depTrace.getAllValuesOfdepElement(null, null,
					match.appInstanceTrigger).filter(DeploymentApplication).head
				val depAppTarget = engine.cps2depTrace.getAllValuesOfdepElement(null, null, match.appInstanceTarget).
					filter(DeploymentApplication).head
				val sendTr = engine.cps2depTrace.getAllValuesOfdepElement(null, null, match.cpsTrigger).filter(
					BehaviorTransition).findFirst[depAppTrigger.behavior.transitions.contains(it)]
				val waitTr = engine.cps2depTrace.getAllValuesOfdepElement(null, null, match.cpsTarget).filter(
					BehaviorTransition).findFirst[depAppTarget.behavior.transitions.contains(it)]
				debug('''Removing trigger between «sendTr.description» and «waitTr.description»''')
				if (sendTr.trigger.contains(waitTr)) {
					trace('''Removing existing trigger''')
					sendTr.trigger -= waitTr
				}
				debug('''Removing trigger between «sendTr.description» and «waitTr.description»''')
			])
	}

}
