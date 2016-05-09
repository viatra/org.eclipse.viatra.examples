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
package org.eclipse.viatra.examples.cps.integration;

import java.util.List;

import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.examples.cps.xform.m2t.api.ChangeM2TOutputProvider;
import org.eclipse.viatra.examples.cps.xform.m2t.api.ICPSGenerator;
import org.eclipse.viatra.examples.cps.xform.m2t.api.M2TOutputRecord;
import org.eclipse.viatra.examples.cps.xform.m2t.distributed.CodeGenerator;
import org.eclipse.viatra.examples.cps.xform.m2t.monitor.DeploymentChangeDelta;
import org.eclipse.viatra.integration.mwe2.IPublishTo;
import org.eclipse.viatra.integration.mwe2.mwe2impl.TransformationStep;

public class M2TDistributedTransformationStep extends TransformationStep {
    protected AdvancedViatraQueryEngine engine;
    public ICPSGenerator generator;
    public String projectName;
    public String sourceFolder;
    public List<M2TOutputRecord> output;
    public DeploymentChangeDelta delta;
   
    
    @Override
    public void doInitialize(IWorkflowContext ctx) {
        System.out.println("Initialized model-to-text transformation");
        engine = (AdvancedViatraQueryEngine) ctx.get("engine");
        projectName = (String) ctx.get("projectname");
        sourceFolder = (String) ctx.get("folder");
        generator = new CodeGenerator(projectName,engine,true);
        
    }
    
    @Override
    public void doExecute() {
        ChangeM2TOutputProvider provider = new ChangeM2TOutputProvider(delta, generator, sourceFolder);
        output = provider.generateChanges();
        System.out.println("Model-to-text transformation executed");
    }
    
    @Override
    public void publishMessages() {
        for (IPublishTo iPublishTo : publishTo) {
            iPublishTo.publishMessage(output);
        }
    }
    
    @Override
    public void dispose() {
        System.out.println("Disposed model-to-text transformation");

    }
}
