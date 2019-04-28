/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Akos Menyhert, Zoltan Ujhelyi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.generator.dtos

import com.google.common.collect.HashMultimap
import com.google.common.collect.Multimap
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystem
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostType
import org.eclipse.viatra.examples.cps.generator.dtos.bases.GeneratorFragment
import org.eclipse.viatra.examples.cps.generator.dtos.bases.GeneratorInput
import org.eclipse.viatra.examples.cps.generator.exceptions.ModelGeneratorException
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine
import org.eclipse.viatra.query.runtime.emf.EMFScope

class CPSFragment extends GeneratorFragment<CyberPhysicalSystem>{
	int numberOfSignals;
	Multimap<HostClass, HostType> hostTypes = HashMultimap.create;
	Multimap<AppClass, ApplicationType> applicationTypes = HashMultimap.create;
	AdvancedViatraQueryEngine engine;
	
	new(GeneratorInput<CyberPhysicalSystem> input) throws ModelGeneratorException {
		super(input)
		if(modelRoot !== null){
			engine = AdvancedViatraQueryEngine.createUnmanagedEngine(new EMFScope(modelRoot));
		}else{
			throw new ModelGeneratorException("Cannot initialize IncQueryEngine on a null model.");
		}
	}
	
	def getNumberOfSignals(){
		return numberOfSignals;
	}
	
	def setNumberOfSignals(int numberOfSignals){
		this.numberOfSignals = numberOfSignals;
	}
	
	def addHostType(HostClass hostClass, HostType hostType){
		hostTypes.put(hostClass, hostType);
	}
	
	def getHostTypes(){
		return hostTypes;
	}
	
	def getApplicationTypes(){
		return applicationTypes;
	}
	
	def addApplicationType(AppClass appClass, ApplicationType appType){
		applicationTypes.put(appClass, appType);
	}
	
	def getEngine(){
		return engine;
	}
	
}