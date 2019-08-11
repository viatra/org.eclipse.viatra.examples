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
import org.eclipse.viatra.examples.cps.deployment.BehaviorTransition;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AlreadyTriggered;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.Cps2depTrace;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.TriggerPair;
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
 *         pattern behTriggerPair(cpsTrigger : Transition, cpsTarget : Transition,
 *                 behTrigger : BehaviorTransition, behTarget : BehaviorTransition 
 *         ) {
 *            find triggerPair(_,_,_,_,cpsTrigger,cpsTarget);
 *             
 *            find cps2depTrace(_, _, cpsTrigger, behTrigger);
 *            find cps2depTrace(_, _, cpsTarget, behTarget);
 *            
 *            neg find alreadyTriggered(behTrigger,behTarget);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtext.xbase.compiler.JvmModelGenerator")
public final class BehTriggerPair extends BaseGeneratedEMFQuerySpecification<BehTriggerPair.Matcher> {
  /**
   * Pattern-specific match representation of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.behTriggerPair pattern,
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
    private Transition fCpsTrigger;
    
    private Transition fCpsTarget;
    
    private BehaviorTransition fBehTrigger;
    
    private BehaviorTransition fBehTarget;
    
    private static List<String> parameterNames = makeImmutableList("cpsTrigger", "cpsTarget", "behTrigger", "behTarget");
    
    private Match(final Transition pCpsTrigger, final Transition pCpsTarget, final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
      this.fCpsTrigger = pCpsTrigger;
      this.fCpsTarget = pCpsTarget;
      this.fBehTrigger = pBehTrigger;
      this.fBehTarget = pBehTarget;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("cpsTrigger".equals(parameterName)) return this.fCpsTrigger;
      if ("cpsTarget".equals(parameterName)) return this.fCpsTarget;
      if ("behTrigger".equals(parameterName)) return this.fBehTrigger;
      if ("behTarget".equals(parameterName)) return this.fBehTarget;
      return null;
    }
    
    public Transition getCpsTrigger() {
      return this.fCpsTrigger;
    }
    
    public Transition getCpsTarget() {
      return this.fCpsTarget;
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
      if ("cpsTrigger".equals(parameterName) ) {
          this.fCpsTrigger = (Transition) newValue;
          return true;
      }
      if ("cpsTarget".equals(parameterName) ) {
          this.fCpsTarget = (Transition) newValue;
          return true;
      }
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
    
    public void setCpsTrigger(final Transition pCpsTrigger) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fCpsTrigger = pCpsTrigger;
    }
    
    public void setCpsTarget(final Transition pCpsTarget) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fCpsTarget = pCpsTarget;
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
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.behTriggerPair";
    }
    
    @Override
    public List<String> parameterNames() {
      return BehTriggerPair.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fCpsTrigger, fCpsTarget, fBehTrigger, fBehTarget};
    }
    
    @Override
    public BehTriggerPair.Match toImmutable() {
      return isMutable() ? newMatch(fCpsTrigger, fCpsTarget, fBehTrigger, fBehTarget) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"cpsTrigger\"=" + prettyPrintValue(fCpsTrigger) + ", ");
      result.append("\"cpsTarget\"=" + prettyPrintValue(fCpsTarget) + ", ");
      result.append("\"behTrigger\"=" + prettyPrintValue(fBehTrigger) + ", ");
      result.append("\"behTarget\"=" + prettyPrintValue(fBehTarget));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fCpsTrigger, fCpsTarget, fBehTrigger, fBehTarget);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof BehTriggerPair.Match)) {
          BehTriggerPair.Match other = (BehTriggerPair.Match) obj;
          return Objects.equals(fCpsTrigger, other.fCpsTrigger) && Objects.equals(fCpsTarget, other.fCpsTarget) && Objects.equals(fBehTrigger, other.fBehTrigger) && Objects.equals(fBehTarget, other.fBehTarget);
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
    public BehTriggerPair specification() {
      return BehTriggerPair.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static BehTriggerPair.Match newEmptyMatch() {
      return new Mutable(null, null, null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pCpsTrigger the fixed value of pattern parameter cpsTrigger, or null if not bound.
     * @param pCpsTarget the fixed value of pattern parameter cpsTarget, or null if not bound.
     * @param pBehTrigger the fixed value of pattern parameter behTrigger, or null if not bound.
     * @param pBehTarget the fixed value of pattern parameter behTarget, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static BehTriggerPair.Match newMutableMatch(final Transition pCpsTrigger, final Transition pCpsTarget, final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
      return new Mutable(pCpsTrigger, pCpsTarget, pBehTrigger, pBehTarget);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pCpsTrigger the fixed value of pattern parameter cpsTrigger, or null if not bound.
     * @param pCpsTarget the fixed value of pattern parameter cpsTarget, or null if not bound.
     * @param pBehTrigger the fixed value of pattern parameter behTrigger, or null if not bound.
     * @param pBehTarget the fixed value of pattern parameter behTarget, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static BehTriggerPair.Match newMatch(final Transition pCpsTrigger, final Transition pCpsTarget, final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
      return new Immutable(pCpsTrigger, pCpsTarget, pBehTrigger, pBehTarget);
    }
    
    private static final class Mutable extends BehTriggerPair.Match {
      Mutable(final Transition pCpsTrigger, final Transition pCpsTarget, final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
        super(pCpsTrigger, pCpsTarget, pBehTrigger, pBehTarget);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends BehTriggerPair.Match {
      Immutable(final Transition pCpsTrigger, final Transition pCpsTarget, final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
        super(pCpsTrigger, pCpsTarget, pBehTrigger, pBehTarget);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.behTriggerPair pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern behTriggerPair(cpsTrigger : Transition, cpsTarget : Transition,
   *         behTrigger : BehaviorTransition, behTarget : BehaviorTransition 
   * ) {
   *    find triggerPair(_,_,_,_,cpsTrigger,cpsTarget);
   *     
   *    find cps2depTrace(_, _, cpsTrigger, behTrigger);
   *    find cps2depTrace(_, _, cpsTarget, behTarget);
   *    
   *    neg find alreadyTriggered(behTrigger,behTarget);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see BehTriggerPair
   * 
   */
  public static class Matcher extends BaseMatcher<BehTriggerPair.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static BehTriggerPair.Matcher on(final ViatraQueryEngine engine) {
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
    public static BehTriggerPair.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_CPSTRIGGER = 0;
    
    private static final int POSITION_CPSTARGET = 1;
    
    private static final int POSITION_BEHTRIGGER = 2;
    
    private static final int POSITION_BEHTARGET = 3;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(BehTriggerPair.Matcher.class);
    
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
     * @param pCpsTrigger the fixed value of pattern parameter cpsTrigger, or null if not bound.
     * @param pCpsTarget the fixed value of pattern parameter cpsTarget, or null if not bound.
     * @param pBehTrigger the fixed value of pattern parameter behTrigger, or null if not bound.
     * @param pBehTarget the fixed value of pattern parameter behTarget, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<BehTriggerPair.Match> getAllMatches(final Transition pCpsTrigger, final Transition pCpsTarget, final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
      return rawStreamAllMatches(new Object[]{pCpsTrigger, pCpsTarget, pBehTrigger, pBehTarget}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pCpsTrigger the fixed value of pattern parameter cpsTrigger, or null if not bound.
     * @param pCpsTarget the fixed value of pattern parameter cpsTarget, or null if not bound.
     * @param pBehTrigger the fixed value of pattern parameter behTrigger, or null if not bound.
     * @param pBehTarget the fixed value of pattern parameter behTarget, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<BehTriggerPair.Match> streamAllMatches(final Transition pCpsTrigger, final Transition pCpsTarget, final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
      return rawStreamAllMatches(new Object[]{pCpsTrigger, pCpsTarget, pBehTrigger, pBehTarget});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pCpsTrigger the fixed value of pattern parameter cpsTrigger, or null if not bound.
     * @param pCpsTarget the fixed value of pattern parameter cpsTarget, or null if not bound.
     * @param pBehTrigger the fixed value of pattern parameter behTrigger, or null if not bound.
     * @param pBehTarget the fixed value of pattern parameter behTarget, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<BehTriggerPair.Match> getOneArbitraryMatch(final Transition pCpsTrigger, final Transition pCpsTarget, final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
      return rawGetOneArbitraryMatch(new Object[]{pCpsTrigger, pCpsTarget, pBehTrigger, pBehTarget});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pCpsTrigger the fixed value of pattern parameter cpsTrigger, or null if not bound.
     * @param pCpsTarget the fixed value of pattern parameter cpsTarget, or null if not bound.
     * @param pBehTrigger the fixed value of pattern parameter behTrigger, or null if not bound.
     * @param pBehTarget the fixed value of pattern parameter behTarget, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Transition pCpsTrigger, final Transition pCpsTarget, final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
      return rawHasMatch(new Object[]{pCpsTrigger, pCpsTarget, pBehTrigger, pBehTarget});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pCpsTrigger the fixed value of pattern parameter cpsTrigger, or null if not bound.
     * @param pCpsTarget the fixed value of pattern parameter cpsTarget, or null if not bound.
     * @param pBehTrigger the fixed value of pattern parameter behTrigger, or null if not bound.
     * @param pBehTarget the fixed value of pattern parameter behTarget, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Transition pCpsTrigger, final Transition pCpsTarget, final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
      return rawCountMatches(new Object[]{pCpsTrigger, pCpsTarget, pBehTrigger, pBehTarget});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pCpsTrigger the fixed value of pattern parameter cpsTrigger, or null if not bound.
     * @param pCpsTarget the fixed value of pattern parameter cpsTarget, or null if not bound.
     * @param pBehTrigger the fixed value of pattern parameter behTrigger, or null if not bound.
     * @param pBehTarget the fixed value of pattern parameter behTarget, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Transition pCpsTrigger, final Transition pCpsTarget, final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget, final Consumer<? super BehTriggerPair.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pCpsTrigger, pCpsTarget, pBehTrigger, pBehTarget}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pCpsTrigger the fixed value of pattern parameter cpsTrigger, or null if not bound.
     * @param pCpsTarget the fixed value of pattern parameter cpsTarget, or null if not bound.
     * @param pBehTrigger the fixed value of pattern parameter behTrigger, or null if not bound.
     * @param pBehTarget the fixed value of pattern parameter behTarget, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public BehTriggerPair.Match newMatch(final Transition pCpsTrigger, final Transition pCpsTarget, final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
      return BehTriggerPair.Match.newMatch(pCpsTrigger, pCpsTarget, pBehTrigger, pBehTarget);
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
    public Stream<Transition> streamAllValuesOfcpsTrigger(final BehTriggerPair.Match partialMatch) {
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
    public Stream<Transition> streamAllValuesOfcpsTrigger(final Transition pCpsTarget, final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
      return rawStreamAllValuesOfcpsTrigger(new Object[]{null, pCpsTarget, pBehTrigger, pBehTarget});
    }
    
    /**
     * Retrieve the set of values that occur in matches for cpsTrigger.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOfcpsTrigger(final BehTriggerPair.Match partialMatch) {
      return rawStreamAllValuesOfcpsTrigger(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for cpsTrigger.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOfcpsTrigger(final Transition pCpsTarget, final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
      return rawStreamAllValuesOfcpsTrigger(new Object[]{null, pCpsTarget, pBehTrigger, pBehTarget}).collect(Collectors.toSet());
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
    public Stream<Transition> streamAllValuesOfcpsTarget(final BehTriggerPair.Match partialMatch) {
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
    public Stream<Transition> streamAllValuesOfcpsTarget(final Transition pCpsTrigger, final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
      return rawStreamAllValuesOfcpsTarget(new Object[]{pCpsTrigger, null, pBehTrigger, pBehTarget});
    }
    
    /**
     * Retrieve the set of values that occur in matches for cpsTarget.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOfcpsTarget(final BehTriggerPair.Match partialMatch) {
      return rawStreamAllValuesOfcpsTarget(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for cpsTarget.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOfcpsTarget(final Transition pCpsTrigger, final BehaviorTransition pBehTrigger, final BehaviorTransition pBehTarget) {
      return rawStreamAllValuesOfcpsTarget(new Object[]{pCpsTrigger, null, pBehTrigger, pBehTarget}).collect(Collectors.toSet());
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
    public Stream<BehaviorTransition> streamAllValuesOfbehTrigger(final BehTriggerPair.Match partialMatch) {
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
    public Stream<BehaviorTransition> streamAllValuesOfbehTrigger(final Transition pCpsTrigger, final Transition pCpsTarget, final BehaviorTransition pBehTarget) {
      return rawStreamAllValuesOfbehTrigger(new Object[]{pCpsTrigger, pCpsTarget, null, pBehTarget});
    }
    
    /**
     * Retrieve the set of values that occur in matches for behTrigger.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<BehaviorTransition> getAllValuesOfbehTrigger(final BehTriggerPair.Match partialMatch) {
      return rawStreamAllValuesOfbehTrigger(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for behTrigger.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<BehaviorTransition> getAllValuesOfbehTrigger(final Transition pCpsTrigger, final Transition pCpsTarget, final BehaviorTransition pBehTarget) {
      return rawStreamAllValuesOfbehTrigger(new Object[]{pCpsTrigger, pCpsTarget, null, pBehTarget}).collect(Collectors.toSet());
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
    public Stream<BehaviorTransition> streamAllValuesOfbehTarget(final BehTriggerPair.Match partialMatch) {
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
    public Stream<BehaviorTransition> streamAllValuesOfbehTarget(final Transition pCpsTrigger, final Transition pCpsTarget, final BehaviorTransition pBehTrigger) {
      return rawStreamAllValuesOfbehTarget(new Object[]{pCpsTrigger, pCpsTarget, pBehTrigger, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for behTarget.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<BehaviorTransition> getAllValuesOfbehTarget(final BehTriggerPair.Match partialMatch) {
      return rawStreamAllValuesOfbehTarget(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for behTarget.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<BehaviorTransition> getAllValuesOfbehTarget(final Transition pCpsTrigger, final Transition pCpsTarget, final BehaviorTransition pBehTrigger) {
      return rawStreamAllValuesOfbehTarget(new Object[]{pCpsTrigger, pCpsTarget, pBehTrigger, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected BehTriggerPair.Match tupleToMatch(final Tuple t) {
      try {
          return BehTriggerPair.Match.newMatch((Transition) t.get(POSITION_CPSTRIGGER), (Transition) t.get(POSITION_CPSTARGET), (BehaviorTransition) t.get(POSITION_BEHTRIGGER), (BehaviorTransition) t.get(POSITION_BEHTARGET));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected BehTriggerPair.Match arrayToMatch(final Object[] match) {
      try {
          return BehTriggerPair.Match.newMatch((Transition) match[POSITION_CPSTRIGGER], (Transition) match[POSITION_CPSTARGET], (BehaviorTransition) match[POSITION_BEHTRIGGER], (BehaviorTransition) match[POSITION_BEHTARGET]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected BehTriggerPair.Match arrayToMatchMutable(final Object[] match) {
      try {
          return BehTriggerPair.Match.newMutableMatch((Transition) match[POSITION_CPSTRIGGER], (Transition) match[POSITION_CPSTARGET], (BehaviorTransition) match[POSITION_BEHTRIGGER], (BehaviorTransition) match[POSITION_BEHTARGET]);
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
    public static IQuerySpecification<BehTriggerPair.Matcher> querySpecification() {
      return BehTriggerPair.instance();
    }
  }
  
  private BehTriggerPair() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static BehTriggerPair instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected BehTriggerPair.Matcher instantiate(final ViatraQueryEngine engine) {
    return BehTriggerPair.Matcher.on(engine);
  }
  
  @Override
  public BehTriggerPair.Matcher instantiate() {
    return BehTriggerPair.Matcher.create();
  }
  
  @Override
  public BehTriggerPair.Match newEmptyMatch() {
    return BehTriggerPair.Match.newEmptyMatch();
  }
  
  @Override
  public BehTriggerPair.Match newMatch(final Object... parameters) {
    return BehTriggerPair.Match.newMatch((org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition) parameters[0], (org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition) parameters[1], (org.eclipse.viatra.examples.cps.deployment.BehaviorTransition) parameters[2], (org.eclipse.viatra.examples.cps.deployment.BehaviorTransition) parameters[3]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.BehTriggerPair (visibility: PUBLIC, simpleName: BehTriggerPair, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.BehTriggerPair, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.BehTriggerPair (visibility: PUBLIC, simpleName: BehTriggerPair, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.BehTriggerPair, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final BehTriggerPair INSTANCE = new BehTriggerPair();
    
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
    private static final BehTriggerPair.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_cpsTrigger = new PParameter("cpsTrigger", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "Transition")), PParameterDirection.INOUT);
    
    private final PParameter parameter_cpsTarget = new PParameter("cpsTarget", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "Transition")), PParameterDirection.INOUT);
    
    private final PParameter parameter_behTrigger = new PParameter("behTrigger", "org.eclipse.viatra.examples.cps.deployment.BehaviorTransition", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/deployment", "BehaviorTransition")), PParameterDirection.INOUT);
    
    private final PParameter parameter_behTarget = new PParameter("behTarget", "org.eclipse.viatra.examples.cps.deployment.BehaviorTransition", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/deployment", "BehaviorTransition")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_cpsTrigger, parameter_cpsTarget, parameter_behTrigger, parameter_behTarget);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.behTriggerPair";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("cpsTrigger","cpsTarget","behTrigger","behTarget");
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
          PVariable var_cpsTrigger = body.getOrCreateVariableByName("cpsTrigger");
          PVariable var_cpsTarget = body.getOrCreateVariableByName("cpsTarget");
          PVariable var_behTrigger = body.getOrCreateVariableByName("behTrigger");
          PVariable var_behTarget = body.getOrCreateVariableByName("behTarget");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
          PVariable var___2_ = body.getOrCreateVariableByName("_<2>");
          PVariable var___3_ = body.getOrCreateVariableByName("_<3>");
          PVariable var___4_ = body.getOrCreateVariableByName("_<4>");
          PVariable var___5_ = body.getOrCreateVariableByName("_<5>");
          PVariable var___6_ = body.getOrCreateVariableByName("_<6>");
          PVariable var___7_ = body.getOrCreateVariableByName("_<7>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_cpsTrigger), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "Transition")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_cpsTarget), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "Transition")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_behTrigger), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "BehaviorTransition")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_behTarget), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "BehaviorTransition")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_cpsTrigger, parameter_cpsTrigger),
             new ExportedParameter(body, var_cpsTarget, parameter_cpsTarget),
             new ExportedParameter(body, var_behTrigger, parameter_behTrigger),
             new ExportedParameter(body, var_behTarget, parameter_behTarget)
          ));
          //    find triggerPair(_,_,_,_,cpsTrigger,cpsTarget)
          new PositivePatternCall(body, Tuples.flatTupleOf(var___0_, var___1_, var___2_, var___3_, var_cpsTrigger, var_cpsTarget), TriggerPair.instance().getInternalQueryRepresentation());
          //        find cps2depTrace(_, _, cpsTrigger, behTrigger)
          new PositivePatternCall(body, Tuples.flatTupleOf(var___4_, var___5_, var_cpsTrigger, var_behTrigger), Cps2depTrace.instance().getInternalQueryRepresentation());
          //    find cps2depTrace(_, _, cpsTarget, behTarget)
          new PositivePatternCall(body, Tuples.flatTupleOf(var___6_, var___7_, var_cpsTarget, var_behTarget), Cps2depTrace.instance().getInternalQueryRepresentation());
          //       neg find alreadyTriggered(behTrigger,behTarget)
          new NegativePatternCall(body, Tuples.flatTupleOf(var_behTrigger, var_behTarget), AlreadyTriggered.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
