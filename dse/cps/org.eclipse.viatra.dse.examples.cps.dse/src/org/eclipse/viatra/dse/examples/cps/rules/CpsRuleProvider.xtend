/** 
 * Copyright (c) 2010-2015, Andras Szabolcs Nagy and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * Andras Szabolcs Nagy - initial API and implementation
 */
package org.eclipse.viatra.dse.examples.cps.rules

import org.eclipse.emf.common.util.EList
import org.eclipse.viatra.dse.examples.cps.ApplicationInstance
import org.eclipse.viatra.dse.examples.cps.CpsFactory
import org.eclipse.viatra.dse.examples.cps.HostInstance
import org.eclipse.viatra.dse.examples.cps.Requirement
import org.eclipse.viatra.dse.examples.cps.ResourceRequirement
import org.eclipse.viatra.dse.examples.cps.State
import org.eclipse.viatra.dse.examples.cps.patterns.AllocateMatch
import org.eclipse.viatra.dse.examples.cps.patterns.AllocateMatcher
import org.eclipse.viatra.dse.examples.cps.patterns.CancelRequestMatch
import org.eclipse.viatra.dse.examples.cps.patterns.CancelRequestMatcher
import org.eclipse.viatra.dse.examples.cps.patterns.CreateApplicationInstanceMatch
import org.eclipse.viatra.dse.examples.cps.patterns.CreateApplicationInstanceMatcher
import org.eclipse.viatra.dse.examples.cps.patterns.CreateApplicationInstancesMatch
import org.eclipse.viatra.dse.examples.cps.patterns.CreateApplicationInstancesMatcher
import org.eclipse.viatra.dse.examples.cps.patterns.CreateHostInstanceMatch
import org.eclipse.viatra.dse.examples.cps.patterns.CreateHostInstanceMatcher
import org.eclipse.viatra.dse.examples.cps.patterns.DeleteAllocationMatch
import org.eclipse.viatra.dse.examples.cps.patterns.DeleteAllocationMatcher
import org.eclipse.viatra.dse.examples.cps.patterns.MoveMatch
import org.eclipse.viatra.dse.examples.cps.patterns.MoveMatcher
import org.eclipse.viatra.dse.examples.cps.patterns.RemoveHostInstanceMatch
import org.eclipse.viatra.dse.examples.cps.patterns.RemoveHostInstanceMatcher
import org.eclipse.viatra.dse.examples.cps.patterns.StartInstanceMatch
import org.eclipse.viatra.dse.examples.cps.patterns.StartInstanceMatcher
import org.eclipse.viatra.dse.examples.cps.patterns.StopInstanceMatch
import org.eclipse.viatra.dse.examples.cps.patterns.StopInstanceMatcher
import org.eclipse.viatra.dse.examples.cps.patterns.util.AllocateQuerySpecification
import org.eclipse.viatra.dse.examples.cps.patterns.util.CancelRequestQuerySpecification
import org.eclipse.viatra.dse.examples.cps.patterns.util.CreateApplicationInstanceQuerySpecification
import org.eclipse.viatra.dse.examples.cps.patterns.util.CreateApplicationInstancesQuerySpecification
import org.eclipse.viatra.dse.examples.cps.patterns.util.CreateHostInstanceQuerySpecification
import org.eclipse.viatra.dse.examples.cps.patterns.util.DeleteAllocationQuerySpecification
import org.eclipse.viatra.dse.examples.cps.patterns.util.MoveQuerySpecification
import org.eclipse.viatra.dse.examples.cps.patterns.util.RemoveHostInstanceQuerySpecification
import org.eclipse.viatra.dse.examples.cps.patterns.util.StartInstanceQuerySpecification
import org.eclipse.viatra.dse.examples.cps.patterns.util.StopInstanceQuerySpecification
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRule
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory

class CpsRuleProvider {
    
    private extension BatchTransformationRuleFactory ruleFactory = new BatchTransformationRuleFactory
    
    public BatchTransformationRule<AllocateMatch, AllocateMatcher> allocateRule
    public BatchTransformationRule<DeleteAllocationMatch, DeleteAllocationMatcher> deleteAllocRule
    public BatchTransformationRule<MoveMatch, MoveMatcher> moveRule
    public BatchTransformationRule<StartInstanceMatch, StartInstanceMatcher> startRule
    public BatchTransformationRule<StopInstanceMatch, StopInstanceMatcher> stopRule
    public BatchTransformationRule<CreateApplicationInstanceMatch, CreateApplicationInstanceMatcher> createAppRule
    public BatchTransformationRule<CreateHostInstanceMatch, CreateHostInstanceMatcher> createHostRule
    // Not used
    public BatchTransformationRule<CancelRequestMatch, CancelRequestMatcher> cancelRequestRule
    public BatchTransformationRule<CreateApplicationInstancesMatch, CreateApplicationInstancesMatcher> createAppsRule
    public BatchTransformationRule<RemoveHostInstanceMatch, RemoveHostInstanceMatcher> removeHostInstanceRule

