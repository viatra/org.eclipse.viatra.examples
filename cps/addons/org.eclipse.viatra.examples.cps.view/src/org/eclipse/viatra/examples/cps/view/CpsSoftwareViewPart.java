/*******************************************************************************
 * Copyright (c) 2014-2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Zoltan Ujhelyi - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.view;

import java.util.Collection;

import org.eclipse.viatra.examples.cps.model.viewer.AppInstancesNoAllocation;
import org.eclipse.viatra.examples.cps.model.viewer.AppInstancesWithAllocation;
import org.eclipse.viatra.examples.cps.model.viewer.ApplicationTypes;
import org.eclipse.viatra.examples.cps.model.viewer.ConnectTypesAndInstancesApp;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;

import com.google.common.collect.ImmutableSet;

public class CpsSoftwareViewPart extends AbstractCpsViewPart {

	@Override
	protected Collection<IQuerySpecification<?>> getSpecifications() {
		return ImmutableSet.<IQuerySpecification<?>>of(
				AppInstancesNoAllocation.instance(),
				AppInstancesWithAllocation.instance(),
				ApplicationTypes.instance(),
				ConnectTypesAndInstancesApp.instance()
				//DependenciesQuerySpecification.instance()
				);
	}
}
