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
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition;
import org.eclipse.viatra.examples.cps.xform.m2m.util.SignalUtil;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EDataTypeInSlotsKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.context.common.JavaTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.viatra.query.runtime.matchers.psystem.IValueProvider;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExpressionEvaluation;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.TypeFilterConstraint;
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
 *         //Transition types
 *         
 *         pattern sendTransitionAppSignal(transition : Transition, app : java String, appType : ApplicationType, signal : java String) {
 *             ApplicationType.behavior(appType, stateMachine);
 *             StateMachine.states(stateMachine, source);
 *             State.outgoingTransitions(source, transition);
 *             Transition.action(transition, action);
 *             app == eval(SignalUtil.getAppId(action));
 *             signal == eval(SignalUtil.getSignalId(action));
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtext.xbase.compiler.JvmModelGenerator")
public final class SendTransitionAppSignal extends BaseGeneratedEMFQuerySpecification<SendTransitionAppSignal.Matcher> {
  /**
   * Pattern-specific match representation of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.sendTransitionAppSignal pattern,
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
    private Transition fTransition;
    
    private String fApp;
    
    private ApplicationType fAppType;
    
    private String fSignal;
    
    private static List<String> parameterNames = makeImmutableList("transition", "app", "appType", "signal");
    
    private Match(final Transition pTransition, final String pApp, final ApplicationType pAppType, final String pSignal) {
      this.fTransition = pTransition;
      this.fApp = pApp;
      this.fAppType = pAppType;
      this.fSignal = pSignal;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("transition".equals(parameterName)) return this.fTransition;
      if ("app".equals(parameterName)) return this.fApp;
      if ("appType".equals(parameterName)) return this.fAppType;
      if ("signal".equals(parameterName)) return this.fSignal;
      return null;
    }
    
    public Transition getTransition() {
      return this.fTransition;
    }
    
    public String getApp() {
      return this.fApp;
    }
    
    public ApplicationType getAppType() {
      return this.fAppType;
    }
    
    public String getSignal() {
      return this.fSignal;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("transition".equals(parameterName) ) {
          this.fTransition = (Transition) newValue;
          return true;
      }
      if ("app".equals(parameterName) ) {
          this.fApp = (String) newValue;
          return true;
      }
      if ("appType".equals(parameterName) ) {
          this.fAppType = (ApplicationType) newValue;
          return true;
      }
      if ("signal".equals(parameterName) ) {
          this.fSignal = (String) newValue;
          return true;
      }
      return false;
    }
    
    public void setTransition(final Transition pTransition) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTransition = pTransition;
    }
    
    public void setApp(final String pApp) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fApp = pApp;
    }
    
    public void setAppType(final ApplicationType pAppType) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fAppType = pAppType;
    }
    
    public void setSignal(final String pSignal) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fSignal = pSignal;
    }
    
    @Override
    public String patternName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.sendTransitionAppSignal";
    }
    
    @Override
    public List<String> parameterNames() {
      return SendTransitionAppSignal.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fTransition, fApp, fAppType, fSignal};
    }
    
    @Override
    public SendTransitionAppSignal.Match toImmutable() {
      return isMutable() ? newMatch(fTransition, fApp, fAppType, fSignal) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"transition\"=" + prettyPrintValue(fTransition) + ", ");
      result.append("\"app\"=" + prettyPrintValue(fApp) + ", ");
      result.append("\"appType\"=" + prettyPrintValue(fAppType) + ", ");
      result.append("\"signal\"=" + prettyPrintValue(fSignal));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fTransition, fApp, fAppType, fSignal);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof SendTransitionAppSignal.Match)) {
          SendTransitionAppSignal.Match other = (SendTransitionAppSignal.Match) obj;
          return Objects.equals(fTransition, other.fTransition) && Objects.equals(fApp, other.fApp) && Objects.equals(fAppType, other.fAppType) && Objects.equals(fSignal, other.fSignal);
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
    public SendTransitionAppSignal specification() {
      return SendTransitionAppSignal.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static SendTransitionAppSignal.Match newEmptyMatch() {
      return new Mutable(null, null, null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pApp the fixed value of pattern parameter app, or null if not bound.
     * @param pAppType the fixed value of pattern parameter appType, or null if not bound.
     * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static SendTransitionAppSignal.Match newMutableMatch(final Transition pTransition, final String pApp, final ApplicationType pAppType, final String pSignal) {
      return new Mutable(pTransition, pApp, pAppType, pSignal);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pApp the fixed value of pattern parameter app, or null if not bound.
     * @param pAppType the fixed value of pattern parameter appType, or null if not bound.
     * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static SendTransitionAppSignal.Match newMatch(final Transition pTransition, final String pApp, final ApplicationType pAppType, final String pSignal) {
      return new Immutable(pTransition, pApp, pAppType, pSignal);
    }
    
    private static final class Mutable extends SendTransitionAppSignal.Match {
      Mutable(final Transition pTransition, final String pApp, final ApplicationType pAppType, final String pSignal) {
        super(pTransition, pApp, pAppType, pSignal);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends SendTransitionAppSignal.Match {
      Immutable(final Transition pTransition, final String pApp, final ApplicationType pAppType, final String pSignal) {
        super(pTransition, pApp, pAppType, pSignal);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.sendTransitionAppSignal pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * //Transition types
   * 
   * pattern sendTransitionAppSignal(transition : Transition, app : java String, appType : ApplicationType, signal : java String) {
   *     ApplicationType.behavior(appType, stateMachine);
   *     StateMachine.states(stateMachine, source);
   *     State.outgoingTransitions(source, transition);
   *     Transition.action(transition, action);
   *     app == eval(SignalUtil.getAppId(action));
   *     signal == eval(SignalUtil.getSignalId(action));
   * }
   * </pre></code>
   * 
   * @see Match
   * @see SendTransitionAppSignal
   * 
   */
  public static class Matcher extends BaseMatcher<SendTransitionAppSignal.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static SendTransitionAppSignal.Matcher on(final ViatraQueryEngine engine) {
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
    public static SendTransitionAppSignal.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_TRANSITION = 0;
    
    private static final int POSITION_APP = 1;
    
    private static final int POSITION_APPTYPE = 2;
    
    private static final int POSITION_SIGNAL = 3;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(SendTransitionAppSignal.Matcher.class);
    
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
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pApp the fixed value of pattern parameter app, or null if not bound.
     * @param pAppType the fixed value of pattern parameter appType, or null if not bound.
     * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<SendTransitionAppSignal.Match> getAllMatches(final Transition pTransition, final String pApp, final ApplicationType pAppType, final String pSignal) {
      return rawStreamAllMatches(new Object[]{pTransition, pApp, pAppType, pSignal}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pApp the fixed value of pattern parameter app, or null if not bound.
     * @param pAppType the fixed value of pattern parameter appType, or null if not bound.
     * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<SendTransitionAppSignal.Match> streamAllMatches(final Transition pTransition, final String pApp, final ApplicationType pAppType, final String pSignal) {
      return rawStreamAllMatches(new Object[]{pTransition, pApp, pAppType, pSignal});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pApp the fixed value of pattern parameter app, or null if not bound.
     * @param pAppType the fixed value of pattern parameter appType, or null if not bound.
     * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<SendTransitionAppSignal.Match> getOneArbitraryMatch(final Transition pTransition, final String pApp, final ApplicationType pAppType, final String pSignal) {
      return rawGetOneArbitraryMatch(new Object[]{pTransition, pApp, pAppType, pSignal});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pApp the fixed value of pattern parameter app, or null if not bound.
     * @param pAppType the fixed value of pattern parameter appType, or null if not bound.
     * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Transition pTransition, final String pApp, final ApplicationType pAppType, final String pSignal) {
      return rawHasMatch(new Object[]{pTransition, pApp, pAppType, pSignal});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pApp the fixed value of pattern parameter app, or null if not bound.
     * @param pAppType the fixed value of pattern parameter appType, or null if not bound.
     * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Transition pTransition, final String pApp, final ApplicationType pAppType, final String pSignal) {
      return rawCountMatches(new Object[]{pTransition, pApp, pAppType, pSignal});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pApp the fixed value of pattern parameter app, or null if not bound.
     * @param pAppType the fixed value of pattern parameter appType, or null if not bound.
     * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Transition pTransition, final String pApp, final ApplicationType pAppType, final String pSignal, final Consumer<? super SendTransitionAppSignal.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pTransition, pApp, pAppType, pSignal}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pApp the fixed value of pattern parameter app, or null if not bound.
     * @param pAppType the fixed value of pattern parameter appType, or null if not bound.
     * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public SendTransitionAppSignal.Match newMatch(final Transition pTransition, final String pApp, final ApplicationType pAppType, final String pSignal) {
      return SendTransitionAppSignal.Match.newMatch(pTransition, pApp, pAppType, pSignal);
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
    public Stream<Transition> streamAllValuesOftransition(final SendTransitionAppSignal.Match partialMatch) {
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
    public Stream<Transition> streamAllValuesOftransition(final String pApp, final ApplicationType pAppType, final String pSignal) {
      return rawStreamAllValuesOftransition(new Object[]{null, pApp, pAppType, pSignal});
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOftransition(final SendTransitionAppSignal.Match partialMatch) {
      return rawStreamAllValuesOftransition(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOftransition(final String pApp, final ApplicationType pAppType, final String pSignal) {
      return rawStreamAllValuesOftransition(new Object[]{null, pApp, pAppType, pSignal}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for app.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<String> rawStreamAllValuesOfapp(final Object[] parameters) {
      return rawStreamAllValues(POSITION_APP, parameters).map(String.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for app.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfapp() {
      return rawStreamAllValuesOfapp(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for app.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfapp() {
      return rawStreamAllValuesOfapp(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for app.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfapp(final SendTransitionAppSignal.Match partialMatch) {
      return rawStreamAllValuesOfapp(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for app.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfapp(final Transition pTransition, final ApplicationType pAppType, final String pSignal) {
      return rawStreamAllValuesOfapp(new Object[]{pTransition, null, pAppType, pSignal});
    }
    
    /**
     * Retrieve the set of values that occur in matches for app.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfapp(final SendTransitionAppSignal.Match partialMatch) {
      return rawStreamAllValuesOfapp(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for app.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfapp(final Transition pTransition, final ApplicationType pAppType, final String pSignal) {
      return rawStreamAllValuesOfapp(new Object[]{pTransition, null, pAppType, pSignal}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for appType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<ApplicationType> rawStreamAllValuesOfappType(final Object[] parameters) {
      return rawStreamAllValues(POSITION_APPTYPE, parameters).map(ApplicationType.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for appType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationType> getAllValuesOfappType() {
      return rawStreamAllValuesOfappType(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for appType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<ApplicationType> streamAllValuesOfappType() {
      return rawStreamAllValuesOfappType(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for appType.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<ApplicationType> streamAllValuesOfappType(final SendTransitionAppSignal.Match partialMatch) {
      return rawStreamAllValuesOfappType(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for appType.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<ApplicationType> streamAllValuesOfappType(final Transition pTransition, final String pApp, final String pSignal) {
      return rawStreamAllValuesOfappType(new Object[]{pTransition, pApp, null, pSignal});
    }
    
    /**
     * Retrieve the set of values that occur in matches for appType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationType> getAllValuesOfappType(final SendTransitionAppSignal.Match partialMatch) {
      return rawStreamAllValuesOfappType(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for appType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationType> getAllValuesOfappType(final Transition pTransition, final String pApp, final String pSignal) {
      return rawStreamAllValuesOfappType(new Object[]{pTransition, pApp, null, pSignal}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for signal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<String> rawStreamAllValuesOfsignal(final Object[] parameters) {
      return rawStreamAllValues(POSITION_SIGNAL, parameters).map(String.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for signal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfsignal() {
      return rawStreamAllValuesOfsignal(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for signal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfsignal() {
      return rawStreamAllValuesOfsignal(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for signal.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfsignal(final SendTransitionAppSignal.Match partialMatch) {
      return rawStreamAllValuesOfsignal(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for signal.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfsignal(final Transition pTransition, final String pApp, final ApplicationType pAppType) {
      return rawStreamAllValuesOfsignal(new Object[]{pTransition, pApp, pAppType, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for signal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfsignal(final SendTransitionAppSignal.Match partialMatch) {
      return rawStreamAllValuesOfsignal(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for signal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfsignal(final Transition pTransition, final String pApp, final ApplicationType pAppType) {
      return rawStreamAllValuesOfsignal(new Object[]{pTransition, pApp, pAppType, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected SendTransitionAppSignal.Match tupleToMatch(final Tuple t) {
      try {
          return SendTransitionAppSignal.Match.newMatch((Transition) t.get(POSITION_TRANSITION), (String) t.get(POSITION_APP), (ApplicationType) t.get(POSITION_APPTYPE), (String) t.get(POSITION_SIGNAL));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected SendTransitionAppSignal.Match arrayToMatch(final Object[] match) {
      try {
          return SendTransitionAppSignal.Match.newMatch((Transition) match[POSITION_TRANSITION], (String) match[POSITION_APP], (ApplicationType) match[POSITION_APPTYPE], (String) match[POSITION_SIGNAL]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected SendTransitionAppSignal.Match arrayToMatchMutable(final Object[] match) {
      try {
          return SendTransitionAppSignal.Match.newMutableMatch((Transition) match[POSITION_TRANSITION], (String) match[POSITION_APP], (ApplicationType) match[POSITION_APPTYPE], (String) match[POSITION_SIGNAL]);
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
    public static IQuerySpecification<SendTransitionAppSignal.Matcher> querySpecification() {
      return SendTransitionAppSignal.instance();
    }
  }
  
  private SendTransitionAppSignal() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static SendTransitionAppSignal instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected SendTransitionAppSignal.Matcher instantiate(final ViatraQueryEngine engine) {
    return SendTransitionAppSignal.Matcher.on(engine);
  }
  
  @Override
  public SendTransitionAppSignal.Matcher instantiate() {
    return SendTransitionAppSignal.Matcher.create();
  }
  
  @Override
  public SendTransitionAppSignal.Match newEmptyMatch() {
    return SendTransitionAppSignal.Match.newEmptyMatch();
  }
  
  @Override
  public SendTransitionAppSignal.Match newMatch(final Object... parameters) {
    return SendTransitionAppSignal.Match.newMatch((org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition) parameters[0], (java.lang.String) parameters[1], (org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType) parameters[2], (java.lang.String) parameters[3]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.SendTransitionAppSignal (visibility: PUBLIC, simpleName: SendTransitionAppSignal, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.SendTransitionAppSignal, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.SendTransitionAppSignal (visibility: PUBLIC, simpleName: SendTransitionAppSignal, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.SendTransitionAppSignal, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final SendTransitionAppSignal INSTANCE = new SendTransitionAppSignal();
    
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
    private static final SendTransitionAppSignal.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_transition = new PParameter("transition", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "Transition")), PParameterDirection.INOUT);
    
    private final PParameter parameter_app = new PParameter("app", "java.lang.String", new JavaTransitiveInstancesKey(java.lang.String.class), PParameterDirection.INOUT);
    
    private final PParameter parameter_appType = new PParameter("appType", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "ApplicationType")), PParameterDirection.INOUT);
    
    private final PParameter parameter_signal = new PParameter("signal", "java.lang.String", new JavaTransitiveInstancesKey(java.lang.String.class), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_transition, parameter_app, parameter_appType, parameter_signal);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.sendTransitionAppSignal";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("transition","app","appType","signal");
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
          PVariable var_transition = body.getOrCreateVariableByName("transition");
          PVariable var_app = body.getOrCreateVariableByName("app");
          PVariable var_appType = body.getOrCreateVariableByName("appType");
          PVariable var_signal = body.getOrCreateVariableByName("signal");
          PVariable var_stateMachine = body.getOrCreateVariableByName("stateMachine");
          PVariable var_source = body.getOrCreateVariableByName("source");
          PVariable var_action = body.getOrCreateVariableByName("action");
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "Transition")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_app), new JavaTransitiveInstancesKey(java.lang.String.class));
          new TypeConstraint(body, Tuples.flatTupleOf(var_appType), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "ApplicationType")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_signal), new JavaTransitiveInstancesKey(java.lang.String.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_transition, parameter_transition),
             new ExportedParameter(body, var_app, parameter_app),
             new ExportedParameter(body, var_appType, parameter_appType),
             new ExportedParameter(body, var_signal, parameter_signal)
          ));
          //     ApplicationType.behavior(appType, stateMachine)
          new TypeConstraint(body, Tuples.flatTupleOf(var_appType), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "ApplicationType")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_appType, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/cps", "ApplicationType", "behavior")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "StateMachine")));
          new Equality(body, var__virtual_0_, var_stateMachine);
          //     StateMachine.states(stateMachine, source)
          new TypeConstraint(body, Tuples.flatTupleOf(var_stateMachine), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "StateMachine")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_stateMachine, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/cps", "StateMachine", "states")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "State")));
          new Equality(body, var__virtual_1_, var_source);
          //     State.outgoingTransitions(source, transition)
          new TypeConstraint(body, Tuples.flatTupleOf(var_source), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "State")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_source, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/cps", "State", "outgoingTransitions")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "Transition")));
          new Equality(body, var__virtual_2_, var_transition);
          //     Transition.action(transition, action)
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "Transition")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/cps", "Transition", "action")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_3_, var_action);
          //     app == eval(SignalUtil.getAppId(action))
          PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
          new ExpressionEvaluation(body, new IExpressionEvaluator() {
          
              @Override
              public String getShortDescription() {
                  return "Expression evaluation from pattern sendTransitionAppSignal";
              }
              
              @Override
              public Iterable<String> getInputParameterNames() {
                  return Arrays.asList("action");}
          
              @Override
              public Object evaluateExpression(IValueProvider provider) throws Exception {
                  String action = (String) provider.getValue("action");
                  return evaluateExpression_1_1(action);
              }
          },  var__virtual_4_ ); 
          new Equality(body, var_app, var__virtual_4_);
          //     signal == eval(SignalUtil.getSignalId(action))
          PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
          new ExpressionEvaluation(body, new IExpressionEvaluator() {
          
              @Override
              public String getShortDescription() {
                  return "Expression evaluation from pattern sendTransitionAppSignal";
              }
              
              @Override
              public Iterable<String> getInputParameterNames() {
                  return Arrays.asList("action");}
          
              @Override
              public Object evaluateExpression(IValueProvider provider) throws Exception {
                  String action = (String) provider.getValue("action");
                  return evaluateExpression_1_2(action);
              }
          },  var__virtual_5_ ); 
          new Equality(body, var_signal, var__virtual_5_);
          bodies.add(body);
      }
      return bodies;
    }
  }
  
  private static String evaluateExpression_1_1(final String action) {
    String _appId = SignalUtil.getAppId(action);
    return _appId;
  }
  
  private static String evaluateExpression_1_2(final String action) {
    String _signalId = SignalUtil.getSignalId(action);
    return _signalId;
  }
}
