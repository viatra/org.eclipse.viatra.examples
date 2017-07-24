/*******************************************************************************
 * Copyright (c) 2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Balazs Grill, Tamas Szabo, Gabor Bergmann - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.tests

import org.eclipse.viatra.examples.cps.tests.queries.util.HostInstanceWithMinCPU1QuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.HostInstanceWithMinCPU2QuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.MinCPUQuerySpecification
import org.eclipse.viatra.query.testing.core.api.ViatraQueryTest
import org.junit.Test
import org.eclipse.viatra.examples.cps.tests.queries.util.SumCPUQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.AvgCPUQuerySpecification
import org.junit.Ignore
import org.eclipse.viatra.examples.cps.tests.queries.util.HasOddApplicationsQuerySpecification
import org.junit.runners.Parameterized.Parameters
import java.util.Collection
import org.junit.runners.Parameterized.Parameter
import org.eclipse.viatra.query.testing.core.XmiModelUtil
import org.eclipse.viatra.query.testing.core.XmiModelUtil.XmiModelUtilRunningOptionEnum
import org.junit.runners.Parameterized
import org.junit.runner.RunWith

@RunWith(Parameterized)
class AggregatorTest {
        
    extension AllBackendTypes = new AllBackendTypes
    
    
    @Parameters(name = "Model: {0}")
    def static Collection<Object[]> testData() {
        newArrayList(
            #[ 
                "org.eclipse.viatra.examples.cps.tests/models/instances/aggregators.cyberphysicalsystem"
            ]
        )
    }
    
    @Parameter(0)
    public String modelPath
    
    
    @Test
    def void testMinCPU1() {
        ViatraQueryTest.test(MinCPUQuerySpecification::instance)
                        .on(XmiModelUtil::resolvePlatformURI(XmiModelUtilRunningOptionEnum.BOTH, modelPath))
                        .withAll
                        .assertEquals 
    }
    
    @Test
    def void testMinCPU2() {
        ViatraQueryTest.test(HostInstanceWithMinCPU1QuerySpecification::instance)
                        .on(XmiModelUtil::resolvePlatformURI(XmiModelUtilRunningOptionEnum.BOTH, modelPath))
                        .withAll
                        .assertEquals 
    }
    
    @Test
    def void testMinCPU3() {
        ViatraQueryTest.test(HostInstanceWithMinCPU2QuerySpecification::instance)
                        .on(XmiModelUtil::resolvePlatformURI(XmiModelUtilRunningOptionEnum.BOTH, modelPath))
                        .withAll
                        .assertEquals 
    }
    
    @Test
    def void testSumCPU() {
        ViatraQueryTest.test(SumCPUQuerySpecification::instance)
                        .on(XmiModelUtil::resolvePlatformURI(XmiModelUtilRunningOptionEnum.BOTH, modelPath))
                        .withAll
                        .assertEquals 
    }
    
    @Test
    def void testHasOddApplications() {
        ViatraQueryTest.test(HasOddApplicationsQuerySpecification::instance)
                        .on(XmiModelUtil::resolvePlatformURI(XmiModelUtilRunningOptionEnum.BOTH, modelPath))
                        .withAll
                        .assertEquals 
    }
    
    @Test
    def void testAvgCPU() {
        ViatraQueryTest.test(AvgCPUQuerySpecification::instance)
                        .on(XmiModelUtil::resolvePlatformURI(XmiModelUtilRunningOptionEnum.BOTH, modelPath))
                        .withAll
                        .assertEquals 
    }

}