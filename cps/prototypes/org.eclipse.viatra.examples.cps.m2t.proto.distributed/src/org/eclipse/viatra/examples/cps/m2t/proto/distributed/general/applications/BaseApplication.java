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
import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.hosts.Host;

public abstract class BaseApplication<StateType extends State> implements Application {

	
	protected StateType currentState;
	protected Host host;

	@Override
	abstract public String getAppID();
	
	public BaseApplication(Host host) {
		this.host = host;
	}
	
	@Override
	public StateType getCurrentState() {
		return currentState;
	}

	@Override
	public boolean hasMessageFor(String trigger) {
		return host.hasMessageFor(getAppID(), trigger);
	}

	@Override
	public void sendTrigger(String trgHostIP, String trgAppID, String trgTransactionID) {
		host.sendTrigger(trgHostIP, trgAppID, trgTransactionID);
	}

	@Override
	public void stepToState(State nextState) {
		// TODO ...
		State newState = currentState.stepTo(nextState, this);
		currentState = (StateType) newState;
	}

}
