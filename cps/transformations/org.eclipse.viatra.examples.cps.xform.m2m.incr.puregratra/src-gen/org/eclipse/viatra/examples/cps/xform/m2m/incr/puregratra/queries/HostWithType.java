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
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostType;
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
 *         pattern hostWithType(type : HostType, instance : HostInstance)  {
 *             HostType.instances(type,instance);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtext.xbase.compiler.JvmModelGenerator")
public final class HostWithType extends BaseGeneratedEMFQuerySpecification<HostWithType.Matcher> {
  /**
   * Pattern-specific match representation of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.hostWithType pattern,
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
    private HostType fType;
    
    private HostInstance fInstance;
    
    private static List<String> parameterNames = makeImmutableList("type", "instance");
    
    private Match(final HostType pType, final HostInstance pInstance) {
      this.fType = pType;
      this.fInstance = pInstance;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("type".equals(parameterName)) return this.fType;
      if ("instance".equals(parameterName)) return this.fInstance;
      return null;
    }
    
    public HostType getType() {
      return this.fType;
    }
    
    public HostInstance getInstance() {
      return this.fInstance;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("type".equals(parameterName) ) {
          this.fType = (HostType) newValue;
          return true;
      }
      if ("instance".equals(parameterName) ) {
          this.fInstance = (HostInstance) newValue;
          return true;
      }
      return false;
    }
    
    public void setType(final HostType pType) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fType = pType;
    }
    
    public void setInstance(final HostInstance pInstance) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fInstance = pInstance;
    }
    
    @Override
    public String patternName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.hostWithType";
    }
    
    @Override
    public List<String> parameterNames() {
      return HostWithType.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fType, fInstance};
    }
    
    @Override
    public HostWithType.Match toImmutable() {
      return isMutable() ? newMatch(fType, fInstance) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"type\"=" + prettyPrintValue(fType) + ", ");
      result.append("\"instance\"=" + prettyPrintValue(fInstance));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fType, fInstance);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof HostWithType.Match)) {
          HostWithType.Match other = (HostWithType.Match) obj;
          return Objects.equals(fType, other.fType) && Objects.equals(fInstance, other.fInstance);
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
    public HostWithType specification() {
      return HostWithType.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static HostWithType.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static HostWithType.Match newMutableMatch(final HostType pType, final HostInstance pInstance) {
      return new Mutable(pType, pInstance);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static HostWithType.Match newMatch(final HostType pType, final HostInstance pInstance) {
      return new Immutable(pType, pInstance);
    }
    
    private static final class Mutable extends HostWithType.Match {
      Mutable(final HostType pType, final HostInstance pInstance) {
        super(pType, pInstance);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends HostWithType.Match {
      Immutable(final HostType pType, final HostInstance pInstance) {
        super(pType, pInstance);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.hostWithType pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern hostWithType(type : HostType, instance : HostInstance)  {
   *     HostType.instances(type,instance);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see HostWithType
   * 
   */
  public static class Matcher extends BaseMatcher<HostWithType.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static HostWithType.Matcher on(final ViatraQueryEngine engine) {
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
    public static HostWithType.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_TYPE = 0;
    
    private static final int POSITION_INSTANCE = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(HostWithType.Matcher.class);
    
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
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<HostWithType.Match> getAllMatches(final HostType pType, final HostInstance pInstance) {
      return rawStreamAllMatches(new Object[]{pType, pInstance}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<HostWithType.Match> streamAllMatches(final HostType pType, final HostInstance pInstance) {
      return rawStreamAllMatches(new Object[]{pType, pInstance});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<HostWithType.Match> getOneArbitraryMatch(final HostType pType, final HostInstance pInstance) {
      return rawGetOneArbitraryMatch(new Object[]{pType, pInstance});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final HostType pType, final HostInstance pInstance) {
      return rawHasMatch(new Object[]{pType, pInstance});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final HostType pType, final HostInstance pInstance) {
      return rawCountMatches(new Object[]{pType, pInstance});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final HostType pType, final HostInstance pInstance, final Consumer<? super HostWithType.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pType, pInstance}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public HostWithType.Match newMatch(final HostType pType, final HostInstance pInstance) {
      return HostWithType.Match.newMatch(pType, pInstance);
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<HostType> rawStreamAllValuesOftype(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TYPE, parameters).map(HostType.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HostType> getAllValuesOftype() {
      return rawStreamAllValuesOftype(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<HostType> streamAllValuesOftype() {
      return rawStreamAllValuesOftype(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<HostType> streamAllValuesOftype(final HostWithType.Match partialMatch) {
      return rawStreamAllValuesOftype(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<HostType> streamAllValuesOftype(final HostInstance pInstance) {
      return rawStreamAllValuesOftype(new Object[]{null, pInstance});
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HostType> getAllValuesOftype(final HostWithType.Match partialMatch) {
      return rawStreamAllValuesOftype(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HostType> getAllValuesOftype(final HostInstance pInstance) {
      return rawStreamAllValuesOftype(new Object[]{null, pInstance}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for instance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<HostInstance> rawStreamAllValuesOfinstance(final Object[] parameters) {
      return rawStreamAllValues(POSITION_INSTANCE, parameters).map(HostInstance.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for instance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HostInstance> getAllValuesOfinstance() {
      return rawStreamAllValuesOfinstance(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for instance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<HostInstance> streamAllValuesOfinstance() {
      return rawStreamAllValuesOfinstance(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for instance.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<HostInstance> streamAllValuesOfinstance(final HostWithType.Match partialMatch) {
      return rawStreamAllValuesOfinstance(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for instance.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<HostInstance> streamAllValuesOfinstance(final HostType pType) {
      return rawStreamAllValuesOfinstance(new Object[]{pType, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for instance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HostInstance> getAllValuesOfinstance(final HostWithType.Match partialMatch) {
      return rawStreamAllValuesOfinstance(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for instance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HostInstance> getAllValuesOfinstance(final HostType pType) {
      return rawStreamAllValuesOfinstance(new Object[]{pType, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected HostWithType.Match tupleToMatch(final Tuple t) {
      try {
          return HostWithType.Match.newMatch((HostType) t.get(POSITION_TYPE), (HostInstance) t.get(POSITION_INSTANCE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected HostWithType.Match arrayToMatch(final Object[] match) {
      try {
          return HostWithType.Match.newMatch((HostType) match[POSITION_TYPE], (HostInstance) match[POSITION_INSTANCE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected HostWithType.Match arrayToMatchMutable(final Object[] match) {
      try {
          return HostWithType.Match.newMutableMatch((HostType) match[POSITION_TYPE], (HostInstance) match[POSITION_INSTANCE]);
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
    public static IQuerySpecification<HostWithType.Matcher> querySpecification() {
      return HostWithType.instance();
    }
  }
  
  private HostWithType() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static HostWithType instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected HostWithType.Matcher instantiate(final ViatraQueryEngine engine) {
    return HostWithType.Matcher.on(engine);
  }
  
  @Override
  public HostWithType.Matcher instantiate() {
    return HostWithType.Matcher.create();
  }
  
  @Override
  public HostWithType.Match newEmptyMatch() {
    return HostWithType.Match.newEmptyMatch();
  }
  
  @Override
  public HostWithType.Match newMatch(final Object... parameters) {
    return HostWithType.Match.newMatch((org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostType) parameters[0], (org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.HostWithType (visibility: PUBLIC, simpleName: HostWithType, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.HostWithType, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.HostWithType (visibility: PUBLIC, simpleName: HostWithType, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.HostWithType, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final HostWithType INSTANCE = new HostWithType();
    
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
    private static final HostWithType.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_type = new PParameter("type", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostType", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "HostType")), PParameterDirection.INOUT);
    
    private final PParameter parameter_instance = new PParameter("instance", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "HostInstance")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_type, parameter_instance);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.hostWithType";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("type","instance");
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
          PVariable var_type = body.getOrCreateVariableByName("type");
          PVariable var_instance = body.getOrCreateVariableByName("instance");
          new TypeConstraint(body, Tuples.flatTupleOf(var_type), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "HostType")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_instance), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "HostInstance")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_type, parameter_type),
             new ExportedParameter(body, var_instance, parameter_instance)
          ));
          //     HostType.instances(type,instance)
          new TypeConstraint(body, Tuples.flatTupleOf(var_type), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "HostType")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_type, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/cps", "HostType", "instances")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "HostInstance")));
          new Equality(body, var__virtual_0_, var_instance);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
