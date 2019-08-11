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
import org.eclipse.viatra.examples.cps.deployment.DeploymentHost;
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
 *         AppInstance Rule Patterns (Spec 2) 
 *         
 *         pattern appInstanceWithDepHost(appInstance : ApplicationInstance, depHost : DeploymentHost) {
 *             HostInstance.applications(hostInstance, appInstance);
 *             find cps2depTrace(_, _, hostInstance, depHost);
 *             neg CPS2DeploymentTrace.cpsElements(_,appInstance);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtext.xbase.compiler.JvmModelGenerator")
public final class AppInstanceWithDepHost extends BaseGeneratedEMFQuerySpecification<AppInstanceWithDepHost.Matcher> {
  /**
   * Pattern-specific match representation of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.appInstanceWithDepHost pattern,
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
    
    private DeploymentHost fDepHost;
    
    private static List<String> parameterNames = makeImmutableList("appInstance", "depHost");
    
    private Match(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost) {
      this.fAppInstance = pAppInstance;
      this.fDepHost = pDepHost;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("appInstance".equals(parameterName)) return this.fAppInstance;
      if ("depHost".equals(parameterName)) return this.fDepHost;
      return null;
    }
    
    public ApplicationInstance getAppInstance() {
      return this.fAppInstance;
    }
    
    public DeploymentHost getDepHost() {
      return this.fDepHost;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("appInstance".equals(parameterName) ) {
          this.fAppInstance = (ApplicationInstance) newValue;
          return true;
      }
      if ("depHost".equals(parameterName) ) {
          this.fDepHost = (DeploymentHost) newValue;
          return true;
      }
      return false;
    }
    
    public void setAppInstance(final ApplicationInstance pAppInstance) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fAppInstance = pAppInstance;
    }
    
    public void setDepHost(final DeploymentHost pDepHost) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fDepHost = pDepHost;
    }
    
    @Override
    public String patternName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.appInstanceWithDepHost";
    }
    
    @Override
    public List<String> parameterNames() {
      return AppInstanceWithDepHost.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fAppInstance, fDepHost};
    }
    
    @Override
    public AppInstanceWithDepHost.Match toImmutable() {
      return isMutable() ? newMatch(fAppInstance, fDepHost) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"appInstance\"=" + prettyPrintValue(fAppInstance) + ", ");
      result.append("\"depHost\"=" + prettyPrintValue(fDepHost));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fAppInstance, fDepHost);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof AppInstanceWithDepHost.Match)) {
          AppInstanceWithDepHost.Match other = (AppInstanceWithDepHost.Match) obj;
          return Objects.equals(fAppInstance, other.fAppInstance) && Objects.equals(fDepHost, other.fDepHost);
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
    public AppInstanceWithDepHost specification() {
      return AppInstanceWithDepHost.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static AppInstanceWithDepHost.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pDepHost the fixed value of pattern parameter depHost, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static AppInstanceWithDepHost.Match newMutableMatch(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost) {
      return new Mutable(pAppInstance, pDepHost);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pDepHost the fixed value of pattern parameter depHost, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static AppInstanceWithDepHost.Match newMatch(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost) {
      return new Immutable(pAppInstance, pDepHost);
    }
    
    private static final class Mutable extends AppInstanceWithDepHost.Match {
      Mutable(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost) {
        super(pAppInstance, pDepHost);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends AppInstanceWithDepHost.Match {
      Immutable(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost) {
        super(pAppInstance, pDepHost);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.appInstanceWithDepHost pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * AppInstance Rule Patterns (Spec 2) 
   * 
   * pattern appInstanceWithDepHost(appInstance : ApplicationInstance, depHost : DeploymentHost) {
   *     HostInstance.applications(hostInstance, appInstance);
   *     find cps2depTrace(_, _, hostInstance, depHost);
   *     neg CPS2DeploymentTrace.cpsElements(_,appInstance);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see AppInstanceWithDepHost
   * 
   */
  public static class Matcher extends BaseMatcher<AppInstanceWithDepHost.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static AppInstanceWithDepHost.Matcher on(final ViatraQueryEngine engine) {
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
    public static AppInstanceWithDepHost.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_APPINSTANCE = 0;
    
    private static final int POSITION_DEPHOST = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(AppInstanceWithDepHost.Matcher.class);
    
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
     * @param pDepHost the fixed value of pattern parameter depHost, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<AppInstanceWithDepHost.Match> getAllMatches(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost) {
      return rawStreamAllMatches(new Object[]{pAppInstance, pDepHost}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pDepHost the fixed value of pattern parameter depHost, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<AppInstanceWithDepHost.Match> streamAllMatches(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost) {
      return rawStreamAllMatches(new Object[]{pAppInstance, pDepHost});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pDepHost the fixed value of pattern parameter depHost, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<AppInstanceWithDepHost.Match> getOneArbitraryMatch(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost) {
      return rawGetOneArbitraryMatch(new Object[]{pAppInstance, pDepHost});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pDepHost the fixed value of pattern parameter depHost, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost) {
      return rawHasMatch(new Object[]{pAppInstance, pDepHost});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pDepHost the fixed value of pattern parameter depHost, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost) {
      return rawCountMatches(new Object[]{pAppInstance, pDepHost});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pDepHost the fixed value of pattern parameter depHost, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost, final Consumer<? super AppInstanceWithDepHost.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pAppInstance, pDepHost}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pDepHost the fixed value of pattern parameter depHost, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public AppInstanceWithDepHost.Match newMatch(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost) {
      return AppInstanceWithDepHost.Match.newMatch(pAppInstance, pDepHost);
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
    public Stream<ApplicationInstance> streamAllValuesOfappInstance(final AppInstanceWithDepHost.Match partialMatch) {
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
    public Stream<ApplicationInstance> streamAllValuesOfappInstance(final DeploymentHost pDepHost) {
      return rawStreamAllValuesOfappInstance(new Object[]{null, pDepHost});
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationInstance> getAllValuesOfappInstance(final AppInstanceWithDepHost.Match partialMatch) {
      return rawStreamAllValuesOfappInstance(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationInstance> getAllValuesOfappInstance(final DeploymentHost pDepHost) {
      return rawStreamAllValuesOfappInstance(new Object[]{null, pDepHost}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depHost.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<DeploymentHost> rawStreamAllValuesOfdepHost(final Object[] parameters) {
      return rawStreamAllValues(POSITION_DEPHOST, parameters).map(DeploymentHost.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for depHost.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DeploymentHost> getAllValuesOfdepHost() {
      return rawStreamAllValuesOfdepHost(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depHost.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<DeploymentHost> streamAllValuesOfdepHost() {
      return rawStreamAllValuesOfdepHost(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depHost.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<DeploymentHost> streamAllValuesOfdepHost(final AppInstanceWithDepHost.Match partialMatch) {
      return rawStreamAllValuesOfdepHost(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depHost.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<DeploymentHost> streamAllValuesOfdepHost(final ApplicationInstance pAppInstance) {
      return rawStreamAllValuesOfdepHost(new Object[]{pAppInstance, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for depHost.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DeploymentHost> getAllValuesOfdepHost(final AppInstanceWithDepHost.Match partialMatch) {
      return rawStreamAllValuesOfdepHost(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depHost.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DeploymentHost> getAllValuesOfdepHost(final ApplicationInstance pAppInstance) {
      return rawStreamAllValuesOfdepHost(new Object[]{pAppInstance, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected AppInstanceWithDepHost.Match tupleToMatch(final Tuple t) {
      try {
          return AppInstanceWithDepHost.Match.newMatch((ApplicationInstance) t.get(POSITION_APPINSTANCE), (DeploymentHost) t.get(POSITION_DEPHOST));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected AppInstanceWithDepHost.Match arrayToMatch(final Object[] match) {
      try {
          return AppInstanceWithDepHost.Match.newMatch((ApplicationInstance) match[POSITION_APPINSTANCE], (DeploymentHost) match[POSITION_DEPHOST]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected AppInstanceWithDepHost.Match arrayToMatchMutable(final Object[] match) {
      try {
          return AppInstanceWithDepHost.Match.newMutableMatch((ApplicationInstance) match[POSITION_APPINSTANCE], (DeploymentHost) match[POSITION_DEPHOST]);
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
    public static IQuerySpecification<AppInstanceWithDepHost.Matcher> querySpecification() {
      return AppInstanceWithDepHost.instance();
    }
  }
  
  private AppInstanceWithDepHost() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static AppInstanceWithDepHost instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected AppInstanceWithDepHost.Matcher instantiate(final ViatraQueryEngine engine) {
    return AppInstanceWithDepHost.Matcher.on(engine);
  }
  
  @Override
  public AppInstanceWithDepHost.Matcher instantiate() {
    return AppInstanceWithDepHost.Matcher.create();
  }
  
  @Override
  public AppInstanceWithDepHost.Match newEmptyMatch() {
    return AppInstanceWithDepHost.Match.newEmptyMatch();
  }
  
  @Override
  public AppInstanceWithDepHost.Match newMatch(final Object... parameters) {
    return AppInstanceWithDepHost.Match.newMatch((org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance) parameters[0], (org.eclipse.viatra.examples.cps.deployment.DeploymentHost) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceWithDepHost (visibility: PUBLIC, simpleName: AppInstanceWithDepHost, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceWithDepHost, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceWithDepHost (visibility: PUBLIC, simpleName: AppInstanceWithDepHost, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceWithDepHost, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final AppInstanceWithDepHost INSTANCE = new AppInstanceWithDepHost();
    
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
    private static final AppInstanceWithDepHost.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_appInstance = new PParameter("appInstance", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "ApplicationInstance")), PParameterDirection.INOUT);
    
    private final PParameter parameter_depHost = new PParameter("depHost", "org.eclipse.viatra.examples.cps.deployment.DeploymentHost", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/deployment", "DeploymentHost")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_appInstance, parameter_depHost);
    
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
        //  CPS2DeploymentTrace.cpsElements(_,appInstance)
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
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.appInstanceWithDepHost";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("appInstance","depHost");
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
          PVariable var_depHost = body.getOrCreateVariableByName("depHost");
          PVariable var_hostInstance = body.getOrCreateVariableByName("hostInstance");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
          PVariable var___2_ = body.getOrCreateVariableByName("_<2>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_appInstance), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "ApplicationInstance")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_depHost), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "DeploymentHost")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_appInstance, parameter_appInstance),
             new ExportedParameter(body, var_depHost, parameter_depHost)
          ));
          //     HostInstance.applications(hostInstance, appInstance)
          new TypeConstraint(body, Tuples.flatTupleOf(var_hostInstance), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "HostInstance")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_hostInstance, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/cps", "HostInstance", "applications")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "ApplicationInstance")));
          new Equality(body, var__virtual_0_, var_appInstance);
          //     find cps2depTrace(_, _, hostInstance, depHost)
          new PositivePatternCall(body, Tuples.flatTupleOf(var___0_, var___1_, var_hostInstance, var_depHost), Cps2depTrace.instance().getInternalQueryRepresentation());
          //     neg CPS2DeploymentTrace.cpsElements(_,appInstance)
          new NegativePatternCall(body, Tuples.flatTupleOf(var___2_, var_appInstance), new AppInstanceWithDepHost.GeneratedPQuery.Embedded_1_CPS2DeploymentTrace_cpsElements());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