    new() throws ViatraQueryException {
        allocateRule = createRule
            .name("AllocateRule")
            .precondition(AllocateQuerySpecification.instance)
            .action() [
                appInstance.getAllocatedTo().add(hostInstance)
                hostInstance.setAvailableMemory(hostInstance.getAvailableMemory() - req.getRequiredMemory())
                hostInstance.setAvailableHdd(hostInstance.getAvailableHdd() - req.getRequiredHdd())
                hostInstance.setAvailableCpu(hostInstance.getAvailableCpu() - req.getRequiredCpu())
            ]
            .build

        deleteAllocRule = createRule
            .name("DeleteAllocationRule")
            .precondition(DeleteAllocationQuerySpecification.instance)
            .action()[
                appInstance.getAllocatedTo().remove(hostInstance)
                hostInstance.setAvailableMemory(hostInstance.getAvailableMemory() + req.getRequiredMemory())
                hostInstance.setAvailableHdd(hostInstance.getAvailableHdd() + req.getRequiredHdd())
                hostInstance.setAvailableCpu(hostInstance.getAvailableCpu() + req.getRequiredCpu())
            ]
            .build

        moveRule = createRule
            .name("moveRule")
            .precondition(MoveQuerySpecification.instance)
            .action[
                appInstance.getAllocatedTo().remove(from)
                appInstance.getAllocatedTo().add(to)
                to.setAvailableMemory(to.getAvailableMemory() - req.getRequiredMemory())
                to.setAvailableHdd(to.getAvailableHdd() - req.getRequiredHdd())
                to.setAvailableCpu(to.getAvailableCpu() - req.getRequiredCpu())
                from.setAvailableMemory(from.getAvailableMemory() + req.getRequiredMemory())
                from.setAvailableHdd(from.getAvailableHdd() + req.getRequiredHdd())
                from.setAvailableCpu(from.getAvailableCpu() + req.getRequiredCpu())
            ]
            .build

        startRule = createRule
            .name("StartRule")
            .precondition(StartInstanceQuerySpecification.instance)
            .action [
                appInstance.setState(State::RUNNING)
            ]
            .build

        stopRule = createRule
            .name("StopRule")
            .precondition(StopInstanceQuerySpecification.instance)
            .action [
                appInstance.setState(State::STOPPED)
            ]
            .build
            
        createAppRule = createRule
            .name("CreateAppRule")
            .precondition(CreateApplicationInstanceQuerySpecification.instance)
            .action[
                var ApplicationInstance instance = CpsFactory::eINSTANCE.createApplicationInstance()
                req.getType().getInstances().add(instance)
                req.getInstances().add(instance)
                instance.setId('''«req.getType().getId()»App(«req.getId()»«req.getInstances().size()»)'''.toString)
            ]
            .build

        createHostRule = createRule
            .name("CreateHostRule")
            .precondition(CreateHostInstanceQuerySpecification.instance)
            .action()[
                var HostInstance hostInstance = CpsFactory::eINSTANCE.createHostInstance()
                hostInstance.setTotalCpu(hostType.getDefaultCpu())
                hostInstance.setAvailableCpu(hostType.getDefaultCpu())
                hostInstance.setTotalHdd(hostType.getDefaultHdd())
                hostInstance.setAvailableHdd(hostType.getDefaultHdd())
                hostInstance.setTotalMemory(hostType.getDefaultMemory())
                hostInstance.setAvailableMemory(hostType.getDefaultMemory())
                hostInstance.setType(hostType)
                hostType.getInstances().add(hostInstance)
                hostInstance.setId(hostType.getId() + hostType.getInstances().size())
            ]
            .build
        // TODO ?
        cancelRequestRule = createRule
            .name("CancelRequestRule")
            .precondition(CancelRequestQuerySpecification.instance)
            .action[
                cps.getRequests().remove(request) // for each Requirement of the Request
                for (Requirement req : request.getRequirements()) {
                    request.getRequirements().remove(req)
                    // for each ApplicationInstance of the Requirement
                    for (ApplicationInstance app : req.getInstances()) {
                        app.getType().getInstances().remove(app)
                        var EList<HostInstance> hosts = app.getAllocatedTo()
                        if (hosts !== null) {
                            // for each HostInstance the app is allocated to
                            for (HostInstance host : hosts) {
                                // delete allocation
                                for (ResourceRequirement rr : app.getType().getRequirements()) {
                                    if (rr.getHostType().equals(host.getType())) {
                                        app.getAllocatedTo().remove(host)
                                        host.setAvailableMemory(host.getAvailableMemory() + rr.getRequiredMemory())
                                        host.setAvailableHdd(host.getAvailableHdd() + rr.getRequiredHdd())
                                        host.setAvailableCpu(host.getAvailableCpu() + rr.getRequiredCpu())
                                    }
                                }
                            }
                        }
                    }
                }
            ]
            .build

        createAppsRule = createRule
            .name("CreateAppsRule")
            .precondition(CreateApplicationInstancesQuerySpecification.instance)
            .action [
                for (var int i = 0; i < req.getCount(); i++) {
                    var ApplicationInstance instance = CpsFactory::eINSTANCE.createApplicationInstance()
                    instance.setId('''AppInsReq:«req.getId()»Id:«i»'''.toString)
                    req.getType().getInstances().add(instance)
                    req.getInstances().add(instance)
                }
            ]
            .build

        removeHostInstanceRule = createRule
            .name("RemoveHosInstanceRule")
            .precondition(RemoveHostInstanceQuerySpecification.instance)
            .action[
                for (ApplicationInstance app : hostInstance.getApplications()) {
                    app.getAllocatedTo().remove(hostInstance)
                    app.setState(State::STOPPED)
                }
                hostInstance.getType().getInstances().remove(hostInstance)
            ]
            .build
    }
}
