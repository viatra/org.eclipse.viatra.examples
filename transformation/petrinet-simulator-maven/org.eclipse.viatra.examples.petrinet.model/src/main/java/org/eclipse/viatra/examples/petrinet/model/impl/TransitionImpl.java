/**
 */
package org.eclipse.viatra.examples.petrinet.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.viatra.examples.petrinet.model.PTArc;
import org.eclipse.viatra.examples.petrinet.model.PetriNet;
import org.eclipse.viatra.examples.petrinet.model.PetriNetPackage;
import org.eclipse.viatra.examples.petrinet.model.TPArc;
import org.eclipse.viatra.examples.petrinet.model.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.viatra.examples.petrinet.model.impl.TransitionImpl#getNet <em>Net</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.petrinet.model.impl.TransitionImpl#getInArcs <em>In Arcs</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.petrinet.model.impl.TransitionImpl#getOutArcs <em>Out Arcs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionImpl extends NamedElementImpl implements Transition {
    /**
     * The cached value of the '{@link #getInArcs() <em>In Arcs</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInArcs()
     * @generated
     * @ordered
     */
    protected EList<PTArc> inArcs;

    /**
     * The cached value of the '{@link #getOutArcs() <em>Out Arcs</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutArcs()
     * @generated
     * @ordered
     */
    protected EList<TPArc> outArcs;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TransitionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PetriNetPackage.Literals.TRANSITION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PetriNet getNet() {
        if (eContainerFeatureID() != PetriNetPackage.TRANSITION__NET) return null;
        return (PetriNet)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetNet(PetriNet newNet, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newNet, PetriNetPackage.TRANSITION__NET, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setNet(PetriNet newNet) {
        if (newNet != eInternalContainer() || (eContainerFeatureID() != PetriNetPackage.TRANSITION__NET && newNet != null)) {
            if (EcoreUtil.isAncestor(this, newNet))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newNet != null)
                msgs = ((InternalEObject)newNet).eInverseAdd(this, PetriNetPackage.PETRI_NET__TRANSITIONS, PetriNet.class, msgs);
            msgs = basicSetNet(newNet, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PetriNetPackage.TRANSITION__NET, newNet, newNet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PTArc> getInArcs() {
        if (inArcs == null) {
            inArcs = new EObjectWithInverseResolvingEList<PTArc>(PTArc.class, this, PetriNetPackage.TRANSITION__IN_ARCS, PetriNetPackage.PT_ARC__TARGET);
        }
        return inArcs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TPArc> getOutArcs() {
        if (outArcs == null) {
            outArcs = new EObjectContainmentWithInverseEList<TPArc>(TPArc.class, this, PetriNetPackage.TRANSITION__OUT_ARCS, PetriNetPackage.TP_ARC__SOURCE);
        }
        return outArcs;
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
            case PetriNetPackage.TRANSITION__NET:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetNet((PetriNet)otherEnd, msgs);
            case PetriNetPackage.TRANSITION__IN_ARCS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getInArcs()).basicAdd(otherEnd, msgs);
            case PetriNetPackage.TRANSITION__OUT_ARCS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutArcs()).basicAdd(otherEnd, msgs);
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
            case PetriNetPackage.TRANSITION__NET:
                return basicSetNet(null, msgs);
            case PetriNetPackage.TRANSITION__IN_ARCS:
                return ((InternalEList<?>)getInArcs()).basicRemove(otherEnd, msgs);
            case PetriNetPackage.TRANSITION__OUT_ARCS:
                return ((InternalEList<?>)getOutArcs()).basicRemove(otherEnd, msgs);
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
            case PetriNetPackage.TRANSITION__NET:
                return eInternalContainer().eInverseRemove(this, PetriNetPackage.PETRI_NET__TRANSITIONS, PetriNet.class, msgs);
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
            case PetriNetPackage.TRANSITION__NET:
                return getNet();
            case PetriNetPackage.TRANSITION__IN_ARCS:
                return getInArcs();
            case PetriNetPackage.TRANSITION__OUT_ARCS:
                return getOutArcs();
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
            case PetriNetPackage.TRANSITION__NET:
                setNet((PetriNet)newValue);
                return;
            case PetriNetPackage.TRANSITION__IN_ARCS:
                getInArcs().clear();
                getInArcs().addAll((Collection<? extends PTArc>)newValue);
                return;
            case PetriNetPackage.TRANSITION__OUT_ARCS:
                getOutArcs().clear();
                getOutArcs().addAll((Collection<? extends TPArc>)newValue);
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
            case PetriNetPackage.TRANSITION__NET:
                setNet((PetriNet)null);
                return;
            case PetriNetPackage.TRANSITION__IN_ARCS:
                getInArcs().clear();
                return;
            case PetriNetPackage.TRANSITION__OUT_ARCS:
                getOutArcs().clear();
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
            case PetriNetPackage.TRANSITION__NET:
                return getNet() != null;
            case PetriNetPackage.TRANSITION__IN_ARCS:
                return inArcs != null && !inArcs.isEmpty();
            case PetriNetPackage.TRANSITION__OUT_ARCS:
                return outArcs != null && !outArcs.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //TransitionImpl
