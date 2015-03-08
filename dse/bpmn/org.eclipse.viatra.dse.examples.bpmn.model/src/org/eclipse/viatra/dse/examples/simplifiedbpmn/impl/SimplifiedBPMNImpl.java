/**
 */
package org.eclipse.viatra.dse.examples.simplifiedbpmn.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.viatra.dse.examples.simplifiedbpmn.EndEvent;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.Gateway;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ParallelGateway;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceType;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.StartEvent;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.Task;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simplified BPMN</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedBPMNImpl#getTasks <em>Tasks</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedBPMNImpl#getStartEvents <em>Start Events</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedBPMNImpl#getEndEvents <em>End Events</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedBPMNImpl#getGateways <em>Gateways</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedBPMNImpl#getParallelGateways <em>Parallel Gateways</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedBPMNImpl#getSequenceFlows <em>Sequence Flows</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedBPMNImpl#getResourceTypes <em>Resource Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimplifiedBPMNImpl extends MinimalEObjectImpl.Container implements SimplifiedBPMN {
    /**
     * The cached value of the '{@link #getTasks() <em>Tasks</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTasks()
     * @generated
     * @ordered
     */
    protected EList<Task> tasks;

    /**
     * The cached value of the '{@link #getStartEvents() <em>Start Events</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStartEvents()
     * @generated
     * @ordered
     */
    protected EList<StartEvent> startEvents;

    /**
     * The cached value of the '{@link #getEndEvents() <em>End Events</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEndEvents()
     * @generated
     * @ordered
     */
    protected EList<EndEvent> endEvents;

    /**
     * The cached value of the '{@link #getGateways() <em>Gateways</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGateways()
     * @generated
     * @ordered
     */
    protected EList<Gateway> gateways;

    /**
     * The cached value of the '{@link #getParallelGateways() <em>Parallel Gateways</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParallelGateways()
     * @generated
     * @ordered
     */
    protected EList<ParallelGateway> parallelGateways;

    /**
     * The cached value of the '{@link #getSequenceFlows() <em>Sequence Flows</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSequenceFlows()
     * @generated
     * @ordered
     */
    protected EList<SequenceFlow> sequenceFlows;

    /**
     * The cached value of the '{@link #getResourceTypes() <em>Resource Types</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getResourceTypes()
     * @generated
     * @ordered
     */
    protected EList<ResourceType> resourceTypes;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SimplifiedBPMNImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SimplifiedbpmnPackage.Literals.SIMPLIFIED_BPMN;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Task> getTasks() {
        if (tasks == null) {
            tasks = new EObjectContainmentEList<Task>(Task.class, this, SimplifiedbpmnPackage.SIMPLIFIED_BPMN__TASKS);
        }
        return tasks;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<StartEvent> getStartEvents() {
        if (startEvents == null) {
            startEvents = new EObjectContainmentEList<StartEvent>(StartEvent.class, this, SimplifiedbpmnPackage.SIMPLIFIED_BPMN__START_EVENTS);
        }
        return startEvents;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<EndEvent> getEndEvents() {
        if (endEvents == null) {
            endEvents = new EObjectContainmentEList<EndEvent>(EndEvent.class, this, SimplifiedbpmnPackage.SIMPLIFIED_BPMN__END_EVENTS);
        }
        return endEvents;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Gateway> getGateways() {
        if (gateways == null) {
            gateways = new EObjectContainmentEList<Gateway>(Gateway.class, this, SimplifiedbpmnPackage.SIMPLIFIED_BPMN__GATEWAYS);
        }
        return gateways;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ParallelGateway> getParallelGateways() {
        if (parallelGateways == null) {
            parallelGateways = new EObjectContainmentEList<ParallelGateway>(ParallelGateway.class, this, SimplifiedbpmnPackage.SIMPLIFIED_BPMN__PARALLEL_GATEWAYS);
        }
        return parallelGateways;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<SequenceFlow> getSequenceFlows() {
        if (sequenceFlows == null) {
            sequenceFlows = new EObjectContainmentEList<SequenceFlow>(SequenceFlow.class, this, SimplifiedbpmnPackage.SIMPLIFIED_BPMN__SEQUENCE_FLOWS);
        }
        return sequenceFlows;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ResourceType> getResourceTypes() {
        if (resourceTypes == null) {
            resourceTypes = new EObjectContainmentEList<ResourceType>(ResourceType.class, this, SimplifiedbpmnPackage.SIMPLIFIED_BPMN__RESOURCE_TYPES);
        }
        return resourceTypes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__TASKS:
                return ((InternalEList<?>)getTasks()).basicRemove(otherEnd, msgs);
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__START_EVENTS:
                return ((InternalEList<?>)getStartEvents()).basicRemove(otherEnd, msgs);
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__END_EVENTS:
                return ((InternalEList<?>)getEndEvents()).basicRemove(otherEnd, msgs);
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__GATEWAYS:
                return ((InternalEList<?>)getGateways()).basicRemove(otherEnd, msgs);
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__PARALLEL_GATEWAYS:
                return ((InternalEList<?>)getParallelGateways()).basicRemove(otherEnd, msgs);
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__SEQUENCE_FLOWS:
                return ((InternalEList<?>)getSequenceFlows()).basicRemove(otherEnd, msgs);
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__RESOURCE_TYPES:
                return ((InternalEList<?>)getResourceTypes()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__TASKS:
                return getTasks();
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__START_EVENTS:
                return getStartEvents();
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__END_EVENTS:
                return getEndEvents();
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__GATEWAYS:
                return getGateways();
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__PARALLEL_GATEWAYS:
                return getParallelGateways();
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__SEQUENCE_FLOWS:
                return getSequenceFlows();
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__RESOURCE_TYPES:
                return getResourceTypes();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__TASKS:
                getTasks().clear();
                getTasks().addAll((Collection<? extends Task>)newValue);
                return;
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__START_EVENTS:
                getStartEvents().clear();
                getStartEvents().addAll((Collection<? extends StartEvent>)newValue);
                return;
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__END_EVENTS:
                getEndEvents().clear();
                getEndEvents().addAll((Collection<? extends EndEvent>)newValue);
                return;
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__GATEWAYS:
                getGateways().clear();
                getGateways().addAll((Collection<? extends Gateway>)newValue);
                return;
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__PARALLEL_GATEWAYS:
                getParallelGateways().clear();
                getParallelGateways().addAll((Collection<? extends ParallelGateway>)newValue);
                return;
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__SEQUENCE_FLOWS:
                getSequenceFlows().clear();
                getSequenceFlows().addAll((Collection<? extends SequenceFlow>)newValue);
                return;
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__RESOURCE_TYPES:
                getResourceTypes().clear();
                getResourceTypes().addAll((Collection<? extends ResourceType>)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__TASKS:
                getTasks().clear();
                return;
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__START_EVENTS:
                getStartEvents().clear();
                return;
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__END_EVENTS:
                getEndEvents().clear();
                return;
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__GATEWAYS:
                getGateways().clear();
                return;
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__PARALLEL_GATEWAYS:
                getParallelGateways().clear();
                return;
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__SEQUENCE_FLOWS:
                getSequenceFlows().clear();
                return;
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__RESOURCE_TYPES:
                getResourceTypes().clear();
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__TASKS:
                return tasks != null && !tasks.isEmpty();
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__START_EVENTS:
                return startEvents != null && !startEvents.isEmpty();
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__END_EVENTS:
                return endEvents != null && !endEvents.isEmpty();
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__GATEWAYS:
                return gateways != null && !gateways.isEmpty();
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__PARALLEL_GATEWAYS:
                return parallelGateways != null && !parallelGateways.isEmpty();
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__SEQUENCE_FLOWS:
                return sequenceFlows != null && !sequenceFlows.isEmpty();
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN__RESOURCE_TYPES:
                return resourceTypes != null && !resourceTypes.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //SimplifiedBPMNImpl
