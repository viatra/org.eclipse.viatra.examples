/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Marton Bur, Zoltan Ujhelyi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2m.incr.qrt.rules

import org.eclipse.viatra.examples.cps.deployment.DeploymentHost
import org.eclipse.viatra.examples.cps.xform.m2m.incr.qrt.queries.HostInstance
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.evm.specific.Jobs
import org.eclipse.viatra.transformation.evm.specific.Lifecycles
import org.eclipse.viatra.transformation.evm.specific.Rules
import org.eclipse.viatra.transformation.evm.specific.crud.CRUDActivationStateEnum

class HostRules {
	static def getRules(ViatraQueryEngine engine) {
		#{
			new HostMapping(engine).specification
		}
	}
}

class HostMapping extends AbstractRule<HostInstance.Match> {

	new(ViatraQueryEngine engine) {
		super(engine)
	}

	override getSpecification() {
		createPriorityRuleSpecification => [
			ruleSpecification = Rules.newMatcherRuleSpecification(hostInstance, Lifecycles.getDefault(true, true),
			#{appearedJob, updateJob, disappearedJob})
			priority = 1
		]
	}

	private def getAppearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.CREATED,
			[ HostInstance.Match match |
				val nodeIp = match.hostInstance.nodeIp
				debug('''Mapping host with IP: «nodeIp»''')
				val host = createDeploymentHost => [
					ip = nodeIp
				]
				rootMapping.deployment.hosts += host
				rootMapping.traces += createCPS2DeploymentTrace => [
					cpsElements += match.hostInstance
					deploymentElements += host
				]
				debug('''Mapped host with IP: «nodeIp»''')
			])
	}

	private def getUpdateJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.UPDATED,
			[ HostInstance.Match match |
				// TODO Optional.get might throw an exception depending on what was deleted from the model
				val depHost = engine.cps2depTrace.getOneArbitraryMatch(rootMapping, null, match.hostInstance, null).
					get.depElement as DeploymentHost
				val hostIp = depHost.ip
				debug('''Updating mapped host with IP: «hostIp»''')
				val nodeIp = match.hostInstance.nodeIp
				if (nodeIp != hostIp) {
					trace('''IP changed to «nodeIp»''')
					depHost.ip = nodeIp
				}
				debug('''Updated mapped host with IP: «nodeIp»''')
			])
	}

	private def getDisappearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.DELETED,
			[ HostInstance.Match match |
				val traceMatch = engine.cps2depTrace.getOneArbitraryMatch(rootMapping, null, match.hostInstance,
					null).get
				val hostIp = match.hostInstance.nodeIp
				logger.debug('''Removing host with IP: «hostIp»''')
				rootMapping.deployment.hosts -= traceMatch.depElement as DeploymentHost
				rootMapping.traces -= traceMatch.trace
				logger.debug('''Removed host with IP: «hostIp»''')
			])
	}

}
