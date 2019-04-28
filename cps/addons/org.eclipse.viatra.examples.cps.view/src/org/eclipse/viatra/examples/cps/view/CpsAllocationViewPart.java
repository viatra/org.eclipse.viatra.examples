/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Zoltan Ujhelyi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.view;

import java.util.Collection;

import org.eclipse.viatra.examples.cps.model.viewer.AllHostInstances;
import org.eclipse.viatra.examples.cps.model.viewer.AppInstancesNoAllocation;
import org.eclipse.viatra.examples.cps.model.viewer.AppInstancesWithAllocation;
import org.eclipse.viatra.examples.cps.model.viewer.ConnectAppAndHost;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;

import com.google.common.collect.ImmutableSet;

public class CpsAllocationViewPart extends AbstractCpsViewPart {

	@Override
	protected Collection<IQuerySpecification<?>> getSpecifications() {
		return ImmutableSet.<IQuerySpecification<?>>of(
				AppInstancesNoAllocation.instance(),
				AppInstancesWithAllocation.instance(),
				ConnectAppAndHost.instance(),
				AllHostInstances.instance());
	}	
}
