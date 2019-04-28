/*******************************************************************************
 * Copyright (c) 2010-2017, Marton Elekes, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.application.ui.transformationview

import org.eclipse.viatra.examples.cps.application.ui.transformationview.util.TransformationConnector
import org.eclipse.viatra.examples.cps.xform.m2m.launcher.TransformationType

/**
 * Interface for listening for changes in {@link TransformationRegistry}.
 * @author Marton Elekes
 */
interface ITransformationRegistryListener {
    def void transformationRemoved(TransformationConnector connector)

    def void transformationAdded(TransformationConnector connector)
    
    def void transformationTypeChanged(TransformationType newTransformationType)
}