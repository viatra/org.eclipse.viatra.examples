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

import org.eclipse.viatra.emf.mwe2integration.providers.IConditionProvider
import org.eclipse.viatra.emf.mwe2integration.providers.impl.BaseProvider

/**
 * This IConditionProvider provides a basic example dynamically computed condition for IF Statements.
 * 
 * Note that this provider is used with the examples only, and it implements no logical function.
 */
public class ExampleIfCondition extends BaseProvider implements IConditionProvider{
	private Boolean ret = true;

	/**
	 * Once the condition of the conditional step is evaluated, this method is called
	 * In this case, it will return true and false in an alternating fashion.
	 */
	override apply() {
		var toReturn = ret;
		ret = !ret;
		return toReturn
	}
}