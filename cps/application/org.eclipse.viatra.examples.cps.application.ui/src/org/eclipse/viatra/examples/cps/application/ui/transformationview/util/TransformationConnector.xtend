/*******************************************************************************
 * Copyright (c) 2010-2017, Marton Elekes, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.application.ui.transformationview.util

import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment
import org.eclipse.viatra.examples.cps.xform.m2m.launcher.CPSTransformationWrapper
import org.eclipse.viatra.examples.cps.xform.m2m.launcher.TransformationType
import org.eclipse.viatra.query.runtime.ui.modelconnector.EMFModelConnector
import org.eclipse.xtend.lib.annotations.Data

/**
 * Stores data for an active transformation on a {@link CPSToDeployment} model from an opened editor.
 * @author Marton Elekes
 */
@Data
class TransformationConnector {
    TransformationType transformationType
    CPSTransformationWrapper wrapper
    EMFModelConnector modelConnector
    CPSToDeployment tracemodel

    override toString() {
        modelConnector.owner.title + ": " + TransformationTypeNames.getFriendlyName(transformationType) + " transformation"
    }

}
