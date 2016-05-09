/*******************************************************************************
 * Copyright (c) 2014, 2016 IncQuery Labs Ltd.
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
import junit.framework.AssertionFailedError
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.viatra.examples.cps.tests.queries.util.CalleeQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.FlattenedQuerySpecification
import org.eclipse.viatra.query.runtime.matchers.backend.IQueryBackendFactory
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint
import org.eclipse.viatra.query.testing.core.MatchSetRecordDiff
import org.eclipse.viatra.query.testing.core.PatternBasedMatchSetModelProvider
import org.eclipse.viatra.query.testing.core.XmiModelUtil
import org.eclipse.viatra.query.testing.core.XmiModelUtil.XmiModelUtilRunningOptionEnum
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameter
import org.junit.runners.Parameterized.Parameters

// This test is necessary because of 481265 bug
@RunWith(Parameterized)
class FlattenedPatternCallCpsTest {
    @Parameters(name = "Backend: {0}, Model: {1}")
    def static Collection<Object[]> testData() {
        newArrayList(
            #[  BackendType.Rete,
                "org.eclipse.viatra.examples.cps.tests.instances/demo.cyberphysicalsystem"
            ],
            #[  BackendType.LocalSearch,
                "org.eclipse.viatra.examples.cps.tests.instances/demo.cyberphysicalsystem"
            ]
        )
    }
    
    @Parameter(0)
    public BackendType backendType
    IQueryBackendFactory queryBackendFactory
    @Parameter(1)
    public String modelPath
    ResourceSet rs
    
    
    @Before
    def void prepareTest() {
        queryBackendFactory = backendType.newBackendInstance
        val modelUri = XmiModelUtil::resolvePlatformURI(XmiModelUtilRunningOptionEnum.BOTH, modelPath)
        rs = new ResourceSetImpl
        rs.getResource(modelUri, true)
    }

    @Test
    def void flattenedPatternCallTest() {
        val hint = new QueryEvaluationHint(queryBackendFactory, emptyMap)
        val modelProvider = new PatternBasedMatchSetModelProvider(hint)
        val notFlattenedMatchSet = modelProvider.getMatchSetRecord(rs, CalleeQuerySpecification.instance, null)
        val flattenedMatchSet = modelProvider.getMatchSetRecord(rs, FlattenedQuerySpecification.instance, null)
        val diff = MatchSetRecordDiff.compute(notFlattenedMatchSet, flattenedMatchSet)
        if (!diff.empty) {
            throw new AssertionFailedError(diff.toString)
        }
    }
    
}