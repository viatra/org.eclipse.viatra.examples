/**
 */
package org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Drawer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Drawer#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Drawer#isOpen <em>Open</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.FowlerPackage#getDrawer()
 * @model
 * @generated
 */
public interface Drawer extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.FowlerPackage#getDrawer_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Drawer#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Open</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Open</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Open</em>' attribute.
	 * @see #setOpen(boolean)
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.FowlerPackage#getDrawer_Open()
	 * @model default="false"
	 * @generated
	 */
	boolean isOpen();

	/**
	 * Sets the value of the '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Drawer#isOpen <em>Open</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Open</em>' attribute.
	 * @see #isOpen()
	 * @generated
	 */
	void setOpen(boolean value);

} // Drawer
