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
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.ApplicationInstanceWithHost;
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.ReachableHosts;
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
 *         pattern communicatingAppInstances(sourceAppInstance : ApplicationInstance, targetAppInstance : ApplicationInstance) {
 *             find applicationInstanceWithHost(_, sourceAppInstance, sourceHostInstance);
 *             find applicationInstanceWithHost(_, targetAppInstance, targetHostInstance);
 *             find reachableHosts(sourceHostInstance, targetHostInstance);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtext.xbase.compiler.JvmModelGenerator")
public final class CommunicatingAppInstances extends BaseGeneratedEMFQuerySpecification<CommunicatingAppInstances.Matcher> {
  /**
   * Pattern-specific match representation of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.communicatingAppInstances pattern,
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
    private ApplicationInstance fSourceAppInstance;
    
    private ApplicationInstance fTargetAppInstance;
    
    private static List<String> parameterNames = makeImmutableList("sourceAppInstance", "targetAppInstance");
    
    private Match(final ApplicationInstance pSourceAppInstance, final ApplicationInstance pTargetAppInstance) {
      this.fSourceAppInstance = pSourceAppInstance;
      this.fTargetAppInstance = pTargetAppInstance;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("sourceAppInstance".equals(parameterName)) return this.fSourceAppInstance;
      if ("targetAppInstance".equals(parameterName)) return this.fTargetAppInstance;
      return null;
    }
    
    public ApplicationInstance getSourceAppInstance() {
      return this.fSourceAppInstance;
    }
    
    public ApplicationInstance getTargetAppInstance() {
      return this.fTargetAppInstance;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("sourceAppInstance".equals(parameterName) ) {
          this.fSourceAppInstance = (ApplicationInstance) newValue;
          return true;
      }
      if ("targetAppInstance".equals(parameterName) ) {
          this.fTargetAppInstance = (ApplicationInstance) newValue;
          return true;
      }
      return false;
    }
    
    public void setSourceAppInstance(final ApplicationInstance pSourceAppInstance) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fSourceAppInstance = pSourceAppInstance;
    }
    
    public void setTargetAppInstance(final ApplicationInstance pTargetAppInstance) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTargetAppInstance = pTargetAppInstance;
    }
    
    @Override
    public String patternName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.communicatingAppInstances";
    }
    
    @Override
    public List<String> parameterNames() {
      return CommunicatingAppInstances.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fSourceAppInstance, fTargetAppInstance};
    }
    
    @Override
    public CommunicatingAppInstances.Match toImmutable() {
      return isMutable() ? newMatch(fSourceAppInstance, fTargetAppInstance) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"sourceAppInstance\"=" + prettyPrintValue(fSourceAppInstance) + ", ");
      result.append("\"targetAppInstance\"=" + prettyPrintValue(fTargetAppInstance));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fSourceAppInstance, fTargetAppInstance);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof CommunicatingAppInstances.Match)) {
          CommunicatingAppInstances.Match other = (CommunicatingAppInstances.Match) obj;
          return Objects.equals(fSourceAppInstance, other.fSourceAppInstance) && Objects.equals(fTargetAppInstance, other.fTargetAppInstance);
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
    public CommunicatingAppInstances specification() {
      return CommunicatingAppInstances.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static CommunicatingAppInstances.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pSourceAppInstance the fixed value of pattern parameter sourceAppInstance, or null if not bound.
     * @param pTargetAppInstance the fixed value of pattern parameter targetAppInstance, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static CommunicatingAppInstances.Match newMutableMatch(final ApplicationInstance pSourceAppInstance, final ApplicationInstance pTargetAppInstance) {
      return new Mutable(pSourceAppInstance, pTargetAppInstance);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSourceAppInstance the fixed value of pattern parameter sourceAppInstance, or null if not bound.
     * @param pTargetAppInstance the fixed value of pattern parameter targetAppInstance, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static CommunicatingAppInstances.Match newMatch(final ApplicationInstance pSourceAppInstance, final ApplicationInstance pTargetAppInstance) {
      return new Immutable(pSourceAppInstance, pTargetAppInstance);
    }
    
    private static final class Mutable extends CommunicatingAppInstances.Match {
      Mutable(final ApplicationInstance pSourceAppInstance, final ApplicationInstance pTargetAppInstance) {
        super(pSourceAppInstance, pTargetAppInstance);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends CommunicatingAppInstances.Match {
      Immutable(final ApplicationInstance pSourceAppInstance, final ApplicationInstance pTargetAppInstance) {
        super(pSourceAppInstance, pTargetAppInstance);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.communicatingAppInstances pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern communicatingAppInstances(sourceAppInstance : ApplicationInstance, targetAppInstance : ApplicationInstance) {
   *     find applicationInstanceWithHost(_, sourceAppInstance, sourceHostInstance);
   *     find applicationInstanceWithHost(_, targetAppInstance, targetHostInstance);
   *     find reachableHosts(sourceHostInstance, targetHostInstance);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see CommunicatingAppInstances
   * 
   */
  public static class Matcher extends BaseMatcher<CommunicatingAppInstances.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static CommunicatingAppInstances.Matcher on(final ViatraQueryEngine engine) {
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
    public static CommunicatingAppInstances.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_SOURCEAPPINSTANCE = 0;
    
    private static final int POSITION_TARGETAPPINSTANCE = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(CommunicatingAppInstances.Matcher.class);
    
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
     * @param pSourceAppInstance the fixed value of pattern parameter sourceAppInstance, or null if not bound.
     * @param pTargetAppInstance the fixed value of pattern parameter targetAppInstance, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<CommunicatingAppInstances.Match> getAllMatches(final ApplicationInstance pSourceAppInstance, final ApplicationInstance pTargetAppInstance) {
      return rawStreamAllMatches(new Object[]{pSourceAppInstance, pTargetAppInstance}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pSourceAppInstance the fixed value of pattern parameter sourceAppInstance, or null if not bound.
     * @param pTargetAppInstance the fixed value of pattern parameter targetAppInstance, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<CommunicatingAppInstances.Match> streamAllMatches(final ApplicationInstance pSourceAppInstance, final ApplicationInstance pTargetAppInstance) {
      return rawStreamAllMatches(new Object[]{pSourceAppInstance, pTargetAppInstance});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSourceAppInstance the fixed value of pattern parameter sourceAppInstance, or null if not bound.
     * @param pTargetAppInstance the fixed value of pattern parameter targetAppInstance, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<CommunicatingAppInstances.Match> getOneArbitraryMatch(final ApplicationInstance pSourceAppInstance, final ApplicationInstance pTargetAppInstance) {
      return rawGetOneArbitraryMatch(new Object[]{pSourceAppInstance, pTargetAppInstance});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pSourceAppInstance the fixed value of pattern parameter sourceAppInstance, or null if not bound.
     * @param pTargetAppInstance the fixed value of pattern parameter targetAppInstance, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final ApplicationInstance pSourceAppInstance, final ApplicationInstance pTargetAppInstance) {
      return rawHasMatch(new Object[]{pSourceAppInstance, pTargetAppInstance});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pSourceAppInstance the fixed value of pattern parameter sourceAppInstance, or null if not bound.
     * @param pTargetAppInstance the fixed value of pattern parameter targetAppInstance, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final ApplicationInstance pSourceAppInstance, final ApplicationInstance pTargetAppInstance) {
      return rawCountMatches(new Object[]{pSourceAppInstance, pTargetAppInstance});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSourceAppInstance the fixed value of pattern parameter sourceAppInstance, or null if not bound.
     * @param pTargetAppInstance the fixed value of pattern parameter targetAppInstance, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final ApplicationInstance pSourceAppInstance, final ApplicationInstance pTargetAppInstance, final Consumer<? super CommunicatingAppInstances.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pSourceAppInstance, pTargetAppInstance}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSourceAppInstance the fixed value of pattern parameter sourceAppInstance, or null if not bound.
     * @param pTargetAppInstance the fixed value of pattern parameter targetAppInstance, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public CommunicatingAppInstances.Match newMatch(final ApplicationInstance pSourceAppInstance, final ApplicationInstance pTargetAppInstance) {
      return CommunicatingAppInstances.Match.newMatch(pSourceAppInstance, pTargetAppInstance);
    }
    
    /**
     * Retrieve the set of values that occur in matches for sourceAppInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<ApplicationInstance> rawStreamAllValuesOfsourceAppInstance(final Object[] parameters) {
      return rawStreamAllValues(POSITION_SOURCEAPPINSTANCE, parameters).map(ApplicationInstance.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for sourceAppInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationInstance> getAllValuesOfsourceAppInstance() {
      return rawStreamAllValuesOfsourceAppInstance(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for sourceAppInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<ApplicationInstance> streamAllValuesOfsourceAppInstance() {
      return rawStreamAllValuesOfsourceAppInstance(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for sourceAppInstance.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<ApplicationInstance> streamAllValuesOfsourceAppInstance(final CommunicatingAppInstances.Match partialMatch) {
      return rawStreamAllValuesOfsourceAppInstance(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for sourceAppInstance.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<ApplicationInstance> streamAllValuesOfsourceAppInstance(final ApplicationInstance pTargetAppInstance) {
      return rawStreamAllValuesOfsourceAppInstance(new Object[]{null, pTargetAppInstance});
    }
    
    /**
     * Retrieve the set of values that occur in matches for sourceAppInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationInstance> getAllValuesOfsourceAppInstance(final CommunicatingAppInstances.Match partialMatch) {
      return rawStreamAllValuesOfsourceAppInstance(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for sourceAppInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationInstance> getAllValuesOfsourceAppInstance(final ApplicationInstance pTargetAppInstance) {
      return rawStreamAllValuesOfsourceAppInstance(new Object[]{null, pTargetAppInstance}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for targetAppInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<ApplicationInstance> rawStreamAllValuesOftargetAppInstance(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TARGETAPPINSTANCE, parameters).map(ApplicationInstance.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for targetAppInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationInstance> getAllValuesOftargetAppInstance() {
      return rawStreamAllValuesOftargetAppInstance(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for targetAppInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<ApplicationInstance> streamAllValuesOftargetAppInstance() {
      return rawStreamAllValuesOftargetAppInstance(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for targetAppInstance.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<ApplicationInstance> streamAllValuesOftargetAppInstance(final CommunicatingAppInstances.Match partialMatch) {
      return rawStreamAllValuesOftargetAppInstance(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for targetAppInstance.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<ApplicationInstance> streamAllValuesOftargetAppInstance(final ApplicationInstance pSourceAppInstance) {
      return rawStreamAllValuesOftargetAppInstance(new Object[]{pSourceAppInstance, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for targetAppInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationInstance> getAllValuesOftargetAppInstance(final CommunicatingAppInstances.Match partialMatch) {
      return rawStreamAllValuesOftargetAppInstance(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for targetAppInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ApplicationInstance> getAllValuesOftargetAppInstance(final ApplicationInstance pSourceAppInstance) {
      return rawStreamAllValuesOftargetAppInstance(new Object[]{pSourceAppInstance, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected CommunicatingAppInstances.Match tupleToMatch(final Tuple t) {
      try {
          return CommunicatingAppInstances.Match.newMatch((ApplicationInstance) t.get(POSITION_SOURCEAPPINSTANCE), (ApplicationInstance) t.get(POSITION_TARGETAPPINSTANCE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected CommunicatingAppInstances.Match arrayToMatch(final Object[] match) {
      try {
          return CommunicatingAppInstances.Match.newMatch((ApplicationInstance) match[POSITION_SOURCEAPPINSTANCE], (ApplicationInstance) match[POSITION_TARGETAPPINSTANCE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected CommunicatingAppInstances.Match arrayToMatchMutable(final Object[] match) {
      try {
          return CommunicatingAppInstances.Match.newMutableMatch((ApplicationInstance) match[POSITION_SOURCEAPPINSTANCE], (ApplicationInstance) match[POSITION_TARGETAPPINSTANCE]);
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
    public static IQuerySpecification<CommunicatingAppInstances.Matcher> querySpecification() {
      return CommunicatingAppInstances.instance();
    }
  }
  
  private CommunicatingAppInstances() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static CommunicatingAppInstances instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected CommunicatingAppInstances.Matcher instantiate(final ViatraQueryEngine engine) {
    return CommunicatingAppInstances.Matcher.on(engine);
  }
  
  @Override
  public CommunicatingAppInstances.Matcher instantiate() {
    return CommunicatingAppInstances.Matcher.create();
  }
  
  @Override
  public CommunicatingAppInstances.Match newEmptyMatch() {
    return CommunicatingAppInstances.Match.newEmptyMatch();
  }
  
  @Override
  public CommunicatingAppInstances.Match newMatch(final Object... parameters) {
    return CommunicatingAppInstances.Match.newMatch((org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance) parameters[0], (org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.CommunicatingAppInstances (visibility: PUBLIC, simpleName: CommunicatingAppInstances, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.CommunicatingAppInstances, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.CommunicatingAppInstances (visibility: PUBLIC, simpleName: CommunicatingAppInstances, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.CommunicatingAppInstances, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final CommunicatingAppInstances INSTANCE = new CommunicatingAppInstances();
    
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
    private static final CommunicatingAppInstances.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_sourceAppInstance = new PParameter("sourceAppInstance", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "ApplicationInstance")), PParameterDirection.INOUT);
    
    private final PParameter parameter_targetAppInstance = new PParameter("targetAppInstance", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "ApplicationInstance")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_sourceAppInstance, parameter_targetAppInstance);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.communicatingAppInstances";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("sourceAppInstance","targetAppInstance");
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
          PVariable var_sourceAppInstance = body.getOrCreateVariableByName("sourceAppInstance");
          PVariable var_targetAppInstance = body.getOrCreateVariableByName("targetAppInstance");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          PVariable var_sourceHostInstance = body.getOrCreateVariableByName("sourceHostInstance");
          PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
          PVariable var_targetHostInstance = body.getOrCreateVariableByName("targetHostInstance");
          new TypeConstraint(body, Tuples.flatTupleOf(var_sourceAppInstance), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "ApplicationInstance")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_targetAppInstance), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "ApplicationInstance")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_sourceAppInstance, parameter_sourceAppInstance),
             new ExportedParameter(body, var_targetAppInstance, parameter_targetAppInstance)
          ));
          //     find applicationInstanceWithHost(_, sourceAppInstance, sourceHostInstance)
          new PositivePatternCall(body, Tuples.flatTupleOf(var___0_, var_sourceAppInstance, var_sourceHostInstance), ApplicationInstanceWithHost.instance().getInternalQueryRepresentation());
          //     find applicationInstanceWithHost(_, targetAppInstance, targetHostInstance)
          new PositivePatternCall(body, Tuples.flatTupleOf(var___1_, var_targetAppInstance, var_targetHostInstance), ApplicationInstanceWithHost.instance().getInternalQueryRepresentation());
          //     find reachableHosts(sourceHostInstance, targetHostInstance)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_sourceHostInstance, var_targetHostInstance), ReachableHosts.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
