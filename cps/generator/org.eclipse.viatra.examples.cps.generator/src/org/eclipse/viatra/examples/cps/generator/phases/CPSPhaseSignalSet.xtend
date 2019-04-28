/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Akos Menyhert, Zoltan Ujhelyi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.generator.phases

import com.google.common.collect.Lists
import org.eclipse.viatra.examples.cps.generator.dtos.CPSFragment
import org.eclipse.viatra.examples.cps.generator.operations.SignalCalculationOperation
import org.eclipse.viatra.examples.cps.planexecutor.api.IPhase

class CPSPhaseSignalSet implements IPhase<CPSFragment>{
	
	override getOperations(CPSFragment fragment) {
		Lists.newArrayList(new SignalCalculationOperation());
	}
	
}