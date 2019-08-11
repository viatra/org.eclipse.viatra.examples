/**
 * Copyright (c) 2014-2019 Geza Kulcsar, Akos Horvath, Abel Hegedus, Zoltan Ujhelyi, Daniel Segesdi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries;

import com.google.common.base.Objects;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Identifiable;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.State;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.StateMachine;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition;
import org.eclipse.viatra.examples.cps.deployment.BehaviorState;
import org.eclipse.viatra.examples.cps.deployment.BehaviorTransition;
import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication;
import org.eclipse.viatra.examples.cps.deployment.DeploymentBehavior;
import org.eclipse.viatra.examples.cps.deployment.DeploymentElement;
import org.eclipse.viatra.examples.cps.deployment.DeploymentFactory;
import org.eclipse.viatra.examples.cps.deployment.DeploymentHost;
import org.eclipse.viatra.examples.cps.deployment.DeploymentPackage;
import org.eclipse.viatra.examples.cps.traceability.CPS2DeploymentTrace;
import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment;
import org.eclipse.viatra.examples.cps.traceability.TraceabilityFactory;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceWithChangedHost;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceWithDepHost;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceWithStateMachine_noTrace;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceWithStateMachine_withTrace;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceWithState_noTrace;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceWithState_withTrace;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.BehTriggerConnLost;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.BehTriggerNoSrcTrace;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.BehTriggerNoTrgTrace;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.BehTriggerPair;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.ChangeAppId;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.ChangeHostIp;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.CpsXformM2M;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.HostInstance;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.MissingAppInstance;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.MissingDepHost;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.StateDel;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.StateMachineDel;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.TransitionDel;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.Transition_noTrace;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.Transition_withTrace;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations;
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.SimpleModelManipulations;
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRule;
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory;
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformation;
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformationStatements;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class CPS2DeploymentIncrPureGraTra {
  @Extension
  private final CpsXformM2M cpsXformM2M = CpsXformM2M.instance();
  
  /**
   * EMF metamodels
   */
  @Extension
  private final DeploymentPackage depPackage = DeploymentPackage.eINSTANCE;
  
  @Extension
  protected DeploymentFactory depFactory = DeploymentFactory.eINSTANCE;
  
  @Extension
  protected TraceabilityFactory traceFactory = TraceabilityFactory.eINSTANCE;
  
  /**
   * Transformation-related extensions
   */
  @Extension
  private BatchTransformation transformation;
  
  @Extension
  private BatchTransformationStatements statements;
  
  /**
   * Transformation rule-related extensions
   */
  @Extension
  private BatchTransformationRuleFactory _batchTransformationRuleFactory = new BatchTransformationRuleFactory();
  
  @Extension
  private IModelManipulations manipulation;
  
  protected ViatraQueryEngine engine;
  
  protected Resource resource;
  
  private final CPSToDeployment cps2dep;
  
  private final BatchTransformationRule<? extends IPatternMatch, ?> hostRule;
  
  private final BatchTransformationRule<? extends IPatternMatch, ?> changeHostIpRule;
  
  private final BatchTransformationRule<? extends IPatternMatch, ?> hostRuleDel;
  
  private final BatchTransformationRule<? extends IPatternMatch, ?> applicationRule;
  
  private final BatchTransformationRule<? extends IPatternMatch, ?> reallocAppRule;
  
  private final BatchTransformationRule<? extends IPatternMatch, ?> changeAppIdRule;
  
  private final BatchTransformationRule<? extends IPatternMatch, ?> appRuleDel;
  
  private final BatchTransformationRule<? extends IPatternMatch, ?> stateMachineNoTraceRule;
  
  private final BatchTransformationRule<? extends IPatternMatch, ?> stateMachineWithTraceRule;
  
  private final BatchTransformationRule<? extends IPatternMatch, ?> stateMachineDel;
  
  private final BatchTransformationRule<? extends IPatternMatch, ?> stateNoTraceRule;
  
  private final BatchTransformationRule<? extends IPatternMatch, ?> stateWithTraceRule;
  
  private final BatchTransformationRule<? extends IPatternMatch, ?> stateDel;
  
  private final BatchTransformationRule<? extends IPatternMatch, ?> transitionNoTraceRule;
  
  private final BatchTransformationRule<? extends IPatternMatch, ?> transitionWithTraceRule;
  
  private final BatchTransformationRule<? extends IPatternMatch, ?> transitionDel;
  
  private final BatchTransformationRule<? extends IPatternMatch, ?> triggerRule;
  
  private final BatchTransformationRule<? extends IPatternMatch, ?> triggerDelNoSrc;
  
  private final BatchTransformationRule<? extends IPatternMatch, ?> triggerDelNoTrg;
  
  private final BatchTransformationRule<? extends IPatternMatch, ?> triggerDelConnLost;
  
  public CPS2DeploymentIncrPureGraTra(final CPSToDeployment cps2dep, final ViatraQueryEngine engine) {
    this.cps2dep = cps2dep;
    this.resource = cps2dep.getDeployment().eResource();
    this.engine = engine;
    this.cpsXformM2M.prepare(engine);
    final Consumer<HostInstance.Match> _function = (HostInstance.Match it) -> {
      final org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance hostInstance = it.getHostInstance();
      final String nodeIp = hostInstance.getNodeIp();
      DeploymentHost _createDeploymentHost = this.depFactory.createDeploymentHost();
      final Procedure1<DeploymentHost> _function_1 = (DeploymentHost it_1) -> {
        it_1.setIp(nodeIp);
      };
      final DeploymentHost depHost = ObjectExtensions.<DeploymentHost>operator_doubleArrow(_createDeploymentHost, _function_1);
      EList<DeploymentHost> _hosts = cps2dep.getDeployment().getHosts();
      _hosts.add(depHost);
      EList<CPS2DeploymentTrace> _traces = cps2dep.getTraces();
      CPS2DeploymentTrace _createCPS2DeploymentTrace = this.traceFactory.createCPS2DeploymentTrace();
      final Procedure1<CPS2DeploymentTrace> _function_2 = (CPS2DeploymentTrace it_1) -> {
        EList<Identifiable> _cpsElements = it_1.getCpsElements();
        _cpsElements.add(hostInstance);
        EList<DeploymentElement> _deploymentElements = it_1.getDeploymentElements();
        _deploymentElements.add(depHost);
      };
      CPS2DeploymentTrace _doubleArrow = ObjectExtensions.<CPS2DeploymentTrace>operator_doubleArrow(_createCPS2DeploymentTrace, _function_2);
      _traces.add(_doubleArrow);
    };
    this.hostRule = this._batchTransformationRuleFactory.<HostInstance.Match, HostInstance.Matcher>createRule(HostInstance.instance()).name("HostRule").action(_function).build();
    final Consumer<ChangeHostIp.Match> _function_1 = (ChangeHostIp.Match it) -> {
      final String newIp = it.getHostInstance().getNodeIp();
      DeploymentHost _depHost = it.getDepHost();
      _depHost.setIp(newIp);
    };
    this.changeHostIpRule = this._batchTransformationRuleFactory.<ChangeHostIp.Match, ChangeHostIp.Matcher>createRule(ChangeHostIp.instance()).name("ChangeHostIpRule").action(_function_1).build();
    final Consumer<MissingDepHost.Match> _function_2 = (MissingDepHost.Match it) -> {
      try {
        this.manipulation.remove(it.getDepHost());
        this.manipulation.remove(it.getTrace());
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    this.hostRuleDel = this._batchTransformationRuleFactory.<MissingDepHost.Match, MissingDepHost.Matcher>createRule(MissingDepHost.instance()).name("HostRuleDel").action(_function_2).build();
    final Consumer<AppInstanceWithDepHost.Match> _function_3 = (AppInstanceWithDepHost.Match it) -> {
      final ApplicationInstance appInstance = it.getAppInstance();
      final String appId = it.getAppInstance().getIdentifier();
      DeploymentApplication _createDeploymentApplication = this.depFactory.createDeploymentApplication();
      final Procedure1<DeploymentApplication> _function_4 = (DeploymentApplication it_1) -> {
        it_1.setId(appId);
      };
      final DeploymentApplication depApp = ObjectExtensions.<DeploymentApplication>operator_doubleArrow(_createDeploymentApplication, _function_4);
      EList<DeploymentApplication> _applications = it.getDepHost().getApplications();
      _applications.add(depApp);
      EList<CPS2DeploymentTrace> _traces = cps2dep.getTraces();
      CPS2DeploymentTrace _createCPS2DeploymentTrace = this.traceFactory.createCPS2DeploymentTrace();
      final Procedure1<CPS2DeploymentTrace> _function_5 = (CPS2DeploymentTrace it_1) -> {
        EList<Identifiable> _cpsElements = it_1.getCpsElements();
        _cpsElements.add(appInstance);
        EList<DeploymentElement> _deploymentElements = it_1.getDeploymentElements();
        _deploymentElements.add(depApp);
      };
      CPS2DeploymentTrace _doubleArrow = ObjectExtensions.<CPS2DeploymentTrace>operator_doubleArrow(_createCPS2DeploymentTrace, _function_5);
      _traces.add(_doubleArrow);
    };
    this.applicationRule = this._batchTransformationRuleFactory.<AppInstanceWithDepHost.Match, AppInstanceWithDepHost.Matcher>createRule(AppInstanceWithDepHost.instance()).name("ApplicationRule").action(_function_3).build();
    final Consumer<AppInstanceWithChangedHost.Match> _function_4 = (AppInstanceWithChangedHost.Match it) -> {
      EList<DeploymentApplication> _applications = it.getDepHost1().getApplications();
      DeploymentApplication _depApp = it.getDepApp();
      _applications.remove(_depApp);
      EList<DeploymentApplication> _applications_1 = it.getDepHost2().getApplications();
      DeploymentApplication _depApp_1 = it.getDepApp();
      _applications_1.add(_depApp_1);
    };
    this.reallocAppRule = this._batchTransformationRuleFactory.<AppInstanceWithChangedHost.Match, AppInstanceWithChangedHost.Matcher>createRule(AppInstanceWithChangedHost.instance()).name("ReallocAppRule").action(_function_4).build();
    final Consumer<ChangeAppId.Match> _function_5 = (ChangeAppId.Match it) -> {
      final String newId = it.getAppInstance().getIdentifier();
      DeploymentApplication _depApp = it.getDepApp();
      _depApp.setId(newId);
    };
    this.changeAppIdRule = this._batchTransformationRuleFactory.<ChangeAppId.Match, ChangeAppId.Matcher>createRule(ChangeAppId.instance()).name("ChangeAppIdRule").action(_function_5).build();
    final Consumer<MissingAppInstance.Match> _function_6 = (MissingAppInstance.Match it) -> {
      try {
        this.manipulation.remove(it.getDepApp());
        this.manipulation.remove(it.getTrace());
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    this.appRuleDel = this._batchTransformationRuleFactory.<MissingAppInstance.Match, MissingAppInstance.Matcher>createRule(MissingAppInstance.instance()).name("AppRuleDel").action(_function_6).build();
    final Consumer<AppInstanceWithStateMachine_noTrace.Match> _function_7 = (AppInstanceWithStateMachine_noTrace.Match it) -> {
      final StateMachine sm = it.getStateMachine();
      final String id = it.getStateMachine().getIdentifier();
      DeploymentBehavior _createDeploymentBehavior = this.depFactory.createDeploymentBehavior();
      final Procedure1<DeploymentBehavior> _function_8 = (DeploymentBehavior it_1) -> {
        it_1.setDescription(id);
      };
      final DeploymentBehavior depBehavior = ObjectExtensions.<DeploymentBehavior>operator_doubleArrow(_createDeploymentBehavior, _function_8);
      DeploymentApplication _depApp = it.getDepApp();
      _depApp.setBehavior(depBehavior);
      EList<CPS2DeploymentTrace> _traces = cps2dep.getTraces();
      CPS2DeploymentTrace _createCPS2DeploymentTrace = this.traceFactory.createCPS2DeploymentTrace();
      final Procedure1<CPS2DeploymentTrace> _function_9 = (CPS2DeploymentTrace it_1) -> {
        EList<Identifiable> _cpsElements = it_1.getCpsElements();
        _cpsElements.add(sm);
        EList<DeploymentElement> _deploymentElements = it_1.getDeploymentElements();
        _deploymentElements.add(depBehavior);
      };
      CPS2DeploymentTrace _doubleArrow = ObjectExtensions.<CPS2DeploymentTrace>operator_doubleArrow(_createCPS2DeploymentTrace, _function_9);
      _traces.add(_doubleArrow);
    };
    this.stateMachineNoTraceRule = this._batchTransformationRuleFactory.<AppInstanceWithStateMachine_noTrace.Match, AppInstanceWithStateMachine_noTrace.Matcher>createRule(AppInstanceWithStateMachine_noTrace.instance()).name(
      "StateMachineNoTraceRule").action(_function_7).build();
    final Consumer<AppInstanceWithStateMachine_withTrace.Match> _function_8 = (AppInstanceWithStateMachine_withTrace.Match it) -> {
      final String id = it.getStateMachine().getIdentifier();
      DeploymentBehavior _createDeploymentBehavior = this.depFactory.createDeploymentBehavior();
      final Procedure1<DeploymentBehavior> _function_9 = (DeploymentBehavior it_1) -> {
        it_1.setDescription(id);
      };
      final DeploymentBehavior depBehavior = ObjectExtensions.<DeploymentBehavior>operator_doubleArrow(_createDeploymentBehavior, _function_9);
      DeploymentApplication _depApp = it.getDepApp();
      _depApp.setBehavior(depBehavior);
      EList<DeploymentElement> _deploymentElements = it.getTrace().getDeploymentElements();
      _deploymentElements.add(depBehavior);
    };
    this.stateMachineWithTraceRule = this._batchTransformationRuleFactory.<AppInstanceWithStateMachine_withTrace.Match, AppInstanceWithStateMachine_withTrace.Matcher>createRule(AppInstanceWithStateMachine_withTrace.instance()).name(
      "StateMachineWithTraceRule").action(_function_8).build();
    final Consumer<StateMachineDel.Match> _function_9 = (StateMachineDel.Match it) -> {
      try {
        this.manipulation.remove(it.getDepBehavior());
        this.manipulation.remove(it.getTrace());
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    this.stateMachineDel = this._batchTransformationRuleFactory.<StateMachineDel.Match, StateMachineDel.Matcher>createRule(StateMachineDel.instance()).name("StateMachineDel").action(_function_9).build();
    final Consumer<AppInstanceWithState_noTrace.Match> _function_10 = (AppInstanceWithState_noTrace.Match it) -> {
      final State state = it.getState();
      final String id = state.getIdentifier();
      BehaviorState _createBehaviorState = this.depFactory.createBehaviorState();
      final Procedure1<BehaviorState> _function_11 = (BehaviorState it_1) -> {
        it_1.setDescription(id);
      };
      final BehaviorState behState = ObjectExtensions.<BehaviorState>operator_doubleArrow(_createBehaviorState, _function_11);
      EList<BehaviorState> _states = it.getDepBehavior().getStates();
      _states.add(behState);
      EList<CPS2DeploymentTrace> _traces = cps2dep.getTraces();
      CPS2DeploymentTrace _createCPS2DeploymentTrace = this.traceFactory.createCPS2DeploymentTrace();
      final Procedure1<CPS2DeploymentTrace> _function_12 = (CPS2DeploymentTrace it_1) -> {
        EList<Identifiable> _cpsElements = it_1.getCpsElements();
        _cpsElements.add(state);
        EList<DeploymentElement> _deploymentElements = it_1.getDeploymentElements();
        _deploymentElements.add(behState);
      };
      CPS2DeploymentTrace _doubleArrow = ObjectExtensions.<CPS2DeploymentTrace>operator_doubleArrow(_createCPS2DeploymentTrace, _function_12);
      _traces.add(_doubleArrow);
    };
    this.stateNoTraceRule = this._batchTransformationRuleFactory.<AppInstanceWithState_noTrace.Match, AppInstanceWithState_noTrace.Matcher>createRule(AppInstanceWithState_noTrace.instance()).name("StateNoTraceRule").action(_function_10).build();
    final Consumer<AppInstanceWithState_withTrace.Match> _function_11 = (AppInstanceWithState_withTrace.Match it) -> {
      final String id = it.getState().getIdentifier();
      BehaviorState _createBehaviorState = this.depFactory.createBehaviorState();
      final Procedure1<BehaviorState> _function_12 = (BehaviorState it_1) -> {
        it_1.setDescription(id);
      };
      final BehaviorState behState = ObjectExtensions.<BehaviorState>operator_doubleArrow(_createBehaviorState, _function_12);
      EList<BehaviorState> _states = it.getDepBehavior().getStates();
      _states.add(behState);
      EList<DeploymentElement> _deploymentElements = it.getTrace().getDeploymentElements();
      _deploymentElements.add(behState);
    };
    this.stateWithTraceRule = this._batchTransformationRuleFactory.<AppInstanceWithState_withTrace.Match, AppInstanceWithState_withTrace.Matcher>createRule(AppInstanceWithState_withTrace.instance()).name("StateWithTraceRule").action(_function_11).build();
    final Consumer<StateDel.Match> _function_12 = (StateDel.Match it) -> {
      try {
        this.manipulation.remove(it.getBehState());
        this.manipulation.remove(it.getTrace());
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    this.stateDel = this._batchTransformationRuleFactory.<StateDel.Match, StateDel.Matcher>createRule(StateDel.instance()).name("StateDel").action(_function_12).build();
    final Consumer<Transition_noTrace.Match> _function_13 = (Transition_noTrace.Match it) -> {
      final Transition transition = it.getTransition();
      final String id = transition.getIdentifier();
      BehaviorTransition _createBehaviorTransition = this.depFactory.createBehaviorTransition();
      final Procedure1<BehaviorTransition> _function_14 = (BehaviorTransition it_1) -> {
        it_1.setDescription(id);
      };
      final BehaviorTransition behTransition = ObjectExtensions.<BehaviorTransition>operator_doubleArrow(_createBehaviorTransition, _function_14);
      EList<BehaviorTransition> _outgoing = it.getSrcDep().getOutgoing();
      _outgoing.add(behTransition);
      behTransition.setTo(it.getTrgDep());
      EList<CPS2DeploymentTrace> _traces = cps2dep.getTraces();
      CPS2DeploymentTrace _createCPS2DeploymentTrace = this.traceFactory.createCPS2DeploymentTrace();
      final Procedure1<CPS2DeploymentTrace> _function_15 = (CPS2DeploymentTrace it_1) -> {
        EList<Identifiable> _cpsElements = it_1.getCpsElements();
        _cpsElements.add(transition);
        EList<DeploymentElement> _deploymentElements = it_1.getDeploymentElements();
        _deploymentElements.add(behTransition);
      };
      CPS2DeploymentTrace _doubleArrow = ObjectExtensions.<CPS2DeploymentTrace>operator_doubleArrow(_createCPS2DeploymentTrace, _function_15);
      _traces.add(_doubleArrow);
    };
    this.transitionNoTraceRule = this._batchTransformationRuleFactory.<Transition_noTrace.Match, Transition_noTrace.Matcher>createRule(Transition_noTrace.instance()).name("TransitionNoTraceRule").action(_function_13).build();
    final Consumer<Transition_withTrace.Match> _function_14 = (Transition_withTrace.Match it) -> {
      final Transition transition = it.getTransition();
      final String id = transition.getIdentifier();
      BehaviorTransition _createBehaviorTransition = this.depFactory.createBehaviorTransition();
      final Procedure1<BehaviorTransition> _function_15 = (BehaviorTransition it_1) -> {
        it_1.setDescription(id);
      };
      final BehaviorTransition behTransition = ObjectExtensions.<BehaviorTransition>operator_doubleArrow(_createBehaviorTransition, _function_15);
      EList<BehaviorTransition> _outgoing = it.getSrcDep().getOutgoing();
      _outgoing.add(behTransition);
      behTransition.setTo(it.getTrgDep());
      EList<DeploymentElement> _deploymentElements = it.getTrace().getDeploymentElements();
      _deploymentElements.add(behTransition);
    };
    this.transitionWithTraceRule = this._batchTransformationRuleFactory.<Transition_withTrace.Match, Transition_withTrace.Matcher>createRule(Transition_withTrace.instance()).name("TransitionWithTraceRule").action(_function_14).build();
    final Consumer<TransitionDel.Match> _function_15 = (TransitionDel.Match it) -> {
      try {
        this.manipulation.remove(it.getBehTransition());
        this.manipulation.remove(it.getTrace());
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    this.transitionDel = this._batchTransformationRuleFactory.<TransitionDel.Match, TransitionDel.Matcher>createRule(TransitionDel.instance()).name("TransitionDel").action(_function_15).build();
    final Consumer<BehTriggerPair.Match> _function_16 = (BehTriggerPair.Match it) -> {
      EList<BehaviorTransition> _trigger = it.getBehTrigger().getTrigger();
      BehaviorTransition _behTarget = it.getBehTarget();
      _trigger.add(_behTarget);
    };
    this.triggerRule = this._batchTransformationRuleFactory.<BehTriggerPair.Match, BehTriggerPair.Matcher>createRule(BehTriggerPair.instance()).name("TriggerRule").action(_function_16).build();
    final Consumer<BehTriggerNoSrcTrace.Match> _function_17 = (BehTriggerNoSrcTrace.Match it) -> {
      EList<BehaviorTransition> _trigger = it.getBehTrigger().getTrigger();
      BehaviorTransition _behTarget = it.getBehTarget();
      _trigger.remove(_behTarget);
    };
    this.triggerDelNoSrc = this._batchTransformationRuleFactory.<BehTriggerNoSrcTrace.Match, BehTriggerNoSrcTrace.Matcher>createRule(BehTriggerNoSrcTrace.instance()).name("TriggerNoSrc").action(_function_17).build();
    final Consumer<BehTriggerNoTrgTrace.Match> _function_18 = (BehTriggerNoTrgTrace.Match it) -> {
      EList<BehaviorTransition> _trigger = it.getBehTrigger().getTrigger();
      BehaviorTransition _behTarget = it.getBehTarget();
      _trigger.remove(_behTarget);
    };
    this.triggerDelNoTrg = this._batchTransformationRuleFactory.<BehTriggerNoTrgTrace.Match, BehTriggerNoTrgTrace.Matcher>createRule(BehTriggerNoTrgTrace.instance()).name("TriggerNoTrg").action(_function_18).build();
    final Consumer<BehTriggerConnLost.Match> _function_19 = (BehTriggerConnLost.Match it) -> {
      EList<BehaviorTransition> _trigger = it.getBehTrigger().getTrigger();
      BehaviorTransition _behTarget = it.getBehTarget();
      _trigger.remove(_behTarget);
    };
    this.triggerDelConnLost = this._batchTransformationRuleFactory.<BehTriggerConnLost.Match, BehTriggerConnLost.Matcher>createRule(BehTriggerConnLost.instance()).name("TriggerConnLost").action(_function_19).build();
    this.createTransformation();
  }
  
  public void execute() {
    this.statements.fireWhilePossible();
  }
  
  private BatchTransformationStatements createTransformation() {
    BatchTransformationStatements _xblockexpression = null;
    {
      SimpleModelManipulations _simpleModelManipulations = new SimpleModelManipulations(this.engine);
      this.manipulation = _simpleModelManipulations;
      final BatchTransformation.BatchTransformationBuilder transformationBuilder = BatchTransformation.forEngine(this.engine);
      this.transformation = transformationBuilder.addRule(this.hostRule).addRule(this.changeHostIpRule).addRule(this.hostRuleDel).addRule(this.applicationRule).addRule(this.reallocAppRule).addRule(this.changeAppIdRule).addRule(this.appRuleDel).addRule(this.stateMachineNoTraceRule).addRule(this.stateMachineWithTraceRule).addRule(this.stateMachineDel).addRule(this.stateNoTraceRule).addRule(this.stateWithTraceRule).addRule(this.stateDel).addRule(this.transitionNoTraceRule).addRule(this.transitionWithTraceRule).addRule(this.transitionDel).addRule(this.triggerRule).addRule(this.triggerDelNoSrc).addRule(this.triggerDelNoTrg).addRule(this.triggerDelConnLost).build();
      _xblockexpression = this.statements = this.transformation.getTransformationStatements();
    }
    return _xblockexpression;
  }
  
  public void dispose() {
    boolean _notEquals = (!Objects.equal(this.transformation, null));
    if (_notEquals) {
      this.transformation.getRuleEngine().dispose();
    }
    this.transformation = null;
    return;
  }
}
