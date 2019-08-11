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
import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
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
 *         pattern missingAppInstance(depApp : DeploymentApplication, trace : CPS2DeploymentTrace) {
 *             CPS2DeploymentTrace.deploymentElements(trace,depApp);
 *             neg find cps2depTrace(_, trace, _, depApp);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtext.xbase.compiler.JvmModelGenerator")
public final class MissingAppInstance extends BaseGeneratedEMFQuerySpecification<MissingAppInstance.Matcher> {
  /**
   * Pattern-specific match representation of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.missingAppInstance pattern,
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
    private DeploymentApplication fDepApp;
    
    private CPS2DeploymentTrace fTrace;
    
    private static List<String> parameterNames = makeImmutableList("depApp", "trace");
    
    private Match(final DeploymentApplication pDepApp, final CPS2DeploymentTrace pTrace) {
      this.fDepApp = pDepApp;
      this.fTrace = pTrace;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("depApp".equals(parameterName)) return this.fDepApp;
      if ("trace".equals(parameterName)) return this.fTrace;
      return null;
    }
    
    public DeploymentApplication getDepApp() {
      return this.fDepApp;
    }
    
    public CPS2DeploymentTrace getTrace() {
      return this.fTrace;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("depApp".equals(parameterName) ) {
          this.fDepApp = (DeploymentApplication) newValue;
          return true;
      }
      if ("trace".equals(parameterName) ) {
          this.fTrace = (CPS2DeploymentTrace) newValue;
          return true;
      }
      return false;
    }
    
    public void setDepApp(final DeploymentApplication pDepApp) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fDepApp = pDepApp;
    }
    
    public void setTrace(final CPS2DeploymentTrace pTrace) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTrace = pTrace;
    }
    
    @Override
    public String patternName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.missingAppInstance";
    }
    
    @Override
    public List<String> parameterNames() {
      return MissingAppInstance.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fDepApp, fTrace};
    }
    
    @Override
    public MissingAppInstance.Match toImmutable() {
      return isMutable() ? newMatch(fDepApp, fTrace) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"depApp\"=" + prettyPrintValue(fDepApp) + ", ");
      result.append("\"trace\"=" + prettyPrintValue(fTrace));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fDepApp, fTrace);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof MissingAppInstance.Match)) {
          MissingAppInstance.Match other = (MissingAppInstance.Match) obj;
          return Objects.equals(fDepApp, other.fDepApp) && Objects.equals(fTrace, other.fTrace);
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
    public MissingAppInstance specification() {
      return MissingAppInstance.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static MissingAppInstance.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static MissingAppInstance.Match newMutableMatch(final DeploymentApplication pDepApp, final CPS2DeploymentTrace pTrace) {
      return new Mutable(pDepApp, pTrace);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static MissingAppInstance.Match newMatch(final DeploymentApplication pDepApp, final CPS2DeploymentTrace pTrace) {
      return new Immutable(pDepApp, pTrace);
    }
    
    private static final class Mutable extends MissingAppInstance.Match {
      Mutable(final DeploymentApplication pDepApp, final CPS2DeploymentTrace pTrace) {
        super(pDepApp, pTrace);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends MissingAppInstance.Match {
      Immutable(final DeploymentApplication pDepApp, final CPS2DeploymentTrace pTrace) {
        super(pDepApp, pTrace);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.missingAppInstance pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern missingAppInstance(depApp : DeploymentApplication, trace : CPS2DeploymentTrace) {
   *     CPS2DeploymentTrace.deploymentElements(trace,depApp);
   *     neg find cps2depTrace(_, trace, _, depApp);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see MissingAppInstance
   * 
   */
  public static class Matcher extends BaseMatcher<MissingAppInstance.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static MissingAppInstance.Matcher on(final ViatraQueryEngine engine) {
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
    public static MissingAppInstance.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_DEPAPP = 0;
    
    private static final int POSITION_TRACE = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(MissingAppInstance.Matcher.class);
    
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
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<MissingAppInstance.Match> getAllMatches(final DeploymentApplication pDepApp, final CPS2DeploymentTrace pTrace) {
      return rawStreamAllMatches(new Object[]{pDepApp, pTrace}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<MissingAppInstance.Match> streamAllMatches(final DeploymentApplication pDepApp, final CPS2DeploymentTrace pTrace) {
      return rawStreamAllMatches(new Object[]{pDepApp, pTrace});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<MissingAppInstance.Match> getOneArbitraryMatch(final DeploymentApplication pDepApp, final CPS2DeploymentTrace pTrace) {
      return rawGetOneArbitraryMatch(new Object[]{pDepApp, pTrace});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final DeploymentApplication pDepApp, final CPS2DeploymentTrace pTrace) {
      return rawHasMatch(new Object[]{pDepApp, pTrace});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final DeploymentApplication pDepApp, final CPS2DeploymentTrace pTrace) {
      return rawCountMatches(new Object[]{pDepApp, pTrace});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final DeploymentApplication pDepApp, final CPS2DeploymentTrace pTrace, final Consumer<? super MissingAppInstance.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pDepApp, pTrace}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pDepApp the fixed value of pattern parameter depApp, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public MissingAppInstance.Match newMatch(final DeploymentApplication pDepApp, final CPS2DeploymentTrace pTrace) {
      return MissingAppInstance.Match.newMatch(pDepApp, pTrace);
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
    public Stream<DeploymentApplication> streamAllValuesOfdepApp(final MissingAppInstance.Match partialMatch) {
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
    public Stream<DeploymentApplication> streamAllValuesOfdepApp(final CPS2DeploymentTrace pTrace) {
      return rawStreamAllValuesOfdepApp(new Object[]{null, pTrace});
    }
    
    /**
     * Retrieve the set of values that occur in matches for depApp.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DeploymentApplication> getAllValuesOfdepApp(final MissingAppInstance.Match partialMatch) {
      return rawStreamAllValuesOfdepApp(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depApp.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DeploymentApplication> getAllValuesOfdepApp(final CPS2DeploymentTrace pTrace) {
      return rawStreamAllValuesOfdepApp(new Object[]{null, pTrace}).collect(Collectors.toSet());
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
    public Stream<CPS2DeploymentTrace> streamAllValuesOftrace(final MissingAppInstance.Match partialMatch) {
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
    public Stream<CPS2DeploymentTrace> streamAllValuesOftrace(final DeploymentApplication pDepApp) {
      return rawStreamAllValuesOftrace(new Object[]{pDepApp, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<CPS2DeploymentTrace> getAllValuesOftrace(final MissingAppInstance.Match partialMatch) {
      return rawStreamAllValuesOftrace(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<CPS2DeploymentTrace> getAllValuesOftrace(final DeploymentApplication pDepApp) {
      return rawStreamAllValuesOftrace(new Object[]{pDepApp, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected MissingAppInstance.Match tupleToMatch(final Tuple t) {
      try {
          return MissingAppInstance.Match.newMatch((DeploymentApplication) t.get(POSITION_DEPAPP), (CPS2DeploymentTrace) t.get(POSITION_TRACE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected MissingAppInstance.Match arrayToMatch(final Object[] match) {
      try {
          return MissingAppInstance.Match.newMatch((DeploymentApplication) match[POSITION_DEPAPP], (CPS2DeploymentTrace) match[POSITION_TRACE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected MissingAppInstance.Match arrayToMatchMutable(final Object[] match) {
      try {
          return MissingAppInstance.Match.newMutableMatch((DeploymentApplication) match[POSITION_DEPAPP], (CPS2DeploymentTrace) match[POSITION_TRACE]);
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
    public static IQuerySpecification<MissingAppInstance.Matcher> querySpecification() {
      return MissingAppInstance.instance();
    }
  }
  
  private MissingAppInstance() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static MissingAppInstance instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected MissingAppInstance.Matcher instantiate(final ViatraQueryEngine engine) {
    return MissingAppInstance.Matcher.on(engine);
  }
  
  @Override
  public MissingAppInstance.Matcher instantiate() {
    return MissingAppInstance.Matcher.create();
  }
  
  @Override
  public MissingAppInstance.Match newEmptyMatch() {
    return MissingAppInstance.Match.newEmptyMatch();
  }
  
  @Override
  public MissingAppInstance.Match newMatch(final Object... parameters) {
    return MissingAppInstance.Match.newMatch((org.eclipse.viatra.examples.cps.deployment.DeploymentApplication) parameters[0], (org.eclipse.viatra.examples.cps.traceability.CPS2DeploymentTrace) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.MissingAppInstance (visibility: PUBLIC, simpleName: MissingAppInstance, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.MissingAppInstance, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.MissingAppInstance (visibility: PUBLIC, simpleName: MissingAppInstance, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.MissingAppInstance, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final MissingAppInstance INSTANCE = new MissingAppInstance();
    
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
    private static final MissingAppInstance.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_depApp = new PParameter("depApp", "org.eclipse.viatra.examples.cps.deployment.DeploymentApplication", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/deployment", "DeploymentApplication")), PParameterDirection.INOUT);
    
    private final PParameter parameter_trace = new PParameter("trace", "org.eclipse.viatra.examples.cps.traceability.CPS2DeploymentTrace", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_depApp, parameter_trace);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.missingAppInstance";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("depApp","trace");
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
          PVariable var_depApp = body.getOrCreateVariableByName("depApp");
          PVariable var_trace = body.getOrCreateVariableByName("trace");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_depApp), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "DeploymentApplication")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_depApp, parameter_depApp),
             new ExportedParameter(body, var_trace, parameter_trace)
          ));
          //     CPS2DeploymentTrace.deploymentElements(trace,depApp)
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace", "deploymentElements")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "DeploymentElement")));
          new Equality(body, var__virtual_0_, var_depApp);
          //     neg find cps2depTrace(_, trace, _, depApp)
          new NegativePatternCall(body, Tuples.flatTupleOf(var___0_, var_trace, var___1_, var_depApp), Cps2depTrace.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
