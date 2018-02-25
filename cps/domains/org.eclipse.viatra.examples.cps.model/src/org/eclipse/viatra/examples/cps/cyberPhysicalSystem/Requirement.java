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
 * A representation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Represents a requested requirement.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Requirement#getCount <em>Count</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Requirement#getRequest <em>Request</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Requirement#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Requirement#getApplications <em>Applications</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Requirement#isMandatory <em>Mandatory</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Requirement#getAvailablePorts <em>Available Ports</em>}</li>
 * </ul>
 *
 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage#getRequirement()
 * @model
 * @generated
 */
public interface Requirement extends Identifiable {
	/**
     * Returns the value of the '<em><b>Count</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The number of instances required.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Count</em>' attribute.
     * @see #setCount(int)
     * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage#getRequirement_Count()
     * @model
     * @generated
     */
	int getCount();

	/**
     * Sets the value of the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Requirement#getCount <em>Count</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Count</em>' attribute.
     * @see #getCount()
     * @generated
     */
	void setCount(int value);

	/**
     * Returns the value of the '<em><b>Request</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Request#getRequirements <em>Requirements</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Request</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Request</em>' container reference.
     * @see #setRequest(Request)
     * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage#getRequirement_Request()
     * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Request#getRequirements
     * @model opposite="requirements" required="true" transient="false"
     * @generated
     */
	Request getRequest();

	/**
     * Sets the value of the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Requirement#getRequest <em>Request</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Request</em>' container reference.
     * @see #getRequest()
     * @generated
     */
	void setRequest(Request value);

	/**
     * Returns the value of the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The type of required application.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Type</em>' reference.
     * @see #isSetType()
     * @see #unsetType()
     * @see #setType(ApplicationType)
     * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage#getRequirement_Type()
     * @model unsettable="true" required="true"
     * @generated
     */
	ApplicationType getType();

	/**
     * Sets the value of the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Requirement#getType <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' reference.
     * @see #isSetType()
     * @see #unsetType()
     * @see #getType()
     * @generated
     */
	void setType(ApplicationType value);

	/**
     * Unsets the value of the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Requirement#getType <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetType()
     * @see #getType()
     * @see #setType(ApplicationType)
     * @generated
     */
    void unsetType();

    /**
     * Returns whether the value of the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Requirement#getType <em>Type</em>}' reference is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Type</em>' reference is set.
     * @see #unsetType()
     * @see #getType()
     * @see #setType(ApplicationType)
     * @generated
     */
    boolean isSetType();

    /**
     * Returns the value of the '<em><b>Applications</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applications</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The concrete application instances fulfilling the original requirement.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Applications</em>' reference list.
     * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage#getRequirement_Applications()
     * @model
     * @generated
     */
	EList<ApplicationInstance> getApplications();

    /**
     * Returns the value of the '<em><b>Mandatory</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mandatory</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mandatory</em>' attribute.
     * @see #setMandatory(boolean)
     * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage#getRequirement_Mandatory()
     * @model default="true"
     * @generated
     */
    boolean isMandatory();

    /**
     * Sets the value of the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Requirement#isMandatory <em>Mandatory</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mandatory</em>' attribute.
     * @see #isMandatory()
     * @generated
     */
    void setMandatory(boolean value);

    /**
     * Returns the value of the '<em><b>Available Ports</b></em>' attribute list.
     * The list contents are of type {@link java.lang.Integer}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Available Ports</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Available Ports</em>' attribute list.
     * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage#getRequirement_AvailablePorts()
     * @model
     * @generated
     */
    EList<Integer> getAvailablePorts();

} // Requirement
