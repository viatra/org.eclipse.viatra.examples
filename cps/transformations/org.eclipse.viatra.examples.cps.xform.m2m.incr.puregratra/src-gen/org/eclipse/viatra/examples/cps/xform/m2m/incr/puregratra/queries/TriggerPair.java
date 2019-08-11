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

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Generated;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.ReachableHosts;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.internal.TriggerPairWithoutReachability;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PVisibility;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * A pattern-specific query specification that can instantiate Matcher in a type-safe way.
 * 
 * <p>Original source:
 *         <code><pre>
 *         pattern triggerPair(sourceHostInstance : HostInstance, targetHostInstance : HostInstance, appInstanceTrigger : ApplicationInstance, 
 *                 appInstanceTarget : ApplicationInstance, cpsTrigger : Transition, cpsTarget : Transition
 *         ) {
 *             find triggerPairWithoutReachability(sourceHostInstance, targetHostInstance, appInstanceTrigger, appInstanceTarget, cpsTrigger, cpsTarget);      
 *             find reachableHosts(sourceHostInstance, targetHostInstance);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtext.xbase.compiler.JvmModelGenerator")
public final class TriggerPair extends BaseGeneratedEMFQuerySpecification<TriggerPair.Matcher> {
  /**
   * Pattern-specific match representation of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.triggerPair pattern,
   * to be used in conjunction with {@link Matcher}.
   * 
   * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
   * Each instance is a (possibly partial) substitution of pattern parameters,
   * usable to represent a match of the pattern in the result of a query,
   * or to specify the bound (fixed) input parameters when issuing a query.
   * 
   * @see Matcher
   * 
   */
  public static abstract class Match extends BasePatternMatch {
    private HostInstance fSourceHostInstance;
    
    private HostInstance fTargetHostInstance;
    
    private ApplicationInstance fAppInstanceTrigger;
    
    private ApplicationInstance fAppInstanceTarget;
    
    private Transition fCpsTrigger;
    
    private Transition fCpsTarget;
    
    private static List<String> parameterNames = makeImmutableList("sourceHostInstance", "targetHostInstance", "appInstanceTrigger", "appInstanceTarget", "cpsTrigger", "cpsTarget");
    
    private Match(final HostInstance pSourceHostInstance, final HostInstance pTargetHostInstance, final ApplicationInstance pAppInstanceTrigger, final ApplicationInstance pAppInstanceTarget, final Transition pCpsTrigger, final Transition pCpsTarget) {
      this.fSourceHostInstance = pSourceHostInstance;
      this.fTargetHostInstance = pTargetHostInstance;
      this.fAppInstanceTrigger = pAppInstanceTrigger;
      this.fAppInstanceTarget = pAppInstanceTarget;
      this.fCpsTrigger = pCpsTrigger;
      this.fCpsTarget = pCpsTarget;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("sourceHostInstance".equals(parameterName)) return this.fSourceHostInstance;
      if ("targetHostInstance".equals(parameterName)) return this.fTargetHostInstance;
      if ("appInstanceTrigger".equals(parameterName)) return this.fAppInstanceTrigger;
      if ("appInstanceTarget".equals(parameterName)) return this.fAppInstanceTarget;
      if ("cpsTrigger".equals(parameterName)) return this.fCpsTrigger;
      if ("cpsTarget".equals(parameterName)) return this.fCpsTarget;
      return null;
    }
    
    public HostInstance getSourceHostInstance() {
      return this.fSourceHostInstance;
    }
    
    public HostInstance getTargetHostInstance() {
      return this.fTargetHostInstance;
    }
    
    public ApplicationInstance getAppInstanceTrigger() {
      return this.fAppInstanceTrigger;
    }
    
    public ApplicationInstance getAppInstanceTarget() {
      return this.fAppInstanceTarget;
    }
    
    public Transition getCpsTrigger() {
      return this.fCpsTrigger;
    }
    
    public Transition getCpsTarget() {
      return this.fCpsTarget;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("sourceHostInstance".equals(parameterName) ) {
          this.fSourceHostInstance = (HostInstance) newValue;
          return true;
      }
      if ("targetHostInstance".equals(parameterName) ) {
          this.fTargetHostInstance = (HostInstance) newValue;
          return true;
      }
      if ("appInstanceTrigger".equals(parameterName) ) {
          this.fAppInstanceTrigger = (ApplicationInstance) newValue;
          return true;
      }
      if ("appInstanceTarget".equals(parameterName) ) {
          this.fAppInstanceTarget = (ApplicationInstance) newValue;
          return true;
      }
      if ("cpsTrigger".equals(parameterName) ) {
          this.fCpsTrigger = (Transition) newValue;
          return true;
      }
      if ("cpsTarget".equals(parameterName) ) {
          this.fCpsTarget = (Transition) newValue;
          return true;
      }
      return false;
    }
    
    public void setSourceHostInstance(final HostInstance pSourceHostInstance) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fSourceHostInstance = pSourceHostInstance;
    }
    
    public void setTargetHostInstance(final HostInstance pTargetHostInstance) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTargetHostInstance = pTargetHostInstance;
    }
    
    public void setAppInstanceTrigger(final ApplicationInstance pAppInstanceTrigger) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fAppInstanceTrigger = pAppInstanceTrigger;
    }
    
    public void setAppInstanceTarget(final ApplicationInstance pAppInstanceTarget) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fAppInstanceTarget = pAppInstanceTarget;
    }
    
    public void setCpsTrigger(final Transition pCpsTrigger) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fCpsTrigger = pCpsTrigger;
    }
    
    public void setCpsTarget(final Transition pCpsTarget) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fCpsTarget = pCpsTarget;
    }
    
    @Override
    public String patternName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.triggerPair";
    }
    
    @Override
    public List<String> parameterNames() {
      return TriggerPair.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fSourceHostInstance, fTargetHostInstance, fAppInstanceTrigger, fAppInstanceTarget, fCpsTrigger, fCpsTarget};
    }
    
    @Override
    public TriggerPair.Match toImmutable() {
      return isMutable() ? newMatch(fSourceHostInstance, fTargetHostInstance, fAppInstanceTrigger, fAppInstanceTarget, fCpsTrigger, fCpsTarget) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"sourceHostInstance\"=" + prettyPrintValue(fSourceHostInstance) + ", ");
      result.append("\"targetHostInstance\"=" + prettyPrintValue(fTargetHostInstance) + ", ");
      result.append("\"appInstanceTrigger\"=" + prettyPrintValue(fAppInstanceTrigger) + ", ");
      result.append("\"appInstanceTarget\"=" + prettyPrintValue(fAppInstanceTarget) + ", ");
      result.append("\"cpsTrigger\"=" + prettyPrintValue(fCpsTrigger) + ", ");
      result.append("\"cpsTarget\"=" + prettyPrintValue(fCpsTarget));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fSourceHostInstance, fTargetHostInstance, fAppInstanceTrigger, fAppInstanceTarget, fCpsTrigger, fCpsTarget);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof TriggerPair.Match)) {
          TriggerPair.Match other = (TriggerPair.Match) obj;
          return Objects.equals(fSourceHostInstance, other.fSourceHostInstance) && Objects.equals(fTargetHostInstance, other.fTargetHostInstance) && Objects.equals(fAppInstanceTrigger, other.fAppInstanceTrigger) && Objects.equals(fAppInstanceTarget, other.fAppInstanceTarget) && Objects.equals(fCpsTrigger, other.fCpsTrigger) && Objects.equals(fCpsTarget, other.fCpsTarget);
      } else {
          // this should be infrequent
          if (!(obj instanceof IPatternMatch)) {
              return false;
          }
          IPatternMatch otherSig  = (IPatternMatch) obj;
          return Objects.equals(specification(), otherSig.specification()) && Arrays.deepEquals(toArray(), otherSig.toArray());
      }
    }
    
    @Override
    public TriggerPair specification() {
      return TriggerPair.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static TriggerPair.Match newEmptyMatch() {
      return new Mutable(null, null, null, null, null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pSourceHostInstance the fixed value of pattern parameter sourceHostInstance, or null if not bound.
     * @param pTargetHostInstance the fixed value of pattern parameter targetHostInstance, or null if not bound.
     * @param pAppInstanceTrigger the fixed value of pattern parameter appInstanceTrigger, or null if not bound.
     * @param pAppInstanceTarget the fixed value of pattern parameter appInstanceTarget, or null if not bound.
     * @param pCpsTrigger the fixed value of pattern parameter cpsTrigger, or null if not bound.
     * @param pCpsTarget the fixed value of pattern parameter cpsTarget, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static TriggerPair.Match newMutableMatch(final HostInstance pSourceHostInstance, final HostInstance pTargetHostInstance, final ApplicationInstance pAppInstanceTrigger, final ApplicationInstance pAppInstanceTarget, final Transition pCpsTrigger, final Transition pCpsTarget) {
      return new Mutable(pSourceHostInstance, pTargetHostInstance, pAppInstanceTrigger, pAppInstanceTarget, pCpsTrigger, pCpsTarget);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSourceHostInstance the fixed value of pattern parameter sourceHostInstance, or null if not bound.
     * @param pTargetHostInstance the fixed value of pattern parameter targetHostInstance, or null if not bound.
     * @param pAppInstanceTrigger the fixed value of pattern parameter appInstanceTrigger, or null if not bound.
     * @param pAppInstanceTarget the fixed value of pattern parameter appInstanceTarget, or null if not bound.
     * @param pCpsTrigger the fixed value of pattern parameter cpsTrigger, or null if not bound.
     * @param pCpsTarget the fixed value of pattern parameter cpsTarget, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static TriggerPair.Match newMatch(final HostInstance pSourceHostInstance, final HostInstance pTargetHostInstance, final ApplicationInstance pAppInstanceTrigger, final ApplicationInstance pAppInstanceTarget, final Transition pCpsTrigger, final Transition pCpsTarget) {
      return new Immutable(pSourceHostInstance, pTargetHostInstance, pAppInstanceTrigger, pAppInstanceTarget, pCpsTrigger, pCpsTarget);
    }
    
    private static final class Mutable extends TriggerPair.Match {
      Mutable(final HostInstance pSourceHostInstance, final HostInstance pTargetHostInstance, final ApplicationInstance pAppInstanceTrigger, final ApplicationInstance pAppInstanceTarget, final Transition pCpsTrigger, final Transition pCpsTarget) {
        super(pSourceHostInstance, pTargetHostInstance, pAppInstanceTrigger, pAppInstanceTarget, pCpsTrigger, pCpsTarget);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends TriggerPair.Match {
      Immutable(final HostInstance pSourceHostInstance, final HostInstance pTargetHostInstance, final ApplicationInstance pAppInstanceTrigger, final ApplicationInstance pAppInstanceTarget, final Transition pCpsTrigger, final Transition pCpsTarget) {
        super(pSourceHostInstance, pTargetHostInstance, pAppInstanceTrigger, pAppInstanceTarget, pCpsTrigger, pCpsTarget);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.triggerPair pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern triggerPair(sourceHostInstance : HostInstance, targetHostInstance : HostInstance, appInstanceTrigger : ApplicationInstance, 
   *         appInstanceTarget : ApplicationInstance, cpsTrigger : Transition, cpsTarget : Transition
   * ) {
   *     find triggerPairWithoutReachability(sourceHostInstance, targetHostInstance, appInstanceTrigger, appInstanceTarget, cpsTrigger, cpsTarget);      
   *     find reachableHosts(sourceHostInstance, targetHostInstance);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see TriggerPair
   * 
   */
  public static class Matcher extends BaseMatcher<TriggerPair.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static TriggerPair.Matcher on(final ViatraQueryEngine engine) {
      // check if matcher already exists
      Matcher matcher = engine.getExistingMatcher(querySpecification());
      if (matcher == null) {
          matcher = (Matcher)engine.getMatcher(querySpecification());
      }
      return matcher;
    }
    
    /**
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * @return an initialized matcher
     * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
     * 
     */
    public static TriggerPair.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_SOURCEHOSTINSTANCE = 0;
    
    private static final int POSITION_TARGETHOSTINSTANCE = 1;
    
    private static final int POSITION_APPINSTANCETRIGGER = 2;
    
    private static final int POSITION_APPINSTANCETARGET = 3;
    
    private static final int POSITION_CPSTRIGGER = 4;
    
    private static final int POSITION_CPSTARGET = 5;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(TriggerPair.Matcher.class);
    
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    private Matcher() {
      super(querySpecification());
    }
    
    /**
     * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pSourceHostInstance the fixed value of pattern parameter sourceHostInstance, or null if not bound.
     * @param pTargetHostInstance the fixed value of pattern parameter targetHostInstance, or null if not bound.
     * @param pAppInstanceTrigger the fixed value of pattern parameter appInstanceTrigger, or null if not bound.
     * @param pAppInstanceTarget the fixed value of pattern parameter appInstanceTarget, or null if not bound.
     * @param pCpsTrigger the fixed value of pattern parameter cpsTrigger, or null if not bound.
     * @param pCpsTarget the fixed value of pattern parameter cpsTarget, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<TriggerPair.Match> getAllMatches(final HostInstance pSourceHostInstance, final HostInstance pTargetHostInstance, final ApplicationInstance pAppInstanceTrigger, final ApplicationInstance pAppInstanceTarget, final Transition pCpsTrigger, final Transition pCpsTarget) {
      return rawStreamAllMatches(new Object[]{pSourceHostInstance, pTargetHostInstance, pAppInstanceTrigger, pAppInstanceTarget, pCpsTrigger, pCpsTarget}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pSourceHostInstance the fixed value of pattern parameter sourceHostInstance, or null if not bound.
     * @param pTargetHostInstance the fixed value of pattern parameter targetHostInstance, or null if not bound.
     * @param pAppInstanceTrigger the fixed value of pattern parameter appInstanceTrigger, or null if not bound.
     * @param pAppInstanceTarget the fixed value of pattern parameter appInstanceTarget, or null if not bound.
     * @param pCpsTrigger the fixed value of pattern parameter cpsTrigger, or null if not bound.
     * @param pCpsTarget the fixed value of pattern parameter cpsTarget, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<TriggerPair.Match> streamAllMatches(final HostInstance pSourceHostInstance, final HostInstance pTargetHostInstance, final ApplicationInstance pAppInstanceTrigger, final ApplicationInstance pAppInstanceTarget, final Transition pCpsTrigger, final Transition pCpsTarget) {
      return rawStreamAllMatches(new Object[]{pSourceHostInstance, pTargetHostInstance, pAppInstanceTrigger, pAppInstanceTarget, pCpsTrigger, pCpsTarget});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSourceHostInstance the fixed value of pattern parameter sourceHostInstance, or null if not bound.
     * @param pTargetHostInstance the fixed value of pattern parameter targetHostInstance, or null if not bound.
     * @param pAppInstanceTrigger the fixed value of pattern parameter appInstanceTrigger, or null if not bound.
     * @param pAppInstanceTarget the fixed value of pattern parameter appInstanceTarget, or null if not bound.
     * @param pCpsTrigger the fixed value of pattern parameter cpsTrigger, or null if not bound.
     * @param pCpsTarget the fixed value of pattern parameter cpsTarget, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<TriggerPair.Match> getOneArbitraryMatch(final HostInstance pSourceHostInstance, final HostInstance pTargetHostInstance, final ApplicationInstance pAppInstanceTrigger, final ApplicationInstance pAppInstanceTarget, final Transition pCpsTrigger, final Transition pCpsTarget) {
      return rawGetOneArbitraryMatch(new Object[]{pSourceHostInstance, pTargetHostInstance, pAppInstanceTrigger, pAppInstanceTarget, pCpsTrigger, pCpsTarget});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pSourceHostInstance the fixed value of pattern parameter sourceHostInstance, or null if not bound.
     * @param pTargetHostInstance the fixed value of pattern parameter targetHostInstance, or null if not bound.
     * @param pAppInstanceTrigger the fixed value of pattern parameter appInstanceTrigger, or null if not bound.
     * @param pAppInstanceTarget the fixed value of pattern parameter appInstanceTarget, or null if not bound.
     * @param pCpsTrigger the fixed value of pattern parameter cpsTrigger, or null if not bound.
     * @param pCpsTarget the fixed value of pattern parameter cpsTarget, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final HostInstance pSourceHostInstance, final HostInstance pTargetHostInstance, final ApplicationInstance pAppInstanceTrigger, final ApplicationInstance pAppInstanceTarget, final Transition pCpsTrigger, final Transition pCpsTarget) {
      return rawHasMatch(new Object[]{pSourceHostInstance, pTargetHostInstance, pAppInstanceTrigger, pAppInstanceTarget, pCpsTrigger, pCpsTarget});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pSourceHostInstance the fixed value of pattern parameter sourceHostInstance, or null if not bound.
     * @param pTargetHostInstance the fixed value of pattern parameter targetHostInstance, or null if not bound.
     * @param pAppInstanceTrigger the fixed value of pattern parameter appInstanceTrigger, or null if not bound.
     * @param pAppInstanceTarget the fixed value of pattern parameter appInstanceTarget, or null if not bound.
     * @param pCpsTrigger the fixed value of pattern parameter cpsTrigger, or null if not bound.
     * @param pCpsTarget the fixed value of pattern parameter cpsTarget, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final HostInstance pSourceHostInstance, final HostInstance pTargetHostInstance, final ApplicationInstance pAppInstanceTrigger, final ApplicationInstance pAppInstanceTarget, final Transition pCpsTrigger, final Transition pCpsTarget) {
      return rawCountMatches(new Object[]{pSourceHostInstance, pTargetHostInstance, pAppInstanceTrigger, pAppInstanceTarget, pCpsTrigger, pCpsTarget});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSourceHostInstance the fixed value of pattern parameter sourceHostInstance, or null if not bound.
     * @param pTargetHostInstance the fixed value of pattern parameter targetHostInstance, or null if not bound.
     * @param pAppInstanceTrigger the fixed value of pattern parameter appInstanceTrigger, or null if not bound.
     * @param pAppInstanceTarget the fixed value of pattern parameter appInstanceTarget, or null if not bound.
     * @param pCpsTrigger the fixed value of pattern parameter cpsTrigger, or null if not bound.
     * @param pCpsTarget the fixed value of pattern parameter cpsTarget, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final HostInstance pSourceHostInstance, final HostInstance pTargetHostInstance, final ApplicationInstance pAppInstanceTrigger, final ApplicationInstance pAppInstanceTarget, final Transition pCpsTrigger, final Transition pCpsTarget, final Consumer<? super TriggerPair.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pSourceHostInstance, pTargetHostInstance, pAppInstanceTrigger, pAppInstanceTarget, pCpsTrigger, pCpsTarget}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSourceHostInstance the fixed value of pattern parameter sourceHostInstance, or null if not bound.
     * @param pTargetHostInstance the fixed value of pattern parameter targetHostInstance, or null if not bound.
     * @param pAppInstanceTrigger the fixed value of pattern parameter appInstanceTrigger, or null if not bound.
     * @param pAppInstanceTarget the fixed value of pattern parameter appInstanceTarget, or null if not bound.
     * @param pCpsTrigger the fixed value of pattern parameter cpsTrigger, or null if not bound.
     * @param pCpsTarget the fixed value of pattern parameter cpsTarget, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public TriggerPair.Match newMatch(final HostInstance pSourceHostInstance, final HostInstance pTargetHostInstance, final ApplicationInstance pAppInstanceTrigger, final ApplicationInstance pAppInstanceTarget, final Transition pCpsTrigger, final Transition pCpsTarget) {
      return TriggerPair.Match.newMatch(pSourceHostInstance, pTargetHostInstance, pAppInstanceTrigger, pAppInstanceTarget, pCpsTrigger, pCpsTarget);
    }
    
    /**
     * Retrieve the set of values that occur in matches for sourceHostInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<HostInstance> rawStreamAllValuesOfsourceHostInstance(final Object[] parameters) {
      return rawStreamAllValues(POSITION_SOURCEHOSTINSTANCE, parameters).map(HostInstance.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for sourceHostInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HostInstance> getAllValuesOfsourceHostInstance() {
      return rawStreamAllValuesOfsourceHostInstance(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for sourceHostInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<HostInstance> streamAllValuesOfsourceHostInstance() {
      return rawStreamAllValuesOfsourceHostInstance(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for sourceHostInstance.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<HostInstance> streamAllValuesOfsourceHostInstance(final TriggerPair.Match partialMatch) {
      return rawStreamAllValuesOfsourceHostInstance(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for sourceHostInstance.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<HostInstance> streamAllValuesOfsourceHostInstance(final HostInstance pTargetHostInstance, final ApplicationInstance pAppInstanceTrigger, final ApplicationInstance pAppInstanceTarget, final Transition pCpsTrigger, final Transition pCpsTarget) {
      return rawStreamAllValuesOfsourceHostInstance(new Object[]{null, pTargetHostInstance, pAppInstanceTrigger, pAppInstanceTarget, pCpsTrigger, pCpsTarget});
    }
    
    /**
     * Retrieve the set of values that occur in matches for sourceHostInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HostInstance> getAllValuesOfsourceHostInstance(final TriggerPair.Match partialMatch) {
      return rawStreamAllValuesOfsourceHostInstance(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for sourceHostInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HostInstance> getAllValuesOfsourceHostInstance(final HostInstance pTargetHostInstance, final ApplicationInstance pAppInstanceTrigger, final ApplicationInstance pAppInstanceTarget, final Transition pCpsTrigger, final Transition pCpsTarget) {
      return rawStreamAllValuesOfsourceHostInstance(new Object[]{null, pTargetHostInstance, pAppInstanceTrigger, pAppInstanceTarget, pCpsTrigger, pCpsTarget}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for targetHostInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<HostInstance> rawStreamAllValuesOftargetHostInstance(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TARGETHOSTINSTANCE, parameters).map(HostInstance.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for targetHostInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HostInstance> getAllValuesOftargetHostInstance() {
      return rawStreamAllValuesOftargetHostInstance(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for targetHostInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<HostInstance> streamAllValuesOftargetHostInstance() {
      return rawStreamAllValuesOftargetHostInstance(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for targetHostInstance.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<HostInstance> streamAllValuesOftargetHostInstance(final TriggerPair.Match partialMatch) {
      return rawStreamAllValuesOftargetHostInstance(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for targetHostInstance.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<HostInstance> streamAllValuesOftargetHostInstance(final HostInstance pSourceHostInstance, final ApplicationInstance pAppInstanceTrigger, final ApplicationInstance pAppInstanceTarget, final Transition pCpsTrigger, final Transition pCpsTarget) {
      return rawStreamAllValuesOftargetHostInstance(new Object[]{pSourceHostInstance, null, pAppInstanceTrigger, pAppInstanceTarget, pCpsTrigger, pCpsTarget});
    }
    
    /**
     * Retrieve the set of values that occur in matches for targetHostInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HostInstance> getAllValuesOftargetHostInstance(final TriggerPair.Match partialMatch) {
      return rawStreamAllValuesOftargetHostInstance(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for targetHostInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HostInstance> getAllValuesOftargetHostInstance(final HostInstance pSourceHostInstance, final ApplicationInstance pAppInstanceTrigger, final ApplicationInstance pAppInstanceTarget, final Transition pCpsTrigger, final Transition pCpsTarget) {
      return rawStreamAllValuesOftargetHostInstance(new Object[]{pSourceHostInstance, null, pAppInstanceTrigger, pAppInstanceTarget, pCpsTrigger, pCpsTarget}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstanceTrigger.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<ApplicationInstance> rawStreamAllValuesOfappInstanceTrigger(final Object[] parameters) {
      return rawStreamAllValues(POSITION_APPINSTANCETRIGGER, parameters).map(ApplicationInstance.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstanceTrigger.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationInstance> getAllValuesOfappInstanceTrigger() {
      return rawStreamAllValuesOfappInstanceTrigger(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstanceTrigger.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<ApplicationInstance> streamAllValuesOfappInstanceTrigger() {
      return rawStreamAllValuesOfappInstanceTrigger(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstanceTrigger.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<ApplicationInstance> streamAllValuesOfappInstanceTrigger(final TriggerPair.Match partialMatch) {
      return rawStreamAllValuesOfappInstanceTrigger(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstanceTrigger.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<ApplicationInstance> streamAllValuesOfappInstanceTrigger(final HostInstance pSourceHostInstance, final HostInstance pTargetHostInstance, final ApplicationInstance pAppInstanceTarget, final Transition pCpsTrigger, final Transition pCpsTarget) {
      return rawStreamAllValuesOfappInstanceTrigger(new Object[]{pSourceHostInstance, pTargetHostInstance, null, pAppInstanceTarget, pCpsTrigger, pCpsTarget});
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstanceTrigger.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationInstance> getAllValuesOfappInstanceTrigger(final TriggerPair.Match partialMatch) {
      return rawStreamAllValuesOfappInstanceTrigger(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstanceTrigger.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationInstance> getAllValuesOfappInstanceTrigger(final HostInstance pSourceHostInstance, final HostInstance pTargetHostInstance, final ApplicationInstance pAppInstanceTarget, final Transition pCpsTrigger, final Transition pCpsTarget) {
      return rawStreamAllValuesOfappInstanceTrigger(new Object[]{pSourceHostInstance, pTargetHostInstance, null, pAppInstanceTarget, pCpsTrigger, pCpsTarget}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstanceTarget.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<ApplicationInstance> rawStreamAllValuesOfappInstanceTarget(final Object[] parameters) {
      return rawStreamAllValues(POSITION_APPINSTANCETARGET, parameters).map(ApplicationInstance.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstanceTarget.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationInstance> getAllValuesOfappInstanceTarget() {
      return rawStreamAllValuesOfappInstanceTarget(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstanceTarget.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<ApplicationInstance> streamAllValuesOfappInstanceTarget() {
      return rawStreamAllValuesOfappInstanceTarget(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstanceTarget.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<ApplicationInstance> streamAllValuesOfappInstanceTarget(final TriggerPair.Match partialMatch) {
      return rawStreamAllValuesOfappInstanceTarget(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstanceTarget.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<ApplicationInstance> streamAllValuesOfappInstanceTarget(final HostInstance pSourceHostInstance, final HostInstance pTargetHostInstance, final ApplicationInstance pAppInstanceTrigger, final Transition pCpsTrigger, final Transition pCpsTarget) {
      return rawStreamAllValuesOfappInstanceTarget(new Object[]{pSourceHostInstance, pTargetHostInstance, pAppInstanceTrigger, null, pCpsTrigger, pCpsTarget});
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstanceTarget.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationInstance> getAllValuesOfappInstanceTarget(final TriggerPair.Match partialMatch) {
      return rawStreamAllValuesOfappInstanceTarget(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstanceTarget.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationInstance> getAllValuesOfappInstanceTarget(final HostInstance pSourceHostInstance, final HostInstance pTargetHostInstance, final ApplicationInstance pAppInstanceTrigger, final Transition pCpsTrigger, final Transition pCpsTarget) {
      return rawStreamAllValuesOfappInstanceTarget(new Object[]{pSourceHostInstance, pTargetHostInstance, pAppInstanceTrigger, null, pCpsTrigger, pCpsTarget}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for cpsTrigger.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Transition> rawStreamAllValuesOfcpsTrigger(final Object[] parameters) {
      return rawStreamAllValues(POSITION_CPSTRIGGER, parameters).map(Transition.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for cpsTrigger.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOfcpsTrigger() {
      return rawStreamAllValuesOfcpsTrigger(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for cpsTrigger.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Transition> streamAllValuesOfcpsTrigger() {
      return rawStreamAllValuesOfcpsTrigger(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for cpsTrigger.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Transition> streamAllValuesOfcpsTrigger(final TriggerPair.Match partialMatch) {
      return rawStreamAllValuesOfcpsTrigger(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for cpsTrigger.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Transition> streamAllValuesOfcpsTrigger(final HostInstance pSourceHostInstance, final HostInstance pTargetHostInstance, final ApplicationInstance pAppInstanceTrigger, final ApplicationInstance pAppInstanceTarget, final Transition pCpsTarget) {
      return rawStreamAllValuesOfcpsTrigger(new Object[]{pSourceHostInstance, pTargetHostInstance, pAppInstanceTrigger, pAppInstanceTarget, null, pCpsTarget});
    }
    
    /**
     * Retrieve the set of values that occur in matches for cpsTrigger.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOfcpsTrigger(final TriggerPair.Match partialMatch) {
      return rawStreamAllValuesOfcpsTrigger(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for cpsTrigger.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOfcpsTrigger(final HostInstance pSourceHostInstance, final HostInstance pTargetHostInstance, final ApplicationInstance pAppInstanceTrigger, final ApplicationInstance pAppInstanceTarget, final Transition pCpsTarget) {
      return rawStreamAllValuesOfcpsTrigger(new Object[]{pSourceHostInstance, pTargetHostInstance, pAppInstanceTrigger, pAppInstanceTarget, null, pCpsTarget}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for cpsTarget.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Transition> rawStreamAllValuesOfcpsTarget(final Object[] parameters) {
      return rawStreamAllValues(POSITION_CPSTARGET, parameters).map(Transition.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for cpsTarget.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOfcpsTarget() {
      return rawStreamAllValuesOfcpsTarget(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for cpsTarget.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Transition> streamAllValuesOfcpsTarget() {
      return rawStreamAllValuesOfcpsTarget(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for cpsTarget.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Transition> streamAllValuesOfcpsTarget(final TriggerPair.Match partialMatch) {
      return rawStreamAllValuesOfcpsTarget(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for cpsTarget.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Transition> streamAllValuesOfcpsTarget(final HostInstance pSourceHostInstance, final HostInstance pTargetHostInstance, final ApplicationInstance pAppInstanceTrigger, final ApplicationInstance pAppInstanceTarget, final Transition pCpsTrigger) {
      return rawStreamAllValuesOfcpsTarget(new Object[]{pSourceHostInstance, pTargetHostInstance, pAppInstanceTrigger, pAppInstanceTarget, pCpsTrigger, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for cpsTarget.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOfcpsTarget(final TriggerPair.Match partialMatch) {
      return rawStreamAllValuesOfcpsTarget(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for cpsTarget.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOfcpsTarget(final HostInstance pSourceHostInstance, final HostInstance pTargetHostInstance, final ApplicationInstance pAppInstanceTrigger, final ApplicationInstance pAppInstanceTarget, final Transition pCpsTrigger) {
      return rawStreamAllValuesOfcpsTarget(new Object[]{pSourceHostInstance, pTargetHostInstance, pAppInstanceTrigger, pAppInstanceTarget, pCpsTrigger, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected TriggerPair.Match tupleToMatch(final Tuple t) {
      try {
          return TriggerPair.Match.newMatch((HostInstance) t.get(POSITION_SOURCEHOSTINSTANCE), (HostInstance) t.get(POSITION_TARGETHOSTINSTANCE), (ApplicationInstance) t.get(POSITION_APPINSTANCETRIGGER), (ApplicationInstance) t.get(POSITION_APPINSTANCETARGET), (Transition) t.get(POSITION_CPSTRIGGER), (Transition) t.get(POSITION_CPSTARGET));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected TriggerPair.Match arrayToMatch(final Object[] match) {
      try {
          return TriggerPair.Match.newMatch((HostInstance) match[POSITION_SOURCEHOSTINSTANCE], (HostInstance) match[POSITION_TARGETHOSTINSTANCE], (ApplicationInstance) match[POSITION_APPINSTANCETRIGGER], (ApplicationInstance) match[POSITION_APPINSTANCETARGET], (Transition) match[POSITION_CPSTRIGGER], (Transition) match[POSITION_CPSTARGET]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected TriggerPair.Match arrayToMatchMutable(final Object[] match) {
      try {
          return TriggerPair.Match.newMutableMatch((HostInstance) match[POSITION_SOURCEHOSTINSTANCE], (HostInstance) match[POSITION_TARGETHOSTINSTANCE], (ApplicationInstance) match[POSITION_APPINSTANCETRIGGER], (ApplicationInstance) match[POSITION_APPINSTANCETARGET], (Transition) match[POSITION_CPSTRIGGER], (Transition) match[POSITION_CPSTARGET]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    /**
     * @return the singleton instance of the query specification of this pattern
     * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
     * 
     */
    public static IQuerySpecification<TriggerPair.Matcher> querySpecification() {
      return TriggerPair.instance();
    }
  }
  
  private TriggerPair() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static TriggerPair instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected TriggerPair.Matcher instantiate(final ViatraQueryEngine engine) {
    return TriggerPair.Matcher.on(engine);
  }
  
  @Override
  public TriggerPair.Matcher instantiate() {
    return TriggerPair.Matcher.create();
  }
  
  @Override
  public TriggerPair.Match newEmptyMatch() {
    return TriggerPair.Match.newEmptyMatch();
  }
  
  @Override
  public TriggerPair.Match newMatch(final Object... parameters) {
    return TriggerPair.Match.newMatch((org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance) parameters[0], (org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance) parameters[1], (org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance) parameters[2], (org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance) parameters[3], (org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition) parameters[4], (org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition) parameters[5]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.TriggerPair (visibility: PUBLIC, simpleName: TriggerPair, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.TriggerPair, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.TriggerPair (visibility: PUBLIC, simpleName: TriggerPair, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.TriggerPair, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final TriggerPair INSTANCE = new TriggerPair();
    
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
    private static final TriggerPair.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_sourceHostInstance = new PParameter("sourceHostInstance", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "HostInstance")), PParameterDirection.INOUT);
    
    private final PParameter parameter_targetHostInstance = new PParameter("targetHostInstance", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "HostInstance")), PParameterDirection.INOUT);
    
    private final PParameter parameter_appInstanceTrigger = new PParameter("appInstanceTrigger", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "ApplicationInstance")), PParameterDirection.INOUT);
    
    private final PParameter parameter_appInstanceTarget = new PParameter("appInstanceTarget", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "ApplicationInstance")), PParameterDirection.INOUT);
    
    private final PParameter parameter_cpsTrigger = new PParameter("cpsTrigger", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "Transition")), PParameterDirection.INOUT);
    
    private final PParameter parameter_cpsTarget = new PParameter("cpsTarget", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "Transition")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_sourceHostInstance, parameter_targetHostInstance, parameter_appInstanceTrigger, parameter_appInstanceTarget, parameter_cpsTrigger, parameter_cpsTarget);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.triggerPair";
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
          //     find triggerPairWithoutReachability(sourceHostInstance, targetHostInstance, appInstanceTrigger, appInstanceTarget, cpsTrigger, cpsTarget)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_sourceHostInstance, var_targetHostInstance, var_appInstanceTrigger, var_appInstanceTarget, var_cpsTrigger, var_cpsTarget), TriggerPairWithoutReachability.instance().getInternalQueryRepresentation());
          //           find reachableHosts(sourceHostInstance, targetHostInstance)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_sourceHostInstance, var_targetHostInstance), ReachableHosts.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
