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

import org.eclipse.viatra.examples.cps.xform.m2m.incr.expl.queries.DeletedDeploymentHostMatch
import org.eclipse.viatra.examples.cps.xform.m2m.incr.expl.queries.MonitoredHostInstanceMatch
import org.eclipse.viatra.examples.cps.xform.m2m.incr.expl.queries.UnmappedHostInstanceMatch
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.evm.specific.Jobs
import org.eclipse.viatra.transformation.evm.specific.Lifecycles
import org.eclipse.viatra.transformation.evm.specific.Rules
import org.eclipse.viatra.transformation.evm.specific.crud.CRUDActivationStateEnum

class HostRules {
	static def getRules(ViatraQueryEngine engine) {
		#{
			new HostMapping(engine).specification
			,new HostUpdate(engine).specification
			,new HostRemoval(engine).specification
		}
	}
}

class HostMapping extends AbstractRule<UnmappedHostInstanceMatch> {
	
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
		Jobs.newStatelessJob(CRUDActivationStateEnum.CREATED, [UnmappedHostInstanceMatch match |
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

class HostUpdate extends AbstractRule<MonitoredHostInstanceMatch> {
	
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
		Jobs.newStatelessJob(CRUDActivationStateEnum.CREATED, [MonitoredHostInstanceMatch match |
			val hostIp = match.hostInstance.nodeIp
			debug('''Starting monitoring mapped host with IP: «hostIp»''')
		])
	}
	
	private def getDisappearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.DELETED, [MonitoredHostInstanceMatch match |
			val hostIp = match.hostInstance.nodeIp
			debug('''Stopped monitoring mapped host with IP: «hostIp»''')
		])
	}
	
	private def getUpdatedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.UPDATED, [MonitoredHostInstanceMatch match |
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

class HostRemoval extends AbstractRule<DeletedDeploymentHostMatch> {
	
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
		Jobs.newStatelessJob(CRUDActivationStateEnum.CREATED, [DeletedDeploymentHostMatch match |
			val depHost = match.depHost
			val hostIp = depHost.ip
			logger.debug('''Removing host with IP: «hostIp»''')
			rootMapping.deployment.hosts -= depHost
			rootMapping.traces -= match.trace
			logger.debug('''Removed host with IP: «hostIp»''')
		])
	} 
}