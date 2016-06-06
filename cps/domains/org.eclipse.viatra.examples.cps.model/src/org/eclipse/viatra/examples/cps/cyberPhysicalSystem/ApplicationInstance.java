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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance#getState <em>State</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance#getDbUser <em>Db User</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance#getDbPassword <em>Db Password</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance#getAllocatedTo <em>Allocated To</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance#getDependOn <em>Depend On</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage#getApplicationInstance()
 * @model
 * @generated
 */
public interface ApplicationInstance extends Identifiable {
	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.AppState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.AppState
	 * @see #setState(AppState)
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage#getApplicationInstance_State()
	 * @model
	 * @generated
	 */
	AppState getState();

	/**
	 * Sets the value of the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.AppState
	 * @see #getState()
	 * @generated
	 */
	void setState(AppState value);

	/**
	 * Returns the value of the '<em><b>Db User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Db User</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Db User</em>' attribute.
	 * @see #setDbUser(String)
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage#getApplicationInstance_DbUser()
	 * @model
	 * @generated
	 */
	String getDbUser();

	/**
	 * Sets the value of the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance#getDbUser <em>Db User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Db User</em>' attribute.
	 * @see #getDbUser()
	 * @generated
	 */
	void setDbUser(String value);

	/**
	 * Returns the value of the '<em><b>Db Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Db Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Db Password</em>' attribute.
	 * @see #setDbPassword(String)
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage#getApplicationInstance_DbPassword()
	 * @model
	 * @generated
	 */
	String getDbPassword();

	/**
	 * Sets the value of the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance#getDbPassword <em>Db Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Db Password</em>' attribute.
	 * @see #getDbPassword()
	 * @generated
	 */
	void setDbPassword(String value);

	/**
	 * Returns the value of the '<em><b>Allocated To</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getApplications <em>Applications</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allocated To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocated To</em>' reference.
	 * @see #setAllocatedTo(HostInstance)
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage#getApplicationInstance_AllocatedTo()
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getApplications
	 * @model opposite="applications"
	 * @generated
	 */
	HostInstance getAllocatedTo();

	/**
	 * Sets the value of the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance#getAllocatedTo <em>Allocated To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allocated To</em>' reference.
	 * @see #getAllocatedTo()
	 * @generated
	 */
	void setAllocatedTo(HostInstance value);

	/**
	 * Returns the value of the '<em><b>Depend On</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depend On</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depend On</em>' reference list.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage#getApplicationInstance_DependOn()
	 * @model
	 * @generated
	 */
	EList<ApplicationInstance> getDependOn();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType#getInstances <em>Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' container reference.
	 * @see #setType(ApplicationType)
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage#getApplicationInstance_Type()
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType#getInstances
	 * @model opposite="instances" required="true" transient="false"
	 * @generated
	 */
	ApplicationType getType();

	/**
	 * Sets the value of the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance#getType <em>Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' container reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(ApplicationType value);

} // ApplicationInstance
