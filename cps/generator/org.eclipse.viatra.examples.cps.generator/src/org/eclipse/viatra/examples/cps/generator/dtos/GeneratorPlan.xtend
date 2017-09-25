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
package org.eclipse.viatra.examples.cps.generator.dtos

import com.google.common.collect.Lists
import java.util.List
import org.eclipse.viatra.examples.cps.planexecutor.api.IPhase
import org.eclipse.viatra.examples.cps.planexecutor.api.IPlan

class GeneratorPlan implements IPlan<CPSFragment> {
	
	List<IPhase<CPSFragment>> phases = Lists.newArrayList;
	
	override addPhase(IPhase<CPSFragment> phase) {
		phases.add(phase);
	}
	
	override getPhases() {
		return phases;
	}
	
}