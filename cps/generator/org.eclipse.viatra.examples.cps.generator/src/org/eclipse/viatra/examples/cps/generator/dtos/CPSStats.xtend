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

import java.util.LinkedHashSet
import org.apache.log4j.Logger
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystem
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition
import org.eclipse.viatra.examples.cps.generator.phases.CPSPhaseActionGeneration
import org.eclipse.viatra.examples.cps.generator.queries.AllocatedAppInstancesMatcher
import org.eclipse.viatra.examples.cps.generator.queries.AppInstancesMatcher
import org.eclipse.viatra.examples.cps.generator.queries.AppTypesMatcher
import org.eclipse.viatra.examples.cps.generator.queries.ConnectedHostsMatcher
import org.eclipse.viatra.examples.cps.generator.queries.HostInstancesMatcher
import org.eclipse.viatra.examples.cps.generator.queries.HostTypesMatcher
import org.eclipse.viatra.examples.cps.generator.queries.StatesMatcher
import org.eclipse.viatra.examples.cps.generator.queries.TransitionWithoutActionMatcher
import org.eclipse.viatra.examples.cps.generator.queries.TransitionsMatcher
import org.eclipse.viatra.examples.cps.generator.utils.StatsUtil
import org.eclipse.viatra.examples.cps.generator.utils.SumProcessor
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.query.runtime.base.api.ViatraBaseFactory

class CPSStats extends ModelStats {
	
	private Logger logger = Logger.getLogger("cps.generator.StatsUtil.CPSStats")
	
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
		this.appTypeCount = AppTypesMatcher.on(engine).countMatches;
		this.appInstanceCount = AppInstancesMatcher.on(engine).countMatches;
		this.hostTypeCount = HostTypesMatcher.on(engine).countMatches;
		this.hostInstanceCount = HostInstancesMatcher.on(engine).countMatches;
		this.stateCount = StatesMatcher.on(engine).countMatches;
		this.transitionCount = TransitionsMatcher.on(engine).countMatches;
		this.allocatedAppCount = AllocatedAppInstancesMatcher.on(engine).countMatches;
		this.connectedHostCount = ConnectedHostsMatcher.on(engine).countMatches;
		this.eObjects = model.eAllContents.size;
		this.eReferences = StatsUtil.countEdges(model)
		this.emptyTransition = TransitionWithoutActionMatcher.on(engine).countMatches;
		
		val baseIndex = ViatraBaseFactory.getInstance.createNavigationHelper(model.eResource.resourceSet, true, logger)
		
		// EFeatures
		val sp2 = new SumProcessor
		baseIndex.processAllFeatureInstances(CyberPhysicalSystemPackage.Literals.TRANSITION__ACTION, [source,target |
				if (source instanceof Transition){
					val Transition t = source as Transition
					if(t.action.startsWith(CPSPhaseActionGeneration.SEND_METHOD_NAME)){
						sendActions++
					}else if(t.action.startsWith(CPSPhaseActionGeneration.WAIT_METHOD_NAME)){
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