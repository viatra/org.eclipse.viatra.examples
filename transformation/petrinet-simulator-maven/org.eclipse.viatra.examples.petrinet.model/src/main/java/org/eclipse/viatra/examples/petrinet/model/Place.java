/**
 */
package org.eclipse.viatra.examples.petrinet.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Place</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.viatra.examples.petrinet.model.Place#getNet <em>Net</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.petrinet.model.Place#getOutArcs <em>Out Arcs</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.petrinet.model.Place#getInArcs <em>In Arcs</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.petrinet.model.Place#getTokens <em>Tokens</em>}</li>
 * </ul>
 *
 * @see org.eclipse.viatra.examples.petrinet.model.PetriNetPackage#getPlace()
 * @model
 * @generated
 */
public interface Place extends NamedElement {
    /**
     * Returns the value of the '<em><b>Net</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.viatra.examples.petrinet.model.PetriNet#getPlaces <em>Places</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Net</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Net</em>' container reference.
     * @see #setNet(PetriNet)
     * @see org.eclipse.viatra.examples.petrinet.model.PetriNetPackage#getPlace_Net()
     * @see org.eclipse.viatra.examples.petrinet.model.PetriNet#getPlaces
     * @model opposite="places" required="true" transient="false"
     * @generated
     */
    PetriNet getNet();

    /**
     * Sets the value of the '{@link org.eclipse.viatra.examples.petrinet.model.Place#getNet <em>Net</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Net</em>' container reference.
     * @see #getNet()
     * @generated
     */
    void setNet(PetriNet value);

    /**
     * Returns the value of the '<em><b>Out Arcs</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.viatra.examples.petrinet.model.PTArc}.
     * It is bidirectional and its opposite is '{@link org.eclipse.viatra.examples.petrinet.model.PTArc#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Out Arcs</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Out Arcs</em>' containment reference list.
     * @see org.eclipse.viatra.examples.petrinet.model.PetriNetPackage#getPlace_OutArcs()
     * @see org.eclipse.viatra.examples.petrinet.model.PTArc#getSource
     * @model opposite="source" containment="true"
     * @generated
     */
    EList<PTArc> getOutArcs();

    /**
     * Returns the value of the '<em><b>In Arcs</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.viatra.examples.petrinet.model.TPArc}.
     * It is bidirectional and its opposite is '{@link org.eclipse.viatra.examples.petrinet.model.TPArc#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>In Arcs</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>In Arcs</em>' reference list.
     * @see org.eclipse.viatra.examples.petrinet.model.PetriNetPackage#getPlace_InArcs()
     * @see org.eclipse.viatra.examples.petrinet.model.TPArc#getTarget
     * @model opposite="target"
     * @generated
     */
    EList<TPArc> getInArcs();

    /**
     * Returns the value of the '<em><b>Tokens</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.viatra.examples.petrinet.model.Token}.
     * It is bidirectional and its opposite is '{@link org.eclipse.viatra.examples.petrinet.model.Token#getPlace <em>Place</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tokens</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Tokens</em>' containment reference list.
     * @see org.eclipse.viatra.examples.petrinet.model.PetriNetPackage#getPlace_Tokens()
     * @see org.eclipse.viatra.examples.petrinet.model.Token#getPlace
     * @model opposite="place" containment="true"
     * @generated
     */
    EList<Token> getTokens();

} // Place
