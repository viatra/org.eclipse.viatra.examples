package org.eclipse.viatra.examples.cps.tests

import org.eclipse.viatra.examples.cps.tests.queries.util.MinCPU1QuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.MinCPU2QuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.MinCPU3QuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.MinCPU4QuerySpecification
import org.eclipse.viatra.query.testing.core.api.ViatraQueryTest
import org.junit.Test

class AggregatorTest {
        
    extension AllBackendTypes = new AllBackendTypes
    
    @Test
    def void testMinCPU1() {
        ViatraQueryTest.test(MinCPU1QuerySpecification::instance)
                        .withAll
                        .assertEquals 
    }
    
    @Test
    def void testMinCPU2() {
        ViatraQueryTest.test(MinCPU2QuerySpecification::instance)
                        .withAll
                        .assertEquals 
    }
    
    @Test
    def void testMinCPU3() {
        ViatraQueryTest.test(MinCPU3QuerySpecification::instance)
                        .withAll
                        .assertEquals 
    }
    
    @Test
    def void testMinCPU4() {
        ViatraQueryTest.test(MinCPU4QuerySpecification::instance)
                        .withAll
                        .assertEquals 
    }

}