/*******************************************************************************
 * Copyright (c) 2010-2017, Marton Elekes, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.application.ui.transformationview

import org.eclipse.jface.action.Action
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.jface.viewers.ListViewer
import org.eclipse.swt.widgets.Composite
import org.eclipse.ui.part.ViewPart
import org.eclipse.viatra.examples.cps.application.ui.CPSApplicationUIPlugin
import static org.eclipse.viatra.examples.cps.application.ui.CPSApplicationUIPlugin.ICON_LOAD_QUERY
import static org.eclipse.viatra.examples.cps.application.ui.CPSApplicationUIPlugin.ICON_STOP
import static org.eclipse.viatra.examples.cps.application.ui.CPSApplicationUIPlugin.LOAD_XFORM_W_DEBUGGER
import org.eclipse.viatra.query.runtime.ui.modelconnector.AdapterUtil
import org.eclipse.viatra.query.runtime.ui.modelconnector.EMFModelConnector
import org.eclipse.viatra.query.runtime.api.IModelConnectorTypeEnum
import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment

import static extension com.google.common.collect.Iterables.getOnlyElement
import org.eclipse.viatra.query.runtime.ui.modelconnector.IModelConnectorListener
import org.eclipse.viatra.query.runtime.ui.modelconnector.IModelConnector
import org.eclipse.ui.IEditorPart
import org.eclipse.emf.edit.domain.IEditingDomainProvider
import org.eclipse.emf.common.command.IdentityCommand
import org.eclipse.viatra.examples.cps.application.ui.transformationview.util.TransformationConnector
import org.eclipse.viatra.examples.cps.xform.m2m.launcher.CPSTransformationWrapper
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.core.runtime.Status
import org.eclipse.swt.widgets.Display
import org.eclipse.viatra.examples.cps.xform.m2m.launcher.TransformationType
import org.eclipse.viatra.examples.cps.xform.m2m.launcher.CPSViatraTransformationWrapper

/** 
 * A view to load, start and remove VIATRA transformations on a selected CPS To Deployment model.
 * @author Marton Elekes
 */
class TransformationManagerView extends ViewPart {
    public static final String ID = "org.eclipse.viatra.examples.cps.xform.m2m.ui.ManageTransformationsView"

    ListViewer listViewer

    val transformationSelectionControl = new TransformationSelectionControl()
    Action runTransformAction
    Action runTransformWDebuggerAction
    Action stopTransformationAction

    EditorSelectionListener selectionHandler
    val transformationsToListViewerListener = new ITransformationRegistryListener() {
        override void transformationRemoved(TransformationConnector connector) {
            listViewer.remove(connector)
        }

        override void transformationAdded(TransformationConnector connector) {
            listViewer.add(connector)
        }
        
        override transformationTypeChanged(TransformationType newTransformationType) {
            isDebuggable = newTransformationType.isDebuggable
            refreshTransformationEnabled
        }        
    }

