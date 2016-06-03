/**
 * Copyright (c) 2010-2015, Andras Szabolcs Nagy and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * Andras Szabolcs Nagy - initial API and implementation
 */
package org.eclipse.viatra.dse.examples.cps.rules;

import org.eclipse.emf.common.util.EList;
import org.eclipse.viatra.dse.examples.cps.ApplicationInstance;
import org.eclipse.viatra.dse.examples.cps.ApplicationType;
import org.eclipse.viatra.dse.examples.cps.CpsFactory;
import org.eclipse.viatra.dse.examples.cps.CyberPhysicalSystem;
import org.eclipse.viatra.dse.examples.cps.HostInstance;
import org.eclipse.viatra.dse.examples.cps.HostType;
import org.eclipse.viatra.dse.examples.cps.Request;
import org.eclipse.viatra.dse.examples.cps.Requirement;
import org.eclipse.viatra.dse.examples.cps.ResourceRequirement;
import org.eclipse.viatra.dse.examples.cps.State;
import org.eclipse.viatra.dse.examples.cps.patterns.AllocateMatch;
import org.eclipse.viatra.dse.examples.cps.patterns.AllocateMatcher;
import org.eclipse.viatra.dse.examples.cps.patterns.CancelRequestMatch;
import org.eclipse.viatra.dse.examples.cps.patterns.CancelRequestMatcher;
import org.eclipse.viatra.dse.examples.cps.patterns.CreateApplicationInstanceMatch;
import org.eclipse.viatra.dse.examples.cps.patterns.CreateApplicationInstanceMatcher;
import org.eclipse.viatra.dse.examples.cps.patterns.CreateApplicationInstancesMatch;
import org.eclipse.viatra.dse.examples.cps.patterns.CreateApplicationInstancesMatcher;
import org.eclipse.viatra.dse.examples.cps.patterns.CreateHostInstanceMatch;
import org.eclipse.viatra.dse.examples.cps.patterns.CreateHostInstanceMatcher;
import org.eclipse.viatra.dse.examples.cps.patterns.DeleteAllocationMatch;
import org.eclipse.viatra.dse.examples.cps.patterns.DeleteAllocationMatcher;
import org.eclipse.viatra.dse.examples.cps.patterns.MoveMatch;
import org.eclipse.viatra.dse.examples.cps.patterns.MoveMatcher;
import org.eclipse.viatra.dse.examples.cps.patterns.RemoveHostInstanceMatch;
import org.eclipse.viatra.dse.examples.cps.patterns.RemoveHostInstanceMatcher;
import org.eclipse.viatra.dse.examples.cps.patterns.StartInstanceMatch;
import org.eclipse.viatra.dse.examples.cps.patterns.StartInstanceMatcher;
import org.eclipse.viatra.dse.examples.cps.patterns.StopInstanceMatch;
import org.eclipse.viatra.dse.examples.cps.patterns.StopInstanceMatcher;
import org.eclipse.viatra.dse.examples.cps.patterns.util.AllocateQuerySpecification;
import org.eclipse.viatra.dse.examples.cps.patterns.util.CancelRequestQuerySpecification;
import org.eclipse.viatra.dse.examples.cps.patterns.util.CreateApplicationInstanceQuerySpecification;
import org.eclipse.viatra.dse.examples.cps.patterns.util.CreateApplicationInstancesQuerySpecification;
import org.eclipse.viatra.dse.examples.cps.patterns.util.CreateHostInstanceQuerySpecification;
import org.eclipse.viatra.dse.examples.cps.patterns.util.DeleteAllocationQuerySpecification;
import org.eclipse.viatra.dse.examples.cps.patterns.util.MoveQuerySpecification;
import org.eclipse.viatra.dse.examples.cps.patterns.util.RemoveHostInstanceQuerySpecification;
import org.eclipse.viatra.dse.examples.cps.patterns.util.StartInstanceQuerySpecification;
import org.eclipse.viatra.dse.examples.cps.patterns.util.StopInstanceQuerySpecification;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRule;
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class CpsRuleProvider {
  @Extension
  private BatchTransformationRuleFactory ruleFactory = new BatchTransformationRuleFactory();
  
  public BatchTransformationRule<AllocateMatch, AllocateMatcher> allocateRule;
  
  public BatchTransformationRule<DeleteAllocationMatch, DeleteAllocationMatcher> deleteAllocRule;
  
  public BatchTransformationRule<MoveMatch, MoveMatcher> moveRule;
  
  public BatchTransformationRule<StartInstanceMatch, StartInstanceMatcher> startRule;
  
  public BatchTransformationRule<StopInstanceMatch, StopInstanceMatcher> stopRule;
  
  public BatchTransformationRule<CreateApplicationInstanceMatch, CreateApplicationInstanceMatcher> createAppRule;
  
  public BatchTransformationRule<CreateHostInstanceMatch, CreateHostInstanceMatcher> createHostRule;
  
  public BatchTransformationRule<CancelRequestMatch, CancelRequestMatcher> cancelRequestRule;
  
  public BatchTransformationRule<CreateApplicationInstancesMatch, CreateApplicationInstancesMatcher> createAppsRule;
  
  public BatchTransformationRule<RemoveHostInstanceMatch, RemoveHostInstanceMatcher> removeHostInstanceRule;
  
  public CpsRuleProvider() throws ViatraQueryException {
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<AllocateMatch, AllocateMatcher> _createRule = this.ruleFactory.<AllocateMatch, AllocateMatcher>createRule();
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<AllocateMatch, AllocateMatcher> _name = _createRule.name("AllocateRule");
    AllocateQuerySpecification _instance = AllocateQuerySpecification.instance();
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<AllocateMatch, AllocateMatcher> _precondition = _name.precondition(_instance);
    final IMatchProcessor<AllocateMatch> _function = new IMatchProcessor<AllocateMatch>() {
      @Override
      public void process(final AllocateMatch it) {
        ApplicationInstance _appInstance = it.getAppInstance();
        EList<HostInstance> _allocatedTo = _appInstance.getAllocatedTo();
        HostInstance _hostInstance = it.getHostInstance();
        _allocatedTo.add(_hostInstance);
        HostInstance _hostInstance_1 = it.getHostInstance();
        HostInstance _hostInstance_2 = it.getHostInstance();
        int _availableMemory = _hostInstance_2.getAvailableMemory();
        ResourceRequirement _req = it.getReq();
        int _requiredMemory = _req.getRequiredMemory();
        int _minus = (_availableMemory - _requiredMemory);
        _hostInstance_1.setAvailableMemory(_minus);
        HostInstance _hostInstance_3 = it.getHostInstance();
        HostInstance _hostInstance_4 = it.getHostInstance();
        int _availableHdd = _hostInstance_4.getAvailableHdd();
        ResourceRequirement _req_1 = it.getReq();
        int _requiredHdd = _req_1.getRequiredHdd();
        int _minus_1 = (_availableHdd - _requiredHdd);
        _hostInstance_3.setAvailableHdd(_minus_1);
        HostInstance _hostInstance_5 = it.getHostInstance();
        HostInstance _hostInstance_6 = it.getHostInstance();
        int _availableCpu = _hostInstance_6.getAvailableCpu();
        ResourceRequirement _req_2 = it.getReq();
        int _requiredCpu = _req_2.getRequiredCpu();
        int _minus_2 = (_availableCpu - _requiredCpu);
        _hostInstance_5.setAvailableCpu(_minus_2);
      }
    };
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<AllocateMatch, AllocateMatcher> _action = _precondition.action(_function);
    BatchTransformationRule<AllocateMatch, AllocateMatcher> _build = _action.build();
    this.allocateRule = _build;
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<DeleteAllocationMatch, DeleteAllocationMatcher> _createRule_1 = this.ruleFactory.<DeleteAllocationMatch, DeleteAllocationMatcher>createRule();
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<DeleteAllocationMatch, DeleteAllocationMatcher> _name_1 = _createRule_1.name("DeleteAllocationRule");
    DeleteAllocationQuerySpecification _instance_1 = DeleteAllocationQuerySpecification.instance();
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<DeleteAllocationMatch, DeleteAllocationMatcher> _precondition_1 = _name_1.precondition(_instance_1);
    final IMatchProcessor<DeleteAllocationMatch> _function_1 = new IMatchProcessor<DeleteAllocationMatch>() {
      @Override
      public void process(final DeleteAllocationMatch it) {
        ApplicationInstance _appInstance = it.getAppInstance();
        EList<HostInstance> _allocatedTo = _appInstance.getAllocatedTo();
        HostInstance _hostInstance = it.getHostInstance();
        _allocatedTo.remove(_hostInstance);
        HostInstance _hostInstance_1 = it.getHostInstance();
        HostInstance _hostInstance_2 = it.getHostInstance();
        int _availableMemory = _hostInstance_2.getAvailableMemory();
        ResourceRequirement _req = it.getReq();
        int _requiredMemory = _req.getRequiredMemory();
        int _plus = (_availableMemory + _requiredMemory);
        _hostInstance_1.setAvailableMemory(_plus);
        HostInstance _hostInstance_3 = it.getHostInstance();
        HostInstance _hostInstance_4 = it.getHostInstance();
        int _availableHdd = _hostInstance_4.getAvailableHdd();
        ResourceRequirement _req_1 = it.getReq();
        int _requiredHdd = _req_1.getRequiredHdd();
        int _plus_1 = (_availableHdd + _requiredHdd);
        _hostInstance_3.setAvailableHdd(_plus_1);
        HostInstance _hostInstance_5 = it.getHostInstance();
        HostInstance _hostInstance_6 = it.getHostInstance();
        int _availableCpu = _hostInstance_6.getAvailableCpu();
        ResourceRequirement _req_2 = it.getReq();
        int _requiredCpu = _req_2.getRequiredCpu();
        int _plus_2 = (_availableCpu + _requiredCpu);
        _hostInstance_5.setAvailableCpu(_plus_2);
      }
    };
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<DeleteAllocationMatch, DeleteAllocationMatcher> _action_1 = _precondition_1.action(_function_1);
    BatchTransformationRule<DeleteAllocationMatch, DeleteAllocationMatcher> _build_1 = _action_1.build();
    this.deleteAllocRule = _build_1;
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<MoveMatch, MoveMatcher> _createRule_2 = this.ruleFactory.<MoveMatch, MoveMatcher>createRule();
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<MoveMatch, MoveMatcher> _name_2 = _createRule_2.name("moveRule");
    MoveQuerySpecification _instance_2 = MoveQuerySpecification.instance();
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<MoveMatch, MoveMatcher> _precondition_2 = _name_2.precondition(_instance_2);
    final IMatchProcessor<MoveMatch> _function_2 = new IMatchProcessor<MoveMatch>() {
      @Override
      public void process(final MoveMatch it) {
        ApplicationInstance _appInstance = it.getAppInstance();
        EList<HostInstance> _allocatedTo = _appInstance.getAllocatedTo();
        HostInstance _from = it.getFrom();
        _allocatedTo.remove(_from);
        ApplicationInstance _appInstance_1 = it.getAppInstance();
        EList<HostInstance> _allocatedTo_1 = _appInstance_1.getAllocatedTo();
        HostInstance _to = it.getTo();
        _allocatedTo_1.add(_to);
        HostInstance _to_1 = it.getTo();
        HostInstance _to_2 = it.getTo();
        int _availableMemory = _to_2.getAvailableMemory();
        ResourceRequirement _req = it.getReq();
        int _requiredMemory = _req.getRequiredMemory();
        int _minus = (_availableMemory - _requiredMemory);
        _to_1.setAvailableMemory(_minus);
        HostInstance _to_3 = it.getTo();
        HostInstance _to_4 = it.getTo();
        int _availableHdd = _to_4.getAvailableHdd();
        ResourceRequirement _req_1 = it.getReq();
        int _requiredHdd = _req_1.getRequiredHdd();
        int _minus_1 = (_availableHdd - _requiredHdd);
        _to_3.setAvailableHdd(_minus_1);
        HostInstance _to_5 = it.getTo();
        HostInstance _to_6 = it.getTo();
        int _availableCpu = _to_6.getAvailableCpu();
        ResourceRequirement _req_2 = it.getReq();
        int _requiredCpu = _req_2.getRequiredCpu();
        int _minus_2 = (_availableCpu - _requiredCpu);
        _to_5.setAvailableCpu(_minus_2);
        HostInstance _from_1 = it.getFrom();
        HostInstance _from_2 = it.getFrom();
        int _availableMemory_1 = _from_2.getAvailableMemory();
        ResourceRequirement _req_3 = it.getReq();
        int _requiredMemory_1 = _req_3.getRequiredMemory();
        int _plus = (_availableMemory_1 + _requiredMemory_1);
        _from_1.setAvailableMemory(_plus);
        HostInstance _from_3 = it.getFrom();
        HostInstance _from_4 = it.getFrom();
        int _availableHdd_1 = _from_4.getAvailableHdd();
        ResourceRequirement _req_4 = it.getReq();
        int _requiredHdd_1 = _req_4.getRequiredHdd();
        int _plus_1 = (_availableHdd_1 + _requiredHdd_1);
        _from_3.setAvailableHdd(_plus_1);
        HostInstance _from_5 = it.getFrom();
        HostInstance _from_6 = it.getFrom();
        int _availableCpu_1 = _from_6.getAvailableCpu();
        ResourceRequirement _req_5 = it.getReq();
        int _requiredCpu_1 = _req_5.getRequiredCpu();
        int _plus_2 = (_availableCpu_1 + _requiredCpu_1);
        _from_5.setAvailableCpu(_plus_2);
      }
    };
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<MoveMatch, MoveMatcher> _action_2 = _precondition_2.action(_function_2);
    BatchTransformationRule<MoveMatch, MoveMatcher> _build_2 = _action_2.build();
    this.moveRule = _build_2;
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<StartInstanceMatch, StartInstanceMatcher> _createRule_3 = this.ruleFactory.<StartInstanceMatch, StartInstanceMatcher>createRule();
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<StartInstanceMatch, StartInstanceMatcher> _name_3 = _createRule_3.name("StartRule");
    StartInstanceQuerySpecification _instance_3 = StartInstanceQuerySpecification.instance();
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<StartInstanceMatch, StartInstanceMatcher> _precondition_3 = _name_3.precondition(_instance_3);
    final IMatchProcessor<StartInstanceMatch> _function_3 = new IMatchProcessor<StartInstanceMatch>() {
      @Override
      public void process(final StartInstanceMatch it) {
        ApplicationInstance _appInstance = it.getAppInstance();
        _appInstance.setState(State.RUNNING);
      }
    };
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<StartInstanceMatch, StartInstanceMatcher> _action_3 = _precondition_3.action(_function_3);
    BatchTransformationRule<StartInstanceMatch, StartInstanceMatcher> _build_3 = _action_3.build();
    this.startRule = _build_3;
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<StopInstanceMatch, StopInstanceMatcher> _createRule_4 = this.ruleFactory.<StopInstanceMatch, StopInstanceMatcher>createRule();
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<StopInstanceMatch, StopInstanceMatcher> _name_4 = _createRule_4.name("StopRule");
    StopInstanceQuerySpecification _instance_4 = StopInstanceQuerySpecification.instance();
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<StopInstanceMatch, StopInstanceMatcher> _precondition_4 = _name_4.precondition(_instance_4);
    final IMatchProcessor<StopInstanceMatch> _function_4 = new IMatchProcessor<StopInstanceMatch>() {
      @Override
      public void process(final StopInstanceMatch it) {
        ApplicationInstance _appInstance = it.getAppInstance();
        _appInstance.setState(State.STOPPED);
      }
    };
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<StopInstanceMatch, StopInstanceMatcher> _action_4 = _precondition_4.action(_function_4);
    BatchTransformationRule<StopInstanceMatch, StopInstanceMatcher> _build_4 = _action_4.build();
    this.stopRule = _build_4;
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CreateApplicationInstanceMatch, CreateApplicationInstanceMatcher> _createRule_5 = this.ruleFactory.<CreateApplicationInstanceMatch, CreateApplicationInstanceMatcher>createRule();
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CreateApplicationInstanceMatch, CreateApplicationInstanceMatcher> _name_5 = _createRule_5.name("CreateAppRule");
    CreateApplicationInstanceQuerySpecification _instance_5 = CreateApplicationInstanceQuerySpecification.instance();
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CreateApplicationInstanceMatch, CreateApplicationInstanceMatcher> _precondition_5 = _name_5.precondition(_instance_5);
    final IMatchProcessor<CreateApplicationInstanceMatch> _function_5 = new IMatchProcessor<CreateApplicationInstanceMatch>() {
      @Override
      public void process(final CreateApplicationInstanceMatch it) {
        ApplicationInstance instance = CpsFactory.eINSTANCE.createApplicationInstance();
        Requirement _req = it.getReq();
        ApplicationType _type = _req.getType();
        EList<ApplicationInstance> _instances = _type.getInstances();
        _instances.add(instance);
        Requirement _req_1 = it.getReq();
        EList<ApplicationInstance> _instances_1 = _req_1.getInstances();
        _instances_1.add(instance);
        StringConcatenation _builder = new StringConcatenation();
        Requirement _req_2 = it.getReq();
        ApplicationType _type_1 = _req_2.getType();
        String _id = _type_1.getId();
        _builder.append(_id, "");
        _builder.append("App(");
        Requirement _req_3 = it.getReq();
        String _id_1 = _req_3.getId();
        _builder.append(_id_1, "");
        Requirement _req_4 = it.getReq();
        EList<ApplicationInstance> _instances_2 = _req_4.getInstances();
        int _size = _instances_2.size();
        _builder.append(_size, "");
        _builder.append(")");
        String _string = _builder.toString();
        instance.setId(_string);
      }
    };
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CreateApplicationInstanceMatch, CreateApplicationInstanceMatcher> _action_5 = _precondition_5.action(_function_5);
    BatchTransformationRule<CreateApplicationInstanceMatch, CreateApplicationInstanceMatcher> _build_5 = _action_5.build();
    this.createAppRule = _build_5;
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CreateHostInstanceMatch, CreateHostInstanceMatcher> _createRule_6 = this.ruleFactory.<CreateHostInstanceMatch, CreateHostInstanceMatcher>createRule();
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CreateHostInstanceMatch, CreateHostInstanceMatcher> _name_6 = _createRule_6.name("CreateHostRule");
    CreateHostInstanceQuerySpecification _instance_6 = CreateHostInstanceQuerySpecification.instance();
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CreateHostInstanceMatch, CreateHostInstanceMatcher> _precondition_6 = _name_6.precondition(_instance_6);
    final IMatchProcessor<CreateHostInstanceMatch> _function_6 = new IMatchProcessor<CreateHostInstanceMatch>() {
      @Override
      public void process(final CreateHostInstanceMatch it) {
        HostInstance hostInstance = CpsFactory.eINSTANCE.createHostInstance();
        HostType _hostType = it.getHostType();
        int _defaultCpu = _hostType.getDefaultCpu();
        hostInstance.setTotalCpu(_defaultCpu);
        HostType _hostType_1 = it.getHostType();
        int _defaultCpu_1 = _hostType_1.getDefaultCpu();
        hostInstance.setAvailableCpu(_defaultCpu_1);
        HostType _hostType_2 = it.getHostType();
        int _defaultHdd = _hostType_2.getDefaultHdd();
        hostInstance.setTotalHdd(_defaultHdd);
        HostType _hostType_3 = it.getHostType();
        int _defaultHdd_1 = _hostType_3.getDefaultHdd();
        hostInstance.setAvailableHdd(_defaultHdd_1);
        HostType _hostType_4 = it.getHostType();
        int _defaultMemory = _hostType_4.getDefaultMemory();
        hostInstance.setTotalMemory(_defaultMemory);
        HostType _hostType_5 = it.getHostType();
        int _defaultMemory_1 = _hostType_5.getDefaultMemory();
        hostInstance.setAvailableMemory(_defaultMemory_1);
        HostType _hostType_6 = it.getHostType();
        hostInstance.setType(_hostType_6);
        HostType _hostType_7 = it.getHostType();
        EList<HostInstance> _instances = _hostType_7.getInstances();
        _instances.add(hostInstance);
        HostType _hostType_8 = it.getHostType();
        String _id = _hostType_8.getId();
        HostType _hostType_9 = it.getHostType();
        EList<HostInstance> _instances_1 = _hostType_9.getInstances();
        int _size = _instances_1.size();
        String _plus = (_id + Integer.valueOf(_size));
        hostInstance.setId(_plus);
      }
    };
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CreateHostInstanceMatch, CreateHostInstanceMatcher> _action_6 = _precondition_6.action(_function_6);
    BatchTransformationRule<CreateHostInstanceMatch, CreateHostInstanceMatcher> _build_6 = _action_6.build();
    this.createHostRule = _build_6;
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CancelRequestMatch, CancelRequestMatcher> _createRule_7 = this.ruleFactory.<CancelRequestMatch, CancelRequestMatcher>createRule();
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CancelRequestMatch, CancelRequestMatcher> _name_7 = _createRule_7.name("CancelRequestRule");
    CancelRequestQuerySpecification _instance_7 = CancelRequestQuerySpecification.instance();
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CancelRequestMatch, CancelRequestMatcher> _precondition_7 = _name_7.precondition(_instance_7);
    final IMatchProcessor<CancelRequestMatch> _function_7 = new IMatchProcessor<CancelRequestMatch>() {
      @Override
      public void process(final CancelRequestMatch it) {
        CyberPhysicalSystem _cps = it.getCps();
        EList<Request> _requests = _cps.getRequests();
        Request _request = it.getRequest();
        _requests.remove(_request);
        Request _request_1 = it.getRequest();
        EList<Requirement> _requirements = _request_1.getRequirements();
        for (final Requirement req : _requirements) {
          {
            Request _request_2 = it.getRequest();
            EList<Requirement> _requirements_1 = _request_2.getRequirements();
            _requirements_1.remove(req);
            EList<ApplicationInstance> _instances = req.getInstances();
            for (final ApplicationInstance app : _instances) {
              {
                ApplicationType _type = app.getType();
                EList<ApplicationInstance> _instances_1 = _type.getInstances();
                _instances_1.remove(app);
                EList<HostInstance> hosts = app.getAllocatedTo();
                if ((hosts != null)) {
                  for (final HostInstance host : hosts) {
                    ApplicationType _type_1 = app.getType();
                    EList<ResourceRequirement> _requirements_2 = _type_1.getRequirements();
                    for (final ResourceRequirement rr : _requirements_2) {
                      HostType _hostType = rr.getHostType();
                      HostType _type_2 = host.getType();
                      boolean _equals = _hostType.equals(_type_2);
                      if (_equals) {
                        EList<HostInstance> _allocatedTo = app.getAllocatedTo();
                        _allocatedTo.remove(host);
                        int _availableMemory = host.getAvailableMemory();
                        int _requiredMemory = rr.getRequiredMemory();
                        int _plus = (_availableMemory + _requiredMemory);
                        host.setAvailableMemory(_plus);
                        int _availableHdd = host.getAvailableHdd();
                        int _requiredHdd = rr.getRequiredHdd();
                        int _plus_1 = (_availableHdd + _requiredHdd);
                        host.setAvailableHdd(_plus_1);
                        int _availableCpu = host.getAvailableCpu();
                        int _requiredCpu = rr.getRequiredCpu();
                        int _plus_2 = (_availableCpu + _requiredCpu);
                        host.setAvailableCpu(_plus_2);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    };
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CancelRequestMatch, CancelRequestMatcher> _action_7 = _precondition_7.action(_function_7);
    BatchTransformationRule<CancelRequestMatch, CancelRequestMatcher> _build_7 = _action_7.build();
    this.cancelRequestRule = _build_7;
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CreateApplicationInstancesMatch, CreateApplicationInstancesMatcher> _createRule_8 = this.ruleFactory.<CreateApplicationInstancesMatch, CreateApplicationInstancesMatcher>createRule();
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CreateApplicationInstancesMatch, CreateApplicationInstancesMatcher> _name_8 = _createRule_8.name("CreateAppsRule");
    CreateApplicationInstancesQuerySpecification _instance_8 = CreateApplicationInstancesQuerySpecification.instance();
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CreateApplicationInstancesMatch, CreateApplicationInstancesMatcher> _precondition_8 = _name_8.precondition(_instance_8);
    final IMatchProcessor<CreateApplicationInstancesMatch> _function_8 = new IMatchProcessor<CreateApplicationInstancesMatch>() {
      @Override
      public void process(final CreateApplicationInstancesMatch it) {
        for (int i = 0; (i < it.getReq().getCount()); i++) {
          {
            ApplicationInstance instance = CpsFactory.eINSTANCE.createApplicationInstance();
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("AppInsReq:");
            Requirement _req = it.getReq();
            String _id = _req.getId();
            _builder.append(_id, "");
            _builder.append("Id:");
            _builder.append(i, "");
            String _string = _builder.toString();
            instance.setId(_string);
            Requirement _req_1 = it.getReq();
            ApplicationType _type = _req_1.getType();
            EList<ApplicationInstance> _instances = _type.getInstances();
            _instances.add(instance);
            Requirement _req_2 = it.getReq();
            EList<ApplicationInstance> _instances_1 = _req_2.getInstances();
            _instances_1.add(instance);
          }
        }
      }
    };
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CreateApplicationInstancesMatch, CreateApplicationInstancesMatcher> _action_8 = _precondition_8.action(_function_8);
    BatchTransformationRule<CreateApplicationInstancesMatch, CreateApplicationInstancesMatcher> _build_8 = _action_8.build();
    this.createAppsRule = _build_8;
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<RemoveHostInstanceMatch, RemoveHostInstanceMatcher> _createRule_9 = this.ruleFactory.<RemoveHostInstanceMatch, RemoveHostInstanceMatcher>createRule();
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<RemoveHostInstanceMatch, RemoveHostInstanceMatcher> _name_9 = _createRule_9.name("RemoveHosInstanceRule");
    RemoveHostInstanceQuerySpecification _instance_9 = RemoveHostInstanceQuerySpecification.instance();
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<RemoveHostInstanceMatch, RemoveHostInstanceMatcher> _precondition_9 = _name_9.precondition(_instance_9);
    final IMatchProcessor<RemoveHostInstanceMatch> _function_9 = new IMatchProcessor<RemoveHostInstanceMatch>() {
      @Override
      public void process(final RemoveHostInstanceMatch it) {
        HostInstance _hostInstance = it.getHostInstance();
        EList<ApplicationInstance> _applications = _hostInstance.getApplications();
        for (final ApplicationInstance app : _applications) {
          {
            EList<HostInstance> _allocatedTo = app.getAllocatedTo();
            HostInstance _hostInstance_1 = it.getHostInstance();
            _allocatedTo.remove(_hostInstance_1);
            app.setState(State.STOPPED);
          }
        }
        HostInstance _hostInstance_1 = it.getHostInstance();
        HostType _type = _hostInstance_1.getType();
        EList<HostInstance> _instances = _type.getInstances();
        HostInstance _hostInstance_2 = it.getHostInstance();
        _instances.remove(_hostInstance_2);
      }
    };
    BatchTransformationRuleFactory.BatchTransformationRuleBuilder<RemoveHostInstanceMatch, RemoveHostInstanceMatcher> _action_9 = _precondition_9.action(_function_9);
    BatchTransformationRule<RemoveHostInstanceMatch, RemoveHostInstanceMatcher> _build_9 = _action_9.build();
    this.removeHostInstanceRule = _build_9;
  }
}
