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

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.AppState;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.ApplicationInstanceImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.ApplicationInstanceImpl#getState <em>State</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.ApplicationInstanceImpl#getDbUser <em>Db User</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.ApplicationInstanceImpl#getDbPassword <em>Db Password</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.ApplicationInstanceImpl#getAllocatedTo <em>Allocated To</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.ApplicationInstanceImpl#getDependOn <em>Depend On</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.ApplicationInstanceImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ApplicationInstanceImpl extends MinimalEObjectImpl.Container implements ApplicationInstance {
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
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final AppState STATE_EDEFAULT = AppState.RUNNING;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected AppState state = STATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDbUser() <em>Db User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDbUser()
	 * @generated
	 * @ordered
	 */
	protected static final String DB_USER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDbUser() <em>Db User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDbUser()
	 * @generated
	 * @ordered
	 */
	protected String dbUser = DB_USER_EDEFAULT;

	/**
	 * The default value of the '{@link #getDbPassword() <em>Db Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDbPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String DB_PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDbPassword() <em>Db Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDbPassword()
	 * @generated
	 * @ordered
	 */
	protected String dbPassword = DB_PASSWORD_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAllocatedTo() <em>Allocated To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocatedTo()
	 * @generated
	 * @ordered
	 */
	protected HostInstance allocatedTo;

	/**
	 * The cached value of the '{@link #getDependOn() <em>Depend On</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependOn()
	 * @generated
	 * @ordered
	 */
	protected EList<ApplicationInstance> dependOn;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicationInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CyberPhysicalSystemPackage.Literals.APPLICATION_INSTANCE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CyberPhysicalSystemPackage.APPLICATION_INSTANCE__IDENTIFIER, oldIdentifier, identifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppState getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(AppState newState) {
		AppState oldState = state;
		state = newState == null ? STATE_EDEFAULT : newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CyberPhysicalSystemPackage.APPLICATION_INSTANCE__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDbUser() {
		return dbUser;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDbUser(String newDbUser) {
		String oldDbUser = dbUser;
		dbUser = newDbUser;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CyberPhysicalSystemPackage.APPLICATION_INSTANCE__DB_USER, oldDbUser, dbUser));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDbPassword() {
		return dbPassword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDbPassword(String newDbPassword) {
		String oldDbPassword = dbPassword;
		dbPassword = newDbPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CyberPhysicalSystemPackage.APPLICATION_INSTANCE__DB_PASSWORD, oldDbPassword, dbPassword));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HostInstance getAllocatedTo() {
		if (allocatedTo != null && allocatedTo.eIsProxy()) {
			InternalEObject oldAllocatedTo = (InternalEObject)allocatedTo;
			allocatedTo = (HostInstance)eResolveProxy(oldAllocatedTo);
			if (allocatedTo != oldAllocatedTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CyberPhysicalSystemPackage.APPLICATION_INSTANCE__ALLOCATED_TO, oldAllocatedTo, allocatedTo));
			}
		}
		return allocatedTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HostInstance basicGetAllocatedTo() {
		return allocatedTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAllocatedTo(HostInstance newAllocatedTo, NotificationChain msgs) {
		HostInstance oldAllocatedTo = allocatedTo;
		allocatedTo = newAllocatedTo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CyberPhysicalSystemPackage.APPLICATION_INSTANCE__ALLOCATED_TO, oldAllocatedTo, newAllocatedTo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllocatedTo(HostInstance newAllocatedTo) {
		if (newAllocatedTo != allocatedTo) {
			NotificationChain msgs = null;
			if (allocatedTo != null)
				msgs = ((InternalEObject)allocatedTo).eInverseRemove(this, CyberPhysicalSystemPackage.HOST_INSTANCE__APPLICATIONS, HostInstance.class, msgs);
			if (newAllocatedTo != null)
				msgs = ((InternalEObject)newAllocatedTo).eInverseAdd(this, CyberPhysicalSystemPackage.HOST_INSTANCE__APPLICATIONS, HostInstance.class, msgs);
			msgs = basicSetAllocatedTo(newAllocatedTo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CyberPhysicalSystemPackage.APPLICATION_INSTANCE__ALLOCATED_TO, newAllocatedTo, newAllocatedTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ApplicationInstance> getDependOn() {
		if (dependOn == null) {
			dependOn = new EObjectResolvingEList<ApplicationInstance>(ApplicationInstance.class, this, CyberPhysicalSystemPackage.APPLICATION_INSTANCE__DEPEND_ON);
		}
		return dependOn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationType getType() {
		if (eContainerFeatureID() != CyberPhysicalSystemPackage.APPLICATION_INSTANCE__TYPE) return null;
		return (ApplicationType)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetType(ApplicationType newType, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newType, CyberPhysicalSystemPackage.APPLICATION_INSTANCE__TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ApplicationType newType) {
		if (newType != eInternalContainer() || (eContainerFeatureID() != CyberPhysicalSystemPackage.APPLICATION_INSTANCE__TYPE && newType != null)) {
			if (EcoreUtil.isAncestor(this, newType))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, CyberPhysicalSystemPackage.APPLICATION_TYPE__INSTANCES, ApplicationType.class, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CyberPhysicalSystemPackage.APPLICATION_INSTANCE__TYPE, newType, newType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__ALLOCATED_TO:
				if (allocatedTo != null)
					msgs = ((InternalEObject)allocatedTo).eInverseRemove(this, CyberPhysicalSystemPackage.HOST_INSTANCE__APPLICATIONS, HostInstance.class, msgs);
				return basicSetAllocatedTo((HostInstance)otherEnd, msgs);
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__TYPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetType((ApplicationType)otherEnd, msgs);
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
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__ALLOCATED_TO:
				return basicSetAllocatedTo(null, msgs);
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__TYPE:
				return basicSetType(null, msgs);
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
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__TYPE:
				return eInternalContainer().eInverseRemove(this, CyberPhysicalSystemPackage.APPLICATION_TYPE__INSTANCES, ApplicationType.class, msgs);
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
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__IDENTIFIER:
				return getIdentifier();
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__STATE:
				return getState();
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__DB_USER:
				return getDbUser();
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__DB_PASSWORD:
				return getDbPassword();
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__ALLOCATED_TO:
				if (resolve) return getAllocatedTo();
				return basicGetAllocatedTo();
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__DEPEND_ON:
				return getDependOn();
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__TYPE:
				return getType();
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
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__IDENTIFIER:
				setIdentifier((String)newValue);
				return;
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__STATE:
				setState((AppState)newValue);
				return;
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__DB_USER:
				setDbUser((String)newValue);
				return;
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__DB_PASSWORD:
				setDbPassword((String)newValue);
				return;
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__ALLOCATED_TO:
				setAllocatedTo((HostInstance)newValue);
				return;
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__DEPEND_ON:
				getDependOn().clear();
				getDependOn().addAll((Collection<? extends ApplicationInstance>)newValue);
				return;
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__TYPE:
				setType((ApplicationType)newValue);
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
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__IDENTIFIER:
				setIdentifier(IDENTIFIER_EDEFAULT);
				return;
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__STATE:
				setState(STATE_EDEFAULT);
				return;
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__DB_USER:
				setDbUser(DB_USER_EDEFAULT);
				return;
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__DB_PASSWORD:
				setDbPassword(DB_PASSWORD_EDEFAULT);
				return;
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__ALLOCATED_TO:
				setAllocatedTo((HostInstance)null);
				return;
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__DEPEND_ON:
				getDependOn().clear();
				return;
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__TYPE:
				setType((ApplicationType)null);
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
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__IDENTIFIER:
				return IDENTIFIER_EDEFAULT == null ? identifier != null : !IDENTIFIER_EDEFAULT.equals(identifier);
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__STATE:
				return state != STATE_EDEFAULT;
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__DB_USER:
				return DB_USER_EDEFAULT == null ? dbUser != null : !DB_USER_EDEFAULT.equals(dbUser);
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__DB_PASSWORD:
				return DB_PASSWORD_EDEFAULT == null ? dbPassword != null : !DB_PASSWORD_EDEFAULT.equals(dbPassword);
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__ALLOCATED_TO:
				return allocatedTo != null;
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__DEPEND_ON:
				return dependOn != null && !dependOn.isEmpty();
			case CyberPhysicalSystemPackage.APPLICATION_INSTANCE__TYPE:
				return getType() != null;
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
		result.append(", state: ");
		result.append(state);
		result.append(", dbUser: ");
		result.append(dbUser);
		result.append(", dbPassword: ");
		result.append(dbPassword);
		result.append(')');
		return result.toString();
	}

} //ApplicationInstanceImpl
