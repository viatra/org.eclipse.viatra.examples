/*******************************************************************************
 * Copyright (c) 2014, 2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Zoltan Ujhelyi - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2t.serializer.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.viatra.examples.cps.tests.CPSTestBase;
import org.eclipse.viatra.examples.cps.xform.serializer.eclipse.EclipseBasedFileAccessor;
import org.junit.Test;

public class EclipseBasedAccessorTestTest extends CPSTestBase{

	private static final String TEST_FILE_NAME = "test.java";
	private static final String TEST_CONSTANT = "Test Test Test File Apple";

	@Test
	public void createProject() throws CoreException, IOException {
	    EclipseBasedFileAccessor accessor = new EclipseBasedFileAccessor();
		accessor.createProject("", "org.alma.test");
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("org.alma.test");
		assertTrue("Project does not exist!", project.exists());
		
	}

	@Test
	public void createFile() throws CoreException, IOException {
		createTestFile();
	}
	
	@Test
	public void writeFile() throws CoreException, IOException {
	    EclipseBasedFileAccessor accessor = new EclipseBasedFileAccessor();
		// Create test file
		IFile file = createTestFile();
		
		long localTimeStamp = file.getModificationStamp();
		
		// Try to create existing file with same content
		IFolder folder = ((IFolder)file.getParent());
		accessor.createFile(folder.getLocation().toOSString(), TEST_FILE_NAME, TEST_CONSTANT);
		IFile createdFile = folder.getFile(TEST_FILE_NAME);
		// Check modification stamp
		long newTimeStamp = file.getModificationStamp();
		
		assertEquals(file, createdFile);
		assertEquals(newTimeStamp, localTimeStamp);

		
		// Modify
		accessor.createFile(folder.getLocation().toOSString(), TEST_FILE_NAME, "NEW CONTENT");
		IFile modifiedFile = folder.getFile(TEST_FILE_NAME);

		assertTrue(localTimeStamp != file.getModificationStamp());
		assertEquals(file, modifiedFile);		
	}
	

	private IFile createTestFile() throws CoreException, IOException {
	    EclipseBasedFileAccessor accessor = new EclipseBasedFileAccessor();
	    accessor.createProject("", "org.alma.test");
        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("org.alma.test");
		assertTrue("Project does not exist!", project.exists());
		

		IFolder srcFolder = project.getFolder("src");
		NullProgressMonitor monitor = new NullProgressMonitor();
		if(!srcFolder.exists()){
			srcFolder.create(true, true, monitor);
		}
		
		assertTrue("Folder does not exist!", srcFolder.exists());
		accessor.createFile(srcFolder.getLocation().toOSString(), TEST_FILE_NAME, TEST_CONSTANT);
		IContainer container = ResourcesPlugin.getWorkspace().getRoot().getContainerForLocation(new Path(srcFolder.getLocation().toOSString()));
		IFile createdFile = null;
		if (container instanceof IFolder) {
                createdFile = ((IFolder)container).getFile(TEST_FILE_NAME);
        }
		assertTrue("File does not exist!", createdFile.exists());
		
		return createdFile;
	}
	
	
}