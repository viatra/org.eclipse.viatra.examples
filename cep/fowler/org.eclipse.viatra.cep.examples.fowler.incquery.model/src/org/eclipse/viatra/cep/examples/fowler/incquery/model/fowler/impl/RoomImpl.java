/**
 */
package org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Door;
import org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Drawer;
import org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.FowlerPackage;
import org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Light;
import org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Room;
import org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Wall;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Room</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.RoomImpl#getDoor <em>Door</em>}</li>
 *   <li>{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.RoomImpl#getDrawers <em>Drawers</em>}</li>
 *   <li>{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.RoomImpl#getWall <em>Wall</em>}</li>
 *   <li>{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.RoomImpl#getLight <em>Light</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoomImpl extends MinimalEObjectImpl.Container implements Room {
	/**
	 * The cached value of the '{@link #getDoor() <em>Door</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoor()
	 * @generated
	 * @ordered
	 */
	protected Door door;

	/**
	 * The cached value of the '{@link #getDrawers() <em>Drawers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDrawers()
	 * @generated
	 * @ordered
	 */
	protected EList<Drawer> drawers;

	/**
	 * The cached value of the '{@link #getWall() <em>Wall</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWall()
	 * @generated
	 * @ordered
	 */
	protected Wall wall;

	/**
	 * The cached value of the '{@link #getLight() <em>Light</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLight()
	 * @generated
	 * @ordered
	 */
	protected Light light;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FowlerPackage.Literals.ROOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Door getDoor() {
		return door;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDoor(Door newDoor, NotificationChain msgs) {
		Door oldDoor = door;
		door = newDoor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FowlerPackage.ROOM__DOOR, oldDoor, newDoor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDoor(Door newDoor) {
		if (newDoor != door) {
			NotificationChain msgs = null;
			if (door != null)
				msgs = ((InternalEObject)door).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FowlerPackage.ROOM__DOOR, null, msgs);
			if (newDoor != null)
				msgs = ((InternalEObject)newDoor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FowlerPackage.ROOM__DOOR, null, msgs);
			msgs = basicSetDoor(newDoor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FowlerPackage.ROOM__DOOR, newDoor, newDoor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Drawer> getDrawers() {
		if (drawers == null) {
			drawers = new EObjectContainmentEList<Drawer>(Drawer.class, this, FowlerPackage.ROOM__DRAWERS);
		}
		return drawers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Wall getWall() {
		return wall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWall(Wall newWall, NotificationChain msgs) {
		Wall oldWall = wall;
		wall = newWall;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FowlerPackage.ROOM__WALL, oldWall, newWall);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWall(Wall newWall) {
		if (newWall != wall) {
			NotificationChain msgs = null;
			if (wall != null)
				msgs = ((InternalEObject)wall).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FowlerPackage.ROOM__WALL, null, msgs);
			if (newWall != null)
				msgs = ((InternalEObject)newWall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FowlerPackage.ROOM__WALL, null, msgs);
			msgs = basicSetWall(newWall, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FowlerPackage.ROOM__WALL, newWall, newWall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Light getLight() {
		return light;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLight(Light newLight, NotificationChain msgs) {
		Light oldLight = light;
		light = newLight;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FowlerPackage.ROOM__LIGHT, oldLight, newLight);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLight(Light newLight) {
		if (newLight != light) {
			NotificationChain msgs = null;
			if (light != null)
				msgs = ((InternalEObject)light).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FowlerPackage.ROOM__LIGHT, null, msgs);
			if (newLight != null)
				msgs = ((InternalEObject)newLight).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FowlerPackage.ROOM__LIGHT, null, msgs);
			msgs = basicSetLight(newLight, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FowlerPackage.ROOM__LIGHT, newLight, newLight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FowlerPackage.ROOM__DOOR:
				return basicSetDoor(null, msgs);
			case FowlerPackage.ROOM__DRAWERS:
				return ((InternalEList<?>)getDrawers()).basicRemove(otherEnd, msgs);
			case FowlerPackage.ROOM__WALL:
				return basicSetWall(null, msgs);
			case FowlerPackage.ROOM__LIGHT:
				return basicSetLight(null, msgs);
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
			case FowlerPackage.ROOM__DOOR:
				return getDoor();
			case FowlerPackage.ROOM__DRAWERS:
				return getDrawers();
			case FowlerPackage.ROOM__WALL:
				return getWall();
			case FowlerPackage.ROOM__LIGHT:
				return getLight();
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
			case FowlerPackage.ROOM__DOOR:
				setDoor((Door)newValue);
				return;
			case FowlerPackage.ROOM__DRAWERS:
				getDrawers().clear();
				getDrawers().addAll((Collection<? extends Drawer>)newValue);
				return;
			case FowlerPackage.ROOM__WALL:
				setWall((Wall)newValue);
				return;
			case FowlerPackage.ROOM__LIGHT:
				setLight((Light)newValue);
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
			case FowlerPackage.ROOM__DOOR:
				setDoor((Door)null);
				return;
			case FowlerPackage.ROOM__DRAWERS:
				getDrawers().clear();
				return;
			case FowlerPackage.ROOM__WALL:
				setWall((Wall)null);
				return;
			case FowlerPackage.ROOM__LIGHT:
				setLight((Light)null);
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
			case FowlerPackage.ROOM__DOOR:
				return door != null;
			case FowlerPackage.ROOM__DRAWERS:
				return drawers != null && !drawers.isEmpty();
			case FowlerPackage.ROOM__WALL:
				return wall != null;
			case FowlerPackage.ROOM__LIGHT:
				return light != null;
		}
		return super.eIsSet(featureID);
	}

} //RoomImpl
