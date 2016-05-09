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
package org.eclipse.viatra.examples.cps.m2t.proto.distributed.generated.applications;

import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.applications.BaseApplication;
import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.hosts.Host;
import org.eclipse.viatra.examples.cps.m2t.proto.distributed.generated.hosts.statemachines.BehaviorISSBState;


public class IBMSystemStorageApplication extends BaseApplication<BehaviorISSBState> {

	// Set ApplicationID
	protected static final String APP_ID = "IBM System Storage";

	public IBMSystemStorageApplication(Host host) {
		super(host);
		
		// Set initial State
		currentState = BehaviorISSBState.ISSWait;
	}
	
	@Override
	public String getAppID() {
		return APP_ID;
	}
	
}
