package org.eclipse.viatra.examples.cps.tests

import org.eclipse.viatra.query.testing.core.api.ViatraQueryTest

class AllBackendTypes {
    
    def ViatraQueryTest withAll(ViatraQueryTest test){
        BackendType.values.fold(test,[t, type | t.with(type.hints)])
    }
    
}