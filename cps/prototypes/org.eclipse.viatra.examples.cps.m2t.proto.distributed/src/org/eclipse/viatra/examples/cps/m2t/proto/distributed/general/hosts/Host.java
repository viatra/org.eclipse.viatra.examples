/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Akos Menyhert, Zoltan Ujhelyi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.hosts;

import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.applications.Application;
import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.applications.statemachines.State;

public interface Host {

	Iterable<State> calculatePossibleNextStates();
	boolean hasMessageFor(String appID, String trigger);
	void sendTrigger(String trgHostIP, String trgAppID, String trgTransactionID);
	void receiveTrigger(String trgAppID, String trgTransactionID);
	
	Iterable<Application> getApplications();
}
