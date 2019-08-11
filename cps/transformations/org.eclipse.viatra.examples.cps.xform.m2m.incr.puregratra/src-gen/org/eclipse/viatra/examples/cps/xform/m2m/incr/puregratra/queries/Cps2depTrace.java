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
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Identifiable;
import org.eclipse.viatra.examples.cps.deployment.DeploymentElement;
import org.eclipse.viatra.examples.cps.traceability.CPS2DeploymentTrace;
import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment;
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
 *         General-Use Patterns 
 *         
 *         pattern cps2depTrace(cps2dep : CPSToDeployment, trace : CPS2DeploymentTrace, cpsElement : Identifiable, depElement : DeploymentElement) {
 *             CPSToDeployment.traces(cps2dep, trace);
 *             CPS2DeploymentTrace.cpsElements(trace, cpsElement);
 *             CPS2DeploymentTrace.deploymentElements(trace, depElement);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtext.xbase.compiler.JvmModelGenerator")
public final class Cps2depTrace extends BaseGeneratedEMFQuerySpecification<Cps2depTrace.Matcher> {
  /**
   * Pattern-specific match representation of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.cps2depTrace pattern,
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
    private CPSToDeployment fCps2dep;
    
    private CPS2DeploymentTrace fTrace;
    
    private Identifiable fCpsElement;
    
    private DeploymentElement fDepElement;
    
    private static List<String> parameterNames = makeImmutableList("cps2dep", "trace", "cpsElement", "depElement");
    
    private Match(final CPSToDeployment pCps2dep, final CPS2DeploymentTrace pTrace, final Identifiable pCpsElement, final DeploymentElement pDepElement) {
      this.fCps2dep = pCps2dep;
      this.fTrace = pTrace;
      this.fCpsElement = pCpsElement;
      this.fDepElement = pDepElement;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("cps2dep".equals(parameterName)) return this.fCps2dep;
      if ("trace".equals(parameterName)) return this.fTrace;
      if ("cpsElement".equals(parameterName)) return this.fCpsElement;
      if ("depElement".equals(parameterName)) return this.fDepElement;
      return null;
    }
    
    public CPSToDeployment getCps2dep() {
      return this.fCps2dep;
    }
    
    public CPS2DeploymentTrace getTrace() {
      return this.fTrace;
    }
    
    public Identifiable getCpsElement() {
      return this.fCpsElement;
    }
    
    public DeploymentElement getDepElement() {
      return this.fDepElement;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("cps2dep".equals(parameterName) ) {
          this.fCps2dep = (CPSToDeployment) newValue;
          return true;
      }
      if ("trace".equals(parameterName) ) {
          this.fTrace = (CPS2DeploymentTrace) newValue;
          return true;
      }
      if ("cpsElement".equals(parameterName) ) {
          this.fCpsElement = (Identifiable) newValue;
          return true;
      }
      if ("depElement".equals(parameterName) ) {
          this.fDepElement = (DeploymentElement) newValue;
          return true;
      }
      return false;
    }
    
    public void setCps2dep(final CPSToDeployment pCps2dep) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fCps2dep = pCps2dep;
    }
    
    public void setTrace(final CPS2DeploymentTrace pTrace) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTrace = pTrace;
    }
    
    public void setCpsElement(final Identifiable pCpsElement) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fCpsElement = pCpsElement;
    }
    
    public void setDepElement(final DeploymentElement pDepElement) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fDepElement = pDepElement;
    }
    
    @Override
    public String patternName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.cps2depTrace";
    }
    
    @Override
    public List<String> parameterNames() {
      return Cps2depTrace.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fCps2dep, fTrace, fCpsElement, fDepElement};
    }
    
    @Override
    public Cps2depTrace.Match toImmutable() {
      return isMutable() ? newMatch(fCps2dep, fTrace, fCpsElement, fDepElement) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"cps2dep\"=" + prettyPrintValue(fCps2dep) + ", ");
      result.append("\"trace\"=" + prettyPrintValue(fTrace) + ", ");
      result.append("\"cpsElement\"=" + prettyPrintValue(fCpsElement) + ", ");
      result.append("\"depElement\"=" + prettyPrintValue(fDepElement));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fCps2dep, fTrace, fCpsElement, fDepElement);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof Cps2depTrace.Match)) {
          Cps2depTrace.Match other = (Cps2depTrace.Match) obj;
          return Objects.equals(fCps2dep, other.fCps2dep) && Objects.equals(fTrace, other.fTrace) && Objects.equals(fCpsElement, other.fCpsElement) && Objects.equals(fDepElement, other.fDepElement);
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
    public Cps2depTrace specification() {
      return Cps2depTrace.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static Cps2depTrace.Match newEmptyMatch() {
      return new Mutable(null, null, null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pCps2dep the fixed value of pattern parameter cps2dep, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pCpsElement the fixed value of pattern parameter cpsElement, or null if not bound.
     * @param pDepElement the fixed value of pattern parameter depElement, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static Cps2depTrace.Match newMutableMatch(final CPSToDeployment pCps2dep, final CPS2DeploymentTrace pTrace, final Identifiable pCpsElement, final DeploymentElement pDepElement) {
      return new Mutable(pCps2dep, pTrace, pCpsElement, pDepElement);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pCps2dep the fixed value of pattern parameter cps2dep, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pCpsElement the fixed value of pattern parameter cpsElement, or null if not bound.
     * @param pDepElement the fixed value of pattern parameter depElement, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static Cps2depTrace.Match newMatch(final CPSToDeployment pCps2dep, final CPS2DeploymentTrace pTrace, final Identifiable pCpsElement, final DeploymentElement pDepElement) {
      return new Immutable(pCps2dep, pTrace, pCpsElement, pDepElement);
    }
    
    private static final class Mutable extends Cps2depTrace.Match {
      Mutable(final CPSToDeployment pCps2dep, final CPS2DeploymentTrace pTrace, final Identifiable pCpsElement, final DeploymentElement pDepElement) {
        super(pCps2dep, pTrace, pCpsElement, pDepElement);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends Cps2depTrace.Match {
      Immutable(final CPSToDeployment pCps2dep, final CPS2DeploymentTrace pTrace, final Identifiable pCpsElement, final DeploymentElement pDepElement) {
        super(pCps2dep, pTrace, pCpsElement, pDepElement);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.cps2depTrace pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * General-Use Patterns 
   * 
   * pattern cps2depTrace(cps2dep : CPSToDeployment, trace : CPS2DeploymentTrace, cpsElement : Identifiable, depElement : DeploymentElement) {
   *     CPSToDeployment.traces(cps2dep, trace);
   *     CPS2DeploymentTrace.cpsElements(trace, cpsElement);
   *     CPS2DeploymentTrace.deploymentElements(trace, depElement);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see Cps2depTrace
   * 
   */
  public static class Matcher extends BaseMatcher<Cps2depTrace.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static Cps2depTrace.Matcher on(final ViatraQueryEngine engine) {
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
    public static Cps2depTrace.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_CPS2DEP = 0;
    
    private static final int POSITION_TRACE = 1;
    
    private static final int POSITION_CPSELEMENT = 2;
    
    private static final int POSITION_DEPELEMENT = 3;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(Cps2depTrace.Matcher.class);
    
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
     * @param pCps2dep the fixed value of pattern parameter cps2dep, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pCpsElement the fixed value of pattern parameter cpsElement, or null if not bound.
     * @param pDepElement the fixed value of pattern parameter depElement, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<Cps2depTrace.Match> getAllMatches(final CPSToDeployment pCps2dep, final CPS2DeploymentTrace pTrace, final Identifiable pCpsElement, final DeploymentElement pDepElement) {
      return rawStreamAllMatches(new Object[]{pCps2dep, pTrace, pCpsElement, pDepElement}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pCps2dep the fixed value of pattern parameter cps2dep, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pCpsElement the fixed value of pattern parameter cpsElement, or null if not bound.
     * @param pDepElement the fixed value of pattern parameter depElement, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<Cps2depTrace.Match> streamAllMatches(final CPSToDeployment pCps2dep, final CPS2DeploymentTrace pTrace, final Identifiable pCpsElement, final DeploymentElement pDepElement) {
      return rawStreamAllMatches(new Object[]{pCps2dep, pTrace, pCpsElement, pDepElement});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pCps2dep the fixed value of pattern parameter cps2dep, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pCpsElement the fixed value of pattern parameter cpsElement, or null if not bound.
     * @param pDepElement the fixed value of pattern parameter depElement, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<Cps2depTrace.Match> getOneArbitraryMatch(final CPSToDeployment pCps2dep, final CPS2DeploymentTrace pTrace, final Identifiable pCpsElement, final DeploymentElement pDepElement) {
      return rawGetOneArbitraryMatch(new Object[]{pCps2dep, pTrace, pCpsElement, pDepElement});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pCps2dep the fixed value of pattern parameter cps2dep, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pCpsElement the fixed value of pattern parameter cpsElement, or null if not bound.
     * @param pDepElement the fixed value of pattern parameter depElement, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final CPSToDeployment pCps2dep, final CPS2DeploymentTrace pTrace, final Identifiable pCpsElement, final DeploymentElement pDepElement) {
      return rawHasMatch(new Object[]{pCps2dep, pTrace, pCpsElement, pDepElement});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pCps2dep the fixed value of pattern parameter cps2dep, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pCpsElement the fixed value of pattern parameter cpsElement, or null if not bound.
     * @param pDepElement the fixed value of pattern parameter depElement, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final CPSToDeployment pCps2dep, final CPS2DeploymentTrace pTrace, final Identifiable pCpsElement, final DeploymentElement pDepElement) {
      return rawCountMatches(new Object[]{pCps2dep, pTrace, pCpsElement, pDepElement});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pCps2dep the fixed value of pattern parameter cps2dep, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pCpsElement the fixed value of pattern parameter cpsElement, or null if not bound.
     * @param pDepElement the fixed value of pattern parameter depElement, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final CPSToDeployment pCps2dep, final CPS2DeploymentTrace pTrace, final Identifiable pCpsElement, final DeploymentElement pDepElement, final Consumer<? super Cps2depTrace.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pCps2dep, pTrace, pCpsElement, pDepElement}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pCps2dep the fixed value of pattern parameter cps2dep, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pCpsElement the fixed value of pattern parameter cpsElement, or null if not bound.
     * @param pDepElement the fixed value of pattern parameter depElement, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public Cps2depTrace.Match newMatch(final CPSToDeployment pCps2dep, final CPS2DeploymentTrace pTrace, final Identifiable pCpsElement, final DeploymentElement pDepElement) {
      return Cps2depTrace.Match.newMatch(pCps2dep, pTrace, pCpsElement, pDepElement);
    }
    
    /**
     * Retrieve the set of values that occur in matches for cps2dep.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<CPSToDeployment> rawStreamAllValuesOfcps2dep(final Object[] parameters) {
      return rawStreamAllValues(POSITION_CPS2DEP, parameters).map(CPSToDeployment.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for cps2dep.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<CPSToDeployment> getAllValuesOfcps2dep() {
      return rawStreamAllValuesOfcps2dep(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for cps2dep.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<CPSToDeployment> streamAllValuesOfcps2dep() {
      return rawStreamAllValuesOfcps2dep(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for cps2dep.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<CPSToDeployment> streamAllValuesOfcps2dep(final Cps2depTrace.Match partialMatch) {
      return rawStreamAllValuesOfcps2dep(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for cps2dep.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<CPSToDeployment> streamAllValuesOfcps2dep(final CPS2DeploymentTrace pTrace, final Identifiable pCpsElement, final DeploymentElement pDepElement) {
      return rawStreamAllValuesOfcps2dep(new Object[]{null, pTrace, pCpsElement, pDepElement});
    }
    
    /**
     * Retrieve the set of values that occur in matches for cps2dep.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<CPSToDeployment> getAllValuesOfcps2dep(final Cps2depTrace.Match partialMatch) {
      return rawStreamAllValuesOfcps2dep(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for cps2dep.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<CPSToDeployment> getAllValuesOfcps2dep(final CPS2DeploymentTrace pTrace, final Identifiable pCpsElement, final DeploymentElement pDepElement) {
      return rawStreamAllValuesOfcps2dep(new Object[]{null, pTrace, pCpsElement, pDepElement}).collect(Collectors.toSet());
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
    public Stream<CPS2DeploymentTrace> streamAllValuesOftrace(final Cps2depTrace.Match partialMatch) {
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
    public Stream<CPS2DeploymentTrace> streamAllValuesOftrace(final CPSToDeployment pCps2dep, final Identifiable pCpsElement, final DeploymentElement pDepElement) {
      return rawStreamAllValuesOftrace(new Object[]{pCps2dep, null, pCpsElement, pDepElement});
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<CPS2DeploymentTrace> getAllValuesOftrace(final Cps2depTrace.Match partialMatch) {
      return rawStreamAllValuesOftrace(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<CPS2DeploymentTrace> getAllValuesOftrace(final CPSToDeployment pCps2dep, final Identifiable pCpsElement, final DeploymentElement pDepElement) {
      return rawStreamAllValuesOftrace(new Object[]{pCps2dep, null, pCpsElement, pDepElement}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for cpsElement.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Identifiable> rawStreamAllValuesOfcpsElement(final Object[] parameters) {
      return rawStreamAllValues(POSITION_CPSELEMENT, parameters).map(Identifiable.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for cpsElement.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Identifiable> getAllValuesOfcpsElement() {
      return rawStreamAllValuesOfcpsElement(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for cpsElement.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Identifiable> streamAllValuesOfcpsElement() {
      return rawStreamAllValuesOfcpsElement(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for cpsElement.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Identifiable> streamAllValuesOfcpsElement(final Cps2depTrace.Match partialMatch) {
      return rawStreamAllValuesOfcpsElement(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for cpsElement.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Identifiable> streamAllValuesOfcpsElement(final CPSToDeployment pCps2dep, final CPS2DeploymentTrace pTrace, final DeploymentElement pDepElement) {
      return rawStreamAllValuesOfcpsElement(new Object[]{pCps2dep, pTrace, null, pDepElement});
    }
    
    /**
     * Retrieve the set of values that occur in matches for cpsElement.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Identifiable> getAllValuesOfcpsElement(final Cps2depTrace.Match partialMatch) {
      return rawStreamAllValuesOfcpsElement(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for cpsElement.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Identifiable> getAllValuesOfcpsElement(final CPSToDeployment pCps2dep, final CPS2DeploymentTrace pTrace, final DeploymentElement pDepElement) {
      return rawStreamAllValuesOfcpsElement(new Object[]{pCps2dep, pTrace, null, pDepElement}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depElement.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<DeploymentElement> rawStreamAllValuesOfdepElement(final Object[] parameters) {
      return rawStreamAllValues(POSITION_DEPELEMENT, parameters).map(DeploymentElement.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for depElement.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DeploymentElement> getAllValuesOfdepElement() {
      return rawStreamAllValuesOfdepElement(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depElement.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<DeploymentElement> streamAllValuesOfdepElement() {
      return rawStreamAllValuesOfdepElement(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depElement.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<DeploymentElement> streamAllValuesOfdepElement(final Cps2depTrace.Match partialMatch) {
      return rawStreamAllValuesOfdepElement(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depElement.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<DeploymentElement> streamAllValuesOfdepElement(final CPSToDeployment pCps2dep, final CPS2DeploymentTrace pTrace, final Identifiable pCpsElement) {
      return rawStreamAllValuesOfdepElement(new Object[]{pCps2dep, pTrace, pCpsElement, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for depElement.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DeploymentElement> getAllValuesOfdepElement(final Cps2depTrace.Match partialMatch) {
      return rawStreamAllValuesOfdepElement(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for depElement.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DeploymentElement> getAllValuesOfdepElement(final CPSToDeployment pCps2dep, final CPS2DeploymentTrace pTrace, final Identifiable pCpsElement) {
      return rawStreamAllValuesOfdepElement(new Object[]{pCps2dep, pTrace, pCpsElement, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected Cps2depTrace.Match tupleToMatch(final Tuple t) {
      try {
          return Cps2depTrace.Match.newMatch((CPSToDeployment) t.get(POSITION_CPS2DEP), (CPS2DeploymentTrace) t.get(POSITION_TRACE), (Identifiable) t.get(POSITION_CPSELEMENT), (DeploymentElement) t.get(POSITION_DEPELEMENT));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected Cps2depTrace.Match arrayToMatch(final Object[] match) {
      try {
          return Cps2depTrace.Match.newMatch((CPSToDeployment) match[POSITION_CPS2DEP], (CPS2DeploymentTrace) match[POSITION_TRACE], (Identifiable) match[POSITION_CPSELEMENT], (DeploymentElement) match[POSITION_DEPELEMENT]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected Cps2depTrace.Match arrayToMatchMutable(final Object[] match) {
      try {
          return Cps2depTrace.Match.newMutableMatch((CPSToDeployment) match[POSITION_CPS2DEP], (CPS2DeploymentTrace) match[POSITION_TRACE], (Identifiable) match[POSITION_CPSELEMENT], (DeploymentElement) match[POSITION_DEPELEMENT]);
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
    public static IQuerySpecification<Cps2depTrace.Matcher> querySpecification() {
      return Cps2depTrace.instance();
    }
  }
  
  private Cps2depTrace() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static Cps2depTrace instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected Cps2depTrace.Matcher instantiate(final ViatraQueryEngine engine) {
    return Cps2depTrace.Matcher.on(engine);
  }
  
  @Override
  public Cps2depTrace.Matcher instantiate() {
    return Cps2depTrace.Matcher.create();
  }
  
  @Override
  public Cps2depTrace.Match newEmptyMatch() {
    return Cps2depTrace.Match.newEmptyMatch();
  }
  
  @Override
  public Cps2depTrace.Match newMatch(final Object... parameters) {
    return Cps2depTrace.Match.newMatch((org.eclipse.viatra.examples.cps.traceability.CPSToDeployment) parameters[0], (org.eclipse.viatra.examples.cps.traceability.CPS2DeploymentTrace) parameters[1], (org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Identifiable) parameters[2], (org.eclipse.viatra.examples.cps.deployment.DeploymentElement) parameters[3]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.Cps2depTrace (visibility: PUBLIC, simpleName: Cps2depTrace, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.Cps2depTrace, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.Cps2depTrace (visibility: PUBLIC, simpleName: Cps2depTrace, identifier: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.Cps2depTrace, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final Cps2depTrace INSTANCE = new Cps2depTrace();
    
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
    private static final Cps2depTrace.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_cps2dep = new PParameter("cps2dep", "org.eclipse.viatra.examples.cps.traceability.CPSToDeployment", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps-traceability", "CPSToDeployment")), PParameterDirection.INOUT);
    
    private final PParameter parameter_trace = new PParameter("trace", "org.eclipse.viatra.examples.cps.traceability.CPS2DeploymentTrace", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace")), PParameterDirection.INOUT);
    
    private final PParameter parameter_cpsElement = new PParameter("cpsElement", "org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Identifiable", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/cps", "Identifiable")), PParameterDirection.INOUT);
    
    private final PParameter parameter_depElement = new PParameter("depElement", "org.eclipse.viatra.examples.cps.deployment.DeploymentElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://org.eclipse.viatra/model/deployment", "DeploymentElement")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_cps2dep, parameter_trace, parameter_cpsElement, parameter_depElement);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.examples.cps.xform.m2m.incr.puregratra.queries.cps2depTrace";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("cps2dep","trace","cpsElement","depElement");
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
          PVariable var_cps2dep = body.getOrCreateVariableByName("cps2dep");
          PVariable var_trace = body.getOrCreateVariableByName("trace");
          PVariable var_cpsElement = body.getOrCreateVariableByName("cpsElement");
          PVariable var_depElement = body.getOrCreateVariableByName("depElement");
          new TypeConstraint(body, Tuples.flatTupleOf(var_cps2dep), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps-traceability", "CPSToDeployment")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_cpsElement), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "Identifiable")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_depElement), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "DeploymentElement")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_cps2dep, parameter_cps2dep),
             new ExportedParameter(body, var_trace, parameter_trace),
             new ExportedParameter(body, var_cpsElement, parameter_cpsElement),
             new ExportedParameter(body, var_depElement, parameter_depElement)
          ));
          //     CPSToDeployment.traces(cps2dep, trace)
          new TypeConstraint(body, Tuples.flatTupleOf(var_cps2dep), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps-traceability", "CPSToDeployment")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_cps2dep, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/cps-traceability", "CPSToDeployment", "traces")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace")));
          new Equality(body, var__virtual_0_, var_trace);
          //     CPS2DeploymentTrace.cpsElements(trace, cpsElement)
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace", "cpsElements")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps", "Identifiable")));
          new Equality(body, var__virtual_1_, var_cpsElement);
          //     CPS2DeploymentTrace.deploymentElements(trace, depElement)
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://org.eclipse.viatra/model/cps-traceability", "CPS2DeploymentTrace", "deploymentElements")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://org.eclipse.viatra/model/deployment", "DeploymentElement")));
          new Equality(body, var__virtual_2_, var_depElement);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
