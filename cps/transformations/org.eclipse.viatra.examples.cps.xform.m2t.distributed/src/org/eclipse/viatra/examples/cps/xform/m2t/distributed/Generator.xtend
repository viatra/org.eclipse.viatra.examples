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
package org.eclipse.viatra.examples.cps.xform.m2t.distributed

import com.google.common.base.Joiner
import com.google.common.collect.Lists
import java.util.HashMap
import org.eclipse.viatra.examples.cps.deployment.BehaviorState
import org.eclipse.viatra.examples.cps.deployment.BehaviorTransition
import org.eclipse.viatra.examples.cps.deployment.Deployment
import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication
import org.eclipse.viatra.examples.cps.deployment.DeploymentBehavior
import org.eclipse.viatra.examples.cps.deployment.DeploymentHost
import org.eclipse.viatra.examples.cps.deployment.common.WaitTransitionMatcher
import org.eclipse.viatra.examples.cps.xform.m2t.exceptions.CPSGeneratorException
import org.eclipse.viatra.examples.cps.xform.m2t.util.FormatterUtil
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.jdt.core.ToolFactory
import org.eclipse.jdt.core.formatter.CodeFormatter

class Generator {
	
	extension FormatterUtil helper = new FormatterUtil
	
	val String PROJECT_NAME
	val ViatraQueryEngine engine
	val CodeFormatter formatter
	
	new(String projectName, ViatraQueryEngine engine){
		PROJECT_NAME = projectName
		this.engine = engine
		this.formatter = ToolFactory.createCodeFormatter(null);
	}
	
	def generateHostCode(DeploymentHost host) '''
	package «PROJECT_NAME».hosts;

	import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.applications.Application;
	import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.communicationlayer.CommunicationNetwork;
	import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.hosts.BaseHost;
	import com.google.common.collect.Lists;
	«FOR app : host.applications»
	import «PROJECT_NAME».applications.«app.id.purifyAndToUpperCamel»Application;
	«ENDFOR»

	
	public class Host«host.ip.purifyAndToUpperCamel» extends BaseHost {
		
		public Host«host.ip.purifyAndToUpperCamel»(CommunicationNetwork network) {
			super(network);
			// Add Applications of Host
			applications = Lists.<Application>newArrayList(
			«Joiner.on(',').join(host.calculateAppListForHost)»
			);
		}
	
	} 
	'''
	
	def calculateAppListForHost(DeploymentHost host){
		val list = Lists.<CharSequence>newArrayList;
		for(app : host.applications){
			list.add('''new «app.id.purifyAndToUpperCamel»Application(this)''')
		}
		list
	}
	
	def generateApplicationCode(DeploymentApplication app)'''
		«val behavior = "Behavior"+app.id.purifyAndToUpperCamel»
		«val appClassName = app.id.purifyAndToUpperCamel + "Application"»
		package «PROJECT_NAME».applications;
			
		import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.applications.BaseApplication;
		import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.hosts.Host;
		
		import «PROJECT_NAME».hosts.statemachines.«behavior»;
		
		
		public class «appClassName» extends BaseApplication<«behavior»> {
		
			// Set ApplicationID
			protected static final String APP_ID = "«app.id»";
		
			public «appClassName»(Host host) {
				super(host);
				
				«IF app?.behavior?.current != null»
				// Set initial State
				currentState = «behavior».«app.behavior.current.description.purifyAndToUpperCamel»;
				«ENDIF»
			}
			
			@Override
			public String getAppID() {
				return APP_ID;
			}
			
		}
	'''
	
	def generateBehaviorCode(DeploymentBehavior behavior)'''
		«val app = behavior.eContainer as DeploymentApplication»
		«val behaviorClassName = "Behavior"+app.id.purifyAndToUpperCamel»
		package «PROJECT_NAME».hosts.statemachines;
			
		import java.util.List;
		
		import org.apache.log4j.Logger;
		import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.applications.Application;
		import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.applications.statemachines.State;
		
		import com.google.common.collect.Lists;
		
		public enum «behaviorClassName» implements State<«behaviorClassName»> {
			 ///////////
			// States
			«Joiner.on(',').join(behavior.calculateStateCodeListFor(behaviorClassName))»;
			
		    private static Logger logger = Logger.getLogger("cps.proto.distributed.state");
		    
			 /////////////////
			// General part
			@Override
			abstract public List<State<«behaviorClassName»>> possibleNextStates(Application app);
			
			@Override
			public «behaviorClassName» stepTo(«behaviorClassName» nextState, Application app){
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
	'''
	
	def calculateStateCodeListFor(DeploymentBehavior behavior, String behaviorClassName){
		val list = Lists.<CharSequence>newArrayList
		for(state : behavior.states){
			list.add(generateState(state, behaviorClassName))
		}
		list
	}
	
