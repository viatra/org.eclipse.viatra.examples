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

public class State {
	
	private List<Transition> outgoingTransitions = new ArrayList<Transition>();
	
	private Application application;
	
	public void addOutgoingTransition(Transition t) {
		outgoingTransitions.add(t);
		t.setSourceState(this);
	}
	
	public List<Transition> getOutgoingTransitions() {
		return outgoingTransitions;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}
	
}
