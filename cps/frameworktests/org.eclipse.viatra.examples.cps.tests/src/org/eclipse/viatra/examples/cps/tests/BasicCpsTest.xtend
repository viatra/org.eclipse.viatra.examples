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

import org.eclipse.viatra.examples.cps.tests.queries.SimpleCpsQueries
import org.eclipse.viatra.examples.cps.tests.queries.util.ApplicationInstancesOfApplicationTypeIdentifiersQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.ApplicationInstancesOfApplicationTypeQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.ApplicationInstancesQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.ApplicationTypeWithHostedInstanceIdentifiersQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.ApplicationTypeWithHostedInstancesQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.ApplicationTypeWithoutHostedInstanceIdentifiersQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.ApplicationTypeWithoutHostedInstanceQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.ApplicationTypesQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.CommunicateWithQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.FinalPatternQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.HasMoreCommunicationPartnerQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.HasMoreHostedApplicationInstancesQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.HasMoreHostedApplicationsQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.HasTheMostCommunicationPartnerQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.HasTheMostHostedApplicationInstancesQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.HasTheMostHostedApplicationsQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.HostInstanceWithAtLeastAsMuchTotalRamAsTotalHddQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.HostInstanceWithPrimeTotalRamQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.HostInstancesWithZeroTotalRamQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.HostedApplicationsQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.InTheCommunicationChainsQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.InstancesQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.TransitionsOfApplicationTypeIdentifiersQuerySpecification
import org.eclipse.viatra.examples.cps.tests.queries.util.TransitionsOfApplicationTypeQuerySpecification
import org.eclipse.viatra.query.runtime.api.IPatternMatch
import org.eclipse.viatra.query.runtime.api.IQuerySpecification
import org.eclipse.viatra.query.runtime.api.ViatraQueryMatcher
import org.eclipse.viatra.query.testing.core.api.ViatraQueryTest
import org.junit.Test

class BasicCpsTest {
    
    val snapshot = "org.eclipse.viatra.examples.cps.tests.queries/snapshots/test.snapshot"
    
