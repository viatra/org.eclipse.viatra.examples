/**
 * 
 *   Copyright (c) 2014-2019 Geza Kulcsar, Akos Horvath, Abel Hegedus, Zoltan Ujhelyi, Peter Lunk, Istvan David, IncQuery Labs Ltd.
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v. 2.0 which is available at
 *   http://www.eclipse.org/legal/epl-v20.html.
 *   
 *   SPDX-License-Identifier: EPL-2.0
 *  
 */
package org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries;

import javax.annotation.Generated;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AlreadyTriggered;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceTransition;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceWithChangedHost;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceWithDepHost;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceWithStateMachine;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceWithStateMachine_noTrace;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceWithStateMachine_withTrace;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceWithState_noTrace;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceWithState_withTrace;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.ApplicationInstance;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.ApplicationInstanceWithHost;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.BehTriggerConnLost;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.BehTriggerNoSrcTrace;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.BehTriggerNoTrgTrace;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.BehTriggerPair;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.ChangeAppId;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.ChangeHostIp;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.CommunicatingAppInstances;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.ConnectionLost;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.Cps2depTrace;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.HostCommunication;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.HostFromTransition;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.HostInstance;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.HostWithType;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.MissingAppInstance;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.MissingDepHost;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.ReachableHosts;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.SendTransitionAppSignal;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.StateDel;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.StateMachineDel;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.TransitionDel;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.Transition_noTrace;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.Transition_withTrace;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.TriggerPair;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.WaitTransitionAppSignal;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in cpsXformM2M.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file cpsXformM2M.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries, the group contains the definition of the following patterns: <ul>
 * <li>cps2depTrace</li>
 * <li>applicationInstance</li>
 * <li>appInstanceWithStateMachine</li>
 * <li>hostWithType</li>
 * <li>hostInstance</li>
 * <li>changeHostIp</li>
 * <li>missingDepHost</li>
 * <li>appInstanceWithDepHost</li>
 * <li>appInstanceWithChangedHost</li>
 * <li>changeAppId</li>
 * <li>missingAppInstance</li>
 * <li>appInstanceWithStateMachine_noTrace</li>
 * <li>appInstanceWithStateMachine_withTrace</li>
 * <li>stateMachineDel</li>
 * <li>appInstanceWithState_noTrace</li>
 * <li>appInstanceWithState_withTrace</li>
 * <li>stateDel</li>
 * <li>transition_noTrace</li>
 * <li>transition_withTrace</li>
 * <li>transitionDel</li>
 * <li>hostCommunication</li>
 * <li>reachableHosts</li>
 * <li>applicationInstanceWithHost</li>
 * <li>communicatingAppInstances</li>
 * <li>sendTransitionAppSignal</li>
 * <li>waitTransitionAppSignal</li>
 * <li>appInstanceTransition</li>
 * <li>hostFromTransition</li>
 * <li>triggerPair</li>
 * <li>alreadyTriggered</li>
 * <li>behTriggerPair</li>
 * <li>connectionLost</li>
 * <li>behTriggerNoSrcTrace</li>
 * <li>behTriggerNoTrgTrace</li>
 * <li>behTriggerConnLost</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtext.xbase.compiler.JvmModelGenerator")
