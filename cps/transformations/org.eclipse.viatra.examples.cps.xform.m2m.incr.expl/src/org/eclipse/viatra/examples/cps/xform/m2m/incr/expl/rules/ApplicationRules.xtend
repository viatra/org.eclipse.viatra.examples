/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Zoltan Ujhelyi, Denes Harmath, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2m.incr.expl.rules

import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication
import org.eclipse.viatra.examples.cps.xform.m2m.incr.expl.queries.DeletedApplicationInstance
import org.eclipse.viatra.examples.cps.xform.m2m.incr.expl.queries.MonitoredApplicationInstance
import org.eclipse.viatra.examples.cps.xform.m2m.incr.expl.queries.UnmappedApplicationInstance
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.evm.specific.Jobs
import org.eclipse.viatra.transformation.evm.specific.Lifecycles
import org.eclipse.viatra.transformation.evm.specific.Rules
import org.eclipse.viatra.transformation.evm.specific.crud.CRUDActivationStateEnum
import java.util.Set
import org.eclipse.viatra.transformation.evm.api.RuleSpecification

class ApplicationRules {
	static def Set<RuleSpecification<?>> getRules(ViatraQueryEngine engine) {
		#{
			new ApplicationMapping(engine).specification,
			new ApplicationUpdate(engine).specification,
			new ApplicationRemoval(engine).specification
		}
	}
}

class ApplicationMapping extends AbstractRule<UnmappedApplicationInstance.Match> {
	
	new(ViatraQueryEngine engine) {
		super(engine)
	}
	
	override getSpecification() {
		Rules.newMatcherRuleSpecification(
			unmappedApplicationInstance,
			Lifecycles.getDefault(false, false),
			#{appearedJob}
		)
	}
	
	private def getAppearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.CREATED, [UnmappedApplicationInstance.Match match |
			val appId = match.appInstance.identifier
			debug('''Mapping application with ID: «appId»''')
			val app = createDeploymentApplication => [
				id = appId
			]
			match.depHost.applications += app
			rootMapping.traces += createCPS2DeploymentTrace => [
				cpsElements += match.appInstance
				deploymentElements += app
			]
			debug('''Mapped application with ID: «appId»''')
		])
	}
}

class ApplicationUpdate extends AbstractRule<MonitoredApplicationInstance.Match> {
	
	new(ViatraQueryEngine engine) {
		super(engine)
	}
	
	override getSpecification() {
		Rules.newMatcherRuleSpecification(
			monitoredApplicationInstance,
			Lifecycles.getDefault(true, true),
			#{appearedJob, disappearedJob, updatedJob}
		)
	}
	
	private def getAppearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.CREATED, [MonitoredApplicationInstance.Match match |
			val appId = match.appInstance.identifier
			debug('''Starting monitoring mapped application with ID: «appId»''')
		])
	}
	
	private def getDisappearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.DELETED, [MonitoredApplicationInstance.Match match |
			val appId = match.appInstance.identifier
			debug('''Stopped monitoring mapped application with ID: «appId»''')
		])
	}
	
	private def getUpdatedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.UPDATED, [MonitoredApplicationInstance.Match match |
			val app = match.appInstance
			val appId = app.identifier
			debug('''Updating application with ID: «appId»''')
			val depAppMatches = getMappedApplicationInstance(engine).getAllMatches(app, null, null, null)
			depAppMatches.forEach[
				val depAppId = depApp.id
				if(appId != depAppId){
					trace('''ID updated from «appId» to «depAppId»''')
					depApp.id = appId
				}
				if(!depHost.applications.contains(depApp)){
					trace('''Host changed to «depHost.ip»''')
					depHost.applications += depApp
				}
			]
			debug('''Updated application with ID: «appId»''')
		])
	}
}

class ApplicationRemoval extends AbstractRule<DeletedApplicationInstance.Match> {
	
	new(ViatraQueryEngine engine) {
		super(engine)
	}
	
	override getSpecification() {
		Rules.newMatcherRuleSpecification(
			deletedApplicationInstance,
			Lifecycles.getDefault(false, false),
			#{appearedJob}
		)
	}
	
	private def getAppearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.CREATED, [DeletedApplicationInstance.Match match |
			val depApp = match.depApp as DeploymentApplication
			val depAppId = depApp.id
			debug('''Removing application with ID: «depAppId»''')
			val hosts = engine.deploymentHostApplications.getAllValuesOfdepHost(depApp)
			if(!hosts.empty){
				hosts.head.applications -= depApp
			}
			rootMapping.traces -= match.trace
			debug('''Removed application with ID: «depAppId»''')
		])
	}
}