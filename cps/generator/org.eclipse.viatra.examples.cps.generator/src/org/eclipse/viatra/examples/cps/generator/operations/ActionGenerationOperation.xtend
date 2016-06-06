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
 package org.eclipse.viatra.examples.cps.generator.operations

import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition
import org.eclipse.viatra.examples.cps.generator.dtos.CPSFragment
import org.eclipse.viatra.examples.cps.generator.utils.CPSModelBuilderUtil
import org.eclipse.viatra.examples.cps.generator.utils.RandomUtils
import org.eclipse.viatra.examples.cps.planexecutor.api.IOperation

class ActionGenerationOperation implements IOperation<CPSFragment> {
	
	private extension CPSModelBuilderUtil modelBuilder;
	private extension RandomUtils randUtil
	
	private String action;
	private Transition transition;
	
	new(String action, Transition transition){
		modelBuilder = new CPSModelBuilderUtil;
		randUtil = new RandomUtils;
		this.action = action;
		this.transition = transition;
	}
	
	override execute(CPSFragment fragment) {
		transition.setAction(action);
		
		true;
	}
	
}