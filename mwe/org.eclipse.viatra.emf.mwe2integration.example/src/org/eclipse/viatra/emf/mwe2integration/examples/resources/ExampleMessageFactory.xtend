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

import org.eclipse.viatra.integration.mwe2.IMessageFactory
import org.eclipse.viatra.integration.mwe2.mwe2impl.exceptions.InvalidParameterTypeException

/**
 * Example message factory that is responsible for the creation of ExampleMessage objects.
 */
class ExampleMessageFactory implements IMessageFactory<String,ExampleMessage>{
	
	/**
	 * 
	 * If the defined parameter matches ExampleMessage, a new instance is created.
	 */
	override createMessage(Object parameter) throws InvalidParameterTypeException{
		if(parameter.isValidParameter){
			return new ExampleMessage(parameter as String)
		}
		throw new InvalidParameterTypeException
	}
	
	/**
	 * 
	 * Checks if the defined parameter matches the parameter type of the ExampleMessage class
	 */
	override isValidParameter(Object parameter) {
		if(parameter instanceof String){
			return true
		}
		return false;
	}
	
}