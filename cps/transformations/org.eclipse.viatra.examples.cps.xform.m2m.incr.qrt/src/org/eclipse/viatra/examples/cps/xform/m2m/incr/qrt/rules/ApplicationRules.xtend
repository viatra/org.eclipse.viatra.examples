/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Marton Bur, Zoltan Ujhelyi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2m.incr.qrt.rules

import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication
import org.eclipse.viatra.examples.cps.deployment.DeploymentHost
import org.eclipse.viatra.examples.cps.traceability.CPS2DeploymentTrace
import org.eclipse.viatra.examples.cps.xform.m2m.incr.qrt.queries.ApplicationInstance
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.evm.specific.Jobs
import org.eclipse.viatra.transformation.evm.specific.Lifecycles
import org.eclipse.viatra.transformation.evm.specific.Rules
import org.eclipse.viatra.transformation.evm.specific.crud.CRUDActivationStateEnum

class ApplicationRules {
	static def getRules(ViatraQueryEngine engine) {
		#{
			new ApplicationMapping(engine).specification
		}
	}
}

class ApplicationMapping extends AbstractRule<ApplicationInstance.Match> {

	new(ViatraQueryEngine engine) {
		super(engine)
	}

	override getSpecification() {
		createPriorityRuleSpecification => [
			ruleSpecification = Rules.newMatcherRuleSpecification(applicationInstance, Lifecycles.getDefault(true, true),
				#{appearedJob, updateJob, disappearedJob})
			priority = 2
		]
	}

	private def getAppearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.CREATED,
			[ ApplicationInstance.Match match |
				val depHost = engine.cps2depTrace.getAllValuesOfdepElement(null, null, match.appInstance.allocatedTo).filter(DeploymentHost).head
				val appId = match.appInstance.identifier
				debug('''Mapping application with ID: «appId»''')
				val app = createDeploymentApplication => [
					id = appId
				]
				depHost.applications += app
				rootMapping.traces += createCPS2DeploymentTrace => [
					cpsElements += match.appInstance
					deploymentElements += app
				]
				debug('''Mapped application with ID: «appId»''')
			])
	}

	private def getUpdateJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.UPDATED,
			[ ApplicationInstance.Match match |
			    // Optional.get is correct as the update job can only run if the traceability exists
				val depApp = engine.cps2depTrace.getOneArbitraryMatch(rootMapping, null, match.appInstance, null).
					get.depElement as DeploymentApplication
				if (depApp.id != match.appInstance.identifier)
					depApp.id = match.appInstance.identifier
			])
	}

	private def getDisappearedJob() {
		Jobs.newStatelessJob(CRUDActivationStateEnum.DELETED,
			[ ApplicationInstance.Match match |
				val trace = engine.cps2depTrace.getAllValuesOftrace(null, match.appInstance, null).filter(CPS2DeploymentTrace).head
				val depApp = trace.deploymentElements.head as DeploymentApplication
				engine.allocatedDeploymentApplication.getAllValuesOfdepHost(depApp).head.applications -= depApp
				rootMapping.traces -= trace
			])
	}
}
