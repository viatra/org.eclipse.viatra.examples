/**
 */
package org.eclipse.viatra.examples.petrinet.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.viatra.examples.petrinet.model.PetriNet;
import org.eclipse.viatra.examples.petrinet.model.PetriNetPackage;
import org.eclipse.viatra.examples.petrinet.model.Place;
import org.eclipse.viatra.examples.petrinet.model.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Petri Net</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.viatra.examples.petrinet.model.impl.PetriNetImpl#getPlaces <em>Places</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.petrinet.model.impl.PetriNetImpl#getTransitions <em>Transitions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PetriNetImpl extends MinimalEObjectImpl.Container implements PetriNet {
    /**
     * The cached value of the '{@link #getPlaces() <em>Places</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPlaces()
     * @generated
     * @ordered
     */
    protected EList<Place> places;

    /**
     * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTransitions()
     * @generated
     * @ordered
     */
    protected EList<Transition> transitions;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PetriNetImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PetriNetPackage.Literals.PETRI_NET;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Place> getPlaces() {
        if (places == null) {
            places = new EObjectContainmentWithInverseEList<Place>(Place.class, this, PetriNetPackage.PETRI_NET__PLACES, PetriNetPackage.PLACE__NET);
        }
        return places;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Transition> getTransitions() {
        if (transitions == null) {
            transitions = new EObjectContainmentWithInverseEList<Transition>(Transition.class, this, PetriNetPackage.PETRI_NET__TRANSITIONS, PetriNetPackage.TRANSITION__NET);
        }
        return transitions;
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
            case PetriNetPackage.PETRI_NET__PLACES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getPlaces()).basicAdd(otherEnd, msgs);
            case PetriNetPackage.PETRI_NET__TRANSITIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getTransitions()).basicAdd(otherEnd, msgs);
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
            case PetriNetPackage.PETRI_NET__PLACES:
                return ((InternalEList<?>)getPlaces()).basicRemove(otherEnd, msgs);
            case PetriNetPackage.PETRI_NET__TRANSITIONS:
                return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
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
            case PetriNetPackage.PETRI_NET__PLACES:
                return getPlaces();
            case PetriNetPackage.PETRI_NET__TRANSITIONS:
                return getTransitions();
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
            case PetriNetPackage.PETRI_NET__PLACES:
                getPlaces().clear();
                getPlaces().addAll((Collection<? extends Place>)newValue);
                return;
            case PetriNetPackage.PETRI_NET__TRANSITIONS:
                getTransitions().clear();
                getTransitions().addAll((Collection<? extends Transition>)newValue);
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
            case PetriNetPackage.PETRI_NET__PLACES:
                getPlaces().clear();
                return;
            case PetriNetPackage.PETRI_NET__TRANSITIONS:
                getTransitions().clear();
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
            case PetriNetPackage.PETRI_NET__PLACES:
                return places != null && !places.isEmpty();
            case PetriNetPackage.PETRI_NET__TRANSITIONS:
                return transitions != null && !transitions.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //PetriNetImpl
