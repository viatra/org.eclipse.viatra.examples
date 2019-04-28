/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Marton Bur, Zoltan Ujhelyi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2m.incr.qrt.util

import org.eclipse.viatra.query.runtime.api.IPatternMatch
import org.eclipse.viatra.transformation.evm.api.RuleSpecification

class PriorityRuleSpecification<Match extends IPatternMatch> {	
	@Property RuleSpecification<Match> ruleSpecification	
	@Property int priority	
}
