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
 *         Action Rule Patterns (Spec 6) 
 *         
 *         // H1 and H2 can communicate
 *         
 *         pattern hostCommunication(fromHost : HostInstance, toHost : HostInstance) {
 *             HostInstance.communicateWith(fromHost, toHost);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtext.xbase.compiler.JvmModelGenerator")
public final class HostCommunication extends BaseGeneratedEMFQuerySpecification<HostCommunication.Matcher> {
  /**
   * Pattern-specific match representation of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.hostCommunication pattern,
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
    private HostInstance fFromHost;
    
    private HostInstance fToHost;
    
    private static List<String> parameterNames = makeImmutableList("fromHost", "toHost");
    
    private Match(final HostInstance pFromHost, final HostInstance pToHost) {
      this.fFromHost = pFromHost;
      this.fToHost = pToHost;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("fromHost".equals(parameterName)) return this.fFromHost;
      if ("toHost".equals(parameterName)) return this.fToHost;
      return null;
    }
    
    public HostInstance getFromHost() {
      return this.fFromHost;
    }
    
    public HostInstance getToHost() {
      return this.fToHost;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("fromHost".equals(parameterName) ) {
          this.fFromHost = (HostInstance) newValue;
          return true;
      }
      if ("toHost".equals(parameterName) ) {
          this.fToHost = (HostInstance) newValue;
          return true;
      }
      return false;
    }
    
    public void setFromHost(final HostInstance pFromHost) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fFromHost = pFromHost;
    }
    
    public void setToHost(final HostInstance pToHost) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fToHost = pToHost;
    }
    
    @Override
    public String patternName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.hostCommunication";
    }
    
    @Override
    public List<String> parameterNames() {
      return HostCommunication.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fFromHost, fToHost};
    }
    
    @Override
    public HostCommunication.Match toImmutable() {
      return isMutable() ? newMatch(fFromHost, fToHost) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"fromHost\"=" + prettyPrintValue(fFromHost) + ", ");
      result.append("\"toHost\"=" + prettyPrintValue(fToHost));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fFromHost, fToHost);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof HostCommunication.Match)) {
          HostCommunication.Match other = (HostCommunication.Match) obj;
          return Objects.equals(fFromHost, other.fFromHost) && Objects.equals(fToHost, other.fToHost);
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
    public HostCommunication specification() {
      return HostCommunication.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static HostCommunication.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pFromHost the fixed value of pattern parameter fromHost, or null if not bound.
     * @param pToHost the fixed value of pattern parameter toHost, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static HostCommunication.Match newMutableMatch(final HostInstance pFromHost, final HostInstance pToHost) {
      return new Mutable(pFromHost, pToHost);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pFromHost the fixed value of pattern parameter fromHost, or null if not bound.
     * @param pToHost the fixed value of pattern parameter toHost, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static HostCommunication.Match newMatch(final HostInstance pFromHost, final HostInstance pToHost) {
      return new Immutable(pFromHost, pToHost);
    }
    
    private static final class Mutable extends HostCommunication.Match {
      Mutable(final HostInstance pFromHost, final HostInstance pToHost) {
        super(pFromHost, pToHost);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends HostCommunication.Match {
      Immutable(final HostInstance pFromHost, final HostInstance pToHost) {
        super(pFromHost, pToHost);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.hostCommunication pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * Action Rule Patterns (Spec 6) 
   * 
   * // H1 and H2 can communicate
   * 
   * pattern hostCommunication(fromHost : HostInstance, toHost : HostInstance) {
   *     HostInstance.communicateWith(fromHost, toHost);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see HostCommunication
   * 
   */
  public static class Matcher extends BaseMatcher<HostCommunication.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static HostCommunication.Matcher on(final ViatraQueryEngine engine) {
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
    public static HostCommunication.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_FROMHOST = 0;
    
    private static final int POSITION_TOHOST = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(HostCommunication.Matcher.class);
    
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
     * @param pFromHost the fixed value of pattern parameter fromHost, or null if not bound.
     * @param pToHost the fixed value of pattern parameter toHost, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<HostCommunication.Match> getAllMatches(final HostInstance pFromHost, final HostInstance pToHost) {
      return rawStreamAllMatches(new Object[]{pFromHost, pToHost}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pFromHost the fixed value of pattern parameter fromHost, or null if not bound.
     * @param pToHost the fixed value of pattern parameter toHost, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<HostCommunication.Match> streamAllMatches(final HostInstance pFromHost, final HostInstance pToHost) {
      return rawStreamAllMatches(new Object[]{pFromHost, pToHost});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pFromHost the fixed value of pattern parameter fromHost, or null if not bound.
     * @param pToHost the fixed value of pattern parameter toHost, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<HostCommunication.Match> getOneArbitraryMatch(final HostInstance pFromHost, final HostInstance pToHost) {
      return rawGetOneArbitraryMatch(new Object[]{pFromHost, pToHost});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pFromHost the fixed value of pattern parameter fromHost, or null if not bound.
     * @param pToHost the fixed value of pattern parameter toHost, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final HostInstance pFromHost, final HostInstance pToHost) {
      return rawHasMatch(new Object[]{pFromHost, pToHost});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pFromHost the fixed value of pattern parameter fromHost, or null if not bound.
     * @param pToHost the fixed value of pattern parameter toHost, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final HostInstance pFromHost, final HostInstance pToHost) {
      return rawCountMatches(new Object[]{pFromHost, pToHost});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pFromHost the fixed value of pattern parameter fromHost, or null if not bound.
     * @param pToHost the fixed value of pattern parameter toHost, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final HostInstance pFromHost, final HostInstance pToHost, final Consumer<? super HostCommunication.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pFromHost, pToHost}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pFromHost the fixed value of pattern parameter fromHost, or null if not bound.
     * @param pToHost the fixed value of pattern parameter toHost, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public HostCommunication.Match newMatch(final HostInstance pFromHost, final HostInstance pToHost) {
      return HostCommunication.Match.newMatch(pFromHost, pToHost);
    }
    
    /**
     * Retrieve the set of values that occur in matches for fromHost.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<HostInstance> rawStreamAllValuesOffromHost(final Object[] parameters) {
      return rawStreamAllValues(POSITION_FROMHOST, parameters).map(HostInstance.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for fromHost.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HostInstance> getAllValuesOffromHost() {
      return rawStreamAllValuesOffromHost(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for fromHost.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<HostInstance> streamAllValuesOffromHost() {
      return rawStreamAllValuesOffromHost(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for fromHost.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<HostInstance> streamAllValuesOffromHost(final HostCommunication.Match partialMatch) {
      return rawStreamAllValuesOffromHost(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for fromHost.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<HostInstance> streamAllValuesOffromHost(final HostInstance pToHost) {
      return rawStreamAllValuesOffromHost(new Object[]{null, pToHost});
    }
    
    /**
     * Retrieve the set of values that occur in matches for fromHost.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HostInstance> getAllValuesOffromHost(final HostCommunication.Match partialMatch) {
      return rawStreamAllValuesOffromHost(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for fromHost.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HostInstance> getAllValuesOffromHost(final HostInstance pToHost) {
      return rawStreamAllValuesOffromHost(new Object[]{null, pToHost}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for toHost.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<HostInstance> rawStreamAllValuesOftoHost(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TOHOST, parameters).map(HostInstance.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for toHost.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HostInstance> getAllValuesOftoHost() {
      return rawStreamAllValuesOftoHost(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for toHost.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<HostInstance> streamAllValuesOftoHost() {
      return rawStreamAllValuesOftoHost(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for toHost.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<HostInstance> streamAllValuesOftoHost(final HostCommunication.Match partialMatch) {
      return rawStreamAllValuesOftoHost(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for toHost.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<HostInstance> streamAllValuesOftoHost(final HostInstance pFromHost) {
      return rawStreamAllValuesOftoHost(new Object[]{pFromHost, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for toHost.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HostInstance> getAllValuesOftoHost(final HostCommunication.Match partialMatch) {
      return rawStreamAllValuesOftoHost(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for toHost.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HostInstance> getAllValuesOftoHost(final HostInstance pFromHost) {
      return rawStreamAllValuesOftoHost(new Object[]{pFromHost, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected HostCommunication.Match tupleToMatch(final Tuple t) {
      try {
          return HostCommunication.Match.newMatch((HostInstance) t.get(POSITION_FROMHOST), (HostInstance) t.get(POSITION_TOHOST));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected HostCommunication.Match arrayToMatch(final Object[] match) {
      try {
          return HostCommunication.Match.newMatch((HostInstance) match[POSITION_FROMHOST], (HostInstance) match[POSITION_TOHOST]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected HostCommunication.Match arrayToMatchMutable(final Object[] match) {
      try {
          return HostCommunication.Match.newMutableMatch((HostInstance) match[POSITION_FROMHOST], (HostInstance) match[POSITION_TOHOST]);
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
    public static IQuerySpecification<HostCommunication.Matcher> querySpecification() {
      return HostCommunication.instance();
    }
  }
  
  private HostCommunication() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static HostCommunication instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected HostCommunication.Matcher instantiate(final ViatraQueryEngine engine) {
    return HostCommunication.Matcher.on(engine);
  }
  
  @Override
  public HostCommunication.Matcher instantiate() {
    return HostCommunication.Matcher.create();
  }
  
  @Override
  public HostCommunication.Match newEmptyMatch() {
    return HostCommunication.Match.newEmptyMatch();
  }
  
  @Override
  public HostCommunication.Match newMatch(final Object... parameters) {
    return HostCommunication.Match.newMatch((org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance) parameters[0], (org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.HostCommunication (visibility: PUBLIC, simpleName: HostCommunication, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.HostCommunication, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.HostCommunication (visibility: PUBLIC, simpleName: HostCommunication, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.HostCommunication, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final HostCommunication INSTANCE = new HostCommunication();
    
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
    private static final HostCommunication.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_fromHost = new PParameter("fromHost", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "HostInstance")), PParameterDirection.INOUT);
    
    private final PParameter parameter_toHost = new PParameter("toHost", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "HostInstance")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_fromHost, parameter_toHost);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.hostCommunication";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("fromHost","toHost");
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
          PVariable var_fromHost = body.getOrCreateVariableByName("fromHost");
          PVariable var_toHost = body.getOrCreateVariableByName("toHost");
          new TypeConstraint(body, Tuples.flatTupleOf(var_fromHost), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "HostInstance")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_toHost), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "HostInstance")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_fromHost, parameter_fromHost),
             new ExportedParameter(body, var_toHost, parameter_toHost)
          ));
          //     HostInstance.communicateWith(fromHost, toHost)
          new TypeConstraint(body, Tuples.flatTupleOf(var_fromHost), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "HostInstance")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_fromHost, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/cps", "HostInstance", "communicateWith")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "HostInstance")));
          new Equality(body, var__virtual_0_, var_toHost);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
