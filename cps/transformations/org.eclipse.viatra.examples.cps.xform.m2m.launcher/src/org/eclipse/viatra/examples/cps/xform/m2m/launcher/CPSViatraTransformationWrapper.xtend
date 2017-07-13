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
package org.eclipse.viatra.examples.cps.xform.m2m.launcher

import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment

abstract class CPSViatraTransformationWrapper extends CPSTransformationWrapper {

    override initializeTransformation(CPSToDeployment cps2dep) {
        initializeDebuggableTransformation(cps2dep, false, null)
    }

    def initializeDebuggableTransformation(CPSToDeployment cps2dep) {
        initializeDebuggableTransformation(cps2dep, true, null)
    }

    def initializeDebuggableTransformation(CPSToDeployment cps2dep, String transformationName) {
        initializeDebuggableTransformation(cps2dep, true, transformationName)
    }

    def void initializeDebuggableTransformation(CPSToDeployment cps2dep, boolean isDebuggable, String debugName)
}
