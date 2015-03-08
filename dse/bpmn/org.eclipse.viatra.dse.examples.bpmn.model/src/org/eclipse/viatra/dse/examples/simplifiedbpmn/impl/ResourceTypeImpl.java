/**
 */
package org.eclipse.viatra.dse.examples.simplifiedbpmn.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceType;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.Task;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.ResourceTypeImpl#getUsedByTasks <em>Used By Tasks</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.ResourceTypeImpl#getVariants <em>Variants</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceTypeImpl extends NamedElementImpl implements ResourceType {
    /**
     * The cached value of the '{@link #getUsedByTasks() <em>Used By Tasks</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUsedByTasks()
     * @generated
     * @ordered
     */
    protected EList<Task> usedByTasks;

    /**
     * The cached value of the '{@link #getVariants() <em>Variants</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVariants()
     * @generated
     * @ordered
     */
    protected EList<ResourceTypeVariant> variants;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ResourceTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SimplifiedbpmnPackage.Literals.RESOURCE_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Task> getUsedByTasks() {
        if (usedByTasks == null) {
            usedByTasks = new EObjectWithInverseResolvingEList<Task>(Task.class, this, SimplifiedbpmnPackage.RESOURCE_TYPE__USED_BY_TASKS, SimplifiedbpmnPackage.TASK__RESOURCE_NEEDED);
        }
        return usedByTasks;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ResourceTypeVariant> getVariants() {
        if (variants == null) {
            variants = new EObjectContainmentWithInverseEList<ResourceTypeVariant>(ResourceTypeVariant.class, this, SimplifiedbpmnPackage.RESOURCE_TYPE__VARIANTS, SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT__TYPE);
        }
        return variants;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SimplifiedbpmnPackage.RESOURCE_TYPE__USED_BY_TASKS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getUsedByTasks()).basicAdd(otherEnd, msgs);
            case SimplifiedbpmnPackage.RESOURCE_TYPE__VARIANTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getVariants()).basicAdd(otherEnd, msgs);
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
            case SimplifiedbpmnPackage.RESOURCE_TYPE__USED_BY_TASKS:
                return ((InternalEList<?>)getUsedByTasks()).basicRemove(otherEnd, msgs);
            case SimplifiedbpmnPackage.RESOURCE_TYPE__VARIANTS:
                return ((InternalEList<?>)getVariants()).basicRemove(otherEnd, msgs);
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
            case SimplifiedbpmnPackage.RESOURCE_TYPE__USED_BY_TASKS:
                return getUsedByTasks();
            case SimplifiedbpmnPackage.RESOURCE_TYPE__VARIANTS:
                return getVariants();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case SimplifiedbpmnPackage.RESOURCE_TYPE__USED_BY_TASKS:
                getUsedByTasks().clear();
                getUsedByTasks().addAll((Collection<? extends Task>)newValue);
                return;
            case SimplifiedbpmnPackage.RESOURCE_TYPE__VARIANTS:
                getVariants().clear();
                getVariants().addAll((Collection<? extends ResourceTypeVariant>)newValue);
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
            case SimplifiedbpmnPackage.RESOURCE_TYPE__USED_BY_TASKS:
                getUsedByTasks().clear();
                return;
            case SimplifiedbpmnPackage.RESOURCE_TYPE__VARIANTS:
                getVariants().clear();
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
            case SimplifiedbpmnPackage.RESOURCE_TYPE__USED_BY_TASKS:
                return usedByTasks != null && !usedByTasks.isEmpty();
            case SimplifiedbpmnPackage.RESOURCE_TYPE__VARIANTS:
                return variants != null && !variants.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //ResourceTypeImpl
