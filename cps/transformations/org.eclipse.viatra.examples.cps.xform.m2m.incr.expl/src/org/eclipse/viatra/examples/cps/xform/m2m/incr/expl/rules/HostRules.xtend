/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Zoltan Ujhelyi, Denes Harmath, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2m.incr.expl.rules

import org.eclipse.viatra.examples.cps.xform.m2m.incr.expl.queries.DeletedDeploymentHost
import org.eclipse.viatra.examples.cps.xform.m2m.incr.expl.queries.MonitoredHostInstance
import org.eclipse.viatra.examples.cps.xform.m2m.incr.expl.queries.UnmappedHostInstance
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.evm.specific.Jobs
import org.eclipse.viatra.transformation.evm.specific.Lifecycles
import org.eclipse.viatra.transformation.evm.specific.Rules
import org.eclipse.viatra.transformation.evm.specific.crud.CRUDActivationStateEnum
import java.util.Set
import org.eclipse.viatra.transformation.evm.api.RuleSpecification

class HostRules {
	static def Set<RuleSpecification<?>> getRules(ViatraQueryEngine engine) {
		#{
			new HostMapping(engine).specification,
			new HostUpdate(engine).specification,
			new HostRemoval(engine).specification
		}
	}
}

class HostMapping extends AbstractRule<UnmappedHostInstance.Match> {
	
	new(ViatraQueryEngine engine) {
		super(engine)
	}
	
	override getSpecification() {
		Rules.newMatcherRuleSpecification(
			unmappedHostInstance,
			Lifecycles.getDefault(false, false),
			#{appearedJob}
		)
	}
	
	private def getAppearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.CREATED, [UnmappedHostInstance.Match match |
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
	
}

class HostUpdate extends AbstractRule<MonitoredHostInstance.Match> {
	
	new(ViatraQueryEngine engine) {
		super(engine)
	}
	
	override getSpecification() {
		Rules.newMatcherRuleSpecification(
			monitoredHostInstance,
			Lifecycles.getDefault(true, true),
			#{appearedJob, disappearedJob, updatedJob}
		)
	}
	
	private def getAppearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.CREATED, [MonitoredHostInstance.Match match |
			val hostIp = match.hostInstance.nodeIp
			debug('''Starting monitoring mapped host with IP: «hostIp»''')
		])
	}
	
	private def getDisappearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.DELETED, [MonitoredHostInstance.Match match |
			val hostIp = match.hostInstance.nodeIp
			debug('''Stopped monitoring mapped host with IP: «hostIp»''')
		])
	}
	
	private def getUpdatedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.UPDATED, [MonitoredHostInstance.Match match |
			val hostIp = match.hostInstance.nodeIp
			debug('''Updating mapped host with IP: «hostIp»''')
			val depHosts = getMappedHostInstance(engine).getAllValuesOfdepHost(match.hostInstance)
			depHosts.forEach[
				val nodeIp = ip
				if(nodeIp != hostIp){
					trace('''IP changed to «hostIp»''')
					ip = hostIp
				}
			]
			debug('''Updated mapped host with IP: «hostIp»''')
		])
	}
}

class HostRemoval extends AbstractRule<DeletedDeploymentHost.Match> {
	
	new(ViatraQueryEngine engine) {
		super(engine)
	}
	
	override getSpecification() {
		Rules.newMatcherRuleSpecification(
			deletedDeploymentHost,
			Lifecycles.getDefault(false, false),
			#{appearedJob}
		)
	}
	
	private def getAppearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.CREATED, [DeletedDeploymentHost.Match match |
			val depHost = match.depHost
			val hostIp = depHost.ip
			logger.debug('''Removing host with IP: «hostIp»''')
			rootMapping.deployment.hosts -= depHost
			rootMapping.traces -= match.trace
			logger.debug('''Removed host with IP: «hostIp»''')
		])
	} 
}