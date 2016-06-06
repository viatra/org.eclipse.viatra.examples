/**
 * Copyright (c) 2014-2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Tamas Borbas, Zoltan Ujhelyi - initial API and implementation
 */
package org.eclipse.viatra.examples.cps.traceability;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystem;

import org.eclipse.viatra.examples.cps.deployment.Deployment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CPS To Deployment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.viatra.examples.cps.traceability.CPSToDeployment#getCps <em>Cps</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.traceability.CPSToDeployment#getDeployment <em>Deployment</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.traceability.CPSToDeployment#getTraces <em>Traces</em>}</li>
 * </ul>
 *
 * @see org.eclipse.viatra.examples.cps.traceability.TraceabilityPackage#getCPSToDeployment()
 * @model
 * @generated
 */
public interface CPSToDeployment extends EObject {
	/**
	 * Returns the value of the '<em><b>Cps</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cps</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cps</em>' reference.
	 * @see #setCps(CyberPhysicalSystem)
	 * @see org.eclipse.viatra.examples.cps.traceability.TraceabilityPackage#getCPSToDeployment_Cps()
	 * @model
	 * @generated
	 */
	CyberPhysicalSystem getCps();

	/**
	 * Sets the value of the '{@link org.eclipse.viatra.examples.cps.traceability.CPSToDeployment#getCps <em>Cps</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cps</em>' reference.
	 * @see #getCps()
	 * @generated
	 */
	void setCps(CyberPhysicalSystem value);

	/**
	 * Returns the value of the '<em><b>Deployment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deployment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deployment</em>' reference.
	 * @see #setDeployment(Deployment)
	 * @see org.eclipse.viatra.examples.cps.traceability.TraceabilityPackage#getCPSToDeployment_Deployment()
	 * @model
	 * @generated
	 */
	Deployment getDeployment();

	/**
	 * Sets the value of the '{@link org.eclipse.viatra.examples.cps.traceability.CPSToDeployment#getDeployment <em>Deployment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deployment</em>' reference.
	 * @see #getDeployment()
	 * @generated
	 */
	void setDeployment(Deployment value);

	/**
	 * Returns the value of the '<em><b>Traces</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.viatra.examples.cps.traceability.CPS2DeploymentTrace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Traces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traces</em>' containment reference list.
	 * @see org.eclipse.viatra.examples.cps.traceability.TraceabilityPackage#getCPSToDeployment_Traces()
	 * @model containment="true"
	 * @generated
	 */
	EList<CPS2DeploymentTrace> getTraces();

} // CPSToDeployment
