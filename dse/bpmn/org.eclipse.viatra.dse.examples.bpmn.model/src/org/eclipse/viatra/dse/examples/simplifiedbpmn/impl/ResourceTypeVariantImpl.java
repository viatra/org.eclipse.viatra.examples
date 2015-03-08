/**
 */
package org.eclipse.viatra.dse.examples.simplifiedbpmn.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceType;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Type Variant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.ResourceTypeVariantImpl#getEfficiency <em>Efficiency</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.ResourceTypeVariantImpl#getInstances <em>Instances</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.ResourceTypeVariantImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceTypeVariantImpl extends NamedElementImpl implements ResourceTypeVariant {
    /**
     * The default value of the '{@link #getEfficiency() <em>Efficiency</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEfficiency()
     * @generated
     * @ordered
     */
    protected static final double EFFICIENCY_EDEFAULT = 1.0;

    /**
     * The cached value of the '{@link #getEfficiency() <em>Efficiency</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEfficiency()
     * @generated
     * @ordered
     */
    protected double efficiency = EFFICIENCY_EDEFAULT;

    /**
     * The cached value of the '{@link #getInstances() <em>Instances</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInstances()
     * @generated
     * @ordered
     */
    protected EList<ResourceInstance> instances;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ResourceTypeVariantImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SimplifiedbpmnPackage.Literals.RESOURCE_TYPE_VARIANT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public double getEfficiency() {
        return efficiency;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEfficiency(double newEfficiency) {
        double oldEfficiency = efficiency;
        efficiency = newEfficiency;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT__EFFICIENCY, oldEfficiency, efficiency));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ResourceInstance> getInstances() {
        if (instances == null) {
            instances = new EObjectContainmentWithInverseEList<ResourceInstance>(ResourceInstance.class, this, SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT__INSTANCES, SimplifiedbpmnPackage.RESOURCE_INSTANCE__RESOURCE_TYPE_VARIANT);
        }
        return instances;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceType getType() {
        if (eContainerFeatureID() != SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT__TYPE) return null;
        return (ResourceType)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetType(ResourceType newType, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newType, SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT__TYPE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setType(ResourceType newType) {
        if (newType != eInternalContainer() || (eContainerFeatureID() != SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT__TYPE && newType != null)) {
            if (EcoreUtil.isAncestor(this, newType))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newType != null)
                msgs = ((InternalEObject)newType).eInverseAdd(this, SimplifiedbpmnPackage.RESOURCE_TYPE__VARIANTS, ResourceType.class, msgs);
            msgs = basicSetType(newType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT__TYPE, newType, newType));
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
            case SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT__INSTANCES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getInstances()).basicAdd(otherEnd, msgs);
            case SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT__TYPE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetType((ResourceType)otherEnd, msgs);
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
            case SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT__INSTANCES:
                return ((InternalEList<?>)getInstances()).basicRemove(otherEnd, msgs);
            case SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT__TYPE:
                return basicSetType(null, msgs);
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
            case SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT__TYPE:
                return eInternalContainer().eInverseRemove(this, SimplifiedbpmnPackage.RESOURCE_TYPE__VARIANTS, ResourceType.class, msgs);
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
            case SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT__EFFICIENCY:
                return getEfficiency();
            case SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT__INSTANCES:
                return getInstances();
            case SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT__TYPE:
                return getType();
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
            case SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT__EFFICIENCY:
                setEfficiency((Double)newValue);
                return;
            case SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT__INSTANCES:
                getInstances().clear();
                getInstances().addAll((Collection<? extends ResourceInstance>)newValue);
                return;
            case SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT__TYPE:
                setType((ResourceType)newValue);
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
            case SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT__EFFICIENCY:
                setEfficiency(EFFICIENCY_EDEFAULT);
                return;
            case SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT__INSTANCES:
                getInstances().clear();
                return;
            case SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT__TYPE:
                setType((ResourceType)null);
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
            case SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT__EFFICIENCY:
                return efficiency != EFFICIENCY_EDEFAULT;
            case SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT__INSTANCES:
                return instances != null && !instances.isEmpty();
            case SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT__TYPE:
                return getType() != null;
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
        result.append(" (efficiency: ");
        result.append(efficiency);
        result.append(')');
        return result.toString();
    }

} //ResourceTypeVariantImpl
