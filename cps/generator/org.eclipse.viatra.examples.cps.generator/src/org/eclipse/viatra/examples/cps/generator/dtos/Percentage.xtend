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
package org.eclipse.viatra.examples.cps.generator.dtos

import org.eclipse.viatra.examples.cps.generator.exceptions.ModelGeneratorException

class Percentage {
	
	private double fraction = 0.0;
	
	new(double percentage) throws ModelGeneratorException {
		// XXX percentage <= 100 ? 
		if(percentage >= 0){
			this.fraction = percentage / 100;
		}else{
			throw new ModelGeneratorException("Percentage must be greater than or equal to zero");
		}
	}
	
	new(double total, double piece) throws ModelGeneratorException {
		if(total < 0 || piece < 0){
			throw new ModelGeneratorException("Total and piece must be greater than or equal to zero");
		}
		
		fraction = piece / total;
	}
	
	def getFraction(){
		return fraction;
	}
	
	def getPercentage(){
		return fraction * 100;
	}
	
	def static value(int total, Percentage percentage){
		if(total < 0){
			throw new ModelGeneratorException("Total must be greater than or equal to zero");
		}
		
		if(percentage === null){
			throw new ModelGeneratorException("Total must be valid");
		}
		
		return total * percentage.fraction;	
	}
}