/**
 */
package org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Room</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Room#getDoor <em>Door</em>}</li>
 *   <li>{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Room#getDrawers <em>Drawers</em>}</li>
 *   <li>{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Room#getWall <em>Wall</em>}</li>
 *   <li>{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Room#getLight <em>Light</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.FowlerPackage#getRoom()
 * @model
 * @generated
 */
public interface Room extends EObject {
	/**
	 * Returns the value of the '<em><b>Door</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Door</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Door</em>' containment reference.
	 * @see #setDoor(Door)
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.FowlerPackage#getRoom_Door()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Door getDoor();

	/**
	 * Sets the value of the '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Room#getDoor <em>Door</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Door</em>' containment reference.
	 * @see #getDoor()
	 * @generated
	 */
	void setDoor(Door value);

	/**
	 * Returns the value of the '<em><b>Drawers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Drawer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Drawers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Drawers</em>' containment reference list.
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.FowlerPackage#getRoom_Drawers()
	 * @model containment="true"
	 * @generated
	 */
	EList<Drawer> getDrawers();

	/**
	 * Returns the value of the '<em><b>Wall</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wall</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wall</em>' containment reference.
	 * @see #setWall(Wall)
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.FowlerPackage#getRoom_Wall()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Wall getWall();

	/**
	 * Sets the value of the '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Room#getWall <em>Wall</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wall</em>' containment reference.
	 * @see #getWall()
	 * @generated
	 */
	void setWall(Wall value);

	/**
	 * Returns the value of the '<em><b>Light</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Light</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Light</em>' containment reference.
	 * @see #setLight(Light)
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.FowlerPackage#getRoom_Light()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Light getLight();

	/**
	 * Sets the value of the '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Room#getLight <em>Light</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Light</em>' containment reference.
	 * @see #getLight()
	 * @generated
	 */
	void setLight(Light value);

} // Room
