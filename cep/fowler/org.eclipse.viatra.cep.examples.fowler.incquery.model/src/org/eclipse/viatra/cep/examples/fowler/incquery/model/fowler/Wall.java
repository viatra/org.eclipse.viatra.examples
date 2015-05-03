/**
 */
package org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wall</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Wall#isKnocked <em>Knocked</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.FowlerPackage#getWall()
 * @model
 * @generated
 */
public interface Wall extends EObject {
	/**
	 * Returns the value of the '<em><b>Knocked</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Knocked</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Knocked</em>' attribute.
	 * @see #setKnocked(boolean)
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.FowlerPackage#getWall_Knocked()
	 * @model default="false"
	 * @generated
	 */
	boolean isKnocked();

	/**
	 * Sets the value of the '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Wall#isKnocked <em>Knocked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Knocked</em>' attribute.
	 * @see #isKnocked()
	 * @generated
	 */
	void setKnocked(boolean value);

} // Wall
