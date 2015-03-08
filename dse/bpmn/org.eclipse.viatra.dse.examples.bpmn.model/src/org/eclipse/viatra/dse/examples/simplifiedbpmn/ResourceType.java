/**
 */
package org.eclipse.viatra.dse.examples.simplifiedbpmn;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceType#getUsedByTasks <em>Used By Tasks</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceType#getVariants <em>Variants</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getResourceType()
 * @model
 * @generated
 */
public interface ResourceType extends NamedElement {
    /**
     * Returns the value of the '<em><b>Used By Tasks</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.viatra.dse.examples.simplifiedbpmn.Task}.
     * It is bidirectional and its opposite is '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.Task#getResourceNeeded <em>Resource Needed</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Used By Tasks</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Used By Tasks</em>' reference list.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getResourceType_UsedByTasks()
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.Task#getResourceNeeded
     * @model opposite="resourceNeeded"
     * @generated
     */
    EList<Task> getUsedByTasks();

    /**
     * Returns the value of the '<em><b>Variants</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant}.
     * It is bidirectional and its opposite is '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Variants</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Variants</em>' containment reference list.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getResourceType_Variants()
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant#getType
     * @model opposite="type" containment="true"
     * @generated
     */
    EList<ResourceTypeVariant> getVariants();

} // ResourceType
