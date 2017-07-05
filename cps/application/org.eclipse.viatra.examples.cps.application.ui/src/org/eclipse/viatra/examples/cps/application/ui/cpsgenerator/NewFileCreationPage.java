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
package org.eclipse.viatra.examples.cps.application.ui.cpsgenerator;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * A wizardpage to enter folder and filename for the new model
 * 
 * @author Marton Elekes
 */
public class NewFileCreationPage extends WizardNewFileCreationPage {
    
    public final String EXTENSION;
    
    public NewFileCreationPage(String pageId, IStructuredSelection selection, String extension) {
        super(pageId, selection);
        EXTENSION = extension;
    }

    @Override
    protected boolean validatePage() {
        if (!super.validatePage())
            return false;

        String extension = new Path(getFileName()).getFileExtension();
        if (extension == null || !EXTENSION.equals(extension)) {
            setErrorMessage("The file name must end in '." + EXTENSION + "'");
            return false;
        }
        return true;
    }

    public IPath getModelRelativePath() {
        return getContainerFullPath().append(getFileName());
    }
}
