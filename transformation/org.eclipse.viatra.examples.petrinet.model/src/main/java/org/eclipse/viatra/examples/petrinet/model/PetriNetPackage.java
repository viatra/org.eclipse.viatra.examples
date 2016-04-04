/**
 */
package org.eclipse.viatra.examples.petrinet.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.viatra.examples.petrinet.model.PetriNetFactory
 * @model kind="package"
 * @generated
 */
public interface PetriNetPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "petrinet";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://inf.mit.bme.hu/petrinet/2014";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "petrinet";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    PetriNetPackage eINSTANCE = org.eclipse.viatra.examples.petrinet.model.impl.PetriNetPackageImpl.init();

    /**
     * The meta object id for the '{@link org.eclipse.viatra.examples.petrinet.model.impl.NamedElementImpl <em>Named Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.viatra.examples.petrinet.model.impl.NamedElementImpl
     * @see org.eclipse.viatra.examples.petrinet.model.impl.PetriNetPackageImpl#getNamedElement()
     * @generated
     */
    int NAMED_ELEMENT = 3;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED_ELEMENT__NAME = 0;

    /**
     * The number of structural features of the '<em>Named Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED_ELEMENT_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Named Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED_ELEMENT_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.viatra.examples.petrinet.model.impl.PlaceImpl <em>Place</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.viatra.examples.petrinet.model.impl.PlaceImpl
     * @see org.eclipse.viatra.examples.petrinet.model.impl.PetriNetPackageImpl#getPlace()
     * @generated
     */
    int PLACE = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLACE__NAME = NAMED_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Net</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLACE__NET = NAMED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Out Arcs</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLACE__OUT_ARCS = NAMED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>In Arcs</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLACE__IN_ARCS = NAMED_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Tokens</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLACE__TOKENS = NAMED_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Place</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLACE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

    /**
     * The number of operations of the '<em>Place</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLACE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.viatra.examples.petrinet.model.impl.TransitionImpl <em>Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.viatra.examples.petrinet.model.impl.TransitionImpl
     * @see org.eclipse.viatra.examples.petrinet.model.impl.PetriNetPackageImpl#getTransition()
     * @generated
     */
    int TRANSITION = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION__NAME = NAMED_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Net</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION__NET = NAMED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>In Arcs</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION__IN_ARCS = NAMED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Out Arcs</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION__OUT_ARCS = NAMED_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Transition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The number of operations of the '<em>Transition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.viatra.examples.petrinet.model.impl.ArcImpl <em>Arc</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.viatra.examples.petrinet.model.impl.ArcImpl
     * @see org.eclipse.viatra.examples.petrinet.model.impl.PetriNetPackageImpl#getArc()
     * @generated
     */
    int ARC = 2;

    /**
     * The feature id for the '<em><b>Weight</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__WEIGHT = 0;

    /**
     * The number of structural features of the '<em>Arc</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Arc</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.viatra.examples.petrinet.model.impl.PetriNetImpl <em>Petri Net</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.viatra.examples.petrinet.model.impl.PetriNetImpl
     * @see org.eclipse.viatra.examples.petrinet.model.impl.PetriNetPackageImpl#getPetriNet()
     * @generated
     */
    int PETRI_NET = 4;

    /**
     * The feature id for the '<em><b>Places</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PETRI_NET__PLACES = 0;

    /**
     * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PETRI_NET__TRANSITIONS = 1;

    /**
     * The number of structural features of the '<em>Petri Net</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PETRI_NET_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Petri Net</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PETRI_NET_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.viatra.examples.petrinet.model.impl.PTArcImpl <em>PT Arc</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.viatra.examples.petrinet.model.impl.PTArcImpl
     * @see org.eclipse.viatra.examples.petrinet.model.impl.PetriNetPackageImpl#getPTArc()
     * @generated
     */
    int PT_ARC = 5;

    /**
     * The feature id for the '<em><b>Weight</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PT_ARC__WEIGHT = ARC__WEIGHT;

    /**
     * The feature id for the '<em><b>Source</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PT_ARC__SOURCE = ARC_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PT_ARC__TARGET = ARC_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>PT Arc</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PT_ARC_FEATURE_COUNT = ARC_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>PT Arc</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PT_ARC_OPERATION_COUNT = ARC_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.viatra.examples.petrinet.model.impl.TPArcImpl <em>TP Arc</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.viatra.examples.petrinet.model.impl.TPArcImpl
     * @see org.eclipse.viatra.examples.petrinet.model.impl.PetriNetPackageImpl#getTPArc()
     * @generated
     */
    int TP_ARC = 6;

    /**
     * The feature id for the '<em><b>Weight</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TP_ARC__WEIGHT = ARC__WEIGHT;

    /**
     * The feature id for the '<em><b>Source</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TP_ARC__SOURCE = ARC_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TP_ARC__TARGET = ARC_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>TP Arc</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TP_ARC_FEATURE_COUNT = ARC_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>TP Arc</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TP_ARC_OPERATION_COUNT = ARC_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.viatra.examples.petrinet.model.impl.TokenImpl <em>Token</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.viatra.examples.petrinet.model.impl.TokenImpl
     * @see org.eclipse.viatra.examples.petrinet.model.impl.PetriNetPackageImpl#getToken()
     * @generated
     */
    int TOKEN = 7;

    /**
     * The feature id for the '<em><b>Place</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TOKEN__PLACE = 0;

    /**
     * The number of structural features of the '<em>Token</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TOKEN_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Token</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TOKEN_OPERATION_COUNT = 0;


    /**
     * Returns the meta object for class '{@link org.eclipse.viatra.examples.petrinet.model.Place <em>Place</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Place</em>'.
     * @see org.eclipse.viatra.examples.petrinet.model.Place
     * @generated
     */
    EClass getPlace();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.viatra.examples.petrinet.model.Place#getNet <em>Net</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Net</em>'.
     * @see org.eclipse.viatra.examples.petrinet.model.Place#getNet()
     * @see #getPlace()
     * @generated
     */
    EReference getPlace_Net();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.examples.petrinet.model.Place#getOutArcs <em>Out Arcs</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Out Arcs</em>'.
     * @see org.eclipse.viatra.examples.petrinet.model.Place#getOutArcs()
     * @see #getPlace()
     * @generated
     */
    EReference getPlace_OutArcs();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.viatra.examples.petrinet.model.Place#getInArcs <em>In Arcs</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>In Arcs</em>'.
     * @see org.eclipse.viatra.examples.petrinet.model.Place#getInArcs()
     * @see #getPlace()
     * @generated
     */
    EReference getPlace_InArcs();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.examples.petrinet.model.Place#getTokens <em>Tokens</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Tokens</em>'.
     * @see org.eclipse.viatra.examples.petrinet.model.Place#getTokens()
     * @see #getPlace()
     * @generated
     */
    EReference getPlace_Tokens();

    /**
     * Returns the meta object for class '{@link org.eclipse.viatra.examples.petrinet.model.Transition <em>Transition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Transition</em>'.
     * @see org.eclipse.viatra.examples.petrinet.model.Transition
     * @generated
     */
    EClass getTransition();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.viatra.examples.petrinet.model.Transition#getNet <em>Net</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Net</em>'.
     * @see org.eclipse.viatra.examples.petrinet.model.Transition#getNet()
     * @see #getTransition()
     * @generated
     */
    EReference getTransition_Net();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.viatra.examples.petrinet.model.Transition#getInArcs <em>In Arcs</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>In Arcs</em>'.
     * @see org.eclipse.viatra.examples.petrinet.model.Transition#getInArcs()
     * @see #getTransition()
     * @generated
     */
    EReference getTransition_InArcs();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.examples.petrinet.model.Transition#getOutArcs <em>Out Arcs</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Out Arcs</em>'.
     * @see org.eclipse.viatra.examples.petrinet.model.Transition#getOutArcs()
     * @see #getTransition()
     * @generated
     */
    EReference getTransition_OutArcs();

    /**
     * Returns the meta object for class '{@link org.eclipse.viatra.examples.petrinet.model.Arc <em>Arc</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Arc</em>'.
     * @see org.eclipse.viatra.examples.petrinet.model.Arc
     * @generated
     */
    EClass getArc();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.petrinet.model.Arc#getWeight <em>Weight</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Weight</em>'.
     * @see org.eclipse.viatra.examples.petrinet.model.Arc#getWeight()
     * @see #getArc()
     * @generated
     */
    EAttribute getArc_Weight();

    /**
     * Returns the meta object for class '{@link org.eclipse.viatra.examples.petrinet.model.NamedElement <em>Named Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Named Element</em>'.
     * @see org.eclipse.viatra.examples.petrinet.model.NamedElement
     * @generated
     */
    EClass getNamedElement();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.petrinet.model.NamedElement#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.viatra.examples.petrinet.model.NamedElement#getName()
     * @see #getNamedElement()
     * @generated
     */
    EAttribute getNamedElement_Name();

    /**
     * Returns the meta object for class '{@link org.eclipse.viatra.examples.petrinet.model.PetriNet <em>Petri Net</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Petri Net</em>'.
     * @see org.eclipse.viatra.examples.petrinet.model.PetriNet
     * @generated
     */
    EClass getPetriNet();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.examples.petrinet.model.PetriNet#getPlaces <em>Places</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Places</em>'.
     * @see org.eclipse.viatra.examples.petrinet.model.PetriNet#getPlaces()
     * @see #getPetriNet()
     * @generated
     */
    EReference getPetriNet_Places();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.examples.petrinet.model.PetriNet#getTransitions <em>Transitions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Transitions</em>'.
     * @see org.eclipse.viatra.examples.petrinet.model.PetriNet#getTransitions()
     * @see #getPetriNet()
     * @generated
     */
    EReference getPetriNet_Transitions();

    /**
     * Returns the meta object for class '{@link org.eclipse.viatra.examples.petrinet.model.PTArc <em>PT Arc</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>PT Arc</em>'.
     * @see org.eclipse.viatra.examples.petrinet.model.PTArc
     * @generated
     */
    EClass getPTArc();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.viatra.examples.petrinet.model.PTArc#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Source</em>'.
     * @see org.eclipse.viatra.examples.petrinet.model.PTArc#getSource()
     * @see #getPTArc()
     * @generated
     */
    EReference getPTArc_Source();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.viatra.examples.petrinet.model.PTArc#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Target</em>'.
     * @see org.eclipse.viatra.examples.petrinet.model.PTArc#getTarget()
     * @see #getPTArc()
     * @generated
     */
    EReference getPTArc_Target();

    /**
     * Returns the meta object for class '{@link org.eclipse.viatra.examples.petrinet.model.TPArc <em>TP Arc</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>TP Arc</em>'.
     * @see org.eclipse.viatra.examples.petrinet.model.TPArc
     * @generated
     */
    EClass getTPArc();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.viatra.examples.petrinet.model.TPArc#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Source</em>'.
     * @see org.eclipse.viatra.examples.petrinet.model.TPArc#getSource()
     * @see #getTPArc()
     * @generated
     */
    EReference getTPArc_Source();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.viatra.examples.petrinet.model.TPArc#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Target</em>'.
     * @see org.eclipse.viatra.examples.petrinet.model.TPArc#getTarget()
     * @see #getTPArc()
     * @generated
     */
    EReference getTPArc_Target();

    /**
     * Returns the meta object for class '{@link org.eclipse.viatra.examples.petrinet.model.Token <em>Token</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Token</em>'.
     * @see org.eclipse.viatra.examples.petrinet.model.Token
     * @generated
     */
    EClass getToken();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.viatra.examples.petrinet.model.Token#getPlace <em>Place</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Place</em>'.
     * @see org.eclipse.viatra.examples.petrinet.model.Token#getPlace()
     * @see #getToken()
     * @generated
     */
    EReference getToken_Place();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    PetriNetFactory getPetriNetFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each operation of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link org.eclipse.viatra.examples.petrinet.model.impl.PlaceImpl <em>Place</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.viatra.examples.petrinet.model.impl.PlaceImpl
         * @see org.eclipse.viatra.examples.petrinet.model.impl.PetriNetPackageImpl#getPlace()
         * @generated
         */
        EClass PLACE = eINSTANCE.getPlace();

        /**
         * The meta object literal for the '<em><b>Net</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PLACE__NET = eINSTANCE.getPlace_Net();

        /**
         * The meta object literal for the '<em><b>Out Arcs</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PLACE__OUT_ARCS = eINSTANCE.getPlace_OutArcs();

        /**
         * The meta object literal for the '<em><b>In Arcs</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PLACE__IN_ARCS = eINSTANCE.getPlace_InArcs();

        /**
         * The meta object literal for the '<em><b>Tokens</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PLACE__TOKENS = eINSTANCE.getPlace_Tokens();

        /**
         * The meta object literal for the '{@link org.eclipse.viatra.examples.petrinet.model.impl.TransitionImpl <em>Transition</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.viatra.examples.petrinet.model.impl.TransitionImpl
         * @see org.eclipse.viatra.examples.petrinet.model.impl.PetriNetPackageImpl#getTransition()
         * @generated
         */
        EClass TRANSITION = eINSTANCE.getTransition();

        /**
         * The meta object literal for the '<em><b>Net</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TRANSITION__NET = eINSTANCE.getTransition_Net();

        /**
         * The meta object literal for the '<em><b>In Arcs</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TRANSITION__IN_ARCS = eINSTANCE.getTransition_InArcs();

        /**
         * The meta object literal for the '<em><b>Out Arcs</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TRANSITION__OUT_ARCS = eINSTANCE.getTransition_OutArcs();

        /**
         * The meta object literal for the '{@link org.eclipse.viatra.examples.petrinet.model.impl.ArcImpl <em>Arc</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.viatra.examples.petrinet.model.impl.ArcImpl
         * @see org.eclipse.viatra.examples.petrinet.model.impl.PetriNetPackageImpl#getArc()
         * @generated
         */
        EClass ARC = eINSTANCE.getArc();

        /**
         * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ARC__WEIGHT = eINSTANCE.getArc_Weight();

        /**
         * The meta object literal for the '{@link org.eclipse.viatra.examples.petrinet.model.impl.NamedElementImpl <em>Named Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.viatra.examples.petrinet.model.impl.NamedElementImpl
         * @see org.eclipse.viatra.examples.petrinet.model.impl.PetriNetPackageImpl#getNamedElement()
         * @generated
         */
        EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

        /**
         * The meta object literal for the '{@link org.eclipse.viatra.examples.petrinet.model.impl.PetriNetImpl <em>Petri Net</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.viatra.examples.petrinet.model.impl.PetriNetImpl
         * @see org.eclipse.viatra.examples.petrinet.model.impl.PetriNetPackageImpl#getPetriNet()
         * @generated
         */
        EClass PETRI_NET = eINSTANCE.getPetriNet();

        /**
         * The meta object literal for the '<em><b>Places</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PETRI_NET__PLACES = eINSTANCE.getPetriNet_Places();

        /**
         * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PETRI_NET__TRANSITIONS = eINSTANCE.getPetriNet_Transitions();

        /**
         * The meta object literal for the '{@link org.eclipse.viatra.examples.petrinet.model.impl.PTArcImpl <em>PT Arc</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.viatra.examples.petrinet.model.impl.PTArcImpl
         * @see org.eclipse.viatra.examples.petrinet.model.impl.PetriNetPackageImpl#getPTArc()
         * @generated
         */
        EClass PT_ARC = eINSTANCE.getPTArc();

        /**
         * The meta object literal for the '<em><b>Source</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PT_ARC__SOURCE = eINSTANCE.getPTArc_Source();

        /**
         * The meta object literal for the '<em><b>Target</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PT_ARC__TARGET = eINSTANCE.getPTArc_Target();

        /**
         * The meta object literal for the '{@link org.eclipse.viatra.examples.petrinet.model.impl.TPArcImpl <em>TP Arc</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.viatra.examples.petrinet.model.impl.TPArcImpl
         * @see org.eclipse.viatra.examples.petrinet.model.impl.PetriNetPackageImpl#getTPArc()
         * @generated
         */
        EClass TP_ARC = eINSTANCE.getTPArc();

        /**
         * The meta object literal for the '<em><b>Source</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TP_ARC__SOURCE = eINSTANCE.getTPArc_Source();

        /**
         * The meta object literal for the '<em><b>Target</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TP_ARC__TARGET = eINSTANCE.getTPArc_Target();

        /**
         * The meta object literal for the '{@link org.eclipse.viatra.examples.petrinet.model.impl.TokenImpl <em>Token</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.viatra.examples.petrinet.model.impl.TokenImpl
         * @see org.eclipse.viatra.examples.petrinet.model.impl.PetriNetPackageImpl#getToken()
         * @generated
         */
        EClass TOKEN = eINSTANCE.getToken();

        /**
         * The meta object literal for the '<em><b>Place</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TOKEN__PLACE = eINSTANCE.getToken_Place();

    }

} //PetriNetPackage
