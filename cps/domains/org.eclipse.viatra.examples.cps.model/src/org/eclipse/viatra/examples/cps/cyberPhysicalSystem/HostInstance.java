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
 * A representation of the model object '<em><b>Host Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getNodeIp <em>Node Ip</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getAvailableCpu <em>Available Cpu</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getAvailableRam <em>Available Ram</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getAvailableHdd <em>Available Hdd</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getTotalCpu <em>Total Cpu</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getTotalRam <em>Total Ram</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getTotalHdd <em>Total Hdd</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getApplications <em>Applications</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getCommunicateWith <em>Communicate With</em>}</li>
 * </ul>
 *
 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage#getHostInstance()
 * @model
 * @generated
 */
public interface HostInstance extends Identifiable {
	/**
	 * Returns the value of the '<em><b>Node Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Ip</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Ip</em>' attribute.
	 * @see #setNodeIp(String)
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage#getHostInstance_NodeIp()
	 * @model
	 * @generated
	 */
	String getNodeIp();

	/**
	 * Sets the value of the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getNodeIp <em>Node Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Ip</em>' attribute.
	 * @see #getNodeIp()
	 * @generated
	 */
	void setNodeIp(String value);

	/**
	 * Returns the value of the '<em><b>Available Cpu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Available Cpu</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available Cpu</em>' attribute.
	 * @see #setAvailableCpu(int)
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage#getHostInstance_AvailableCpu()
	 * @model
	 * @generated
	 */
	int getAvailableCpu();

	/**
	 * Sets the value of the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getAvailableCpu <em>Available Cpu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Available Cpu</em>' attribute.
	 * @see #getAvailableCpu()
	 * @generated
	 */
	void setAvailableCpu(int value);

	/**
	 * Returns the value of the '<em><b>Available Ram</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Available Ram</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available Ram</em>' attribute.
	 * @see #setAvailableRam(int)
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage#getHostInstance_AvailableRam()
	 * @model
	 * @generated
	 */
	int getAvailableRam();

	/**
	 * Sets the value of the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getAvailableRam <em>Available Ram</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Available Ram</em>' attribute.
	 * @see #getAvailableRam()
	 * @generated
	 */
	void setAvailableRam(int value);

	/**
	 * Returns the value of the '<em><b>Available Hdd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Available Hdd</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available Hdd</em>' attribute.
	 * @see #setAvailableHdd(int)
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage#getHostInstance_AvailableHdd()
	 * @model
	 * @generated
	 */
	int getAvailableHdd();

	/**
	 * Sets the value of the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getAvailableHdd <em>Available Hdd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Available Hdd</em>' attribute.
	 * @see #getAvailableHdd()
	 * @generated
	 */
	void setAvailableHdd(int value);

	/**
	 * Returns the value of the '<em><b>Total Cpu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Cpu</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Cpu</em>' attribute.
	 * @see #setTotalCpu(int)
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage#getHostInstance_TotalCpu()
	 * @model
	 * @generated
	 */
	int getTotalCpu();

	/**
	 * Sets the value of the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getTotalCpu <em>Total Cpu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Cpu</em>' attribute.
	 * @see #getTotalCpu()
	 * @generated
	 */
	void setTotalCpu(int value);

	/**
	 * Returns the value of the '<em><b>Total Ram</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Ram</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Ram</em>' attribute.
	 * @see #setTotalRam(int)
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage#getHostInstance_TotalRam()
	 * @model
	 * @generated
	 */
	int getTotalRam();

	/**
	 * Sets the value of the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getTotalRam <em>Total Ram</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Ram</em>' attribute.
	 * @see #getTotalRam()
	 * @generated
	 */
	void setTotalRam(int value);

	/**
	 * Returns the value of the '<em><b>Total Hdd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Hdd</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Hdd</em>' attribute.
	 * @see #setTotalHdd(int)
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage#getHostInstance_TotalHdd()
	 * @model
	 * @generated
	 */
	int getTotalHdd();

	/**
	 * Sets the value of the '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance#getTotalHdd <em>Total Hdd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Hdd</em>' attribute.
	 * @see #getTotalHdd()
	 * @generated
	 */
	void setTotalHdd(int value);

	/**
	 * Returns the value of the '<em><b>Applications</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance#getAllocatedTo <em>Allocated To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applications</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applications</em>' reference list.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage#getHostInstance_Applications()
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance#getAllocatedTo
	 * @model opposite="allocatedTo"
	 * @generated
	 */
	EList<ApplicationInstance> getApplications();

	/**
	 * Returns the value of the '<em><b>Communicate With</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Communicate With</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Communicate With</em>' reference list.
	 * @see org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage#getHostInstance_CommunicateWith()
	 * @model
	 * @generated
	 */
	EList<HostInstance> getCommunicateWith();

} // HostInstance
