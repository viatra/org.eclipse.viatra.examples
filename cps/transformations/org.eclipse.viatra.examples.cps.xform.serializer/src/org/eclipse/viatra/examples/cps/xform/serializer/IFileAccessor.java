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
package org.eclipse.viatra.examples.cps.xform.serializer;

public interface IFileAccessor {
    /**
     * Create the specified file and fill it with the provided content
     * 
     * @param fileName File path using / to separate
     * @param contents Contents of the file
     */
    public void createFile(String folderPath, String fileName, CharSequence contents);
    
    
    /**
     * Delete the specified file
     * 
     * @param fileName File path using / to separate
     */
    public void deleteFile(String folderPath, String fileName);
    
    /**
     * Created folder
     * 
     * @param folderPath
     * @param folderName
     * @param isProject
     */
    public void createFolder(String folderPath, String folderName);
    
    /**
     * Create project folder with metadata
     * 
     * @param projectPath
     * @param projectName
     */
    public void createProject(String projectPath, String projectName);
    

}
