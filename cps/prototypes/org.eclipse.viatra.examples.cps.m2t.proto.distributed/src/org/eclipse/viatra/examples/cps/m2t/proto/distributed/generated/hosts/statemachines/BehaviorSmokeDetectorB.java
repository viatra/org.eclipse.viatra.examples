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
package org.eclipse.viatra.examples.cps.m2t.proto.distributed.generated.hosts.statemachines;

import java.util.List;

import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.applications.Application;
import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.applications.statemachines.State;

import com.google.common.collect.Lists;

public enum BehaviorSmokeDetectorB implements State<BehaviorSmokeDetectorB> {
	 ///////////
	// States
	SDInit {
        @Override
        public List<State<BehaviorSmokeDetectorB>> possibleNextStates(Application app) {
        	List<State<BehaviorSmokeDetectorB>> possibleStates = Lists.newArrayList();
        	
        	// Add Neutral Transitions
        	
        	// Add Send Transitions
        	possibleStates.add(SDSent);
        	
        	// Add Wait Transitions
        	
        	return possibleStates;
        }
        
        @Override
        public BehaviorSmokeDetectorB stepTo(BehaviorSmokeDetectorB nextState, Application app) {
        	// Send triggers
        	if(nextState == SDSent){
        		// Send to all corresponding App Instances on all Host Instances (send to N waiter)
        		app.sendTrigger("152.66.102.5", "IBM System Storage", "ISSReceiving");
        		return nextState;
        	}
        	
        	// Other cases (wait, neutral)
        	return super.stepTo(nextState, app);
        }
    },
    SDSent {
        @Override
        public List<State<BehaviorSmokeDetectorB>> possibleNextStates(Application app) {
        	List<State<BehaviorSmokeDetectorB>> possibleStates = Lists.newArrayList();
        	
        	// Add Neutral Transitions
        	possibleStates.add(SDInit);
        	
        	// Add Send Transitions
        	        	
        	// Add Wait Transitions
        	
        	return possibleStates;
        }
    };
	
     ////////////
    // Triggers
    
	 /////////////////
	// General part
	@Override
	abstract public List<State<BehaviorSmokeDetectorB>> possibleNextStates(Application app);
	
	@Override
	public BehaviorSmokeDetectorB stepTo(BehaviorSmokeDetectorB nextState, Application app){
		if(possibleNextStates(app).contains(nextState)){
			return nextState;
		}
		return this;
	}

}
