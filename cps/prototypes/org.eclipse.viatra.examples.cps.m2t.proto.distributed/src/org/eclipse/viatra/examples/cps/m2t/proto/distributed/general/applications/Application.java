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
package org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.applications;

import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.applications.statemachines.State;

public interface Application {
	
	State<?> getCurrentState();
	void stepToState(State nextState);
	
	boolean hasMessageFor(String trigger);
	public void sendTrigger(String trgHostIP, String trgAppID, String trgTransactionID);
	
	String getAppID();
	
}
