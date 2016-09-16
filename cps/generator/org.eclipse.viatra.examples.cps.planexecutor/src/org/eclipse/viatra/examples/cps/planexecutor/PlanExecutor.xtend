/*******************************************************************************
 * Copyright (c) 2014-2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Akos Menyhert, Zoltan Ujhelyi - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.planexecutor

import com.google.common.base.Stopwatch
import java.util.concurrent.TimeUnit
import org.apache.log4j.Logger
import org.eclipse.viatra.examples.cps.planexecutor.api.IPlan
import org.eclipse.viatra.examples.cps.planexecutor.api.Initializer

class PlanExecutor<FragmentType, InputType extends Initializer<FragmentType>> {
	
	protected extension Logger logger = Logger.getLogger("cps.generator.Generator")
	
	def process(IPlan<FragmentType> plan, InputType input){
		val FragmentType fragment = input.getInitialFragment;
		
		continueProcessing(plan, fragment)
		
		return fragment;
	}
	
	def continueProcessing(IPlan<FragmentType> plan, FragmentType fragment) {
		plan.phases.forEach[phase | 
		    if(isDebugEnabled){
    			debug("<< Begin Phase: " + phase.class.simpleName + " >>");
		    }
			val phaseSw = Stopwatch.createStarted;
			phase.getOperations(fragment).forEach[operation |
				try{
					if(isDebugEnabled){
					    debug("< OPERATION " + operation.class.simpleName + " >");
				    }
					operation.execute(fragment);
					if(isDebugEnabled){
					   debug("<-------------------- END OPERATION ----------------------->");
				   }
				}catch(Exception e){
					info(e.message);
				}
			]
			phaseSw.stop;
			info("<< Done "+ phase.class.simpleName + " phase in "+ phaseSw.elapsed(TimeUnit.MILLISECONDS) +" ms >>");
		]
	}
	
}