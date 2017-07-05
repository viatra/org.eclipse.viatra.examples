/*******************************************************************************
 * Copyright (c) 2010-2017, Marton Elekes, IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Marton Elekes - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.application.ui.cpsgenerator

import java.util.Random
import org.eclipse.viatra.examples.cps.generator.dtos.constraints.ICPSConstraints
import org.eclipse.xtend.lib.annotations.Data

/**
 * Stores a named constraint type and produces an instance based on a scaling factor and a random generator
 * @author Marton Elekes
 */
@Data
class ScalableConstraints {
    String name
    (int, Random)=>ICPSConstraints constraints

    def getConstraints(int scale, Random rand) {
        constraints.apply(scale, rand)
    }

    override toString() {
        name
    }
}
