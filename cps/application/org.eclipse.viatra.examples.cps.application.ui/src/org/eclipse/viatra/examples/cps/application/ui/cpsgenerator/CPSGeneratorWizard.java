/*******************************************************************************
 * Copyright (c) 2010-2017, Marton Elekes, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.application.ui.cpsgenerator;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;
import org.eclipse.viatra.examples.cps.application.ui.CPSApplicationUIPlugin;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystem;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage;
import org.eclipse.viatra.examples.cps.generator.CPSPlanBuilder;
import org.eclipse.viatra.examples.cps.generator.dtos.CPSFragment;
import org.eclipse.viatra.examples.cps.generator.dtos.CPSGeneratorInput;
import org.eclipse.viatra.examples.cps.generator.dtos.constraints.ICPSConstraints;
import org.eclipse.viatra.examples.cps.planexecutor.PlanExecutor;

/**
 * A wizard to generate CPS models according to selected {@linkplain ICPSConstraints constraints} on host and
 * application types
 * 
 * @author Marton Elekes
 */
public class CPSGeneratorWizard extends Wizard implements INewWizard {

    private static final String TITLE = "Generate CPS Model";
    private static final String DEFAULT_FILENAME = "My";
    private static final String EXTENSION = "cyberphysicalsystem";

    private NewFileCreationPage newFileCreationPage;
    private ConstraintTypePage constraintPage;
    private ConstraintDetailsPage detailsPage;

    private IStructuredSelection selection;
    private IWorkbench workbench;

    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.workbench = workbench;
        this.selection = selection;
        setWindowTitle(TITLE);
        setDefaultPageImageDescriptor(
                CPSApplicationUIPlugin.getDefault().getImageRegistry().getDescriptor(CPSApplicationUIPlugin.CPS_NEW));
    }

    @Override
    public void addPages() {
        newFileCreationPage = new NewFileCreationPage("CPSWizardNewFileCreationPage", selection, EXTENSION);
        newFileCreationPage.setTitle(TITLE);
        newFileCreationPage.setDescription("Create a new CyberPhysicalSystem model file");
        newFileCreationPage.setFileName(DEFAULT_FILENAME + "." + EXTENSION);
        addPage(newFileCreationPage);

        // Try and get the resource selection to determine a current directory for the file dialog.
        if (selection != null && !selection.isEmpty()) {

            // Based on the generated EMF new model wizard. Picks one resource from the selection.
            Object selectedElement = selection.iterator().next();
            if (selectedElement instanceof IResource) {
                // Get the resource parent, if its a file.
                IResource selectedResource = (IResource) selectedElement;
                if (selectedResource.getType() == IResource.FILE) {
                    selectedResource = selectedResource.getParent();
                }

                if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
                    newFileCreationPage.setContainerFullPath(selectedResource.getFullPath());

                    // Make up a unique new name here.
                    String modelFilename = DEFAULT_FILENAME + "." + EXTENSION;
                    for (int i = 1; ((IContainer) selectedResource).findMember(modelFilename) != null; ++i) {
                        modelFilename = DEFAULT_FILENAME + i + "." + EXTENSION;
                    }
                    newFileCreationPage.setFileName(modelFilename);
                }
            }
        }

        constraintPage = new ConstraintTypePage();
        constraintPage.setTitle(TITLE);
        addPage(constraintPage);

        detailsPage = new ConstraintDetailsPage();
        detailsPage.setTitle(TITLE);
        addPage(detailsPage);
    }

    @Override
    public boolean performFinish() {
        try {
            final IFile modelFile = ResourcesPlugin.getWorkspace().getRoot().getFile(newFileCreationPage.getModelRelativePath());

            WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
                @Override
                protected void execute(IProgressMonitor progressMonitor) throws CoreException {
                    try {
                        ResourceSet resourceSet = new ResourceSetImpl();
                        URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);
                        Resource resource = resourceSet.createResource(fileURI);

                        CyberPhysicalSystem rootObject = createModel();
                        resource.getContents().add(rootObject);

                        Map<Object, Object> options = new HashMap<Object, Object>();
                        options.put(XMLResource.OPTION_ENCODING, "UTF-8");
                        resource.save(options);
                    } catch (IOException e) {
                        throw new CoreException(new Status(IStatus.ERROR, CPSApplicationUIPlugin.PLUGIN_ID,
                                "Error creating file " + modelFile.getName(), e));
                    } finally {
                        progressMonitor.done();
                    }
                }
            };

            getContainer().run(false, false, operation);

            BasicNewResourceWizard.selectAndReveal(modelFile, workbench.getActiveWorkbenchWindow());

            if (constraintPage.shouldOpenModel())
                IDE.openEditor(workbench.getActiveWorkbenchWindow().getActivePage(), modelFile, true);

            return true;
        } catch (InvocationTargetException e) {
            log(e);
            MessageDialog.openError(getShell(), "Error creating file", e.getTargetException().getMessage());
            return false;
        } catch (Exception e) {
            log(e);
            MessageDialog.openError(getShell(), "Error creating file", e.getMessage());
            return false;
        }
    }

    private CyberPhysicalSystem createModel() {
        CyberPhysicalSystem cps = CyberPhysicalSystemPackage.eINSTANCE.getCyberPhysicalSystemFactory()
                .createCyberPhysicalSystem();

        ICPSConstraints plainConstaints = constraintPage.getConstraints();
        ICPSConstraints constraints = plainConstaints != null ? plainConstaints : detailsPage.getConstraints();

        CPSGeneratorInput input = new CPSGeneratorInput(constraintPage.getSeed(), constraints, cps);
        PlanExecutor<CPSFragment, CPSGeneratorInput> generator = new PlanExecutor<>();
        CPSFragment fragment = generator.process(CPSPlanBuilder.buildDefaultPlan(), input);

        fragment.getEngine().dispose();

        return cps;
    }

    private void log(Exception exception) {
        CPSApplicationUIPlugin.getDefault().logException("An error happened: " + exception.getMessage(), exception);
    }
}
