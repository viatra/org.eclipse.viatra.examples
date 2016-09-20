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
package org.eclipse.viatra.examples.cps.cyberPhysicalSystem;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore settingDelegates='org.eclipse.viatra.query.querybasedfeature'"
 * @generated
 */
public interface CyberPhysicalSystemPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cyberPhysicalSystem";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.eclipse.viatra/model/cps";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cps";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CyberPhysicalSystemPackage eINSTANCE = org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Identifiable <em>Identifiable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Identifiable
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemPackageImpl#getIdentifiable()
	 * @generated
	 */
	int IDENTIFIABLE = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE__IDENTIFIER = 0;

	/**
	 * The number of structural features of the '<em>Identifiable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Identifiable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemImpl <em>Cyber Physical System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemImpl
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemPackageImpl#getCyberPhysicalSystem()
	 * @generated
	 */
	int CYBER_PHYSICAL_SYSTEM = 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYBER_PHYSICAL_SYSTEM__IDENTIFIER = IDENTIFIABLE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Db Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYBER_PHYSICAL_SYSTEM__DB_URL = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>App Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYBER_PHYSICAL_SYSTEM__APP_TYPES = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Requests</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYBER_PHYSICAL_SYSTEM__REQUESTS = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Host Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYBER_PHYSICAL_SYSTEM__HOST_TYPES = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Cyber Physical System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYBER_PHYSICAL_SYSTEM_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Cyber Physical System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYBER_PHYSICAL_SYSTEM_OPERATION_COUNT = IDENTIFIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.ApplicationTypeImpl <em>Application Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.ApplicationTypeImpl
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemPackageImpl#getApplicationType()
	 * @generated
	 */
	int APPLICATION_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_TYPE__IDENTIFIER = IDENTIFIABLE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Exe File Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_TYPE__EXE_FILE_LOCATION = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Exe Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_TYPE__EXE_TYPE = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Zip File Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_TYPE__ZIP_FILE_URL = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_TYPE__REQUIREMENTS = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Cps</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_TYPE__CPS = IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_TYPE__INSTANCES = IDENTIFIABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_TYPE__BEHAVIOR = IDENTIFIABLE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Application Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_TYPE_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Application Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_TYPE_OPERATION_COUNT = IDENTIFIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.HostTypeImpl <em>Host Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.HostTypeImpl
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemPackageImpl#getHostType()
	 * @generated
	 */
	int HOST_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST_TYPE__IDENTIFIER = IDENTIFIABLE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Default Cpu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST_TYPE__DEFAULT_CPU = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Default Ram</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST_TYPE__DEFAULT_RAM = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Default Hdd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST_TYPE__DEFAULT_HDD = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Cps</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST_TYPE__CPS = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST_TYPE__INSTANCES = IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Host Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST_TYPE_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Host Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST_TYPE_OPERATION_COUNT = IDENTIFIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.ResourceRequirementImpl <em>Resource Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.ResourceRequirementImpl
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemPackageImpl#getResourceRequirement()
	 * @generated
	 */
	int RESOURCE_REQUIREMENT = 4;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIREMENT__IDENTIFIER = IDENTIFIABLE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Required Cpu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIREMENT__REQUIRED_CPU = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Required Ram</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIREMENT__REQUIRED_RAM = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Required Hdd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIREMENT__REQUIRED_HDD = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIREMENT__TYPE = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Resource Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIREMENT_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Resource Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIREMENT_OPERATION_COUNT = IDENTIFIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.HostInstanceImpl <em>Host Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.HostInstanceImpl
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemPackageImpl#getHostInstance()
	 * @generated
	 */
	int HOST_INSTANCE = 5;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST_INSTANCE__IDENTIFIER = IDENTIFIABLE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Node Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST_INSTANCE__NODE_IP = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Available Cpu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST_INSTANCE__AVAILABLE_CPU = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Available Ram</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST_INSTANCE__AVAILABLE_RAM = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Available Hdd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST_INSTANCE__AVAILABLE_HDD = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Total Cpu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST_INSTANCE__TOTAL_CPU = IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Total Ram</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST_INSTANCE__TOTAL_RAM = IDENTIFIABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Total Hdd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST_INSTANCE__TOTAL_HDD = IDENTIFIABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Applications</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST_INSTANCE__APPLICATIONS = IDENTIFIABLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Communicate With</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST_INSTANCE__COMMUNICATE_WITH = IDENTIFIABLE_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Host Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST_INSTANCE_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 9;

	/**
	 * The number of operations of the '<em>Host Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST_INSTANCE_OPERATION_COUNT = IDENTIFIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.ApplicationInstanceImpl <em>Application Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.ApplicationInstanceImpl
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemPackageImpl#getApplicationInstance()
	 * @generated
	 */
	int APPLICATION_INSTANCE = 6;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_INSTANCE__IDENTIFIER = IDENTIFIABLE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_INSTANCE__STATE = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Db User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_INSTANCE__DB_USER = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Db Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_INSTANCE__DB_PASSWORD = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Allocated To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_INSTANCE__ALLOCATED_TO = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Depend On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_INSTANCE__DEPEND_ON = IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_INSTANCE__TYPE = IDENTIFIABLE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Application Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_INSTANCE_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Application Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_INSTANCE_OPERATION_COUNT = IDENTIFIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.RequestImpl <em>Request</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.RequestImpl
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemPackageImpl#getRequest()
	 * @generated
	 */
	int REQUEST = 7;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__IDENTIFIER = IDENTIFIABLE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__REQUIREMENTS = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_OPERATION_COUNT = IDENTIFIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.RequirementImpl <em>Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.RequirementImpl
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemPackageImpl#getRequirement()
	 * @generated
	 */
	int REQUIREMENT = 8;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__IDENTIFIER = IDENTIFIABLE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__COUNT = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Request</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REQUEST = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__TYPE = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Applications</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__APPLICATIONS = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_OPERATION_COUNT = IDENTIFIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.StateMachineImpl <em>State Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.StateMachineImpl
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemPackageImpl#getStateMachine()
	 * @generated
	 */
	int STATE_MACHINE = 9;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__IDENTIFIER = IDENTIFIABLE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__STATES = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initial</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__INITIAL = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>State Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>State Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_OPERATION_COUNT = IDENTIFIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.StateImpl
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemPackageImpl#getState()
	 * @generated
	 */
	int STATE = 10;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__IDENTIFIER = IDENTIFIABLE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OUTGOING_TRANSITIONS = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_OPERATION_COUNT = IDENTIFIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.TransitionImpl
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 11;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__IDENTIFIER = IDENTIFIABLE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Target State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TARGET_STATE = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__ACTION = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_OPERATION_COUNT = IDENTIFIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.AppState <em>App State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.AppState
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemPackageImpl#getAppState()
	 * @generated
	 */
	int APP_STATE = 12;


	/**
	 * Returns the meta object for class '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Identifiable <em>Identifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifiable</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Identifiable
	 * @generated
	 */
	EClass getIdentifiable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Identifiable#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Identifiable#getIdentifier()
	 * @see #getIdentifiable()
	 * @generated
	 */
	EAttribute getIdentifiable_Identifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystem <em>Cyber Physical System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cyber Physical System</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystem
	 * @generated
	 */
	EClass getCyberPhysicalSystem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystem#getDbUrl <em>Db Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Db Url</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystem#getDbUrl()
	 * @see #getCyberPhysicalSystem()
	 * @generated
	 */
	EAttribute getCyberPhysicalSystem_DbUrl();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystem#getAppTypes <em>App Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>App Types</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystem#getAppTypes()
	 * @see #getCyberPhysicalSystem()
	 * @generated
	 */
	EReference getCyberPhysicalSystem_AppTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystem#getRequests <em>Requests</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Requests</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystem#getRequests()
	 * @see #getCyberPhysicalSystem()
	 * @generated
	 */
	EReference getCyberPhysicalSystem_Requests();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystem#getHostTypes <em>Host Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Host Types</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystem#getHostTypes()
	 * @see #getCyberPhysicalSystem()
	 * @generated
	 */
	EReference getCyberPhysicalSystem_HostTypes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType <em>Application Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application Type</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType
	 * @generated
	 */
	EClass getApplicationType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType#getExeFileLocation <em>Exe File Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exe File Location</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType#getExeFileLocation()
	 * @see #getApplicationType()
	 * @generated
	 */
	EAttribute getApplicationType_ExeFileLocation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType#getExeType <em>Exe Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exe Type</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType#getExeType()
	 * @see #getApplicationType()
	 * @generated
	 */
	EAttribute getApplicationType_ExeType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType#getZipFileUrl <em>Zip File Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Zip File Url</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType#getZipFileUrl()
	 * @see #getApplicationType()
	 * @generated
	 */
	EAttribute getApplicationType_ZipFileUrl();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType#getRequirements <em>Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Requirements</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType#getRequirements()
	 * @see #getApplicationType()
	 * @generated
	 */
	EReference getApplicationType_Requirements();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType#getCps <em>Cps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Cps</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType#getCps()
	 * @see #getApplicationType()
	 * @generated
	 */
	EReference getApplicationType_Cps();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType#getInstances <em>Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instances</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType#getInstances()
	 * @see #getApplicationType()
	 * @generated
	 */
	EReference getApplicationType_Instances();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType#getBehavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Behavior</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType#getBehavior()
	 * @see #getApplicationType()
	 * @generated
	 */
	EReference getApplicationType_Behavior();

	/**
	 * Returns the meta object for class '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostType <em>Host Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Host Type</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostType
	 * @generated
	 */
	EClass getHostType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostType#getDefaultCpu <em>Default Cpu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Cpu</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostType#getDefaultCpu()
	 * @see #getHostType()
	 * @generated
	 */
	EAttribute getHostType_DefaultCpu();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostType#getDefaultRam <em>Default Ram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Ram</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostType#getDefaultRam()
	 * @see #getHostType()
	 * @generated
	 */
	EAttribute getHostType_DefaultRam();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostType#getDefaultHdd <em>Default Hdd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Hdd</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostType#getDefaultHdd()
	 * @see #getHostType()
	 * @generated
	 */
	EAttribute getHostType_DefaultHdd();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostType#getCps <em>Cps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Cps</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostType#getCps()
	 * @see #getHostType()
	 * @generated
	 */
	EReference getHostType_Cps();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostType#getInstances <em>Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instances</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostType#getInstances()
	 * @see #getHostType()
	 * @generated
	 */
	EReference getHostType_Instances();

	/**
	 * Returns the meta object for class '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ResourceRequirement <em>Resource Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Requirement</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ResourceRequirement
	 * @generated
	 */
	EClass getResourceRequirement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ResourceRequirement#getRequiredCpu <em>Required Cpu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required Cpu</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ResourceRequirement#getRequiredCpu()
	 * @see #getResourceRequirement()
	 * @generated
	 */
	EAttribute getResourceRequirement_RequiredCpu();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ResourceRequirement#getRequiredRam <em>Required Ram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required Ram</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ResourceRequirement#getRequiredRam()
	 * @see #getResourceRequirement()
	 * @generated
	 */
	EAttribute getResourceRequirement_RequiredRam();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ResourceRequirement#getRequiredHdd <em>Required Hdd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required Hdd</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ResourceRequirement#getRequiredHdd()
	 * @see #getResourceRequirement()
	 * @generated
	 */
	EAttribute getResourceRequirement_RequiredHdd();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ResourceRequirement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ResourceRequirement#getType()
	 * @see #getResourceRequirement()
	 * @generated
	 */
	EReference getResourceRequirement_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance <em>Host Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Host Instance</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance
	 * @generated
	 */
	EClass getHostInstance();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getNodeIp <em>Node Ip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node Ip</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getNodeIp()
	 * @see #getHostInstance()
	 * @generated
	 */
	EAttribute getHostInstance_NodeIp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getAvailableCpu <em>Available Cpu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Available Cpu</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getAvailableCpu()
	 * @see #getHostInstance()
	 * @generated
	 */
	EAttribute getHostInstance_AvailableCpu();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getAvailableRam <em>Available Ram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Available Ram</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getAvailableRam()
	 * @see #getHostInstance()
	 * @generated
	 */
	EAttribute getHostInstance_AvailableRam();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getAvailableHdd <em>Available Hdd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Available Hdd</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getAvailableHdd()
	 * @see #getHostInstance()
	 * @generated
	 */
	EAttribute getHostInstance_AvailableHdd();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getTotalCpu <em>Total Cpu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Cpu</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getTotalCpu()
	 * @see #getHostInstance()
	 * @generated
	 */
	EAttribute getHostInstance_TotalCpu();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getTotalRam <em>Total Ram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Ram</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getTotalRam()
	 * @see #getHostInstance()
	 * @generated
	 */
	EAttribute getHostInstance_TotalRam();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getTotalHdd <em>Total Hdd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Hdd</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getTotalHdd()
	 * @see #getHostInstance()
	 * @generated
	 */
	EAttribute getHostInstance_TotalHdd();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getApplications <em>Applications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Applications</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getApplications()
	 * @see #getHostInstance()
	 * @generated
	 */
	EReference getHostInstance_Applications();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getCommunicateWith <em>Communicate With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Communicate With</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getCommunicateWith()
	 * @see #getHostInstance()
	 * @generated
	 */
	EReference getHostInstance_CommunicateWith();

	/**
	 * Returns the meta object for class '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance <em>Application Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application Instance</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance
	 * @generated
	 */
	EClass getApplicationInstance();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance#getState()
	 * @see #getApplicationInstance()
	 * @generated
	 */
	EAttribute getApplicationInstance_State();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance#getDbUser <em>Db User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Db User</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance#getDbUser()
	 * @see #getApplicationInstance()
	 * @generated
	 */
	EAttribute getApplicationInstance_DbUser();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance#getDbPassword <em>Db Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Db Password</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance#getDbPassword()
	 * @see #getApplicationInstance()
	 * @generated
	 */
	EAttribute getApplicationInstance_DbPassword();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance#getAllocatedTo <em>Allocated To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Allocated To</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance#getAllocatedTo()
	 * @see #getApplicationInstance()
	 * @generated
	 */
	EReference getApplicationInstance_AllocatedTo();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance#getDependOn <em>Depend On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Depend On</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance#getDependOn()
	 * @see #getApplicationInstance()
	 * @generated
	 */
	EReference getApplicationInstance_DependOn();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Type</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance#getType()
	 * @see #getApplicationInstance()
	 * @generated
	 */
	EReference getApplicationInstance_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Request <em>Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Request</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Request
	 * @generated
	 */
	EClass getRequest();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Request#getRequirements <em>Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Requirements</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Request#getRequirements()
	 * @see #getRequest()
	 * @generated
	 */
	EReference getRequest_Requirements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Requirement
	 * @generated
	 */
	EClass getRequirement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Requirement#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Requirement#getCount()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_Count();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Requirement#getRequest <em>Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Request</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Requirement#getRequest()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_Request();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Requirement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Requirement#getType()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_Type();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Requirement#getApplications <em>Applications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Applications</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Requirement#getApplications()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_Applications();

	/**
	 * Returns the meta object for class '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.StateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Machine</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.StateMachine
	 * @generated
	 */
	EClass getStateMachine();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.StateMachine#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.StateMachine#getStates()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_States();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.StateMachine#getInitial <em>Initial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initial</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.StateMachine#getInitial()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_Initial();

	/**
	 * Returns the meta object for class '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.State#getOutgoingTransitions <em>Outgoing Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outgoing Transitions</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.State#getOutgoingTransitions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_OutgoingTransitions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition#getTargetState <em>Target State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target State</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition#getTargetState()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_TargetState();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition#getAction()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Action();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.AppState <em>App State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>App State</em>'.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.AppState
	 * @generated
	 */
	EEnum getAppState();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CyberPhysicalSystemFactory getCyberPhysicalSystemFactory();

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
		 * The meta object literal for the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Identifiable <em>Identifiable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Identifiable
		 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemPackageImpl#getIdentifiable()
		 * @generated
		 */
		EClass IDENTIFIABLE = eINSTANCE.getIdentifiable();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIABLE__IDENTIFIER = eINSTANCE.getIdentifiable_Identifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemImpl <em>Cyber Physical System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemImpl
		 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemPackageImpl#getCyberPhysicalSystem()
		 * @generated
		 */
		EClass CYBER_PHYSICAL_SYSTEM = eINSTANCE.getCyberPhysicalSystem();

		/**
		 * The meta object literal for the '<em><b>Db Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CYBER_PHYSICAL_SYSTEM__DB_URL = eINSTANCE.getCyberPhysicalSystem_DbUrl();

		/**
		 * The meta object literal for the '<em><b>App Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CYBER_PHYSICAL_SYSTEM__APP_TYPES = eINSTANCE.getCyberPhysicalSystem_AppTypes();

		/**
		 * The meta object literal for the '<em><b>Requests</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CYBER_PHYSICAL_SYSTEM__REQUESTS = eINSTANCE.getCyberPhysicalSystem_Requests();

		/**
		 * The meta object literal for the '<em><b>Host Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CYBER_PHYSICAL_SYSTEM__HOST_TYPES = eINSTANCE.getCyberPhysicalSystem_HostTypes();

		/**
		 * The meta object literal for the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.ApplicationTypeImpl <em>Application Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.ApplicationTypeImpl
		 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemPackageImpl#getApplicationType()
		 * @generated
		 */
		EClass APPLICATION_TYPE = eINSTANCE.getApplicationType();

		/**
		 * The meta object literal for the '<em><b>Exe File Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_TYPE__EXE_FILE_LOCATION = eINSTANCE.getApplicationType_ExeFileLocation();

		/**
		 * The meta object literal for the '<em><b>Exe Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_TYPE__EXE_TYPE = eINSTANCE.getApplicationType_ExeType();

		/**
		 * The meta object literal for the '<em><b>Zip File Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_TYPE__ZIP_FILE_URL = eINSTANCE.getApplicationType_ZipFileUrl();

		/**
		 * The meta object literal for the '<em><b>Requirements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_TYPE__REQUIREMENTS = eINSTANCE.getApplicationType_Requirements();

		/**
		 * The meta object literal for the '<em><b>Cps</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_TYPE__CPS = eINSTANCE.getApplicationType_Cps();

		/**
		 * The meta object literal for the '<em><b>Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_TYPE__INSTANCES = eINSTANCE.getApplicationType_Instances();

		/**
		 * The meta object literal for the '<em><b>Behavior</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_TYPE__BEHAVIOR = eINSTANCE.getApplicationType_Behavior();

		/**
		 * The meta object literal for the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.HostTypeImpl <em>Host Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.HostTypeImpl
		 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemPackageImpl#getHostType()
		 * @generated
		 */
		EClass HOST_TYPE = eINSTANCE.getHostType();

		/**
		 * The meta object literal for the '<em><b>Default Cpu</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOST_TYPE__DEFAULT_CPU = eINSTANCE.getHostType_DefaultCpu();

		/**
		 * The meta object literal for the '<em><b>Default Ram</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOST_TYPE__DEFAULT_RAM = eINSTANCE.getHostType_DefaultRam();

		/**
		 * The meta object literal for the '<em><b>Default Hdd</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOST_TYPE__DEFAULT_HDD = eINSTANCE.getHostType_DefaultHdd();

		/**
		 * The meta object literal for the '<em><b>Cps</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HOST_TYPE__CPS = eINSTANCE.getHostType_Cps();

		/**
		 * The meta object literal for the '<em><b>Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HOST_TYPE__INSTANCES = eINSTANCE.getHostType_Instances();

		/**
		 * The meta object literal for the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.ResourceRequirementImpl <em>Resource Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.ResourceRequirementImpl
		 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemPackageImpl#getResourceRequirement()
		 * @generated
		 */
		EClass RESOURCE_REQUIREMENT = eINSTANCE.getResourceRequirement();

		/**
		 * The meta object literal for the '<em><b>Required Cpu</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_REQUIREMENT__REQUIRED_CPU = eINSTANCE.getResourceRequirement_RequiredCpu();

		/**
		 * The meta object literal for the '<em><b>Required Ram</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_REQUIREMENT__REQUIRED_RAM = eINSTANCE.getResourceRequirement_RequiredRam();

		/**
		 * The meta object literal for the '<em><b>Required Hdd</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_REQUIREMENT__REQUIRED_HDD = eINSTANCE.getResourceRequirement_RequiredHdd();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_REQUIREMENT__TYPE = eINSTANCE.getResourceRequirement_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.HostInstanceImpl <em>Host Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.HostInstanceImpl
		 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemPackageImpl#getHostInstance()
		 * @generated
		 */
		EClass HOST_INSTANCE = eINSTANCE.getHostInstance();

		/**
		 * The meta object literal for the '<em><b>Node Ip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOST_INSTANCE__NODE_IP = eINSTANCE.getHostInstance_NodeIp();

		/**
		 * The meta object literal for the '<em><b>Available Cpu</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOST_INSTANCE__AVAILABLE_CPU = eINSTANCE.getHostInstance_AvailableCpu();

		/**
		 * The meta object literal for the '<em><b>Available Ram</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOST_INSTANCE__AVAILABLE_RAM = eINSTANCE.getHostInstance_AvailableRam();

		/**
		 * The meta object literal for the '<em><b>Available Hdd</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOST_INSTANCE__AVAILABLE_HDD = eINSTANCE.getHostInstance_AvailableHdd();

		/**
		 * The meta object literal for the '<em><b>Total Cpu</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOST_INSTANCE__TOTAL_CPU = eINSTANCE.getHostInstance_TotalCpu();

		/**
		 * The meta object literal for the '<em><b>Total Ram</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOST_INSTANCE__TOTAL_RAM = eINSTANCE.getHostInstance_TotalRam();

		/**
		 * The meta object literal for the '<em><b>Total Hdd</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOST_INSTANCE__TOTAL_HDD = eINSTANCE.getHostInstance_TotalHdd();

		/**
		 * The meta object literal for the '<em><b>Applications</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HOST_INSTANCE__APPLICATIONS = eINSTANCE.getHostInstance_Applications();

		/**
		 * The meta object literal for the '<em><b>Communicate With</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HOST_INSTANCE__COMMUNICATE_WITH = eINSTANCE.getHostInstance_CommunicateWith();

		/**
		 * The meta object literal for the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.ApplicationInstanceImpl <em>Application Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.ApplicationInstanceImpl
		 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemPackageImpl#getApplicationInstance()
		 * @generated
		 */
		EClass APPLICATION_INSTANCE = eINSTANCE.getApplicationInstance();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_INSTANCE__STATE = eINSTANCE.getApplicationInstance_State();

		/**
		 * The meta object literal for the '<em><b>Db User</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_INSTANCE__DB_USER = eINSTANCE.getApplicationInstance_DbUser();

		/**
		 * The meta object literal for the '<em><b>Db Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_INSTANCE__DB_PASSWORD = eINSTANCE.getApplicationInstance_DbPassword();

		/**
		 * The meta object literal for the '<em><b>Allocated To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_INSTANCE__ALLOCATED_TO = eINSTANCE.getApplicationInstance_AllocatedTo();

		/**
		 * The meta object literal for the '<em><b>Depend On</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_INSTANCE__DEPEND_ON = eINSTANCE.getApplicationInstance_DependOn();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_INSTANCE__TYPE = eINSTANCE.getApplicationInstance_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.RequestImpl <em>Request</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.RequestImpl
		 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemPackageImpl#getRequest()
		 * @generated
		 */
		EClass REQUEST = eINSTANCE.getRequest();

		/**
		 * The meta object literal for the '<em><b>Requirements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUEST__REQUIREMENTS = eINSTANCE.getRequest_Requirements();

		/**
		 * The meta object literal for the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.RequirementImpl <em>Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.RequirementImpl
		 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemPackageImpl#getRequirement()
		 * @generated
		 */
		EClass REQUIREMENT = eINSTANCE.getRequirement();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__COUNT = eINSTANCE.getRequirement_Count();

		/**
		 * The meta object literal for the '<em><b>Request</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__REQUEST = eINSTANCE.getRequirement_Request();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__TYPE = eINSTANCE.getRequirement_Type();

		/**
		 * The meta object literal for the '<em><b>Applications</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__APPLICATIONS = eINSTANCE.getRequirement_Applications();

		/**
		 * The meta object literal for the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.StateMachineImpl <em>State Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.StateMachineImpl
		 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemPackageImpl#getStateMachine()
		 * @generated
		 */
		EClass STATE_MACHINE = eINSTANCE.getStateMachine();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE__STATES = eINSTANCE.getStateMachine_States();

		/**
		 * The meta object literal for the '<em><b>Initial</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE__INITIAL = eINSTANCE.getStateMachine_Initial();

		/**
		 * The meta object literal for the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.StateImpl
		 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Outgoing Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__OUTGOING_TRANSITIONS = eINSTANCE.getState_OutgoingTransitions();

		/**
		 * The meta object literal for the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.TransitionImpl
		 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Target State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__TARGET_STATE = eINSTANCE.getTransition_TargetState();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__ACTION = eINSTANCE.getTransition_Action();

		/**
		 * The meta object literal for the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.AppState <em>App State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.AppState
		 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemPackageImpl#getAppState()
		 * @generated
		 */
		EEnum APP_STATE = eINSTANCE.getAppState();

	}

} //CyberPhysicalSystemPackage
