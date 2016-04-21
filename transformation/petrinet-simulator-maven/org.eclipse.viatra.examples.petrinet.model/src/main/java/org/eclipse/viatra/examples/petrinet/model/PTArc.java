/**
 */
package org.eclipse.viatra.examples.petrinet.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PT Arc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.viatra.examples.petrinet.model.PTArc#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.petrinet.model.PTArc#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.eclipse.viatra.examples.petrinet.model.PetriNetPackage#getPTArc()
 * @model
 * @generated
 */
public interface PTArc extends Arc {
    /**
     * Returns the value of the '<em><b>Source</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.viatra.examples.petrinet.model.Place#getOutArcs <em>Out Arcs</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source</em>' container reference.
     * @see #setSource(Place)
     * @see org.eclipse.viatra.examples.petrinet.model.PetriNetPackage#getPTArc_Source()
     * @see org.eclipse.viatra.examples.petrinet.model.Place#getOutArcs
     * @model opposite="outArcs" required="true" transient="false"
     * @generated
     */
    Place getSource();

    /**
     * Sets the value of the '{@link org.eclipse.viatra.examples.petrinet.model.PTArc#getSource <em>Source</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source</em>' container reference.
     * @see #getSource()
     * @generated
     */
    void setSource(Place value);

    /**
     * Returns the value of the '<em><b>Target</b></em>' reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.viatra.examples.petrinet.model.Transition#getInArcs <em>In Arcs</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target</em>' reference.
     * @see #setTarget(Transition)
     * @see org.eclipse.viatra.examples.petrinet.model.PetriNetPackage#getPTArc_Target()
     * @see org.eclipse.viatra.examples.petrinet.model.Transition#getInArcs
     * @model opposite="inArcs" required="true"
     * @generated
     */
    Transition getTarget();

    /**
     * Sets the value of the '{@link org.eclipse.viatra.examples.petrinet.model.PTArc#getTarget <em>Target</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target</em>' reference.
     * @see #getTarget()
     * @generated
     */
    void setTarget(Transition value);

} // PTArc
