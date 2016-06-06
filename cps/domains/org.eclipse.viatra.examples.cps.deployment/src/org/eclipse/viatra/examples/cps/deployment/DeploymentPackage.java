/**
 * Copyright (c) 2014-2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Tamas Borbas, Zoltan Ujhelyi, Istvan David - initial API and implementation
 */
package org.eclipse.viatra.examples.cps.deployment;

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
 * @see org.eclipse.viatra.examples.cps.deployment.DeploymentFactory
 * @model kind="package"
 * @generated
 */
public interface DeploymentPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "deployment";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.eclipse.viatra/model/deployment";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "deployment";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DeploymentPackage eINSTANCE = org.eclipse.viatra.examples.cps.deployment.impl.DeploymentPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.examples.cps.deployment.DeploymentElement <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.examples.cps.deployment.DeploymentElement
	 * @see org.eclipse.viatra.examples.cps.deployment.impl.DeploymentPackageImpl#getDeploymentElement()
	 * @generated
	 */
	int DEPLOYMENT_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_ELEMENT__DESCRIPTION = 0;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.examples.cps.deployment.impl.DeploymentHostImpl <em>Host</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.examples.cps.deployment.impl.DeploymentHostImpl
	 * @see org.eclipse.viatra.examples.cps.deployment.impl.DeploymentPackageImpl#getDeploymentHost()
	 * @generated
	 */
	int DEPLOYMENT_HOST = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_HOST__DESCRIPTION = DEPLOYMENT_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Applications</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_HOST__APPLICATIONS = DEPLOYMENT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_HOST__IP = DEPLOYMENT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Host</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_HOST_FEATURE_COUNT = DEPLOYMENT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Host</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_HOST_OPERATION_COUNT = DEPLOYMENT_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.examples.cps.deployment.impl.DeploymentApplicationImpl <em>Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.examples.cps.deployment.impl.DeploymentApplicationImpl
	 * @see org.eclipse.viatra.examples.cps.deployment.impl.DeploymentPackageImpl#getDeploymentApplication()
	 * @generated
	 */
	int DEPLOYMENT_APPLICATION = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_APPLICATION__DESCRIPTION = DEPLOYMENT_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_APPLICATION__BEHAVIOR = DEPLOYMENT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_APPLICATION__ID = DEPLOYMENT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_APPLICATION_FEATURE_COUNT = DEPLOYMENT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_APPLICATION_OPERATION_COUNT = DEPLOYMENT_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.examples.cps.deployment.impl.DeploymentBehaviorImpl <em>Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.examples.cps.deployment.impl.DeploymentBehaviorImpl
	 * @see org.eclipse.viatra.examples.cps.deployment.impl.DeploymentPackageImpl#getDeploymentBehavior()
	 * @generated
	 */
	int DEPLOYMENT_BEHAVIOR = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_BEHAVIOR__DESCRIPTION = DEPLOYMENT_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_BEHAVIOR__STATES = DEPLOYMENT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_BEHAVIOR__TRANSITIONS = DEPLOYMENT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Current</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_BEHAVIOR__CURRENT = DEPLOYMENT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_BEHAVIOR_FEATURE_COUNT = DEPLOYMENT_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_BEHAVIOR_OPERATION_COUNT = DEPLOYMENT_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.examples.cps.deployment.impl.BehaviorStateImpl <em>Behavior State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.examples.cps.deployment.impl.BehaviorStateImpl
	 * @see org.eclipse.viatra.examples.cps.deployment.impl.DeploymentPackageImpl#getBehaviorState()
	 * @generated
	 */
	int BEHAVIOR_STATE = 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_STATE__DESCRIPTION = DEPLOYMENT_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_STATE__OUTGOING = DEPLOYMENT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Behavior State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_STATE_FEATURE_COUNT = DEPLOYMENT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Behavior State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_STATE_OPERATION_COUNT = DEPLOYMENT_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.examples.cps.deployment.impl.BehaviorTransitionImpl <em>Behavior Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.examples.cps.deployment.impl.BehaviorTransitionImpl
	 * @see org.eclipse.viatra.examples.cps.deployment.impl.DeploymentPackageImpl#getBehaviorTransition()
	 * @generated
	 */
	int BEHAVIOR_TRANSITION = 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TRANSITION__DESCRIPTION = DEPLOYMENT_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TRANSITION__TO = DEPLOYMENT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TRANSITION__TRIGGER = DEPLOYMENT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Behavior Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TRANSITION_FEATURE_COUNT = DEPLOYMENT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Behavior Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_TRANSITION_OPERATION_COUNT = DEPLOYMENT_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.examples.cps.deployment.impl.DeploymentImpl <em>Deployment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.examples.cps.deployment.impl.DeploymentImpl
	 * @see org.eclipse.viatra.examples.cps.deployment.impl.DeploymentPackageImpl#getDeployment()
	 * @generated
	 */
	int DEPLOYMENT = 5;

	/**
	 * The feature id for the '<em><b>Hosts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT__HOSTS = 0;

	/**
	 * The number of structural features of the '<em>Deployment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Deployment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.viatra.examples.cps.deployment.DeploymentHost <em>Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Host</em>'.
	 * @see org.eclipse.viatra.examples.cps.deployment.DeploymentHost
	 * @generated
	 */
	EClass getDeploymentHost();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.examples.cps.deployment.DeploymentHost#getApplications <em>Applications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Applications</em>'.
	 * @see org.eclipse.viatra.examples.cps.deployment.DeploymentHost#getApplications()
	 * @see #getDeploymentHost()
	 * @generated
	 */
	EReference getDeploymentHost_Applications();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.cps.deployment.DeploymentHost#getIp <em>Ip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ip</em>'.
	 * @see org.eclipse.viatra.examples.cps.deployment.DeploymentHost#getIp()
	 * @see #getDeploymentHost()
	 * @generated
	 */
	EAttribute getDeploymentHost_Ip();

	/**
	 * Returns the meta object for class '{@link org.eclipse.viatra.examples.cps.deployment.DeploymentApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application</em>'.
	 * @see org.eclipse.viatra.examples.cps.deployment.DeploymentApplication
	 * @generated
	 */
	EClass getDeploymentApplication();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.viatra.examples.cps.deployment.DeploymentApplication#getBehavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Behavior</em>'.
	 * @see org.eclipse.viatra.examples.cps.deployment.DeploymentApplication#getBehavior()
	 * @see #getDeploymentApplication()
	 * @generated
	 */
	EReference getDeploymentApplication_Behavior();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.cps.deployment.DeploymentApplication#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.viatra.examples.cps.deployment.DeploymentApplication#getId()
	 * @see #getDeploymentApplication()
	 * @generated
	 */
	EAttribute getDeploymentApplication_Id();

	/**
	 * Returns the meta object for class '{@link org.eclipse.viatra.examples.cps.deployment.DeploymentBehavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior</em>'.
	 * @see org.eclipse.viatra.examples.cps.deployment.DeploymentBehavior
	 * @generated
	 */
	EClass getDeploymentBehavior();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.examples.cps.deployment.DeploymentBehavior#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see org.eclipse.viatra.examples.cps.deployment.DeploymentBehavior#getStates()
	 * @see #getDeploymentBehavior()
	 * @generated
	 */
	EReference getDeploymentBehavior_States();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.examples.cps.deployment.DeploymentBehavior#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transitions</em>'.
	 * @see org.eclipse.viatra.examples.cps.deployment.DeploymentBehavior#getTransitions()
	 * @see #getDeploymentBehavior()
	 * @generated
	 */
	EReference getDeploymentBehavior_Transitions();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.viatra.examples.cps.deployment.DeploymentBehavior#getCurrent <em>Current</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Current</em>'.
	 * @see org.eclipse.viatra.examples.cps.deployment.DeploymentBehavior#getCurrent()
	 * @see #getDeploymentBehavior()
	 * @generated
	 */
	EReference getDeploymentBehavior_Current();

	/**
	 * Returns the meta object for class '{@link org.eclipse.viatra.examples.cps.deployment.BehaviorState <em>Behavior State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior State</em>'.
	 * @see org.eclipse.viatra.examples.cps.deployment.BehaviorState
	 * @generated
	 */
	EClass getBehaviorState();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.viatra.examples.cps.deployment.BehaviorState#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing</em>'.
	 * @see org.eclipse.viatra.examples.cps.deployment.BehaviorState#getOutgoing()
	 * @see #getBehaviorState()
	 * @generated
	 */
	EReference getBehaviorState_Outgoing();

	/**
	 * Returns the meta object for class '{@link org.eclipse.viatra.examples.cps.deployment.BehaviorTransition <em>Behavior Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Transition</em>'.
	 * @see org.eclipse.viatra.examples.cps.deployment.BehaviorTransition
	 * @generated
	 */
	EClass getBehaviorTransition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.viatra.examples.cps.deployment.BehaviorTransition#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see org.eclipse.viatra.examples.cps.deployment.BehaviorTransition#getTo()
	 * @see #getBehaviorTransition()
	 * @generated
	 */
	EReference getBehaviorTransition_To();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.viatra.examples.cps.deployment.BehaviorTransition#getTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trigger</em>'.
	 * @see org.eclipse.viatra.examples.cps.deployment.BehaviorTransition#getTrigger()
	 * @see #getBehaviorTransition()
	 * @generated
	 */
	EReference getBehaviorTransition_Trigger();

	/**
	 * Returns the meta object for class '{@link org.eclipse.viatra.examples.cps.deployment.Deployment <em>Deployment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deployment</em>'.
	 * @see org.eclipse.viatra.examples.cps.deployment.Deployment
	 * @generated
	 */
	EClass getDeployment();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.examples.cps.deployment.Deployment#getHosts <em>Hosts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Hosts</em>'.
	 * @see org.eclipse.viatra.examples.cps.deployment.Deployment#getHosts()
	 * @see #getDeployment()
	 * @generated
	 */
	EReference getDeployment_Hosts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.viatra.examples.cps.deployment.DeploymentElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.eclipse.viatra.examples.cps.deployment.DeploymentElement
	 * @generated
	 */
	EClass getDeploymentElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.cps.deployment.DeploymentElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.viatra.examples.cps.deployment.DeploymentElement#getDescription()
	 * @see #getDeploymentElement()
	 * @generated
	 */
	EAttribute getDeploymentElement_Description();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DeploymentFactory getDeploymentFactory();

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
		 * The meta object literal for the '{@link org.eclipse.viatra.examples.cps.deployment.impl.DeploymentHostImpl <em>Host</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.examples.cps.deployment.impl.DeploymentHostImpl
		 * @see org.eclipse.viatra.examples.cps.deployment.impl.DeploymentPackageImpl#getDeploymentHost()
		 * @generated
		 */
		EClass DEPLOYMENT_HOST = eINSTANCE.getDeploymentHost();

		/**
		 * The meta object literal for the '<em><b>Applications</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_HOST__APPLICATIONS = eINSTANCE.getDeploymentHost_Applications();

		/**
		 * The meta object literal for the '<em><b>Ip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYMENT_HOST__IP = eINSTANCE.getDeploymentHost_Ip();

		/**
		 * The meta object literal for the '{@link org.eclipse.viatra.examples.cps.deployment.impl.DeploymentApplicationImpl <em>Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.examples.cps.deployment.impl.DeploymentApplicationImpl
		 * @see org.eclipse.viatra.examples.cps.deployment.impl.DeploymentPackageImpl#getDeploymentApplication()
		 * @generated
		 */
		EClass DEPLOYMENT_APPLICATION = eINSTANCE.getDeploymentApplication();

		/**
		 * The meta object literal for the '<em><b>Behavior</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_APPLICATION__BEHAVIOR = eINSTANCE.getDeploymentApplication_Behavior();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYMENT_APPLICATION__ID = eINSTANCE.getDeploymentApplication_Id();

		/**
		 * The meta object literal for the '{@link org.eclipse.viatra.examples.cps.deployment.impl.DeploymentBehaviorImpl <em>Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.examples.cps.deployment.impl.DeploymentBehaviorImpl
		 * @see org.eclipse.viatra.examples.cps.deployment.impl.DeploymentPackageImpl#getDeploymentBehavior()
		 * @generated
		 */
		EClass DEPLOYMENT_BEHAVIOR = eINSTANCE.getDeploymentBehavior();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_BEHAVIOR__STATES = eINSTANCE.getDeploymentBehavior_States();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_BEHAVIOR__TRANSITIONS = eINSTANCE.getDeploymentBehavior_Transitions();

		/**
		 * The meta object literal for the '<em><b>Current</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_BEHAVIOR__CURRENT = eINSTANCE.getDeploymentBehavior_Current();

		/**
		 * The meta object literal for the '{@link org.eclipse.viatra.examples.cps.deployment.impl.BehaviorStateImpl <em>Behavior State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.examples.cps.deployment.impl.BehaviorStateImpl
		 * @see org.eclipse.viatra.examples.cps.deployment.impl.DeploymentPackageImpl#getBehaviorState()
		 * @generated
		 */
		EClass BEHAVIOR_STATE = eINSTANCE.getBehaviorState();

		/**
		 * The meta object literal for the '<em><b>Outgoing</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_STATE__OUTGOING = eINSTANCE.getBehaviorState_Outgoing();

		/**
		 * The meta object literal for the '{@link org.eclipse.viatra.examples.cps.deployment.impl.BehaviorTransitionImpl <em>Behavior Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.examples.cps.deployment.impl.BehaviorTransitionImpl
		 * @see org.eclipse.viatra.examples.cps.deployment.impl.DeploymentPackageImpl#getBehaviorTransition()
		 * @generated
		 */
		EClass BEHAVIOR_TRANSITION = eINSTANCE.getBehaviorTransition();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_TRANSITION__TO = eINSTANCE.getBehaviorTransition_To();

		/**
		 * The meta object literal for the '<em><b>Trigger</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_TRANSITION__TRIGGER = eINSTANCE.getBehaviorTransition_Trigger();

		/**
		 * The meta object literal for the '{@link org.eclipse.viatra.examples.cps.deployment.impl.DeploymentImpl <em>Deployment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.examples.cps.deployment.impl.DeploymentImpl
		 * @see org.eclipse.viatra.examples.cps.deployment.impl.DeploymentPackageImpl#getDeployment()
		 * @generated
		 */
		EClass DEPLOYMENT = eINSTANCE.getDeployment();

		/**
		 * The meta object literal for the '<em><b>Hosts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT__HOSTS = eINSTANCE.getDeployment_Hosts();

		/**
		 * The meta object literal for the '{@link org.eclipse.viatra.examples.cps.deployment.DeploymentElement <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.examples.cps.deployment.DeploymentElement
		 * @see org.eclipse.viatra.examples.cps.deployment.impl.DeploymentPackageImpl#getDeploymentElement()
		 * @generated
		 */
		EClass DEPLOYMENT_ELEMENT = eINSTANCE.getDeploymentElement();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYMENT_ELEMENT__DESCRIPTION = eINSTANCE.getDeploymentElement_Description();

	}

} //DeploymentPackage
