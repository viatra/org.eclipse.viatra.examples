/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Marton Bur, Zoltan Ujhelyi, Robert Doczi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2t.monitor;

import org.eclipse.viatra.examples.cps.deployment.Deployment;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.matchers.ViatraQueryRuntimeException;

public abstract class AbstractDeploymentChangeMonitor {

    protected Deployment deployment;
    protected ViatraQueryEngine engine;

    public AbstractDeploymentChangeMonitor(Deployment deployment, ViatraQueryEngine engine){
        this.deployment = deployment;
        this.engine = engine;
		
	}
	
	/**
	 * Sets the model whose changes are observed. Also creates an initial checkpoint with no changes registered.
	 * @param deployment the deployment model
	 * @param engine engine associated with the 
	 * @throws ViatraQueryRuntimeException 
	 */
	public abstract void startMonitoring();
	
	/**
	 * Creates a checkpoint which means:
	 * <li>Model changes since the last checkpont are saved</li>
	 * <li>The model changes in the future are tracked separately from the changes before the checkpoint</li>
	 * @return the DTO containing the changed elements since the last checkpoint
	 */
	public abstract DeploymentChangeDelta createCheckpoint();
	
	/**
	 * Returns all changed elements since the last call to {@link #createCheckpoint()}
	 * 
	 * @return the DTO containing the changed elements
	 */
	public abstract DeploymentChangeDelta getDeltaSinceLastCheckpoint();
	
}
