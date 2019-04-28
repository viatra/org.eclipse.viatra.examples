/*******************************************************************************
 * Copyright (c) 2010-2017, Marton Elekes, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.application.ui.transformationview

import org.eclipse.core.runtime.Adapters
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.ISelectionProvider
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.ui.IEditorPart
import org.eclipse.ui.INullSelectionListener
import org.eclipse.ui.IPartListener
import org.eclipse.ui.IWorkbenchPart
import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment
import org.eclipse.viatra.query.runtime.ui.modelconnector.IModelConnector

/**
 * @author Marton Elekes
 * 
 */
class EditorSelectionListener implements INullSelectionListener, IPartListener {

    ISelection lastSelection
    IEditorPart lastEditor

    val TransformationManagerView transformationsView

    new(TransformationManagerView transformationsView) {
        this.transformationsView = transformationsView
    }

    /*
     * Call it to initialize the enabled property based on current selection
     * @param editorPart the currently active editor
     */
    def void init(IEditorPart editorPart) {
        if (editorPart instanceof ISelectionProvider) {
            selectionChanged(editorPart, editorPart?.selection)
        } else
            updateTransformationViewEnablement(false)
    }

    override selectionChanged(IWorkbenchPart part, ISelection selection) {
        if (part instanceof IEditorPart) {
            lastEditor = part
            lastSelection = selection

            refreshState
        }
    }

    override partActivated(IWorkbenchPart part) {
        if (part instanceof IEditorPart) {
            // Invalidate last editor and selection
            updateTransformationViewEnablement(false)
        }
    }

    override partBroughtToTop(IWorkbenchPart part) {
        // Empty method
    }

    override partClosed(IWorkbenchPart part) {
        if (part === lastEditor) {
            // Invalidate last editor
            updateTransformationViewEnablement(false)
        }
    }

    override partDeactivated(IWorkbenchPart part) {
        // Empty method
    }

    override partOpened(IWorkbenchPart part) {
        // Empty method
    }

    /**
     * Refresh state based on requirements to the editor and the selected item
     */
    def refreshState() {

        if (lastEditor === null)
            updateTransformationViewEnablement(false)
        else if (lastSelection instanceof IStructuredSelection) {
            // Check selected element, whether we can connect to the model or not
            var newEnabledState = lastSelection.size == 1 && lastSelection.firstElement instanceof CPSToDeployment &&
                Adapters.adapt(lastEditor, IModelConnector) !== null

            // Check for loaded transformation, then disable without cache invalidation
            if (newEnabledState && TransformationRegistry.instance.containsKey(lastEditor))
                updateTransformationViewEnablement(false, false)
            else
                updateTransformationViewEnablement(newEnabledState)
        } else
            updateTransformationViewEnablement(false)
    }

    private def void updateTransformationViewEnablement(boolean viewEnablement) {
        updateTransformationViewEnablement(viewEnablement, true)
    }

    private def void updateTransformationViewEnablement(boolean viewEnablement, boolean unsetLastValues) {
        transformationsView.transformationEnabled = viewEnablement

        if (!viewEnablement && unsetLastValues) {
            lastSelection = null
            lastEditor = null
        }
    }
}
