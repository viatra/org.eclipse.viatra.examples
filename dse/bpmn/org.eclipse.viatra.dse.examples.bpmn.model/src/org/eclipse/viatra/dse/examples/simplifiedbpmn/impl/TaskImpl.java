/**
 */
package org.eclipse.viatra.dse.examples.simplifiedbpmn.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceType;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.Task;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.TaskImpl#getExecutionTime <em>Execution Time</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.TaskImpl#getResourceNeeded <em>Resource Needed</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.TaskImpl#getVariant <em>Variant</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskImpl extends BaseElementImpl implements Task {
    /**
     * The default value of the '{@link #getExecutionTime() <em>Execution Time</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExecutionTime()
     * @generated
     * @ordered
     */
    protected static final int EXECUTION_TIME_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getExecutionTime() <em>Execution Time</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExecutionTime()
     * @generated
     * @ordered
     */
    protected int executionTime = EXECUTION_TIME_EDEFAULT;

    /**
     * The cached value of the '{@link #getResourceNeeded() <em>Resource Needed</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getResourceNeeded()
     * @generated
     * @ordered
     */
    protected ResourceType resourceNeeded;

    /**
     * The cached value of the '{@link #getVariant() <em>Variant</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVariant()
     * @generated
     * @ordered
     */
    protected ResourceTypeVariant variant;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TaskImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SimplifiedbpmnPackage.Literals.TASK;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getExecutionTime() {
        return executionTime;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExecutionTime(int newExecutionTime) {
        int oldExecutionTime = executionTime;
        executionTime = newExecutionTime;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimplifiedbpmnPackage.TASK__EXECUTION_TIME, oldExecutionTime, executionTime));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceType getResourceNeeded() {
        if (resourceNeeded != null && resourceNeeded.eIsProxy()) {
            InternalEObject oldResourceNeeded = (InternalEObject)resourceNeeded;
            resourceNeeded = (ResourceType)eResolveProxy(oldResourceNeeded);
            if (resourceNeeded != oldResourceNeeded) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimplifiedbpmnPackage.TASK__RESOURCE_NEEDED, oldResourceNeeded, resourceNeeded));
            }
        }
        return resourceNeeded;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceType basicGetResourceNeeded() {
        return resourceNeeded;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetResourceNeeded(ResourceType newResourceNeeded, NotificationChain msgs) {
        ResourceType oldResourceNeeded = resourceNeeded;
        resourceNeeded = newResourceNeeded;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimplifiedbpmnPackage.TASK__RESOURCE_NEEDED, oldResourceNeeded, newResourceNeeded);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setResourceNeeded(ResourceType newResourceNeeded) {
        if (newResourceNeeded != resourceNeeded) {
            NotificationChain msgs = null;
            if (resourceNeeded != null)
                msgs = ((InternalEObject)resourceNeeded).eInverseRemove(this, SimplifiedbpmnPackage.RESOURCE_TYPE__USED_BY_TASKS, ResourceType.class, msgs);
            if (newResourceNeeded != null)
                msgs = ((InternalEObject)newResourceNeeded).eInverseAdd(this, SimplifiedbpmnPackage.RESOURCE_TYPE__USED_BY_TASKS, ResourceType.class, msgs);
            msgs = basicSetResourceNeeded(newResourceNeeded, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimplifiedbpmnPackage.TASK__RESOURCE_NEEDED, newResourceNeeded, newResourceNeeded));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceTypeVariant getVariant() {
        if (variant != null && variant.eIsProxy()) {
            InternalEObject oldVariant = (InternalEObject)variant;
            variant = (ResourceTypeVariant)eResolveProxy(oldVariant);
            if (variant != oldVariant) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimplifiedbpmnPackage.TASK__VARIANT, oldVariant, variant));
            }
        }
        return variant;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceTypeVariant basicGetVariant() {
        return variant;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setVariant(ResourceTypeVariant newVariant) {
        ResourceTypeVariant oldVariant = variant;
        variant = newVariant;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimplifiedbpmnPackage.TASK__VARIANT, oldVariant, variant));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SimplifiedbpmnPackage.TASK__RESOURCE_NEEDED:
                if (resourceNeeded != null)
                    msgs = ((InternalEObject)resourceNeeded).eInverseRemove(this, SimplifiedbpmnPackage.RESOURCE_TYPE__USED_BY_TASKS, ResourceType.class, msgs);
                return basicSetResourceNeeded((ResourceType)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SimplifiedbpmnPackage.TASK__RESOURCE_NEEDED:
                return basicSetResourceNeeded(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SimplifiedbpmnPackage.TASK__EXECUTION_TIME:
                return getExecutionTime();
            case SimplifiedbpmnPackage.TASK__RESOURCE_NEEDED:
                if (resolve) return getResourceNeeded();
                return basicGetResourceNeeded();
            case SimplifiedbpmnPackage.TASK__VARIANT:
                if (resolve) return getVariant();
                return basicGetVariant();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case SimplifiedbpmnPackage.TASK__EXECUTION_TIME:
                setExecutionTime((Integer)newValue);
                return;
            case SimplifiedbpmnPackage.TASK__RESOURCE_NEEDED:
                setResourceNeeded((ResourceType)newValue);
                return;
            case SimplifiedbpmnPackage.TASK__VARIANT:
                setVariant((ResourceTypeVariant)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case SimplifiedbpmnPackage.TASK__EXECUTION_TIME:
                setExecutionTime(EXECUTION_TIME_EDEFAULT);
                return;
            case SimplifiedbpmnPackage.TASK__RESOURCE_NEEDED:
                setResourceNeeded((ResourceType)null);
                return;
            case SimplifiedbpmnPackage.TASK__VARIANT:
                setVariant((ResourceTypeVariant)null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case SimplifiedbpmnPackage.TASK__EXECUTION_TIME:
                return executionTime != EXECUTION_TIME_EDEFAULT;
            case SimplifiedbpmnPackage.TASK__RESOURCE_NEEDED:
                return resourceNeeded != null;
            case SimplifiedbpmnPackage.TASK__VARIANT:
                return variant != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (executionTime: ");
        result.append(executionTime);
        result.append(')');
        return result.toString();
    }

} //TaskImpl
