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


public class Transition {
	
	private State targetState;
	private State sourceState;
	
	private Transition triggeredTransition;
	private Transition triggeredBy;
	
	public void setTriggeredTransition(Transition t){
		triggeredTransition = t;
		t.triggeredBy = this;
	}
	
	public Transition getTriggeredTransition() {
		return triggeredTransition;
	}
	
	public void setTriggeredBy(Transition t){
		t.setTriggeredTransition(this);
	}
	
	public Transition getTriggeredBy() {
		return triggeredBy;
	}
	
	public State getTargetState() {
		return targetState;
	}

	public void setTargetState(State s) {
		targetState = s;
	}

	public State getSourceState() {
		return sourceState;
	}

	public void setSourceState(State sourceState) {
		this.sourceState = sourceState;
	}
	
	
}
