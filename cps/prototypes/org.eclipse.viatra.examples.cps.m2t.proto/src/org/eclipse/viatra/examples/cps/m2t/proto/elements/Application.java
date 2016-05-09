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
