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
package org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CyberPhysicalSystemFactoryImpl extends EFactoryImpl implements CyberPhysicalSystemFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CyberPhysicalSystemFactory init() {
		try {
			CyberPhysicalSystemFactory theCyberPhysicalSystemFactory = (CyberPhysicalSystemFactory)EPackage.Registry.INSTANCE.getEFactory(CyberPhysicalSystemPackage.eNS_URI);
			if (theCyberPhysicalSystemFactory != null) {
				return theCyberPhysicalSystemFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CyberPhysicalSystemFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CyberPhysicalSystemFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM: return createCyberPhysicalSystem();
			case CyberPhysicalSystemPackage.APPLICATION_TYPE: return createApplicationType();
			case CyberPhysicalSystemPackage.HOST_TYPE: return createHostType();
			case CyberPhysicalSystemPackage.RESOURCE_REQUIREMENT: return createResourceRequirement();
			case CyberPhysicalSystemPackage.HOST_INSTANCE: return createHostInstance();
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE: return createApplicationInstance();
			case CyberPhysicalSystemPackage.REQUEST: return createRequest();
			case CyberPhysicalSystemPackage.REQUIREMENT: return createRequirement();
			case CyberPhysicalSystemPackage.STATE_MACHINE: return createStateMachine();
			case CyberPhysicalSystemPackage.STATE: return createState();
			case CyberPhysicalSystemPackage.TRANSITION: return createTransition();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case CyberPhysicalSystemPackage.APP_STATE:
				return createAppStateFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case CyberPhysicalSystemPackage.APP_STATE:
				return convertAppStateToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CyberPhysicalSystem createCyberPhysicalSystem() {
		CyberPhysicalSystemImpl cyberPhysicalSystem = new CyberPhysicalSystemImpl();
		return cyberPhysicalSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationType createApplicationType() {
		ApplicationTypeImpl applicationType = new ApplicationTypeImpl();
		return applicationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HostType createHostType() {
		HostTypeImpl hostType = new HostTypeImpl();
		return hostType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRequirement createResourceRequirement() {
		ResourceRequirementImpl resourceRequirement = new ResourceRequirementImpl();
		return resourceRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HostInstance createHostInstance() {
		HostInstanceImpl hostInstance = new HostInstanceImpl();
		return hostInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationInstance createApplicationInstance() {
		ApplicationInstanceImpl applicationInstance = new ApplicationInstanceImpl();
		return applicationInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Request createRequest() {
		RequestImpl request = new RequestImpl();
		return request;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement createRequirement() {
		RequirementImpl requirement = new RequirementImpl();
		return requirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachine createStateMachine() {
		StateMachineImpl stateMachine = new StateMachineImpl();
		return stateMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State createState() {
		StateImpl state = new StateImpl();
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition createTransition() {
		TransitionImpl transition = new TransitionImpl();
		return transition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppState createAppStateFromString(EDataType eDataType, String initialValue) {
		AppState result = AppState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAppStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CyberPhysicalSystemPackage getCyberPhysicalSystemPackage() {
		return (CyberPhysicalSystemPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CyberPhysicalSystemPackage getPackage() {
		return CyberPhysicalSystemPackage.eINSTANCE;
	}

} //CyberPhysicalSystemFactoryImpl
