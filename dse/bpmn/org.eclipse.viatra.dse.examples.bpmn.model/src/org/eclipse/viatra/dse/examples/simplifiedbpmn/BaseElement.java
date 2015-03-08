/**
 */
package org.eclipse.viatra.dse.examples.simplifiedbpmn;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Base Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.BaseElement#getOutFlows <em>Out Flows</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.BaseElement#getInFlows <em>In Flows</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getBaseElement()
 * @model
 * @generated
 */
public interface BaseElement extends NamedElement {
    /**
     * Returns the value of the '<em><b>Out Flows</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow}.
     * It is bidirectional and its opposite is '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Out Flows</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Out Flows</em>' reference list.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getBaseElement_OutFlows()
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow#getSource
     * @model opposite="source"
     * @generated
     */
    EList<SequenceFlow> getOutFlows();

    /**
     * Returns the value of the '<em><b>In Flows</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow}.
     * It is bidirectional and its opposite is '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>In Flows</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>In Flows</em>' reference list.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getBaseElement_InFlows()
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow#getTarget
     * @model opposite="target"
     * @generated
     */
    EList<SequenceFlow> getInFlows();

} // BaseElement
