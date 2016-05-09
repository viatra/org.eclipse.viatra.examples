/*******************************************************************************
 * Copyright (c) 2014, 2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Zoltan Ujhelyi, Peter Lunk, Istvan David - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2m.incr.viatra.util

import org.eclipse.viatra.transformation.evm.specific.resolver.FixedPriorityConflictResolver
import org.eclipse.viatra.transformation.evm.specific.resolver.FixedPriorityConflictSet
import java.util.Map
import org.eclipse.viatra.transformation.evm.api.RuleSpecification
import org.eclipse.viatra.transformation.evm.api.Activation
import org.eclipse.viatra.transformation.evm.specific.crud.CRUDActivationStateEnum

import static com.google.common.base.Preconditions.checkArgument;

class PerJobFixedPriorityConflictResolver extends FixedPriorityConflictResolver {

	override protected createReconfigurableConflictSet() {
		return new PerJobConflictSet(this, priorities)
	}

	static class PerJobConflictSet extends FixedPriorityConflictSet {

		new(FixedPriorityConflictResolver resolver, Map<RuleSpecification<?>, Integer> priorities) {
			super(resolver, priorities)
		}

		override protected getRulePriority(Activation<?> activation) {
			if (CRUDActivationStateEnum.DELETED.equals(activation.state))
				return (-1) * super.getRulePriority(activation)
			return super.getRulePriority(activation)
		}

		override removeActivation(Activation<?> activation) {
			checkArgument(activation != null, "Activation cannot be null!")
			val rulePriority = getRulePriority(activation)
			return priorityBuckets.remove(rulePriority, activation) ||
				priorityBuckets.remove((-1) * rulePriority, activation)
		}

	}
}