public final class CpsXformM2M extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static CpsXformM2M instance() {
    if (INSTANCE == null) {
        INSTANCE = new CpsXformM2M();
    }
    return INSTANCE;
  }
  
  private static CpsXformM2M INSTANCE;
  
  private CpsXformM2M() {
    querySpecifications.add(Cps2depTrace.instance());
    querySpecifications.add(ApplicationInstance.instance());
    querySpecifications.add(AppInstanceWithStateMachine.instance());
    querySpecifications.add(HostWithType.instance());
    querySpecifications.add(HostInstance.instance());
    querySpecifications.add(ChangeHostIp.instance());
    querySpecifications.add(MissingDepHost.instance());
    querySpecifications.add(AppInstanceWithDepHost.instance());
    querySpecifications.add(AppInstanceWithChangedHost.instance());
    querySpecifications.add(ChangeAppId.instance());
    querySpecifications.add(MissingAppInstance.instance());
    querySpecifications.add(AppInstanceWithStateMachine_noTrace.instance());
    querySpecifications.add(AppInstanceWithStateMachine_withTrace.instance());
    querySpecifications.add(StateMachineDel.instance());
    querySpecifications.add(AppInstanceWithState_noTrace.instance());
    querySpecifications.add(AppInstanceWithState_withTrace.instance());
    querySpecifications.add(StateDel.instance());
    querySpecifications.add(Transition_noTrace.instance());
    querySpecifications.add(Transition_withTrace.instance());
    querySpecifications.add(TransitionDel.instance());
    querySpecifications.add(HostCommunication.instance());
    querySpecifications.add(ReachableHosts.instance());
    querySpecifications.add(ApplicationInstanceWithHost.instance());
    querySpecifications.add(CommunicatingAppInstances.instance());
    querySpecifications.add(SendTransitionAppSignal.instance());
    querySpecifications.add(WaitTransitionAppSignal.instance());
    querySpecifications.add(AppInstanceTransition.instance());
    querySpecifications.add(HostFromTransition.instance());
    querySpecifications.add(TriggerPair.instance());
    querySpecifications.add(AlreadyTriggered.instance());
    querySpecifications.add(BehTriggerPair.instance());
    querySpecifications.add(ConnectionLost.instance());
    querySpecifications.add(BehTriggerNoSrcTrace.instance());
    querySpecifications.add(BehTriggerNoTrgTrace.instance());
    querySpecifications.add(BehTriggerConnLost.instance());
  }
  
  public Cps2depTrace getCps2depTrace() {
    return Cps2depTrace.instance();
  }
  
  public Cps2depTrace.Matcher getCps2depTrace(final ViatraQueryEngine engine) {
    return Cps2depTrace.Matcher.on(engine);
  }
  
  public ApplicationInstance getApplicationInstance() {
    return ApplicationInstance.instance();
  }
  
  public ApplicationInstance.Matcher getApplicationInstance(final ViatraQueryEngine engine) {
    return ApplicationInstance.Matcher.on(engine);
  }
  
  public AppInstanceWithStateMachine getAppInstanceWithStateMachine() {
    return AppInstanceWithStateMachine.instance();
  }
  
  public AppInstanceWithStateMachine.Matcher getAppInstanceWithStateMachine(final ViatraQueryEngine engine) {
    return AppInstanceWithStateMachine.Matcher.on(engine);
  }
  
  public HostWithType getHostWithType() {
    return HostWithType.instance();
  }
  
  public HostWithType.Matcher getHostWithType(final ViatraQueryEngine engine) {
    return HostWithType.Matcher.on(engine);
  }
  
  public HostInstance getHostInstance() {
    return HostInstance.instance();
  }
  
  public HostInstance.Matcher getHostInstance(final ViatraQueryEngine engine) {
    return HostInstance.Matcher.on(engine);
  }
  
  public ChangeHostIp getChangeHostIp() {
    return ChangeHostIp.instance();
  }
  
  public ChangeHostIp.Matcher getChangeHostIp(final ViatraQueryEngine engine) {
    return ChangeHostIp.Matcher.on(engine);
  }
  
  public MissingDepHost getMissingDepHost() {
    return MissingDepHost.instance();
  }
  
  public MissingDepHost.Matcher getMissingDepHost(final ViatraQueryEngine engine) {
    return MissingDepHost.Matcher.on(engine);
  }
  
  public AppInstanceWithDepHost getAppInstanceWithDepHost() {
    return AppInstanceWithDepHost.instance();
  }
  
  public AppInstanceWithDepHost.Matcher getAppInstanceWithDepHost(final ViatraQueryEngine engine) {
    return AppInstanceWithDepHost.Matcher.on(engine);
  }
  
  public AppInstanceWithChangedHost getAppInstanceWithChangedHost() {
    return AppInstanceWithChangedHost.instance();
  }
  
  public AppInstanceWithChangedHost.Matcher getAppInstanceWithChangedHost(final ViatraQueryEngine engine) {
    return AppInstanceWithChangedHost.Matcher.on(engine);
  }
  
  public ChangeAppId getChangeAppId() {
    return ChangeAppId.instance();
  }
  
  public ChangeAppId.Matcher getChangeAppId(final ViatraQueryEngine engine) {
    return ChangeAppId.Matcher.on(engine);
  }
  
  public MissingAppInstance getMissingAppInstance() {
    return MissingAppInstance.instance();
  }
  
  public MissingAppInstance.Matcher getMissingAppInstance(final ViatraQueryEngine engine) {
    return MissingAppInstance.Matcher.on(engine);
  }
  
  public AppInstanceWithStateMachine_noTrace getAppInstanceWithStateMachine_noTrace() {
    return AppInstanceWithStateMachine_noTrace.instance();
  }
  
  public AppInstanceWithStateMachine_noTrace.Matcher getAppInstanceWithStateMachine_noTrace(final ViatraQueryEngine engine) {
    return AppInstanceWithStateMachine_noTrace.Matcher.on(engine);
  }
  
  public AppInstanceWithStateMachine_withTrace getAppInstanceWithStateMachine_withTrace() {
    return AppInstanceWithStateMachine_withTrace.instance();
  }
  
  public AppInstanceWithStateMachine_withTrace.Matcher getAppInstanceWithStateMachine_withTrace(final ViatraQueryEngine engine) {
    return AppInstanceWithStateMachine_withTrace.Matcher.on(engine);
  }
  
  public StateMachineDel getStateMachineDel() {
    return StateMachineDel.instance();
  }
  
  public StateMachineDel.Matcher getStateMachineDel(final ViatraQueryEngine engine) {
    return StateMachineDel.Matcher.on(engine);
  }
  
  public AppInstanceWithState_noTrace getAppInstanceWithState_noTrace() {
    return AppInstanceWithState_noTrace.instance();
  }
  
  public AppInstanceWithState_noTrace.Matcher getAppInstanceWithState_noTrace(final ViatraQueryEngine engine) {
    return AppInstanceWithState_noTrace.Matcher.on(engine);
  }
  
  public AppInstanceWithState_withTrace getAppInstanceWithState_withTrace() {
    return AppInstanceWithState_withTrace.instance();
  }
  
  public AppInstanceWithState_withTrace.Matcher getAppInstanceWithState_withTrace(final ViatraQueryEngine engine) {
    return AppInstanceWithState_withTrace.Matcher.on(engine);
  }
  
  public StateDel getStateDel() {
    return StateDel.instance();
  }
  
  public StateDel.Matcher getStateDel(final ViatraQueryEngine engine) {
    return StateDel.Matcher.on(engine);
  }
  
  public Transition_noTrace getTransition_noTrace() {
    return Transition_noTrace.instance();
  }
  
  public Transition_noTrace.Matcher getTransition_noTrace(final ViatraQueryEngine engine) {
    return Transition_noTrace.Matcher.on(engine);
  }
  
  public Transition_withTrace getTransition_withTrace() {
    return Transition_withTrace.instance();
  }
  
  public Transition_withTrace.Matcher getTransition_withTrace(final ViatraQueryEngine engine) {
    return Transition_withTrace.Matcher.on(engine);
  }
  
  public TransitionDel getTransitionDel() {
    return TransitionDel.instance();
  }
  
  public TransitionDel.Matcher getTransitionDel(final ViatraQueryEngine engine) {
    return TransitionDel.Matcher.on(engine);
  }
  
  public HostCommunication getHostCommunication() {
    return HostCommunication.instance();
  }
  
  public HostCommunication.Matcher getHostCommunication(final ViatraQueryEngine engine) {
    return HostCommunication.Matcher.on(engine);
  }
  
  public ReachableHosts getReachableHosts() {
    return ReachableHosts.instance();
  }
  
  public ReachableHosts.Matcher getReachableHosts(final ViatraQueryEngine engine) {
    return ReachableHosts.Matcher.on(engine);
  }
  
  public ApplicationInstanceWithHost getApplicationInstanceWithHost() {
    return ApplicationInstanceWithHost.instance();
  }
  
  public ApplicationInstanceWithHost.Matcher getApplicationInstanceWithHost(final ViatraQueryEngine engine) {
    return ApplicationInstanceWithHost.Matcher.on(engine);
  }
  
  public CommunicatingAppInstances getCommunicatingAppInstances() {
    return CommunicatingAppInstances.instance();
  }
  
  public CommunicatingAppInstances.Matcher getCommunicatingAppInstances(final ViatraQueryEngine engine) {
    return CommunicatingAppInstances.Matcher.on(engine);
  }
  
  public SendTransitionAppSignal getSendTransitionAppSignal() {
    return SendTransitionAppSignal.instance();
  }
  
  public SendTransitionAppSignal.Matcher getSendTransitionAppSignal(final ViatraQueryEngine engine) {
    return SendTransitionAppSignal.Matcher.on(engine);
  }
  
  public WaitTransitionAppSignal getWaitTransitionAppSignal() {
    return WaitTransitionAppSignal.instance();
  }
  
  public WaitTransitionAppSignal.Matcher getWaitTransitionAppSignal(final ViatraQueryEngine engine) {
    return WaitTransitionAppSignal.Matcher.on(engine);
  }
  
  public AppInstanceTransition getAppInstanceTransition() {
    return AppInstanceTransition.instance();
  }
  
  public AppInstanceTransition.Matcher getAppInstanceTransition(final ViatraQueryEngine engine) {
    return AppInstanceTransition.Matcher.on(engine);
  }
  
  public HostFromTransition getHostFromTransition() {
    return HostFromTransition.instance();
  }
  
  public HostFromTransition.Matcher getHostFromTransition(final ViatraQueryEngine engine) {
    return HostFromTransition.Matcher.on(engine);
  }
  
  public TriggerPair getTriggerPair() {
    return TriggerPair.instance();
  }
  
  public TriggerPair.Matcher getTriggerPair(final ViatraQueryEngine engine) {
    return TriggerPair.Matcher.on(engine);
  }
  
  public AlreadyTriggered getAlreadyTriggered() {
    return AlreadyTriggered.instance();
  }
  
  public AlreadyTriggered.Matcher getAlreadyTriggered(final ViatraQueryEngine engine) {
    return AlreadyTriggered.Matcher.on(engine);
  }
  
  public BehTriggerPair getBehTriggerPair() {
    return BehTriggerPair.instance();
  }
  
  public BehTriggerPair.Matcher getBehTriggerPair(final ViatraQueryEngine engine) {
    return BehTriggerPair.Matcher.on(engine);
  }
  
  public ConnectionLost getConnectionLost() {
    return ConnectionLost.instance();
  }
  
  public ConnectionLost.Matcher getConnectionLost(final ViatraQueryEngine engine) {
    return ConnectionLost.Matcher.on(engine);
  }
  
  public BehTriggerNoSrcTrace getBehTriggerNoSrcTrace() {
    return BehTriggerNoSrcTrace.instance();
  }
  
  public BehTriggerNoSrcTrace.Matcher getBehTriggerNoSrcTrace(final ViatraQueryEngine engine) {
    return BehTriggerNoSrcTrace.Matcher.on(engine);
  }
  
  public BehTriggerNoTrgTrace getBehTriggerNoTrgTrace() {
    return BehTriggerNoTrgTrace.instance();
  }
  
  public BehTriggerNoTrgTrace.Matcher getBehTriggerNoTrgTrace(final ViatraQueryEngine engine) {
    return BehTriggerNoTrgTrace.Matcher.on(engine);
  }
  
  public BehTriggerConnLost getBehTriggerConnLost() {
    return BehTriggerConnLost.instance();
  }
  
  public BehTriggerConnLost.Matcher getBehTriggerConnLost(final ViatraQueryEngine engine) {
    return BehTriggerConnLost.Matcher.on(engine);
  }
}
