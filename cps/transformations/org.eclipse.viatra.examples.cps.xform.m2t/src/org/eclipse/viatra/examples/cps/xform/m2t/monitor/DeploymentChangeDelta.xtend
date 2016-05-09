/*******************************************************************************
 * Copyright (c) 2014, 2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Akos Horvath, Abel Hegedus, Marton Bur, Zoltan Ujhelyi, Robert Doczi - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2t.monitor

import java.util.Map
import java.util.Set
import org.eclipse.viatra.examples.cps.deployment.DeploymentElement

@Data class DeploymentChangeDelta {
	public Set<DeploymentElement> appeared
	public Set<DeploymentElement> updated
	public Set<DeploymentElement> disappeared
	public Map<DeploymentElement, String> oldNamesForDeletion
	public boolean deploymentChanged
}