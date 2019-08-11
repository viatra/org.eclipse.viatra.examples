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
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance;
import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.Cps2depTrace;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Inequality;
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
 *         pattern changeAppId(appInstance : ApplicationInstance, depApp : DeploymentApplication) {
 *             find cps2depTrace(_,_,appInstance,depApp);
 *             ApplicationInstance.identifier(appInstance,appId);
 *             DeploymentApplication.id(depApp,depId);
 *             appId != depId;
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtext.xbase.compiler.JvmModelGenerator")
public final class ChangeAppId extends BaseGeneratedEMFQuerySpecification<ChangeAppId.Matcher> {
  /**
   * Pattern-specific match representation of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.changeAppId pattern,
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
    
    private DeploymentApplication fDepApp;
    
    private static List<String> parameterNames = makeImmutableList("appInstance", "depApp");
    
    private Match(final ApplicationInstance pAppInstance, final DeploymentApplication pDepApp) {
      this.fAppInstance = pAppInstance;
      this.fDepApp = pDepApp;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("appInstance".equals(parameterName)) return this.fAppInstance;
      if ("depApp".equals(parameterName)) return this.fDepApp;
      return null;
    }
    
    public ApplicationInstance getAppInstance() {
      return this.fAppInstance;
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
    
    public void setDepApp(final DeploymentApplication pDepApp) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fDepApp = pDepApp;
    }
    
    @Override
    public String patternName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.changeAppId";
    }
    
    @Override
    public List<String> parameterNames() {
      return ChangeAppId.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fAppInstance, fDepApp};
    }
    
    @Override
    public ChangeAppId.Match toImmutable() {
      return isMutable() ? newMatch(fAppInstance, fDepApp) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"appInstance\"=" + prettyPrintValue(fAppInstance) + ", ");
      result.append("\"depApp\"=" + prettyPrintValue(fDepApp));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fAppInstance, fDepApp);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof ChangeAppId.Match)) {
          ChangeAppId.Match other = (ChangeAppId.Match) obj;
          return Objects.equals(fAppInstance, other.fAppInstance) && Objects.equals(fDepApp, other.fDepApp);
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
    public ChangeAppId specification() {
      return ChangeAppId.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static ChangeAppId.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static ChangeAppId.Match newMutableMatch(final ApplicationInstance pAppInstance, final DeploymentApplication pDepApp) {
      return new Mutable(pAppInstance, pDepApp);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static ChangeAppId.Match newMatch(final ApplicationInstance pAppInstance, final DeploymentApplication pDepApp) {
      return new Immutable(pAppInstance, pDepApp);
    }
    
    private static final class Mutable extends ChangeAppId.Match {
      Mutable(final ApplicationInstance pAppInstance, final DeploymentApplication pDepApp) {
        super(pAppInstance, pDepApp);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends ChangeAppId.Match {
      Immutable(final ApplicationInstance pAppInstance, final DeploymentApplication pDepApp) {
        super(pAppInstance, pDepApp);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.changeAppId pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern changeAppId(appInstance : ApplicationInstance, depApp : DeploymentApplication) {
   *     find cps2depTrace(_,_,appInstance,depApp);
   *     ApplicationInstance.identifier(appInstance,appId);
   *     DeploymentApplication.id(depApp,depId);
   *     appId != depId;
   * }
   * </pre></code>
   * 
   * @see Match
   * @see ChangeAppId
   * 
   */
  public static class Matcher extends BaseMatcher<ChangeAppId.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static ChangeAppId.Matcher on(final ViatraQueryEngine engine) {
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
    public static ChangeAppId.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_APPINSTANCE = 0;
    
    private static final int POSITION_DEPAPP = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ChangeAppId.Matcher.class);
    
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
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<ChangeAppId.Match> getAllMatches(final ApplicationInstance pAppInstance, final DeploymentApplication pDepApp) {
      return rawStreamAllMatches(new Object[]{pAppInstance, pDepApp}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<ChangeAppId.Match> streamAllMatches(final ApplicationInstance pAppInstance, final DeploymentApplication pDepApp) {
      return rawStreamAllMatches(new Object[]{pAppInstance, pDepApp});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<ChangeAppId.Match> getOneArbitraryMatch(final ApplicationInstance pAppInstance, final DeploymentApplication pDepApp) {
      return rawGetOneArbitraryMatch(new Object[]{pAppInstance, pDepApp});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final ApplicationInstance pAppInstance, final DeploymentApplication pDepApp) {
      return rawHasMatch(new Object[]{pAppInstance, pDepApp});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final ApplicationInstance pAppInstance, final DeploymentApplication pDepApp) {
      return rawCountMatches(new Object[]{pAppInstance, pDepApp});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final ApplicationInstance pAppInstance, final DeploymentApplication pDepApp, final Consumer<? super ChangeAppId.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pAppInstance, pDepApp}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pAppInstance the fixed value of pattern parameter appInstance, or null if not bound.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public ChangeAppId.Match newMatch(final ApplicationInstance pAppInstance, final DeploymentApplication pDepApp) {
      return ChangeAppId.Match.newMatch(pAppInstance, pDepApp);
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
    public Stream<ApplicationInstance> streamAllValuesOfappInstance(final ChangeAppId.Match partialMatch) {
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
    public Stream<ApplicationInstance> streamAllValuesOfappInstance(final DeploymentApplication pDepApp) {
      return rawStreamAllValuesOfappInstance(new Object[]{null, pDepApp});
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationInstance> getAllValuesOfappInstance(final ChangeAppId.Match partialMatch) {
      return rawStreamAllValuesOfappInstance(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for appInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationInstance> getAllValuesOfappInstance(final DeploymentApplication pDepApp) {
      return rawStreamAllValuesOfappInstance(new Object[]{null, pDepApp}).collect(Collectors.toSet());
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
    public Stream<DeploymentApplication> streamAllValuesOfdepApp(final ChangeAppId.Match partialMatch) {
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
    public Stream<DeploymentApplication> streamAllValuesOfdepApp(final ApplicationInstance pAppInstance) {
      return rawStreamAllValuesOfdepApp(new Object[]{pAppInstance, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for depApp.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DeploymentApplication> getAllValuesOfdepApp(final ChangeAppId.Match partialMatch) {
      return rawStreamAllValuesOfdepApp(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depApp.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DeploymentApplication> getAllValuesOfdepApp(final ApplicationInstance pAppInstance) {
      return rawStreamAllValuesOfdepApp(new Object[]{pAppInstance, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected ChangeAppId.Match tupleToMatch(final Tuple t) {
      try {
          return ChangeAppId.Match.newMatch((ApplicationInstance) t.get(POSITION_APPINSTANCE), (DeploymentApplication) t.get(POSITION_DEPAPP));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected ChangeAppId.Match arrayToMatch(final Object[] match) {
      try {
          return ChangeAppId.Match.newMatch((ApplicationInstance) match[POSITION_APPINSTANCE], (DeploymentApplication) match[POSITION_DEPAPP]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected ChangeAppId.Match arrayToMatchMutable(final Object[] match) {
      try {
          return ChangeAppId.Match.newMutableMatch((ApplicationInstance) match[POSITION_APPINSTANCE], (DeploymentApplication) match[POSITION_DEPAPP]);
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
    public static IQuerySpecification<ChangeAppId.Matcher> querySpecification() {
      return ChangeAppId.instance();
    }
  }
  
  private ChangeAppId() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static ChangeAppId instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected ChangeAppId.Matcher instantiate(final ViatraQueryEngine engine) {
    return ChangeAppId.Matcher.on(engine);
  }
  
  @Override
  public ChangeAppId.Matcher instantiate() {
    return ChangeAppId.Matcher.create();
  }
  
  @Override
  public ChangeAppId.Match newEmptyMatch() {
    return ChangeAppId.Match.newEmptyMatch();
  }
  
  @Override
  public ChangeAppId.Match newMatch(final Object... parameters) {
    return ChangeAppId.Match.newMatch((org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance) parameters[0], (org.eclipse.viatra.examples.cps.deployment.DeploymentApplication) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.ChangeAppId (visibility: PUBLIC, simpleName: ChangeAppId, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.ChangeAppId, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.ChangeAppId (visibility: PUBLIC, simpleName: ChangeAppId, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.ChangeAppId, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final ChangeAppId INSTANCE = new ChangeAppId();
    
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
    private static final ChangeAppId.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_appInstance = new PParameter("appInstance", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "ApplicationInstance")), PParameterDirection.INOUT);
    
    private final PParameter parameter_depApp = new PParameter("depApp", "org.eclipse.viatra.examples.cps.deployment.DeploymentApplication", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/deployment", "DeploymentApplication")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_appInstance, parameter_depApp);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.changeAppId";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("appInstance","depApp");
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
          PVariable var_depApp = body.getOrCreateVariableByName("depApp");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
          PVariable var_appId = body.getOrCreateVariableByName("appId");
          PVariable var_depId = body.getOrCreateVariableByName("depId");
          new TypeConstraint(body, Tuples.flatTupleOf(var_appInstance), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "ApplicationInstance")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_depApp), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "DeploymentApplication")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_appInstance, parameter_appInstance),
             new ExportedParameter(body, var_depApp, parameter_depApp)
          ));
          //     find cps2depTrace(_,_,appInstance,depApp)
          new PositivePatternCall(body, Tuples.flatTupleOf(var___0_, var___1_, var_appInstance, var_depApp), Cps2depTrace.instance().getInternalQueryRepresentation());
          //     ApplicationInstance.identifier(appInstance,appId)
          new TypeConstraint(body, Tuples.flatTupleOf(var_appInstance), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "ApplicationInstance")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_appInstance, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/cps", "Identifiable", "identifier")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_0_, var_appId);
          //     DeploymentApplication.id(depApp,depId)
          new TypeConstraint(body, Tuples.flatTupleOf(var_depApp), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "DeploymentApplication")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_depApp, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/deployment", "DeploymentApplication", "id")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_1_, var_depId);
          //     appId != depId
          new Inequality(body, var_appId, var_depId);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
