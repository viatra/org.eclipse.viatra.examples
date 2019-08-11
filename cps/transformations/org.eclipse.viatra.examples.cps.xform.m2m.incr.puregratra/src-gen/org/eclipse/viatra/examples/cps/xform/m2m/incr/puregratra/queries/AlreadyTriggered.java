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
 *         //Behavior transition lookup for trigger pairs
 *         
 *         pattern alreadyTriggered(behTrigger : BehaviorTransition, behTarget : BehaviorTransition) {
 *             BehaviorTransition.trigger(behTrigger,behTarget);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtext.xbase.compiler.JvmModelGenerator")
public final class AlreadyTriggered extends BaseGeneratedEMFQuerySpecification<AlreadyTriggered.Matcher> {
  /**
   * Pattern-specific match representation of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.alreadyTriggered pattern,
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
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.alreadyTriggered";
    }
    
    @Override
    public List<String> parameterNames() {
      return AlreadyTriggered.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fBehTrigger, fBehTarget};
    }
    
    @Override
    public AlreadyTriggered.Match toImmutable() {
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
      if ((obj instanceof AlreadyTriggered.Match)) {
          AlreadyTriggered.Match other = (AlreadyTriggered.Match) obj;
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
    public AlreadyTriggered specification() {
      return AlreadyTriggered.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static AlreadyTriggered.Match newEmptyMatch() {
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
    public static AlreadyTriggered.Match newMutableMatch(final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
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
    public static AlreadyTriggered.Match newMatch(final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
      return new Immutable(pBehTrigger, pBehTarget);
    }
    
    private static final class Mutable extends AlreadyTriggered.Match {
      Mutable(final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
        super(pBehTrigger, pBehTarget);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends AlreadyTriggered.Match {
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
   * Generated pattern matcher API of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.alreadyTriggered pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * //Behavior transition lookup for trigger pairs
   * 
   * pattern alreadyTriggered(behTrigger : BehaviorTransition, behTarget : BehaviorTransition) {
   *     BehaviorTransition.trigger(behTrigger,behTarget);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see AlreadyTriggered
   * 
   */
  public static class Matcher extends BaseMatcher<AlreadyTriggered.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static AlreadyTriggered.Matcher on(final ViatraQueryEngine engine) {
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
    public static AlreadyTriggered.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_BEHTRIGGER = 0;
    
    private static final int POSITION_BEHTARGET = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(AlreadyTriggered.Matcher.class);
    
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
    public Collection<AlreadyTriggered.Match> getAllMatches(final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
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
    public Stream<AlreadyTriggered.Match> streamAllMatches(final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
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
    public Optional<AlreadyTriggered.Match> getOneArbitraryMatch(final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
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
    public boolean forOneArbitraryMatch(final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget, final Consumer<? super AlreadyTriggered.Match> processor) {
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
    public AlreadyTriggered.Match newMatch(final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
      return AlreadyTriggered.Match.newMatch(pBehTrigger, pBehTarget);
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
    public Stream<BehaviorTransition> streamAllValuesOfbehTrigger(final AlreadyTriggered.Match partialMatch) {
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
    public Set<BehaviorTransition> getAllValuesOfbehTrigger(final AlreadyTriggered.Match partialMatch) {
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
    public Stream<BehaviorTransition> streamAllValuesOfbehTarget(final AlreadyTriggered.Match partialMatch) {
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
    public Set<BehaviorTransition> getAllValuesOfbehTarget(final AlreadyTriggered.Match partialMatch) {
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
    protected AlreadyTriggered.Match tupleToMatch(final Tuple t) {
      try {
          return AlreadyTriggered.Match.newMatch((BehaviorTransition) t.get(POSITION_BEHTRIGGER), (BehaviorTransition) t.get(POSITION_BEHTARGET));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected AlreadyTriggered.Match arrayToMatch(final Object[] match) {
      try {
          return AlreadyTriggered.Match.newMatch((BehaviorTransition) match[POSITION_BEHTRIGGER], (BehaviorTransition) match[POSITION_BEHTARGET]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected AlreadyTriggered.Match arrayToMatchMutable(final Object[] match) {
      try {
          return AlreadyTriggered.Match.newMutableMatch((BehaviorTransition) match[POSITION_BEHTRIGGER], (BehaviorTransition) match[POSITION_BEHTARGET]);
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
    public static IQuerySpecification<AlreadyTriggered.Matcher> querySpecification() {
      return AlreadyTriggered.instance();
    }
  }
  
  private AlreadyTriggered() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static AlreadyTriggered instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected AlreadyTriggered.Matcher instantiate(final ViatraQueryEngine engine) {
    return AlreadyTriggered.Matcher.on(engine);
  }
  
  @Override
  public AlreadyTriggered.Matcher instantiate() {
    return AlreadyTriggered.Matcher.create();
  }
  
  @Override
  public AlreadyTriggered.Match newEmptyMatch() {
    return AlreadyTriggered.Match.newEmptyMatch();
  }
  
  @Override
  public AlreadyTriggered.Match newMatch(final Object... parameters) {
    return AlreadyTriggered.Match.newMatch((org.eclipse.viatra.examples.cps.deployment.BehaviorTransition) parameters[0], (org.eclipse.viatra.examples.cps.deployment.BehaviorTransition) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AlreadyTriggered (visibility: PUBLIC, simpleName: AlreadyTriggered, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AlreadyTriggered, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AlreadyTriggered (visibility: PUBLIC, simpleName: AlreadyTriggered, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AlreadyTriggered, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final AlreadyTriggered INSTANCE = new AlreadyTriggered();
    
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
    private static final AlreadyTriggered.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_behTrigger = new PParameter("behTrigger", "org.eclipse.viatra.examples.cps.deployment.BehaviorTransition", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/deployment", "BehaviorTransition")), PParameterDirection.INOUT);
    
    private final PParameter parameter_behTarget = new PParameter("behTarget", "org.eclipse.viatra.examples.cps.deployment.BehaviorTransition", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/deployment", "BehaviorTransition")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_behTrigger, parameter_behTarget);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.alreadyTriggered";
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
          new TypeConstraint(body, Tuples.flatTupleOf(var_behTrigger), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "BehaviorTransition")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_behTarget), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "BehaviorTransition")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_behTrigger, parameter_behTrigger),
             new ExportedParameter(body, var_behTarget, parameter_behTarget)
          ));
          //     BehaviorTransition.trigger(behTrigger,behTarget)
          new TypeConstraint(body, Tuples.flatTupleOf(var_behTrigger), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "BehaviorTransition")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_behTrigger, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/deployment", "BehaviorTransition", "trigger")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "BehaviorTransition")));
          new Equality(body, var__virtual_0_, var_behTarget);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
