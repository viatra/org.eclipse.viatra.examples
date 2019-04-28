/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Akos Menyhert, Zoltan Ujhelyi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.applications;

import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.applications.statemachines.State;

public interface Application {
	
	State<?> getCurrentState();
	void stepToState(State nextState);
	
	boolean hasMessageFor(String trigger);
	public void sendTrigger(String trgHostIP, String trgAppID, String trgTransactionID);
	
	String getAppID();
	
}
