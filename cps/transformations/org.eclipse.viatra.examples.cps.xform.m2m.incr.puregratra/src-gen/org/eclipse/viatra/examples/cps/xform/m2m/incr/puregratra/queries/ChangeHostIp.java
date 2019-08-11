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
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance;
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
 *         pattern changeHostIp(hostInstance: HostInstance, depHost: DeploymentHost) {
 *             find cps2depTrace(_, _, hostInstance, depHost);
 *             HostInstance.nodeIp(hostInstance,hostIp);
 *             DeploymentHost.ip(depHost,depIp);
 *             hostIp != depIp;
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtext.xbase.compiler.JvmModelGenerator")
public final class ChangeHostIp extends BaseGeneratedEMFQuerySpecification<ChangeHostIp.Matcher> {
  /**
   * Pattern-specific match representation of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.changeHostIp pattern,
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
    private HostInstance fHostInstance;
    
    private DeploymentHost fDepHost;
    
    private static List<String> parameterNames = makeImmutableList("hostInstance", "depHost");
    
    private Match(final HostInstance pHostInstance, final DeploymentHost pDepHost) {
      this.fHostInstance = pHostInstance;
      this.fDepHost = pDepHost;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("hostInstance".equals(parameterName)) return this.fHostInstance;
      if ("depHost".equals(parameterName)) return this.fDepHost;
      return null;
    }
    
    public HostInstance getHostInstance() {
      return this.fHostInstance;
    }
    
    public DeploymentHost getDepHost() {
      return this.fDepHost;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("hostInstance".equals(parameterName) ) {
          this.fHostInstance = (HostInstance) newValue;
          return true;
      }
      if ("depHost".equals(parameterName) ) {
          this.fDepHost = (DeploymentHost) newValue;
          return true;
      }
      return false;
    }
    
    public void setHostInstance(final HostInstance pHostInstance) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fHostInstance = pHostInstance;
    }
    
    public void setDepHost(final DeploymentHost pDepHost) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fDepHost = pDepHost;
    }
    
    @Override
    public String patternName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.changeHostIp";
    }
    
    @Override
    public List<String> parameterNames() {
      return ChangeHostIp.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fHostInstance, fDepHost};
    }
    
    @Override
    public ChangeHostIp.Match toImmutable() {
      return isMutable() ? newMatch(fHostInstance, fDepHost) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"hostInstance\"=" + prettyPrintValue(fHostInstance) + ", ");
      result.append("\"depHost\"=" + prettyPrintValue(fDepHost));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fHostInstance, fDepHost);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof ChangeHostIp.Match)) {
          ChangeHostIp.Match other = (ChangeHostIp.Match) obj;
          return Objects.equals(fHostInstance, other.fHostInstance) && Objects.equals(fDepHost, other.fDepHost);
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
    public ChangeHostIp specification() {
      return ChangeHostIp.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static ChangeHostIp.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pHostInstance the fixed value of pattern parameter hostInstance, or null if not bound.
     * @param pDepHost the fixed value of pattern parameter depHost, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static ChangeHostIp.Match newMutableMatch(final HostInstance pHostInstance, final DeploymentHost pDepHost) {
      return new Mutable(pHostInstance, pDepHost);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pHostInstance the fixed value of pattern parameter hostInstance, or null if not bound.
     * @param pDepHost the fixed value of pattern parameter depHost, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static ChangeHostIp.Match newMatch(final HostInstance pHostInstance, final DeploymentHost pDepHost) {
      return new Immutable(pHostInstance, pDepHost);
    }
    
    private static final class Mutable extends ChangeHostIp.Match {
      Mutable(final HostInstance pHostInstance, final DeploymentHost pDepHost) {
        super(pHostInstance, pDepHost);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends ChangeHostIp.Match {
      Immutable(final HostInstance pHostInstance, final DeploymentHost pDepHost) {
        super(pHostInstance, pDepHost);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.changeHostIp pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern changeHostIp(hostInstance: HostInstance, depHost: DeploymentHost) {
   *     find cps2depTrace(_, _, hostInstance, depHost);
   *     HostInstance.nodeIp(hostInstance,hostIp);
   *     DeploymentHost.ip(depHost,depIp);
   *     hostIp != depIp;
   * }
   * </pre></code>
   * 
   * @see Match
   * @see ChangeHostIp
   * 
   */
  public static class Matcher extends BaseMatcher<ChangeHostIp.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static ChangeHostIp.Matcher on(final ViatraQueryEngine engine) {
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
    public static ChangeHostIp.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_HOSTINSTANCE = 0;
    
    private static final int POSITION_DEPHOST = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ChangeHostIp.Matcher.class);
    
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
     * @param pHostInstance the fixed value of pattern parameter hostInstance, or null if not bound.
     * @param pDepHost the fixed value of pattern parameter depHost, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<ChangeHostIp.Match> getAllMatches(final HostInstance pHostInstance, final DeploymentHost pDepHost) {
      return rawStreamAllMatches(new Object[]{pHostInstance, pDepHost}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pHostInstance the fixed value of pattern parameter hostInstance, or null if not bound.
     * @param pDepHost the fixed value of pattern parameter depHost, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<ChangeHostIp.Match> streamAllMatches(final HostInstance pHostInstance, final DeploymentHost pDepHost) {
      return rawStreamAllMatches(new Object[]{pHostInstance, pDepHost});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pHostInstance the fixed value of pattern parameter hostInstance, or null if not bound.
     * @param pDepHost the fixed value of pattern parameter depHost, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<ChangeHostIp.Match> getOneArbitraryMatch(final HostInstance pHostInstance, final DeploymentHost pDepHost) {
      return rawGetOneArbitraryMatch(new Object[]{pHostInstance, pDepHost});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pHostInstance the fixed value of pattern parameter hostInstance, or null if not bound.
     * @param pDepHost the fixed value of pattern parameter depHost, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final HostInstance pHostInstance, final DeploymentHost pDepHost) {
      return rawHasMatch(new Object[]{pHostInstance, pDepHost});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pHostInstance the fixed value of pattern parameter hostInstance, or null if not bound.
     * @param pDepHost the fixed value of pattern parameter depHost, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final HostInstance pHostInstance, final DeploymentHost pDepHost) {
      return rawCountMatches(new Object[]{pHostInstance, pDepHost});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pHostInstance the fixed value of pattern parameter hostInstance, or null if not bound.
     * @param pDepHost the fixed value of pattern parameter depHost, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final HostInstance pHostInstance, final DeploymentHost pDepHost, final Consumer<? super ChangeHostIp.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pHostInstance, pDepHost}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pHostInstance the fixed value of pattern parameter hostInstance, or null if not bound.
     * @param pDepHost the fixed value of pattern parameter depHost, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public ChangeHostIp.Match newMatch(final HostInstance pHostInstance, final DeploymentHost pDepHost) {
      return ChangeHostIp.Match.newMatch(pHostInstance, pDepHost);
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
    public Stream<HostInstance> streamAllValuesOfhostInstance(final ChangeHostIp.Match partialMatch) {
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
    public Stream<HostInstance> streamAllValuesOfhostInstance(final DeploymentHost pDepHost) {
      return rawStreamAllValuesOfhostInstance(new Object[]{null, pDepHost});
    }
    
    /**
     * Retrieve the set of values that occur in matches for hostInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HostInstance> getAllValuesOfhostInstance(final ChangeHostIp.Match partialMatch) {
      return rawStreamAllValuesOfhostInstance(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for hostInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HostInstance> getAllValuesOfhostInstance(final DeploymentHost pDepHost) {
      return rawStreamAllValuesOfhostInstance(new Object[]{null, pDepHost}).collect(Collectors.toSet());
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
    public Stream<DeploymentHost> streamAllValuesOfdepHost(final ChangeHostIp.Match partialMatch) {
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
    public Stream<DeploymentHost> streamAllValuesOfdepHost(final HostInstance pHostInstance) {
      return rawStreamAllValuesOfdepHost(new Object[]{pHostInstance, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for depHost.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DeploymentHost> getAllValuesOfdepHost(final ChangeHostIp.Match partialMatch) {
      return rawStreamAllValuesOfdepHost(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depHost.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DeploymentHost> getAllValuesOfdepHost(final HostInstance pHostInstance) {
      return rawStreamAllValuesOfdepHost(new Object[]{pHostInstance, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected ChangeHostIp.Match tupleToMatch(final Tuple t) {
      try {
          return ChangeHostIp.Match.newMatch((HostInstance) t.get(POSITION_HOSTINSTANCE), (DeploymentHost) t.get(POSITION_DEPHOST));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected ChangeHostIp.Match arrayToMatch(final Object[] match) {
      try {
          return ChangeHostIp.Match.newMatch((HostInstance) match[POSITION_HOSTINSTANCE], (DeploymentHost) match[POSITION_DEPHOST]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected ChangeHostIp.Match arrayToMatchMutable(final Object[] match) {
      try {
          return ChangeHostIp.Match.newMutableMatch((HostInstance) match[POSITION_HOSTINSTANCE], (DeploymentHost) match[POSITION_DEPHOST]);
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
    public static IQuerySpecification<ChangeHostIp.Matcher> querySpecification() {
      return ChangeHostIp.instance();
    }
  }
  
  private ChangeHostIp() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static ChangeHostIp instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected ChangeHostIp.Matcher instantiate(final ViatraQueryEngine engine) {
    return ChangeHostIp.Matcher.on(engine);
  }
  
  @Override
  public ChangeHostIp.Matcher instantiate() {
    return ChangeHostIp.Matcher.create();
  }
  
  @Override
  public ChangeHostIp.Match newEmptyMatch() {
    return ChangeHostIp.Match.newEmptyMatch();
  }
  
  @Override
  public ChangeHostIp.Match newMatch(final Object... parameters) {
    return ChangeHostIp.Match.newMatch((org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance) parameters[0], (org.eclipse.viatra.examples.cps.deployment.DeploymentHost) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.ChangeHostIp (visibility: PUBLIC, simpleName: ChangeHostIp, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.ChangeHostIp, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.ChangeHostIp (visibility: PUBLIC, simpleName: ChangeHostIp, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.ChangeHostIp, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final ChangeHostIp INSTANCE = new ChangeHostIp();
    
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
    private static final ChangeHostIp.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_hostInstance = new PParameter("hostInstance", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "HostInstance")), PParameterDirection.INOUT);
    
    private final PParameter parameter_depHost = new PParameter("depHost", "org.eclipse.viatra.examples.cps.deployment.DeploymentHost", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/deployment", "DeploymentHost")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_hostInstance, parameter_depHost);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.changeHostIp";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("hostInstance","depHost");
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
          PVariable var_hostInstance = body.getOrCreateVariableByName("hostInstance");
          PVariable var_depHost = body.getOrCreateVariableByName("depHost");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
          PVariable var_hostIp = body.getOrCreateVariableByName("hostIp");
          PVariable var_depIp = body.getOrCreateVariableByName("depIp");
          new TypeConstraint(body, Tuples.flatTupleOf(var_hostInstance), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "HostInstance")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_depHost), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "DeploymentHost")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_hostInstance, parameter_hostInstance),
             new ExportedParameter(body, var_depHost, parameter_depHost)
          ));
          //     find cps2depTrace(_, _, hostInstance, depHost)
          new PositivePatternCall(body, Tuples.flatTupleOf(var___0_, var___1_, var_hostInstance, var_depHost), Cps2depTrace.instance().getInternalQueryRepresentation());
          //     HostInstance.nodeIp(hostInstance,hostIp)
          new TypeConstraint(body, Tuples.flatTupleOf(var_hostInstance), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "HostInstance")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_hostInstance, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/cps", "HostInstance", "nodeIp")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_0_, var_hostIp);
          //     DeploymentHost.ip(depHost,depIp)
          new TypeConstraint(body, Tuples.flatTupleOf(var_depHost), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "DeploymentHost")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_depHost, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/deployment", "DeploymentHost", "ip")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_1_, var_depIp);
          //     hostIp != depIp
          new Inequality(body, var_hostIp, var_depIp);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
