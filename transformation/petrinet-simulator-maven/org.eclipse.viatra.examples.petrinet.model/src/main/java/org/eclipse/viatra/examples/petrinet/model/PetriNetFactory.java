/**
 */
package org.eclipse.viatra.examples.petrinet.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.viatra.examples.petrinet.model.PetriNetPackage
 * @generated
 */
public interface PetriNetFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    PetriNetFactory eINSTANCE = org.eclipse.viatra.examples.petrinet.model.impl.PetriNetFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Place</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Place</em>'.
     * @generated
     */
    Place createPlace();

    /**
     * Returns a new object of class '<em>Transition</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Transition</em>'.
     * @generated
     */
    Transition createTransition();

    /**
     * Returns a new object of class '<em>Named Element</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Named Element</em>'.
     * @generated
     */
    NamedElement createNamedElement();

    /**
     * Returns a new object of class '<em>Petri Net</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Petri Net</em>'.
     * @generated
     */
    PetriNet createPetriNet();

    /**
     * Returns a new object of class '<em>PT Arc</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>PT Arc</em>'.
     * @generated
     */
    PTArc createPTArc();

    /**
     * Returns a new object of class '<em>TP Arc</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>TP Arc</em>'.
     * @generated
     */
    TPArc createTPArc();

    /**
     * Returns a new object of class '<em>Token</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Token</em>'.
     * @generated
     */
    Token createToken();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    PetriNetPackage getPetriNetPackage();

} //PetriNetFactory
