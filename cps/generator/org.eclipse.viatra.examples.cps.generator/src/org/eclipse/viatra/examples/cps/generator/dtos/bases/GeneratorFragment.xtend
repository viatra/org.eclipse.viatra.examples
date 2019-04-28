/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Akos Menyhert, Zoltan Ujhelyi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.generator.dtos.bases

import java.util.Random
import org.eclipse.emf.ecore.EObject

class GeneratorFragment<ModelType extends EObject> extends GeneratorConfiguration<ModelType> {
	
	val GeneratorInput<ModelType> input;
	val Random rand;
	
	new(GeneratorInput<ModelType> input) {
		this.input = input;
		this.modelRoot = input.modelRoot;
		if(input !== null){
			this.rand = new Random(input.seed);
		}else{
			this.rand = new Random(0);
		}
		
	}
	
	def getInput(){
		return input;
	}
	
	def getSeed(){
		if(input !== null){
			return input.seed;
		}
		return 0;
	}
	
	def getRandom(){
		return rand;
	}
	
}