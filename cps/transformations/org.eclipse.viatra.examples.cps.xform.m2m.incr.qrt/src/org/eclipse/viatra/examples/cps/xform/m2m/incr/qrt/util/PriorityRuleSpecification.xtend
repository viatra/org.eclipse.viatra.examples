/*******************************************************************************
 * Copyright (c) 2014, 2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Marton Bur, Zoltan Ujhelyi - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2m.incr.qrt.util

import org.eclipse.viatra.query.runtime.api.IPatternMatch
import org.eclipse.viatra.transformation.evm.api.RuleSpecification

class PriorityRuleSpecification<Match extends IPatternMatch> {	
	@Property RuleSpecification<Match> ruleSpecification	
	@Property int priority	
}
