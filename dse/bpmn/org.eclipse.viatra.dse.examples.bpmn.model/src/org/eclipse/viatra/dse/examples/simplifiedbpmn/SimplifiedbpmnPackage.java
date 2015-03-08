/**
 */
package org.eclipse.viatra.dse.examples.simplifiedbpmn;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnFactory
 * @model kind="package"
 * @generated
 */
public interface SimplifiedbpmnPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "simplifiedbpmn";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "org.eclipse.viatra.dse.examples.bpmn";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "org.eclipse.viatra.dse.examples.bpmn";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    SimplifiedbpmnPackage eINSTANCE = org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedbpmnPackageImpl.init();

    /**
     * The meta object id for the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedBPMNImpl <em>Simplified BPMN</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedBPMNImpl
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedbpmnPackageImpl#getSimplifiedBPMN()
     * @generated
     */
    int SIMPLIFIED_BPMN = 0;

    /**
     * The feature id for the '<em><b>Tasks</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLIFIED_BPMN__TASKS = 0;

    /**
     * The feature id for the '<em><b>Start Events</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLIFIED_BPMN__START_EVENTS = 1;

    /**
     * The feature id for the '<em><b>End Events</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLIFIED_BPMN__END_EVENTS = 2;

    /**
     * The feature id for the '<em><b>Gateways</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLIFIED_BPMN__GATEWAYS = 3;

    /**
     * The feature id for the '<em><b>Parallel Gateways</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLIFIED_BPMN__PARALLEL_GATEWAYS = 4;

    /**
     * The feature id for the '<em><b>Sequence Flows</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLIFIED_BPMN__SEQUENCE_FLOWS = 5;

    /**
     * The feature id for the '<em><b>Resource Types</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLIFIED_BPMN__RESOURCE_TYPES = 6;

    /**
     * The number of structural features of the '<em>Simplified BPMN</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLIFIED_BPMN_FEATURE_COUNT = 7;

    /**
     * The number of operations of the '<em>Simplified BPMN</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLIFIED_BPMN_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.NamedElementImpl <em>Named Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.NamedElementImpl
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedbpmnPackageImpl#getNamedElement()
     * @generated
     */
    int NAMED_ELEMENT = 11;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED_ELEMENT__NAME = 0;

    /**
     * The number of structural features of the '<em>Named Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED_ELEMENT_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Named Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED_ELEMENT_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.BaseElementImpl <em>Base Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.BaseElementImpl
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedbpmnPackageImpl#getBaseElement()
     * @generated
     */
    int BASE_ELEMENT = 7;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BASE_ELEMENT__NAME = NAMED_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Out Flows</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BASE_ELEMENT__OUT_FLOWS = NAMED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>In Flows</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BASE_ELEMENT__IN_FLOWS = NAMED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Base Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BASE_ELEMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Base Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BASE_ELEMENT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.TaskImpl <em>Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.TaskImpl
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedbpmnPackageImpl#getTask()
     * @generated
     */
    int TASK = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__NAME = BASE_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Out Flows</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__OUT_FLOWS = BASE_ELEMENT__OUT_FLOWS;

    /**
     * The feature id for the '<em><b>In Flows</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__IN_FLOWS = BASE_ELEMENT__IN_FLOWS;

    /**
     * The feature id for the '<em><b>Execution Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__EXECUTION_TIME = BASE_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Resource Needed</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__RESOURCE_NEEDED = BASE_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Variant</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__VARIANT = BASE_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Task</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The number of operations of the '<em>Task</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.StartEventImpl <em>Start Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.StartEventImpl
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedbpmnPackageImpl#getStartEvent()
     * @generated
     */
    int START_EVENT = 2;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_EVENT__NAME = BASE_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Out Flows</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_EVENT__OUT_FLOWS = BASE_ELEMENT__OUT_FLOWS;

    /**
     * The feature id for the '<em><b>In Flows</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_EVENT__IN_FLOWS = BASE_ELEMENT__IN_FLOWS;

    /**
     * The number of structural features of the '<em>Start Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_EVENT_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Start Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_EVENT_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.EndEventImpl <em>End Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.EndEventImpl
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedbpmnPackageImpl#getEndEvent()
     * @generated
     */
    int END_EVENT = 3;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_EVENT__NAME = BASE_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Out Flows</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_EVENT__OUT_FLOWS = BASE_ELEMENT__OUT_FLOWS;

    /**
     * The feature id for the '<em><b>In Flows</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_EVENT__IN_FLOWS = BASE_ELEMENT__IN_FLOWS;

    /**
     * The number of structural features of the '<em>End Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_EVENT_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>End Event</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int END_EVENT_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SequenceFlowImpl <em>Sequence Flow</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SequenceFlowImpl
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedbpmnPackageImpl#getSequenceFlow()
     * @generated
     */
    int SEQUENCE_FLOW = 4;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_FLOW__SOURCE = 0;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_FLOW__TARGET = 1;

    /**
     * The feature id for the '<em><b>Propability</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_FLOW__PROPABILITY = 2;

    /**
     * The feature id for the '<em><b>Is Data Flow</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_FLOW__IS_DATA_FLOW = 3;

    /**
     * The number of structural features of the '<em>Sequence Flow</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_FLOW_FEATURE_COUNT = 4;

    /**
     * The number of operations of the '<em>Sequence Flow</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEQUENCE_FLOW_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.GatewayImpl <em>Gateway</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.GatewayImpl
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedbpmnPackageImpl#getGateway()
     * @generated
     */
    int GATEWAY = 5;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GATEWAY__NAME = BASE_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Out Flows</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GATEWAY__OUT_FLOWS = BASE_ELEMENT__OUT_FLOWS;

    /**
     * The feature id for the '<em><b>In Flows</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GATEWAY__IN_FLOWS = BASE_ELEMENT__IN_FLOWS;

    /**
     * The number of structural features of the '<em>Gateway</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GATEWAY_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Gateway</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GATEWAY_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.ParallelGatewayImpl <em>Parallel Gateway</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.ParallelGatewayImpl
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedbpmnPackageImpl#getParallelGateway()
     * @generated
     */
    int PARALLEL_GATEWAY = 6;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARALLEL_GATEWAY__NAME = BASE_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Out Flows</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARALLEL_GATEWAY__OUT_FLOWS = BASE_ELEMENT__OUT_FLOWS;

    /**
     * The feature id for the '<em><b>In Flows</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARALLEL_GATEWAY__IN_FLOWS = BASE_ELEMENT__IN_FLOWS;

    /**
     * The feature id for the '<em><b>Diverging</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARALLEL_GATEWAY__DIVERGING = BASE_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Parallel Gateway</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARALLEL_GATEWAY_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Parallel Gateway</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARALLEL_GATEWAY_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.ResourceTypeImpl <em>Resource Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.ResourceTypeImpl
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedbpmnPackageImpl#getResourceType()
     * @generated
     */
    int RESOURCE_TYPE = 8;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_TYPE__NAME = NAMED_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Used By Tasks</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_TYPE__USED_BY_TASKS = NAMED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Variants</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_TYPE__VARIANTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Resource Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_TYPE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Resource Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_TYPE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.ResourceInstanceImpl <em>Resource Instance</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.ResourceInstanceImpl
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedbpmnPackageImpl#getResourceInstance()
     * @generated
     */
    int RESOURCE_INSTANCE = 9;

    /**
     * The feature id for the '<em><b>Resource Type Variant</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_INSTANCE__RESOURCE_TYPE_VARIANT = 0;

    /**
     * The number of structural features of the '<em>Resource Instance</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_INSTANCE_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Resource Instance</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_INSTANCE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.ResourceTypeVariantImpl <em>Resource Type Variant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.ResourceTypeVariantImpl
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedbpmnPackageImpl#getResourceTypeVariant()
     * @generated
     */
    int RESOURCE_TYPE_VARIANT = 10;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_TYPE_VARIANT__NAME = NAMED_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Efficiency</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_TYPE_VARIANT__EFFICIENCY = NAMED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Instances</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_TYPE_VARIANT__INSTANCES = NAMED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Type</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_TYPE_VARIANT__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Resource Type Variant</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_TYPE_VARIANT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The number of operations of the '<em>Resource Type Variant</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOURCE_TYPE_VARIANT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;


    /**
     * Returns the meta object for class '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN <em>Simplified BPMN</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Simplified BPMN</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN
     * @generated
     */
    EClass getSimplifiedBPMN();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN#getTasks <em>Tasks</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Tasks</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN#getTasks()
     * @see #getSimplifiedBPMN()
     * @generated
     */
    EReference getSimplifiedBPMN_Tasks();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN#getStartEvents <em>Start Events</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Start Events</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN#getStartEvents()
     * @see #getSimplifiedBPMN()
     * @generated
     */
    EReference getSimplifiedBPMN_StartEvents();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN#getEndEvents <em>End Events</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>End Events</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN#getEndEvents()
     * @see #getSimplifiedBPMN()
     * @generated
     */
    EReference getSimplifiedBPMN_EndEvents();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN#getGateways <em>Gateways</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Gateways</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN#getGateways()
     * @see #getSimplifiedBPMN()
     * @generated
     */
    EReference getSimplifiedBPMN_Gateways();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN#getParallelGateways <em>Parallel Gateways</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Parallel Gateways</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN#getParallelGateways()
     * @see #getSimplifiedBPMN()
     * @generated
     */
    EReference getSimplifiedBPMN_ParallelGateways();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN#getSequenceFlows <em>Sequence Flows</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Sequence Flows</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN#getSequenceFlows()
     * @see #getSimplifiedBPMN()
     * @generated
     */
    EReference getSimplifiedBPMN_SequenceFlows();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN#getResourceTypes <em>Resource Types</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Resource Types</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN#getResourceTypes()
     * @see #getSimplifiedBPMN()
     * @generated
     */
    EReference getSimplifiedBPMN_ResourceTypes();

    /**
     * Returns the meta object for class '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.Task <em>Task</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Task</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.Task
     * @generated
     */
    EClass getTask();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.Task#getExecutionTime <em>Execution Time</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Execution Time</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.Task#getExecutionTime()
     * @see #getTask()
     * @generated
     */
    EAttribute getTask_ExecutionTime();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.Task#getResourceNeeded <em>Resource Needed</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Resource Needed</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.Task#getResourceNeeded()
     * @see #getTask()
     * @generated
     */
    EReference getTask_ResourceNeeded();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.Task#getVariant <em>Variant</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Variant</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.Task#getVariant()
     * @see #getTask()
     * @generated
     */
    EReference getTask_Variant();

    /**
     * Returns the meta object for class '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.StartEvent <em>Start Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Start Event</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.StartEvent
     * @generated
     */
    EClass getStartEvent();

    /**
     * Returns the meta object for class '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.EndEvent <em>End Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>End Event</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.EndEvent
     * @generated
     */
    EClass getEndEvent();

    /**
     * Returns the meta object for class '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow <em>Sequence Flow</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Sequence Flow</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow
     * @generated
     */
    EClass getSequenceFlow();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Source</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow#getSource()
     * @see #getSequenceFlow()
     * @generated
     */
    EReference getSequenceFlow_Source();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Target</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow#getTarget()
     * @see #getSequenceFlow()
     * @generated
     */
    EReference getSequenceFlow_Target();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow#getPropability <em>Propability</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Propability</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow#getPropability()
     * @see #getSequenceFlow()
     * @generated
     */
    EAttribute getSequenceFlow_Propability();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow#isIsDataFlow <em>Is Data Flow</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Data Flow</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow#isIsDataFlow()
     * @see #getSequenceFlow()
     * @generated
     */
    EAttribute getSequenceFlow_IsDataFlow();

    /**
     * Returns the meta object for class '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.Gateway <em>Gateway</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Gateway</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.Gateway
     * @generated
     */
    EClass getGateway();

    /**
     * Returns the meta object for class '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ParallelGateway <em>Parallel Gateway</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Parallel Gateway</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.ParallelGateway
     * @generated
     */
    EClass getParallelGateway();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ParallelGateway#isDiverging <em>Diverging</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Diverging</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.ParallelGateway#isDiverging()
     * @see #getParallelGateway()
     * @generated
     */
    EAttribute getParallelGateway_Diverging();

    /**
     * Returns the meta object for class '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.BaseElement <em>Base Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Base Element</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.BaseElement
     * @generated
     */
    EClass getBaseElement();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.BaseElement#getOutFlows <em>Out Flows</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Out Flows</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.BaseElement#getOutFlows()
     * @see #getBaseElement()
     * @generated
     */
    EReference getBaseElement_OutFlows();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.BaseElement#getInFlows <em>In Flows</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>In Flows</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.BaseElement#getInFlows()
     * @see #getBaseElement()
     * @generated
     */
    EReference getBaseElement_InFlows();

    /**
     * Returns the meta object for class '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceType <em>Resource Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Resource Type</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceType
     * @generated
     */
    EClass getResourceType();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceType#getUsedByTasks <em>Used By Tasks</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Used By Tasks</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceType#getUsedByTasks()
     * @see #getResourceType()
     * @generated
     */
    EReference getResourceType_UsedByTasks();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceType#getVariants <em>Variants</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Variants</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceType#getVariants()
     * @see #getResourceType()
     * @generated
     */
    EReference getResourceType_Variants();

    /**
     * Returns the meta object for class '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance <em>Resource Instance</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Resource Instance</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance
     * @generated
     */
    EClass getResourceInstance();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance#getResourceTypeVariant <em>Resource Type Variant</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Resource Type Variant</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance#getResourceTypeVariant()
     * @see #getResourceInstance()
     * @generated
     */
    EReference getResourceInstance_ResourceTypeVariant();

    /**
     * Returns the meta object for class '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant <em>Resource Type Variant</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Resource Type Variant</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant
     * @generated
     */
    EClass getResourceTypeVariant();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant#getEfficiency <em>Efficiency</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Efficiency</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant#getEfficiency()
     * @see #getResourceTypeVariant()
     * @generated
     */
    EAttribute getResourceTypeVariant_Efficiency();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant#getInstances <em>Instances</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Instances</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant#getInstances()
     * @see #getResourceTypeVariant()
     * @generated
     */
    EReference getResourceTypeVariant_Instances();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Type</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant#getType()
     * @see #getResourceTypeVariant()
     * @generated
     */
    EReference getResourceTypeVariant_Type();

    /**
     * Returns the meta object for class '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.NamedElement <em>Named Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Named Element</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.NamedElement
     * @generated
     */
    EClass getNamedElement();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.NamedElement#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.NamedElement#getName()
     * @see #getNamedElement()
     * @generated
     */
    EAttribute getNamedElement_Name();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    SimplifiedbpmnFactory getSimplifiedbpmnFactory();

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
         * The meta object literal for the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedBPMNImpl <em>Simplified BPMN</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedBPMNImpl
         * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedbpmnPackageImpl#getSimplifiedBPMN()
         * @generated
         */
        EClass SIMPLIFIED_BPMN = eINSTANCE.getSimplifiedBPMN();

        /**
         * The meta object literal for the '<em><b>Tasks</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SIMPLIFIED_BPMN__TASKS = eINSTANCE.getSimplifiedBPMN_Tasks();

        /**
         * The meta object literal for the '<em><b>Start Events</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SIMPLIFIED_BPMN__START_EVENTS = eINSTANCE.getSimplifiedBPMN_StartEvents();

        /**
         * The meta object literal for the '<em><b>End Events</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SIMPLIFIED_BPMN__END_EVENTS = eINSTANCE.getSimplifiedBPMN_EndEvents();

        /**
         * The meta object literal for the '<em><b>Gateways</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SIMPLIFIED_BPMN__GATEWAYS = eINSTANCE.getSimplifiedBPMN_Gateways();

        /**
         * The meta object literal for the '<em><b>Parallel Gateways</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SIMPLIFIED_BPMN__PARALLEL_GATEWAYS = eINSTANCE.getSimplifiedBPMN_ParallelGateways();

        /**
         * The meta object literal for the '<em><b>Sequence Flows</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SIMPLIFIED_BPMN__SEQUENCE_FLOWS = eINSTANCE.getSimplifiedBPMN_SequenceFlows();

        /**
         * The meta object literal for the '<em><b>Resource Types</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SIMPLIFIED_BPMN__RESOURCE_TYPES = eINSTANCE.getSimplifiedBPMN_ResourceTypes();

        /**
         * The meta object literal for the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.TaskImpl <em>Task</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.TaskImpl
         * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedbpmnPackageImpl#getTask()
         * @generated
         */
        EClass TASK = eINSTANCE.getTask();

        /**
         * The meta object literal for the '<em><b>Execution Time</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK__EXECUTION_TIME = eINSTANCE.getTask_ExecutionTime();

        /**
         * The meta object literal for the '<em><b>Resource Needed</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TASK__RESOURCE_NEEDED = eINSTANCE.getTask_ResourceNeeded();

        /**
         * The meta object literal for the '<em><b>Variant</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TASK__VARIANT = eINSTANCE.getTask_Variant();

        /**
         * The meta object literal for the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.StartEventImpl <em>Start Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.StartEventImpl
         * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedbpmnPackageImpl#getStartEvent()
         * @generated
         */
        EClass START_EVENT = eINSTANCE.getStartEvent();

        /**
         * The meta object literal for the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.EndEventImpl <em>End Event</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.EndEventImpl
         * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedbpmnPackageImpl#getEndEvent()
         * @generated
         */
        EClass END_EVENT = eINSTANCE.getEndEvent();

        /**
         * The meta object literal for the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SequenceFlowImpl <em>Sequence Flow</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SequenceFlowImpl
         * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedbpmnPackageImpl#getSequenceFlow()
         * @generated
         */
        EClass SEQUENCE_FLOW = eINSTANCE.getSequenceFlow();

        /**
         * The meta object literal for the '<em><b>Source</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SEQUENCE_FLOW__SOURCE = eINSTANCE.getSequenceFlow_Source();

        /**
         * The meta object literal for the '<em><b>Target</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SEQUENCE_FLOW__TARGET = eINSTANCE.getSequenceFlow_Target();

        /**
         * The meta object literal for the '<em><b>Propability</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SEQUENCE_FLOW__PROPABILITY = eINSTANCE.getSequenceFlow_Propability();

        /**
         * The meta object literal for the '<em><b>Is Data Flow</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SEQUENCE_FLOW__IS_DATA_FLOW = eINSTANCE.getSequenceFlow_IsDataFlow();

        /**
         * The meta object literal for the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.GatewayImpl <em>Gateway</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.GatewayImpl
         * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedbpmnPackageImpl#getGateway()
         * @generated
         */
        EClass GATEWAY = eINSTANCE.getGateway();

        /**
         * The meta object literal for the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.ParallelGatewayImpl <em>Parallel Gateway</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.ParallelGatewayImpl
         * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedbpmnPackageImpl#getParallelGateway()
         * @generated
         */
        EClass PARALLEL_GATEWAY = eINSTANCE.getParallelGateway();

        /**
         * The meta object literal for the '<em><b>Diverging</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PARALLEL_GATEWAY__DIVERGING = eINSTANCE.getParallelGateway_Diverging();

        /**
         * The meta object literal for the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.BaseElementImpl <em>Base Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.BaseElementImpl
         * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedbpmnPackageImpl#getBaseElement()
         * @generated
         */
        EClass BASE_ELEMENT = eINSTANCE.getBaseElement();

        /**
         * The meta object literal for the '<em><b>Out Flows</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference BASE_ELEMENT__OUT_FLOWS = eINSTANCE.getBaseElement_OutFlows();

        /**
         * The meta object literal for the '<em><b>In Flows</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference BASE_ELEMENT__IN_FLOWS = eINSTANCE.getBaseElement_InFlows();

        /**
         * The meta object literal for the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.ResourceTypeImpl <em>Resource Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.ResourceTypeImpl
         * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedbpmnPackageImpl#getResourceType()
         * @generated
         */
        EClass RESOURCE_TYPE = eINSTANCE.getResourceType();

        /**
         * The meta object literal for the '<em><b>Used By Tasks</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RESOURCE_TYPE__USED_BY_TASKS = eINSTANCE.getResourceType_UsedByTasks();

        /**
         * The meta object literal for the '<em><b>Variants</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RESOURCE_TYPE__VARIANTS = eINSTANCE.getResourceType_Variants();

        /**
         * The meta object literal for the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.ResourceInstanceImpl <em>Resource Instance</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.ResourceInstanceImpl
         * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedbpmnPackageImpl#getResourceInstance()
         * @generated
         */
        EClass RESOURCE_INSTANCE = eINSTANCE.getResourceInstance();

        /**
         * The meta object literal for the '<em><b>Resource Type Variant</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RESOURCE_INSTANCE__RESOURCE_TYPE_VARIANT = eINSTANCE.getResourceInstance_ResourceTypeVariant();

        /**
         * The meta object literal for the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.ResourceTypeVariantImpl <em>Resource Type Variant</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.ResourceTypeVariantImpl
         * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedbpmnPackageImpl#getResourceTypeVariant()
         * @generated
         */
        EClass RESOURCE_TYPE_VARIANT = eINSTANCE.getResourceTypeVariant();

        /**
         * The meta object literal for the '<em><b>Efficiency</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RESOURCE_TYPE_VARIANT__EFFICIENCY = eINSTANCE.getResourceTypeVariant_Efficiency();

        /**
         * The meta object literal for the '<em><b>Instances</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RESOURCE_TYPE_VARIANT__INSTANCES = eINSTANCE.getResourceTypeVariant_Instances();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RESOURCE_TYPE_VARIANT__TYPE = eINSTANCE.getResourceTypeVariant_Type();

        /**
         * The meta object literal for the '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.NamedElementImpl <em>Named Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.NamedElementImpl
         * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.impl.SimplifiedbpmnPackageImpl#getNamedElement()
         * @generated
         */
        EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

    }

} //SimplifiedbpmnPackage
