/*******************************************************************************
 * Copyright (c) 2004-2015, Peter Lunk, Zoltan Ujhelyi and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Peter Lunk - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.emf.mwe2integration.examples.resources

import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext
import org.eclipse.viatra.emf.mwe2integration.mwe2impl.TransformationStep

/** 
 * An example transformation step. User defined transformation steps should extend the abstract class 
 * TransformationStep. It already implements the core features of transformation steps, namely the management of 
 * publishings, subscriptions, as well as message processing and -creation.
 * 
 * This class is the same as the A variant, it is needed as most of the examples call for two different 
 * transformation steps
 * 
 * For a more complex implementation check out the CPS MWE Orchestrator example in the
 * following repository: https://github.com/IncQueryLabs/incquery-examples-cps
 * @author Peter Lunk
 */
class ExampleBTransformationStep extends TransformationStep {
	override doInitialize(IWorkflowContext ctx) {
		//this method is called after the workflow context is assigned to the step
		//The transformation should be  initialized here
		System.out.println("Init B transformation")
		//The context can be used to access global variables
		//via ctx.get("String")
	}
	
	override void doExecute() {
		//This method is executed during the execute method of a given transformation step,
		//after the received messages are processed and before outgoing messages are sent-
		//Run the transformation (or any other user defined function) here 
		System.out.println("B transformation executed")
	}
	
	override void dispose() {
		// Dispose functions
		System.out.println("Dispose B transformation")
	}

	//In this method the sending of messages can be defined
	//Typically the following implementation, which send a given message type to all publishing topics, 
	//is sufficient
	override void publishMessages() {
		publishings.forEach[
			publishMessage("MESSAGE B")
		]
	}
}
