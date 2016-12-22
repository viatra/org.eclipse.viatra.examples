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

import org.eclipse.viatra.examples.cps.tests.queries.util.MandatoryRequirementsQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.OptionalRequirementsQuerySpecification
import org.eclipse.viatra.query.testing.core.api.ViatraQueryTest
import org.junit.Test

class LiteralValuesTest {
    
    val snapshot = "org.eclipse.viatra.examples.cps.tests.queries/snapshots/test_mandatoryRequirements.snapshot"
    
    extension AllBackendTypes = new AllBackendTypes
    
    @Test
    def void booleanFalseTest() {
        ViatraQueryTest.test(OptionalRequirementsQuerySpecification.instance)
                        .with(snapshot)
                        .withAll
                        .assertEquals
    }
    @Test
    def void booleanTrueTest() {
        ViatraQueryTest.test(MandatoryRequirementsQuerySpecification.instance)
                        .with(snapshot)
                        .withAll
                        .assertEquals
    }
}