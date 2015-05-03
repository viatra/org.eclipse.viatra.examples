/**
 */
package org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Light</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Light#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.FowlerPackage#getLight()
 * @model
 * @generated
 */
public interface Light extends EObject {
	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The default value is <code>"OFF"</code>.
	 * The literals are from the enumeration {@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.State
	 * @see #setState(State)
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.FowlerPackage#getLight_State()
	 * @model default="OFF"
	 * @generated
	 */
	State getState();

	/**
	 * Sets the value of the '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Light#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.State
	 * @see #getState()
	 * @generated
	 */
	void setState(State value);

} // Light
