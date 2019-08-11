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
package org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.internal;

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
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.internal.TriggerPairWithoutReachability;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all patterns defined in cpsXformM2M.vql.
 * 
 * <p>A private group that includes private patterns as well. Only intended use case is for pattern testing.
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
 * <li>triggerPairWithoutReachability</li>
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
public final class CpsXformM2MAll extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static CpsXformM2MAll instance() {
    if (INSTANCE == null) {
        INSTANCE = new CpsXformM2MAll();
    }
    return INSTANCE;
  }
  
  private static CpsXformM2MAll INSTANCE;
  
  private CpsXformM2MAll() {
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
    querySpecifications.add(TriggerPairWithoutReachability.instance());
    querySpecifications.add(TriggerPair.instance());
    querySpecifications.add(AlreadyTriggered.instance());
    querySpecifications.add(BehTriggerPair.instance());
    querySpecifications.add(ConnectionLost.instance());
    querySpecifications.add(BehTriggerNoSrcTrace.instance());
    querySpecifications.add(BehTriggerNoTrgTrace.instance());
    querySpecifications.add(BehTriggerConnLost.instance());
  }
}
