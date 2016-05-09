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

import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication
import org.eclipse.viatra.examples.cps.xform.m2m.incr.expl.queries.DeletedApplicationInstanceMatch
import org.eclipse.viatra.examples.cps.xform.m2m.incr.expl.queries.MonitoredApplicationInstanceMatch
import org.eclipse.viatra.examples.cps.xform.m2m.incr.expl.queries.UnmappedApplicationInstanceMatch
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.evm.specific.Jobs
import org.eclipse.viatra.transformation.evm.specific.Lifecycles
import org.eclipse.viatra.transformation.evm.specific.Rules
import org.eclipse.viatra.transformation.evm.specific.crud.CRUDActivationStateEnum

class ApplicationRules {
	static def getRules(ViatraQueryEngine engine) {
		#{
			new ApplicationMapping(engine).specification
			,new ApplicationUpdate(engine).specification
			,new ApplicationRemoval(engine).specification
		}
	}
}

class ApplicationMapping extends AbstractRule<UnmappedApplicationInstanceMatch> {
	
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
		Jobs.newStatelessJob(CRUDActivationStateEnum.CREATED, [UnmappedApplicationInstanceMatch match |
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

class ApplicationUpdate extends AbstractRule<MonitoredApplicationInstanceMatch> {
	
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
		Jobs.newStatelessJob(CRUDActivationStateEnum.CREATED, [MonitoredApplicationInstanceMatch match |
			val appId = match.appInstance.identifier
			debug('''Starting monitoring mapped application with ID: «appId»''')
		])
	}
	
	private def getDisappearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.DELETED, [MonitoredApplicationInstanceMatch match |
			val appId = match.appInstance.identifier
			debug('''Stopped monitoring mapped application with ID: «appId»''')
		])
	}
	
	private def getUpdatedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.UPDATED, [MonitoredApplicationInstanceMatch match |
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

class ApplicationRemoval extends AbstractRule<DeletedApplicationInstanceMatch> {
	
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
		Jobs.newStatelessJob(CRUDActivationStateEnum.CREATED, [DeletedApplicationInstanceMatch match |
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