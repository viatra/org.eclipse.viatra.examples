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

import java.security.InvalidParameterException
import org.eclipse.viatra.emf.mwe2integration.IMessage
import org.eclipse.viatra.emf.mwe2integration.IMessageProcessor
import org.eclipse.viatra.emf.mwe2integration.ITransformationStep
import org.eclipse.viatra.emf.mwe2integration.examples.resources.ExampleMessage
import org.eclipse.viatra.emf.mwe2integration.mwe2impl.exceptions.InvalidParameterTypeException

/**
 * 
 * Example message processor that is used for processing ExampleMessages. 
 * Other custom processors should look similar to this one.
 */
class ExampleMessageProcessor implements IMessageProcessor<String, ExampleMessage> {
	//A ITransformationStep object that contains this processor
	protected ITransformationStep parent;

	override getParent() {
		return parent
	}

	override setParent(ITransformationStep parent) {
		this.parent = parent
	}
	
	/**
	 * Processes the given message. If it contains parameter of the wrong type,  
	 * an InvalidParameterTypeException is thrown.
	 */
	override processMessage(IMessage<?> message) throws InvalidParameterTypeException{
		if(message instanceof ExampleMessage){
			System.out.println(message.parameter+" processed")
		}else{
			throw new InvalidParameterException
		}
	}

}