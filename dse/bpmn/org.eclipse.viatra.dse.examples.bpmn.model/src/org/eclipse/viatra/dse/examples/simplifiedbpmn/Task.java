/**
 */
package org.eclipse.viatra.dse.examples.simplifiedbpmn;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.Task#getExecutionTime <em>Execution Time</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.Task#getResourceNeeded <em>Resource Needed</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.Task#getVariant <em>Variant</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getTask()
 * @model
 * @generated
 */
public interface Task extends BaseElement {
    /**
     * Returns the value of the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Execution Time</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Execution Time</em>' attribute.
     * @see #setExecutionTime(int)
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getTask_ExecutionTime()
     * @model
     * @generated
     */
    int getExecutionTime();

    /**
     * Sets the value of the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.Task#getExecutionTime <em>Execution Time</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Execution Time</em>' attribute.
     * @see #getExecutionTime()
     * @generated
     */
    void setExecutionTime(int value);

    /**
     * Returns the value of the '<em><b>Resource Needed</b></em>' reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceType#getUsedByTasks <em>Used By Tasks</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Resource Needed</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Resource Needed</em>' reference.
     * @see #setResourceNeeded(ResourceType)
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getTask_ResourceNeeded()
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceType#getUsedByTasks
     * @model opposite="usedByTasks"
     * @generated
     */
    ResourceType getResourceNeeded();

    /**
     * Sets the value of the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.Task#getResourceNeeded <em>Resource Needed</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Resource Needed</em>' reference.
     * @see #getResourceNeeded()
     * @generated
     */
    void setResourceNeeded(ResourceType value);

    /**
     * Returns the value of the '<em><b>Variant</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Variant</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Variant</em>' reference.
     * @see #setVariant(ResourceTypeVariant)
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#getTask_Variant()
     * @model
     * @generated
     */
    ResourceTypeVariant getVariant();

    /**
     * Sets the value of the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.Task#getVariant <em>Variant</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Variant</em>' reference.
     * @see #getVariant()
     * @generated
     */
    void setVariant(ResourceTypeVariant value);

} // Task
