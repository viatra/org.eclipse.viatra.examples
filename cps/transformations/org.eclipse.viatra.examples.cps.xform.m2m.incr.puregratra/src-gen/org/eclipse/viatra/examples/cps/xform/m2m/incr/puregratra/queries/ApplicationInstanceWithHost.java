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
 *         //The corresponding app instances can communicate
 *         
 *         pattern applicationInstanceWithHost(appType : ApplicationType, appInstance : ApplicationInstance, host : HostInstance) {
 *             find applicationInstance(appType, appInstance);
 *             ApplicationInstance.allocatedTo(appInstance, host);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtext.xbase.compiler.JvmModelGenerator")
public final class ApplicationInstanceWithHost extends BaseGeneratedEMFQuerySpecification<ApplicationInstanceWithHost.Matcher> {
  /**
   * Pattern-specific match representation of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.applicationInstanceWithHost pattern,
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
    
    private HostInstance fHost;
    
    private static List<String> parameterNames = makeImmutableList("appType", "appInstance", "host");
    
    private Match(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final HostInstance pHost) {
      this.fAppType = pAppType;
      this.fAppInstance = pAppInstance;
      this.fHost = pHost;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("appType".equals(parameterName)) return this.fAppType;
      if ("appInstance".equals(parameterName)) return this.fAppInstance;
      if ("host".equals(parameterName)) return this.fHost;
      return null;
    }
    
    public ApplicationType getAppType() {
      return this.fAppType;
    }
    
    public ApplicationInstance getAppInstance() {
      return this.fAppInstance;
    }
    
    public HostInstance getHost() {
      return this.fHost;
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
      if ("host".equals(parameterName) ) {
          this.fHost = (HostInstance) newValue;
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
    
    public void setHost(final HostInstance pHost) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fHost = pHost;
    }
    
    @Override
    public String patternName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.applicationInstanceWithHost";
    }
    
    @Override
    public List<String> parameterNames() {
      return ApplicationInstanceWithHost.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fAppType, fAppInstance, fHost};
    }
    
    @Override
    public ApplicationInstanceWithHost.Match toImmutable() {
      return isMutable() ? newMatch(fAppType, fAppInstance, fHost) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"appType\"=" + prettyPrintValue(fAppType) + ", ");
      result.append("\"appInstance\"=" + prettyPrintValue(fAppInstance) + ", ");
      result.append("\"host\"=" + prettyPrintValue(fHost));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fAppType, fAppInstance, fHost);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof ApplicationInstanceWithHost.Match)) {
          ApplicationInstanceWithHost.Match other = (ApplicationInstanceWithHost.Match) obj;
          return Objects.equals(fAppType, other.fAppType) && Objects.equals(fAppInstance, other.fAppInstance) && Objects.equals(fHost, other.fHost);
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
    public ApplicationInstanceWithHost specification() {
      return ApplicationInstanceWithHost.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static ApplicationInstanceWithHost.Match newEmptyMatch() {
      return new Mutable(null, null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pAppType the fixed value of pattern parameter appType, or null if not bound.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pHost the fixed value of pattern parameter host, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static ApplicationInstanceWithHost.Match newMutableMatch(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final HostInstance pHost) {
      return new Mutable(pAppType, pAppInstance, pHost);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pAppType the fixed value of pattern parameter appType, or null if not bound.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pHost the fixed value of pattern parameter host, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static ApplicationInstanceWithHost.Match newMatch(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final HostInstance pHost) {
      return new Immutable(pAppType, pAppInstance, pHost);
    }
    
    private static final class Mutable extends ApplicationInstanceWithHost.Match {
      Mutable(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final HostInstance pHost) {
        super(pAppType, pAppInstance, pHost);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends ApplicationInstanceWithHost.Match {
      Immutable(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final HostInstance pHost) {
        super(pAppType, pAppInstance, pHost);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.applicationInstanceWithHost pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * //The corresponding app instances can communicate
   * 
   * pattern applicationInstanceWithHost(appType : ApplicationType, appInstance : ApplicationInstance, host : HostInstance) {
   *     find applicationInstance(appType, appInstance);
   *     ApplicationInstance.allocatedTo(appInstance, host);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see ApplicationInstanceWithHost
   * 
   */
  public static class Matcher extends BaseMatcher<ApplicationInstanceWithHost.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static ApplicationInstanceWithHost.Matcher on(final ViatraQueryEngine engine) {
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
    public static ApplicationInstanceWithHost.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_APPTYPE = 0;
    
    private static final int POSITION_APPINSTANCE = 1;
    
    private static final int POSITION_HOST = 2;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ApplicationInstanceWithHost.Matcher.class);
    
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
     * @param pHost the fixed value of pattern parameter host, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<ApplicationInstanceWithHost.Match> getAllMatches(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final HostInstance pHost) {
      return rawStreamAllMatches(new Object[]{pAppType, pAppInstance, pHost}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pAppType the fixed value of pattern parameter appType, or null if not bound.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pHost the fixed value of pattern parameter host, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<ApplicationInstanceWithHost.Match> streamAllMatches(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final HostInstance pHost) {
      return rawStreamAllMatches(new Object[]{pAppType, pAppInstance, pHost});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pAppType the fixed value of pattern parameter appType, or null if not bound.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pHost the fixed value of pattern parameter host, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<ApplicationInstanceWithHost.Match> getOneArbitraryMatch(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final HostInstance pHost) {
      return rawGetOneArbitraryMatch(new Object[]{pAppType, pAppInstance, pHost});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pAppType the fixed value of pattern parameter appType, or null if not bound.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pHost the fixed value of pattern parameter host, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final HostInstance pHost) {
      return rawHasMatch(new Object[]{pAppType, pAppInstance, pHost});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pAppType the fixed value of pattern parameter appType, or null if not bound.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pHost the fixed value of pattern parameter host, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final HostInstance pHost) {
      return rawCountMatches(new Object[]{pAppType, pAppInstance, pHost});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pAppType the fixed value of pattern parameter appType, or null if not bound.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pHost the fixed value of pattern parameter host, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final HostInstance pHost, final Consumer<? super ApplicationInstanceWithHost.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pAppType, pAppInstance, pHost}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pAppType the fixed value of pattern parameter appType, or null if not bound.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pHost the fixed value of pattern parameter host, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public ApplicationInstanceWithHost.Match newMatch(final ApplicationType pAppType, final ApplicationInstance pAppInstance, final HostInstance pHost) {
      return ApplicationInstanceWithHost.Match.newMatch(pAppType, pAppInstance, pHost);
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
    public Stream<ApplicationType> streamAllValuesOfappType(final ApplicationInstanceWithHost.Match partialMatch) {
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
    public Stream<ApplicationType> streamAllValuesOfappType(final ApplicationInstance pAppInstance, final HostInstance pHost) {
      return rawStreamAllValuesOfappType(new Object[]{null, pAppInstance, pHost});
    }
    
    /**
     * Retrieve the set of values that occur in matches for appType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationType> getAllValuesOfappType(final ApplicationInstanceWithHost.Match partialMatch) {
      return rawStreamAllValuesOfappType(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for appType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationType> getAllValuesOfappType(final ApplicationInstance pAppInstance, final HostInstance pHost) {
      return rawStreamAllValuesOfappType(new Object[]{null, pAppInstance, pHost}).collect(Collectors.toSet());
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
    public Stream<ApplicationInstance> streamAllValuesOfappInstance(final ApplicationInstanceWithHost.Match partialMatch) {
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
    public Stream<ApplicationInstance> streamAllValuesOfappInstance(final ApplicationType pAppType, final HostInstance pHost) {
      return rawStreamAllValuesOfappInstance(new Object[]{pAppType, null, pHost});
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationInstance> getAllValuesOfappInstance(final ApplicationInstanceWithHost.Match partialMatch) {
      return rawStreamAllValuesOfappInstance(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationInstance> getAllValuesOfappInstance(final ApplicationType pAppType, final HostInstance pHost) {
      return rawStreamAllValuesOfappInstance(new Object[]{pAppType, null, pHost}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for host.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<HostInstance> rawStreamAllValuesOfhost(final Object[] parameters) {
      return rawStreamAllValues(POSITION_HOST, parameters).map(HostInstance.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for host.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HostInstance> getAllValuesOfhost() {
      return rawStreamAllValuesOfhost(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for host.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<HostInstance> streamAllValuesOfhost() {
      return rawStreamAllValuesOfhost(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for host.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<HostInstance> streamAllValuesOfhost(final ApplicationInstanceWithHost.Match partialMatch) {
      return rawStreamAllValuesOfhost(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for host.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<HostInstance> streamAllValuesOfhost(final ApplicationType pAppType, final ApplicationInstance pAppInstance) {
      return rawStreamAllValuesOfhost(new Object[]{pAppType, pAppInstance, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for host.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HostInstance> getAllValuesOfhost(final ApplicationInstanceWithHost.Match partialMatch) {
      return rawStreamAllValuesOfhost(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for host.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HostInstance> getAllValuesOfhost(final ApplicationType pAppType, final ApplicationInstance pAppInstance) {
      return rawStreamAllValuesOfhost(new Object[]{pAppType, pAppInstance, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected ApplicationInstanceWithHost.Match tupleToMatch(final Tuple t) {
      try {
          return ApplicationInstanceWithHost.Match.newMatch((ApplicationType) t.get(POSITION_APPTYPE), (ApplicationInstance) t.get(POSITION_APPINSTANCE), (HostInstance) t.get(POSITION_HOST));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected ApplicationInstanceWithHost.Match arrayToMatch(final Object[] match) {
      try {
          return ApplicationInstanceWithHost.Match.newMatch((ApplicationType) match[POSITION_APPTYPE], (ApplicationInstance) match[POSITION_APPINSTANCE], (HostInstance) match[POSITION_HOST]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected ApplicationInstanceWithHost.Match arrayToMatchMutable(final Object[] match) {
      try {
          return ApplicationInstanceWithHost.Match.newMutableMatch((ApplicationType) match[POSITION_APPTYPE], (ApplicationInstance) match[POSITION_APPINSTANCE], (HostInstance) match[POSITION_HOST]);
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
    public static IQuerySpecification<ApplicationInstanceWithHost.Matcher> querySpecification() {
      return ApplicationInstanceWithHost.instance();
    }
  }
  
  private ApplicationInstanceWithHost() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static ApplicationInstanceWithHost instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected ApplicationInstanceWithHost.Matcher instantiate(final ViatraQueryEngine engine) {
    return ApplicationInstanceWithHost.Matcher.on(engine);
  }
  
  @Override
  public ApplicationInstanceWithHost.Matcher instantiate() {
    return ApplicationInstanceWithHost.Matcher.create();
  }
  
  @Override
  public ApplicationInstanceWithHost.Match newEmptyMatch() {
    return ApplicationInstanceWithHost.Match.newEmptyMatch();
  }
  
  @Override
  public ApplicationInstanceWithHost.Match newMatch(final Object... parameters) {
    return ApplicationInstanceWithHost.Match.newMatch((org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType) parameters[0], (org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance) parameters[1], (org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.ApplicationInstanceWithHost (visibility: PUBLIC, simpleName: ApplicationInstanceWithHost, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.ApplicationInstanceWithHost, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.ApplicationInstanceWithHost (visibility: PUBLIC, simpleName: ApplicationInstanceWithHost, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.ApplicationInstanceWithHost, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final ApplicationInstanceWithHost INSTANCE = new ApplicationInstanceWithHost();
    
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
    private static final ApplicationInstanceWithHost.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_appType = new PParameter("appType", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "ApplicationType")), PParameterDirection.INOUT);
    
    private final PParameter parameter_appInstance = new PParameter("appInstance", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "ApplicationInstance")), PParameterDirection.INOUT);
    
    private final PParameter parameter_host = new PParameter("host", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "HostInstance")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_appType, parameter_appInstance, parameter_host);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.applicationInstanceWithHost";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("appType","appInstance","host");
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
          PVariable var_host = body.getOrCreateVariableByName("host");
          new TypeConstraint(body, Tuples.flatTupleOf(var_appType), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "ApplicationType")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_appInstance), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "ApplicationInstance")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_host), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "HostInstance")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_appType, parameter_appType),
             new ExportedParameter(body, var_appInstance, parameter_appInstance),
             new ExportedParameter(body, var_host, parameter_host)
          ));
          //     find applicationInstance(appType, appInstance)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_appType, var_appInstance), org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.ApplicationInstance.instance().getInternalQueryRepresentation());
          //     ApplicationInstance.allocatedTo(appInstance, host)
          new TypeConstraint(body, Tuples.flatTupleOf(var_appInstance), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "ApplicationInstance")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_appInstance, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/cps", "ApplicationInstance", "allocatedTo")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "HostInstance")));
          new Equality(body, var__virtual_0_, var_host);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
