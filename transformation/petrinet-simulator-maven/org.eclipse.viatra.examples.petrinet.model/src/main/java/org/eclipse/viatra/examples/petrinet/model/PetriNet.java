/**
 */
package org.eclipse.viatra.examples.petrinet.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Petri Net</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.viatra.examples.petrinet.model.PetriNet#getPlaces <em>Places</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.petrinet.model.PetriNet#getTransitions <em>Transitions</em>}</li>
 * </ul>
 *
 * @see org.eclipse.viatra.examples.petrinet.model.PetriNetPackage#getPetriNet()
 * @model
 * @generated
 */
public interface PetriNet extends EObject {
    /**
     * Returns the value of the '<em><b>Places</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.viatra.examples.petrinet.model.Place}.
     * It is bidirectional and its opposite is '{@link org.eclipse.viatra.examples.petrinet.model.Place#getNet <em>Net</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Places</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Places</em>' containment reference list.
     * @see org.eclipse.viatra.examples.petrinet.model.PetriNetPackage#getPetriNet_Places()
     * @see org.eclipse.viatra.examples.petrinet.model.Place#getNet
     * @model opposite="net" containment="true"
     * @generated
     */
    EList<Place> getPlaces();

    /**
     * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.viatra.examples.petrinet.model.Transition}.
     * It is bidirectional and its opposite is '{@link org.eclipse.viatra.examples.petrinet.model.Transition#getNet <em>Net</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transitions</em>' containment reference list.
     * @see org.eclipse.viatra.examples.petrinet.model.PetriNetPackage#getPetriNet_Transitions()
     * @see org.eclipse.viatra.examples.petrinet.model.Transition#getNet
     * @model opposite="net" containment="true"
     * @generated
     */
    EList<Transition> getTransitions();

} // PetriNet
