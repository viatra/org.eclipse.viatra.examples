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

import org.eclipse.viatra.integration.mwe2.providers.IConditionProvider
import org.eclipse.viatra.integration.mwe2.providers.impl.BaseProvider

/**
 * This IConditionProvider provides a basic example dynamically computed condition for WHILE Loops.
 * 
 * Note that this provider is used with the examples only, and it implements no logical function.
 */
public class ExampleWhileCondition extends BaseProvider implements IConditionProvider{
	private int reference = 3;
	private int actual = 0;
	
	//This condition provider will return true on the first three calls, and false on the fourth
	//Resulting in a 3 length loop
	override apply() {
		if(reference > actual){
			actual++
			return true
		}
		false
	}

}