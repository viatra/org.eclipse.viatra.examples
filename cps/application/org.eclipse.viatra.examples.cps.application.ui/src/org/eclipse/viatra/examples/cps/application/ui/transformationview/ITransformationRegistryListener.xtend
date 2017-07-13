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
package org.eclipse.viatra.examples.cps.application.ui.transformationview

import org.eclipse.viatra.examples.cps.application.ui.transformationview.util.TransformationConnector
import org.eclipse.viatra.examples.cps.xform.m2m.launcher.TransformationType

/**
 * Interface for listening for changes in {@link ManageTransformationsModel}.
 * @author Marton Elekes
 */
interface ITransformationRegistryListener {
    def void transformationRemoved(TransformationConnector connector)

    def void transformationAdded(TransformationConnector connector)
    
    def void transformationTypeChanged(TransformationType newTransformationType)
}