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

import java.security.InvalidParameterException
import org.eclipse.viatra.examples.cps.integration.M2TDistributedTransformationStep
import org.eclipse.viatra.examples.cps.xform.m2t.monitor.DeploymentChangeDelta
import org.eclipse.viatra.integration.mwe2.IMessage
import org.eclipse.viatra.integration.mwe2.IMessageProcessor
import org.eclipse.viatra.integration.mwe2.ITransformationStep

class ChangeDeltaMessageProcessor implements IMessageProcessor<DeploymentChangeDelta, ChangeDeltaMessage> {
	protected ITransformationStep parent

	override ITransformationStep getParent() {
		return parent
	}

	override void setParent(ITransformationStep parent) {
		this.parent = parent
	}

	override void processMessage(IMessage<? extends Object> message) throws InvalidParameterException {
		if (message instanceof ChangeDeltaMessage) {
			var ChangeDeltaMessage event = (message as ChangeDeltaMessage)
			if (parent instanceof M2TDistributedTransformationStep) {
				var M2TDistributedTransformationStep m2tparent = (parent as M2TDistributedTransformationStep)
				m2tparent.delta = event.getParameter()
			}
		}
	}
}
