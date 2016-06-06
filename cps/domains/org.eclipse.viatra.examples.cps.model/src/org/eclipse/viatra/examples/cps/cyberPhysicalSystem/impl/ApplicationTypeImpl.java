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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystem;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ResourceRequirement;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.StateMachine;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.ApplicationTypeImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.ApplicationTypeImpl#getExeFileLocation <em>Exe File Location</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.ApplicationTypeImpl#getExeType <em>Exe Type</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.ApplicationTypeImpl#getZipFileUrl <em>Zip File Url</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.ApplicationTypeImpl#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.ApplicationTypeImpl#getCps <em>Cps</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.ApplicationTypeImpl#getInstances <em>Instances</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.ApplicationTypeImpl#getBehavior <em>Behavior</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ApplicationTypeImpl extends MinimalEObjectImpl.Container implements ApplicationType {
	/**
	 * The default value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String identifier = IDENTIFIER_EDEFAULT;

	/**
	 * The default value of the '{@link #getExeFileLocation() <em>Exe File Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExeFileLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String EXE_FILE_LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExeFileLocation() <em>Exe File Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExeFileLocation()
	 * @generated
	 * @ordered
	 */
	protected String exeFileLocation = EXE_FILE_LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getExeType() <em>Exe Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExeType()
	 * @generated
	 * @ordered
	 */
	protected static final String EXE_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExeType() <em>Exe Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExeType()
	 * @generated
	 * @ordered
	 */
	protected String exeType = EXE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getZipFileUrl() <em>Zip File Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZipFileUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String ZIP_FILE_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getZipFileUrl() <em>Zip File Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZipFileUrl()
	 * @generated
	 * @ordered
	 */
	protected String zipFileUrl = ZIP_FILE_URL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRequirements() <em>Requirements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceRequirement> requirements;

	/**
	 * The cached value of the '{@link #getInstances() <em>Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<ApplicationInstance> instances;

	/**
	 * The cached value of the '{@link #getBehavior() <em>Behavior</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehavior()
	 * @generated
	 * @ordered
	 */
	protected StateMachine behavior;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicationTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CyberPhysicalSystemPackage.Literals.APPLICATION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(String newIdentifier) {
		String oldIdentifier = identifier;
		identifier = newIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CyberPhysicalSystemPackage.APPLICATION_TYPE__IDENTIFIER, oldIdentifier, identifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExeFileLocation() {
		return exeFileLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExeFileLocation(String newExeFileLocation) {
		String oldExeFileLocation = exeFileLocation;
		exeFileLocation = newExeFileLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CyberPhysicalSystemPackage.APPLICATION_TYPE__EXE_FILE_LOCATION, oldExeFileLocation, exeFileLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExeType() {
		return exeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExeType(String newExeType) {
		String oldExeType = exeType;
		exeType = newExeType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CyberPhysicalSystemPackage.APPLICATION_TYPE__EXE_TYPE, oldExeType, exeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getZipFileUrl() {
		return zipFileUrl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZipFileUrl(String newZipFileUrl) {
		String oldZipFileUrl = zipFileUrl;
		zipFileUrl = newZipFileUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CyberPhysicalSystemPackage.APPLICATION_TYPE__ZIP_FILE_URL, oldZipFileUrl, zipFileUrl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceRequirement> getRequirements() {
		if (requirements == null) {
			requirements = new EObjectContainmentEList<ResourceRequirement>(ResourceRequirement.class, this, CyberPhysicalSystemPackage.APPLICATION_TYPE__REQUIREMENTS);
		}
		return requirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CyberPhysicalSystem getCps() {
		if (eContainerFeatureID() != CyberPhysicalSystemPackage.APPLICATION_TYPE__CPS) return null;
		return (CyberPhysicalSystem)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCps(CyberPhysicalSystem newCps, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCps, CyberPhysicalSystemPackage.APPLICATION_TYPE__CPS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCps(CyberPhysicalSystem newCps) {
		if (newCps != eInternalContainer() || (eContainerFeatureID() != CyberPhysicalSystemPackage.APPLICATION_TYPE__CPS && newCps != null)) {
			if (EcoreUtil.isAncestor(this, newCps))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCps != null)
				msgs = ((InternalEObject)newCps).eInverseAdd(this, CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__APP_TYPES, CyberPhysicalSystem.class, msgs);
			msgs = basicSetCps(newCps, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CyberPhysicalSystemPackage.APPLICATION_TYPE__CPS, newCps, newCps));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ApplicationInstance> getInstances() {
		if (instances == null) {
			instances = new EObjectContainmentWithInverseEList<ApplicationInstance>(ApplicationInstance.class, this, CyberPhysicalSystemPackage.APPLICATION_TYPE__INSTANCES, CyberPhysicalSystemPackage.APPLICATION_INSTANCE__TYPE);
		}
		return instances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachine getBehavior() {
		return behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBehavior(StateMachine newBehavior, NotificationChain msgs) {
		StateMachine oldBehavior = behavior;
		behavior = newBehavior;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CyberPhysicalSystemPackage.APPLICATION_TYPE__BEHAVIOR, oldBehavior, newBehavior);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBehavior(StateMachine newBehavior) {
		if (newBehavior != behavior) {
			NotificationChain msgs = null;
			if (behavior != null)
				msgs = ((InternalEObject)behavior).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CyberPhysicalSystemPackage.APPLICATION_TYPE__BEHAVIOR, null, msgs);
			if (newBehavior != null)
				msgs = ((InternalEObject)newBehavior).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CyberPhysicalSystemPackage.APPLICATION_TYPE__BEHAVIOR, null, msgs);
			msgs = basicSetBehavior(newBehavior, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CyberPhysicalSystemPackage.APPLICATION_TYPE__BEHAVIOR, newBehavior, newBehavior));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__CPS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCps((CyberPhysicalSystem)otherEnd, msgs);
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__INSTANCES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInstances()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__REQUIREMENTS:
				return ((InternalEList<?>)getRequirements()).basicRemove(otherEnd, msgs);
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__CPS:
				return basicSetCps(null, msgs);
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__INSTANCES:
				return ((InternalEList<?>)getInstances()).basicRemove(otherEnd, msgs);
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__BEHAVIOR:
				return basicSetBehavior(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__CPS:
				return eInternalContainer().eInverseRemove(this, CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__APP_TYPES, CyberPhysicalSystem.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__IDENTIFIER:
				return getIdentifier();
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__EXE_FILE_LOCATION:
				return getExeFileLocation();
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__EXE_TYPE:
				return getExeType();
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__ZIP_FILE_URL:
				return getZipFileUrl();
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__REQUIREMENTS:
				return getRequirements();
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__CPS:
				return getCps();
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__INSTANCES:
				return getInstances();
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__BEHAVIOR:
				return getBehavior();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__IDENTIFIER:
				setIdentifier((String)newValue);
				return;
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__EXE_FILE_LOCATION:
				setExeFileLocation((String)newValue);
				return;
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__EXE_TYPE:
				setExeType((String)newValue);
				return;
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__ZIP_FILE_URL:
				setZipFileUrl((String)newValue);
				return;
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__REQUIREMENTS:
				getRequirements().clear();
				getRequirements().addAll((Collection<? extends ResourceRequirement>)newValue);
				return;
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__CPS:
				setCps((CyberPhysicalSystem)newValue);
				return;
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__INSTANCES:
				getInstances().clear();
				getInstances().addAll((Collection<? extends ApplicationInstance>)newValue);
				return;
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__BEHAVIOR:
				setBehavior((StateMachine)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__IDENTIFIER:
				setIdentifier(IDENTIFIER_EDEFAULT);
				return;
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__EXE_FILE_LOCATION:
				setExeFileLocation(EXE_FILE_LOCATION_EDEFAULT);
				return;
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__EXE_TYPE:
				setExeType(EXE_TYPE_EDEFAULT);
				return;
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__ZIP_FILE_URL:
				setZipFileUrl(ZIP_FILE_URL_EDEFAULT);
				return;
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__REQUIREMENTS:
				getRequirements().clear();
				return;
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__CPS:
				setCps((CyberPhysicalSystem)null);
				return;
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__INSTANCES:
				getInstances().clear();
				return;
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__BEHAVIOR:
				setBehavior((StateMachine)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__IDENTIFIER:
				return IDENTIFIER_EDEFAULT == null ? identifier != null : !IDENTIFIER_EDEFAULT.equals(identifier);
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__EXE_FILE_LOCATION:
				return EXE_FILE_LOCATION_EDEFAULT == null ? exeFileLocation != null : !EXE_FILE_LOCATION_EDEFAULT.equals(exeFileLocation);
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__EXE_TYPE:
				return EXE_TYPE_EDEFAULT == null ? exeType != null : !EXE_TYPE_EDEFAULT.equals(exeType);
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__ZIP_FILE_URL:
				return ZIP_FILE_URL_EDEFAULT == null ? zipFileUrl != null : !ZIP_FILE_URL_EDEFAULT.equals(zipFileUrl);
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__REQUIREMENTS:
				return requirements != null && !requirements.isEmpty();
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__CPS:
				return getCps() != null;
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__INSTANCES:
				return instances != null && !instances.isEmpty();
			case CyberPhysicalSystemPackage.APPLICATION_TYPE__BEHAVIOR:
				return behavior != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (identifier: ");
		result.append(identifier);
		result.append(", exeFileLocation: ");
		result.append(exeFileLocation);
		result.append(", exeType: ");
		result.append(exeType);
		result.append(", zipFileUrl: ");
		result.append(zipFileUrl);
		result.append(')');
		return result.toString();
	}

} //ApplicationTypeImpl
