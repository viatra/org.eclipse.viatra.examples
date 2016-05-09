/*******************************************************************************
 * Copyright (c) 2014, 2016 IncQuery Labs Ltd.
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

import org.eclipse.gef4.layout.LayoutAlgorithm;
import org.eclipse.gef4.layout.algorithms.SpaceTreeLayoutAlgorithm;
import org.eclipse.viatra.examples.cps.model.viewer.util.AppInstancesNoAllocationQuerySpecification;
import org.eclipse.viatra.examples.cps.model.viewer.util.AppInstancesWithAllocationQuerySpecification;
import org.eclipse.viatra.examples.cps.model.viewer.util.ConnectAppQuerySpecification;
import org.eclipse.viatra.examples.cps.model.viewer.util.RequestsQuerySpecification;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import com.google.common.collect.ImmutableSet;

public class CpsRequirementViewPart extends AbstractCpsViewPart {

	protected LayoutAlgorithm getLayout() {
		return new SpaceTreeLayoutAlgorithm();
	}
	
	@Override
	protected Collection<IQuerySpecification<?>> getSpecifications()
			throws ViatraQueryException {
		return ImmutableSet.<IQuerySpecification<?>>of(
				AppInstancesNoAllocationQuerySpecification.instance(),
				AppInstancesWithAllocationQuerySpecification.instance(),
				ConnectAppQuerySpecification.instance(),
				RequestsQuerySpecification.instance());
	}

}
