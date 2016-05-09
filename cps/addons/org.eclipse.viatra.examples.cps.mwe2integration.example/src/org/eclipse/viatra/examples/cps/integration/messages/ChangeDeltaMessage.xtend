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
package org.eclipse.viatra.examples.cps.integration.messages

import org.eclipse.viatra.examples.cps.xform.m2t.monitor.DeploymentChangeDelta
import org.eclipse.viatra.integration.mwe2.IMessage

class ChangeDeltaMessage implements IMessage<DeploymentChangeDelta> {
	DeploymentChangeDelta parameter

	new(DeploymentChangeDelta parameter) {
		super()
		this.parameter = parameter
	}

	override DeploymentChangeDelta getParameter() {
		return parameter
	}

	override void setParameter(DeploymentChangeDelta parameter) {
		this.parameter = parameter
	}

}
