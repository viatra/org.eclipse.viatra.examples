/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Akos Menyhert, Zoltan Ujhelyi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.generator.operations

import org.eclipse.viatra.examples.cps.generator.dtos.CPSFragment
import org.eclipse.viatra.examples.cps.planexecutor.api.IOperation
import org.eclipse.viatra.examples.cps.generator.queries.TransitionWithoutAction
import org.eclipse.emf.ecore.util.EcoreUtil

class DeleteTransitionWithoutAction implements IOperation<CPSFragment> {
	
	CPSFragment fragment
	
	new(CPSFragment fragment){
		this.fragment = fragment;
	}
	
	override execute(CPSFragment fragment) {
		
		val matcher = TransitionWithoutAction.Matcher.on(fragment.engine)
		
		matcher.allMatches.forEach[
			EcoreUtil.delete(it.t)
		]
		
		true;
	}
	
}