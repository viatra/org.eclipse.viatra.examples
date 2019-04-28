/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Akos Menyhert, Zoltan Ujhelyi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.generator.dtos

import org.eclipse.viatra.examples.cps.generator.exceptions.ModelGeneratorException

class Percentage {
	
	double fraction = 0.0;
	
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