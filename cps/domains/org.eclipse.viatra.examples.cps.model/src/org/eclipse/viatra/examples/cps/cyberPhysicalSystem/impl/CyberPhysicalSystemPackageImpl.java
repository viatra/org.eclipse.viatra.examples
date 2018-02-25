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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.AppState;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystem;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemFactory;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostType;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Identifiable;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Request;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Requirement;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ResourceRequirement;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.State;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.StateMachine;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CyberPhysicalSystemPackageImpl extends EPackageImpl implements CyberPhysicalSystemPackage {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass identifiableEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass cyberPhysicalSystemEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass applicationTypeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass hostTypeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass resourceRequirementEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass hostInstanceEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass applicationInstanceEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass requestEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass requirementEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass stateMachineEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass stateEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass transitionEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EEnum appStateEEnum = null;

	/**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage#eNS_URI
     * @see #init()
     * @generated
     */
	private CyberPhysicalSystemPackageImpl() {
        super(eNS_URI, CyberPhysicalSystemFactory.eINSTANCE);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static boolean isInited = false;

	/**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     *
     * <p>This method is used to initialize {@link CyberPhysicalSystemPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
	public static CyberPhysicalSystemPackage init() {
        if (isInited) return (CyberPhysicalSystemPackage)EPackage.Registry.INSTANCE.getEPackage(CyberPhysicalSystemPackage.eNS_URI);

        // Obtain or create and register package
        Object registeredCyberPhysicalSystemPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
        CyberPhysicalSystemPackageImpl theCyberPhysicalSystemPackage = registeredCyberPhysicalSystemPackage instanceof CyberPhysicalSystemPackageImpl ? (CyberPhysicalSystemPackageImpl)registeredCyberPhysicalSystemPackage : new CyberPhysicalSystemPackageImpl();

        isInited = true;

        // Create package meta-data objects
        theCyberPhysicalSystemPackage.createPackageContents();

        // Initialize created meta-data
        theCyberPhysicalSystemPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theCyberPhysicalSystemPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(CyberPhysicalSystemPackage.eNS_URI, theCyberPhysicalSystemPackage);
        return theCyberPhysicalSystemPackage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getIdentifiable() {
        return identifiableEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getIdentifiable_Identifier() {
        return (EAttribute)identifiableEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getCyberPhysicalSystem() {
        return cyberPhysicalSystemEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getCyberPhysicalSystem_DbUrl() {
        return (EAttribute)cyberPhysicalSystemEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getCyberPhysicalSystem_AppTypes() {
        return (EReference)cyberPhysicalSystemEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getCyberPhysicalSystem_Requests() {
        return (EReference)cyberPhysicalSystemEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getCyberPhysicalSystem_HostTypes() {
        return (EReference)cyberPhysicalSystemEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getApplicationType() {
        return applicationTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getApplicationType_ExeFileLocation() {
        return (EAttribute)applicationTypeEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getApplicationType_ExeType() {
        return (EAttribute)applicationTypeEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getApplicationType_ZipFileUrl() {
        return (EAttribute)applicationTypeEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getApplicationType_Requirements() {
        return (EReference)applicationTypeEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getApplicationType_Cps() {
        return (EReference)applicationTypeEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getApplicationType_Instances() {
        return (EReference)applicationTypeEClass.getEStructuralFeatures().get(5);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getApplicationType_Behavior() {
        return (EReference)applicationTypeEClass.getEStructuralFeatures().get(6);
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getApplicationType_ExeFileSize() {
        return (EAttribute)applicationTypeEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getHostType() {
        return hostTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getHostType_DefaultCpu() {
        return (EAttribute)hostTypeEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getHostType_DefaultRam() {
        return (EAttribute)hostTypeEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getHostType_DefaultHdd() {
        return (EAttribute)hostTypeEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getHostType_Cps() {
        return (EReference)hostTypeEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getHostType_Instances() {
        return (EReference)hostTypeEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getResourceRequirement() {
        return resourceRequirementEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getResourceRequirement_RequiredCpu() {
        return (EAttribute)resourceRequirementEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getResourceRequirement_RequiredRam() {
        return (EAttribute)resourceRequirementEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getResourceRequirement_RequiredHdd() {
        return (EAttribute)resourceRequirementEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getResourceRequirement_Type() {
        return (EReference)resourceRequirementEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getHostInstance() {
        return hostInstanceEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getHostInstance_NodeIp() {
        return (EAttribute)hostInstanceEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getHostInstance_AvailableCpu() {
        return (EAttribute)hostInstanceEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getHostInstance_AvailableRam() {
        return (EAttribute)hostInstanceEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getHostInstance_AvailableHdd() {
        return (EAttribute)hostInstanceEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getHostInstance_TotalCpu() {
        return (EAttribute)hostInstanceEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getHostInstance_TotalRam() {
        return (EAttribute)hostInstanceEClass.getEStructuralFeatures().get(5);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getHostInstance_TotalHdd() {
        return (EAttribute)hostInstanceEClass.getEStructuralFeatures().get(6);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getHostInstance_Applications() {
        return (EReference)hostInstanceEClass.getEStructuralFeatures().get(7);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getHostInstance_CommunicateWith() {
        return (EReference)hostInstanceEClass.getEStructuralFeatures().get(8);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getApplicationInstance() {
        return applicationInstanceEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getApplicationInstance_State() {
        return (EAttribute)applicationInstanceEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getApplicationInstance_DbUser() {
        return (EAttribute)applicationInstanceEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getApplicationInstance_DbPassword() {
        return (EAttribute)applicationInstanceEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getApplicationInstance_AllocatedTo() {
        return (EReference)applicationInstanceEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getApplicationInstance_DependOn() {
        return (EReference)applicationInstanceEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getApplicationInstance_Type() {
        return (EReference)applicationInstanceEClass.getEStructuralFeatures().get(5);
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getApplicationInstance_Priority() {
        return (EAttribute)applicationInstanceEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getRequest() {
        return requestEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getRequest_Requirements() {
        return (EReference)requestEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getRequirement() {
        return requirementEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getRequirement_Count() {
        return (EAttribute)requirementEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getRequirement_Request() {
        return (EReference)requirementEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getRequirement_Type() {
        return (EReference)requirementEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getRequirement_Applications() {
        return (EReference)requirementEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRequirement_Mandatory() {
        return (EAttribute)requirementEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRequirement_AvailablePorts() {
        return (EAttribute)requirementEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getStateMachine() {
        return stateMachineEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getStateMachine_States() {
        return (EReference)stateMachineEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getStateMachine_Initial() {
        return (EReference)stateMachineEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getState() {
        return stateEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getState_OutgoingTransitions() {
        return (EReference)stateEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTransition() {
        return transitionEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTransition_TargetState() {
        return (EReference)transitionEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getTransition_Action() {
        return (EAttribute)transitionEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EEnum getAppState() {
        return appStateEEnum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CyberPhysicalSystemFactory getCyberPhysicalSystemFactory() {
        return (CyberPhysicalSystemFactory)getEFactoryInstance();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private boolean isCreated = false;

	/**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        identifiableEClass = createEClass(IDENTIFIABLE);
        createEAttribute(identifiableEClass, IDENTIFIABLE__IDENTIFIER);

        cyberPhysicalSystemEClass = createEClass(CYBER_PHYSICAL_SYSTEM);
        createEAttribute(cyberPhysicalSystemEClass, CYBER_PHYSICAL_SYSTEM__DB_URL);
        createEReference(cyberPhysicalSystemEClass, CYBER_PHYSICAL_SYSTEM__APP_TYPES);
        createEReference(cyberPhysicalSystemEClass, CYBER_PHYSICAL_SYSTEM__REQUESTS);
        createEReference(cyberPhysicalSystemEClass, CYBER_PHYSICAL_SYSTEM__HOST_TYPES);

        applicationTypeEClass = createEClass(APPLICATION_TYPE);
        createEAttribute(applicationTypeEClass, APPLICATION_TYPE__EXE_FILE_LOCATION);
        createEAttribute(applicationTypeEClass, APPLICATION_TYPE__EXE_TYPE);
        createEAttribute(applicationTypeEClass, APPLICATION_TYPE__ZIP_FILE_URL);
        createEReference(applicationTypeEClass, APPLICATION_TYPE__REQUIREMENTS);
        createEReference(applicationTypeEClass, APPLICATION_TYPE__CPS);
        createEReference(applicationTypeEClass, APPLICATION_TYPE__INSTANCES);
        createEReference(applicationTypeEClass, APPLICATION_TYPE__BEHAVIOR);
        createEAttribute(applicationTypeEClass, APPLICATION_TYPE__EXE_FILE_SIZE);

        hostTypeEClass = createEClass(HOST_TYPE);
        createEAttribute(hostTypeEClass, HOST_TYPE__DEFAULT_CPU);
        createEAttribute(hostTypeEClass, HOST_TYPE__DEFAULT_RAM);
        createEAttribute(hostTypeEClass, HOST_TYPE__DEFAULT_HDD);
        createEReference(hostTypeEClass, HOST_TYPE__CPS);
        createEReference(hostTypeEClass, HOST_TYPE__INSTANCES);

        resourceRequirementEClass = createEClass(RESOURCE_REQUIREMENT);
        createEAttribute(resourceRequirementEClass, RESOURCE_REQUIREMENT__REQUIRED_CPU);
        createEAttribute(resourceRequirementEClass, RESOURCE_REQUIREMENT__REQUIRED_RAM);
        createEAttribute(resourceRequirementEClass, RESOURCE_REQUIREMENT__REQUIRED_HDD);
        createEReference(resourceRequirementEClass, RESOURCE_REQUIREMENT__TYPE);

        hostInstanceEClass = createEClass(HOST_INSTANCE);
        createEAttribute(hostInstanceEClass, HOST_INSTANCE__NODE_IP);
        createEAttribute(hostInstanceEClass, HOST_INSTANCE__AVAILABLE_CPU);
        createEAttribute(hostInstanceEClass, HOST_INSTANCE__AVAILABLE_RAM);
        createEAttribute(hostInstanceEClass, HOST_INSTANCE__AVAILABLE_HDD);
        createEAttribute(hostInstanceEClass, HOST_INSTANCE__TOTAL_CPU);
        createEAttribute(hostInstanceEClass, HOST_INSTANCE__TOTAL_RAM);
        createEAttribute(hostInstanceEClass, HOST_INSTANCE__TOTAL_HDD);
        createEReference(hostInstanceEClass, HOST_INSTANCE__APPLICATIONS);
        createEReference(hostInstanceEClass, HOST_INSTANCE__COMMUNICATE_WITH);

        applicationInstanceEClass = createEClass(APPLICATION_INSTANCE);
        createEAttribute(applicationInstanceEClass, APPLICATION_INSTANCE__STATE);
        createEAttribute(applicationInstanceEClass, APPLICATION_INSTANCE__DB_USER);
        createEAttribute(applicationInstanceEClass, APPLICATION_INSTANCE__DB_PASSWORD);
        createEReference(applicationInstanceEClass, APPLICATION_INSTANCE__ALLOCATED_TO);
        createEReference(applicationInstanceEClass, APPLICATION_INSTANCE__DEPEND_ON);
        createEReference(applicationInstanceEClass, APPLICATION_INSTANCE__TYPE);
        createEAttribute(applicationInstanceEClass, APPLICATION_INSTANCE__PRIORITY);

        requestEClass = createEClass(REQUEST);
        createEReference(requestEClass, REQUEST__REQUIREMENTS);

        requirementEClass = createEClass(REQUIREMENT);
        createEAttribute(requirementEClass, REQUIREMENT__COUNT);
        createEReference(requirementEClass, REQUIREMENT__REQUEST);
        createEReference(requirementEClass, REQUIREMENT__TYPE);
        createEReference(requirementEClass, REQUIREMENT__APPLICATIONS);
        createEAttribute(requirementEClass, REQUIREMENT__MANDATORY);
        createEAttribute(requirementEClass, REQUIREMENT__AVAILABLE_PORTS);

        stateMachineEClass = createEClass(STATE_MACHINE);
        createEReference(stateMachineEClass, STATE_MACHINE__STATES);
        createEReference(stateMachineEClass, STATE_MACHINE__INITIAL);

        stateEClass = createEClass(STATE);
        createEReference(stateEClass, STATE__OUTGOING_TRANSITIONS);

        transitionEClass = createEClass(TRANSITION);
        createEReference(transitionEClass, TRANSITION__TARGET_STATE);
        createEAttribute(transitionEClass, TRANSITION__ACTION);

        // Create enums
        appStateEEnum = createEEnum(APP_STATE);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private boolean isInitialized = false;

	/**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        cyberPhysicalSystemEClass.getESuperTypes().add(this.getIdentifiable());
        applicationTypeEClass.getESuperTypes().add(this.getIdentifiable());
        hostTypeEClass.getESuperTypes().add(this.getIdentifiable());
        resourceRequirementEClass.getESuperTypes().add(this.getIdentifiable());
        hostInstanceEClass.getESuperTypes().add(this.getIdentifiable());
        applicationInstanceEClass.getESuperTypes().add(this.getIdentifiable());
        requestEClass.getESuperTypes().add(this.getIdentifiable());
        requirementEClass.getESuperTypes().add(this.getIdentifiable());
        stateMachineEClass.getESuperTypes().add(this.getIdentifiable());
        stateEClass.getESuperTypes().add(this.getIdentifiable());
        transitionEClass.getESuperTypes().add(this.getIdentifiable());

        // Initialize classes, features, and operations; add parameters
        initEClass(identifiableEClass, Identifiable.class, "Identifiable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIdentifiable_Identifier(), ecorePackage.getEString(), "identifier", null, 0, 1, Identifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(cyberPhysicalSystemEClass, CyberPhysicalSystem.class, "CyberPhysicalSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCyberPhysicalSystem_DbUrl(), ecorePackage.getEString(), "dbUrl", null, 0, 1, CyberPhysicalSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getCyberPhysicalSystem_AppTypes(), this.getApplicationType(), this.getApplicationType_Cps(), "appTypes", null, 0, -1, CyberPhysicalSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getCyberPhysicalSystem_Requests(), this.getRequest(), null, "requests", null, 0, -1, CyberPhysicalSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getCyberPhysicalSystem_HostTypes(), this.getHostType(), this.getHostType_Cps(), "hostTypes", null, 0, -1, CyberPhysicalSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(applicationTypeEClass, ApplicationType.class, "ApplicationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getApplicationType_ExeFileLocation(), ecorePackage.getEString(), "exeFileLocation", null, 0, 1, ApplicationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getApplicationType_ExeType(), ecorePackage.getEString(), "exeType", null, 0, 1, ApplicationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getApplicationType_ZipFileUrl(), ecorePackage.getEString(), "zipFileUrl", null, 0, 1, ApplicationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getApplicationType_Requirements(), this.getResourceRequirement(), null, "requirements", null, 0, -1, ApplicationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getApplicationType_Cps(), this.getCyberPhysicalSystem(), this.getCyberPhysicalSystem_AppTypes(), "cps", null, 1, 1, ApplicationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getApplicationType_Instances(), this.getApplicationInstance(), this.getApplicationInstance_Type(), "instances", null, 0, -1, ApplicationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getApplicationType_Behavior(), this.getStateMachine(), null, "behavior", null, 0, 1, ApplicationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getApplicationType_ExeFileSize(), ecorePackage.getELong(), "exeFileSize", null, 0, 1, ApplicationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(hostTypeEClass, HostType.class, "HostType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getHostType_DefaultCpu(), ecorePackage.getEInt(), "defaultCpu", null, 0, 1, HostType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHostType_DefaultRam(), ecorePackage.getEInt(), "defaultRam", null, 0, 1, HostType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHostType_DefaultHdd(), ecorePackage.getEInt(), "defaultHdd", null, 0, 1, HostType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getHostType_Cps(), this.getCyberPhysicalSystem(), this.getCyberPhysicalSystem_HostTypes(), "cps", null, 1, 1, HostType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getHostType_Instances(), this.getHostInstance(), null, "instances", null, 0, -1, HostType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(resourceRequirementEClass, ResourceRequirement.class, "ResourceRequirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getResourceRequirement_RequiredCpu(), ecorePackage.getEInt(), "requiredCpu", null, 0, 1, ResourceRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getResourceRequirement_RequiredRam(), ecorePackage.getEInt(), "requiredRam", null, 0, 1, ResourceRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getResourceRequirement_RequiredHdd(), ecorePackage.getEInt(), "requiredHdd", null, 0, 1, ResourceRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getResourceRequirement_Type(), this.getHostType(), null, "type", null, 1, 1, ResourceRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(hostInstanceEClass, HostInstance.class, "HostInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getHostInstance_NodeIp(), ecorePackage.getEString(), "nodeIp", null, 0, 1, HostInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHostInstance_AvailableCpu(), ecorePackage.getEInt(), "availableCpu", null, 0, 1, HostInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHostInstance_AvailableRam(), ecorePackage.getEInt(), "availableRam", null, 0, 1, HostInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHostInstance_AvailableHdd(), ecorePackage.getEInt(), "availableHdd", null, 0, 1, HostInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHostInstance_TotalCpu(), ecorePackage.getEInt(), "totalCpu", null, 0, 1, HostInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHostInstance_TotalRam(), ecorePackage.getEInt(), "totalRam", null, 0, 1, HostInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHostInstance_TotalHdd(), ecorePackage.getEInt(), "totalHdd", null, 0, 1, HostInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getHostInstance_Applications(), this.getApplicationInstance(), this.getApplicationInstance_AllocatedTo(), "applications", null, 0, -1, HostInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getHostInstance_CommunicateWith(), this.getHostInstance(), null, "communicateWith", null, 0, -1, HostInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(applicationInstanceEClass, ApplicationInstance.class, "ApplicationInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getApplicationInstance_State(), this.getAppState(), "state", null, 0, 1, ApplicationInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getApplicationInstance_DbUser(), ecorePackage.getEString(), "dbUser", null, 0, 1, ApplicationInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getApplicationInstance_DbPassword(), ecorePackage.getEString(), "dbPassword", null, 0, 1, ApplicationInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getApplicationInstance_AllocatedTo(), this.getHostInstance(), this.getHostInstance_Applications(), "allocatedTo", null, 0, 1, ApplicationInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getApplicationInstance_DependOn(), this.getApplicationInstance(), null, "dependOn", null, 0, -1, ApplicationInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getApplicationInstance_Type(), this.getApplicationType(), this.getApplicationType_Instances(), "type", null, 1, 1, ApplicationInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getApplicationInstance_Priority(), ecorePackage.getEInt(), "priority", null, 0, 1, ApplicationInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(requestEClass, Request.class, "Request", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRequest_Requirements(), this.getRequirement(), this.getRequirement_Request(), "requirements", null, 0, -1, Request.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(requirementEClass, Requirement.class, "Requirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRequirement_Count(), ecorePackage.getEInt(), "count", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRequirement_Request(), this.getRequest(), this.getRequest_Requirements(), "request", null, 1, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRequirement_Type(), this.getApplicationType(), null, "type", null, 1, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRequirement_Applications(), this.getApplicationInstance(), null, "applications", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRequirement_Mandatory(), ecorePackage.getEBoolean(), "mandatory", "true", 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRequirement_AvailablePorts(), ecorePackage.getEInt(), "availablePorts", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(stateMachineEClass, StateMachine.class, "StateMachine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getStateMachine_States(), this.getState(), null, "states", null, 0, -1, StateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getStateMachine_Initial(), this.getState(), null, "initial", null, 0, 1, StateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(stateEClass, State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getState_OutgoingTransitions(), this.getTransition(), null, "outgoingTransitions", null, 0, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(transitionEClass, Transition.class, "Transition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTransition_TargetState(), this.getState(), null, "targetState", null, 0, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTransition_Action(), ecorePackage.getEString(), "action", null, 0, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(appStateEEnum, AppState.class, "AppState");
        addEEnumLiteral(appStateEEnum, AppState.RUNNING);
        addEEnumLiteral(appStateEEnum, AppState.STOPPED);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http://www.eclipse.org/emf/2002/Ecore
        createEcoreAnnotations();
        // http://www.eclipse.org/emf/2002/GenModel
        createGenModelAnnotations();
    }

	/**
     * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void createEcoreAnnotations() {
        String source = "http://www.eclipse.org/emf/2002/Ecore";
        addAnnotation
          (this,
           source,
           new String[] {
               "settingDelegates", "org.eclipse.viatra.query.querybasedfeature"
           });
    }

    /**
     * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/GenModel</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createGenModelAnnotations() {
        String source = "http://www.eclipse.org/emf/2002/GenModel";
        addAnnotation
          (identifiableEClass,
           source,
           new String[] {
               "documentation", "An identifiable element of the CPS domain has a unique identifier."
           });
        addAnnotation
          (getIdentifiable_Identifier(),
           source,
           new String[] {
               "documentation", "An identifier is used as both a user-facing name and an identifier for serialization. Must be unique."
           });
        addAnnotation
          (cyberPhysicalSystemEClass,
           source,
           new String[] {
               "documentation", "The cyber-physical system instance acts as a container of a cps model."
           });
        addAnnotation
          (applicationTypeEClass,
           source,
           new String[] {
               "documentation", "A descriptor for a class of applications."
           });
        addAnnotation
          (getApplicationType_ExeFileLocation(),
           source,
           new String[] {
               "documentation", "Where to look for the executable file."
           });
        addAnnotation
          (getApplicationType_ExeType(),
           source,
           new String[] {
               "documentation", "The type of the executable file."
           });
        addAnnotation
          (getApplicationType_Requirements(),
           source,
           new String[] {
               "documentation", "The resource requirements of the application are stored in this reference."
           });
        addAnnotation
          (getApplicationType_Cps(),
           source,
           new String[] {
               "documentation", "A reference to the container instance."
           });
        addAnnotation
          (getApplicationType_Instances(),
           source,
           new String[] {
               "documentation", "All known instances of this type."
           });
        addAnnotation
          (getApplicationType_Behavior(),
           source,
           new String[] {
               "documentation", "An optional state machine describing the behavior of the application."
           });
        addAnnotation
          (getApplicationType_ExeFileSize(),
           source,
           new String[] {
               "documentation", "The size of the executable in bytes."
           });
        addAnnotation
          (hostTypeEClass,
           source,
           new String[] {
               "documentation", "A class describing common properties of a set of hosts."
           });
        addAnnotation
          (getHostType_DefaultCpu(),
           source,
           new String[] {
               "documentation", "If a host instance does not set the total CPU attribute, this default value should be used instead."
           });
        addAnnotation
          (getHostType_DefaultRam(),
           source,
           new String[] {
               "documentation", "If a host instance does not set the total RAM attribute, this default value should be used instead."
           });
        addAnnotation
          (getHostType_DefaultHdd(),
           source,
           new String[] {
               "documentation", "If a host instance does not set the total HDD attribute, this default value should be used instead."
           });
        addAnnotation
          (getHostType_Cps(),
           source,
           new String[] {
               "documentation", "A reference to the container model."
           });
        addAnnotation
          (getHostType_Instances(),
           source,
           new String[] {
               "documentation", "A list to the instances of the selected host type."
           });
        addAnnotation
          (resourceRequirementEClass,
           source,
           new String[] {
               "documentation", "This class represents the requirements of a given application type."
           });
        addAnnotation
          (getResourceRequirement_RequiredCpu(),
           source,
           new String[] {
               "documentation", "This field stores the number of CPUs required in a non-negative number."
           });
        addAnnotation
          (getResourceRequirement_RequiredRam(),
           source,
           new String[] {
               "documentation", "This field stores the amount of RAM required in MB as a non-negative number."
           });
        addAnnotation
          (getResourceRequirement_RequiredHdd(),
           source,
           new String[] {
               "documentation", "This field stores the amount of persistent storage required in MB as a non-negative number."
           });
        addAnnotation
          (getResourceRequirement_Type(),
           source,
           new String[] {
               "documentation", "This field represents the required host type."
           });
        addAnnotation
          (hostInstanceEClass,
           source,
           new String[] {
               "documentation", "Represents a single host in the system"
           });
        addAnnotation
          (getHostInstance_NodeIp(),
           source,
           new String[] {
               "documentation", "The IP address of the given host instance. Must be unique."
           });
        addAnnotation
          (getHostInstance_AvailableCpu(),
           source,
           new String[] {
               "documentation", "The number of CPUs that are not bound for any applications."
           });
        addAnnotation
          (getHostInstance_AvailableRam(),
           source,
           new String[] {
               "documentation", "The amount of RAM not bound for any applications."
           });
        addAnnotation
          (getHostInstance_AvailableHdd(),
           source,
           new String[] {
               "documentation", "The amount of persistent storage not bound for any applications."
           });
        addAnnotation
          (getHostInstance_TotalCpu(),
           source,
           new String[] {
               "documentation", "The total number of CPUs available. If unspecified, the default value from the corresponding host type should be used."
           });
        addAnnotation
          (getHostInstance_TotalRam(),
           source,
           new String[] {
               "documentation", "The total amount of RAM available. If unspecified, the default value from the corresponding host type should be used."
           });
        addAnnotation
          (getHostInstance_TotalHdd(),
           source,
           new String[] {
               "documentation", "The total amount of persistent storage available. If unspecified, the default value from the corresponding host type should be used."
           });
        addAnnotation
          (getHostInstance_Applications(),
           source,
           new String[] {
               "documentation", "All application instances running on this host."
           });
        addAnnotation
          (getHostInstance_CommunicateWith(),
           source,
           new String[] {
               "documentation", "This reference enumerates host instances the current instance needs to communicate with."
           });
        addAnnotation
          (applicationInstanceEClass,
           source,
           new String[] {
               "documentation", "Represents an application instance."
           });
        addAnnotation
          (getApplicationInstance_State(),
           source,
           new String[] {
               "documentation", "Represents whether the application is running."
           });
        addAnnotation
          (getApplicationInstance_AllocatedTo(),
           source,
           new String[] {
               "documentation", "The host instances this application is running on."
           });
        addAnnotation
          (getApplicationInstance_DependOn(),
           source,
           new String[] {
               "documentation", "Other application instances the current one depends on."
           });
        addAnnotation
          (getApplicationInstance_Type(),
           source,
           new String[] {
               "documentation", "The type of the application."
           });
        addAnnotation
          (getApplicationInstance_Priority(),
           source,
           new String[] {
               "documentation", "The priority of the application; larger number means higher priority."
           });
        addAnnotation
          (appStateEEnum,
           source,
           new String[] {
               "documentation", "Represents whether an application is running."
           });
        addAnnotation
          (requirementEClass,
           source,
           new String[] {
               "documentation", "Represents a requested requirement."
           });
        addAnnotation
          (getRequirement_Count(),
           source,
           new String[] {
               "documentation", "The number of instances required."
           });
        addAnnotation
          (getRequirement_Type(),
           source,
           new String[] {
               "documentation", "The type of required application."
           });
        addAnnotation
          (getRequirement_Applications(),
           source,
           new String[] {
               "documentation", "The concrete application instances fulfilling the original requirement."
           });
        addAnnotation
          (stateMachineEClass,
           source,
           new String[] {
               "documentation", "A state machine is used to define the behavior of a given application type."
           });
        addAnnotation
          (getStateMachine_States(),
           source,
           new String[] {
               "documentation", "All states the state machine uses."
           });
        addAnnotation
          (getStateMachine_Initial(),
           source,
           new String[] {
               "documentation", "The specific initial state of the state machine; should be a member of the states reference as well."
           });
        addAnnotation
          (stateEClass,
           source,
           new String[] {
               "documentation", "A state of a state machine."
           });
        addAnnotation
          (getState_OutgoingTransitions(),
           source,
           new String[] {
               "documentation", "A list of all transitions starting from the current state."
           });
        addAnnotation
          (transitionEClass,
           source,
           new String[] {
               "documentation", "A transition in a state machine."
           });
        addAnnotation
          (getTransition_TargetState(),
           source,
           new String[] {
               "documentation", "The state this transition ends in."
           });
        addAnnotation
          (getTransition_Action(),
           source,
           new String[] {
               "documentation", "The action may specify either waiting for a signal with a given ID or sending a signal with a given ID to another application with a given type ID.\r\n- Use waitForSignal(signal) to specify waiting for signal\r\n- Use sendSignal(app, signal) to specify sending a signal to an app\r\n\r\nRestrictions:\r\n- Only one action is allowed in a transition\r\n- There can be only a single application instance for the given application type ID on host instances that the host on which the sending application instance is allocated to can communicate with."
           });
    }

} //CyberPhysicalSystemPackageImpl
