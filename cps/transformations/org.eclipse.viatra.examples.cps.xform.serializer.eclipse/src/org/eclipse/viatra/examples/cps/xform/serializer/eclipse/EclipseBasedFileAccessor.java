/*******************************************************************************
 * Copyright (c) 2014, 2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Zoltan Ujhelyi, Peter Lunk - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.serializer.eclipse;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.zip.Adler32;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.viatra.examples.cps.xform.serializer.IFileAccessor;

import com.google.common.io.Files;

public class EclipseBasedFileAccessor implements IFileAccessor {

    @Override
    public void createFile(String folderPath, String filename, CharSequence contents) {
        IContainer container = ResourcesPlugin.getWorkspace().getRoot().getContainerForLocation(new Path(folderPath));
        if (container instanceof IFolder) {
            try {
                createFile((IFolder) container, filename, true, contents, false);
            } catch (CoreException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void deleteFile(String folderPath, String fileName) {
        IContainer container = ResourcesPlugin.getWorkspace().getRoot().getContainerForLocation(new Path(folderPath));
        if (container instanceof IFolder) {
            try {
                IFile file = ((IFolder) container).getFile(fileName);
                if (file.exists() && file.isDerived()) {
                    file.delete(true, new NullProgressMonitor());
                }
            } catch (CoreException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void createFolder(String folderPath, String folderName) {
        IContainer container = ResourcesPlugin.getWorkspace().getRoot().getContainerForLocation(new Path(folderPath));
        if (container instanceof IFolder) {
            try {
                createFolder((IFolder) container, folderName);
            } catch (CoreException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void createProject(String projectPath, String projectName) {
        try {
            createProject(projectName);
        } catch (CoreException e) {
            e.printStackTrace();
        }

    }

    private void createFile(IFolder folder, String name, boolean derived, CharSequence content, boolean forceReCreate)
            throws CoreException, IOException {
        // Referring a file by a relative name.
        IFile file = folder.getFile(name);

        // If the file existed before, and it is not editable, it should be
        // deleted
        IProgressMonitor monitor = new NullProgressMonitor();
        // If the file existed befor check the content
        if (file.exists()) {
            long fileCheckSum = calculateFileCheckSum(file);
            long contentCheckSum = calculateCharSequenceCheckSum(content);
            // Same content do not write again!
            if (fileCheckSum == contentCheckSum) {
                return;
            }
        }

        if (file.exists() && file.isDerived())
            file.delete(true, monitor);

        // Create the file if it is to exists.
        if (file.exists() && forceReCreate) {
            file.delete(true, monitor);
        }
        if (!file.exists()) {
            file.create(new ByteArrayInputStream(content.toString().getBytes()), true, monitor);

            // Setting the properties of the file.
            if (derived)
                file.setDerived(true, monitor);
        }

        // Return with the file.
        return;
    }

    private long calculateCharSequenceCheckSum(CharSequence content) {
        byte[] byteArray = new byte[content.length()];
        for (int i = 0; i < content.length(); i++) {
            byteArray[i] = (byte) content.charAt(i);
        }
        return calculateCheckSum(byteArray);
    }

    private long calculateFileCheckSum(IFile file) throws IOException {
        return calculateFileCheckSum(file.getRawLocation().makeAbsolute().toFile());
    }

    private long calculateFileCheckSum(File file) throws IOException {
        byte[] fileByteArray = Files.toByteArray(file);
        return calculateCheckSum(fileByteArray);
    }

    private long calculateCheckSum(byte[] byteArray) {
        Adler32 a32 = new Adler32();
        a32.update(byteArray);
        return a32.getValue();
    }

    private void createProject(String name) throws CoreException {
        // Referring a project in the workspace by it's name
        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(name);

        // If the project is not exist it will be created.
        IProgressMonitor monitor = new NullProgressMonitor();
        if (!project.exists()) {
            project.create(monitor);
        }

        // The project should be opened.
        project.open(IResource.BACKGROUND_REFRESH, monitor);

        // Setting natures of the project
        IProjectDescription desc = project.getDescription();
        desc.setNatureIds(new String[] { "org.eclipse.jdt.core.javanature"
        /* ,"org.eclipse.pde.PluginNature" */});
        project.setDescription(desc, monitor);
        return;
    }

    private void createFolder(IFolder container, String newFolder) throws CoreException {
        // Referring a folder by a relative name.
        IFolder folder = container.getFolder(newFolder);

        // If the folder doesn't exists create it.
        if (!folder.exists()) {
            IProgressMonitor monitor = new NullProgressMonitor();
            folder.create(true, true, monitor);
        }
        return;
    }

}
