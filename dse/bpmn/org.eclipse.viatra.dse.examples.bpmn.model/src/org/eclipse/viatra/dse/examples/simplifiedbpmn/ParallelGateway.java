/**
 */
package org.eclipse.viatra.dse.examples.simplifiedbpmn;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parallel Gateway</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ParallelGateway#isDiverging <em>Diverging</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getParallelGateway()
 * @model
 * @generated
 */
public interface ParallelGateway extends BaseElement {
    /**
     * Returns the value of the '<em><b>Diverging</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Diverging</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Diverging</em>' attribute.
     * @see #setDiverging(boolean)
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getParallelGateway_Diverging()
     * @model
     * @generated
     */
    boolean isDiverging();

    /**
     * Sets the value of the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ParallelGateway#isDiverging <em>Diverging</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Diverging</em>' attribute.
     * @see #isDiverging()
     * @generated
     */
    void setDiverging(boolean value);

} // ParallelGateway
