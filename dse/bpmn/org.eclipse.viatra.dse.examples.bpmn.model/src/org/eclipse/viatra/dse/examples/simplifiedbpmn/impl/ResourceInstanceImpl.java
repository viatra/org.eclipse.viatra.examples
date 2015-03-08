/**
 */
package org.eclipse.viatra.dse.examples.simplifiedbpmn.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.ResourceInstanceImpl#getResourceTypeVariant <em>Resource Type Variant</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceInstanceImpl extends MinimalEObjectImpl.Container implements ResourceInstance {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ResourceInstanceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SimplifiedbpmnPackage.Literals.RESOURCE_INSTANCE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceTypeVariant getResourceTypeVariant() {
        if (eContainerFeatureID() != SimplifiedbpmnPackage.RESOURCE_INSTANCE__RESOURCE_TYPE_VARIANT) return null;
        return (ResourceTypeVariant)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetResourceTypeVariant(ResourceTypeVariant newResourceTypeVariant, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newResourceTypeVariant, SimplifiedbpmnPackage.RESOURCE_INSTANCE__RESOURCE_TYPE_VARIANT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setResourceTypeVariant(ResourceTypeVariant newResourceTypeVariant) {
        if (newResourceTypeVariant != eInternalContainer() || (eContainerFeatureID() != SimplifiedbpmnPackage.RESOURCE_INSTANCE__RESOURCE_TYPE_VARIANT && newResourceTypeVariant != null)) {
            if (EcoreUtil.isAncestor(this, newResourceTypeVariant))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newResourceTypeVariant != null)
                msgs = ((InternalEObject)newResourceTypeVariant).eInverseAdd(this, SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT__INSTANCES, ResourceTypeVariant.class, msgs);
            msgs = basicSetResourceTypeVariant(newResourceTypeVariant, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimplifiedbpmnPackage.RESOURCE_INSTANCE__RESOURCE_TYPE_VARIANT, newResourceTypeVariant, newResourceTypeVariant));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SimplifiedbpmnPackage.RESOURCE_INSTANCE__RESOURCE_TYPE_VARIANT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetResourceTypeVariant((ResourceTypeVariant)otherEnd, msgs);
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
            case SimplifiedbpmnPackage.RESOURCE_INSTANCE__RESOURCE_TYPE_VARIANT:
                return basicSetResourceTypeVariant(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case SimplifiedbpmnPackage.RESOURCE_INSTANCE__RESOURCE_TYPE_VARIANT:
                return eInternalContainer().eInverseRemove(this, SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT__INSTANCES, ResourceTypeVariant.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SimplifiedbpmnPackage.RESOURCE_INSTANCE__RESOURCE_TYPE_VARIANT:
                return getResourceTypeVariant();
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
            case SimplifiedbpmnPackage.RESOURCE_INSTANCE__RESOURCE_TYPE_VARIANT:
                setResourceTypeVariant((ResourceTypeVariant)newValue);
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
            case SimplifiedbpmnPackage.RESOURCE_INSTANCE__RESOURCE_TYPE_VARIANT:
                setResourceTypeVariant((ResourceTypeVariant)null);
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
            case SimplifiedbpmnPackage.RESOURCE_INSTANCE__RESOURCE_TYPE_VARIANT:
                return getResourceTypeVariant() != null;
        }
        return super.eIsSet(featureID);
    }

} //ResourceInstanceImpl
