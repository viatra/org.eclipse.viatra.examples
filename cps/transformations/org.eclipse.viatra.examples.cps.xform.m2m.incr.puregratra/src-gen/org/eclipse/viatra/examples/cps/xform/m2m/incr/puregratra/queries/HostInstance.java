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
import org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.Cps2depTrace;
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
 *         Host Rule Patterns (Spec 1) 
 *         
 *         pattern hostInstance(hostInstance : HostInstance) {
 *             HostInstance(hostInstance);
 *             neg find cps2depTrace(_, _, hostInstance, _);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtext.xbase.compiler.JvmModelGenerator")
public final class HostInstance extends BaseGeneratedEMFQuerySpecification<HostInstance.Matcher> {
  /**
   * Pattern-specific match representation of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.hostInstance pattern,
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
    private org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance fHostInstance;
    
    private static List<String> parameterNames = makeImmutableList("hostInstance");
    
    private Match(final org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance pHostInstance) {
      this.fHostInstance = pHostInstance;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("hostInstance".equals(parameterName)) return this.fHostInstance;
      return null;
    }
    
    public org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance getHostInstance() {
      return this.fHostInstance;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("hostInstance".equals(parameterName) ) {
          this.fHostInstance = (org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance) newValue;
          return true;
      }
      return false;
    }
    
    public void setHostInstance(final org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance pHostInstance) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fHostInstance = pHostInstance;
    }
    
    @Override
    public String patternName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.hostInstance";
    }
    
    @Override
    public List<String> parameterNames() {
      return HostInstance.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fHostInstance};
    }
    
    @Override
    public HostInstance.Match toImmutable() {
      return isMutable() ? newMatch(fHostInstance) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"hostInstance\"=" + prettyPrintValue(fHostInstance));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fHostInstance);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof HostInstance.Match)) {
          HostInstance.Match other = (HostInstance.Match) obj;
          return Objects.equals(fHostInstance, other.fHostInstance);
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
    public HostInstance specification() {
      return HostInstance.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static HostInstance.Match newEmptyMatch() {
      return new Mutable(null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pHostInstance the fixed value of pattern parameter hostInstance, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static HostInstance.Match newMutableMatch(final org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance pHostInstance) {
      return new Mutable(pHostInstance);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pHostInstance the fixed value of pattern parameter hostInstance, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static HostInstance.Match newMatch(final org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance pHostInstance) {
      return new Immutable(pHostInstance);
    }
    
    private static final class Mutable extends HostInstance.Match {
      Mutable(final org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance pHostInstance) {
        super(pHostInstance);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends HostInstance.Match {
      Immutable(final org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance pHostInstance) {
        super(pHostInstance);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.hostInstance pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * Host Rule Patterns (Spec 1) 
   * 
   * pattern hostInstance(hostInstance : HostInstance) {
   *     HostInstance(hostInstance);
   *     neg find cps2depTrace(_, _, hostInstance, _);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see HostInstance
   * 
   */
  public static class Matcher extends BaseMatcher<HostInstance.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static HostInstance.Matcher on(final ViatraQueryEngine engine) {
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
    public static HostInstance.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_HOSTINSTANCE = 0;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(HostInstance.Matcher.class);
    
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
     * @return matches represented as a Match object.
     * 
     */
    public Collection<HostInstance.Match> getAllMatches(final org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance pHostInstance) {
      return rawStreamAllMatches(new Object[]{pHostInstance}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pHostInstance the fixed value of pattern parameter hostInstance, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<HostInstance.Match> streamAllMatches(final org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance pHostInstance) {
      return rawStreamAllMatches(new Object[]{pHostInstance});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pHostInstance the fixed value of pattern parameter hostInstance, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<HostInstance.Match> getOneArbitraryMatch(final org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance pHostInstance) {
      return rawGetOneArbitraryMatch(new Object[]{pHostInstance});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pHostInstance the fixed value of pattern parameter hostInstance, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance pHostInstance) {
      return rawHasMatch(new Object[]{pHostInstance});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pHostInstance the fixed value of pattern parameter hostInstance, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance pHostInstance) {
      return rawCountMatches(new Object[]{pHostInstance});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pHostInstance the fixed value of pattern parameter hostInstance, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance pHostInstance, final Consumer<? super HostInstance.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pHostInstance}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pHostInstance the fixed value of pattern parameter hostInstance, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public HostInstance.Match newMatch(final org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance pHostInstance) {
      return HostInstance.Match.newMatch(pHostInstance);
    }
    
    /**
     * Retrieve the set of values that occur in matches for hostInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance> rawStreamAllValuesOfhostInstance(final Object[] parameters) {
      return rawStreamAllValues(POSITION_HOSTINSTANCE, parameters).map(org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for hostInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance> getAllValuesOfhostInstance() {
      return rawStreamAllValuesOfhostInstance(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for hostInstance.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance> streamAllValuesOfhostInstance() {
      return rawStreamAllValuesOfhostInstance(emptyArray());
    }
    
    @Override
    protected HostInstance.Match tupleToMatch(final Tuple t) {
      try {
          return HostInstance.Match.newMatch((org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance) t.get(POSITION_HOSTINSTANCE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected HostInstance.Match arrayToMatch(final Object[] match) {
      try {
          return HostInstance.Match.newMatch((org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance) match[POSITION_HOSTINSTANCE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected HostInstance.Match arrayToMatchMutable(final Object[] match) {
      try {
          return HostInstance.Match.newMutableMatch((org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance) match[POSITION_HOSTINSTANCE]);
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
    public static IQuerySpecification<HostInstance.Matcher> querySpecification() {
      return HostInstance.instance();
    }
  }
  
  private HostInstance() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static HostInstance instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected HostInstance.Matcher instantiate(final ViatraQueryEngine engine) {
    return HostInstance.Matcher.on(engine);
  }
  
  @Override
  public HostInstance.Matcher instantiate() {
    return HostInstance.Matcher.create();
  }
  
  @Override
  public HostInstance.Match newEmptyMatch() {
    return HostInstance.Match.newEmptyMatch();
  }
  
  @Override
  public HostInstance.Match newMatch(final Object... parameters) {
    return HostInstance.Match.newMatch((org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance) parameters[0]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.HostInstance (visibility: PUBLIC, simpleName: HostInstance, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.HostInstance, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.HostInstance (visibility: PUBLIC, simpleName: HostInstance, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.HostInstance, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final HostInstance INSTANCE = new HostInstance();
    
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
    private static final HostInstance.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_hostInstance = new PParameter("hostInstance", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "HostInstance")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_hostInstance);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.hostInstance";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("hostInstance");
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
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
          PVariable var___2_ = body.getOrCreateVariableByName("_<2>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_hostInstance), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "HostInstance")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_hostInstance, parameter_hostInstance)
          ));
          //     HostInstance(hostInstance)
          new TypeConstraint(body, Tuples.flatTupleOf(var_hostInstance), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "HostInstance")));
          //     neg find cps2depTrace(_, _, hostInstance, _)
          new NegativePatternCall(body, Tuples.flatTupleOf(var___0_, var___1_, var_hostInstance, var___2_), Cps2depTrace.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
