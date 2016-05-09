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

import org.apache.log4j.Logger
import org.eclipse.viatra.examples.cps.deployment.DeploymentFactory
import org.eclipse.viatra.examples.cps.traceability.TraceabilityFactory
import org.eclipse.viatra.examples.cps.xform.m2m.incr.qrt.queries.CpsXformM2M
import org.eclipse.viatra.examples.cps.xform.m2m.incr.qrt.util.PriorityRuleSpecification
import org.eclipse.viatra.query.runtime.api.IPatternMatch
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine

import static com.google.common.base.Preconditions.*

abstract class AbstractRule<M extends IPatternMatch> {

	protected extension Logger logger = Logger.getLogger("cps.xform.AbstractRule")
	protected extension DeploymentFactory depFactory = DeploymentFactory.eINSTANCE
	protected extension TraceabilityFactory traceFactory = TraceabilityFactory.eINSTANCE
	protected extension CpsXformM2M cpsXformM2M = CpsXformM2M.instance
	protected ViatraQueryEngine engine

	new(ViatraQueryEngine engine) {
		this.engine = engine
		debug('''Creating rule «this.class.simpleName»''')
	}

	def PriorityRuleSpecification<M> getSpecification()

	def getRootMapping() {
		val matcher = cpsXformM2M.getMappedCPS(engine)
		checkState(matcher.countMatches == 1, "Incorrect number of CPSToDeployment mappings!")
		return matcher.oneArbitraryMatch.cps2dep
	}

	def <Match extends M> createPriorityRuleSpecification() {
		new PriorityRuleSpecification<Match>	
	}
}