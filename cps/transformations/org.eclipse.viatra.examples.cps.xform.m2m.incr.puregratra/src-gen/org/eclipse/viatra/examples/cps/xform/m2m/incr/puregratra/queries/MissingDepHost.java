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
import org.eclipse.viatra.examples.cps.deployment.DeploymentHost;
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
 *         pattern missingDepHost(depHost : DeploymentHost, trace : CPS2DeploymentTrace) {
 *             CPS2DeploymentTrace.deploymentElements(trace,depHost);
 *             neg find cps2depTrace(_, trace, _, depHost);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtext.xbase.compiler.JvmModelGenerator")
public final class MissingDepHost extends BaseGeneratedEMFQuerySpecification<MissingDepHost.Matcher> {
  /**
   * Pattern-specific match representation of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.missingDepHost pattern,
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
    private DeploymentHost fDepHost;
    
    private CPS2DeploymentTrace fTrace;
    
    private static List<String> parameterNames = makeImmutableList("depHost", "trace");
    
    private Match(final DeploymentHost pDepHost, final CPS2DeploymentTrace pTrace) {
      this.fDepHost = pDepHost;
      this.fTrace = pTrace;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("depHost".equals(parameterName)) return this.fDepHost;
      if ("trace".equals(parameterName)) return this.fTrace;
      return null;
    }
    
    public DeploymentHost getDepHost() {
      return this.fDepHost;
    }
    
    public CPS2DeploymentTrace getTrace() {
      return this.fTrace;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("depHost".equals(parameterName) ) {
          this.fDepHost = (DeploymentHost) newValue;
          return true;
      }
      if ("trace".equals(parameterName) ) {
          this.fTrace = (CPS2DeploymentTrace) newValue;
          return true;
      }
      return false;
    }
    
    public void setDepHost(final DeploymentHost pDepHost) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fDepHost = pDepHost;
    }
    
    public void setTrace(final CPS2DeploymentTrace pTrace) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTrace = pTrace;
    }
    
    @Override
    public String patternName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.missingDepHost";
    }
    
    @Override
    public List<String> parameterNames() {
      return MissingDepHost.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fDepHost, fTrace};
    }
    
    @Override
    public MissingDepHost.Match toImmutable() {
      return isMutable() ? newMatch(fDepHost, fTrace) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"depHost\"=" + prettyPrintValue(fDepHost) + ", ");
      result.append("\"trace\"=" + prettyPrintValue(fTrace));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fDepHost, fTrace);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof MissingDepHost.Match)) {
          MissingDepHost.Match other = (MissingDepHost.Match) obj;
          return Objects.equals(fDepHost, other.fDepHost) && Objects.equals(fTrace, other.fTrace);
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
    public MissingDepHost specification() {
      return MissingDepHost.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static MissingDepHost.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pDepHost the fixed value of pattern parameter depHost, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static MissingDepHost.Match newMutableMatch(final DeploymentHost pDepHost, final CPS2DeploymentTrace pTrace) {
      return new Mutable(pDepHost, pTrace);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pDepHost the fixed value of pattern parameter depHost, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static MissingDepHost.Match newMatch(final DeploymentHost pDepHost, final CPS2DeploymentTrace pTrace) {
      return new Immutable(pDepHost, pTrace);
    }
    
    private static final class Mutable extends MissingDepHost.Match {
      Mutable(final DeploymentHost pDepHost, final CPS2DeploymentTrace pTrace) {
        super(pDepHost, pTrace);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends MissingDepHost.Match {
      Immutable(final DeploymentHost pDepHost, final CPS2DeploymentTrace pTrace) {
        super(pDepHost, pTrace);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.missingDepHost pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern missingDepHost(depHost : DeploymentHost, trace : CPS2DeploymentTrace) {
   *     CPS2DeploymentTrace.deploymentElements(trace,depHost);
   *     neg find cps2depTrace(_, trace, _, depHost);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see MissingDepHost
   * 
   */
  public static class Matcher extends BaseMatcher<MissingDepHost.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static MissingDepHost.Matcher on(final ViatraQueryEngine engine) {
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
    public static MissingDepHost.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_DEPHOST = 0;
    
    private static final int POSITION_TRACE = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(MissingDepHost.Matcher.class);
    
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
     * @param pDepHost the fixed value of pattern parameter depHost, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<MissingDepHost.Match> getAllMatches(final DeploymentHost pDepHost, final CPS2DeploymentTrace pTrace) {
      return rawStreamAllMatches(new Object[]{pDepHost, pTrace}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pDepHost the fixed value of pattern parameter depHost, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<MissingDepHost.Match> streamAllMatches(final DeploymentHost pDepHost, final CPS2DeploymentTrace pTrace) {
      return rawStreamAllMatches(new Object[]{pDepHost, pTrace});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pDepHost the fixed value of pattern parameter depHost, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<MissingDepHost.Match> getOneArbitraryMatch(final DeploymentHost pDepHost, final CPS2DeploymentTrace pTrace) {
      return rawGetOneArbitraryMatch(new Object[]{pDepHost, pTrace});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pDepHost the fixed value of pattern parameter depHost, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final DeploymentHost pDepHost, final CPS2DeploymentTrace pTrace) {
      return rawHasMatch(new Object[]{pDepHost, pTrace});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pDepHost the fixed value of pattern parameter depHost, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final DeploymentHost pDepHost, final CPS2DeploymentTrace pTrace) {
      return rawCountMatches(new Object[]{pDepHost, pTrace});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pDepHost the fixed value of pattern parameter depHost, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final DeploymentHost pDepHost, final CPS2DeploymentTrace pTrace, final Consumer<? super MissingDepHost.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pDepHost, pTrace}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pDepHost the fixed value of pattern parameter depHost, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public MissingDepHost.Match newMatch(final DeploymentHost pDepHost, final CPS2DeploymentTrace pTrace) {
      return MissingDepHost.Match.newMatch(pDepHost, pTrace);
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
    public Stream<DeploymentHost> streamAllValuesOfdepHost(final MissingDepHost.Match partialMatch) {
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
    public Stream<DeploymentHost> streamAllValuesOfdepHost(final CPS2DeploymentTrace pTrace) {
      return rawStreamAllValuesOfdepHost(new Object[]{null, pTrace});
    }
    
    /**
     * Retrieve the set of values that occur in matches for depHost.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DeploymentHost> getAllValuesOfdepHost(final MissingDepHost.Match partialMatch) {
      return rawStreamAllValuesOfdepHost(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depHost.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DeploymentHost> getAllValuesOfdepHost(final CPS2DeploymentTrace pTrace) {
      return rawStreamAllValuesOfdepHost(new Object[]{null, pTrace}).collect(Collectors.toSet());
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
    public Stream<CPS2DeploymentTrace> streamAllValuesOftrace(final MissingDepHost.Match partialMatch) {
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
    public Stream<CPS2DeploymentTrace> streamAllValuesOftrace(final DeploymentHost pDepHost) {
      return rawStreamAllValuesOftrace(new Object[]{pDepHost, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<CPS2DeploymentTrace> getAllValuesOftrace(final MissingDepHost.Match partialMatch) {
      return rawStreamAllValuesOftrace(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<CPS2DeploymentTrace> getAllValuesOftrace(final DeploymentHost pDepHost) {
      return rawStreamAllValuesOftrace(new Object[]{pDepHost, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected MissingDepHost.Match tupleToMatch(final Tuple t) {
      try {
          return MissingDepHost.Match.newMatch((DeploymentHost) t.get(POSITION_DEPHOST), (CPS2DeploymentTrace) t.get(POSITION_TRACE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected MissingDepHost.Match arrayToMatch(final Object[] match) {
      try {
          return MissingDepHost.Match.newMatch((DeploymentHost) match[POSITION_DEPHOST], (CPS2DeploymentTrace) match[POSITION_TRACE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected MissingDepHost.Match arrayToMatchMutable(final Object[] match) {
      try {
          return MissingDepHost.Match.newMutableMatch((DeploymentHost) match[POSITION_DEPHOST], (CPS2DeploymentTrace) match[POSITION_TRACE]);
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
    public static IQuerySpecification<MissingDepHost.Matcher> querySpecification() {
      return MissingDepHost.instance();
    }
  }
  
  private MissingDepHost() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static MissingDepHost instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected MissingDepHost.Matcher instantiate(final ViatraQueryEngine engine) {
    return MissingDepHost.Matcher.on(engine);
  }
  
  @Override
  public MissingDepHost.Matcher instantiate() {
    return MissingDepHost.Matcher.create();
  }
  
  @Override
  public MissingDepHost.Match newEmptyMatch() {
    return MissingDepHost.Match.newEmptyMatch();
  }
  
  @Override
  public MissingDepHost.Match newMatch(final Object... parameters) {
    return MissingDepHost.Match.newMatch((org.eclipse.viatra.examples.cps.deployment.DeploymentHost) parameters[0], (org.eclipse.viatra.examples.cps.traceability.CPS2DeploymentTrace) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.MissingDepHost (visibility: PUBLIC, simpleName: MissingDepHost, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.MissingDepHost, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.MissingDepHost (visibility: PUBLIC, simpleName: MissingDepHost, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.MissingDepHost, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final MissingDepHost INSTANCE = new MissingDepHost();
    
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
    private static final MissingDepHost.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_depHost = new PParameter("depHost", "org.eclipse.viatra.examples.cps.deployment.DeploymentHost", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/deployment", "DeploymentHost")), PParameterDirection.INOUT);
    
    private final PParameter parameter_trace = new PParameter("trace", "org.eclipse.viatra.examples.cps.traceability.CPS2DeploymentTrace", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_depHost, parameter_trace);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.missingDepHost";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("depHost","trace");
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
          PVariable var_depHost = body.getOrCreateVariableByName("depHost");
          PVariable var_trace = body.getOrCreateVariableByName("trace");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_depHost), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "DeploymentHost")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_depHost, parameter_depHost),
             new ExportedParameter(body, var_trace, parameter_trace)
          ));
          //     CPS2DeploymentTrace.deploymentElements(trace,depHost)
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace", "deploymentElements")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "DeploymentElement")));
          new Equality(body, var__virtual_0_, var_depHost);
          //     neg find cps2depTrace(_, trace, _, depHost)
          new NegativePatternCall(body, Tuples.flatTupleOf(var___0_, var_trace, var___1_, var_depHost), Cps2depTrace.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
