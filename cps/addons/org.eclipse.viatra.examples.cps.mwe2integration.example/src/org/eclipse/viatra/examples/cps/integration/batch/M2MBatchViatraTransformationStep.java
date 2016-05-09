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
package org.eclipse.viatra.examples.cps.integration.batch;

import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;
import org.eclipse.viatra.examples.cps.xform.m2m.batch.viatra.CPS2DeploymentBatchViatra;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment;
import org.eclipse.viatra.integration.mwe2.mwe2impl.TransformationStep;

public class M2MBatchViatraTransformationStep extends TransformationStep {
    protected AdvancedViatraQueryEngine engine;
    protected CPS2DeploymentBatchViatra transformation;

    @Override
    public void doInitialize(IWorkflowContext ctx) {
        CPSToDeployment cps2dep = (CPSToDeployment) ctx.get("model");
        
        engine = (AdvancedViatraQueryEngine) ctx.get("engine");
        transformation = new CPS2DeploymentBatchViatra();
        transformation.initialize(cps2dep, engine);

        System.out.println("Initialized model-to-model transformation");
    }   

    @Override
    public void doExecute() {
        transformation.execute();
        System.out.println("Model-to-model transformation executed");
    }

    @Override
    public void dispose() {
        transformation.dispose();
        System.out.println("Disposed model-to-model transformation");
    }
}
