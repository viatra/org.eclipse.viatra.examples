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

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.viatra.examples.cps.tests.CPSTestBase;
import org.eclipse.viatra.examples.cps.xform.serializer.javaio.JavaIOBasedFileAccessor;
import org.junit.Test;

public class JavaIOBasedAccessorTest extends CPSTestBase{

	private static final String TEST_FILE_NAME = "test.java";
	private static final String TEST_CONSTANT = "Test Test Test File Apple";
	private String projectLocation = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
	JavaIOBasedFileAccessor accessor = new JavaIOBasedFileAccessor();

	@Test
	public void createProject() throws CoreException, IOException {
	    
		accessor.createProject(projectLocation, "org.alma.test");
		
		File project = new File(projectLocation, "org.alma.test");
		assertTrue("Project does not exist!", project.exists());
		
	}

	@Test
	public void createFile() throws CoreException, IOException {
		File file = createTestFile();
		accessor.deleteFile(file.getParentFile().getAbsolutePath(), TEST_FILE_NAME);
	}
	
	@Test
	public void writeFile() throws CoreException, IOException {

		// Create test file
		File file = createTestFile();
		
		long localTimeStamp = file.lastModified();
		
		// Try to create existing file with same content
		File folder = file.getParentFile();
		accessor.createFile(folder.getAbsolutePath(), TEST_FILE_NAME, TEST_CONSTANT);
		File createdFile = new File(folder.getAbsolutePath(),TEST_FILE_NAME );
		// Check modification stamp
		long newTimeStamp = file.lastModified();
		
		assertEquals(file, createdFile);
		assertEquals(newTimeStamp, localTimeStamp);

		
		// Modify
		accessor.createFile(folder.getAbsolutePath(), TEST_FILE_NAME, "NEW CONTENT");
		File modifiedFile = new File(folder.getAbsolutePath(),TEST_FILE_NAME );

		assertTrue(localTimeStamp != file.lastModified());
		assertEquals(file, modifiedFile);	
		accessor.deleteFile(file.getParentFile().getAbsolutePath(), TEST_FILE_NAME);
	}
	

	private File createTestFile() throws CoreException, IOException {

	    accessor.createProject(projectLocation, "org.alma.test");
        File project = new File(projectLocation, "org.alma.test");
		assertTrue("Project does not exist!", project.exists());
		
		accessor.createFolder(project.getAbsolutePath(), "src");
		File srcFolder = new File(project.getAbsolutePath(), "src");
		
		assertTrue("Folder does not exist!", srcFolder.exists());
		
		accessor.createFile(srcFolder.getAbsolutePath(), TEST_FILE_NAME, TEST_CONSTANT);

		File createdFile = new File(srcFolder.getAbsolutePath(),TEST_FILE_NAME);
		assertTrue("File does not exist!", createdFile.exists());
		
		return createdFile;
	}
	
	
}