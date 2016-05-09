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

import org.eclipse.viatra.examples.cps.xform.m2t.api.IM2TOutputProvider;
import org.eclipse.viatra.examples.cps.xform.m2t.api.M2TOutputRecord;

public class DefaultSerializer implements ISerializer {

    @Override
    public void serialize(String folderPath, IM2TOutputProvider provider, IFileAccessor fileaccessor) {
        for (M2TOutputRecord record : provider.getOutput()) {
            if(record.isDeleted()){
                fileaccessor.deleteFile(folderPath, record.getFileName());
            }else{
                fileaccessor.createFile(folderPath, record.getFileName(), record.getContent());
            }
        }
    }

    @Override
    public void createProject(String projectPath, String projectName, IFileAccessor fileaccessor) {
        fileaccessor.createProject(projectPath, projectName);
    }

    @Override
    public void createFolder(String folderPath, String folderName, IFileAccessor fileaccessor) {
        fileaccessor.createFolder(folderPath, folderName);        
    }
    
    

}
