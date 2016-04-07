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

import com.google.common.collect.Lists
import org.eclipse.viatra.integration.mwe2.providers.IIterableProvider
import org.eclipse.viatra.integration.mwe2.providers.impl.BaseProvider

/**
 * This IIterableProvider creates a list on which a FOREACH loop can iterate through.
 * 
 * Note that this provider is used with the examples only, and it implements no logical function .
 */
public class ExampleLoopIterable extends BaseProvider implements IIterableProvider{
	override getIterable() {
		var list = Lists.newArrayList
		list.add("1")
		list.add("2")
		return list
	}
}