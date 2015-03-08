/**
 */
package org.eclipse.viatra.dse.examples.simplifiedbpmn;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Type Variant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant#getEfficiency <em>Efficiency</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant#getInstances <em>Instances</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getResourceTypeVariant()
 * @model
 * @generated
 */
public interface ResourceTypeVariant extends NamedElement {
    /**
     * Returns the value of the '<em><b>Efficiency</b></em>' attribute.
     * The default value is <code>"1.0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Efficiency</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Efficiency</em>' attribute.
     * @see #setEfficiency(double)
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getResourceTypeVariant_Efficiency()
     * @model default="1.0"
     * @generated
     */
    double getEfficiency();

    /**
     * Sets the value of the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant#getEfficiency <em>Efficiency</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Efficiency</em>' attribute.
     * @see #getEfficiency()
     * @generated
     */
    void setEfficiency(double value);

    /**
     * Returns the value of the '<em><b>Instances</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance}.
     * It is bidirectional and its opposite is '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance#getResourceTypeVariant <em>Resource Type Variant</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Instances</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Instances</em>' containment reference list.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getResourceTypeVariant_Instances()
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance#getResourceTypeVariant
     * @model opposite="resourceTypeVariant" containment="true"
     * @generated
     */
    EList<ResourceInstance> getInstances();

    /**
     * Returns the value of the '<em><b>Type</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceType#getVariants <em>Variants</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' container reference.
     * @see #setType(ResourceType)
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getResourceTypeVariant_Type()
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceType#getVariants
     * @model opposite="variants" transient="false"
     * @generated
     */
    ResourceType getType();

    /**
     * Sets the value of the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant#getType <em>Type</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' container reference.
     * @see #getType()
     * @generated
     */
    void setType(ResourceType value);

} // ResourceTypeVariant
