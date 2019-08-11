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
import org.eclipse.viatra.examples.cps.deployment.BehaviorState;
import org.eclipse.viatra.examples.cps.traceability.CPS2DeploymentTrace;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.Cps2depTrace;
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
 *         pattern stateDel(behState : BehaviorState, trace : CPS2DeploymentTrace) {
 *             CPS2DeploymentTrace.deploymentElements(trace,behState);
 *             neg find cps2depTrace(_, trace, _, behState);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtext.xbase.compiler.JvmModelGenerator")
public final class StateDel extends BaseGeneratedEMFQuerySpecification<StateDel.Matcher> {
  /**
   * Pattern-specific match representation of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.stateDel pattern,
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
    private BehaviorState fBehState;
    
    private CPS2DeploymentTrace fTrace;
    
    private static List<String> parameterNames = makeImmutableList("behState", "trace");
    
    private Match(final BehaviorState pBehState, final CPS2DeploymentTrace pTrace) {
      this.fBehState = pBehState;
      this.fTrace = pTrace;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("behState".equals(parameterName)) return this.fBehState;
      if ("trace".equals(parameterName)) return this.fTrace;
      return null;
    }
    
    public BehaviorState getBehState() {
      return this.fBehState;
    }
    
    public CPS2DeploymentTrace getTrace() {
      return this.fTrace;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("behState".equals(parameterName) ) {
          this.fBehState = (BehaviorState) newValue;
          return true;
      }
      if ("trace".equals(parameterName) ) {
          this.fTrace = (CPS2DeploymentTrace) newValue;
          return true;
      }
      return false;
    }
    
    public void setBehState(final BehaviorState pBehState) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fBehState = pBehState;
    }
    
    public void setTrace(final CPS2DeploymentTrace pTrace) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTrace = pTrace;
    }
    
    @Override
    public String patternName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.stateDel";
    }
    
    @Override
    public List<String> parameterNames() {
      return StateDel.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fBehState, fTrace};
    }
    
    @Override
    public StateDel.Match toImmutable() {
      return isMutable() ? newMatch(fBehState, fTrace) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"behState\"=" + prettyPrintValue(fBehState) + ", ");
      result.append("\"trace\"=" + prettyPrintValue(fTrace));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fBehState, fTrace);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof StateDel.Match)) {
          StateDel.Match other = (StateDel.Match) obj;
          return Objects.equals(fBehState, other.fBehState) && Objects.equals(fTrace, other.fTrace);
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
    public StateDel specification() {
      return StateDel.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static StateDel.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pBehState the fixed value of pattern parameter behState, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static StateDel.Match newMutableMatch(final BehaviorState pBehState, final CPS2DeploymentTrace pTrace) {
      return new Mutable(pBehState, pTrace);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pBehState the fixed value of pattern parameter behState, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static StateDel.Match newMatch(final BehaviorState pBehState, final CPS2DeploymentTrace pTrace) {
      return new Immutable(pBehState, pTrace);
    }
    
    private static final class Mutable extends StateDel.Match {
      Mutable(final BehaviorState pBehState, final CPS2DeploymentTrace pTrace) {
        super(pBehState, pTrace);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends StateDel.Match {
      Immutable(final BehaviorState pBehState, final CPS2DeploymentTrace pTrace) {
        super(pBehState, pTrace);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.stateDel pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern stateDel(behState : BehaviorState, trace : CPS2DeploymentTrace) {
   *     CPS2DeploymentTrace.deploymentElements(trace,behState);
   *     neg find cps2depTrace(_, trace, _, behState);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see StateDel
   * 
   */
  public static class Matcher extends BaseMatcher<StateDel.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static StateDel.Matcher on(final ViatraQueryEngine engine) {
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
    public static StateDel.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_BEHSTATE = 0;
    
    private static final int POSITION_TRACE = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(StateDel.Matcher.class);
    
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
     * @param pBehState the fixed value of pattern parameter behState, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<StateDel.Match> getAllMatches(final BehaviorState pBehState, final CPS2DeploymentTrace pTrace) {
      return rawStreamAllMatches(new Object[]{pBehState, pTrace}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pBehState the fixed value of pattern parameter behState, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<StateDel.Match> streamAllMatches(final BehaviorState pBehState, final CPS2DeploymentTrace pTrace) {
      return rawStreamAllMatches(new Object[]{pBehState, pTrace});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pBehState the fixed value of pattern parameter behState, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<StateDel.Match> getOneArbitraryMatch(final BehaviorState pBehState, final CPS2DeploymentTrace pTrace) {
      return rawGetOneArbitraryMatch(new Object[]{pBehState, pTrace});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pBehState the fixed value of pattern parameter behState, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final BehaviorState pBehState, final CPS2DeploymentTrace pTrace) {
      return rawHasMatch(new Object[]{pBehState, pTrace});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pBehState the fixed value of pattern parameter behState, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final BehaviorState pBehState, final CPS2DeploymentTrace pTrace) {
      return rawCountMatches(new Object[]{pBehState, pTrace});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pBehState the fixed value of pattern parameter behState, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final BehaviorState pBehState, final CPS2DeploymentTrace pTrace, final Consumer<? super StateDel.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pBehState, pTrace}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pBehState the fixed value of pattern parameter behState, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public StateDel.Match newMatch(final BehaviorState pBehState, final CPS2DeploymentTrace pTrace) {
      return StateDel.Match.newMatch(pBehState, pTrace);
    }
    
    /**
     * Retrieve the set of values that occur in matches for behState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<BehaviorState> rawStreamAllValuesOfbehState(final Object[] parameters) {
      return rawStreamAllValues(POSITION_BEHSTATE, parameters).map(BehaviorState.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for behState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<BehaviorState> getAllValuesOfbehState() {
      return rawStreamAllValuesOfbehState(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for behState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<BehaviorState> streamAllValuesOfbehState() {
      return rawStreamAllValuesOfbehState(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for behState.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<BehaviorState> streamAllValuesOfbehState(final StateDel.Match partialMatch) {
      return rawStreamAllValuesOfbehState(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for behState.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<BehaviorState> streamAllValuesOfbehState(final CPS2DeploymentTrace pTrace) {
      return rawStreamAllValuesOfbehState(new Object[]{null, pTrace});
    }
    
    /**
     * Retrieve the set of values that occur in matches for behState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<BehaviorState> getAllValuesOfbehState(final StateDel.Match partialMatch) {
      return rawStreamAllValuesOfbehState(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for behState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<BehaviorState> getAllValuesOfbehState(final CPS2DeploymentTrace pTrace) {
      return rawStreamAllValuesOfbehState(new Object[]{null, pTrace}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<CPS2DeploymentTrace> rawStreamAllValuesOftrace(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TRACE, parameters).map(CPS2DeploymentTrace.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<CPS2DeploymentTrace> getAllValuesOftrace() {
      return rawStreamAllValuesOftrace(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<CPS2DeploymentTrace> streamAllValuesOftrace() {
      return rawStreamAllValuesOftrace(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<CPS2DeploymentTrace> streamAllValuesOftrace(final StateDel.Match partialMatch) {
      return rawStreamAllValuesOftrace(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<CPS2DeploymentTrace> streamAllValuesOftrace(final BehaviorState pBehState) {
      return rawStreamAllValuesOftrace(new Object[]{pBehState, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<CPS2DeploymentTrace> getAllValuesOftrace(final StateDel.Match partialMatch) {
      return rawStreamAllValuesOftrace(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<CPS2DeploymentTrace> getAllValuesOftrace(final BehaviorState pBehState) {
      return rawStreamAllValuesOftrace(new Object[]{pBehState, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected StateDel.Match tupleToMatch(final Tuple t) {
      try {
          return StateDel.Match.newMatch((BehaviorState) t.get(POSITION_BEHSTATE), (CPS2DeploymentTrace) t.get(POSITION_TRACE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected StateDel.Match arrayToMatch(final Object[] match) {
      try {
          return StateDel.Match.newMatch((BehaviorState) match[POSITION_BEHSTATE], (CPS2DeploymentTrace) match[POSITION_TRACE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected StateDel.Match arrayToMatchMutable(final Object[] match) {
      try {
          return StateDel.Match.newMutableMatch((BehaviorState) match[POSITION_BEHSTATE], (CPS2DeploymentTrace) match[POSITION_TRACE]);
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
    public static IQuerySpecification<StateDel.Matcher> querySpecification() {
      return StateDel.instance();
    }
  }
  
  private StateDel() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static StateDel instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected StateDel.Matcher instantiate(final ViatraQueryEngine engine) {
    return StateDel.Matcher.on(engine);
  }
  
  @Override
  public StateDel.Matcher instantiate() {
    return StateDel.Matcher.create();
  }
  
  @Override
  public StateDel.Match newEmptyMatch() {
    return StateDel.Match.newEmptyMatch();
  }
  
  @Override
  public StateDel.Match newMatch(final Object... parameters) {
    return StateDel.Match.newMatch((org.eclipse.viatra.examples.cps.deployment.BehaviorState) parameters[0], (org.eclipse.viatra.examples.cps.traceability.CPS2DeploymentTrace) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.StateDel (visibility: PUBLIC, simpleName: StateDel, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.StateDel, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.StateDel (visibility: PUBLIC, simpleName: StateDel, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.StateDel, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final StateDel INSTANCE = new StateDel();
    
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
    private static final StateDel.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_behState = new PParameter("behState", "org.eclipse.viatra.examples.cps.deployment.BehaviorState", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/deployment", "BehaviorState")), PParameterDirection.INOUT);
    
    private final PParameter parameter_trace = new PParameter("trace", "org.eclipse.viatra.examples.cps.traceability.CPS2DeploymentTrace", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_behState, parameter_trace);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.stateDel";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("behState","trace");
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
          PVariable var_behState = body.getOrCreateVariableByName("behState");
          PVariable var_trace = body.getOrCreateVariableByName("trace");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_behState), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "BehaviorState")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_behState, parameter_behState),
             new ExportedParameter(body, var_trace, parameter_trace)
          ));
          //     CPS2DeploymentTrace.deploymentElements(trace,behState)
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace", "deploymentElements")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "DeploymentElement")));
          new Equality(body, var__virtual_0_, var_behState);
          //     neg find cps2depTrace(_, trace, _, behState)
          new NegativePatternCall(body, Tuples.flatTupleOf(var___0_, var_trace, var___1_, var_behState), Cps2depTrace.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
