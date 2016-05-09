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

import org.eclipse.viatra.examples.cps.xform.m2m.incr.expl.queries.IllegalTraceMatch
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.evm.specific.Jobs
import org.eclipse.viatra.transformation.evm.specific.Lifecycles
import org.eclipse.viatra.transformation.evm.specific.Rules
import org.eclipse.viatra.transformation.evm.specific.crud.CRUDActivationStateEnum

class TraceRules {
	static def getRules(ViatraQueryEngine engine) {
		#{
			new IllegalTraceRemoval(engine).specification
		}
	}
}

class IllegalTraceRemoval extends AbstractRule<IllegalTraceMatch> {
	new(ViatraQueryEngine engine) {
		super(engine)
	}
	
	override getSpecification() {
		Rules.newMatcherRuleSpecification(
			illegalTrace,
			Lifecycles.getDefault(false, false),
			#{appearedJob}
		)
	}
	
	private def getAppearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.CREATED, [IllegalTraceMatch match |
			val cpsElements = match.trace.cpsElements
			debug('''Removing illegal trace for CPS elements: «FOR e : cpsElements SEPARATOR ", "»«e.identifier»«ENDFOR»''')
			rootMapping.traces -= match.trace
			debug('''Removed illegal trace''')
		])
	}
	
}