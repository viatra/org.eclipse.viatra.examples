/*******************************************************************************
 * Copyright (c) 2014-2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Akos Menyhert, Tamas Borbas, Marton Bur, Zoltan Ujhelyi, Daniel Segesdi - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.tests

import java.util.Collection
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance
import org.eclipse.viatra.examples.cps.tests.queries.util.AvgCPUQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.SumCPUQuerySpecification
import org.eclipse.viatra.query.testing.core.XmiModelUtil
import org.eclipse.viatra.query.testing.core.XmiModelUtil.XmiModelUtilRunningOptionEnum
import org.eclipse.viatra.query.testing.core.api.ViatraQueryTest
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameter
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized)
class ModelManipulationAggregatorTest {

	@Parameters(name="Model: {0}")
	def static Collection<Object[]> testData() {
		newArrayList(
			#[
				"org.eclipse.viatra.examples.cps.tests.instances/demo.cyberphysicalsystem"
			]
		)
	}

	@Parameter(0)
	public String modelPath

	@Test
	def void test_sumCPU() {
		ViatraQueryTest.test(SumCPUQuerySpecification.instance).with(BackendType.Rete.newBackendInstance).
			on(XmiModelUtil::resolvePlatformURI(XmiModelUtilRunningOptionEnum.BOTH, modelPath)).
			modify(HostInstance, [true], [host|host.availableCpu = 10]).with(
				"org.eclipse.viatra.examples.cps.tests.queries/snapshots/test_sumCPU.snapshot").assertEquals
	}
	
	@Test
	def void test_avgCPU() {
		ViatraQueryTest.test(AvgCPUQuerySpecification.instance).with(BackendType.Rete.newBackendInstance).
			on(XmiModelUtil::resolvePlatformURI(XmiModelUtilRunningOptionEnum.BOTH, modelPath)).
			modify(HostInstance, [true], [host|host.availableCpu = 10]).with(
				"org.eclipse.viatra.examples.cps.tests.queries/snapshots/test_avgCPU.snapshot").assertEquals
	}

}
