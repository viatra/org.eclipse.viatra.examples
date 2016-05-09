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
package org.eclipse.viatra.examples.cps.xform.m2m.incr.qrt

import com.google.common.base.Stopwatch
import com.google.common.collect.ImmutableSet
import java.util.concurrent.TimeUnit
import org.apache.log4j.Logger
import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment
import org.eclipse.viatra.examples.cps.xform.m2m.incr.qrt.queries.CpsXformM2M
import org.eclipse.viatra.examples.cps.xform.m2m.incr.qrt.rules.ApplicationRules
import org.eclipse.viatra.examples.cps.xform.m2m.incr.qrt.rules.HostRules
import org.eclipse.viatra.examples.cps.xform.m2m.incr.qrt.util.PerJobFixedPriorityConflictResolver
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.evm.api.ExecutionSchema
import org.eclipse.viatra.transformation.evm.specific.ExecutionSchemas
import org.eclipse.viatra.transformation.evm.specific.Schedulers

import static com.google.common.base.Preconditions.*
import org.eclipse.viatra.examples.cps.xform.m2m.incr.qrt.rules.StateMachineRules
import org.eclipse.viatra.examples.cps.xform.m2m.incr.qrt.rules.StateRules
import org.eclipse.viatra.examples.cps.xform.m2m.incr.qrt.rules.TransitionRules
import org.eclipse.viatra.examples.cps.xform.m2m.incr.qrt.rules.TriggerRules

class CPS2DeploymentTransformationQrt {

	extension Logger logger = Logger.getLogger("cps.xform.m2m.expl.incr")
	extension CpsXformM2M cpsXformM2M = CpsXformM2M.instance

	ExecutionSchema schema = null

	CPSToDeployment cps2dep
	ViatraQueryEngine engine

	def initialize(CPSToDeployment cps2dep, ViatraQueryEngine engine) {
		checkArgument(cps2dep != null, "Mapping cannot be null!")
		checkArgument(cps2dep.cps != null, "CPS not defined in mapping!")
		checkArgument(cps2dep.deployment != null, "Deployment not defined in mapping!")
		checkArgument(engine != null, "Engine cannot be null!")

		this.cps2dep = cps2dep
		this.engine = engine

		debug("Preparing queries on engine.")
		val watch = Stopwatch.createStarted
		prepare(engine)
		info('''Prepared queries on engine («watch.elapsed(TimeUnit.MILLISECONDS)» ms)''')
	}

	def execute() {
		if (schema == null) {
			info(
				'''
				Executing transformation on:
					Cyber-physical system: «cps2dep.cps.identifier»''')

			debug("Preparing transformation rules.")
			val watch = Stopwatch.createStarted

			val rulesBuilder = ImmutableSet.builder
			rulesBuilder.addAll(HostRules.getRules(engine))
			rulesBuilder.addAll(ApplicationRules.getRules(engine))
			rulesBuilder.addAll(StateMachineRules.getRules(engine));
			rulesBuilder.addAll(StateRules.getRules(engine));
			rulesBuilder.addAll(TransitionRules.getRules(engine));
			rulesBuilder.addAll(TriggerRules.getRules(engine));
			val rules = rulesBuilder.build

			val schedulerFactory = Schedulers.getQueryEngineSchedulerFactory(engine)
			schema = ExecutionSchemas.createViatraQueryExecutionSchema(engine, schedulerFactory)

			val fpr = new PerJobFixedPriorityConflictResolver

			rules.forEach [
				fpr.setPriority(ruleSpecification, priority)
				schema.addRule(it.ruleSpecification)
			]

			schema.conflictResolver = fpr;

			info('''Prepared transformation rules («watch.elapsed(TimeUnit.MILLISECONDS)» ms)''')

			debug("Initial execution of transformation rules.")
			watch.reset.start
			schema.startUnscheduledExecution
			info('''Initial execution of transformation rules finished («watch.elapsed(TimeUnit.MILLISECONDS)» ms)''')
		}
	}

	def dispose() {
		schema?.dispose
	}

}
