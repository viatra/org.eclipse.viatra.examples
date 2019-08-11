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
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition;
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
 *         pattern transition_withTrace(srcDep : BehaviorState, transition : Transition, trgDep : BehaviorState, trace : CPS2DeploymentTrace) {
 *             Transition.targetState(transition,trg);
 *             State.outgoingTransitions(src,transition);
 *             
 *             find cps2depTrace(_, _, src, srcDep);
 *             find cps2depTrace(_, _, trg, trgDep);
 *             
 *             find cps2depTrace(_, trace, transition, _);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtext.xbase.compiler.JvmModelGenerator")
public final class Transition_withTrace extends BaseGeneratedEMFQuerySpecification<Transition_withTrace.Matcher> {
  /**
   * Pattern-specific match representation of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.transition_withTrace pattern,
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
    private BehaviorState fSrcDep;
    
    private Transition fTransition;
    
    private BehaviorState fTrgDep;
    
    private CPS2DeploymentTrace fTrace;
    
    private static List<String> parameterNames = makeImmutableList("srcDep", "transition", "trgDep", "trace");
    
    private Match(final BehaviorState pSrcDep, final Transition pTransition, final BehaviorState pTrgDep, final CPS2DeploymentTrace pTrace) {
      this.fSrcDep = pSrcDep;
      this.fTransition = pTransition;
      this.fTrgDep = pTrgDep;
      this.fTrace = pTrace;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("srcDep".equals(parameterName)) return this.fSrcDep;
      if ("transition".equals(parameterName)) return this.fTransition;
      if ("trgDep".equals(parameterName)) return this.fTrgDep;
      if ("trace".equals(parameterName)) return this.fTrace;
      return null;
    }
    
    public BehaviorState getSrcDep() {
      return this.fSrcDep;
    }
    
    public Transition getTransition() {
      return this.fTransition;
    }
    
    public BehaviorState getTrgDep() {
      return this.fTrgDep;
    }
    
    public CPS2DeploymentTrace getTrace() {
      return this.fTrace;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("srcDep".equals(parameterName) ) {
          this.fSrcDep = (BehaviorState) newValue;
          return true;
      }
      if ("transition".equals(parameterName) ) {
          this.fTransition = (Transition) newValue;
          return true;
      }
      if ("trgDep".equals(parameterName) ) {
          this.fTrgDep = (BehaviorState) newValue;
          return true;
      }
      if ("trace".equals(parameterName) ) {
          this.fTrace = (CPS2DeploymentTrace) newValue;
          return true;
      }
      return false;
    }
    
    public void setSrcDep(final BehaviorState pSrcDep) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fSrcDep = pSrcDep;
    }
    
    public void setTransition(final Transition pTransition) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTransition = pTransition;
    }
    
    public void setTrgDep(final BehaviorState pTrgDep) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTrgDep = pTrgDep;
    }
    
    public void setTrace(final CPS2DeploymentTrace pTrace) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTrace = pTrace;
    }
    
    @Override
    public String patternName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.transition_withTrace";
    }
    
    @Override
    public List<String> parameterNames() {
      return Transition_withTrace.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fSrcDep, fTransition, fTrgDep, fTrace};
    }
    
    @Override
    public Transition_withTrace.Match toImmutable() {
      return isMutable() ? newMatch(fSrcDep, fTransition, fTrgDep, fTrace) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"srcDep\"=" + prettyPrintValue(fSrcDep) + ", ");
      result.append("\"transition\"=" + prettyPrintValue(fTransition) + ", ");
      result.append("\"trgDep\"=" + prettyPrintValue(fTrgDep) + ", ");
      result.append("\"trace\"=" + prettyPrintValue(fTrace));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fSrcDep, fTransition, fTrgDep, fTrace);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof Transition_withTrace.Match)) {
          Transition_withTrace.Match other = (Transition_withTrace.Match) obj;
          return Objects.equals(fSrcDep, other.fSrcDep) && Objects.equals(fTransition, other.fTransition) && Objects.equals(fTrgDep, other.fTrgDep) && Objects.equals(fTrace, other.fTrace);
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
    public Transition_withTrace specification() {
      return Transition_withTrace.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static Transition_withTrace.Match newEmptyMatch() {
      return new Mutable(null, null, null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pSrcDep the fixed value of pattern parameter srcDep, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pTrgDep the fixed value of pattern parameter trgDep, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static Transition_withTrace.Match newMutableMatch(final BehaviorState pSrcDep, final Transition pTransition, final BehaviorState pTrgDep, final CPS2DeploymentTrace pTrace) {
      return new Mutable(pSrcDep, pTransition, pTrgDep, pTrace);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSrcDep the fixed value of pattern parameter srcDep, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pTrgDep the fixed value of pattern parameter trgDep, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static Transition_withTrace.Match newMatch(final BehaviorState pSrcDep, final Transition pTransition, final BehaviorState pTrgDep, final CPS2DeploymentTrace pTrace) {
      return new Immutable(pSrcDep, pTransition, pTrgDep, pTrace);
    }
    
    private static final class Mutable extends Transition_withTrace.Match {
      Mutable(final BehaviorState pSrcDep, final Transition pTransition, final BehaviorState pTrgDep, final CPS2DeploymentTrace pTrace) {
        super(pSrcDep, pTransition, pTrgDep, pTrace);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends Transition_withTrace.Match {
      Immutable(final BehaviorState pSrcDep, final Transition pTransition, final BehaviorState pTrgDep, final CPS2DeploymentTrace pTrace) {
        super(pSrcDep, pTransition, pTrgDep, pTrace);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.transition_withTrace pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern transition_withTrace(srcDep : BehaviorState, transition : Transition, trgDep : BehaviorState, trace : CPS2DeploymentTrace) {
   *     Transition.targetState(transition,trg);
   *     State.outgoingTransitions(src,transition);
   *     
   *     find cps2depTrace(_, _, src, srcDep);
   *     find cps2depTrace(_, _, trg, trgDep);
   *     
   *     find cps2depTrace(_, trace, transition, _);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see Transition_withTrace
   * 
   */
  public static class Matcher extends BaseMatcher<Transition_withTrace.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static Transition_withTrace.Matcher on(final ViatraQueryEngine engine) {
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
    public static Transition_withTrace.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_SRCDEP = 0;
    
    private static final int POSITION_TRANSITION = 1;
    
    private static final int POSITION_TRGDEP = 2;
    
    private static final int POSITION_TRACE = 3;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(Transition_withTrace.Matcher.class);
    
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
     * @param pSrcDep the fixed value of pattern parameter srcDep, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pTrgDep the fixed value of pattern parameter trgDep, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<Transition_withTrace.Match> getAllMatches(final BehaviorState pSrcDep, final Transition pTransition, final BehaviorState pTrgDep, final CPS2DeploymentTrace pTrace) {
      return rawStreamAllMatches(new Object[]{pSrcDep, pTransition, pTrgDep, pTrace}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pSrcDep the fixed value of pattern parameter srcDep, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pTrgDep the fixed value of pattern parameter trgDep, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<Transition_withTrace.Match> streamAllMatches(final BehaviorState pSrcDep, final Transition pTransition, final BehaviorState pTrgDep, final CPS2DeploymentTrace pTrace) {
      return rawStreamAllMatches(new Object[]{pSrcDep, pTransition, pTrgDep, pTrace});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSrcDep the fixed value of pattern parameter srcDep, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pTrgDep the fixed value of pattern parameter trgDep, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<Transition_withTrace.Match> getOneArbitraryMatch(final BehaviorState pSrcDep, final Transition pTransition, final BehaviorState pTrgDep, final CPS2DeploymentTrace pTrace) {
      return rawGetOneArbitraryMatch(new Object[]{pSrcDep, pTransition, pTrgDep, pTrace});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pSrcDep the fixed value of pattern parameter srcDep, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pTrgDep the fixed value of pattern parameter trgDep, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final BehaviorState pSrcDep, final Transition pTransition, final BehaviorState pTrgDep, final CPS2DeploymentTrace pTrace) {
      return rawHasMatch(new Object[]{pSrcDep, pTransition, pTrgDep, pTrace});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pSrcDep the fixed value of pattern parameter srcDep, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pTrgDep the fixed value of pattern parameter trgDep, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final BehaviorState pSrcDep, final Transition pTransition, final BehaviorState pTrgDep, final CPS2DeploymentTrace pTrace) {
      return rawCountMatches(new Object[]{pSrcDep, pTransition, pTrgDep, pTrace});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSrcDep the fixed value of pattern parameter srcDep, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pTrgDep the fixed value of pattern parameter trgDep, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final BehaviorState pSrcDep, final Transition pTransition, final BehaviorState pTrgDep, final CPS2DeploymentTrace pTrace, final Consumer<? super Transition_withTrace.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pSrcDep, pTransition, pTrgDep, pTrace}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSrcDep the fixed value of pattern parameter srcDep, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pTrgDep the fixed value of pattern parameter trgDep, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public Transition_withTrace.Match newMatch(final BehaviorState pSrcDep, final Transition pTransition, final BehaviorState pTrgDep, final CPS2DeploymentTrace pTrace) {
      return Transition_withTrace.Match.newMatch(pSrcDep, pTransition, pTrgDep, pTrace);
    }
    
    /**
     * Retrieve the set of values that occur in matches for srcDep.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<BehaviorState> rawStreamAllValuesOfsrcDep(final Object[] parameters) {
      return rawStreamAllValues(POSITION_SRCDEP, parameters).map(BehaviorState.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for srcDep.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<BehaviorState> getAllValuesOfsrcDep() {
      return rawStreamAllValuesOfsrcDep(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for srcDep.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<BehaviorState> streamAllValuesOfsrcDep() {
      return rawStreamAllValuesOfsrcDep(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for srcDep.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<BehaviorState> streamAllValuesOfsrcDep(final Transition_withTrace.Match partialMatch) {
      return rawStreamAllValuesOfsrcDep(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for srcDep.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<BehaviorState> streamAllValuesOfsrcDep(final Transition pTransition, final BehaviorState pTrgDep, final CPS2DeploymentTrace pTrace) {
      return rawStreamAllValuesOfsrcDep(new Object[]{null, pTransition, pTrgDep, pTrace});
    }
    
    /**
     * Retrieve the set of values that occur in matches for srcDep.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<BehaviorState> getAllValuesOfsrcDep(final Transition_withTrace.Match partialMatch) {
      return rawStreamAllValuesOfsrcDep(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for srcDep.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<BehaviorState> getAllValuesOfsrcDep(final Transition pTransition, final BehaviorState pTrgDep, final CPS2DeploymentTrace pTrace) {
      return rawStreamAllValuesOfsrcDep(new Object[]{null, pTransition, pTrgDep, pTrace}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Transition> rawStreamAllValuesOftransition(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TRANSITION, parameters).map(Transition.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOftransition() {
      return rawStreamAllValuesOftransition(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Transition> streamAllValuesOftransition() {
      return rawStreamAllValuesOftransition(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Transition> streamAllValuesOftransition(final Transition_withTrace.Match partialMatch) {
      return rawStreamAllValuesOftransition(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Transition> streamAllValuesOftransition(final BehaviorState pSrcDep, final BehaviorState pTrgDep, final CPS2DeploymentTrace pTrace) {
      return rawStreamAllValuesOftransition(new Object[]{pSrcDep, null, pTrgDep, pTrace});
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOftransition(final Transition_withTrace.Match partialMatch) {
      return rawStreamAllValuesOftransition(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOftransition(final BehaviorState pSrcDep, final BehaviorState pTrgDep, final CPS2DeploymentTrace pTrace) {
      return rawStreamAllValuesOftransition(new Object[]{pSrcDep, null, pTrgDep, pTrace}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trgDep.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<BehaviorState> rawStreamAllValuesOftrgDep(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TRGDEP, parameters).map(BehaviorState.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for trgDep.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<BehaviorState> getAllValuesOftrgDep() {
      return rawStreamAllValuesOftrgDep(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trgDep.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<BehaviorState> streamAllValuesOftrgDep() {
      return rawStreamAllValuesOftrgDep(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trgDep.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<BehaviorState> streamAllValuesOftrgDep(final Transition_withTrace.Match partialMatch) {
      return rawStreamAllValuesOftrgDep(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trgDep.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<BehaviorState> streamAllValuesOftrgDep(final BehaviorState pSrcDep, final Transition pTransition, final CPS2DeploymentTrace pTrace) {
      return rawStreamAllValuesOftrgDep(new Object[]{pSrcDep, pTransition, null, pTrace});
    }
    
    /**
     * Retrieve the set of values that occur in matches for trgDep.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<BehaviorState> getAllValuesOftrgDep(final Transition_withTrace.Match partialMatch) {
      return rawStreamAllValuesOftrgDep(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trgDep.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<BehaviorState> getAllValuesOftrgDep(final BehaviorState pSrcDep, final Transition pTransition, final CPS2DeploymentTrace pTrace) {
      return rawStreamAllValuesOftrgDep(new Object[]{pSrcDep, pTransition, null, pTrace}).collect(Collectors.toSet());
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
    public Stream<CPS2DeploymentTrace> streamAllValuesOftrace(final Transition_withTrace.Match partialMatch) {
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
    public Stream<CPS2DeploymentTrace> streamAllValuesOftrace(final BehaviorState pSrcDep, final Transition pTransition, final BehaviorState pTrgDep) {
      return rawStreamAllValuesOftrace(new Object[]{pSrcDep, pTransition, pTrgDep, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<CPS2DeploymentTrace> getAllValuesOftrace(final Transition_withTrace.Match partialMatch) {
      return rawStreamAllValuesOftrace(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<CPS2DeploymentTrace> getAllValuesOftrace(final BehaviorState pSrcDep, final Transition pTransition, final BehaviorState pTrgDep) {
      return rawStreamAllValuesOftrace(new Object[]{pSrcDep, pTransition, pTrgDep, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected Transition_withTrace.Match tupleToMatch(final Tuple t) {
      try {
          return Transition_withTrace.Match.newMatch((BehaviorState) t.get(POSITION_SRCDEP), (Transition) t.get(POSITION_TRANSITION), (BehaviorState) t.get(POSITION_TRGDEP), (CPS2DeploymentTrace) t.get(POSITION_TRACE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected Transition_withTrace.Match arrayToMatch(final Object[] match) {
      try {
          return Transition_withTrace.Match.newMatch((BehaviorState) match[POSITION_SRCDEP], (Transition) match[POSITION_TRANSITION], (BehaviorState) match[POSITION_TRGDEP], (CPS2DeploymentTrace) match[POSITION_TRACE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected Transition_withTrace.Match arrayToMatchMutable(final Object[] match) {
      try {
          return Transition_withTrace.Match.newMutableMatch((BehaviorState) match[POSITION_SRCDEP], (Transition) match[POSITION_TRANSITION], (BehaviorState) match[POSITION_TRGDEP], (CPS2DeploymentTrace) match[POSITION_TRACE]);
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
    public static IQuerySpecification<Transition_withTrace.Matcher> querySpecification() {
      return Transition_withTrace.instance();
    }
  }
  
  private Transition_withTrace() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static Transition_withTrace instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected Transition_withTrace.Matcher instantiate(final ViatraQueryEngine engine) {
    return Transition_withTrace.Matcher.on(engine);
  }
  
  @Override
  public Transition_withTrace.Matcher instantiate() {
    return Transition_withTrace.Matcher.create();
  }
  
  @Override
  public Transition_withTrace.Match newEmptyMatch() {
    return Transition_withTrace.Match.newEmptyMatch();
  }
  
  @Override
  public Transition_withTrace.Match newMatch(final Object... parameters) {
    return Transition_withTrace.Match.newMatch((org.eclipse.viatra.examples.cps.deployment.BehaviorState) parameters[0], (org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition) parameters[1], (org.eclipse.viatra.examples.cps.deployment.BehaviorState) parameters[2], (org.eclipse.viatra.examples.cps.traceability.CPS2DeploymentTrace) parameters[3]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.Transition_withTrace (visibility: PUBLIC, simpleName: Transition_withTrace, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.Transition_withTrace, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.Transition_withTrace (visibility: PUBLIC, simpleName: Transition_withTrace, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.Transition_withTrace, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final Transition_withTrace INSTANCE = new Transition_withTrace();
    
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
    private static final Transition_withTrace.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_srcDep = new PParameter("srcDep", "org.eclipse.viatra.examples.cps.deployment.BehaviorState", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/deployment", "BehaviorState")), PParameterDirection.INOUT);
    
    private final PParameter parameter_transition = new PParameter("transition", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "Transition")), PParameterDirection.INOUT);
    
    private final PParameter parameter_trgDep = new PParameter("trgDep", "org.eclipse.viatra.examples.cps.deployment.BehaviorState", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/deployment", "BehaviorState")), PParameterDirection.INOUT);
    
    private final PParameter parameter_trace = new PParameter("trace", "org.eclipse.viatra.examples.cps.traceability.CPS2DeploymentTrace", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_srcDep, parameter_transition, parameter_trgDep, parameter_trace);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.transition_withTrace";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("srcDep","transition","trgDep","trace");
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
          PVariable var_srcDep = body.getOrCreateVariableByName("srcDep");
          PVariable var_transition = body.getOrCreateVariableByName("transition");
          PVariable var_trgDep = body.getOrCreateVariableByName("trgDep");
          PVariable var_trace = body.getOrCreateVariableByName("trace");
          PVariable var_trg = body.getOrCreateVariableByName("trg");
          PVariable var_src = body.getOrCreateVariableByName("src");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
          PVariable var___2_ = body.getOrCreateVariableByName("_<2>");
          PVariable var___3_ = body.getOrCreateVariableByName("_<3>");
          PVariable var___4_ = body.getOrCreateVariableByName("_<4>");
          PVariable var___5_ = body.getOrCreateVariableByName("_<5>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_srcDep), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "BehaviorState")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "Transition")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_trgDep), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "BehaviorState")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_srcDep, parameter_srcDep),
             new ExportedParameter(body, var_transition, parameter_transition),
             new ExportedParameter(body, var_trgDep, parameter_trgDep),
             new ExportedParameter(body, var_trace, parameter_trace)
          ));
          //     Transition.targetState(transition,trg)
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "Transition")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/cps", "Transition", "targetState")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "State")));
          new Equality(body, var__virtual_0_, var_trg);
          //     State.outgoingTransitions(src,transition)
          new TypeConstraint(body, Tuples.flatTupleOf(var_src), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "State")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_src, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/cps", "State", "outgoingTransitions")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "Transition")));
          new Equality(body, var__virtual_1_, var_transition);
          //         find cps2depTrace(_, _, src, srcDep)
          new PositivePatternCall(body, Tuples.flatTupleOf(var___0_, var___1_, var_src, var_srcDep), Cps2depTrace.instance().getInternalQueryRepresentation());
          //     find cps2depTrace(_, _, trg, trgDep)
          new PositivePatternCall(body, Tuples.flatTupleOf(var___2_, var___3_, var_trg, var_trgDep), Cps2depTrace.instance().getInternalQueryRepresentation());
          //         find cps2depTrace(_, trace, transition, _)
          new PositivePatternCall(body, Tuples.flatTupleOf(var___4_, var_trace, var_transition, var___5_), Cps2depTrace.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
