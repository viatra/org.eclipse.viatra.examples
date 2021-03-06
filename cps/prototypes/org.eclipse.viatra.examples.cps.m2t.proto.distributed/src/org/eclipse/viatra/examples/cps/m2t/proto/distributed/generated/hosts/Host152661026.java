/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Akos Menyhert, Zoltan Ujhelyi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.m2t.proto.distributed.generated.hosts;

import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.applications.Application;
import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.communicationlayer.CommunicationNetwork;
import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.hosts.BaseHost;
import org.eclipse.viatra.examples.cps.m2t.proto.distributed.generated.applications.AlarmApplication;
import org.eclipse.viatra.examples.cps.m2t.proto.distributed.generated.applications.CameraApplication;
import org.eclipse.viatra.examples.cps.m2t.proto.distributed.generated.applications.SmokeDetectorApplication;

import com.google.common.collect.Lists;


public class Host152661026 extends BaseHost {
	
	public Host152661026(CommunicationNetwork network) {
		super(network);
		// Add Applications of Host
		applications = Lists.<Application>newArrayList(
				new CameraApplication(this),
				new AlarmApplication(this),
				new SmokeDetectorApplication(this)				
		);
	}

} 
