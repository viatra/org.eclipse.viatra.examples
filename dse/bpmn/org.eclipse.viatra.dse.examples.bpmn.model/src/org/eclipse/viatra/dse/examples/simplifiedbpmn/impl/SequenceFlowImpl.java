/**
 */
package org.eclipse.viatra.dse.examples.simplifiedbpmn.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.viatra.dse.examples.simplifiedbpmn.BaseElement;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SequenceFlowImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SequenceFlowImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SequenceFlowImpl#getPropability <em>Propability</em>}</li>
 *   <li>{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SequenceFlowImpl#isIsDataFlow <em>Is Data Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequenceFlowImpl extends MinimalEObjectImpl.Container implements SequenceFlow {
    /**
     * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSource()
     * @generated
     * @ordered
     */
    protected BaseElement source;

    /**
     * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTarget()
     * @generated
     * @ordered
     */
    protected BaseElement target;

    /**
     * The default value of the '{@link #getPropability() <em>Propability</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPropability()
     * @generated
     * @ordered
     */
    protected static final int PROPABILITY_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getPropability() <em>Propability</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPropability()
     * @generated
     * @ordered
     */
    protected int propability = PROPABILITY_EDEFAULT;

    /**
     * The default value of the '{@link #isIsDataFlow() <em>Is Data Flow</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsDataFlow()
     * @generated
     * @ordered
     */
    protected static final boolean IS_DATA_FLOW_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIsDataFlow() <em>Is Data Flow</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsDataFlow()
     * @generated
     * @ordered
     */
    protected boolean isDataFlow = IS_DATA_FLOW_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SequenceFlowImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SimplifiedbpmnPackage.Literals.SEQUENCE_FLOW;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BaseElement getSource() {
        if (source != null && source.eIsProxy()) {
            InternalEObject oldSource = (InternalEObject)source;
            source = (BaseElement)eResolveProxy(oldSource);
            if (source != oldSource) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimplifiedbpmnPackage.SEQUENCE_FLOW__SOURCE, oldSource, source));
            }
        }
        return source;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BaseElement basicGetSource() {
        return source;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSource(BaseElement newSource, NotificationChain msgs) {
        BaseElement oldSource = source;
        source = newSource;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimplifiedbpmnPackage.SEQUENCE_FLOW__SOURCE, oldSource, newSource);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSource(BaseElement newSource) {
        if (newSource != source) {
            NotificationChain msgs = null;
            if (source != null)
                msgs = ((InternalEObject)source).eInverseRemove(this, SimplifiedbpmnPackage.BASE_ELEMENT__OUT_FLOWS, BaseElement.class, msgs);
            if (newSource != null)
                msgs = ((InternalEObject)newSource).eInverseAdd(this, SimplifiedbpmnPackage.BASE_ELEMENT__OUT_FLOWS, BaseElement.class, msgs);
            msgs = basicSetSource(newSource, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimplifiedbpmnPackage.SEQUENCE_FLOW__SOURCE, newSource, newSource));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BaseElement getTarget() {
        if (target != null && target.eIsProxy()) {
            InternalEObject oldTarget = (InternalEObject)target;
            target = (BaseElement)eResolveProxy(oldTarget);
            if (target != oldTarget) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimplifiedbpmnPackage.SEQUENCE_FLOW__TARGET, oldTarget, target));
            }
        }
        return target;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BaseElement basicGetTarget() {
        return target;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTarget(BaseElement newTarget, NotificationChain msgs) {
        BaseElement oldTarget = target;
        target = newTarget;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimplifiedbpmnPackage.SEQUENCE_FLOW__TARGET, oldTarget, newTarget);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTarget(BaseElement newTarget) {
        if (newTarget != target) {
            NotificationChain msgs = null;
            if (target != null)
                msgs = ((InternalEObject)target).eInverseRemove(this, SimplifiedbpmnPackage.BASE_ELEMENT__IN_FLOWS, BaseElement.class, msgs);
            if (newTarget != null)
                msgs = ((InternalEObject)newTarget).eInverseAdd(this, SimplifiedbpmnPackage.BASE_ELEMENT__IN_FLOWS, BaseElement.class, msgs);
            msgs = basicSetTarget(newTarget, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimplifiedbpmnPackage.SEQUENCE_FLOW__TARGET, newTarget, newTarget));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getPropability() {
        return propability;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPropability(int newPropability) {
        int oldPropability = propability;
        propability = newPropability;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimplifiedbpmnPackage.SEQUENCE_FLOW__PROPABILITY, oldPropability, propability));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isIsDataFlow() {
        return isDataFlow;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIsDataFlow(boolean newIsDataFlow) {
        boolean oldIsDataFlow = isDataFlow;
        isDataFlow = newIsDataFlow;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimplifiedbpmnPackage.SEQUENCE_FLOW__IS_DATA_FLOW, oldIsDataFlow, isDataFlow));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SimplifiedbpmnPackage.SEQUENCE_FLOW__SOURCE:
                if (source != null)
                    msgs = ((InternalEObject)source).eInverseRemove(this, SimplifiedbpmnPackage.BASE_ELEMENT__OUT_FLOWS, BaseElement.class, msgs);
                return basicSetSource((BaseElement)otherEnd, msgs);
            case SimplifiedbpmnPackage.SEQUENCE_FLOW__TARGET:
                if (target != null)
                    msgs = ((InternalEObject)target).eInverseRemove(this, SimplifiedbpmnPackage.BASE_ELEMENT__IN_FLOWS, BaseElement.class, msgs);
                return basicSetTarget((BaseElement)otherEnd, msgs);
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
            case SimplifiedbpmnPackage.SEQUENCE_FLOW__SOURCE:
                return basicSetSource(null, msgs);
            case SimplifiedbpmnPackage.SEQUENCE_FLOW__TARGET:
                return basicSetTarget(null, msgs);
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
            case SimplifiedbpmnPackage.SEQUENCE_FLOW__SOURCE:
                if (resolve) return getSource();
                return basicGetSource();
            case SimplifiedbpmnPackage.SEQUENCE_FLOW__TARGET:
                if (resolve) return getTarget();
                return basicGetTarget();
            case SimplifiedbpmnPackage.SEQUENCE_FLOW__PROPABILITY:
                return getPropability();
            case SimplifiedbpmnPackage.SEQUENCE_FLOW__IS_DATA_FLOW:
                return isIsDataFlow();
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
            case SimplifiedbpmnPackage.SEQUENCE_FLOW__SOURCE:
                setSource((BaseElement)newValue);
                return;
            case SimplifiedbpmnPackage.SEQUENCE_FLOW__TARGET:
                setTarget((BaseElement)newValue);
                return;
            case SimplifiedbpmnPackage.SEQUENCE_FLOW__PROPABILITY:
                setPropability((Integer)newValue);
                return;
            case SimplifiedbpmnPackage.SEQUENCE_FLOW__IS_DATA_FLOW:
                setIsDataFlow((Boolean)newValue);
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
            case SimplifiedbpmnPackage.SEQUENCE_FLOW__SOURCE:
                setSource((BaseElement)null);
                return;
            case SimplifiedbpmnPackage.SEQUENCE_FLOW__TARGET:
                setTarget((BaseElement)null);
                return;
            case SimplifiedbpmnPackage.SEQUENCE_FLOW__PROPABILITY:
                setPropability(PROPABILITY_EDEFAULT);
                return;
            case SimplifiedbpmnPackage.SEQUENCE_FLOW__IS_DATA_FLOW:
                setIsDataFlow(IS_DATA_FLOW_EDEFAULT);
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
            case SimplifiedbpmnPackage.SEQUENCE_FLOW__SOURCE:
                return source != null;
            case SimplifiedbpmnPackage.SEQUENCE_FLOW__TARGET:
                return target != null;
            case SimplifiedbpmnPackage.SEQUENCE_FLOW__PROPABILITY:
                return propability != PROPABILITY_EDEFAULT;
            case SimplifiedbpmnPackage.SEQUENCE_FLOW__IS_DATA_FLOW:
                return isDataFlow != IS_DATA_FLOW_EDEFAULT;
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
        result.append(" (propability: ");
        result.append(propability);
        result.append(", isDataFlow: ");
        result.append(isDataFlow);
        result.append(')');
        return result.toString();
    }

} //SequenceFlowImpl
