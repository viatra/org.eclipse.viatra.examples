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

public enum BehaviorISSBState implements State<BehaviorISSBState>{
     ///////////
	// States
	ISSWait {
        @Override
        public List<State<BehaviorISSBState>> possibleNextStates(Application app) {
        	List<State<BehaviorISSBState>> possibleStates = Lists.newArrayList();
        	
        	// Add Neutral Transitions
        	
        	// Add Send Transitions
        	        	
        	// Add Wait Transitions
        	if(app.hasMessageFor(ISS_RECEIVING)){
        		possibleStates.add(ISSReceived);
        	}
        	
        	return possibleStates;
        }
    },
    ISSReceived {
        @Override
        public List<State<BehaviorISSBState>> possibleNextStates(Application app) {
        	List<State<BehaviorISSBState>> possibleStates = Lists.newArrayList();
        	
        	// Add Neutral Transitions
        	possibleStates.add(ISSWait);
        	
        	// Add Send Transitions
        	        	
        	// Add Wait Transitions
        	
        	return possibleStates;
        }
    };
	
     ////////////
    // Triggers
    // TODO should be Enum...?
	public static final String ISS_RECEIVING = "ISSReceiving";
	
	 /////////////////
	// General part
	@Override
	abstract public List<State<BehaviorISSBState>> possibleNextStates(Application app);
	
	@Override
	public BehaviorISSBState stepTo(BehaviorISSBState nextState, Application app){
		if(possibleNextStates(app).contains(nextState)){
			return nextState;
		}
		return this;
	}

}
