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

import org.eclipse.viatra.examples.cps.deployment.DeploymentHost
import org.eclipse.viatra.examples.cps.xform.m2m.incr.qrt.queries.HostInstanceMatch
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

class HostMapping extends AbstractRule<HostInstanceMatch> {

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
			[ HostInstanceMatch match |
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
			[ HostInstanceMatch match |
				val depHost = engine.cps2depTrace.getOneArbitraryMatch(rootMapping, null, match.hostInstance, null).
					depElement as DeploymentHost
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
			[ HostInstanceMatch match |
				val traceMatch = engine.cps2depTrace.getOneArbitraryMatch(rootMapping, null, match.hostInstance,
					null)
				val hostIp = match.hostInstance.nodeIp
				logger.debug('''Removing host with IP: «hostIp»''')
				rootMapping.deployment.hosts -= traceMatch.depElement as DeploymentHost
				rootMapping.traces -= traceMatch.trace
				logger.debug('''Removed host with IP: «hostIp»''')
			])
	}

}
