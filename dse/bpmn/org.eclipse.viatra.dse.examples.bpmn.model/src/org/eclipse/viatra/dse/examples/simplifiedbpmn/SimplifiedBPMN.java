/**
 */
package org.eclipse.viatra.dse.examples.simplifiedbpmn;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN#getTasks <em>Tasks</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN#getStartEvents <em>Start Events</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN#getEndEvents <em>End Events</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN#getGateways <em>Gateways</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN#getParallelGateways <em>Parallel Gateways</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN#getSequenceFlows <em>Sequence Flows</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN#getResourceTypes <em>Resource Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getSimplifiedBPMN()
 * @model
 * @generated
 */
public interface SimplifiedBPMN extends EObject {
    /**
     * Returns the value of the '<em><b>Tasks</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.viatra.dse.examples.simplifiedbpmn.Task}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tasks</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Tasks</em>' containment reference list.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getSimplifiedBPMN_Tasks()
     * @model containment="true"
     * @generated
     */
    EList<Task> getTasks();

    /**
     * Returns the value of the '<em><b>Start Events</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.viatra.dse.examples.simplifiedbpmn.StartEvent}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Start Events</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Start Events</em>' containment reference list.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getSimplifiedBPMN_StartEvents()
     * @model containment="true"
     * @generated
     */
    EList<StartEvent> getStartEvents();

    /**
     * Returns the value of the '<em><b>End Events</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.viatra.dse.examples.simplifiedbpmn.EndEvent}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>End Events</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>End Events</em>' containment reference list.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getSimplifiedBPMN_EndEvents()
     * @model containment="true"
     * @generated
     */
    EList<EndEvent> getEndEvents();

    /**
     * Returns the value of the '<em><b>Gateways</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.viatra.dse.examples.simplifiedbpmn.Gateway}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Gateways</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Gateways</em>' containment reference list.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getSimplifiedBPMN_Gateways()
     * @model containment="true"
     * @generated
     */
    EList<Gateway> getGateways();

    /**
     * Returns the value of the '<em><b>Parallel Gateways</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ParallelGateway}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parallel Gateways</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parallel Gateways</em>' containment reference list.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getSimplifiedBPMN_ParallelGateways()
     * @model containment="true"
     * @generated
     */
    EList<ParallelGateway> getParallelGateways();

    /**
     * Returns the value of the '<em><b>Sequence Flows</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sequence Flows</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Sequence Flows</em>' containment reference list.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getSimplifiedBPMN_SequenceFlows()
     * @model containment="true"
     * @generated
     */
    EList<SequenceFlow> getSequenceFlows();

    /**
     * Returns the value of the '<em><b>Resource Types</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Resource Types</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Resource Types</em>' containment reference list.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getSimplifiedBPMN_ResourceTypes()
     * @model containment="true"
     * @generated
     */
    EList<ResourceType> getResourceTypes();

} // Root
