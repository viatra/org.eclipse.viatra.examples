/**
 */
package org.eclipse.viatra.dse.examples.simplifiedbpmn.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.viatra.dse.examples.simplifiedbpmn.BaseElement;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Base Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.BaseElementImpl#getOutFlows <em>Out Flows</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.BaseElementImpl#getInFlows <em>In Flows</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BaseElementImpl extends NamedElementImpl implements BaseElement {
    /**
     * The cached value of the '{@link #getOutFlows() <em>Out Flows</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutFlows()
     * @generated
     * @ordered
     */
    protected EList<SequenceFlow> outFlows;

    /**
     * The cached value of the '{@link #getInFlows() <em>In Flows</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInFlows()
     * @generated
     * @ordered
     */
    protected EList<SequenceFlow> inFlows;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BaseElementImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SimplifiedbpmnPackage.Literals.BASE_ELEMENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<SequenceFlow> getOutFlows() {
        if (outFlows == null) {
            outFlows = new EObjectWithInverseResolvingEList<SequenceFlow>(SequenceFlow.class, this, SimplifiedbpmnPackage.BASE_ELEMENT__OUT_FLOWS, SimplifiedbpmnPackage.SEQUENCE_FLOW__SOURCE);
        }
        return outFlows;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<SequenceFlow> getInFlows() {
        if (inFlows == null) {
            inFlows = new EObjectWithInverseResolvingEList<SequenceFlow>(SequenceFlow.class, this, SimplifiedbpmnPackage.BASE_ELEMENT__IN_FLOWS, SimplifiedbpmnPackage.SEQUENCE_FLOW__TARGET);
        }
        return inFlows;
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
            case SimplifiedbpmnPackage.BASE_ELEMENT__OUT_FLOWS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutFlows()).basicAdd(otherEnd, msgs);
            case SimplifiedbpmnPackage.BASE_ELEMENT__IN_FLOWS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getInFlows()).basicAdd(otherEnd, msgs);
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
            case SimplifiedbpmnPackage.BASE_ELEMENT__OUT_FLOWS:
                return ((InternalEList<?>)getOutFlows()).basicRemove(otherEnd, msgs);
            case SimplifiedbpmnPackage.BASE_ELEMENT__IN_FLOWS:
                return ((InternalEList<?>)getInFlows()).basicRemove(otherEnd, msgs);
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
            case SimplifiedbpmnPackage.BASE_ELEMENT__OUT_FLOWS:
                return getOutFlows();
            case SimplifiedbpmnPackage.BASE_ELEMENT__IN_FLOWS:
                return getInFlows();
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
            case SimplifiedbpmnPackage.BASE_ELEMENT__OUT_FLOWS:
                getOutFlows().clear();
                getOutFlows().addAll((Collection<? extends SequenceFlow>)newValue);
                return;
            case SimplifiedbpmnPackage.BASE_ELEMENT__IN_FLOWS:
                getInFlows().clear();
                getInFlows().addAll((Collection<? extends SequenceFlow>)newValue);
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
            case SimplifiedbpmnPackage.BASE_ELEMENT__OUT_FLOWS:
                getOutFlows().clear();
                return;
            case SimplifiedbpmnPackage.BASE_ELEMENT__IN_FLOWS:
                getInFlows().clear();
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
            case SimplifiedbpmnPackage.BASE_ELEMENT__OUT_FLOWS:
                return outFlows != null && !outFlows.isEmpty();
            case SimplifiedbpmnPackage.BASE_ELEMENT__IN_FLOWS:
                return inFlows != null && !inFlows.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //BaseElementImpl
