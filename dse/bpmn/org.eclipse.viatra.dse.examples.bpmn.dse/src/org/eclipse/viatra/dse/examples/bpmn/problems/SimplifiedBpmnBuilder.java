/*******************************************************************************
 * Copyright (c) 2010-2015, Andras Szabolcs Nagy, Abel Hegedus, Akos Horvath, Zoltan Ujhelyi and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Andras Szabolcs Nagy - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.dse.examples.bpmn.problems;

import org.eclipse.viatra.dse.examples.simplifiedbpmn.BaseElement;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.EndEvent;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.Gateway;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ParallelGateway;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceType;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnFactory;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.StartEvent;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.Task;

/**
 * This class simplifies the creation of a BPMN model by defining helper methods.
 * 
 * @author András Szabolcs Nagy
 */
public class SimplifiedBpmnBuilder {

    private final SimplifiedBPMN root;
    private SimplifiedbpmnFactory factory;

    public SimplifiedBpmnBuilder(SimplifiedBPMN root) {
        this.root = root;
        factory = SimplifiedbpmnFactory.eINSTANCE;
    }

    public SimplifiedBpmnBuilder() {
        factory = SimplifiedbpmnFactory.eINSTANCE;
        this.root = factory.createSimplifiedBPMN();
    }

    public SimplifiedBPMN getRoot() {
        return root;
    }

    public StartEvent createStartEvent(String name) {
        StartEvent startEvent = factory.createStartEvent();
        startEvent.setName(name);
        root.getStartEvents().add(startEvent);
        return startEvent;
    }

    public EndEvent createEndEvent(String name) {
        EndEvent endEvent = factory.createEndEvent();
        endEvent.setName(name);
        root.getEndEvents().add(endEvent);
        return endEvent;
    }

    public Task createTask(String name, int execTime, ResourceType resourceType) {
        Task task = factory.createTask();
        task.setName(name);
        task.setExecutionTime(execTime);
        task.setResourceNeeded(resourceType);
        root.getTasks().add(task);
        return task;
    }

    public Task createTask(String name, int execTime) {
        return createTask(name, execTime, null);
    }

    public Gateway createGateway(String name) {
        Gateway gateway = factory.createGateway();
        gateway.setName(name);
        root.getGateways().add(gateway);
        return gateway;
    }

    public ParallelGateway createParallelGateway(String name, boolean isDiverging) {
        ParallelGateway gateway = factory.createParallelGateway();
        gateway.setName(name);
        gateway.setDiverging(isDiverging);
        root.getParallelGateways().add(gateway);
        return gateway;
    }

    public ResourceType createResourceType(String name) {
        ResourceType resourceType = factory.createResourceType();
        resourceType.setName(name);
        root.getResourceTypes().add(resourceType);
        return resourceType;
    }

    public ResourceType createResourceTypeWithSimpleVariant(String name, int count) {
        ResourceType resourceType = createResourceType(name);
        createResourceTypeVariant(name, resourceType, 1.0, count);
        return resourceType;
    }

    public ResourceTypeVariant createResourceTypeVariant(String name, ResourceType resourceType, double efficiency,
            int count) {
        ResourceTypeVariant resourceTypeVariant = factory.createResourceTypeVariant();
        resourceTypeVariant.setName(name);
        resourceTypeVariant.setEfficiency(efficiency);
        resourceType.getVariants().add(resourceTypeVariant);
        for (int i = 0; i < count; i++) {
            ResourceInstance instance = factory.createResourceInstance();
            resourceTypeVariant.getInstances().add(instance);
        }
        return resourceTypeVariant;
    }

    public ResourceTypeVariant createResourceTypeVariant(String name, ResourceType resourceType, double efficiency) {
        return createResourceTypeVariant(name, resourceType, efficiency, 0);
    }

    public ResourceTypeVariant createResourceTypeVariant(String name, ResourceType resourceType) {
        return createResourceTypeVariant(name, resourceType, 1.0d, 0);
    }

    public SequenceFlow createFlow(BaseElement source, BaseElement target, int propability) {
        SequenceFlow flow = factory.createSequenceFlow();
        root.getSequenceFlows().add(flow);
        flow.setSource(source);
        flow.setTarget(target);
        flow.setPropability(propability);
        return flow;
    }

    public SequenceFlow createFlow(BaseElement source, BaseElement target) {
        return createFlow(source, target, 1);
    }

    public SequenceFlow createDataFlow(BaseElement source, BaseElement target, int propability) {
        SequenceFlow flow = createFlow(source, target, propability);
        flow.setIsDataFlow(true);
        return flow;
    }

    public SequenceFlow createDataFlow(BaseElement source, BaseElement target) {
        SequenceFlow flow = createFlow(source, target, 1);
        flow.setIsDataFlow(true);
        return flow;
    }
}