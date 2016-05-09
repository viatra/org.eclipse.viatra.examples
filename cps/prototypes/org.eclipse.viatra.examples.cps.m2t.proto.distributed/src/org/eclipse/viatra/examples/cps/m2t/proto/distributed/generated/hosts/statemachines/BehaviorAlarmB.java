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

import org.apache.log4j.Logger;
import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.applications.Application;
import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.applications.statemachines.State;

import com.google.common.collect.Lists;

public enum BehaviorAlarmB implements State<BehaviorAlarmB> {
	 ///////////
	// States
	AInit {
        @Override
        public List<State<BehaviorAlarmB>> possibleNextStates(Application app) {
        	List<State<BehaviorAlarmB>> possibleStates = Lists.newArrayList();
        	
        	// Add Neutral Transitions
        	
        	// Add Send Transitions
        	possibleStates.add(ASent);
        	
        	// Add Wait Transitions
        	
        	return possibleStates;
        }
        
        @Override
        public BehaviorAlarmB stepTo(BehaviorAlarmB nextState, Application app) {
        	// Send triggers
        	if(nextState == ASent){
        		app.sendTrigger("152.66.102.5", "IBM System Storage", "ISSReceiving");
        		return super.stepTo(nextState, app); // TODO remove--> else if needed!
        	}
        	
        	// Other cases (wait, neutral)
        	return super.stepTo(nextState, app);
        }
    },
    ASent {
        @Override
        public List<State<BehaviorAlarmB>> possibleNextStates(Application app) {
        	List<State<BehaviorAlarmB>> possibleStates = Lists.newArrayList();
        	
        	// Add Neutral Transitions
        	possibleStates.add(AInit);
        	
        	// Add Send Transitions
        	        	
        	// Add Wait Transitions
        	
        	return possibleStates;
        }
    };
	
    private static Logger logger = Logger.getLogger("cps.proto.distributed.state");
    
     ////////////
    // Triggers
    
	 /////////////////
	// General part
	@Override
	abstract public List<State<BehaviorAlarmB>> possibleNextStates(Application app);
	
	@Override
	public BehaviorAlarmB stepTo(BehaviorAlarmB nextState, Application app){
		if(possibleNextStates(app).contains(nextState)){
			logger.info("Step from " + this.name() + " to " + nextState.name());
			return nextState;
		}else{
			logger.info("!!! Warning: Unable to step from " + this.name() + " to " + nextState.name() 
					+ " because the target state is not possible state.");
		}
		return this;
	}

}
