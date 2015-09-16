/*******************************************************************************
 * Copyright (c) 2010-2015, Andras Szabolcs Nagy and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Andras Szabolcs Nagy - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.dse.examples.cps.problems;

import org.eclipse.viatra.dse.util.EMFHelper;
import org.junit.Test;

public class CpsModelsToFile {

    @Test
    public void saveModels() {
        CpsProblemFactory cpsProblemFactory = new CpsProblemFactory();
        EMFHelper.serializeModel(cpsProblemFactory.basicAndSecurePackage(), "tiny", "cps");
        EMFHelper.serializeModel(cpsProblemFactory.allXTimes(1), "small", "cps");
        EMFHelper.serializeModel(cpsProblemFactory.allAndMore(), "medium", "cps");
        EMFHelper.serializeModel(cpsProblemFactory.allXTimes(2), "large", "cps");
        EMFHelper.serializeModel(cpsProblemFactory.allXTimes(3), "huge", "cps");
    }
}