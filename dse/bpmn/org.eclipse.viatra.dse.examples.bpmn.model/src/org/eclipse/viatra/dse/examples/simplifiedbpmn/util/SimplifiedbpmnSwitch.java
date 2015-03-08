/**
 */
package org.eclipse.viatra.dse.examples.simplifiedbpmn.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.viatra.dse.examples.simplifiedbpmn.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage
 * @generated
 */
public class SimplifiedbpmnSwitch<T> extends Switch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static SimplifiedbpmnPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SimplifiedbpmnSwitch() {
        if (modelPackage == null) {
            modelPackage = SimplifiedbpmnPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @parameter ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN: {
                SimplifiedBPMN simplifiedBPMN = (SimplifiedBPMN)theEObject;
                T result = caseSimplifiedBPMN(simplifiedBPMN);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimplifiedbpmnPackage.TASK: {
                Task task = (Task)theEObject;
                T result = caseTask(task);
                if (result == null) result = caseBaseElement(task);
                if (result == null) result = caseNamedElement(task);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimplifiedbpmnPackage.START_EVENT: {
                StartEvent startEvent = (StartEvent)theEObject;
                T result = caseStartEvent(startEvent);
                if (result == null) result = caseBaseElement(startEvent);
                if (result == null) result = caseNamedElement(startEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimplifiedbpmnPackage.END_EVENT: {
                EndEvent endEvent = (EndEvent)theEObject;
                T result = caseEndEvent(endEvent);
                if (result == null) result = caseBaseElement(endEvent);
                if (result == null) result = caseNamedElement(endEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimplifiedbpmnPackage.SEQUENCE_FLOW: {
                SequenceFlow sequenceFlow = (SequenceFlow)theEObject;
                T result = caseSequenceFlow(sequenceFlow);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimplifiedbpmnPackage.GATEWAY: {
                Gateway gateway = (Gateway)theEObject;
                T result = caseGateway(gateway);
                if (result == null) result = caseBaseElement(gateway);
                if (result == null) result = caseNamedElement(gateway);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimplifiedbpmnPackage.PARALLEL_GATEWAY: {
                ParallelGateway parallelGateway = (ParallelGateway)theEObject;
                T result = caseParallelGateway(parallelGateway);
                if (result == null) result = caseBaseElement(parallelGateway);
                if (result == null) result = caseNamedElement(parallelGateway);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimplifiedbpmnPackage.BASE_ELEMENT: {
                BaseElement baseElement = (BaseElement)theEObject;
                T result = caseBaseElement(baseElement);
                if (result == null) result = caseNamedElement(baseElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimplifiedbpmnPackage.RESOURCE_TYPE: {
                ResourceType resourceType = (ResourceType)theEObject;
                T result = caseResourceType(resourceType);
                if (result == null) result = caseNamedElement(resourceType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimplifiedbpmnPackage.RESOURCE_INSTANCE: {
                ResourceInstance resourceInstance = (ResourceInstance)theEObject;
                T result = caseResourceInstance(resourceInstance);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT: {
                ResourceTypeVariant resourceTypeVariant = (ResourceTypeVariant)theEObject;
                T result = caseResourceTypeVariant(resourceTypeVariant);
                if (result == null) result = caseNamedElement(resourceTypeVariant);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SimplifiedbpmnPackage.NAMED_ELEMENT: {
                NamedElement namedElement = (NamedElement)theEObject;
                T result = caseNamedElement(namedElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Simplified BPMN</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Simplified BPMN</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSimplifiedBPMN(SimplifiedBPMN object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Task</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Task</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTask(Task object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Start Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Start Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStartEvent(StartEvent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>End Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>End Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEndEvent(EndEvent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Sequence Flow</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Sequence Flow</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSequenceFlow(SequenceFlow object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Gateway</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Gateway</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGateway(Gateway object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Parallel Gateway</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Parallel Gateway</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseParallelGateway(ParallelGateway object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Base Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Base Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBaseElement(BaseElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Resource Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Resource Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseResourceType(ResourceType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Resource Instance</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Resource Instance</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseResourceInstance(ResourceInstance object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Resource Type Variant</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Resource Type Variant</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseResourceTypeVariant(ResourceTypeVariant object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNamedElement(NamedElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(EObject object) {
        return null;
    }

} //SimplifiedbpmnSwitch
