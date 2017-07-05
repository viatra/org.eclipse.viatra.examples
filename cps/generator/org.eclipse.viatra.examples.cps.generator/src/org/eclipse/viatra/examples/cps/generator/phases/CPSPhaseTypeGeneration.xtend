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
package org.eclipse.viatra.examples.cps.generator.phases

import com.google.common.collect.Lists
import org.eclipse.viatra.examples.cps.generator.dtos.CPSFragment
import org.eclipse.viatra.examples.cps.generator.dtos.constraints.ICPSConstraints
import org.eclipse.viatra.examples.cps.generator.operations.ApplicationTypeGenerationOperation
import org.eclipse.viatra.examples.cps.generator.operations.HostTypeGenerationOperation
import org.eclipse.viatra.examples.cps.planexecutor.api.IPhase

class CPSPhaseTypeGeneration implements IPhase<CPSFragment>{
	
	override getOperations(CPSFragment fragment) {
		val operations = Lists.newArrayList();
		
		val constraints = fragment.input.constraints as ICPSConstraints;
		
		// ApplicationTypes
		constraints.applicationClasses.forEach[appClass, i | 
			operations.add(new ApplicationTypeGenerationOperation(appClass));
		]
		
		// HostTypes
		constraints.hostClasses.forEach[hostClass, i | 
			operations.add(new HostTypeGenerationOperation(hostClass));
		]
		
		return operations;
	}
	
}