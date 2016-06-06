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

import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Identifiable;

import org.eclipse.viatra.examples.cps.deployment.DeploymentElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CPS2 Deployment Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.viatra.examples.cps.traceability.CPS2DeploymentTrace#getCpsElements <em>Cps Elements</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.traceability.CPS2DeploymentTrace#getDeploymentElements <em>Deployment Elements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.viatra.examples.cps.traceability.TraceabilityPackage#getCPS2DeploymentTrace()
 * @model
 * @generated
 */
public interface CPS2DeploymentTrace extends EObject {
	/**
	 * Returns the value of the '<em><b>Cps Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Identifiable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cps Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cps Elements</em>' reference list.
	 * @see org.eclipse.viatra.examples.cps.traceability.TraceabilityPackage#getCPS2DeploymentTrace_CpsElements()
	 * @model
	 * @generated
	 */
	EList<Identifiable> getCpsElements();

	/**
	 * Returns the value of the '<em><b>Deployment Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.viatra.examples.cps.deployment.DeploymentElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deployment Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deployment Elements</em>' reference list.
	 * @see org.eclipse.viatra.examples.cps.traceability.TraceabilityPackage#getCPS2DeploymentTrace_DeploymentElements()
	 * @model
	 * @generated
	 */
	EList<DeploymentElement> getDeploymentElements();

} // CPS2DeploymentTrace
