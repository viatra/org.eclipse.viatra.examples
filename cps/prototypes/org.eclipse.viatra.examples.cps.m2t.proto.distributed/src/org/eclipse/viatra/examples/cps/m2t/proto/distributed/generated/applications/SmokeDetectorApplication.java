/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Akos Menyhert, Zoltan Ujhelyi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.m2t.proto.distributed.generated.applications;

import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.applications.BaseApplication;
import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.hosts.Host;
import org.eclipse.viatra.examples.cps.m2t.proto.distributed.generated.hosts.statemachines.BehaviorSmokeDetectorB;


public class SmokeDetectorApplication extends BaseApplication<BehaviorSmokeDetectorB> {

	protected static final String APP_ID = "Smoke Detector";

	public SmokeDetectorApplication(Host host) {
		super(host);
		
		// Set initial State
		currentState = BehaviorSmokeDetectorB.SDInit;
	}
	
	@Override
	public String getAppID() {
		return APP_ID;
	}
	
}
