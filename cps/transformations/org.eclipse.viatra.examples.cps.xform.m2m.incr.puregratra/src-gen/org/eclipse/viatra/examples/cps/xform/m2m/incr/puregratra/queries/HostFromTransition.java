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
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceTransition;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.ApplicationInstanceWithHost;
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
 *         pattern hostFromTransition(appType : ApplicationType, appInstance : ApplicationInstance, transition : Transition, hostInstance : HostInstance) {
 *             find appInstanceTransition(appInstance, transition);
 *             find applicationInstanceWithHost(appType, appInstance, hostInstance);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtext.xbase.compiler.JvmModelGenerator")
public final class HostFromTransition extends BaseGeneratedEMFQuerySpecification<HostFromTransition.Matcher> {
  /**
   * Pattern-specific match representation of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.hostFromTransition pattern,
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
    private ApplicationType fAppType;
    
    private ApplicationInstance fAppInstance;
    
    private Transition fTransition;
    
    private HostInstance fHostInstance;
    
    private static List<String> parameterNames = makeImmutableList("appType", "appInstance", "transition", "hostInstance");
    
    private Match(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final Transition pTransition, final HostInstance pHostInstance) {
      this.fAppType = pAppType;
      this.fAppInstance = pAppInstance;
      this.fTransition = pTransition;
      this.fHostInstance = pHostInstance;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("appType".equals(parameterName)) return this.fAppType;
      if ("appInstance".equals(parameterName)) return this.fAppInstance;
      if ("transition".equals(parameterName)) return this.fTransition;
      if ("hostInstance".equals(parameterName)) return this.fHostInstance;
      return null;
    }
    
    public ApplicationType getAppType() {
      return this.fAppType;
    }
    
    public ApplicationInstance getAppInstance() {
      return this.fAppInstance;
    }
    
    public Transition getTransition() {
      return this.fTransition;
    }
    
    public HostInstance getHostInstance() {
      return this.fHostInstance;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("appType".equals(parameterName) ) {
          this.fAppType = (ApplicationType) newValue;
          return true;
      }
      if ("appInstance".equals(parameterName) ) {
          this.fAppInstance = (ApplicationInstance) newValue;
          return true;
      }
      if ("transition".equals(parameterName) ) {
          this.fTransition = (Transition) newValue;
          return true;
      }
      if ("hostInstance".equals(parameterName) ) {
          this.fHostInstance = (HostInstance) newValue;
          return true;
      }
      return false;
    }
    
    public void setAppType(final ApplicationType pAppType) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fAppType = pAppType;
    }
    
    public void setAppInstance(final ApplicationInstance pAppInstance) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fAppInstance = pAppInstance;
    }
    
    public void setTransition(final Transition pTransition) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTransition = pTransition;
    }
    
    public void setHostInstance(final HostInstance pHostInstance) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fHostInstance = pHostInstance;
    }
    
    @Override
    public String patternName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.hostFromTransition";
    }
    
    @Override
    public List<String> parameterNames() {
      return HostFromTransition.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fAppType, fAppInstance, fTransition, fHostInstance};
    }
    
    @Override
    public HostFromTransition.Match toImmutable() {
      return isMutable() ? newMatch(fAppType, fAppInstance, fTransition, fHostInstance) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"appType\"=" + prettyPrintValue(fAppType) + ", ");
      result.append("\"appInstance\"=" + prettyPrintValue(fAppInstance) + ", ");
      result.append("\"transition\"=" + prettyPrintValue(fTransition) + ", ");
      result.append("\"hostInstance\"=" + prettyPrintValue(fHostInstance));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fAppType, fAppInstance, fTransition, fHostInstance);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof HostFromTransition.Match)) {
          HostFromTransition.Match other = (HostFromTransition.Match) obj;
          return Objects.equals(fAppType, other.fAppType) && Objects.equals(fAppInstance, other.fAppInstance) && Objects.equals(fTransition, other.fTransition) && Objects.equals(fHostInstance, other.fHostInstance);
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
    public HostFromTransition specification() {
      return HostFromTransition.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static HostFromTransition.Match newEmptyMatch() {
      return new Mutable(null, null, null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pAppType the fixed value of pattern parameter appType, or null if not bound.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pHostInstance the fixed value of pattern parameter hostInstance, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static HostFromTransition.Match newMutableMatch(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final Transition pTransition, final HostInstance pHostInstance) {
      return new Mutable(pAppType, pAppInstance, pTransition, pHostInstance);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pAppType the fixed value of pattern parameter appType, or null if not bound.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pHostInstance the fixed value of pattern parameter hostInstance, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static HostFromTransition.Match newMatch(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final Transition pTransition, final HostInstance pHostInstance) {
      return new Immutable(pAppType, pAppInstance, pTransition, pHostInstance);
    }
    
    private static final class Mutable extends HostFromTransition.Match {
      Mutable(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final Transition pTransition, final HostInstance pHostInstance) {
        super(pAppType, pAppInstance, pTransition, pHostInstance);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends HostFromTransition.Match {
      Immutable(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final Transition pTransition, final HostInstance pHostInstance) {
        super(pAppType, pAppInstance, pTransition, pHostInstance);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.hostFromTransition pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern hostFromTransition(appType : ApplicationType, appInstance : ApplicationInstance, transition : Transition, hostInstance : HostInstance) {
   *     find appInstanceTransition(appInstance, transition);
   *     find applicationInstanceWithHost(appType, appInstance, hostInstance);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see HostFromTransition
   * 
   */
  public static class Matcher extends BaseMatcher<HostFromTransition.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static HostFromTransition.Matcher on(final ViatraQueryEngine engine) {
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
    public static HostFromTransition.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_APPTYPE = 0;
    
    private static final int POSITION_APPINSTANCE = 1;
    
    private static final int POSITION_TRANSITION = 2;
    
    private static final int POSITION_HOSTINSTANCE = 3;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(HostFromTransition.Matcher.class);
    
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
     * @param pAppType the fixed value of pattern parameter appType, or null if not bound.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pHostInstance the fixed value of pattern parameter hostInstance, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<HostFromTransition.Match> getAllMatches(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final Transition pTransition, final HostInstance pHostInstance) {
      return rawStreamAllMatches(new Object[]{pAppType, pAppInstance, pTransition, pHostInstance}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pAppType the fixed value of pattern parameter appType, or null if not bound.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pHostInstance the fixed value of pattern parameter hostInstance, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<HostFromTransition.Match> streamAllMatches(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final Transition pTransition, final HostInstance pHostInstance) {
      return rawStreamAllMatches(new Object[]{pAppType, pAppInstance, pTransition, pHostInstance});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pAppType the fixed value of pattern parameter appType, or null if not bound.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pHostInstance the fixed value of pattern parameter hostInstance, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<HostFromTransition.Match> getOneArbitraryMatch(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final Transition pTransition, final HostInstance pHostInstance) {
      return rawGetOneArbitraryMatch(new Object[]{pAppType, pAppInstance, pTransition, pHostInstance});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pAppType the fixed value of pattern parameter appType, or null if not bound.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pHostInstance the fixed value of pattern parameter hostInstance, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final Transition pTransition, final HostInstance pHostInstance) {
      return rawHasMatch(new Object[]{pAppType, pAppInstance, pTransition, pHostInstance});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pAppType the fixed value of pattern parameter appType, or null if not bound.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pHostInstance the fixed value of pattern parameter hostInstance, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final Transition pTransition, final HostInstance pHostInstance) {
      return rawCountMatches(new Object[]{pAppType, pAppInstance, pTransition, pHostInstance});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pAppType the fixed value of pattern parameter appType, or null if not bound.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pHostInstance the fixed value of pattern parameter hostInstance, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final Transition pTransition, final HostInstance pHostInstance, final Consumer<? super HostFromTransition.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pAppType, pAppInstance, pTransition, pHostInstance}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pAppType the fixed value of pattern parameter appType, or null if not bound.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pHostInstance the fixed value of pattern parameter hostInstance, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public HostFromTransition.Match newMatch(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final Transition pTransition, final HostInstance pHostInstance) {
      return HostFromTransition.Match.newMatch(pAppType, pAppInstance, pTransition, pHostInstance);
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
    public Stream<ApplicationType> streamAllValuesOfappType(final HostFromTransition.Match partialMatch) {
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
    public Stream<ApplicationType> streamAllValuesOfappType(final ApplicationInstance pAppInstance, final Transition pTransition, final HostInstance pHostInstance) {
      return rawStreamAllValuesOfappType(new Object[]{null, pAppInstance, pTransition, pHostInstance});
    }
    
    /**
     * Retrieve the set of values that occur in matches for appType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationType> getAllValuesOfappType(final HostFromTransition.Match partialMatch) {
      return rawStreamAllValuesOfappType(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for appType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationType> getAllValuesOfappType(final ApplicationInstance pAppInstance, final Transition pTransition, final HostInstance pHostInstance) {
      return rawStreamAllValuesOfappType(new Object[]{null, pAppInstance, pTransition, pHostInstance}).collect(Collectors.toSet());
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
    public Stream<ApplicationInstance> streamAllValuesOfappInstance(final HostFromTransition.Match partialMatch) {
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
    public Stream<ApplicationInstance> streamAllValuesOfappInstance(final ApplicationType pAppType, final Transition pTransition, final HostInstance pHostInstance) {
      return rawStreamAllValuesOfappInstance(new Object[]{pAppType, null, pTransition, pHostInstance});
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationInstance> getAllValuesOfappInstance(final HostFromTransition.Match partialMatch) {
      return rawStreamAllValuesOfappInstance(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationInstance> getAllValuesOfappInstance(final ApplicationType pAppType, final Transition pTransition, final HostInstance pHostInstance) {
      return rawStreamAllValuesOfappInstance(new Object[]{pAppType, null, pTransition, pHostInstance}).collect(Collectors.toSet());
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
    public Stream<Transition> streamAllValuesOftransition(final HostFromTransition.Match partialMatch) {
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
    public Stream<Transition> streamAllValuesOftransition(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final HostInstance pHostInstance) {
      return rawStreamAllValuesOftransition(new Object[]{pAppType, pAppInstance, null, pHostInstance});
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOftransition(final HostFromTransition.Match partialMatch) {
      return rawStreamAllValuesOftransition(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOftransition(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final HostInstance pHostInstance) {
      return rawStreamAllValuesOftransition(new Object[]{pAppType, pAppInstance, null, pHostInstance}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for hostInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<HostInstance> rawStreamAllValuesOfhostInstance(final Object[] parameters) {
      return rawStreamAllValues(POSITION_HOSTINSTANCE, parameters).map(HostInstance.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for hostInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HostInstance> getAllValuesOfhostInstance() {
      return rawStreamAllValuesOfhostInstance(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for hostInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<HostInstance> streamAllValuesOfhostInstance() {
      return rawStreamAllValuesOfhostInstance(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for hostInstance.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<HostInstance> streamAllValuesOfhostInstance(final HostFromTransition.Match partialMatch) {
      return rawStreamAllValuesOfhostInstance(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for hostInstance.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<HostInstance> streamAllValuesOfhostInstance(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final Transition pTransition) {
      return rawStreamAllValuesOfhostInstance(new Object[]{pAppType, pAppInstance, pTransition, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for hostInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HostInstance> getAllValuesOfhostInstance(final HostFromTransition.Match partialMatch) {
      return rawStreamAllValuesOfhostInstance(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for hostInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HostInstance> getAllValuesOfhostInstance(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final Transition pTransition) {
      return rawStreamAllValuesOfhostInstance(new Object[]{pAppType, pAppInstance, pTransition, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected HostFromTransition.Match tupleToMatch(final Tuple t) {
      try {
          return HostFromTransition.Match.newMatch((ApplicationType) t.get(POSITION_APPTYPE), (ApplicationInstance) t.get(POSITION_APPINSTANCE), (Transition) t.get(POSITION_TRANSITION), (HostInstance) t.get(POSITION_HOSTINSTANCE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected HostFromTransition.Match arrayToMatch(final Object[] match) {
      try {
          return HostFromTransition.Match.newMatch((ApplicationType) match[POSITION_APPTYPE], (ApplicationInstance) match[POSITION_APPINSTANCE], (Transition) match[POSITION_TRANSITION], (HostInstance) match[POSITION_HOSTINSTANCE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected HostFromTransition.Match arrayToMatchMutable(final Object[] match) {
      try {
          return HostFromTransition.Match.newMutableMatch((ApplicationType) match[POSITION_APPTYPE], (ApplicationInstance) match[POSITION_APPINSTANCE], (Transition) match[POSITION_TRANSITION], (HostInstance) match[POSITION_HOSTINSTANCE]);
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
    public static IQuerySpecification<HostFromTransition.Matcher> querySpecification() {
      return HostFromTransition.instance();
    }
  }
  
  private HostFromTransition() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static HostFromTransition instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected HostFromTransition.Matcher instantiate(final ViatraQueryEngine engine) {
    return HostFromTransition.Matcher.on(engine);
  }
  
  @Override
  public HostFromTransition.Matcher instantiate() {
    return HostFromTransition.Matcher.create();
  }
  
  @Override
  public HostFromTransition.Match newEmptyMatch() {
    return HostFromTransition.Match.newEmptyMatch();
  }
  
  @Override
  public HostFromTransition.Match newMatch(final Object... parameters) {
    return HostFromTransition.Match.newMatch((org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType) parameters[0], (org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance) parameters[1], (org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition) parameters[2], (org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance) parameters[3]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.HostFromTransition (visibility: PUBLIC, simpleName: HostFromTransition, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.HostFromTransition, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.HostFromTransition (visibility: PUBLIC, simpleName: HostFromTransition, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.HostFromTransition, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final HostFromTransition INSTANCE = new HostFromTransition();
    
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
    private static final HostFromTransition.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_appType = new PParameter("appType", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "ApplicationType")), PParameterDirection.INOUT);
    
    private final PParameter parameter_appInstance = new PParameter("appInstance", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "ApplicationInstance")), PParameterDirection.INOUT);
    
    private final PParameter parameter_transition = new PParameter("transition", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "Transition")), PParameterDirection.INOUT);
    
    private final PParameter parameter_hostInstance = new PParameter("hostInstance", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "HostInstance")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_appType, parameter_appInstance, parameter_transition, parameter_hostInstance);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.hostFromTransition";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("appType","appInstance","transition","hostInstance");
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
          PVariable var_appType = body.getOrCreateVariableByName("appType");
          PVariable var_appInstance = body.getOrCreateVariableByName("appInstance");
          PVariable var_transition = body.getOrCreateVariableByName("transition");
          PVariable var_hostInstance = body.getOrCreateVariableByName("hostInstance");
          new TypeConstraint(body, Tuples.flatTupleOf(var_appType), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "ApplicationType")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_appInstance), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "ApplicationInstance")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "Transition")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_hostInstance), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "HostInstance")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_appType, parameter_appType),
             new ExportedParameter(body, var_appInstance, parameter_appInstance),
             new ExportedParameter(body, var_transition, parameter_transition),
             new ExportedParameter(body, var_hostInstance, parameter_hostInstance)
          ));
          //     find appInstanceTransition(appInstance, transition)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_appInstance, var_transition), AppInstanceTransition.instance().getInternalQueryRepresentation());
          //     find applicationInstanceWithHost(appType, appInstance, hostInstance)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_appType, var_appInstance, var_hostInstance), ApplicationInstanceWithHost.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
