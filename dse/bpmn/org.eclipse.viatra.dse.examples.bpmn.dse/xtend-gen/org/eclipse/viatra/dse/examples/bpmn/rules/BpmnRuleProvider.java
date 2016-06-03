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
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant;
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
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<AllocateTaskToVariantMatch, AllocateTaskToVariantMatcher> _createRule = this.factory.<AllocateTaskToVariantMatch, AllocateTaskToVariantMatcher>createRule();
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<AllocateTaskToVariantMatch, AllocateTaskToVariantMatcher> _name = _createRule.name("AllocateTaskToVariantRule");
      AllocateTaskToVariantQuerySpecification _instance = AllocateTaskToVariantQuerySpecification.instance();
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<AllocateTaskToVariantMatch, AllocateTaskToVariantMatcher> _precondition = _name.precondition(_instance);
      final IMatchProcessor<AllocateTaskToVariantMatch> _function = new IMatchProcessor<AllocateTaskToVariantMatch>() {
        @Override
        public void process(final AllocateTaskToVariantMatch it) {
          Task _t = it.getT();
          ResourceTypeVariant _rTV = it.getRTV();
          _t.setVariant(_rTV);
        }
      };
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<AllocateTaskToVariantMatch, AllocateTaskToVariantMatcher> _action = _precondition.action(_function);
      BatchTransformationRule<AllocateTaskToVariantMatch, AllocateTaskToVariantMatcher> _build = _action.build();
      this.allocateRule = _build;
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<AllocateTaskToVariantMatch, AllocateTaskToVariantMatcher> _createRule_1 = this.factory.<AllocateTaskToVariantMatch, AllocateTaskToVariantMatcher>createRule();
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<AllocateTaskToVariantMatch, AllocateTaskToVariantMatcher> _name_1 = _createRule_1.name("AllocateTaskToVariantRule");
      AllocateTaskToVariantQuerySpecification _instance_1 = AllocateTaskToVariantQuerySpecification.instance();
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<AllocateTaskToVariantMatch, AllocateTaskToVariantMatcher> _precondition_1 = _name_1.precondition(_instance_1);
      final IMatchProcessor<AllocateTaskToVariantMatch> _function_1 = new IMatchProcessor<AllocateTaskToVariantMatch>() {
        @Override
        public void process(final AllocateTaskToVariantMatch it) {
          Task _t = it.getT();
          ResourceTypeVariant _rTV = it.getRTV();
          _t.setVariant(_rTV);
        }
      };
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<AllocateTaskToVariantMatch, AllocateTaskToVariantMatcher> _action_1 = _precondition_1.action(_function_1);
      final EventFilter<AllocateTaskToVariantMatch> _function_2 = new EventFilter<AllocateTaskToVariantMatch>() {
        @Override
        public boolean isProcessable(final AllocateTaskToVariantMatch it) {
          if ((it.getRTV().getName().equals(BpmnProblems.NOSQL_MEDIUM) || 
            it.getRTV().getName().equals(BpmnProblems.SQL_MEDIUM))) {
            return false;
          }
          return true;
        }
      };
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<AllocateTaskToVariantMatch, AllocateTaskToVariantMatcher> _filter = _action_1.filter(_function_2);
      BatchTransformationRule<AllocateTaskToVariantMatch, AllocateTaskToVariantMatcher> _build_1 = _filter.build();
      this.allocateRuleFilteredExample = _build_1;
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CreateResourceMatch, CreateResourceMatcher> _createRule_2 = this.factory.<CreateResourceMatch, CreateResourceMatcher>createRule();
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CreateResourceMatch, CreateResourceMatcher> _name_2 = _createRule_2.name("CreateResourceRule");
      CreateResourceQuerySpecification _instance_2 = CreateResourceQuerySpecification.instance();
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CreateResourceMatch, CreateResourceMatcher> _precondition_2 = _name_2.precondition(_instance_2);
      final IMatchProcessor<CreateResourceMatch> _function_3 = new IMatchProcessor<CreateResourceMatch>() {
        @Override
        public void process(final CreateResourceMatch it) {
          ResourceTypeVariant _rTV = it.getRTV();
          EList<ResourceInstance> _instances = _rTV.getInstances();
          ResourceInstance _createResourceInstance = SimplifiedbpmnFactory.eINSTANCE.createResourceInstance();
          _instances.add(_createResourceInstance);
        }
      };
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CreateResourceMatch, CreateResourceMatcher> _action_2 = _precondition_2.action(_function_3);
      BatchTransformationRule<CreateResourceMatch, CreateResourceMatcher> _build_2 = _action_2.build();
      this.createResourceRule = _build_2;
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<MakeParallelMatch, MakeParallelMatcher> _createRule_3 = this.factory.<MakeParallelMatch, MakeParallelMatcher>createRule();
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<MakeParallelMatch, MakeParallelMatcher> _name_3 = _createRule_3.name("MakeParallelRule");
      MakeParallelQuerySpecification _instance_3 = MakeParallelQuerySpecification.instance();
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<MakeParallelMatch, MakeParallelMatcher> _precondition_3 = _name_3.precondition(_instance_3);
      final IMatchProcessor<MakeParallelMatch> _function_4 = new IMatchProcessor<MakeParallelMatch>() {
        @Override
        public void process(final MakeParallelMatch it) {
          SimplifiedBPMN _root = it.getRoot();
          final SimplifiedBpmnBuilder builder = new SimplifiedBpmnBuilder(_root);
          Task _t1 = it.getT1();
          Task _t2 = it.getT2();
          final ParallelGateway divergingGateway = builder.createParallelGateway(_t1, _t2, true);
          Task _t1_1 = it.getT1();
          Task _t2_1 = it.getT2();
          final ParallelGateway convergingGateway = builder.createParallelGateway(_t1_1, _t2_1, false);
          Task _t1_2 = it.getT1();
          EList<SequenceFlow> flows = _t1_2.getInFlows();
          while ((!flows.isEmpty())) {
            {
              final SequenceFlow flow = flows.get(0);
              flow.setTarget(divergingGateway);
            }
          }
          Task _t2_2 = it.getT2();
          EList<SequenceFlow> _outFlows = _t2_2.getOutFlows();
          flows = _outFlows;
          while ((!flows.isEmpty())) {
            {
              final SequenceFlow flow = flows.get(0);
              flow.setSource(convergingGateway);
            }
          }
          Task _t1_3 = it.getT1();
          EList<SequenceFlow> _outFlows_1 = _t1_3.getOutFlows();
          final SequenceFlow flow = _outFlows_1.get(0);
          SimplifiedBPMN _root_1 = it.getRoot();
          EList<SequenceFlow> _sequenceFlows = _root_1.getSequenceFlows();
          _sequenceFlows.remove(flow);
          flow.setTarget(null);
          flow.setSource(null);
          Task _t1_4 = it.getT1();
          builder.createFlow(divergingGateway, _t1_4);
          Task _t2_3 = it.getT2();
          builder.createFlow(divergingGateway, _t2_3);
          Task _t1_5 = it.getT1();
          builder.createFlow(_t1_5, convergingGateway);
          Task _t2_4 = it.getT2();
          builder.createFlow(_t2_4, convergingGateway);
        }
      };
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<MakeParallelMatch, MakeParallelMatcher> _action_3 = _precondition_3.action(_function_4);
      BatchTransformationRule<MakeParallelMatch, MakeParallelMatcher> _build_3 = _action_3.build();
      this.makeParallelRule = _build_3;
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<MakeSequentialMatch, MakeSequentialMatcher> _createRule_4 = this.factory.<MakeSequentialMatch, MakeSequentialMatcher>createRule();
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<MakeSequentialMatch, MakeSequentialMatcher> _name_4 = _createRule_4.name("MakeSequentialRule");
      MakeSequentialQuerySpecification _instance_4 = MakeSequentialQuerySpecification.instance();
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<MakeSequentialMatch, MakeSequentialMatcher> _precondition_4 = _name_4.precondition(_instance_4);
      final IMatchProcessor<MakeSequentialMatch> _function_5 = new IMatchProcessor<MakeSequentialMatch>() {
        @Override
        public void process(final MakeSequentialMatch it) {
          Task _t1 = it.getT1();
          EList<SequenceFlow> flows = _t1.getInFlows();
          SequenceFlow _get = flows.get(0);
          final BaseElement divergingGateway = _get.getSource();
          SimplifiedBPMN _root = it.getRoot();
          EList<ParallelGateway> _parallelGateways = _root.getParallelGateways();
          _parallelGateways.remove(divergingGateway);
          SimplifiedBPMN _root_1 = it.getRoot();
          EList<SequenceFlow> _sequenceFlows = _root_1.getSequenceFlows();
          _sequenceFlows.removeAll(flows);
          flows.clear();
          Task _t2 = it.getT2();
          EList<SequenceFlow> _inFlows = _t2.getInFlows();
          flows = _inFlows;
          SimplifiedBPMN _root_2 = it.getRoot();
          EList<SequenceFlow> _sequenceFlows_1 = _root_2.getSequenceFlows();
          _sequenceFlows_1.removeAll(flows);
          flows.clear();
          Task _t1_1 = it.getT1();
          EList<SequenceFlow> _outFlows = _t1_1.getOutFlows();
          flows = _outFlows;
          SimplifiedBPMN _root_3 = it.getRoot();
          EList<SequenceFlow> _sequenceFlows_2 = _root_3.getSequenceFlows();
          _sequenceFlows_2.removeAll(flows);
          flows.clear();
          Task _t2_1 = it.getT2();
          EList<SequenceFlow> _outFlows_1 = _t2_1.getOutFlows();
          flows = _outFlows_1;
          SequenceFlow _get_1 = flows.get(0);
          final BaseElement convergingGateway = _get_1.getTarget();
          SimplifiedBPMN _root_4 = it.getRoot();
          EList<ParallelGateway> _parallelGateways_1 = _root_4.getParallelGateways();
          _parallelGateways_1.remove(convergingGateway);
          SimplifiedBPMN _root_5 = it.getRoot();
          EList<SequenceFlow> _sequenceFlows_3 = _root_5.getSequenceFlows();
          _sequenceFlows_3.removeAll(flows);
          flows.clear();
          EList<SequenceFlow> _inFlows_1 = divergingGateway.getInFlows();
          flows = _inFlows_1;
          while ((!flows.isEmpty())) {
            {
              final SequenceFlow flow = flows.get(0);
              Task _t1_2 = it.getT1();
              flow.setTarget(_t1_2);
            }
          }
          EList<SequenceFlow> _outFlows_2 = convergingGateway.getOutFlows();
          flows = _outFlows_2;
          while ((!flows.isEmpty())) {
            {
              final SequenceFlow flow = flows.get(0);
              Task _t2_2 = it.getT2();
              flow.setSource(_t2_2);
            }
          }
          SimplifiedBPMN _root_6 = it.getRoot();
          SimplifiedBpmnBuilder _simplifiedBpmnBuilder = new SimplifiedBpmnBuilder(_root_6);
          Task _t1_2 = it.getT1();
          Task _t2_2 = it.getT2();
          _simplifiedBpmnBuilder.createFlow(_t1_2, _t2_2);
        }
      };
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<MakeSequentialMatch, MakeSequentialMatcher> _action_4 = _precondition_4.action(_function_5);
      BatchTransformationRule<MakeSequentialMatch, MakeSequentialMatcher> _build_4 = _action_4.build();
      this.makeSequentialRule = _build_4;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
