/*******************************************************************************
 * Copyright (c) 2010-2015, Andras Szabolcs Nagy and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Andras Szabolcs Nagy - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.dse.examples.cps.rules;

import org.eclipse.emf.common.util.EList;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.api.DSETransformationRule;
import org.eclipse.viatra.examples.dse.cps.ApplicationInstance;
import org.eclipse.viatra.examples.dse.cps.CpsFactory;
import org.eclipse.viatra.examples.dse.cps.CyberPhysicalSystem;
import org.eclipse.viatra.examples.dse.cps.HostInstance;
import org.eclipse.viatra.examples.dse.cps.HostType;
import org.eclipse.viatra.examples.dse.cps.Request;
import org.eclipse.viatra.examples.dse.cps.Requirement;
import org.eclipse.viatra.examples.dse.cps.ResourceRequirement;
import org.eclipse.viatra.examples.dse.cps.State;

import hu.bme.mit.inf.cps.patterns.AllocateMatch;
import hu.bme.mit.inf.cps.patterns.AllocateMatcher;
import hu.bme.mit.inf.cps.patterns.CancelRequestMatch;
import hu.bme.mit.inf.cps.patterns.CancelRequestMatcher;
import hu.bme.mit.inf.cps.patterns.CreateApplicationInstanceMatch;
import hu.bme.mit.inf.cps.patterns.CreateApplicationInstanceMatcher;
import hu.bme.mit.inf.cps.patterns.CreateApplicationInstancesMatch;
import hu.bme.mit.inf.cps.patterns.CreateApplicationInstancesMatcher;
import hu.bme.mit.inf.cps.patterns.CreateHostInstanceMatch;
import hu.bme.mit.inf.cps.patterns.CreateHostInstanceMatcher;
import hu.bme.mit.inf.cps.patterns.DeleteAllocationMatch;
import hu.bme.mit.inf.cps.patterns.DeleteAllocationMatcher;
import hu.bme.mit.inf.cps.patterns.MoveMatch;
import hu.bme.mit.inf.cps.patterns.MoveMatcher;
import hu.bme.mit.inf.cps.patterns.RemoveHostInstanceMatch;
import hu.bme.mit.inf.cps.patterns.RemoveHostInstanceMatcher;
import hu.bme.mit.inf.cps.patterns.StartInstanceMatch;
import hu.bme.mit.inf.cps.patterns.StartInstanceMatcher;
import hu.bme.mit.inf.cps.patterns.StopInstanceMatch;
import hu.bme.mit.inf.cps.patterns.StopInstanceMatcher;
import hu.bme.mit.inf.cps.patterns.util.AllocateProcessor;
import hu.bme.mit.inf.cps.patterns.util.CancelRequestProcessor;
import hu.bme.mit.inf.cps.patterns.util.CancelRequestQuerySpecification;
import hu.bme.mit.inf.cps.patterns.util.CreateApplicationInstanceProcessor;
import hu.bme.mit.inf.cps.patterns.util.CreateApplicationInstancesProcessor;
import hu.bme.mit.inf.cps.patterns.util.CreateApplicationInstancesQuerySpecification;
import hu.bme.mit.inf.cps.patterns.util.CreateHostInstanceProcessor;
import hu.bme.mit.inf.cps.patterns.util.DeleteAllocationProcessor;
import hu.bme.mit.inf.cps.patterns.util.MoveProcessor;
import hu.bme.mit.inf.cps.patterns.util.RemoveHostInstanceProcessor;
import hu.bme.mit.inf.cps.patterns.util.RemoveHostInstanceQuerySpecification;
import hu.bme.mit.inf.cps.patterns.util.StartInstanceProcessor;
import hu.bme.mit.inf.cps.patterns.util.StopInstanceProcessor;

public class Rules {

	public DSETransformationRule<AllocateMatch, AllocateMatcher> allocateRule;
    public DSETransformationRule<DeleteAllocationMatch, DeleteAllocationMatcher> deleteAllocRule;
    public DSETransformationRule<MoveMatch, MoveMatcher> moveRule;
    public DSETransformationRule<StartInstanceMatch, StartInstanceMatcher> startRule;
    public DSETransformationRule<StopInstanceMatch, StopInstanceMatcher> stopRule;
    public DSETransformationRule<CreateApplicationInstanceMatch, CreateApplicationInstanceMatcher> createAppRule;
	public DSETransformationRule<CreateHostInstanceMatch, CreateHostInstanceMatcher> createHostRule;
	
	// Not used
	public DSETransformationRule<CancelRequestMatch, CancelRequestMatcher> cancelRequestRule;
	public DSETransformationRule<CreateApplicationInstancesMatch, CreateApplicationInstancesMatcher> createAppsRule;
	public DSETransformationRule<RemoveHostInstanceMatch, RemoveHostInstanceMatcher> removeHostInstanceRule;

	public Rules() throws IncQueryException {

		allocateRule = new DSETransformationRule<>(
		        AllocateMatcher.querySpecification(),
		        new AllocateProcessor() {
		            
		    @Override
		    public void process(ApplicationInstance pAppInstance,
		            HostInstance pHostInstance, ResourceRequirement pReq) {
		        
		        pAppInstance.getAllocatedTo().add(pHostInstance);   
		        pHostInstance.setAvailableMemory(pHostInstance.getAvailableMemory() - pReq.getRequiredMemory());
		        pHostInstance.setAvailableHdd(pHostInstance.getAvailableHdd() - pReq.getRequiredHdd());
		        pHostInstance.setAvailableCpu(pHostInstance.getAvailableCpu() - pReq.getRequiredCpu());
		    }

		});
		
		deleteAllocRule = new DSETransformationRule<>(
		        DeleteAllocationMatcher.querySpecification(), 
		        new DeleteAllocationProcessor() {

		    @Override
		    public void process(ApplicationInstance pAppInstance,
		            HostInstance pHostInstance, ResourceRequirement pReq) {
		        
		        pAppInstance.getAllocatedTo().remove(pHostInstance);
		        pHostInstance.setAvailableMemory(pHostInstance.getAvailableMemory() + pReq.getRequiredMemory());
		        pHostInstance.setAvailableHdd(pHostInstance.getAvailableHdd() + pReq.getRequiredHdd());
		        pHostInstance.setAvailableCpu(pHostInstance.getAvailableCpu() + pReq.getRequiredCpu());
		    }

		});
		
		moveRule = new DSETransformationRule<>(
		        MoveMatcher.querySpecification(),
		        new MoveProcessor() {

		    @Override
		    public void process(ApplicationInstance pAppInstance, HostInstance pFrom,
		            HostInstance pTo, ResourceRequirement pReq) {
		        
		        pAppInstance.getAllocatedTo().remove(pFrom);
		        pAppInstance.getAllocatedTo().add(pTo);
		        
		        pTo.setAvailableMemory(pTo.getAvailableMemory() - pReq.getRequiredMemory());
		        pTo.setAvailableHdd(pTo.getAvailableHdd() - pReq.getRequiredHdd());
		        pTo.setAvailableCpu(pTo.getAvailableCpu() - pReq.getRequiredCpu());
		        
		        pFrom.setAvailableMemory(pFrom.getAvailableMemory() + pReq.getRequiredMemory());
		        pFrom.setAvailableHdd(pFrom.getAvailableHdd() + pReq.getRequiredHdd());
		        pFrom.setAvailableCpu(pFrom.getAvailableCpu() + pReq.getRequiredCpu());
		    }
		});
		
		
		
		startRule = new DSETransformationRule<>(
		        StartInstanceMatcher.querySpecification(),
		        new StartInstanceProcessor() {

		    @Override
		    public void process(ApplicationInstance pAppInstance) {
		        pAppInstance.setState(State.RUNNING);
		    }

		});
		
		stopRule = new DSETransformationRule<>(StopInstanceMatcher.querySpecification(), new StopInstanceProcessor() {

		    @Override
		    public void process(ApplicationInstance pAppInstance) {
		        pAppInstance.setState(State.STOPPED);
		    }

		});
		
		
		
		createAppRule = new DSETransformationRule<>(
		        CreateApplicationInstanceMatcher.querySpecification(),
		        new CreateApplicationInstanceProcessor() {

		    @Override
		    public void process(Requirement pReq) {
		        ApplicationInstance instance = CpsFactory.eINSTANCE.createApplicationInstance();
		        pReq.getType().getInstances().add(instance);
		        pReq.getInstances().add(instance);
		        instance.setId(pReq.getType().getId() + "App(" + pReq.getId() + pReq.getInstances().size() +")");
		    }
		});
		
		createHostRule = new DSETransformationRule<>(
		        CreateHostInstanceMatcher.querySpecification(),
		        new CreateHostInstanceProcessor() {

		    @Override
		    public void process(HostType pHostType) {
		        HostInstance hostInstance = CpsFactory.eINSTANCE.createHostInstance();
		        
		        hostInstance.setTotalCpu(pHostType.getDefaultCpu());
		        hostInstance.setAvailableCpu(pHostType.getDefaultCpu());
		        hostInstance.setTotalHdd(pHostType.getDefaultHdd());
		        hostInstance.setAvailableHdd(pHostType.getDefaultHdd());
		        hostInstance.setTotalMemory(pHostType.getDefaultMemory());
		        hostInstance.setAvailableMemory(pHostType.getDefaultMemory());
		        
		        hostInstance.setType(pHostType);
		        
		        pHostType.getInstances().add(hostInstance);
		        
		        hostInstance.setId(pHostType.getId() + pHostType.getInstances().size());
		        
		    }

		});

		// TODO ?
		cancelRequestRule = new DSETransformationRule<>(
		        CancelRequestQuerySpecification.instance(),
		        new CancelRequestProcessor() {
                    
                    @Override
                    public void process(Request pRequest, CyberPhysicalSystem pCps) {
                        pCps.getRequests().remove(pRequest);
                        // for each Requirement of the Request
                        for (Requirement req : pRequest.getRequirements()) {
                            pRequest.getRequirements().remove(req);
                            // for each ApplicationInstance of the Requirement
                            for (ApplicationInstance app : req.getInstances()) {
                                app.getType().getInstances().remove(app);
                                EList<HostInstance> hosts = app.getAllocatedTo();
                                if (hosts != null) {
                                    // for each HostInstance the app is allocated to
                                    for (HostInstance host : hosts) {
                                        // delete allocation
                                        for (ResourceRequirement rr : app.getType().getRequirements()) {
                                            if (rr.getHostType().equals(host.getType())) {
                                                app.getAllocatedTo().remove(host);
                                                host.setAvailableMemory(host.getAvailableMemory() + rr.getRequiredMemory());
                                                host.setAvailableHdd(host.getAvailableHdd() + rr.getRequiredHdd());
                                                host.setAvailableCpu(host.getAvailableCpu() + rr.getRequiredCpu());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                });
		
		createAppsRule = new DSETransformationRule<>(
		        CreateApplicationInstancesQuerySpecification.instance(),
		        new CreateApplicationInstancesProcessor() {
		            @Override
                    public void process(Requirement pReq) {
		                for (int i = 0; i < pReq.getCount(); i++) {
		                    ApplicationInstance instance = CpsFactory.eINSTANCE.createApplicationInstance();
		                    instance.setId("AppInsReq:" + pReq.getId() + "Id:" + i);
		                    pReq.getType().getInstances().add(instance);
		                    pReq.getInstances().add(instance);
		                }
                    }
                });
		
		removeHostInstanceRule = new DSETransformationRule<>(
		        RemoveHostInstanceQuerySpecification.instance(),
		        new RemoveHostInstanceProcessor() {
                    
                    @Override
                    public void process(HostInstance pHostInstance) {
                        for (ApplicationInstance app : pHostInstance.getApplications()) {
                            app.getAllocatedTo().remove(pHostInstance);
                            app.setState(State.STOPPED);
                        }
                        
                        pHostInstance.getType().getInstances().remove(pHostInstance);
                        
                    }
                });
		        
	}
}
