/**
 */
package org.eclipse.viatra.dse.examples.simplifiedbpmn;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance#getResourceTypeVariant <em>Resource Type Variant</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getResourceInstance()
 * @model
 * @generated
 */
public interface ResourceInstance extends EObject {
    /**
     * Returns the value of the '<em><b>Resource Type Variant</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant#getInstances <em>Instances</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Resource Type Variant</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Resource Type Variant</em>' container reference.
     * @see #setResourceTypeVariant(ResourceTypeVariant)
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getResourceInstance_ResourceTypeVariant()
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant#getInstances
     * @model opposite="instances" transient="false"
     * @generated
     */
    ResourceTypeVariant getResourceTypeVariant();

    /**
     * Sets the value of the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance#getResourceTypeVariant <em>Resource Type Variant</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Resource Type Variant</em>' container reference.
     * @see #getResourceTypeVariant()
     * @generated
     */
    void setResourceTypeVariant(ResourceTypeVariant value);

} // ResourceInstance
