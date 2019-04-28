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

public class Application {
	
	private List<State> states = new ArrayList<State>();
	private State currentState;
	
	private List<Transition> transitions;
	
	public void addState(State s) {
		states.add(s);
		s.setApplication(this);
	}
	
	public void addTransition(Transition t) {
		transitions.add(t);
	}
	
	public State getCurrentState() {
		return currentState;
	}
	
	public List<State> getStates() {
		return states;
	}

	public void setCurrent(State s) {
		this.currentState = s;
	}
	
	
}
