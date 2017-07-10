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

import org.eclipse.jface.action.Action
import org.eclipse.jface.action.Separator
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.jface.viewers.ListViewer
import org.eclipse.swt.widgets.Composite
import org.eclipse.ui.part.ViewPart
import org.eclipse.viatra.examples.cps.application.ui.CPSApplicationUIPlugin
import static org.eclipse.viatra.examples.cps.application.ui.CPSApplicationUIPlugin.ICON_LOAD_QUERY
import static org.eclipse.viatra.examples.cps.application.ui.CPSApplicationUIPlugin.ICON_RUN
import static org.eclipse.viatra.examples.cps.application.ui.CPSApplicationUIPlugin.ICON_STOP
import org.eclipse.viatra.query.tooling.ui.queryexplorer.adapters.AdapterUtil
import org.eclipse.viatra.query.tooling.ui.queryexplorer.adapters.EMFModelConnector
import org.eclipse.viatra.query.runtime.api.IModelConnectorTypeEnum
import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment

import static extension com.google.common.collect.Iterables.getOnlyElement
import org.eclipse.viatra.query.tooling.ui.util.IModelConnectorListener
import org.eclipse.viatra.query.tooling.ui.queryexplorer.IModelConnector
import org.eclipse.ui.IEditorPart
import org.eclipse.emf.edit.domain.IEditingDomainProvider
import org.eclipse.emf.common.command.IdentityCommand
import org.eclipse.viatra.examples.cps.application.ui.transformationview.util.TransformationConnector
import org.eclipse.viatra.examples.cps.xform.m2m.launcher.CPSTransformationWrapper
import org.eclipse.jface.dialogs.MessageDialog

/** 
 * A view to load, start and remove VIATRA transformations on a selected CPS To Deployment model.
 * @author Marton Elekes
 */
class TransformationManagerView extends ViewPart {
    public static final String ID = "org.eclipse.viatra.examples.cps.xform.m2m.ui.ManageTransformationsView"

    ListViewer listViewer

    val transformationSelectionControl = new TransformationSelectionControl()
    Action loadTransformAction
    Action runTransformationAction
    Action stopTransformationAction

    EditorSelectionListener selectionHandler
    val transformationsToListViewerListener = new ITransformationRegistryListener() {
        override void transformationRemoved(TransformationConnector connector) {
            listViewer.remove(connector)
        }

        override void transformationAdded(TransformationConnector connector) {
            listViewer.add(connector)
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
                    runTransformationAction.enabled = enabled
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

        loadTransformAction = new Action("Load New Transformation on CPS To Deployment") {
            override void run() {
                var CPSTransformationWrapper wrapper
                try {
                    super.run()
                    val editorPart = site?.page?.activeEditor

                    if (editorPart === null)
                        return;

                    if (!TransformationRegistry.instance.containsKey(editorPart)) {

                        val transformationType = TransformationRegistry.instance.newTransformationType
                        wrapper = transformationType.wrapper

                        val modelConnector = AdapterUtil.
                            getModelConnectorFromIEditorPart(editorPart) as EMFModelConnector
                        modelConnector.loadModel(IModelConnectorTypeEnum.RESOURCESET)
                        val tracemodel = modelConnector.selectedEObjects.onlyElement as CPSToDeployment

                        val transformationConnector = new TransformationConnector(transformationType, wrapper,
                            modelConnector, tracemodel)

                        wrapper.initializeTransformation(tracemodel)

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
                    }

                    selectionHandler.refreshState()
                } catch (Exception e) {
                    wrapper?.cleanupTransformation
                    MessageDialog.openError(site?.shell, "Error loading transformation", e.message)
                }
            }
        }
        loadTransformAction => [
            imageDescriptor = imageRegistry.getDescriptor(ICON_LOAD_QUERY)
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

        runTransformationAction = new Action("Run Transformation") {
            override void run() {
                super.run()

                val Iterable iterable = [listViewer.structuredSelection.iterator];

                for (Object connector : iterable) {
                    if (connector instanceof TransformationConnector) {
                        val editorPart = connector.modelConnector.owner as IEditorPart
                        TransformationRegistry.instance.get(editorPart)?.wrapper.executeTransformation()

                        // touch the file to make dirty after transformation
                        switch editorPart {
                            IEditingDomainProvider:
                                editorPart.editingDomain.commandStack.execute(IdentityCommand.INSTANCE)
                        }
                    }
                }
            }
        }
        runTransformationAction => [
            imageDescriptor = imageRegistry.getDescriptor(ICON_RUN)
            enabled = false
        ]
    }

    def private void initializeToolBar() {
        viewSite?.actionBars.toolBarManager => [
            add(transformationSelectionControl)
            add(loadTransformAction)
            add(new Separator())
            add(runTransformationAction)
            add(stopTransformationAction)
        ]
    }

    def setTransformationEnabled(boolean enabled) {
        loadTransformAction.enabled = enabled
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

}
