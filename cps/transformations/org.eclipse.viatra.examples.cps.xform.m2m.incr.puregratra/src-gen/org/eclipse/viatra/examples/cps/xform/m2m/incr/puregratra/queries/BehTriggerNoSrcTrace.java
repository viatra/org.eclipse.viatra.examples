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
import org.eclipse.viatra.examples.cps.deployment.BehaviorTransition;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AlreadyTriggered;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.Cps2depTrace;
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
 *         pattern behTriggerNoSrcTrace(behTrigger : BehaviorTransition, behTarget : BehaviorTransition) {
 *             find alreadyTriggered(behTrigger,behTarget);
 *             neg find cps2depTrace(_, _, _, behTrigger);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtext.xbase.compiler.JvmModelGenerator")
public final class BehTriggerNoSrcTrace extends BaseGeneratedEMFQuerySpecification<BehTriggerNoSrcTrace.Matcher> {
  /**
   * Pattern-specific match representation of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.behTriggerNoSrcTrace pattern,
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
    private BehaviorTransition fBehTrigger;
    
    private BehaviorTransition fBehTarget;
    
    private static List<String> parameterNames = makeImmutableList("behTrigger", "behTarget");
    
    private Match(final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
      this.fBehTrigger = pBehTrigger;
      this.fBehTarget = pBehTarget;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("behTrigger".equals(parameterName)) return this.fBehTrigger;
      if ("behTarget".equals(parameterName)) return this.fBehTarget;
      return null;
    }
    
    public BehaviorTransition getBehTrigger() {
      return this.fBehTrigger;
    }
    
    public BehaviorTransition getBehTarget() {
      return this.fBehTarget;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("behTrigger".equals(parameterName) ) {
          this.fBehTrigger = (BehaviorTransition) newValue;
          return true;
      }
      if ("behTarget".equals(parameterName) ) {
          this.fBehTarget = (BehaviorTransition) newValue;
          return true;
      }
      return false;
    }
    
    public void setBehTrigger(final BehaviorTransition pBehTrigger) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fBehTrigger = pBehTrigger;
    }
    
    public void setBehTarget(final BehaviorTransition pBehTarget) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fBehTarget = pBehTarget;
    }
    
    @Override
    public String patternName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.behTriggerNoSrcTrace";
    }
    
    @Override
    public List<String> parameterNames() {
      return BehTriggerNoSrcTrace.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fBehTrigger, fBehTarget};
    }
    
    @Override
    public BehTriggerNoSrcTrace.Match toImmutable() {
      return isMutable() ? newMatch(fBehTrigger, fBehTarget) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"behTrigger\"=" + prettyPrintValue(fBehTrigger) + ", ");
      result.append("\"behTarget\"=" + prettyPrintValue(fBehTarget));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fBehTrigger, fBehTarget);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof BehTriggerNoSrcTrace.Match)) {
          BehTriggerNoSrcTrace.Match other = (BehTriggerNoSrcTrace.Match) obj;
          return Objects.equals(fBehTrigger, other.fBehTrigger) && Objects.equals(fBehTarget, other.fBehTarget);
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
    public BehTriggerNoSrcTrace specification() {
      return BehTriggerNoSrcTrace.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static BehTriggerNoSrcTrace.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pBehTrigger the fixed value of pattern parameter behTrigger, or null if not bound.
     * @param pBehTarget the fixed value of pattern parameter behTarget, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static BehTriggerNoSrcTrace.Match newMutableMatch(final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
      return new Mutable(pBehTrigger, pBehTarget);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pBehTrigger the fixed value of pattern parameter behTrigger, or null if not bound.
     * @param pBehTarget the fixed value of pattern parameter behTarget, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static BehTriggerNoSrcTrace.Match newMatch(final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
      return new Immutable(pBehTrigger, pBehTarget);
    }
    
    private static final class Mutable extends BehTriggerNoSrcTrace.Match {
      Mutable(final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
        super(pBehTrigger, pBehTarget);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends BehTriggerNoSrcTrace.Match {
      Immutable(final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
        super(pBehTrigger, pBehTarget);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.behTriggerNoSrcTrace pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern behTriggerNoSrcTrace(behTrigger : BehaviorTransition, behTarget : BehaviorTransition) {
   *     find alreadyTriggered(behTrigger,behTarget);
   *     neg find cps2depTrace(_, _, _, behTrigger);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see BehTriggerNoSrcTrace
   * 
   */
  public static class Matcher extends BaseMatcher<BehTriggerNoSrcTrace.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static BehTriggerNoSrcTrace.Matcher on(final ViatraQueryEngine engine) {
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
    public static BehTriggerNoSrcTrace.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_BEHTRIGGER = 0;
    
    private static final int POSITION_BEHTARGET = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(BehTriggerNoSrcTrace.Matcher.class);
    
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
     * @param pBehTrigger the fixed value of pattern parameter behTrigger, or null if not bound.
     * @param pBehTarget the fixed value of pattern parameter behTarget, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<BehTriggerNoSrcTrace.Match> getAllMatches(final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
      return rawStreamAllMatches(new Object[]{pBehTrigger, pBehTarget}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pBehTrigger the fixed value of pattern parameter behTrigger, or null if not bound.
     * @param pBehTarget the fixed value of pattern parameter behTarget, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<BehTriggerNoSrcTrace.Match> streamAllMatches(final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
      return rawStreamAllMatches(new Object[]{pBehTrigger, pBehTarget});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pBehTrigger the fixed value of pattern parameter behTrigger, or null if not bound.
     * @param pBehTarget the fixed value of pattern parameter behTarget, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<BehTriggerNoSrcTrace.Match> getOneArbitraryMatch(final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
      return rawGetOneArbitraryMatch(new Object[]{pBehTrigger, pBehTarget});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pBehTrigger the fixed value of pattern parameter behTrigger, or null if not bound.
     * @param pBehTarget the fixed value of pattern parameter behTarget, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
      return rawHasMatch(new Object[]{pBehTrigger, pBehTarget});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pBehTrigger the fixed value of pattern parameter behTrigger, or null if not bound.
     * @param pBehTarget the fixed value of pattern parameter behTarget, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
      return rawCountMatches(new Object[]{pBehTrigger, pBehTarget});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pBehTrigger the fixed value of pattern parameter behTrigger, or null if not bound.
     * @param pBehTarget the fixed value of pattern parameter behTarget, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget, final Consumer<? super BehTriggerNoSrcTrace.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pBehTrigger, pBehTarget}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pBehTrigger the fixed value of pattern parameter behTrigger, or null if not bound.
     * @param pBehTarget the fixed value of pattern parameter behTarget, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public BehTriggerNoSrcTrace.Match newMatch(final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
      return BehTriggerNoSrcTrace.Match.newMatch(pBehTrigger, pBehTarget);
    }
    
    /**
     * Retrieve the set of values that occur in matches for behTrigger.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<BehaviorTransition> rawStreamAllValuesOfbehTrigger(final Object[] parameters) {
      return rawStreamAllValues(POSITION_BEHTRIGGER, parameters).map(BehaviorTransition.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for behTrigger.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<BehaviorTransition> getAllValuesOfbehTrigger() {
      return rawStreamAllValuesOfbehTrigger(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for behTrigger.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<BehaviorTransition> streamAllValuesOfbehTrigger() {
      return rawStreamAllValuesOfbehTrigger(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for behTrigger.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<BehaviorTransition> streamAllValuesOfbehTrigger(final BehTriggerNoSrcTrace.Match partialMatch) {
      return rawStreamAllValuesOfbehTrigger(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for behTrigger.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<BehaviorTransition> streamAllValuesOfbehTrigger(final BehaviorTransition pBehTarget) {
      return rawStreamAllValuesOfbehTrigger(new Object[]{null, pBehTarget});
    }
    
    /**
     * Retrieve the set of values that occur in matches for behTrigger.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<BehaviorTransition> getAllValuesOfbehTrigger(final BehTriggerNoSrcTrace.Match partialMatch) {
      return rawStreamAllValuesOfbehTrigger(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for behTrigger.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<BehaviorTransition> getAllValuesOfbehTrigger(final BehaviorTransition pBehTarget) {
      return rawStreamAllValuesOfbehTrigger(new Object[]{null, pBehTarget}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for behTarget.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<BehaviorTransition> rawStreamAllValuesOfbehTarget(final Object[] parameters) {
      return rawStreamAllValues(POSITION_BEHTARGET, parameters).map(BehaviorTransition.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for behTarget.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<BehaviorTransition> getAllValuesOfbehTarget() {
      return rawStreamAllValuesOfbehTarget(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for behTarget.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<BehaviorTransition> streamAllValuesOfbehTarget() {
      return rawStreamAllValuesOfbehTarget(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for behTarget.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<BehaviorTransition> streamAllValuesOfbehTarget(final BehTriggerNoSrcTrace.Match partialMatch) {
      return rawStreamAllValuesOfbehTarget(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for behTarget.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<BehaviorTransition> streamAllValuesOfbehTarget(final BehaviorTransition pBehTrigger) {
      return rawStreamAllValuesOfbehTarget(new Object[]{pBehTrigger, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for behTarget.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<BehaviorTransition> getAllValuesOfbehTarget(final BehTriggerNoSrcTrace.Match partialMatch) {
      return rawStreamAllValuesOfbehTarget(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for behTarget.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<BehaviorTransition> getAllValuesOfbehTarget(final BehaviorTransition pBehTrigger) {
      return rawStreamAllValuesOfbehTarget(new Object[]{pBehTrigger, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected BehTriggerNoSrcTrace.Match tupleToMatch(final Tuple t) {
      try {
          return BehTriggerNoSrcTrace.Match.newMatch((BehaviorTransition) t.get(POSITION_BEHTRIGGER), (BehaviorTransition) t.get(POSITION_BEHTARGET));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected BehTriggerNoSrcTrace.Match arrayToMatch(final Object[] match) {
      try {
          return BehTriggerNoSrcTrace.Match.newMatch((BehaviorTransition) match[POSITION_BEHTRIGGER], (BehaviorTransition) match[POSITION_BEHTARGET]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected BehTriggerNoSrcTrace.Match arrayToMatchMutable(final Object[] match) {
      try {
          return BehTriggerNoSrcTrace.Match.newMutableMatch((BehaviorTransition) match[POSITION_BEHTRIGGER], (BehaviorTransition) match[POSITION_BEHTARGET]);
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
    public static IQuerySpecification<BehTriggerNoSrcTrace.Matcher> querySpecification() {
      return BehTriggerNoSrcTrace.instance();
    }
  }
  
  private BehTriggerNoSrcTrace() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static BehTriggerNoSrcTrace instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected BehTriggerNoSrcTrace.Matcher instantiate(final ViatraQueryEngine engine) {
    return BehTriggerNoSrcTrace.Matcher.on(engine);
  }
  
  @Override
  public BehTriggerNoSrcTrace.Matcher instantiate() {
    return BehTriggerNoSrcTrace.Matcher.create();
  }
  
  @Override
  public BehTriggerNoSrcTrace.Match newEmptyMatch() {
    return BehTriggerNoSrcTrace.Match.newEmptyMatch();
  }
  
  @Override
  public BehTriggerNoSrcTrace.Match newMatch(final Object... parameters) {
    return BehTriggerNoSrcTrace.Match.newMatch((org.eclipse.viatra.examples.cps.deployment.BehaviorTransition) parameters[0], (org.eclipse.viatra.examples.cps.deployment.BehaviorTransition) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.BehTriggerNoSrcTrace (visibility: PUBLIC, simpleName: BehTriggerNoSrcTrace, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.BehTriggerNoSrcTrace, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.BehTriggerNoSrcTrace (visibility: PUBLIC, simpleName: BehTriggerNoSrcTrace, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.BehTriggerNoSrcTrace, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final BehTriggerNoSrcTrace INSTANCE = new BehTriggerNoSrcTrace();
    
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
    private static final BehTriggerNoSrcTrace.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_behTrigger = new PParameter("behTrigger", "org.eclipse.viatra.examples.cps.deployment.BehaviorTransition", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/deployment", "BehaviorTransition")), PParameterDirection.INOUT);
    
    private final PParameter parameter_behTarget = new PParameter("behTarget", "org.eclipse.viatra.examples.cps.deployment.BehaviorTransition", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/deployment", "BehaviorTransition")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_behTrigger, parameter_behTarget);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.behTriggerNoSrcTrace";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("behTrigger","behTarget");
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
          PVariable var_behTrigger = body.getOrCreateVariableByName("behTrigger");
          PVariable var_behTarget = body.getOrCreateVariableByName("behTarget");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
          PVariable var___2_ = body.getOrCreateVariableByName("_<2>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_behTrigger), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "BehaviorTransition")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_behTarget), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "BehaviorTransition")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_behTrigger, parameter_behTrigger),
             new ExportedParameter(body, var_behTarget, parameter_behTarget)
          ));
          //     find alreadyTriggered(behTrigger,behTarget)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_behTrigger, var_behTarget), AlreadyTriggered.instance().getInternalQueryRepresentation());
          //     neg find cps2depTrace(_, _, _, behTrigger)
          new NegativePatternCall(body, Tuples.flatTupleOf(var___0_, var___1_, var___2_, var_behTrigger), Cps2depTrace.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
