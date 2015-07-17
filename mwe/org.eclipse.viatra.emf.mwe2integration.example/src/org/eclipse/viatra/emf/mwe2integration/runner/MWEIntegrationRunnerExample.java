/*******************************************************************************
 * Copyright (c) 2004-2015, Peter Lunk, Zoltan Ujhelyi and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Peter Lunk - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.emf.mwe2integration.runner;

import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.mwe2.launch.runtime.Mwe2Runner;
import org.eclipse.emf.mwe2.runtime.workflow.WorkflowContextImpl;
import org.eclipse.viatra.emf.mwe2integration.initializer.MWE2IntegrationInitializer;
import org.junit.Test;

/**
 * Test case that demonstrates how an MWE framework should be called programmatically. 
 * 
 * Note: Always run as a plain JUnit test.
 * 
 * @author Peter Lunk
 *
 */
public class MWEIntegrationRunnerExample {
    String location;
    
    @Test
    public void runSimple() {
        location = "src/org/eclipse/viatra/emf/mwe2integration/examples/simple/SimpleChainExample.mwe2";
        
        MWE2IntegrationInitializer initializer = new MWE2IntegrationInitializer();
        Mwe2Runner  mweRunner = initializer.initializePlainJava();
        mweRunner.run(URI.createURI(location), new HashMap<String,String>(), new WorkflowContextImpl());
    }
}
