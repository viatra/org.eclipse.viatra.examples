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

import org.eclipse.jface.viewers.ArrayContentProvider
import org.eclipse.jface.viewers.ComboViewer
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.jface.viewers.LabelProvider
import org.eclipse.jface.viewers.StructuredSelection
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Composite
import org.eclipse.ui.menus.WorkbenchWindowControlContribution
import org.eclipse.viatra.examples.cps.xform.m2m.launcher.TransformationType
import org.eclipse.viatra.examples.cps.application.ui.transformationview.util.TransformationTypeNames

/**
 * A control to select a transformation from {@link TransformationType}.
 * @author Marton Elekes
 */
class TransformationSelectionControl extends WorkbenchWindowControlContribution {

    new() {
    }

    new(String id) {
        super(id)
    }

    override protected createControl(Composite parent) {
        val viewer = new ComboViewer(parent, (SWT.BORDER.bitwiseOr(SWT.READ_ONLY))) => [
            contentProvider = ArrayContentProvider.instance
            labelProvider = new LabelProvider() {
                override getText(Object element) {
                    TransformationTypeNames.getFriendlyName(element as TransformationType)
                }
            }
            input = TransformationType.values.filter[TransformationTypeNames.shouldShowOnUi(it)].toList

            addSelectionChangedListener([
                val selection = getSelection()
                if (selection instanceof IStructuredSelection) {
                    val transformationType = selection.firstElement
                    if (transformationType instanceof TransformationType) {
                        TransformationRegistry.instance.newTransformationType = transformationType
                    }
                }
            ])
            selection = new StructuredSelection(TransformationType.BATCH_VIATRA_TRANSFORMATION)
        ]

        return viewer.control
    }
}
