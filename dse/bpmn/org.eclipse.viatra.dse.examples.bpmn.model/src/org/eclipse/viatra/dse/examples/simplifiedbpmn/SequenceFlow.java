/**
 */
package org.eclipse.viatra.dse.examples.simplifiedbpmn;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow#getPropability <em>Propability</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow#isIsDataFlow <em>Is Data Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getSequenceFlow()
 * @model
 * @generated
 */
public interface SequenceFlow extends EObject {
    /**
     * Returns the value of the '<em><b>Source</b></em>' reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.BaseElement#getOutFlows <em>Out Flows</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source</em>' reference.
     * @see #setSource(BaseElement)
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getSequenceFlow_Source()
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.BaseElement#getOutFlows
     * @model opposite="outFlows"
     * @generated
     */
    BaseElement getSource();

    /**
     * Sets the value of the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow#getSource <em>Source</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source</em>' reference.
     * @see #getSource()
     * @generated
     */
    void setSource(BaseElement value);

    /**
     * Returns the value of the '<em><b>Target</b></em>' reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.BaseElement#getInFlows <em>In Flows</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target</em>' reference.
     * @see #setTarget(BaseElement)
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getSequenceFlow_Target()
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.BaseElement#getInFlows
     * @model opposite="inFlows"
     * @generated
     */
    BaseElement getTarget();

    /**
     * Sets the value of the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow#getTarget <em>Target</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target</em>' reference.
     * @see #getTarget()
     * @generated
     */
    void setTarget(BaseElement value);

    /**
     * Returns the value of the '<em><b>Propability</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Propability</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Propability</em>' attribute.
     * @see #setPropability(int)
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getSequenceFlow_Propability()
     * @model
     * @generated
     */
    int getPropability();

    /**
     * Sets the value of the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow#getPropability <em>Propability</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Propability</em>' attribute.
     * @see #getPropability()
     * @generated
     */
    void setPropability(int value);

    /**
     * Returns the value of the '<em><b>Is Data Flow</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Is Data Flow</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Is Data Flow</em>' attribute.
     * @see #setIsDataFlow(boolean)
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getSequenceFlow_IsDataFlow()
     * @model
     * @generated
     */
    boolean isIsDataFlow();

    /**
     * Sets the value of the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow#isIsDataFlow <em>Is Data Flow</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Data Flow</em>' attribute.
     * @see #isIsDataFlow()
     * @generated
     */
    void setIsDataFlow(boolean value);

} // SequenceFlow
