/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Zoltan Ujhelyi, Peter Lunk, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.serializer;

import org.eclipse.viatra.examples.cps.xform.m2t.api.IM2TOutputProvider;

public interface ISerializer {
    public void serialize(String folderPath, IM2TOutputProvider provider, IFileAccessor fileaccessor);
    
    public void createProject(String projectPath, String projectName, IFileAccessor fileaccessor);
    
    public void createFolder(String folderPath, String folderName, IFileAccessor fileaccessor);
}
