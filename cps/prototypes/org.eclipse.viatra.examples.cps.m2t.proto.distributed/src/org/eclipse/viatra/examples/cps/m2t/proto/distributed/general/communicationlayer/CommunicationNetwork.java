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
package org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.communicationlayer;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.HostRunner;

public class CommunicationNetwork {
	private static Logger logger = Logger.getLogger("cps.proto.distributed.commnetwork"); 
	
	Map<String, HostRunner> hosts = new HashMap<String, HostRunner>();
	
	public void addHost(String ipAddress, HostRunner hostRunner){
		logger.info("Host added: " + ipAddress);
		hosts.put(ipAddress, hostRunner);
	}
	
	public void removeHost(String ipAddress){
		hosts.remove(ipAddress);
	}
	
	public synchronized void sendTrigger(String trgHostIP, String trgAppID, String trgTransactionID){
		HostRunner hostRunner = hosts.get(trgHostIP);
		if(hostRunner != null && hostRunner.hasHost()){
			hostRunner.getHost().receiveTrigger(trgAppID, trgTransactionID);
		}else{
			logger.info("Unknown ip adderss (" + trgHostIP + ") or dormant host");
		}
	}
	
}
