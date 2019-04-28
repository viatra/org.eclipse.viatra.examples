/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Akos Menyhert, Zoltan Ujhelyi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.generator.dtos

import java.util.LinkedHashSet
import org.apache.log4j.Logger
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystem
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition
import org.eclipse.viatra.examples.cps.generator.phases.CPSPhaseActionGeneration
import org.eclipse.viatra.examples.cps.generator.queries.AllocatedAppInstances
import org.eclipse.viatra.examples.cps.generator.queries.AppInstances
import org.eclipse.viatra.examples.cps.generator.queries.AppTypes
import org.eclipse.viatra.examples.cps.generator.queries.ConnectedHosts
import org.eclipse.viatra.examples.cps.generator.queries.HostInstances
import org.eclipse.viatra.examples.cps.generator.queries.HostTypes
import org.eclipse.viatra.examples.cps.generator.queries.States
import org.eclipse.viatra.examples.cps.generator.queries.TransitionWithoutAction
import org.eclipse.viatra.examples.cps.generator.queries.Transitions
import org.eclipse.viatra.examples.cps.generator.utils.StatsUtil
import org.eclipse.viatra.examples.cps.generator.utils.SumProcessor
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.query.runtime.base.api.ViatraBaseFactory

class CPSStats extends ModelStats {
	
	Logger logger = Logger.getLogger("cps.generator.StatsUtil.CPSStats")
	
	public int appTypeCount = 0;
	public int appInstanceCount = 0;
	public int hostTypeCount = 0;
	public int hostInstanceCount = 0;
	public int stateCount = 0;
	public int transitionCount = 0;
	public int allocatedAppCount = 0;
	public int connectedHostCount = 0;
	public int sendActions = 0;
	public int waitActions = 0;
	public int emptyTransition = 0;
	public int duplicateIds = 0;

	new(ViatraQueryEngine engine, CyberPhysicalSystem model){
		this.appTypeCount = AppTypes.Matcher.on(engine).countMatches;
		this.appInstanceCount = AppInstances.Matcher.on(engine).countMatches;
		this.hostTypeCount = HostTypes.Matcher.on(engine).countMatches;
		this.hostInstanceCount = HostInstances.Matcher.on(engine).countMatches;
		this.stateCount = States.Matcher.on(engine).countMatches;
		this.transitionCount = Transitions.Matcher.on(engine).countMatches;
		this.allocatedAppCount = AllocatedAppInstances.Matcher.on(engine).countMatches;
		this.connectedHostCount = ConnectedHosts.Matcher.on(engine).countMatches;
		this.eObjects = model.eAllContents.size;
		this.eReferences = StatsUtil.countEdges(model)
		this.emptyTransition = TransitionWithoutAction.Matcher.on(engine).countMatches;
		
		val baseIndex = ViatraBaseFactory.getInstance.createNavigationHelper(model.eResource.resourceSet, true, logger)
		
		// EFeatures
		val sp2 = new SumProcessor
		baseIndex.processAllFeatureInstances(CyberPhysicalSystemPackage.Literals.TRANSITION__ACTION, [source,target |
				if (source instanceof Transition){
					if(source.action.startsWith(CPSPhaseActionGeneration.SEND_METHOD_NAME)){
						sendActions++
					}else if(source.action.startsWith(CPSPhaseActionGeneration.WAIT_METHOD_NAME)){
						waitActions++
					}
				}
		])	
		sp2.resetSum
		
		val appInstanceIdentifiers = baseIndex.getAllInstances(CyberPhysicalSystemPackage.Literals.APPLICATION_INSTANCE).filter(ApplicationInstance).map[it.identifier].toList
		val uniqueAppInstanceIdentifiers = new LinkedHashSet
		appInstanceIdentifiers.forEach[
			val added = uniqueAppInstanceIdentifiers.add(it)
		    if(!added){
		    	duplicateIds++
		    	logger.error('''Non-unique ApplicationInstance identifier: «it»''')
		    }
		]
		
		baseIndex.dispose
		
	}
	
	def log() {
		logger.info("====================================================================")
		logger.info("= CPS Stats: ");
		logger.info("=   ApplicationTypes: " + appTypeCount);
		logger.info("=   ApplicationInstances: " + appInstanceCount);
		logger.info("=   HostTypes: " + hostTypeCount);
		logger.info("=   HostInstances: " + hostInstanceCount);
		logger.info("=   States: " + stateCount);
		logger.info("=   Transitions: " + transitionCount);
		logger.info("=     Send: " + sendActions);
		logger.info("=     Wait: " + waitActions);
		logger.info("=     Without action: " + emptyTransition);
		logger.info("=   Allocated AppInstances: " + allocatedAppCount);
		logger.info("=   Connected HostsInstances: " + connectedHostCount);
		logger.info("=   EObjects: " + eObjects);
		logger.info("=   EReferences: " + eReferences);
		logger.info("=   Duplicate AppInstance IDs: " + duplicateIds);
		logger.info("====================================================================")
	}
	
}