	def generateState(BehaviorState state, String behaviorClassName) '''
		«state.description.purifyAndToUpperCamel» {
		    @Override
		    public List<State<«behaviorClassName»>> possibleNextStates(Application app) {
		    	List<State<«behaviorClassName»>> possibleStates = Lists.newArrayList();
		    	
		    	// Add Neutral Transitions
		    	«FOR trgState : state.calculateNeutralStateTransition»
		    	possibleStates.add(«trgState.description.purifyAndToUpperCamel»);
		    	«ENDFOR»
		    	
		    	// Add Send Transitions
		    	«FOR transition : state.calculateSendStateTransition»
		    	possibleStates.add(«transition.to.description.purifyAndToUpperCamel»);
		    	«ENDFOR»
		    	
		    	// Add Wait Transitions
		    	«val map = state.calculateWaitStateTransition»
		    	«FOR trgTransition : map.keySet»
		    	if(app.hasMessageFor("«trgTransition.description.purifyAndToUpperCamel»")){
		    		possibleStates.add(«map.get(trgTransition).description.purifyAndToUpperCamel»);
		    	}
				«ENDFOR»
		    	
		    	return possibleStates;
		    }
		    
		    «IF state.hasSendTrigger»
		    @Override
		    public «behaviorClassName» stepTo(«behaviorClassName» nextState, Application app) {
		    	// Send triggers
		    	«FOR transition : state.calculateSendStateTransition»
		    	if(nextState == «transition.to.description.purifyAndToUpperCamel»){
		    		app.sendTrigger(«state.calculateSendTriggerParameters(transition)»);
		    		return super.stepTo(nextState, app);
		    	}
		    	«ENDFOR»
		    	// Other cases (wait, neutral)
		    	return super.stepTo(nextState, app);
		    }
		    «ENDIF»
		}
	'''
	
	def String calculateSendTriggerParameters(BehaviorState srcState, BehaviorTransition transition){
		//"152.66.102.5", "IBM System Storage", "ISSReceiving"
		if(transition != null){
			'''"«transition.trigger.head.host.ip»", "«transition.trigger.head.app.id»", "«transition.trigger.head.name»"'''
		}else{
			throw new CPSGeneratorException("#Error: Cannot find transition from " + srcState.name + " to " + transition.to.name)
		}
	}
	
	def DeploymentApplication app(BehaviorTransition transition){
		val app = transition?.eContainer?.eContainer
		if(app != null && app instanceof DeploymentApplication){
			return app as DeploymentApplication
		}
		throw new CPSGeneratorException("#Error: Cannot find Application of the Transition (" + transition.name + ")")
	}
	
	def DeploymentHost host(BehaviorTransition transition){
		val app = transition?.eContainer?.eContainer?.eContainer
		if(app != null && app instanceof DeploymentHost){
			return app as DeploymentHost
		}
		throw new CPSGeneratorException("#Error: Cannot find Host of the Transition (" + transition.name + ")")
	}
	
	def DeploymentApplication app(BehaviorState state){
		val app = state?.eContainer?.eContainer
		if(app != null && app instanceof DeploymentApplication){
			return app as DeploymentApplication
		}
		throw new CPSGeneratorException("#Error: Cannot find Application of the State (" + state.name + ")")
	}
	
	def DeploymentHost host(BehaviorState state){
		val host = state?.eContainer?.eContainer?.eContainer
		if(host != null && host instanceof DeploymentHost){
			return host as DeploymentHost
		}
		throw new CPSGeneratorException("#Error: Cannot find Host of the State (" + state.name + ")")
	}
	
	def String name(BehaviorState state){
		state.description.purifyAndToUpperCamel
	}
	
	def String name(BehaviorTransition transition){
		transition.description.purifyAndToUpperCamel
	}
	
	def boolean hasSendTrigger(BehaviorState srcState){
		return srcState.outgoing.exists[ transition | !transition.trigger.empty]
	}
	
	def Iterable<BehaviorTransition> calculateSendStateTransition(BehaviorState srcState){
		srcState.outgoing.filter[transition | 
	        		return !transition.trigger.empty
	    ]
	}
	
	def calculateWaitStateTransition(BehaviorState srcState){
		val waitTransitions = srcState.outgoing.filter[transition | 
	        		return transition.trigger.empty && transition.hasIncomingTrigger
	    ]
	    val map = new HashMap<BehaviorTransition, BehaviorState>
	    
	    waitTransitions.forEach[waitTrans | 
	    	map.put(waitTrans, waitTrans.to)
	    ]
	    
	    return map
	}
	
	def Iterable<BehaviorState> calculateNeutralStateTransition(BehaviorState srcState){
		// TODO optimize
//		val incomingTrigger = IncQueryBaseFactory.getInstance.createNavigationHelper(srcState.eResource.resourceSet, true, Logger.getLogger("cps.codegenerator"))
		srcState.outgoing.filter[transition | 
//	        		val reverse = incomingTrigger.getInverseReferences(transition, ImmutableList.of(DeploymentPackage.Literals.BEHAVIOR_TRANSITION__TRIGGER))
	        		return transition.trigger.empty && !transition.hasIncomingTrigger
	    ].map[transition | transition.to]
	}
	
	def boolean hasIncomingTrigger(BehaviorTransition transition){
		WaitTransitionMatcher.on(engine).hasMatch(transition, null);
	}
	
	def CharSequence generateDeploymentCode(Deployment deployment) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	
	
}