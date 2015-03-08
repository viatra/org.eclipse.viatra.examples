/**
 */
package org.eclipse.viatra.dse.examples.simplifiedbpmn.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.viatra.dse.examples.simplifiedbpmn.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimplifiedbpmnFactoryImpl extends EFactoryImpl implements SimplifiedbpmnFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static SimplifiedbpmnFactory init() {
        try {
            SimplifiedbpmnFactory theSimplifiedbpmnFactory = (SimplifiedbpmnFactory)EPackage.Registry.INSTANCE.getEFactory(SimplifiedbpmnPackage.eNS_URI);
            if (theSimplifiedbpmnFactory != null) {
                return theSimplifiedbpmnFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new SimplifiedbpmnFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SimplifiedbpmnFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case SimplifiedbpmnPackage.SIMPLIFIED_BPMN: return createSimplifiedBPMN();
            case SimplifiedbpmnPackage.TASK: return createTask();
            case SimplifiedbpmnPackage.START_EVENT: return createStartEvent();
            case SimplifiedbpmnPackage.END_EVENT: return createEndEvent();
            case SimplifiedbpmnPackage.SEQUENCE_FLOW: return createSequenceFlow();
            case SimplifiedbpmnPackage.GATEWAY: return createGateway();
            case SimplifiedbpmnPackage.PARALLEL_GATEWAY: return createParallelGateway();
            case SimplifiedbpmnPackage.BASE_ELEMENT: return createBaseElement();
            case SimplifiedbpmnPackage.RESOURCE_TYPE: return createResourceType();
            case SimplifiedbpmnPackage.RESOURCE_INSTANCE: return createResourceInstance();
            case SimplifiedbpmnPackage.RESOURCE_TYPE_VARIANT: return createResourceTypeVariant();
            case SimplifiedbpmnPackage.NAMED_ELEMENT: return createNamedElement();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SimplifiedBPMN createSimplifiedBPMN() {
        SimplifiedBPMNImpl simplifiedBPMN = new SimplifiedBPMNImpl();
        return simplifiedBPMN;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Task createTask() {
        TaskImpl task = new TaskImpl();
        return task;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public StartEvent createStartEvent() {
        StartEventImpl startEvent = new StartEventImpl();
        return startEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EndEvent createEndEvent() {
        EndEventImpl endEvent = new EndEventImpl();
        return endEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SequenceFlow createSequenceFlow() {
        SequenceFlowImpl sequenceFlow = new SequenceFlowImpl();
        return sequenceFlow;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Gateway createGateway() {
        GatewayImpl gateway = new GatewayImpl();
        return gateway;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ParallelGateway createParallelGateway() {
        ParallelGatewayImpl parallelGateway = new ParallelGatewayImpl();
        return parallelGateway;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BaseElement createBaseElement() {
        BaseElementImpl baseElement = new BaseElementImpl();
        return baseElement;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceType createResourceType() {
        ResourceTypeImpl resourceType = new ResourceTypeImpl();
        return resourceType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceInstance createResourceInstance() {
        ResourceInstanceImpl resourceInstance = new ResourceInstanceImpl();
        return resourceInstance;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceTypeVariant createResourceTypeVariant() {
        ResourceTypeVariantImpl resourceTypeVariant = new ResourceTypeVariantImpl();
        return resourceTypeVariant;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NamedElement createNamedElement() {
        NamedElementImpl namedElement = new NamedElementImpl();
        return namedElement;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SimplifiedbpmnPackage getSimplifiedbpmnPackage() {
        return (SimplifiedbpmnPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static SimplifiedbpmnPackage getPackage() {
        return SimplifiedbpmnPackage.eINSTANCE;
    }

} //SimplifiedbpmnFactoryImpl
