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

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.HostFromTransition;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.SendTransitionAppSignal;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.WaitTransitionAppSignal;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecificationWithGenericMatcher;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EDataTypeInSlotsKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PVisibility;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;

/**
 * A pattern-specific query specification that can instantiate GenericPatternMatcher in a type-safe way.
 * 
 * <p>Original source:
 *         <code><pre>
 *         //Check if those hosts really communicate
 *         
 *         private pattern triggerPairWithoutReachability(sourceHostInstance : HostInstance, targetHostInstance : HostInstance, appInstanceTrigger : ApplicationInstance, 
 *                 appInstanceTarget : ApplicationInstance, cpsTrigger : Transition, cpsTarget : Transition
 *         ) {
 *             find sendTransitionAppSignal(cpsTrigger, appId, triggerApp, signal);
 *             find waitTransitionAppSignal(cpsTarget, waitApp, signal);
 *             ApplicationType.identifier(waitApp, appId);
 *             
 *             find hostFromTransition(triggerApp, appInstanceTrigger, cpsTrigger, sourceHostInstance);    
 *             find hostFromTransition(waitApp, appInstanceTarget, cpsTarget, targetHostInstance);
 *         }
 * </pre></code>
 * 
 * @see GenericPatternMatcher
 * @see GenericPatternMatch
 * 
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtext.xbase.compiler.JvmModelGenerator")
public final class TriggerPairWithoutReachability extends BaseGeneratedEMFQuerySpecificationWithGenericMatcher {
  private TriggerPairWithoutReachability() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static TriggerPairWithoutReachability instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.internal.TriggerPairWithoutReachability (visibility: PUBLIC, simpleName: TriggerPairWithoutReachability, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.internal.TriggerPairWithoutReachability, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.internal) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.internal.TriggerPairWithoutReachability (visibility: PUBLIC, simpleName: TriggerPairWithoutReachability, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.internal.TriggerPairWithoutReachability, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.internal) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final TriggerPairWithoutReachability INSTANCE = new TriggerPairWithoutReachability();
    
    /**
     * Statically initializes the query specification <b>after</b> the field {@link #INSTANCE} is assigned.
     * This initialization order is required to support indirect recursion.
     * 
     * <p> The static initializer is defined using a helper field to work around limitations of the code generator.
     * 
     */
    private static final Object STATIC_INITIALIZER = ensureInitialized();
    
    public static Object ensureInitialized() {
      INSTANCE.ensureInitializedInternal();
      return null;
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private static final TriggerPairWithoutReachability.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_sourceHostInstance = new PParameter("sourceHostInstance", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "HostInstance")), PParameterDirection.INOUT);
    
    private final PParameter parameter_targetHostInstance = new PParameter("targetHostInstance", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "HostInstance")), PParameterDirection.INOUT);
    
    private final PParameter parameter_appInstanceTrigger = new PParameter("appInstanceTrigger", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "ApplicationInstance")), PParameterDirection.INOUT);
    
    private final PParameter parameter_appInstanceTarget = new PParameter("appInstanceTarget", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "ApplicationInstance")), PParameterDirection.INOUT);
    
    private final PParameter parameter_cpsTrigger = new PParameter("cpsTrigger", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "Transition")), PParameterDirection.INOUT);
    
    private final PParameter parameter_cpsTarget = new PParameter("cpsTarget", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "Transition")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_sourceHostInstance, parameter_targetHostInstance, parameter_appInstanceTrigger, parameter_appInstanceTarget, parameter_cpsTrigger, parameter_cpsTarget);
    
    private GeneratedPQuery() {
      super(PVisibility.PRIVATE);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.triggerPairWithoutReachability";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("sourceHostInstance","targetHostInstance","appInstanceTrigger","appInstanceTarget","cpsTrigger","cpsTarget");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return parameters;
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() {
      setEvaluationHints(new QueryEvaluationHint(null, QueryEvaluationHint.BackendRequirement.UNSPECIFIED));
      Set<PBody> bodies = new LinkedHashSet<>();
      {
          PBody body = new PBody(this);
          PVariable var_sourceHostInstance = body.getOrCreateVariableByName("sourceHostInstance");
          PVariable var_targetHostInstance = body.getOrCreateVariableByName("targetHostInstance");
          PVariable var_appInstanceTrigger = body.getOrCreateVariableByName("appInstanceTrigger");
          PVariable var_appInstanceTarget = body.getOrCreateVariableByName("appInstanceTarget");
          PVariable var_cpsTrigger = body.getOrCreateVariableByName("cpsTrigger");
          PVariable var_cpsTarget = body.getOrCreateVariableByName("cpsTarget");
          PVariable var_appId = body.getOrCreateVariableByName("appId");
          PVariable var_triggerApp = body.getOrCreateVariableByName("triggerApp");
          PVariable var_signal = body.getOrCreateVariableByName("signal");
          PVariable var_waitApp = body.getOrCreateVariableByName("waitApp");
          new TypeConstraint(body, Tuples.flatTupleOf(var_sourceHostInstance), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "HostInstance")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_targetHostInstance), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "HostInstance")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_appInstanceTrigger), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "ApplicationInstance")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_appInstanceTarget), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "ApplicationInstance")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_cpsTrigger), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "Transition")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_cpsTarget), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "Transition")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_sourceHostInstance, parameter_sourceHostInstance),
             new ExportedParameter(body, var_targetHostInstance, parameter_targetHostInstance),
             new ExportedParameter(body, var_appInstanceTrigger, parameter_appInstanceTrigger),
             new ExportedParameter(body, var_appInstanceTarget, parameter_appInstanceTarget),
             new ExportedParameter(body, var_cpsTrigger, parameter_cpsTrigger),
             new ExportedParameter(body, var_cpsTarget, parameter_cpsTarget)
          ));
          //     find sendTransitionAppSignal(cpsTrigger, appId, triggerApp, signal)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_cpsTrigger, var_appId, var_triggerApp, var_signal), SendTransitionAppSignal.instance().getInternalQueryRepresentation());
          //     find waitTransitionAppSignal(cpsTarget, waitApp, signal)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_cpsTarget, var_waitApp, var_signal), WaitTransitionAppSignal.instance().getInternalQueryRepresentation());
          //     ApplicationType.identifier(waitApp, appId)
          new TypeConstraint(body, Tuples.flatTupleOf(var_waitApp), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "ApplicationType")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_waitApp, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/cps", "Identifiable", "identifier")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_0_, var_appId);
          //         find hostFromTransition(triggerApp, appInstanceTrigger, cpsTrigger, sourceHostInstance)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_triggerApp, var_appInstanceTrigger, var_cpsTrigger, var_sourceHostInstance), HostFromTransition.instance().getInternalQueryRepresentation());
          //         find hostFromTransition(waitApp, appInstanceTarget, cpsTarget, targetHostInstance)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_waitApp, var_appInstanceTarget, var_cpsTarget, var_targetHostInstance), HostFromTransition.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
