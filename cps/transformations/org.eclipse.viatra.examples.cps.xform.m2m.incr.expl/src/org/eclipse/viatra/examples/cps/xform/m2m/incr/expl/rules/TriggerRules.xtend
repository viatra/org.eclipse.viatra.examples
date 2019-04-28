/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Zoltan Ujhelyi, Denes Harmath, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2m.incr.expl.rules

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.examples.cps.xform.m2m.incr.expl.queries.DeletedTrigger
import org.eclipse.viatra.transformation.evm.specific.crud.CRUDActivationStateEnum
import org.eclipse.viatra.examples.cps.xform.m2m.incr.expl.queries.UnmappedTrigger
import org.eclipse.viatra.transformation.evm.specific.Rules
import org.eclipse.viatra.transformation.evm.specific.Lifecycles
import org.eclipse.viatra.transformation.evm.specific.Jobs
import org.eclipse.viatra.transformation.evm.api.RuleSpecification
import java.util.Set

class TriggerRules {
	static def Set<RuleSpecification<?>> getRules(ViatraQueryEngine engine) {
		#{
			new TriggerMapping(engine).specification,
			new TriggerRemoval(engine).specification
		}
	}
}

class TriggerMapping extends AbstractRule<UnmappedTrigger.Match> {
	
	new(ViatraQueryEngine engine) {
		super(engine)
	}
	
	override getSpecification() {
		Rules.newMatcherRuleSpecification(
			unmappedTrigger,
			Lifecycles.getDefault(false, false),
			#{appearedJob}
		)
	}
	
	private def getAppearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.CREATED, [UnmappedTrigger.Match match |
			val sendTr = match.depSendTransition
			val waitTr = match.depWaitTransition
			debug('''Mapping trigger between «sendTr.description» and «waitTr.description»''')
			
			if(!sendTr.trigger.contains(waitTr)) {
				trace('''Adding new trigger''')
				sendTr.trigger += waitTr
			}

			debug('''Mapped trigger between «sendTr.description» and «waitTr.description»''')
		])
	}
}

class TriggerRemoval extends AbstractRule<DeletedTrigger.Match> {
	
	new(ViatraQueryEngine engine) {
		super(engine)
	}
	
	override getSpecification() {
		Rules.newMatcherRuleSpecification(
			deletedTrigger,
			Lifecycles.getDefault(false, false),
			#{appearedJob}
		)
	}
	
	private def getAppearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.CREATED, [DeletedTrigger.Match match |
			val sendTr = match.depSendTransition
			val waitTr = match.depWaitTransition
			debug('''Removing trigger between «sendTr.description» and «waitTr.description»''')
			
			if(sendTr.trigger.contains(waitTr)) {
				trace('''Removing existing trigger''')
				sendTr.trigger -= waitTr
			}

			debug('''Removing trigger between «sendTr.description» and «waitTr.description»''')
		])
	} 
}