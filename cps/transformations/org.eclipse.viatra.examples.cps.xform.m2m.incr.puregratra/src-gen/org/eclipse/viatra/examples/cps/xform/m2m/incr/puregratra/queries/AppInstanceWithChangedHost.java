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
import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication;
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
 *         pattern appInstanceWithChangedHost(appInstance : ApplicationInstance, depHost1 : DeploymentHost, depHost2 : DeploymentHost, depApp : DeploymentApplication) {
 *             find cps2depTrace(_,_,appInstance,depApp);
 *             DeploymentHost.applications(depHost1,depApp);
 *             find cps2depTrace(_,_,hostInstance1,depHost1);
 *             neg HostInstance.applications(hostInstance1,appInstance);
 *             HostInstance.applications(hostInstance2,appInstance);
 *             find cps2depTrace(_,_,hostInstance2,depHost2);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtext.xbase.compiler.JvmModelGenerator")
public final class AppInstanceWithChangedHost extends BaseGeneratedEMFQuerySpecification<AppInstanceWithChangedHost.Matcher> {
  /**
   * Pattern-specific match representation of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.appInstanceWithChangedHost pattern,
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
    
    private DeploymentHost fDepHost1;
    
    private DeploymentHost fDepHost2;
    
    private DeploymentApplication fDepApp;
    
    private static List<String> parameterNames = makeImmutableList("appInstance", "depHost1", "depHost2", "depApp");
    
    private Match(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost1, final DeploymentHost pDepHost2, final DeploymentApplication pDepApp) {
      this.fAppInstance = pAppInstance;
      this.fDepHost1 = pDepHost1;
      this.fDepHost2 = pDepHost2;
      this.fDepApp = pDepApp;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("appInstance".equals(parameterName)) return this.fAppInstance;
      if ("depHost1".equals(parameterName)) return this.fDepHost1;
      if ("depHost2".equals(parameterName)) return this.fDepHost2;
      if ("depApp".equals(parameterName)) return this.fDepApp;
      return null;
    }
    
    public ApplicationInstance getAppInstance() {
      return this.fAppInstance;
    }
    
    public DeploymentHost getDepHost1() {
      return this.fDepHost1;
    }
    
    public DeploymentHost getDepHost2() {
      return this.fDepHost2;
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
      if ("depHost1".equals(parameterName) ) {
          this.fDepHost1 = (DeploymentHost) newValue;
          return true;
      }
      if ("depHost2".equals(parameterName) ) {
          this.fDepHost2 = (DeploymentHost) newValue;
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
    
    public void setDepHost1(final DeploymentHost pDepHost1) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fDepHost1 = pDepHost1;
    }
    
    public void setDepHost2(final DeploymentHost pDepHost2) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fDepHost2 = pDepHost2;
    }
    
    public void setDepApp(final DeploymentApplication pDepApp) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fDepApp = pDepApp;
    }
    
    @Override
    public String patternName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.appInstanceWithChangedHost";
    }
    
    @Override
    public List<String> parameterNames() {
      return AppInstanceWithChangedHost.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fAppInstance, fDepHost1, fDepHost2, fDepApp};
    }
    
    @Override
    public AppInstanceWithChangedHost.Match toImmutable() {
      return isMutable() ? newMatch(fAppInstance, fDepHost1, fDepHost2, fDepApp) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"appInstance\"=" + prettyPrintValue(fAppInstance) + ", ");
      result.append("\"depHost1\"=" + prettyPrintValue(fDepHost1) + ", ");
      result.append("\"depHost2\"=" + prettyPrintValue(fDepHost2) + ", ");
      result.append("\"depApp\"=" + prettyPrintValue(fDepApp));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fAppInstance, fDepHost1, fDepHost2, fDepApp);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof AppInstanceWithChangedHost.Match)) {
          AppInstanceWithChangedHost.Match other = (AppInstanceWithChangedHost.Match) obj;
          return Objects.equals(fAppInstance, other.fAppInstance) && Objects.equals(fDepHost1, other.fDepHost1) && Objects.equals(fDepHost2, other.fDepHost2) && Objects.equals(fDepApp, other.fDepApp);
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
    public AppInstanceWithChangedHost specification() {
      return AppInstanceWithChangedHost.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static AppInstanceWithChangedHost.Match newEmptyMatch() {
      return new Mutable(null, null, null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pDepHost1 the fixed value of pattern parameter depHost1, or null if not bound.
     * @param pDepHost2 the fixed value of pattern parameter depHost2, or null if not bound.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static AppInstanceWithChangedHost.Match newMutableMatch(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost1, final DeploymentHost pDepHost2, final DeploymentApplication pDepApp) {
      return new Mutable(pAppInstance, pDepHost1, pDepHost2, pDepApp);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pDepHost1 the fixed value of pattern parameter depHost1, or null if not bound.
     * @param pDepHost2 the fixed value of pattern parameter depHost2, or null if not bound.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static AppInstanceWithChangedHost.Match newMatch(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost1, final DeploymentHost pDepHost2, final DeploymentApplication pDepApp) {
      return new Immutable(pAppInstance, pDepHost1, pDepHost2, pDepApp);
    }
    
    private static final class Mutable extends AppInstanceWithChangedHost.Match {
      Mutable(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost1, final DeploymentHost pDepHost2, final DeploymentApplication pDepApp) {
        super(pAppInstance, pDepHost1, pDepHost2, pDepApp);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends AppInstanceWithChangedHost.Match {
      Immutable(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost1, final DeploymentHost pDepHost2, final DeploymentApplication pDepApp) {
        super(pAppInstance, pDepHost1, pDepHost2, pDepApp);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.appInstanceWithChangedHost pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern appInstanceWithChangedHost(appInstance : ApplicationInstance, depHost1 : DeploymentHost, depHost2 : DeploymentHost, depApp : DeploymentApplication) {
   *     find cps2depTrace(_,_,appInstance,depApp);
   *     DeploymentHost.applications(depHost1,depApp);
   *     find cps2depTrace(_,_,hostInstance1,depHost1);
   *     neg HostInstance.applications(hostInstance1,appInstance);
   *     HostInstance.applications(hostInstance2,appInstance);
   *     find cps2depTrace(_,_,hostInstance2,depHost2);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see AppInstanceWithChangedHost
   * 
   */
  public static class Matcher extends BaseMatcher<AppInstanceWithChangedHost.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static AppInstanceWithChangedHost.Matcher on(final ViatraQueryEngine engine) {
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
    public static AppInstanceWithChangedHost.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_APPINSTANCE = 0;
    
    private static final int POSITION_DEPHOST1 = 1;
    
    private static final int POSITION_DEPHOST2 = 2;
    
    private static final int POSITION_DEPAPP = 3;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(AppInstanceWithChangedHost.Matcher.class);
    
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
     * @param pDepHost1 the fixed value of pattern parameter depHost1, or null if not bound.
     * @param pDepHost2 the fixed value of pattern parameter depHost2, or null if not bound.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<AppInstanceWithChangedHost.Match> getAllMatches(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost1, final DeploymentHost pDepHost2, final DeploymentApplication pDepApp) {
      return rawStreamAllMatches(new Object[]{pAppInstance, pDepHost1, pDepHost2, pDepApp}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pDepHost1 the fixed value of pattern parameter depHost1, or null if not bound.
     * @param pDepHost2 the fixed value of pattern parameter depHost2, or null if not bound.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<AppInstanceWithChangedHost.Match> streamAllMatches(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost1, final DeploymentHost pDepHost2, final DeploymentApplication pDepApp) {
      return rawStreamAllMatches(new Object[]{pAppInstance, pDepHost1, pDepHost2, pDepApp});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pDepHost1 the fixed value of pattern parameter depHost1, or null if not bound.
     * @param pDepHost2 the fixed value of pattern parameter depHost2, or null if not bound.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<AppInstanceWithChangedHost.Match> getOneArbitraryMatch(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost1, final DeploymentHost pDepHost2, final DeploymentApplication pDepApp) {
      return rawGetOneArbitraryMatch(new Object[]{pAppInstance, pDepHost1, pDepHost2, pDepApp});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pDepHost1 the fixed value of pattern parameter depHost1, or null if not bound.
     * @param pDepHost2 the fixed value of pattern parameter depHost2, or null if not bound.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost1, final DeploymentHost pDepHost2, final DeploymentApplication pDepApp) {
      return rawHasMatch(new Object[]{pAppInstance, pDepHost1, pDepHost2, pDepApp});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pDepHost1 the fixed value of pattern parameter depHost1, or null if not bound.
     * @param pDepHost2 the fixed value of pattern parameter depHost2, or null if not bound.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost1, final DeploymentHost pDepHost2, final DeploymentApplication pDepApp) {
      return rawCountMatches(new Object[]{pAppInstance, pDepHost1, pDepHost2, pDepApp});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pDepHost1 the fixed value of pattern parameter depHost1, or null if not bound.
     * @param pDepHost2 the fixed value of pattern parameter depHost2, or null if not bound.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost1, final DeploymentHost pDepHost2, final DeploymentApplication pDepApp, final Consumer<? super AppInstanceWithChangedHost.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pAppInstance, pDepHost1, pDepHost2, pDepApp}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pDepHost1 the fixed value of pattern parameter depHost1, or null if not bound.
     * @param pDepHost2 the fixed value of pattern parameter depHost2, or null if not bound.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public AppInstanceWithChangedHost.Match newMatch(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost1, final DeploymentHost pDepHost2, final DeploymentApplication pDepApp) {
      return AppInstanceWithChangedHost.Match.newMatch(pAppInstance, pDepHost1, pDepHost2, pDepApp);
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
    public Stream<ApplicationInstance> streamAllValuesOfappInstance(final AppInstanceWithChangedHost.Match partialMatch) {
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
    public Stream<ApplicationInstance> streamAllValuesOfappInstance(final DeploymentHost pDepHost1, final DeploymentHost pDepHost2, final DeploymentApplication pDepApp) {
      return rawStreamAllValuesOfappInstance(new Object[]{null, pDepHost1, pDepHost2, pDepApp});
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationInstance> getAllValuesOfappInstance(final AppInstanceWithChangedHost.Match partialMatch) {
      return rawStreamAllValuesOfappInstance(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationInstance> getAllValuesOfappInstance(final DeploymentHost pDepHost1, final DeploymentHost pDepHost2, final DeploymentApplication pDepApp) {
      return rawStreamAllValuesOfappInstance(new Object[]{null, pDepHost1, pDepHost2, pDepApp}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depHost1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<DeploymentHost> rawStreamAllValuesOfdepHost1(final Object[] parameters) {
      return rawStreamAllValues(POSITION_DEPHOST1, parameters).map(DeploymentHost.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for depHost1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DeploymentHost> getAllValuesOfdepHost1() {
      return rawStreamAllValuesOfdepHost1(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depHost1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<DeploymentHost> streamAllValuesOfdepHost1() {
      return rawStreamAllValuesOfdepHost1(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depHost1.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<DeploymentHost> streamAllValuesOfdepHost1(final AppInstanceWithChangedHost.Match partialMatch) {
      return rawStreamAllValuesOfdepHost1(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depHost1.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<DeploymentHost> streamAllValuesOfdepHost1(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost2, final DeploymentApplication pDepApp) {
      return rawStreamAllValuesOfdepHost1(new Object[]{pAppInstance, null, pDepHost2, pDepApp});
    }
    
    /**
     * Retrieve the set of values that occur in matches for depHost1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DeploymentHost> getAllValuesOfdepHost1(final AppInstanceWithChangedHost.Match partialMatch) {
      return rawStreamAllValuesOfdepHost1(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depHost1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DeploymentHost> getAllValuesOfdepHost1(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost2, final DeploymentApplication pDepApp) {
      return rawStreamAllValuesOfdepHost1(new Object[]{pAppInstance, null, pDepHost2, pDepApp}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depHost2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<DeploymentHost> rawStreamAllValuesOfdepHost2(final Object[] parameters) {
      return rawStreamAllValues(POSITION_DEPHOST2, parameters).map(DeploymentHost.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for depHost2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DeploymentHost> getAllValuesOfdepHost2() {
      return rawStreamAllValuesOfdepHost2(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depHost2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<DeploymentHost> streamAllValuesOfdepHost2() {
      return rawStreamAllValuesOfdepHost2(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depHost2.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<DeploymentHost> streamAllValuesOfdepHost2(final AppInstanceWithChangedHost.Match partialMatch) {
      return rawStreamAllValuesOfdepHost2(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depHost2.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<DeploymentHost> streamAllValuesOfdepHost2(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost1, final DeploymentApplication pDepApp) {
      return rawStreamAllValuesOfdepHost2(new Object[]{pAppInstance, pDepHost1, null, pDepApp});
    }
    
    /**
     * Retrieve the set of values that occur in matches for depHost2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DeploymentHost> getAllValuesOfdepHost2(final AppInstanceWithChangedHost.Match partialMatch) {
      return rawStreamAllValuesOfdepHost2(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depHost2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DeploymentHost> getAllValuesOfdepHost2(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost1, final DeploymentApplication pDepApp) {
      return rawStreamAllValuesOfdepHost2(new Object[]{pAppInstance, pDepHost1, null, pDepApp}).collect(Collectors.toSet());
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
    public Stream<DeploymentApplication> streamAllValuesOfdepApp(final AppInstanceWithChangedHost.Match partialMatch) {
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
    public Stream<DeploymentApplication> streamAllValuesOfdepApp(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost1, final DeploymentHost pDepHost2) {
      return rawStreamAllValuesOfdepApp(new Object[]{pAppInstance, pDepHost1, pDepHost2, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for depApp.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DeploymentApplication> getAllValuesOfdepApp(final AppInstanceWithChangedHost.Match partialMatch) {
      return rawStreamAllValuesOfdepApp(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depApp.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DeploymentApplication> getAllValuesOfdepApp(final ApplicationInstance pAppInstance, final DeploymentHost pDepHost1, final DeploymentHost pDepHost2) {
      return rawStreamAllValuesOfdepApp(new Object[]{pAppInstance, pDepHost1, pDepHost2, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected AppInstanceWithChangedHost.Match tupleToMatch(final Tuple t) {
      try {
          return AppInstanceWithChangedHost.Match.newMatch((ApplicationInstance) t.get(POSITION_APPINSTANCE), (DeploymentHost) t.get(POSITION_DEPHOST1), (DeploymentHost) t.get(POSITION_DEPHOST2), (DeploymentApplication) t.get(POSITION_DEPAPP));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected AppInstanceWithChangedHost.Match arrayToMatch(final Object[] match) {
      try {
          return AppInstanceWithChangedHost.Match.newMatch((ApplicationInstance) match[POSITION_APPINSTANCE], (DeploymentHost) match[POSITION_DEPHOST1], (DeploymentHost) match[POSITION_DEPHOST2], (DeploymentApplication) match[POSITION_DEPAPP]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected AppInstanceWithChangedHost.Match arrayToMatchMutable(final Object[] match) {
      try {
          return AppInstanceWithChangedHost.Match.newMutableMatch((ApplicationInstance) match[POSITION_APPINSTANCE], (DeploymentHost) match[POSITION_DEPHOST1], (DeploymentHost) match[POSITION_DEPHOST2], (DeploymentApplication) match[POSITION_DEPAPP]);
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
    public static IQuerySpecification<AppInstanceWithChangedHost.Matcher> querySpecification() {
      return AppInstanceWithChangedHost.instance();
    }
  }
  
  private AppInstanceWithChangedHost() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static AppInstanceWithChangedHost instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected AppInstanceWithChangedHost.Matcher instantiate(final ViatraQueryEngine engine) {
    return AppInstanceWithChangedHost.Matcher.on(engine);
  }
  
  @Override
  public AppInstanceWithChangedHost.Matcher instantiate() {
    return AppInstanceWithChangedHost.Matcher.create();
  }
  
  @Override
  public AppInstanceWithChangedHost.Match newEmptyMatch() {
    return AppInstanceWithChangedHost.Match.newEmptyMatch();
  }
  
  @Override
  public AppInstanceWithChangedHost.Match newMatch(final Object... parameters) {
    return AppInstanceWithChangedHost.Match.newMatch((org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance) parameters[0], (org.eclipse.viatra.examples.cps.deployment.DeploymentHost) parameters[1], (org.eclipse.viatra.examples.cps.deployment.DeploymentHost) parameters[2], (org.eclipse.viatra.examples.cps.deployment.DeploymentApplication) parameters[3]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceWithChangedHost (visibility: PUBLIC, simpleName: AppInstanceWithChangedHost, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceWithChangedHost, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceWithChangedHost (visibility: PUBLIC, simpleName: AppInstanceWithChangedHost, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.AppInstanceWithChangedHost, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final AppInstanceWithChangedHost INSTANCE = new AppInstanceWithChangedHost();
    
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
    private static final AppInstanceWithChangedHost.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_appInstance = new PParameter("appInstance", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "ApplicationInstance")), PParameterDirection.INOUT);
    
    private final PParameter parameter_depHost1 = new PParameter("depHost1", "org.eclipse.viatra.examples.cps.deployment.DeploymentHost", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/deployment", "DeploymentHost")), PParameterDirection.INOUT);
    
    private final PParameter parameter_depHost2 = new PParameter("depHost2", "org.eclipse.viatra.examples.cps.deployment.DeploymentHost", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/deployment", "DeploymentHost")), PParameterDirection.INOUT);
    
    private final PParameter parameter_depApp = new PParameter("depApp", "org.eclipse.viatra.examples.cps.deployment.DeploymentApplication", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/deployment", "DeploymentApplication")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_appInstance, parameter_depHost1, parameter_depHost2, parameter_depApp);
    
    private class Embedded_1_HostInstance_applications extends BaseGeneratedEMFPQuery {
      private final PParameter parameter_p0 = new PParameter("p0", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "HostInstance")), PParameterDirection.INOUT);
      
      private final PParameter parameter_p1 = new PParameter("p1", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "ApplicationInstance")), PParameterDirection.INOUT);
      
      private final List<PParameter> embeddedParameters = Arrays.asList(parameter_p0, parameter_p1);
      
      public Embedded_1_HostInstance_applications() {
        super(PVisibility.EMBEDDED);
      }
      
      @Override
      public String getFullyQualifiedName() {
        return GeneratedPQuery.this.getFullyQualifiedName() + "$Embedded_1_HostInstance_applications";
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
        //  HostInstance.applications(hostInstance1,appInstance)
        new TypeConstraint(body, Tuples.flatTupleOf(var_p0), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "HostInstance")));
        PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
        new TypeConstraint(body, Tuples.flatTupleOf(var_p0, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/cps", "HostInstance", "applications")));
        new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "ApplicationInstance")));
        new Equality(body, var__virtual_0_, var_p1);
        return Collections.singleton(body);
      }
    }
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.appInstanceWithChangedHost";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("appInstance","depHost1","depHost2","depApp");
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
          PVariable var_depHost1 = body.getOrCreateVariableByName("depHost1");
          PVariable var_depHost2 = body.getOrCreateVariableByName("depHost2");
          PVariable var_depApp = body.getOrCreateVariableByName("depApp");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
          PVariable var___2_ = body.getOrCreateVariableByName("_<2>");
          PVariable var___3_ = body.getOrCreateVariableByName("_<3>");
          PVariable var_hostInstance1 = body.getOrCreateVariableByName("hostInstance1");
          PVariable var_hostInstance2 = body.getOrCreateVariableByName("hostInstance2");
          PVariable var___4_ = body.getOrCreateVariableByName("_<4>");
          PVariable var___5_ = body.getOrCreateVariableByName("_<5>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_appInstance), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "ApplicationInstance")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_depHost1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "DeploymentHost")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_depHost2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "DeploymentHost")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_depApp), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "DeploymentApplication")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_appInstance, parameter_appInstance),
             new ExportedParameter(body, var_depHost1, parameter_depHost1),
             new ExportedParameter(body, var_depHost2, parameter_depHost2),
             new ExportedParameter(body, var_depApp, parameter_depApp)
          ));
          //     find cps2depTrace(_,_,appInstance,depApp)
          new PositivePatternCall(body, Tuples.flatTupleOf(var___0_, var___1_, var_appInstance, var_depApp), Cps2depTrace.instance().getInternalQueryRepresentation());
          //     DeploymentHost.applications(depHost1,depApp)
          new TypeConstraint(body, Tuples.flatTupleOf(var_depHost1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "DeploymentHost")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_depHost1, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/deployment", "DeploymentHost", "applications")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "DeploymentApplication")));
          new Equality(body, var__virtual_0_, var_depApp);
          //     find cps2depTrace(_,_,hostInstance1,depHost1)
          new PositivePatternCall(body, Tuples.flatTupleOf(var___2_, var___3_, var_hostInstance1, var_depHost1), Cps2depTrace.instance().getInternalQueryRepresentation());
          //     neg HostInstance.applications(hostInstance1,appInstance)
          new NegativePatternCall(body, Tuples.flatTupleOf(var_hostInstance1, var_appInstance), new AppInstanceWithChangedHost.GeneratedPQuery.Embedded_1_HostInstance_applications());
          //     HostInstance.applications(hostInstance2,appInstance)
          new TypeConstraint(body, Tuples.flatTupleOf(var_hostInstance2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "HostInstance")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_hostInstance2, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/cps", "HostInstance", "applications")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "ApplicationInstance")));
          new Equality(body, var__virtual_1_, var_appInstance);
          //     find cps2depTrace(_,_,hostInstance2,depHost2)
          new PositivePatternCall(body, Tuples.flatTupleOf(var___4_, var___5_, var_hostInstance2, var_depHost2), Cps2depTrace.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
