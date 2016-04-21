/**
 */
package org.eclipse.viatra.examples.petrinet.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.viatra.examples.petrinet.model.Transition#getNet <em>Net</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.petrinet.model.Transition#getInArcs <em>In Arcs</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.petrinet.model.Transition#getOutArcs <em>Out Arcs</em>}</li>
 * </ul>
 *
 * @see org.eclipse.viatra.examples.petrinet.model.PetriNetPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends NamedElement {
    /**
     * Returns the value of the '<em><b>Net</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.viatra.examples.petrinet.model.PetriNet#getTransitions <em>Transitions</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Net</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Net</em>' container reference.
     * @see #setNet(PetriNet)
     * @see org.eclipse.viatra.examples.petrinet.model.PetriNetPackage#getTransition_Net()
     * @see org.eclipse.viatra.examples.petrinet.model.PetriNet#getTransitions
     * @model opposite="transitions" required="true" transient="false"
     * @generated
     */
    PetriNet getNet();

    /**
     * Sets the value of the '{@link org.eclipse.viatra.examples.petrinet.model.Transition#getNet <em>Net</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Net</em>' container reference.
     * @see #getNet()
     * @generated
     */
    void setNet(PetriNet value);

    /**
     * Returns the value of the '<em><b>In Arcs</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.viatra.examples.petrinet.model.PTArc}.
     * It is bidirectional and its opposite is '{@link org.eclipse.viatra.examples.petrinet.model.PTArc#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>In Arcs</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>In Arcs</em>' reference list.
     * @see org.eclipse.viatra.examples.petrinet.model.PetriNetPackage#getTransition_InArcs()
     * @see org.eclipse.viatra.examples.petrinet.model.PTArc#getTarget
     * @model opposite="target"
     * @generated
     */
    EList<PTArc> getInArcs();

    /**
     * Returns the value of the '<em><b>Out Arcs</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.viatra.examples.petrinet.model.TPArc}.
     * It is bidirectional and its opposite is '{@link org.eclipse.viatra.examples.petrinet.model.TPArc#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Out Arcs</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Out Arcs</em>' containment reference list.
     * @see org.eclipse.viatra.examples.petrinet.model.PetriNetPackage#getTransition_OutArcs()
     * @see org.eclipse.viatra.examples.petrinet.model.TPArc#getSource
     * @model opposite="source" containment="true"
     * @generated
     */
    EList<TPArc> getOutArcs();

} // Transition
