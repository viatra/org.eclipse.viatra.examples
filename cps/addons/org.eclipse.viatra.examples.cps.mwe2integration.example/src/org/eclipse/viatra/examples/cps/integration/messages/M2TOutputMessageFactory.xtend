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

import java.util.ArrayList
import java.util.List
import org.eclipse.viatra.examples.cps.xform.m2t.api.M2TOutputRecord
import org.eclipse.viatra.integration.mwe2.IMessageFactory
import org.eclipse.viatra.integration.mwe2.mwe2impl.exceptions.InvalidParameterTypeException

class M2TOutputMessageFactory implements IMessageFactory<List<M2TOutputRecord>, M2TOutputMessage> {
	override boolean isValidParameter(Object parameter) {
		var List<M2TOutputRecord> list = (parameter as List<M2TOutputRecord>)
		if(list != null){
			return true
		}else {
			return false
		}
	}

	override M2TOutputMessage createMessage(Object parameter) throws InvalidParameterTypeException {
		if (isValidParameter(parameter)) {
			return new M2TOutputMessage(parameter as List<M2TOutputRecord>)
		}
		return new M2TOutputMessage(new ArrayList<M2TOutputRecord>())
	}

}
