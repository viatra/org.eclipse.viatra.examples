/**
 */
package org.eclipse.viatra.dse.examples.simplifiedbpmn;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage
 * @generated
 */
public interface SimplifiedbpmnFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    SimplifiedbpmnFactory eINSTANCE = org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedbpmnFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Simplified BPMN</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Simplified BPMN</em>'.
     * @generated
     */
    SimplifiedBPMN createSimplifiedBPMN();

    /**
     * Returns a new object of class '<em>Task</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Task</em>'.
     * @generated
     */
    Task createTask();

    /**
     * Returns a new object of class '<em>Start Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Start Event</em>'.
     * @generated
     */
    StartEvent createStartEvent();

    /**
     * Returns a new object of class '<em>End Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>End Event</em>'.
     * @generated
     */
    EndEvent createEndEvent();

    /**
     * Returns a new object of class '<em>Sequence Flow</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Sequence Flow</em>'.
     * @generated
     */
    SequenceFlow createSequenceFlow();

    /**
     * Returns a new object of class '<em>Gateway</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Gateway</em>'.
     * @generated
     */
    Gateway createGateway();

    /**
     * Returns a new object of class '<em>Parallel Gateway</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Parallel Gateway</em>'.
     * @generated
     */
    ParallelGateway createParallelGateway();

    /**
     * Returns a new object of class '<em>Base Element</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Base Element</em>'.
     * @generated
     */
    BaseElement createBaseElement();

    /**
     * Returns a new object of class '<em>Resource Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Resource Type</em>'.
     * @generated
     */
    ResourceType createResourceType();

    /**
     * Returns a new object of class '<em>Resource Instance</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Resource Instance</em>'.
     * @generated
     */
    ResourceInstance createResourceInstance();

    /**
     * Returns a new object of class '<em>Resource Type Variant</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Resource Type Variant</em>'.
     * @generated
     */
    ResourceTypeVariant createResourceTypeVariant();

    /**
     * Returns a new object of class '<em>Named Element</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Named Element</em>'.
     * @generated
     */
    NamedElement createNamedElement();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    SimplifiedbpmnPackage getSimplifiedbpmnPackage();

} //SimplifiedbpmnFactory
