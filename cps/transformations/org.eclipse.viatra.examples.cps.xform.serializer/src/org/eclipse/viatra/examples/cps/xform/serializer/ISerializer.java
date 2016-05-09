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

public interface ISerializer {
    public void serialize(String folderPath, IM2TOutputProvider provider, IFileAccessor fileaccessor);
    
    public void createProject(String projectPath, String projectName, IFileAccessor fileaccessor);
    
    public void createFolder(String folderPath, String folderName, IFileAccessor fileaccessor);
}
