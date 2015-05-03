/**
 */
package org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Door</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Door#isOpen <em>Open</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.FowlerPackage#getDoor()
 * @model
 * @generated
 */
public interface Door extends EObject {
	/**
	 * Returns the value of the '<em><b>Open</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Open</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Open</em>' attribute.
	 * @see #setOpen(boolean)
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.FowlerPackage#getDoor_Open()
	 * @model
	 * @generated
	 */
	boolean isOpen();

	/**
	 * Sets the value of the '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Door#isOpen <em>Open</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Open</em>' attribute.
	 * @see #isOpen()
	 * @generated
	 */
	void setOpen(boolean value);

} // Door
