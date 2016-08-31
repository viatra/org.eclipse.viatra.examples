package org.eclipse.viatra.examples.cps.tests

import org.eclipse.viatra.examples.cps.tests.queries.util.HostInstanceWithMinCPU1QuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.HostInstanceWithMinCPU2QuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.MinCPUQuerySpecification
import org.eclipse.viatra.query.testing.core.api.ViatraQueryTest
import org.junit.Test
import org.eclipse.viatra.examples.cps.tests.queries.util.SumCPUQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.AvgCPUQuerySpecification
import org.junit.Ignore

class AggregatorTest {
        
    extension AllBackendTypes = new AllBackendTypes
    
    @Test
    def void testMinCPU1() {
        ViatraQueryTest.test(MinCPUQuerySpecification::instance)
                        .withAll
                        .assertEquals 
    }
    
    @Test
    def void testMinCPU2() {
        ViatraQueryTest.test(HostInstanceWithMinCPU1QuerySpecification::instance)
                        .withAll
                        .assertEquals 
    }
    
    @Test
    def void testMinCPU3() {
        ViatraQueryTest.test(HostInstanceWithMinCPU2QuerySpecification::instance)
                        .withAll
                        .assertEquals 
    }
    
    @Test
    def void testSumCPU() {
        ViatraQueryTest.test(SumCPUQuerySpecification::instance)
                        .withAll
                        .assertEquals 
    }
    
    @Ignore("Local search engine needs to be updated")
    @Test
    def void testAvgCPU() {
        ViatraQueryTest.test(AvgCPUQuerySpecification::instance)
                        .withAll
                        .assertEquals 
    }

}