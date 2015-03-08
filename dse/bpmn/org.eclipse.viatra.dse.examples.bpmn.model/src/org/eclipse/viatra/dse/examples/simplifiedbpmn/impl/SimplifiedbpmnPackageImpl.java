/**
 */
package org.eclipse.viatra.dse.examples.simplifiedbpmn.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.viatra.dse.examples.simplifiedbpmn.BaseElement;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.EndEvent;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.Gateway;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.NamedElement;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ParallelGateway;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceType;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnFactory;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.StartEvent;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.Task;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimplifiedbpmnPackageImpl extends EPackageImpl implements SimplifiedbpmnPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass simplifiedBPMNEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass taskEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass startEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass endEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass sequenceFlowEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass gatewayEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass parallelGatewayEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass baseElementEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass resourceTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass resourceInstanceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass resourceTypeVariantEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass namedElementEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private SimplifiedbpmnPackageImpl() {
        super(eNS_URI, SimplifiedbpmnFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link SimplifiedbpmnPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static SimplifiedbpmnPackage init() {
        if (isInited) return (SimplifiedbpmnPackage)EPackage.Registry.INSTANCE.getEPackage(SimplifiedbpmnPackage.eNS_URI);

        // Obtain or create and register package
        SimplifiedbpmnPackageImpl theSimplifiedbpmnPackage = (SimplifiedbpmnPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SimplifiedbpmnPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SimplifiedbpmnPackageImpl());

        isInited = true;

        // Create package meta-data objects
        theSimplifiedbpmnPackage.createPackageContents();

        // Initialize created meta-data
        theSimplifiedbpmnPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theSimplifiedbpmnPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(SimplifiedbpmnPackage.eNS_URI, theSimplifiedbpmnPackage);
        return theSimplifiedbpmnPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSimplifiedBPMN() {
        return simplifiedBPMNEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSimplifiedBPMN_Tasks() {
        return (EReference)simplifiedBPMNEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSimplifiedBPMN_StartEvents() {
        return (EReference)simplifiedBPMNEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSimplifiedBPMN_EndEvents() {
        return (EReference)simplifiedBPMNEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSimplifiedBPMN_Gateways() {
        return (EReference)simplifiedBPMNEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSimplifiedBPMN_ParallelGateways() {
        return (EReference)simplifiedBPMNEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSimplifiedBPMN_SequenceFlows() {
        return (EReference)simplifiedBPMNEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSimplifiedBPMN_ResourceTypes() {
        return (EReference)simplifiedBPMNEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTask() {
        return taskEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTask_ExecutionTime() {
        return (EAttribute)taskEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTask_ResourceNeeded() {
        return (EReference)taskEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTask_Variant() {
        return (EReference)taskEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getStartEvent() {
        return startEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEndEvent() {
        return endEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSequenceFlow() {
        return sequenceFlowEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSequenceFlow_Source() {
        return (EReference)sequenceFlowEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSequenceFlow_Target() {
        return (EReference)sequenceFlowEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSequenceFlow_Propability() {
        return (EAttribute)sequenceFlowEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSequenceFlow_IsDataFlow() {
        return (EAttribute)sequenceFlowEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGateway() {
        return gatewayEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getParallelGateway() {
        return parallelGatewayEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getParallelGateway_Diverging() {
        return (EAttribute)parallelGatewayEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getBaseElement() {
        return baseElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBaseElement_OutFlows() {
        return (EReference)baseElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBaseElement_InFlows() {
        return (EReference)baseElementEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getResourceType() {
        return resourceTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getResourceType_UsedByTasks() {
        return (EReference)resourceTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getResourceType_Variants() {
        return (EReference)resourceTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getResourceInstance() {
        return resourceInstanceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getResourceInstance_ResourceTypeVariant() {
        return (EReference)resourceInstanceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getResourceTypeVariant() {
        return resourceTypeVariantEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getResourceTypeVariant_Efficiency() {
        return (EAttribute)resourceTypeVariantEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getResourceTypeVariant_Instances() {
        return (EReference)resourceTypeVariantEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getResourceTypeVariant_Type() {
        return (EReference)resourceTypeVariantEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getNamedElement() {
        return namedElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNamedElement_Name() {
        return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SimplifiedbpmnFactory getSimplifiedbpmnFactory() {
        return (SimplifiedbpmnFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        simplifiedBPMNEClass = createEClass(SIMPLIFIED_BPMN);
        createEReference(simplifiedBPMNEClass, SIMPLIFIED_BPMN__TASKS);
        createEReference(simplifiedBPMNEClass, SIMPLIFIED_BPMN__START_EVENTS);
        createEReference(simplifiedBPMNEClass, SIMPLIFIED_BPMN__END_EVENTS);
        createEReference(simplifiedBPMNEClass, SIMPLIFIED_BPMN__GATEWAYS);
        createEReference(simplifiedBPMNEClass, SIMPLIFIED_BPMN__PARALLEL_GATEWAYS);
        createEReference(simplifiedBPMNEClass, SIMPLIFIED_BPMN__SEQUENCE_FLOWS);
        createEReference(simplifiedBPMNEClass, SIMPLIFIED_BPMN__RESOURCE_TYPES);

        taskEClass = createEClass(TASK);
        createEAttribute(taskEClass, TASK__EXECUTION_TIME);
        createEReference(taskEClass, TASK__RESOURCE_NEEDED);
        createEReference(taskEClass, TASK__VARIANT);

        startEventEClass = createEClass(START_EVENT);

        endEventEClass = createEClass(END_EVENT);

        sequenceFlowEClass = createEClass(SEQUENCE_FLOW);
        createEReference(sequenceFlowEClass, SEQUENCE_FLOW__SOURCE);
        createEReference(sequenceFlowEClass, SEQUENCE_FLOW__TARGET);
        createEAttribute(sequenceFlowEClass, SEQUENCE_FLOW__PROPABILITY);
        createEAttribute(sequenceFlowEClass, SEQUENCE_FLOW__IS_DATA_FLOW);

        gatewayEClass = createEClass(GATEWAY);

        parallelGatewayEClass = createEClass(PARALLEL_GATEWAY);
        createEAttribute(parallelGatewayEClass, PARALLEL_GATEWAY__DIVERGING);

        baseElementEClass = createEClass(BASE_ELEMENT);
        createEReference(baseElementEClass, BASE_ELEMENT__OUT_FLOWS);
        createEReference(baseElementEClass, BASE_ELEMENT__IN_FLOWS);

        resourceTypeEClass = createEClass(RESOURCE_TYPE);
        createEReference(resourceTypeEClass, RESOURCE_TYPE__USED_BY_TASKS);
        createEReference(resourceTypeEClass, RESOURCE_TYPE__VARIANTS);

        resourceInstanceEClass = createEClass(RESOURCE_INSTANCE);
        createEReference(resourceInstanceEClass, RESOURCE_INSTANCE__RESOURCE_TYPE_VARIANT);

        resourceTypeVariantEClass = createEClass(RESOURCE_TYPE_VARIANT);
        createEAttribute(resourceTypeVariantEClass, RESOURCE_TYPE_VARIANT__EFFICIENCY);
        createEReference(resourceTypeVariantEClass, RESOURCE_TYPE_VARIANT__INSTANCES);
        createEReference(resourceTypeVariantEClass, RESOURCE_TYPE_VARIANT__TYPE);

        namedElementEClass = createEClass(NAMED_ELEMENT);
        createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        taskEClass.getESuperTypes().add(this.getBaseElement());
        startEventEClass.getESuperTypes().add(this.getBaseElement());
        endEventEClass.getESuperTypes().add(this.getBaseElement());
        gatewayEClass.getESuperTypes().add(this.getBaseElement());
        parallelGatewayEClass.getESuperTypes().add(this.getBaseElement());
        baseElementEClass.getESuperTypes().add(this.getNamedElement());
        resourceTypeEClass.getESuperTypes().add(this.getNamedElement());
        resourceTypeVariantEClass.getESuperTypes().add(this.getNamedElement());

        // Initialize classes, features, and operations; add parameters
        initEClass(simplifiedBPMNEClass, SimplifiedBPMN.class, "SimplifiedBPMN", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getSimplifiedBPMN_Tasks(), this.getTask(), null, "tasks", null, 0, -1, SimplifiedBPMN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSimplifiedBPMN_StartEvents(), this.getStartEvent(), null, "startEvents", null, 0, -1, SimplifiedBPMN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSimplifiedBPMN_EndEvents(), this.getEndEvent(), null, "endEvents", null, 0, -1, SimplifiedBPMN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSimplifiedBPMN_Gateways(), this.getGateway(), null, "gateways", null, 0, -1, SimplifiedBPMN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSimplifiedBPMN_ParallelGateways(), this.getParallelGateway(), null, "parallelGateways", null, 0, -1, SimplifiedBPMN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSimplifiedBPMN_SequenceFlows(), this.getSequenceFlow(), null, "sequenceFlows", null, 0, -1, SimplifiedBPMN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSimplifiedBPMN_ResourceTypes(), this.getResourceType(), null, "resourceTypes", null, 0, -1, SimplifiedBPMN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(taskEClass, Task.class, "Task", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTask_ExecutionTime(), ecorePackage.getEInt(), "executionTime", null, 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTask_ResourceNeeded(), this.getResourceType(), this.getResourceType_UsedByTasks(), "resourceNeeded", null, 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTask_Variant(), this.getResourceTypeVariant(), null, "variant", null, 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(startEventEClass, StartEvent.class, "StartEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(endEventEClass, EndEvent.class, "EndEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(sequenceFlowEClass, SequenceFlow.class, "SequenceFlow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getSequenceFlow_Source(), this.getBaseElement(), this.getBaseElement_OutFlows(), "source", null, 0, 1, SequenceFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSequenceFlow_Target(), this.getBaseElement(), this.getBaseElement_InFlows(), "target", null, 0, 1, SequenceFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSequenceFlow_Propability(), ecorePackage.getEInt(), "propability", null, 0, 1, SequenceFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSequenceFlow_IsDataFlow(), ecorePackage.getEBoolean(), "isDataFlow", null, 0, 1, SequenceFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(gatewayEClass, Gateway.class, "Gateway", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(parallelGatewayEClass, ParallelGateway.class, "ParallelGateway", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getParallelGateway_Diverging(), ecorePackage.getEBoolean(), "diverging", null, 0, 1, ParallelGateway.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(baseElementEClass, BaseElement.class, "BaseElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getBaseElement_OutFlows(), this.getSequenceFlow(), this.getSequenceFlow_Source(), "outFlows", null, 0, -1, BaseElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getBaseElement_InFlows(), this.getSequenceFlow(), this.getSequenceFlow_Target(), "inFlows", null, 0, -1, BaseElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(resourceTypeEClass, ResourceType.class, "ResourceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getResourceType_UsedByTasks(), this.getTask(), this.getTask_ResourceNeeded(), "usedByTasks", null, 0, -1, ResourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getResourceType_Variants(), this.getResourceTypeVariant(), this.getResourceTypeVariant_Type(), "variants", null, 0, -1, ResourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(resourceInstanceEClass, ResourceInstance.class, "ResourceInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getResourceInstance_ResourceTypeVariant(), this.getResourceTypeVariant(), this.getResourceTypeVariant_Instances(), "resourceTypeVariant", null, 0, 1, ResourceInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(resourceTypeVariantEClass, ResourceTypeVariant.class, "ResourceTypeVariant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getResourceTypeVariant_Efficiency(), ecorePackage.getEDouble(), "efficiency", "1.0", 0, 1, ResourceTypeVariant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getResourceTypeVariant_Instances(), this.getResourceInstance(), this.getResourceInstance_ResourceTypeVariant(), "instances", null, 0, -1, ResourceTypeVariant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getResourceTypeVariant_Type(), this.getResourceType(), this.getResourceType_Variants(), "type", null, 0, 1, ResourceTypeVariant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(namedElementEClass, NamedElement.class, "NamedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //SimplifiedbpmnPackageImpl
