 /*******************************************************************************
 * Copyright (c) 2014-2016 Marton Elekes, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
