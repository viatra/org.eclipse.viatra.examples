/*******************************************************************************
 * Copyright (c) 2014, 2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Marton Bur, Zoltan Ujhelyi - initial API and implementation
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
