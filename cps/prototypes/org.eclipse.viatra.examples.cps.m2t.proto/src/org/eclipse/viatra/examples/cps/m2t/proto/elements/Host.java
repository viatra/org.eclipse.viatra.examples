/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Akos Menyhert, Zoltan Ujhelyi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.m2t.proto.elements;

import java.util.ArrayList;
import java.util.List;

public class Host {
	private List<Application> apps = new ArrayList<Application>();
	
	public List<Application> getApps() {
		return apps;
	}
	
	public void addApp(Application app) {
		apps.add(app);
	}
}
