package org.eclipse.viatra.dse.examples.bpmn.rules

import org.eclipse.viatra.dse.examples.bpmn.patterns.util.AllocateTaskToVariantQuerySpecification
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.CreateResourceQuerySpecification
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.MakeParallelQuerySpecification
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.MakeSequentialQuerySpecification
import org.eclipse.viatra.dse.examples.bpmn.problems.BpmnProblems
import org.eclipse.viatra.dse.examples.bpmn.problems.SimplifiedBpmnBuilder
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnFactory
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRule
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory

class BpmnRuleProvider {
    private extension BatchTransformationRuleFactory factory = new BatchTransformationRuleFactory

    public BatchTransformationRule<?, ?> allocateRule
    public BatchTransformationRule<?, ?> createResourceRule
    public BatchTransformationRule<?, ?> makeParallelRule
    public BatchTransformationRule<?, ?> makeSequentialRule
    public BatchTransformationRule<?, ?> allocateRuleFilteredExample
    

    new() {
        allocateRule = createRule
            .name("AllocateTaskToVariantRule")
            .precondition(AllocateTaskToVariantQuerySpecification.instance())
            .action()[
                t.setVariant(RTV)
            ]
            .build()

        allocateRuleFilteredExample = createRule
            .name("AllocateTaskToVariantRule")
            .precondition(AllocateTaskToVariantQuerySpecification.instance())
            .action()[
                t.setVariant(RTV)
            ]
            .filter()[
                if (it.RTV.name.equals(BpmnProblems.NOSQL_MEDIUM) ||
                    it.RTV.name.equals(BpmnProblems.SQL_MEDIUM)) {
                    return false;
                }
                return true;
            ]
            .build()

        createResourceRule = createRule
            .name("CreateResourceRule")
            .precondition(CreateResourceQuerySpecification.instance())
            .action() [
                RTV.getInstances().add(SimplifiedbpmnFactory.eINSTANCE.createResourceInstance())
            ]
            .build()

        makeParallelRule = createRule
            .name("MakeParallelRule")
            .precondition(MakeParallelQuerySpecification.instance())
            .action()[
                val builder = new SimplifiedBpmnBuilder(root)

                val divergingGateway = builder.createParallelGateway(t1, t2, true)
                val convergingGateway = builder.createParallelGateway(t1, t2, false)

                var flows = t1.getInFlows()
                while (!flows.isEmpty()) {
                    val flow = flows.get(0)
                    flow.setTarget(divergingGateway)
                }
                flows = t2.getOutFlows()
                while (!flows.isEmpty()) {
                    val flow = flows.get(0)
                    flow.setSource(convergingGateway)
                }

                val flow = t1.getOutFlows().get(0)
                root.getSequenceFlows().remove(flow)
                flow.setTarget(null)
                flow.setSource(null)

                builder.createFlow(divergingGateway, t1)
                builder.createFlow(divergingGateway, t2)
                builder.createFlow(t1, convergingGateway)
                builder.createFlow(t2, convergingGateway)
            ]
            .build()

        makeSequentialRule = createRule
            .name("MakeSequentialRule")
            .precondition(MakeSequentialQuerySpecification.instance())
            .action() [
                var flows = t1.getInFlows()
                val divergingGateway = flows.get(0).getSource()
                root.getParallelGateways().remove(divergingGateway)
                root.getSequenceFlows().removeAll(flows)
                flows.clear()
                flows = t2.getInFlows()
                root.getSequenceFlows().removeAll(flows)
                flows.clear()
                flows = t1.getOutFlows()
                root.getSequenceFlows().removeAll(flows)
                flows.clear()
                flows = t2.getOutFlows()
                val convergingGateway = flows.get(0).getTarget()
                root.getParallelGateways().remove(convergingGateway)
                root.getSequenceFlows().removeAll(flows)
                flows.clear()

                flows = divergingGateway.getInFlows()
                while (!flows.isEmpty()) {
                    val flow = flows.get(0)
                    flow.setTarget(t1)
                }
                flows = convergingGateway.getOutFlows()
                while (!flows.isEmpty()) {
                    val flow = flows.get(0)
                    flow.setSource(t2)
                }

                new SimplifiedBpmnBuilder(root).createFlow(t1, t2)
            ]
            .build()
    }
}