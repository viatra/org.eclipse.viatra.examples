/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Akos Menyhert, Zoltan Ujhelyi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.generator.phases

import com.google.common.collect.ImmutableList
import org.eclipse.viatra.examples.cps.generator.dtos.CPSFragment
import org.eclipse.viatra.examples.cps.generator.queries.Queries
import org.eclipse.viatra.examples.cps.planexecutor.api.IOperation
import org.eclipse.viatra.examples.cps.planexecutor.api.IPhase

class CPSPhasePrepare implements IPhase<CPSFragment> {
	
	override getOperations(CPSFragment fragment) {
		return ImmutableList.of(new IOperation<CPSFragment>{
			override execute(CPSFragment fr) {
				Queries.instance.prepare(fr.engine);
				true;
			}
		});
	}
	
}