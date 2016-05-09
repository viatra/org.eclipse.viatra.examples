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

import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.examples.cps.deployment.Deployment;
import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment;
import org.eclipse.viatra.examples.cps.xform.m2t.monitor.DeploymentChangeDelta;
import org.eclipse.viatra.examples.cps.xform.m2t.monitor.DeploymentChangeMonitor;
import org.eclipse.viatra.integration.mwe2.IPublishTo;
import org.eclipse.viatra.integration.mwe2.mwe2impl.TransformationStep;

public class ChangeMonitorTransformationStep extends TransformationStep {
    protected AdvancedViatraQueryEngine engine;
    protected DeploymentChangeMonitor monitor;
    protected DeploymentChangeDelta delta;
    
    @Override
    public void doInitialize(IWorkflowContext ctx) {
        // create transformation
        System.out.println("Initialized change monitor");
        engine = (AdvancedViatraQueryEngine) ctx.get("engine");
        Deployment deployment = ((CPSToDeployment) ctx.get("model")).getDeployment();
        monitor = new DeploymentChangeMonitor(deployment, engine);
        try {
            monitor.startMonitoring();
        } catch (ViatraQueryException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doExecute() {
        delta = monitor.createCheckpoint();
        System.out.println("Checkpoint created");
    }
    
    @Override
    public void publishMessages() {
        for (IPublishTo iPublishTo : publishTo) {
            iPublishTo.publishMessage(delta);
        }
    }
    
    @Override
    public void dispose() {
        System.out.println("Disposed change monitor");
    }
}
