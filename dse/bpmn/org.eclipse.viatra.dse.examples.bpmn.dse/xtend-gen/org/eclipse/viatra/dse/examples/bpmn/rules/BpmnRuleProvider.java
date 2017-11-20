package org.eclipse.viatra.dse.examples.bpmn.rules;

import org.eclipse.emf.common.util.EList;
import org.eclipse.viatra.dse.examples.bpmn.patterns.AllocateTaskToVariantMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.AllocateTaskToVariantMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.CreateResourceMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.CreateResourceMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.MakeParallelMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.MakeParallelMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.MakeSequentialMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.MakeSequentialMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.AllocateTaskToVariantQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.CreateResourceQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.MakeParallelQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.MakeSequentialQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.problems.BpmnProblems;
import org.eclipse.viatra.dse.examples.bpmn.problems.SimplifiedBpmnBuilder;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.BaseElement;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ParallelGateway;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnFactory;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.Task;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.transformation.evm.api.event.EventFilter;
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRule;
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class BpmnRuleProvider {
  @Extension
  private BatchTransformationRuleFactory factory = new BatchTransformationRuleFactory();
  
  public BatchTransformationRule<?, ?> allocateRule;
  
  public BatchTransformationRule<?, ?> createResourceRule;
  
  public BatchTransformationRule<?, ?> makeParallelRule;
  
  public BatchTransformationRule<?, ?> makeSequentialRule;
  
  public BatchTransformationRule<?, ?> allocateRuleFilteredExample;
  
  public BpmnRuleProvider() {
    try {
      final IMatchProcessor<AllocateTaskToVariantMatch> _function = (AllocateTaskToVariantMatch it) -> {
        Task _t = it.getT();
        _t.setVariant(it.getRTV());
      };
      this.allocateRule = this.factory.<AllocateTaskToVariantMatch, AllocateTaskToVariantMatcher>createRule().name("AllocateTaskToVariantRule").precondition(AllocateTaskToVariantQuerySpecification.instance()).action(_function).build();
      final IMatchProcessor<AllocateTaskToVariantMatch> _function_1 = (AllocateTaskToVariantMatch it) -> {
        Task _t = it.getT();
        _t.setVariant(it.getRTV());
      };
      final EventFilter<AllocateTaskToVariantMatch> _function_2 = (AllocateTaskToVariantMatch it) -> {
        if ((it.getRTV().getName().equals(BpmnProblems.NOSQL_MEDIUM) || 
          it.getRTV().getName().equals(BpmnProblems.SQL_MEDIUM))) {
          return false;
        }
        return true;
      };
      this.allocateRuleFilteredExample = this.factory.<AllocateTaskToVariantMatch, AllocateTaskToVariantMatcher>createRule().name("FilteredAllocateTaskToVariantRule").precondition(AllocateTaskToVariantQuerySpecification.instance()).action(_function_1).filter(_function_2).build();
      final IMatchProcessor<CreateResourceMatch> _function_3 = (CreateResourceMatch it) -> {
        EList<ResourceInstance> _instances = it.getRTV().getInstances();
        ResourceInstance _createResourceInstance = SimplifiedbpmnFactory.eINSTANCE.createResourceInstance();
        _instances.add(_createResourceInstance);
      };
      this.createResourceRule = this.factory.<CreateResourceMatch, CreateResourceMatcher>createRule().name("CreateResourceRule").precondition(CreateResourceQuerySpecification.instance()).action(_function_3).build();
      final IMatchProcessor<MakeParallelMatch> _function_4 = (MakeParallelMatch it) -> {
        SimplifiedBPMN _root = it.getRoot();
        final SimplifiedBpmnBuilder builder = new SimplifiedBpmnBuilder(_root);
        final ParallelGateway divergingGateway = builder.createParallelGateway(it.getT1(), it.getT2(), true);
        final ParallelGateway convergingGateway = builder.createParallelGateway(it.getT1(), it.getT2(), false);
        EList<SequenceFlow> flows = it.getT1().getInFlows();
        while ((!flows.isEmpty())) {
          {
            final SequenceFlow flow = flows.get(0);
            flow.setTarget(divergingGateway);
          }
        }
        flows = it.getT2().getOutFlows();
        while ((!flows.isEmpty())) {
          {
            final SequenceFlow flow = flows.get(0);
            flow.setSource(convergingGateway);
          }
        }
        final SequenceFlow flow = it.getT1().getOutFlows().get(0);
        EList<SequenceFlow> _sequenceFlows = it.getRoot().getSequenceFlows();
        _sequenceFlows.remove(flow);
        flow.setTarget(null);
        flow.setSource(null);
        builder.createFlow(divergingGateway, it.getT1());
        builder.createFlow(divergingGateway, it.getT2());
        builder.createFlow(it.getT1(), convergingGateway);
        builder.createFlow(it.getT2(), convergingGateway);
      };
      this.makeParallelRule = this.factory.<MakeParallelMatch, MakeParallelMatcher>createRule().name("MakeParallelRule").precondition(MakeParallelQuerySpecification.instance()).action(_function_4).build();
      final IMatchProcessor<MakeSequentialMatch> _function_5 = (MakeSequentialMatch it) -> {
        EList<SequenceFlow> flows = it.getT1().getInFlows();
        final BaseElement divergingGateway = flows.get(0).getSource();
        it.getRoot().getParallelGateways().remove(divergingGateway);
        it.getRoot().getSequenceFlows().removeAll(flows);
        flows.clear();
        flows = it.getT2().getInFlows();
        it.getRoot().getSequenceFlows().removeAll(flows);
        flows.clear();
        flows = it.getT1().getOutFlows();
        it.getRoot().getSequenceFlows().removeAll(flows);
        flows.clear();
        flows = it.getT2().getOutFlows();
        final BaseElement convergingGateway = flows.get(0).getTarget();
        it.getRoot().getParallelGateways().remove(convergingGateway);
        it.getRoot().getSequenceFlows().removeAll(flows);
        flows.clear();
        flows = divergingGateway.getInFlows();
        while ((!flows.isEmpty())) {
          {
            final SequenceFlow flow = flows.get(0);
            flow.setTarget(it.getT1());
          }
        }
        flows = convergingGateway.getOutFlows();
        while ((!flows.isEmpty())) {
          {
            final SequenceFlow flow = flows.get(0);
            flow.setSource(it.getT2());
          }
        }
        SimplifiedBPMN _root = it.getRoot();
        new SimplifiedBpmnBuilder(_root).createFlow(it.getT1(), it.getT2());
      };
      this.makeSequentialRule = this.factory.<MakeSequentialMatch, MakeSequentialMatcher>createRule().name("MakeSequentialRule").precondition(MakeSequentialQuerySpecification.instance()).action(_function_5).build();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
