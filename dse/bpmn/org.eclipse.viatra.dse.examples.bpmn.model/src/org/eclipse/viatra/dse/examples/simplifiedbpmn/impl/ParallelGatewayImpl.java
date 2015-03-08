/**
 */
package org.eclipse.viatra.dse.examples.simplifiedbpmn.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.viatra.dse.examples.simplifiedbpmn.ParallelGateway;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parallel Gateway</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.ParallelGatewayImpl#isDiverging <em>Diverging</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParallelGatewayImpl extends BaseElementImpl implements ParallelGateway {
    /**
     * The default value of the '{@link #isDiverging() <em>Diverging</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDiverging()
     * @generated
     * @ordered
     */
    protected static final boolean DIVERGING_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isDiverging() <em>Diverging</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDiverging()
     * @generated
     * @ordered
     */
    protected boolean diverging = DIVERGING_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ParallelGatewayImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SimplifiedbpmnPackage.Literals.PARALLEL_GATEWAY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isDiverging() {
        return diverging;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDiverging(boolean newDiverging) {
        boolean oldDiverging = diverging;
        diverging = newDiverging;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimplifiedbpmnPackage.PARALLEL_GATEWAY__DIVERGING, oldDiverging, diverging));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SimplifiedbpmnPackage.PARALLEL_GATEWAY__DIVERGING:
                return isDiverging();
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
            case SimplifiedbpmnPackage.PARALLEL_GATEWAY__DIVERGING:
                setDiverging((Boolean)newValue);
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
            case SimplifiedbpmnPackage.PARALLEL_GATEWAY__DIVERGING:
                setDiverging(DIVERGING_EDEFAULT);
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
            case SimplifiedbpmnPackage.PARALLEL_GATEWAY__DIVERGING:
                return diverging != DIVERGING_EDEFAULT;
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
        result.append(" (diverging: ");
        result.append(diverging);
        result.append(')');
        return result.toString();
    }

} //ParallelGatewayImpl
