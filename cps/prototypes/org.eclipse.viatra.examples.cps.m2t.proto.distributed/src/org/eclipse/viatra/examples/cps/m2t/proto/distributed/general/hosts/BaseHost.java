/*******************************************************************************
 * Copyright (c) 2014, 2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Akos Menyhert, Zoltan Ujhelyi - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.hosts;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.applications.Application;
import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.applications.statemachines.State;
import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.communicationlayer.CommunicationNetwork;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;

public abstract class BaseHost implements Host{

	protected static Logger logger = Logger.getLogger("cps.proto.distributed.hostengine");
	
	// Table<AppID, TriggerID, Date>
	protected Table<String, String, Date> triggers = HashBasedTable.create();
	
	// Applications
	protected List<Application> applications;

	private CommunicationNetwork network;
	
	
	public BaseHost(CommunicationNetwork network) {
		this.network = network;
	}
	
	public Iterable<State> calculatePossibleNextStates(){
		List<State> states = Lists.newArrayList();

		for (Application app : applications) {
			states.addAll(app.getCurrentState().possibleNextStates(app));
		}
		
		return states;
	}

	@Override
	public boolean hasMessageFor(String appID, String trigger) {
		Map<String, Date> appTriggers = triggers.row(appID);
		logger.info("Has message for " + trigger + "?  --> " + appTriggers.containsKey(trigger));
		
		return appTriggers.containsKey(trigger);
	}

	@Override
	public void sendTrigger(String trgHostIP, String trgAppID, String trgTransactionID) {
		logger.info("Send trigger to " + trgHostIP + " : " + trgAppID + " : " + trgTransactionID);

		network.sendTrigger(trgHostIP, trgAppID, trgTransactionID);
	}
	
	
	@Override
	public synchronized void receiveTrigger(String trgAppID, String trgTransactionID) {
		logger.info("Received trigger[ AppID: " + trgAppID + ", TriggerID: " + trgTransactionID + "]");
		
		triggers.put(trgAppID, trgTransactionID, new Date());
	}
	
	@Override
	public Iterable<Application> getApplications(){
		return applications;
	}
	
}
