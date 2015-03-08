/**
 */
package org.eclipse.viatra.dse.examples.simplifiedbpmn.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.viatra.dse.examples.simplifiedbpmn.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage
 * @generated
 */
public class SimplifiedbpmnAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static SimplifiedbpmnPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SimplifiedbpmnAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = SimplifiedbpmnPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SimplifiedbpmnSwitch<Adapter> modelSwitch =
        new SimplifiedbpmnSwitch<Adapter>() {
            @Override
            public Adapter caseSimplifiedBPMN(SimplifiedBPMN object) {
                return createSimplifiedBPMNAdapter();
            }
            @Override
            public Adapter caseTask(Task object) {
                return createTaskAdapter();
            }
            @Override
            public Adapter caseStartEvent(StartEvent object) {
                return createStartEventAdapter();
            }
            @Override
            public Adapter caseEndEvent(EndEvent object) {
                return createEndEventAdapter();
            }
            @Override
            public Adapter caseSequenceFlow(SequenceFlow object) {
                return createSequenceFlowAdapter();
            }
            @Override
            public Adapter caseGateway(Gateway object) {
                return createGatewayAdapter();
            }
            @Override
            public Adapter caseParallelGateway(ParallelGateway object) {
                return createParallelGatewayAdapter();
            }
            @Override
            public Adapter caseBaseElement(BaseElement object) {
                return createBaseElementAdapter();
            }
            @Override
            public Adapter caseResourceType(ResourceType object) {
                return createResourceTypeAdapter();
            }
            @Override
            public Adapter caseResourceInstance(ResourceInstance object) {
                return createResourceInstanceAdapter();
            }
            @Override
            public Adapter caseResourceTypeVariant(ResourceTypeVariant object) {
                return createResourceTypeVariantAdapter();
            }
            @Override
            public Adapter caseNamedElement(NamedElement object) {
                return createNamedElementAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN <em>Simplified BPMN</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN
     * @generated
     */
    public Adapter createSimplifiedBPMNAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.Task <em>Task</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.Task
     * @generated
     */
    public Adapter createTaskAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.StartEvent <em>Start Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.StartEvent
     * @generated
     */
    public Adapter createStartEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.EndEvent <em>End Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.EndEvent
     * @generated
     */
    public Adapter createEndEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow <em>Sequence Flow</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow
     * @generated
     */
    public Adapter createSequenceFlowAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.Gateway <em>Gateway</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.Gateway
     * @generated
     */
    public Adapter createGatewayAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ParallelGateway <em>Parallel Gateway</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.ParallelGateway
     * @generated
     */
    public Adapter createParallelGatewayAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.BaseElement <em>Base Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.BaseElement
     * @generated
     */
    public Adapter createBaseElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceType <em>Resource Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceType
     * @generated
     */
    public Adapter createResourceTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance <em>Resource Instance</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance
     * @generated
     */
    public Adapter createResourceInstanceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant <em>Resource Type Variant</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant
     * @generated
     */
    public Adapter createResourceTypeVariantAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.viatra.dse.examples.simplifiedbpmn.NamedElement <em>Named Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.viatra.dse.examples.simplifiedbpmn.NamedElement
     * @generated
     */
    public Adapter createNamedElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //SimplifiedbpmnAdapterFactory
