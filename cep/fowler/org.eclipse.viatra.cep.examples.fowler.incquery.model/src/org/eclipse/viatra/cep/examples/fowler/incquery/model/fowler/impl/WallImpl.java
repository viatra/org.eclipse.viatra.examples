/**
 */
package org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.FowlerPackage;
import org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Wall;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Wall</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.WallImpl#isKnocked <em>Knocked</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WallImpl extends MinimalEObjectImpl.Container implements Wall {
	/**
	 * The default value of the '{@link #isKnocked() <em>Knocked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isKnocked()
	 * @generated
	 * @ordered
	 */
	protected static final boolean KNOCKED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isKnocked() <em>Knocked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isKnocked()
	 * @generated
	 * @ordered
	 */
	protected boolean knocked = KNOCKED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FowlerPackage.Literals.WALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isKnocked() {
		return knocked;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKnocked(boolean newKnocked) {
		boolean oldKnocked = knocked;
		knocked = newKnocked;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FowlerPackage.WALL__KNOCKED, oldKnocked, knocked));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FowlerPackage.WALL__KNOCKED:
				return isKnocked();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FowlerPackage.WALL__KNOCKED:
				setKnocked((Boolean)newValue);
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
			case FowlerPackage.WALL__KNOCKED:
				setKnocked(KNOCKED_EDEFAULT);
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
			case FowlerPackage.WALL__KNOCKED:
				return knocked != KNOCKED_EDEFAULT;
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
		result.append(" (knocked: ");
		result.append(knocked);
		result.append(')');
		return result.toString();
	}

} //WallImpl
