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
package org.eclipse.viatra.examples.cps.generator.dtos.scenario

import org.eclipse.viatra.examples.cps.generator.dtos.constraints.ICPSConstraints

/**
 * &sum; <sub>Element count of CPS model</sub> &#8776; |HC| * F<sub>H</sub> + |AC| * F<sub>A</sub> * 
 * (2 + F<sub>AI</sub> + F<sub>HI</sub> + F<sub>S</sub> + F<sub>T</sub>)
 * 
 * <ul>
 * 	 <li>HC: HostClass</li>
 * 	 <li>AC: ApplicationClass</li>
 * 	 <li>F<sub>H</sub>: HostType factor</li>
 * 	 <li>F<sub>A</sub>: ApplicationType factor</li>
 * 	 <li>F<sub>AI</sub>: ApplicationInstance factor</li>
 * 	 <li>F<sub>HI</sub>: HostInstance factor</li>
 * 	 <li>F<sub>S</sub>: State factor</li>
 * 	 <li>F<sub>T</sub>: Transition factor</li>
 * </ul>
 * 
 */
interface IScenario {
	def ICPSConstraints getConstraintsFor(int countOfElements);
}