/**
 */
package org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.FowlerFactory
 * @model kind="package"
 * @generated
 */
public interface FowlerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "fowler";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "fowler.meta";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.viatra.cep.examples.fowler.incquery.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FowlerPackage eINSTANCE = org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.FowlerPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.RoomImpl <em>Room</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.RoomImpl
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.FowlerPackageImpl#getRoom()
	 * @generated
	 */
	int ROOM = 0;

	/**
	 * The feature id for the '<em><b>Door</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOM__DOOR = 0;

	/**
	 * The feature id for the '<em><b>Drawers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOM__DRAWERS = 1;

	/**
	 * The feature id for the '<em><b>Wall</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOM__WALL = 2;

	/**
	 * The feature id for the '<em><b>Light</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOM__LIGHT = 3;

	/**
	 * The number of structural features of the '<em>Room</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOM_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Room</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.DrawerImpl <em>Drawer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.DrawerImpl
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.FowlerPackageImpl#getDrawer()
	 * @generated
	 */
	int DRAWER = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER__ID = 0;

	/**
	 * The feature id for the '<em><b>Open</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER__OPEN = 1;

	/**
	 * The number of structural features of the '<em>Drawer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Drawer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.DoorImpl <em>Door</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.DoorImpl
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.FowlerPackageImpl#getDoor()
	 * @generated
	 */
	int DOOR = 2;

	/**
	 * The feature id for the '<em><b>Open</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOOR__OPEN = 0;

	/**
	 * The number of structural features of the '<em>Door</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOOR_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Door</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.WallImpl <em>Wall</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.WallImpl
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.FowlerPackageImpl#getWall()
	 * @generated
	 */
	int WALL = 3;

	/**
	 * The feature id for the '<em><b>Knocked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WALL__KNOCKED = 0;

	/**
	 * The number of structural features of the '<em>Wall</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WALL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Wall</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WALL_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.LightImpl <em>Light</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.LightImpl
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.FowlerPackageImpl#getLight()
	 * @generated
	 */
	int LIGHT = 4;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIGHT__STATE = 0;

	/**
	 * The number of structural features of the '<em>Light</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIGHT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Light</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIGHT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.State <em>State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.State
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.FowlerPackageImpl#getState()
	 * @generated
	 */
	int STATE = 5;


	/**
	 * Returns the meta object for class '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Room <em>Room</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Room</em>'.
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Room
	 * @generated
	 */
	EClass getRoom();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Room#getDoor <em>Door</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Door</em>'.
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Room#getDoor()
	 * @see #getRoom()
	 * @generated
	 */
	EReference getRoom_Door();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Room#getDrawers <em>Drawers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Drawers</em>'.
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Room#getDrawers()
	 * @see #getRoom()
	 * @generated
	 */
	EReference getRoom_Drawers();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Room#getWall <em>Wall</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Wall</em>'.
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Room#getWall()
	 * @see #getRoom()
	 * @generated
	 */
	EReference getRoom_Wall();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Room#getLight <em>Light</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Light</em>'.
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Room#getLight()
	 * @see #getRoom()
	 * @generated
	 */
	EReference getRoom_Light();

	/**
	 * Returns the meta object for class '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Drawer <em>Drawer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Drawer</em>'.
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Drawer
	 * @generated
	 */
	EClass getDrawer();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Drawer#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Drawer#getId()
	 * @see #getDrawer()
	 * @generated
	 */
	EAttribute getDrawer_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Drawer#isOpen <em>Open</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Open</em>'.
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Drawer#isOpen()
	 * @see #getDrawer()
	 * @generated
	 */
	EAttribute getDrawer_Open();

	/**
	 * Returns the meta object for class '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Door <em>Door</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Door</em>'.
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Door
	 * @generated
	 */
	EClass getDoor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Door#isOpen <em>Open</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Open</em>'.
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Door#isOpen()
	 * @see #getDoor()
	 * @generated
	 */
	EAttribute getDoor_Open();

	/**
	 * Returns the meta object for class '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Wall <em>Wall</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wall</em>'.
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Wall
	 * @generated
	 */
	EClass getWall();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Wall#isKnocked <em>Knocked</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Knocked</em>'.
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Wall#isKnocked()
	 * @see #getWall()
	 * @generated
	 */
	EAttribute getWall_Knocked();

	/**
	 * Returns the meta object for class '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Light <em>Light</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Light</em>'.
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Light
	 * @generated
	 */
	EClass getLight();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Light#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Light#getState()
	 * @see #getLight()
	 * @generated
	 */
	EAttribute getLight_State();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>State</em>'.
	 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.State
	 * @generated
	 */
	EEnum getState();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FowlerFactory getFowlerFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.RoomImpl <em>Room</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.RoomImpl
		 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.FowlerPackageImpl#getRoom()
		 * @generated
		 */
		EClass ROOM = eINSTANCE.getRoom();

		/**
		 * The meta object literal for the '<em><b>Door</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOM__DOOR = eINSTANCE.getRoom_Door();

		/**
		 * The meta object literal for the '<em><b>Drawers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOM__DRAWERS = eINSTANCE.getRoom_Drawers();

		/**
		 * The meta object literal for the '<em><b>Wall</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOM__WALL = eINSTANCE.getRoom_Wall();

		/**
		 * The meta object literal for the '<em><b>Light</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOM__LIGHT = eINSTANCE.getRoom_Light();

		/**
		 * The meta object literal for the '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.DrawerImpl <em>Drawer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.DrawerImpl
		 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.FowlerPackageImpl#getDrawer()
		 * @generated
		 */
		EClass DRAWER = eINSTANCE.getDrawer();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRAWER__ID = eINSTANCE.getDrawer_Id();

		/**
		 * The meta object literal for the '<em><b>Open</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRAWER__OPEN = eINSTANCE.getDrawer_Open();

		/**
		 * The meta object literal for the '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.DoorImpl <em>Door</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.DoorImpl
		 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.FowlerPackageImpl#getDoor()
		 * @generated
		 */
		EClass DOOR = eINSTANCE.getDoor();

		/**
		 * The meta object literal for the '<em><b>Open</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOOR__OPEN = eINSTANCE.getDoor_Open();

		/**
		 * The meta object literal for the '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.WallImpl <em>Wall</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.WallImpl
		 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.FowlerPackageImpl#getWall()
		 * @generated
		 */
		EClass WALL = eINSTANCE.getWall();

		/**
		 * The meta object literal for the '<em><b>Knocked</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WALL__KNOCKED = eINSTANCE.getWall_Knocked();

		/**
		 * The meta object literal for the '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.LightImpl <em>Light</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.LightImpl
		 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.FowlerPackageImpl#getLight()
		 * @generated
		 */
		EClass LIGHT = eINSTANCE.getLight();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIGHT__STATE = eINSTANCE.getLight_State();

		/**
		 * The meta object literal for the '{@link org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.State <em>State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.State
		 * @see org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.impl.FowlerPackageImpl#getState()
		 * @generated
		 */
		EEnum STATE = eINSTANCE.getState();

	}

} //FowlerPackage
