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
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystem;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostType;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Request;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cyber Physical System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemImpl#getDbUrl <em>Db Url</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemImpl#getAppTypes <em>App Types</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemImpl#getRequests <em>Requests</em>}</li>
 *   <li>{@link org.eclipse.viatra.examples.cps.cyberPhysicalSystem.impl.CyberPhysicalSystemImpl#getHostTypes <em>Host Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CyberPhysicalSystemImpl extends MinimalEObjectImpl.Container implements CyberPhysicalSystem {
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
	 * The default value of the '{@link #getDbUrl() <em>Db Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDbUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String DB_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDbUrl() <em>Db Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDbUrl()
	 * @generated
	 * @ordered
	 */
	protected String dbUrl = DB_URL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAppTypes() <em>App Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ApplicationType> appTypes;

	/**
	 * The cached value of the '{@link #getRequests() <em>Requests</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequests()
	 * @generated
	 * @ordered
	 */
	protected EList<Request> requests;

	/**
	 * The cached value of the '{@link #getHostTypes() <em>Host Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHostTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<HostType> hostTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CyberPhysicalSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CyberPhysicalSystemPackage.Literals.CYBER_PHYSICAL_SYSTEM;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__IDENTIFIER, oldIdentifier, identifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDbUrl() {
		return dbUrl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDbUrl(String newDbUrl) {
		String oldDbUrl = dbUrl;
		dbUrl = newDbUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__DB_URL, oldDbUrl, dbUrl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ApplicationType> getAppTypes() {
		if (appTypes == null) {
			appTypes = new EObjectContainmentWithInverseEList<ApplicationType>(ApplicationType.class, this, CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__APP_TYPES, CyberPhysicalSystemPackage.APPLICATION_TYPE__CPS);
		}
		return appTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Request> getRequests() {
		if (requests == null) {
			requests = new EObjectContainmentEList<Request>(Request.class, this, CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__REQUESTS);
		}
		return requests;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HostType> getHostTypes() {
		if (hostTypes == null) {
			hostTypes = new EObjectContainmentWithInverseEList<HostType>(HostType.class, this, CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__HOST_TYPES, CyberPhysicalSystemPackage.HOST_TYPE__CPS);
		}
		return hostTypes;
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
			case CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__APP_TYPES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAppTypes()).basicAdd(otherEnd, msgs);
			case CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__HOST_TYPES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getHostTypes()).basicAdd(otherEnd, msgs);
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
			case CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__APP_TYPES:
				return ((InternalEList<?>)getAppTypes()).basicRemove(otherEnd, msgs);
			case CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__REQUESTS:
				return ((InternalEList<?>)getRequests()).basicRemove(otherEnd, msgs);
			case CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__HOST_TYPES:
				return ((InternalEList<?>)getHostTypes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__IDENTIFIER:
				return getIdentifier();
			case CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__DB_URL:
				return getDbUrl();
			case CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__APP_TYPES:
				return getAppTypes();
			case CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__REQUESTS:
				return getRequests();
			case CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__HOST_TYPES:
				return getHostTypes();
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
			case CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__IDENTIFIER:
				setIdentifier((String)newValue);
				return;
			case CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__DB_URL:
				setDbUrl((String)newValue);
				return;
			case CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__APP_TYPES:
				getAppTypes().clear();
				getAppTypes().addAll((Collection<? extends ApplicationType>)newValue);
				return;
			case CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__REQUESTS:
				getRequests().clear();
				getRequests().addAll((Collection<? extends Request>)newValue);
				return;
			case CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__HOST_TYPES:
				getHostTypes().clear();
				getHostTypes().addAll((Collection<? extends HostType>)newValue);
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
			case CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__IDENTIFIER:
				setIdentifier(IDENTIFIER_EDEFAULT);
				return;
			case CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__DB_URL:
				setDbUrl(DB_URL_EDEFAULT);
				return;
			case CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__APP_TYPES:
				getAppTypes().clear();
				return;
			case CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__REQUESTS:
				getRequests().clear();
				return;
			case CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__HOST_TYPES:
				getHostTypes().clear();
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
			case CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__IDENTIFIER:
				return IDENTIFIER_EDEFAULT == null ? identifier != null : !IDENTIFIER_EDEFAULT.equals(identifier);
			case CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__DB_URL:
				return DB_URL_EDEFAULT == null ? dbUrl != null : !DB_URL_EDEFAULT.equals(dbUrl);
			case CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__APP_TYPES:
				return appTypes != null && !appTypes.isEmpty();
			case CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__REQUESTS:
				return requests != null && !requests.isEmpty();
			case CyberPhysicalSystemPackage.CYBER_PHYSICAL_SYSTEM__HOST_TYPES:
				return hostTypes != null && !hostTypes.isEmpty();
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
		result.append(", dbUrl: ");
		result.append(dbUrl);
		result.append(')');
		return result.toString();
	}

} //CyberPhysicalSystemImpl
