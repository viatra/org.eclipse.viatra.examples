/**
 */
package org.eclipse.viatra.examples.petrinet.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TP Arc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.viatra.examples.petrinet.model.TPArc#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.petrinet.model.TPArc#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.eclipse.viatra.examples.petrinet.model.PetriNetPackage#getTPArc()
 * @model
 * @generated
 */
public interface TPArc extends Arc {
    /**
     * Returns the value of the '<em><b>Source</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.viatra.examples.petrinet.model.Transition#getOutArcs <em>Out Arcs</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source</em>' container reference.
     * @see #setSource(Transition)
     * @see org.eclipse.viatra.examples.petrinet.model.PetriNetPackage#getTPArc_Source()
     * @see org.eclipse.viatra.examples.petrinet.model.Transition#getOutArcs
     * @model opposite="outArcs" required="true" transient="false"
     * @generated
     */
    Transition getSource();

    /**
     * Sets the value of the '{@link org.eclipse.viatra.examples.petrinet.model.TPArc#getSource <em>Source</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source</em>' container reference.
     * @see #getSource()
     * @generated
     */
    void setSource(Transition value);

    /**
     * Returns the value of the '<em><b>Target</b></em>' reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.viatra.examples.petrinet.model.Place#getInArcs <em>In Arcs</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target</em>' reference.
     * @see #setTarget(Place)
     * @see org.eclipse.viatra.examples.petrinet.model.PetriNetPackage#getTPArc_Target()
     * @see org.eclipse.viatra.examples.petrinet.model.Place#getInArcs
     * @model opposite="inArcs" required="true"
     * @generated
     */
    Place getTarget();

    /**
     * Sets the value of the '{@link org.eclipse.viatra.examples.petrinet.model.TPArc#getTarget <em>Target</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target</em>' reference.
     * @see #getTarget()
     * @generated
     */
    void setTarget(Place value);

} // TPArc
