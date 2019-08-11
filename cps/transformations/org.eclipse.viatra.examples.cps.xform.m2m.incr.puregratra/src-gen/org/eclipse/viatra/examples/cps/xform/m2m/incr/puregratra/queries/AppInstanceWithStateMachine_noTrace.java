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
import java.util.Collections;
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
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.StateMachine;
import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceWithDepHost;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceWithStateMachine;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
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
 *         State Machine Rule Patterns (Spec 3) 
 *         
 *         pattern appInstanceWithStateMachine_noTrace(appInstance : ApplicationInstance, 
 *                             stateMachine : StateMachine, depApp : DeploymentApplication
 *         ) {
 *             find appInstanceWithStateMachine(_, appInstance, stateMachine);
 *             find appInstanceWithDepHost(appInstance, depHost);
 *             DeploymentHost.applications(depHost,depApp);
 *             
 *             neg CPS2DeploymentTrace.cpsElements(_, stateMachine);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtext.xbase.compiler.JvmModelGenerator")
public final class AppInstanceWithStateMachine_noTrace extends BaseGeneratedEMFQuerySpecification<AppInstanceWithStateMachine_noTrace.Matcher> {
  /**
   * Pattern-specific match representation of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.appInstanceWithStateMachine_noTrace pattern,
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
    private ApplicationInstance fAppInstance;
    
    private StateMachine fStateMachine;
    
    private DeploymentApplication fDepApp;
    
    private static List<String> parameterNames = makeImmutableList("appInstance", "stateMachine", "depApp");
    
    private Match(final ApplicationInstance pAppInstance, final StateMachine pStateMachine, final DeploymentApplication pDepApp) {
      this.fAppInstance = pAppInstance;
      this.fStateMachine = pStateMachine;
      this.fDepApp = pDepApp;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("appInstance".equals(parameterName)) return this.fAppInstance;
      if ("stateMachine".equals(parameterName)) return this.fStateMachine;
      if ("depApp".equals(parameterName)) return this.fDepApp;
      return null;
    }
    
    public ApplicationInstance getAppInstance() {
      return this.fAppInstance;
    }
    
    public StateMachine getStateMachine() {
      return this.fStateMachine;
    }
    
    public DeploymentApplication getDepApp() {
      return this.fDepApp;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("appInstance".equals(parameterName) ) {
          this.fAppInstance = (ApplicationInstance) newValue;
          return true;
      }
      if ("stateMachine".equals(parameterName) ) {
          this.fStateMachine = (StateMachine) newValue;
          return true;
      }
      if ("depApp".equals(parameterName) ) {
          this.fDepApp = (DeploymentApplication) newValue;
          return true;
      }
      return false;
    }
    
    public void setAppInstance(final ApplicationInstance pAppInstance) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fAppInstance = pAppInstance;
    }
    
    public void setStateMachine(final StateMachine pStateMachine) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fStateMachine = pStateMachine;
    }
    
    public void setDepApp(final DeploymentApplication pDepApp) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fDepApp = pDepApp;
    }
    
    @Override
    public String patternName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.appInstanceWithStateMachine_noTrace";
    }
    
    @Override
    public List<String> parameterNames() {
      return AppInstanceWithStateMachine_noTrace.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fAppInstance, fStateMachine, fDepApp};
    }
    
    @Override
    public AppInstanceWithStateMachine_noTrace.Match toImmutable() {
      return isMutable() ? newMatch(fAppInstance, fStateMachine, fDepApp) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"appInstance\"=" + prettyPrintValue(fAppInstance) + ", ");
      result.append("\"stateMachine\"=" + prettyPrintValue(fStateMachine) + ", ");
      result.append("\"depApp\"=" + prettyPrintValue(fDepApp));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fAppInstance, fStateMachine, fDepApp);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof AppInstanceWithStateMachine_noTrace.Match)) {
          AppInstanceWithStateMachine_noTrace.Match other = (AppInstanceWithStateMachine_noTrace.Match) obj;
          return Objects.equals(fAppInstance, other.fAppInstance) && Objects.equals(fStateMachine, other.fStateMachine) && Objects.equals(fDepApp, other.fDepApp);
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
    public AppInstanceWithStateMachine_noTrace specification() {
      return AppInstanceWithStateMachine_noTrace.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static AppInstanceWithStateMachine_noTrace.Match newEmptyMatch() {
      return new Mutable(null, null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static AppInstanceWithStateMachine_noTrace.Match newMutableMatch(final ApplicationInstance pAppInstance, final StateMachine pStateMachine, final DeploymentApplication pDepApp) {
      return new Mutable(pAppInstance, pStateMachine, pDepApp);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static AppInstanceWithStateMachine_noTrace.Match newMatch(final ApplicationInstance pAppInstance, final StateMachine pStateMachine, final DeploymentApplication pDepApp) {
      return new Immutable(pAppInstance, pStateMachine, pDepApp);
    }
    
    private static final class Mutable extends AppInstanceWithStateMachine_noTrace.Match {
      Mutable(final ApplicationInstance pAppInstance, final StateMachine pStateMachine, final DeploymentApplication pDepApp) {
        super(pAppInstance, pStateMachine, pDepApp);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends AppInstanceWithStateMachine_noTrace.Match {
      Immutable(final ApplicationInstance pAppInstance, final StateMachine pStateMachine, final DeploymentApplication pDepApp) {
        super(pAppInstance, pStateMachine, pDepApp);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.appInstanceWithStateMachine_noTrace pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * State Machine Rule Patterns (Spec 3) 
   * 
   * pattern appInstanceWithStateMachine_noTrace(appInstance : ApplicationInstance, 
   *                     stateMachine : StateMachine, depApp : DeploymentApplication
   * ) {
   *     find appInstanceWithStateMachine(_, appInstance, stateMachine);
   *     find appInstanceWithDepHost(appInstance, depHost);
   *     DeploymentHost.applications(depHost,depApp);
   *     
   *     neg CPS2DeploymentTrace.cpsElements(_, stateMachine);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see AppInstanceWithStateMachine_noTrace
   * 
   */
  public static class Matcher extends BaseMatcher<AppInstanceWithStateMachine_noTrace.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static AppInstanceWithStateMachine_noTrace.Matcher on(final ViatraQueryEngine engine) {
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
    public static AppInstanceWithStateMachine_noTrace.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_APPINSTANCE = 0;
    
    private static final int POSITION_STATEMACHINE = 1;
    
    private static final int POSITION_DEPAPP = 2;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(AppInstanceWithStateMachine_noTrace.Matcher.class);
    
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
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<AppInstanceWithStateMachine_noTrace.Match> getAllMatches(final ApplicationInstance pAppInstance, final StateMachine pStateMachine, final DeploymentApplication pDepApp) {
      return rawStreamAllMatches(new Object[]{pAppInstance, pStateMachine, pDepApp}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<AppInstanceWithStateMachine_noTrace.Match> streamAllMatches(final ApplicationInstance pAppInstance, final StateMachine pStateMachine, final DeploymentApplication pDepApp) {
      return rawStreamAllMatches(new Object[]{pAppInstance, pStateMachine, pDepApp});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<AppInstanceWithStateMachine_noTrace.Match> getOneArbitraryMatch(final ApplicationInstance pAppInstance, final StateMachine pStateMachine, final DeploymentApplication pDepApp) {
      return rawGetOneArbitraryMatch(new Object[]{pAppInstance, pStateMachine, pDepApp});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final ApplicationInstance pAppInstance, final StateMachine pStateMachine, final DeploymentApplication pDepApp) {
      return rawHasMatch(new Object[]{pAppInstance, pStateMachine, pDepApp});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final ApplicationInstance pAppInstance, final StateMachine pStateMachine, final DeploymentApplication pDepApp) {
      return rawCountMatches(new Object[]{pAppInstance, pStateMachine, pDepApp});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final ApplicationInstance pAppInstance, final StateMachine pStateMachine, final DeploymentApplication pDepApp, final Consumer<? super AppInstanceWithStateMachine_noTrace.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pAppInstance, pStateMachine, pDepApp}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public AppInstanceWithStateMachine_noTrace.Match newMatch(final ApplicationInstance pAppInstance, final StateMachine pStateMachine, final DeploymentApplication pDepApp) {
      return AppInstanceWithStateMachine_noTrace.Match.newMatch(pAppInstance, pStateMachine, pDepApp);
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<ApplicationInstance> rawStreamAllValuesOfappInstance(final Object[] parameters) {
      return rawStreamAllValues(POSITION_APPINSTANCE, parameters).map(ApplicationInstance.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationInstance> getAllValuesOfappInstance() {
      return rawStreamAllValuesOfappInstance(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<ApplicationInstance> streamAllValuesOfappInstance() {
      return rawStreamAllValuesOfappInstance(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstance.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<ApplicationInstance> streamAllValuesOfappInstance(final AppInstanceWithStateMachine_noTrace.Match partialMatch) {
      return rawStreamAllValuesOfappInstance(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstance.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<ApplicationInstance> streamAllValuesOfappInstance(final StateMachine pStateMachine, final DeploymentApplication pDepApp) {
      return rawStreamAllValuesOfappInstance(new Object[]{null, pStateMachine, pDepApp});
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationInstance> getAllValuesOfappInstance(final AppInstanceWithStateMachine_noTrace.Match partialMatch) {
      return rawStreamAllValuesOfappInstance(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationInstance> getAllValuesOfappInstance(final StateMachine pStateMachine, final DeploymentApplication pDepApp) {
      return rawStreamAllValuesOfappInstance(new Object[]{null, pStateMachine, pDepApp}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for stateMachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<StateMachine> rawStreamAllValuesOfstateMachine(final Object[] parameters) {
      return rawStreamAllValues(POSITION_STATEMACHINE, parameters).map(StateMachine.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for stateMachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<StateMachine> getAllValuesOfstateMachine() {
      return rawStreamAllValuesOfstateMachine(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for stateMachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<StateMachine> streamAllValuesOfstateMachine() {
      return rawStreamAllValuesOfstateMachine(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for stateMachine.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<StateMachine> streamAllValuesOfstateMachine(final AppInstanceWithStateMachine_noTrace.Match partialMatch) {
      return rawStreamAllValuesOfstateMachine(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for stateMachine.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<StateMachine> streamAllValuesOfstateMachine(final ApplicationInstance pAppInstance, final DeploymentApplication pDepApp) {
      return rawStreamAllValuesOfstateMachine(new Object[]{pAppInstance, null, pDepApp});
    }
    
    /**
     * Retrieve the set of values that occur in matches for stateMachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<StateMachine> getAllValuesOfstateMachine(final AppInstanceWithStateMachine_noTrace.Match partialMatch) {
      return rawStreamAllValuesOfstateMachine(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for stateMachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<StateMachine> getAllValuesOfstateMachine(final ApplicationInstance pAppInstance, final DeploymentApplication pDepApp) {
      return rawStreamAllValuesOfstateMachine(new Object[]{pAppInstance, null, pDepApp}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depApp.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<DeploymentApplication> rawStreamAllValuesOfdepApp(final Object[] parameters) {
      return rawStreamAllValues(POSITION_DEPAPP, parameters).map(DeploymentApplication.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for depApp.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DeploymentApplication> getAllValuesOfdepApp() {
      return rawStreamAllValuesOfdepApp(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depApp.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<DeploymentApplication> streamAllValuesOfdepApp() {
      return rawStreamAllValuesOfdepApp(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depApp.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<DeploymentApplication> streamAllValuesOfdepApp(final AppInstanceWithStateMachine_noTrace.Match partialMatch) {
      return rawStreamAllValuesOfdepApp(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depApp.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<DeploymentApplication> streamAllValuesOfdepApp(final ApplicationInstance pAppInstance, final StateMachine pStateMachine) {
      return rawStreamAllValuesOfdepApp(new Object[]{pAppInstance, pStateMachine, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for depApp.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DeploymentApplication> getAllValuesOfdepApp(final AppInstanceWithStateMachine_noTrace.Match partialMatch) {
      return rawStreamAllValuesOfdepApp(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depApp.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DeploymentApplication> getAllValuesOfdepApp(final ApplicationInstance pAppInstance, final StateMachine pStateMachine) {
      return rawStreamAllValuesOfdepApp(new Object[]{pAppInstance, pStateMachine, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected AppInstanceWithStateMachine_noTrace.Match tupleToMatch(final Tuple t) {
      try {
          return AppInstanceWithStateMachine_noTrace.Match.newMatch((ApplicationInstance) t.get(POSITION_APPINSTANCE), (StateMachine) t.get(POSITION_STATEMACHINE), (DeploymentApplication) t.get(POSITION_DEPAPP));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected AppInstanceWithStateMachine_noTrace.Match arrayToMatch(final Object[] match) {
      try {
          return AppInstanceWithStateMachine_noTrace.Match.newMatch((ApplicationInstance) match[POSITION_APPINSTANCE], (StateMachine) match[POSITION_STATEMACHINE], (DeploymentApplication) match[POSITION_DEPAPP]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected AppInstanceWithStateMachine_noTrace.Match arrayToMatchMutable(final Object[] match) {
      try {
          return AppInstanceWithStateMachine_noTrace.Match.newMutableMatch((ApplicationInstance) match[POSITION_APPINSTANCE], (StateMachine) match[POSITION_STATEMACHINE], (DeploymentApplication) match[POSITION_DEPAPP]);
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
    public static IQuerySpecification<AppInstanceWithStateMachine_noTrace.Matcher> querySpecification() {
      return AppInstanceWithStateMachine_noTrace.instance();
    }
  }
  
  private AppInstanceWithStateMachine_noTrace() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static AppInstanceWithStateMachine_noTrace instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected AppInstanceWithStateMachine_noTrace.Matcher instantiate(final ViatraQueryEngine engine) {
    return AppInstanceWithStateMachine_noTrace.Matcher.on(engine);
  }
  
  @Override
  public AppInstanceWithStateMachine_noTrace.Matcher instantiate() {
    return AppInstanceWithStateMachine_noTrace.Matcher.create();
  }
  
  @Override
  public AppInstanceWithStateMachine_noTrace.Match newEmptyMatch() {
    return AppInstanceWithStateMachine_noTrace.Match.newEmptyMatch();
  }
  
  @Override
  public AppInstanceWithStateMachine_noTrace.Match newMatch(final Object... parameters) {
    return AppInstanceWithStateMachine_noTrace.Match.newMatch((org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance) parameters[0], (org.eclipse.viatra.examples.cps.cyberPhysicalSystem.StateMachine) parameters[1], (org.eclipse.viatra.examples.cps.deployment.DeploymentApplication) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceWithStateMachine_noTrace (visibility: PUBLIC, simpleName: AppInstanceWithStateMachine_noTrace, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceWithStateMachine_noTrace, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceWithStateMachine_noTrace (visibility: PUBLIC, simpleName: AppInstanceWithStateMachine_noTrace, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceWithStateMachine_noTrace, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final AppInstanceWithStateMachine_noTrace INSTANCE = new AppInstanceWithStateMachine_noTrace();
    
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
    private static final AppInstanceWithStateMachine_noTrace.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_appInstance = new PParameter("appInstance", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "ApplicationInstance")), PParameterDirection.INOUT);
    
    private final PParameter parameter_stateMachine = new PParameter("stateMachine", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.StateMachine", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "StateMachine")), PParameterDirection.INOUT);
    
    private final PParameter parameter_depApp = new PParameter("depApp", "org.eclipse.viatra.examples.cps.deployment.DeploymentApplication", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/deployment", "DeploymentApplication")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_appInstance, parameter_stateMachine, parameter_depApp);
    
    private class Embedded_1_CPS2DeploymentTrace_cpsElements extends BaseGeneratedEMFPQuery {
      private final PParameter parameter_p0 = new PParameter("p0", "org.eclipse.viatra.examples.cps.traceability.CPS2DeploymentTrace", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace")), PParameterDirection.INOUT);
      
      private final PParameter parameter_p1 = new PParameter("p1", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Identifiable", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "Identifiable")), PParameterDirection.INOUT);
      
      private final List<PParameter> embeddedParameters = Arrays.asList(parameter_p0, parameter_p1);
      
      public Embedded_1_CPS2DeploymentTrace_cpsElements() {
        super(PVisibility.EMBEDDED);
      }
      
      @Override
      public String getFullyQualifiedName() {
        return GeneratedPQuery.this.getFullyQualifiedName() + "$Embedded_1_CPS2DeploymentTrace_cpsElements";
      }
      
      @Override
      public List<PParameter> getParameters() {
        return embeddedParameters;
      }
      
      @Override
      public Set<PBody> doGetContainedBodies() {
        PBody body = new PBody(this);
        PVariable var_p0 = body.getOrCreateVariableByName("p0");
        PVariable var_p1 = body.getOrCreateVariableByName("p1");
        body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
           new ExportedParameter(body, var_p0, parameter_p0),
           new ExportedParameter(body, var_p1, parameter_p1)
        ));
        //  CPS2DeploymentTrace.cpsElements(_, stateMachine)
        new TypeConstraint(body, Tuples.flatTupleOf(var_p0), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace")));
        PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
        new TypeConstraint(body, Tuples.flatTupleOf(var_p0, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace", "cpsElements")));
        new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "Identifiable")));
        new Equality(body, var__virtual_0_, var_p1);
        return Collections.singleton(body);
      }
    }
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.appInstanceWithStateMachine_noTrace";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("appInstance","stateMachine","depApp");
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
          PVariable var_appInstance = body.getOrCreateVariableByName("appInstance");
          PVariable var_stateMachine = body.getOrCreateVariableByName("stateMachine");
          PVariable var_depApp = body.getOrCreateVariableByName("depApp");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          PVariable var_depHost = body.getOrCreateVariableByName("depHost");
          PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_appInstance), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "ApplicationInstance")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_stateMachine), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "StateMachine")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_depApp), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "DeploymentApplication")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_appInstance, parameter_appInstance),
             new ExportedParameter(body, var_stateMachine, parameter_stateMachine),
             new ExportedParameter(body, var_depApp, parameter_depApp)
          ));
          //     find appInstanceWithStateMachine(_, appInstance, stateMachine)
          new PositivePatternCall(body, Tuples.flatTupleOf(var___0_, var_appInstance, var_stateMachine), AppInstanceWithStateMachine.instance().getInternalQueryRepresentation());
          //     find appInstanceWithDepHost(appInstance, depHost)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_appInstance, var_depHost), AppInstanceWithDepHost.instance().getInternalQueryRepresentation());
          //     DeploymentHost.applications(depHost,depApp)
          new TypeConstraint(body, Tuples.flatTupleOf(var_depHost), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "DeploymentHost")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_depHost, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/deployment", "DeploymentHost", "applications")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "DeploymentApplication")));
          new Equality(body, var__virtual_0_, var_depApp);
          //         neg CPS2DeploymentTrace.cpsElements(_, stateMachine)
          new NegativePatternCall(body, Tuples.flatTupleOf(var___1_, var_stateMachine), new AppInstanceWithStateMachine_noTrace.GeneratedPQuery.Embedded_1_CPS2DeploymentTrace_cpsElements());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
