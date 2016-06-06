/*******************************************************************************
 * Copyright (c) 2014-2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Akos Menyhert, Zoltan Ujhelyi - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.generator.dtos

import org.apache.log4j.Logger
import org.eclipse.viatra.examples.cps.deployment.Deployment
import org.eclipse.viatra.examples.cps.deployment.DeploymentPackage
import org.eclipse.viatra.examples.cps.generator.utils.StatsUtil
import org.eclipse.viatra.examples.cps.generator.utils.SumProcessor
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.query.runtime.base.api.ViatraBaseFactory

class DeploymentStats extends ModelStats {
	
	private Logger logger = Logger.getLogger("cps.generator.StatsUtil.DeploymentStats")
	
	public int deploymentHosts = 0;
	public int deploymentApps = 0;
	public int deploymentBehavior = 0;
	public int deploymentState = 0;
	public int deploymentTransition = 0;
	public int deploymentCurrent = 0;
	public int deploymentTrigger = 0;
	public int deploymentOutgoing = 0;

	def log() {
		logger.info("====================================================================")
		logger.info("= Deployment Stats: ");
		logger.info("=   Hosts: " + deploymentHosts);
		logger.info("=   Apps: " + deploymentApps);
		logger.info("=   Behaviors: " + deploymentBehavior);
		logger.info("=   States: " + deploymentState);
		logger.info("=   Transitions: " + deploymentTransition);
		logger.info("=   Current States: " + deploymentCurrent);
		logger.info("=   Triggers: " + deploymentTrigger);
		logger.info("=   Outgoing: " + deploymentOutgoing);
		logger.info("=   EObjects: " + eObjects);
		logger.info("=   EReferences: " + eReferences);
		logger.info("====================================================================")
	}
	
	new(ViatraQueryEngine engine, Deployment model){
		val baseIndex = ViatraBaseFactory.getInstance.createNavigationHelper(model.eResource.resourceSet, true, logger)
		//TODO one SumProcessor
		
		// EClasses
		val sumProcessor = new SumProcessor
		baseIndex.processAllInstances(DeploymentPackage.Literals.DEPLOYMENT_APPLICATION, sumProcessor)	
		this.deploymentApps = sumProcessor.sum
		sumProcessor.resetSum
		
		val sp = new SumProcessor
		baseIndex.processAllInstances(DeploymentPackage.Literals.DEPLOYMENT_HOST, sp)	
		this.deploymentHosts = sp.sum
		
		val sp2 = new SumProcessor
		baseIndex.processAllInstances(DeploymentPackage.Literals.DEPLOYMENT_BEHAVIOR, sp2)	
		this.deploymentBehavior = sp2.sum
		
		val sp3 = new SumProcessor
		baseIndex.processAllInstances(DeploymentPackage.Literals.BEHAVIOR_STATE, sp3)	
		this.deploymentState = sp3.sum
		
		val sp4 = new SumProcessor
		baseIndex.processAllInstances(DeploymentPackage.Literals.BEHAVIOR_TRANSITION, sp4)	
		this.deploymentTransition = sp4.sum
		
		// FEATURES
		val sp5 = new SumProcessor
		baseIndex.processAllFeatureInstances(DeploymentPackage.Literals.DEPLOYMENT_BEHAVIOR__CURRENT, sp5)	
		this.deploymentCurrent = sp5.sum
		
		val sp6 = new SumProcessor
		baseIndex.processAllFeatureInstances(DeploymentPackage.Literals.BEHAVIOR_TRANSITION__TRIGGER, sp6)	
		this.deploymentTrigger = sp6.sum
		
		val sp7 = new SumProcessor
		baseIndex.processAllFeatureInstances(DeploymentPackage.Literals.BEHAVIOR_STATE__OUTGOING, sp7)	
		this.deploymentOutgoing = sp7.sum
		
		this.eObjects = model.eAllContents.size
		this.eReferences = StatsUtil.countEdges(model)
		
		baseIndex.dispose
	}
}