    override void createPartControl(Composite parent) {
        listViewer = new ListViewer(parent) => [
            addSelectionChangedListener([
                val selection = getSelection
                if (selection instanceof IStructuredSelection) {

                    val Iterable iterable = [selection.iterator]

                    val enabled = selection.size >= 1 && iterable.forall[it instanceof TransformationConnector]
                    stopTransformationAction.enabled = enabled
                }
            ])
            addDoubleClickListener([
                val selection = getSelection
                if (selection instanceof IStructuredSelection) {
                    if (selection.size !== 1)
                        return;

                    val firstElement = selection.firstElement
                    if (firstElement instanceof TransformationConnector) {
                        firstElement.modelConnector.showLocation(#[firstElement.tracemodel])
                    }
                }
            ])
        ]
        TransformationRegistry.instance.addListener(transformationsToListViewerListener, true)

        createActions()
        initializeToolBar()

        if (site !== null) {
            site.selectionProvider = listViewer

            selectionHandler = new EditorSelectionListener(this)
            selectionHandler.init(site.workbenchWindow?.activePage?.activeEditor)

            site.workbenchWindow => [
                partService.addPartListener(selectionHandler)
                selectionService.addSelectionListener(selectionHandler)
            ]
        }
    }

    def private void createActions() {
        val imageRegistry = CPSApplicationUIPlugin.^default.imageRegistry

        runTransformAction = new Action("Run Transformation on CPS To Deployment") {
            override void run() {
                runTransformation(false)
            }
        }
        runTransformAction => [
            imageDescriptor = imageRegistry.getDescriptor(ICON_LOAD_QUERY)
            enabled = false
        ]

        runTransformWDebuggerAction = new Action("Run Transformation on CPS To Deployment and Wait for Debugger") {
            override void run() {
                runTransformation(true)
            }
        }
        runTransformWDebuggerAction => [
            imageDescriptor = imageRegistry.getDescriptor(LOAD_XFORM_W_DEBUGGER)
            enabled = false
        ]

        stopTransformationAction = new Action("Stop and Remove Transformation") {
            override void run() {
                super.run()

                val Iterable iterable = [listViewer.structuredSelection.iterator];

                for (Object connector : iterable) {
                    if (connector instanceof TransformationConnector) {
                        connector.getModelConnector().unloadModel();
                    }
                }

                selectionHandler.refreshState()
            }
        }
        stopTransformationAction => [
            imageDescriptor = imageRegistry.getDescriptor(ICON_STOP)
            enabled = false
        ]
    }

    def private void initializeToolBar() {
        viewSite?.actionBars.toolBarManager => [
            add(transformationSelectionControl)
            add(runTransformAction)
            add(runTransformWDebuggerAction)
            add(stopTransformationAction)
        ]
    }

    var transformationEnabled = false
    var isDebuggable = false
    def setTransformationEnabled(boolean enabled) {
        transformationEnabled = enabled
        
        refreshTransformationEnabled
    }
    
    private def refreshTransformationEnabled() {
        if (runTransformAction === null)
            return;

        runTransformAction.enabled = transformationEnabled
        runTransformWDebuggerAction.enabled = transformationEnabled && isDebuggable
    }

    override void setFocus() {
        listViewer.control.setFocus()
    }

    override void dispose() {
        TransformationRegistry.instance.removeListener(transformationsToListViewerListener)
        site?.workbenchWindow => [
            partService.removePartListener(selectionHandler)
            selectionService.removeSelectionListener(selectionHandler)
        ]

        super.dispose()
    }

    def void runTransformation(boolean isDebugPressed) {
        var CPSTransformationWrapper wrapper
        try {
            val editorPart = site?.page?.activeEditor

            if (editorPart === null)
                return;

            if (!TransformationRegistry.instance.containsKey(editorPart)) {

                val transformationType = TransformationRegistry.instance.newTransformationType
                wrapper = transformationType.wrapper

                val modelConnector = AdapterUtil.getModelConnectorFromIEditorPart(editorPart) as EMFModelConnector
                modelConnector.loadModel(IModelConnectorTypeEnum.RESOURCESET)
                val tracemodel = modelConnector.selectedEObjects.onlyElement as CPSToDeployment

                val transformationConnector = new TransformationConnector(transformationType, wrapper,
                    modelConnector, tracemodel)

                modelConnector.addListener(new IModelConnectorListener() {
                    override modelUnloaded(IModelConnector it) {
                        val modelConnector = transformationConnector.modelConnector
                        modelConnector.removeListener(this)
                        val editorPart = modelConnector.owner as IEditorPart

                        transformationConnector.wrapper.cleanupTransformation

                        TransformationRegistry.instance.remove(editorPart)
                    }
                })

                TransformationRegistry.instance.put(editorPart, transformationConnector)

                // touch the file to make dirty after transformation
                switch editorPart {
                    IEditingDomainProvider:
                        editorPart.editingDomain.commandStack.execute(IdentityCommand.INSTANCE)
                }

                val jobName = if (isDebugPressed)
                        "Running CPS Transformation. Connect Debugger!"
                    else
                        "Running CPS Transformation"
                val wrapperVal = wrapper
                Job.create(jobName, [
                    try {
                        if (isDebugPressed)
                            (wrapperVal as CPSViatraTransformationWrapper).initializeDebuggableTransformation(tracemodel)
                        else
                            wrapperVal.initializeTransformation(tracemodel)
                        wrapperVal.executeTransformation

                        if (!transformationType.wrapper.incremental)
                            Display.^default.syncExec([
                                modelConnector.unloadModel
                            ])

                        return Status.OK_STATUS
                    } catch (Exception e) {
                        wrapperVal.cleanupTransformation
                        Display.^default.syncExec([
                            modelConnector.unloadModel
                        ])
                        return new Status(Status.ERROR, CPSApplicationUIPlugin.PLUGIN_ID,
                            "Error running transformation", e)
                    }
                ]).schedule()
            }

            selectionHandler.refreshState()
        } catch (Exception e) {
            wrapper?.cleanupTransformation
            MessageDialog.openError(site?.shell, "Error running transformation", e.message)
        }
    }
}
