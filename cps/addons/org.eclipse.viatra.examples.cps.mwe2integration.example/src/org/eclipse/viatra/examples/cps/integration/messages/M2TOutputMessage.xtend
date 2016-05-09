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

import java.util.List
import org.eclipse.viatra.examples.cps.xform.m2t.api.M2TOutputRecord
import org.eclipse.viatra.integration.mwe2.IMessage

class M2TOutputMessage implements IMessage<List<M2TOutputRecord>> {
	List<M2TOutputRecord> parameter

	new(List<M2TOutputRecord> parameter) {
		super()
		this.parameter = parameter
	}

	override List<M2TOutputRecord> getParameter() {
		return parameter
	}

	override void setParameter(List<M2TOutputRecord> parameter) {
		this.parameter = parameter
	}

}
