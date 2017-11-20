/*******************************************************************************
 * Copyright (c) 2014-2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Tamas Borbas, Marton Bur, Zoltan Ujhelyi - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2m.util

import java.util.regex.Pattern

class SignalUtil {
	
	static val waitPattern = Pattern.compile("^waitForSignal\\((.*)\\)$")
	static val sendPattern = Pattern.compile("^sendSignal\\((.*),(.*)\\)$")
	
	@Pure
	static def isSend(String action) {
		sendPattern.matcher(action).matches
	}
	
	@Pure
	static def isWait(String action) {
		waitPattern.matcher(action).matches
	}
	
	@Pure
	static def getAppId(String action){
		sendPattern.getGroupOfMatch(action, 1)
	}
	
	@Pure
	static def getSignalId(String action) {
		val sendId = sendPattern.getGroupOfMatch(action, 2)
		if(sendId === null) {
			waitPattern.getGroupOfMatch(action, 1)
		} else {
			sendId
		}
	}
	
	private static def getGroupOfMatch(Pattern pattern, String action, int group){
		val matcher = pattern.matcher(action)
		if(matcher.matches) {
			matcher.group(group).trim
		}
	}
}