    @Test
    def void testAllQueries() {
        SimpleCpsQueries.instance.specifications.forEach[
            ViatraQueryTest.test(it as IQuerySpecification<ViatraQueryMatcher<IPatternMatch>>)
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance).assertEquals
        ]
    }
    
    @Test
    def void testApplicationTypes() {
        ViatraQueryTest.test("org.eclipse.viatra.examples.cps.tests.queries.applicationTypes")
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void testApplicationInstances() {
        ViatraQueryTest.test("org.eclipse.viatra.examples.cps.tests.queries.applicationInstances")
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void testApplicationInstancesOfApplicationType() {
        ViatraQueryTest.test("org.eclipse.viatra.examples.cps.tests.queries.applicationInstancesOfApplicationType")
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void testApplicationInstancesOfApplicationTypeIdentifiers() {
        ViatraQueryTest.test("org.eclipse.viatra.examples.cps.tests.queries.applicationInstancesOfApplicationTypeIdentifiers")
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void testApplicationTypeWithHostedInstances() {
        ViatraQueryTest.test("org.eclipse.viatra.examples.cps.tests.queries.applicationTypeWithHostedInstances")
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void testApplicationTypeWithHostedInstanceIdentifiers() {
        ViatraQueryTest.test("org.eclipse.viatra.examples.cps.tests.queries.applicationTypeWithHostedInstanceIdentifiers")
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void testApplicationTypeWithoutHostedInstance() {
        ViatraQueryTest.test("org.eclipse.viatra.examples.cps.tests.queries.applicationTypeWithoutHostedInstance")
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void testApplicationTypeWithoutHostedInstanceIdentifiers() {
        ViatraQueryTest.test("org.eclipse.viatra.examples.cps.tests.queries.applicationTypeWithoutHostedInstanceIdentifiers")
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void testTransitionsOfApplicationType() {
        ViatraQueryTest.test("org.eclipse.viatra.examples.cps.tests.queries.transitionsOfApplicationType")
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void testTransitionsOfApplicationTypeIdentifiers() {
        ViatraQueryTest.test("org.eclipse.viatra.examples.cps.tests.queries.transitionsOfApplicationTypeIdentifiers")
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void testHostInstancesWithZeroTotalRam() {
        ViatraQueryTest.test("org.eclipse.viatra.examples.cps.tests.queries.hostInstancesWithZeroTotalRam")
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void testHostInstanceWithAtLeastAsMuchTotalRamAsTotalHdd() {
        ViatraQueryTest.test("org.eclipse.viatra.examples.cps.tests.queries.hostInstanceWithAtLeastAsMuchTotalRamAsTotalHdd")
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void testHostInstanceWithPrimeTotalRam() {
        ViatraQueryTest.test("org.eclipse.viatra.examples.cps.tests.queries.hostInstanceWithPrimeTotalRam")
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    // This is necessary because of 490761 bug
    @Test
    def void testHasMoreHostedApplicationInstances() {
        ViatraQueryTest.test("org.eclipse.viatra.examples.cps.tests.queries.hasMoreHostedApplicationInstances")
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    // This is necessary because of 490761 bug
    @Test
    def void testHasTheMostHostedApplicationInstances() {
        ViatraQueryTest.test("org.eclipse.viatra.examples.cps.tests.queries.hasTheMostHostedApplicationInstances")
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void testCommunicateWith() {
        ViatraQueryTest.test("org.eclipse.viatra.examples.cps.tests.queries.communicateWith")
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void testInTheCommunicationChains() {
        ViatraQueryTest.test("org.eclipse.viatra.examples.cps.tests.queries.inTheCommunicationChains")
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void testHasMoreCommunicationPartner() {
        ViatraQueryTest.test("org.eclipse.viatra.examples.cps.tests.queries.hasMoreCommunicationPartner")
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void testHasTheMostCommunicationPartner() {
        ViatraQueryTest.test("org.eclipse.viatra.examples.cps.tests.queries.hasTheMostCommunicationPartner")
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void testHostedApplications() {
        ViatraQueryTest.test("org.eclipse.viatra.examples.cps.tests.queries.hostedApplications")
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void testHasMoreHostedApplications() {
        ViatraQueryTest.test("org.eclipse.viatra.examples.cps.tests.queries.hasMoreHostedApplications")
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void testHasTheMostHostedApplications() {
        ViatraQueryTest.test("org.eclipse.viatra.examples.cps.tests.queries.hasTheMostHostedApplications")
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void testFinalPattern() {
        ViatraQueryTest.test("org.eclipse.viatra.examples.cps.tests.queries.finalPattern")
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void testInstances() {
        ViatraQueryTest.test("org.eclipse.viatra.examples.cps.tests.queries.instances")
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    
    @Test
    def void mfTestApplicationTypes() {
        ViatraQueryTest.test(ApplicationTypesQuerySpecification.instance)
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void mfTestApplicationInstances() {
        ViatraQueryTest.test(ApplicationInstancesQuerySpecification.instance)
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void mfTestApplicationInstancesOfApplicationType() {
        ViatraQueryTest.test(ApplicationInstancesOfApplicationTypeQuerySpecification.instance)
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void mfTestApplicationInstancesOfApplicationTypeIdentifiers() {
        ViatraQueryTest.test(ApplicationInstancesOfApplicationTypeIdentifiersQuerySpecification.instance)
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void mfTestApplicationTypeWithHostedInstances() {
        ViatraQueryTest.test(ApplicationTypeWithHostedInstancesQuerySpecification.instance)
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void mfTestApplicationTypeWithHostedInstanceIdentifiers() {
        ViatraQueryTest.test(ApplicationTypeWithHostedInstanceIdentifiersQuerySpecification.instance)
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void mfTestApplicationTypeWithoutHostedInstance() {
        ViatraQueryTest.test(ApplicationTypeWithoutHostedInstanceQuerySpecification.instance)
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void mfTestApplicationTypeWithoutHostedInstanceIdentifiers() {
        ViatraQueryTest.test(ApplicationTypeWithoutHostedInstanceIdentifiersQuerySpecification.instance)
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void mfTestTransitionsOfApplicationType() {
        ViatraQueryTest.test(TransitionsOfApplicationTypeQuerySpecification.instance)
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void mfTestTransitionsOfApplicationTypeIdentifiers() {
        ViatraQueryTest.test(TransitionsOfApplicationTypeIdentifiersQuerySpecification.instance)
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void mfTestHostInstancesWithZeroTotalRam() {
        ViatraQueryTest.test(HostInstancesWithZeroTotalRamQuerySpecification.instance)
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void mfTestHostInstanceWithAtLeastAsMuchTotalRamAsTotalHdd() {
        ViatraQueryTest.test(HostInstanceWithAtLeastAsMuchTotalRamAsTotalHddQuerySpecification.instance)
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void mfTestHostInstanceWithPrimeTotalRam() {
        ViatraQueryTest.test(HostInstanceWithPrimeTotalRamQuerySpecification.instance)
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void mfTestHasMoreHostedApplicationInstances() {
        ViatraQueryTest.test(HasMoreHostedApplicationInstancesQuerySpecification.instance)
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void mfTestHasTheMostHostedApplicationInstances() {
        ViatraQueryTest.test(HasTheMostHostedApplicationInstancesQuerySpecification.instance)
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void mfTestCommunicateWith() {
        ViatraQueryTest.test(CommunicateWithQuerySpecification.instance)
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void mfTestInTheCommunicationChains() {
        ViatraQueryTest.test(InTheCommunicationChainsQuerySpecification.instance)
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void mfTestHasMoreCommunicationPartner() {
        ViatraQueryTest.test(HasMoreCommunicationPartnerQuerySpecification.instance)
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void mfTestHasTheMostCommunicationPartner() {
        ViatraQueryTest.test(HasTheMostCommunicationPartnerQuerySpecification.instance)
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void mfTestHostedApplications() {
        ViatraQueryTest.test(HostedApplicationsQuerySpecification.instance)
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void mfTestHasMoreHostedApplications() {
        ViatraQueryTest.test(HasMoreHostedApplicationsQuerySpecification.instance)
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void mfTestHasTheMostHostedApplications() {
        ViatraQueryTest.test(HasTheMostHostedApplicationsQuerySpecification.instance)
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void mfTestFinalPattern() {
        ViatraQueryTest.test(FinalPatternQuerySpecification.instance)
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    @Test
    def void mfTestInstances() {
        ViatraQueryTest.test(InstancesQuerySpecification.instance)
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance)
                        .assertEquals 
    }
    
    @Test
    def void wildCardTestFinalPattern() {
        ViatraQueryTest.test(FinalPatternQuerySpecification.instance)
                        .with(snapshot)
                        .with(BackendType.Rete.newBackendInstance)
                        .with(BackendType.LocalSearch.newBackendInstance).assertEquals
    }
}
