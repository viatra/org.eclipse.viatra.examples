/**
 * 
 *   Copyright (c) 2010-2015, Andras Szabolcs Nagy, Abel Hegedus, Akos Horvath, Zoltan Ujhelyi and Daniel Varro
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *   Contributors:
 *     Andras Szabolcs Nagy - initial API and implementation
 *  
 */
package org.eclipse.viatra.dse.examples.bpmn.patterns;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.viatra.dse.examples.bpmn.patterns.VariantAllocatedToTaskMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.VariantAllocatedToTaskQuerySpecification;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.Task;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the org.eclipse.viatra.dse.examples.bpmn.patterns.variantAllocatedToTask pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link VariantAllocatedToTaskMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern variantAllocatedToTask(T : Task, RTV : ResourceTypeVariant) {
 * 	Task.variant(T, RTV);
 * }
 * </pre></code>
 * 
 * @see VariantAllocatedToTaskMatch
 * @see VariantAllocatedToTaskProcessor
 * @see VariantAllocatedToTaskQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class VariantAllocatedToTaskMatcher extends BaseMatcher<VariantAllocatedToTaskMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static VariantAllocatedToTaskMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    VariantAllocatedToTaskMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (VariantAllocatedToTaskMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static VariantAllocatedToTaskMatcher create() throws ViatraQueryException {
    return new VariantAllocatedToTaskMatcher();
  }
  
  private final static int POSITION_T = 0;
  
  private final static int POSITION_RTV = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(VariantAllocatedToTaskMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private VariantAllocatedToTaskMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pT the fixed value of pattern parameter T, or null if not bound.
   * @param pRTV the fixed value of pattern parameter RTV, or null if not bound.
   * @return matches represented as a VariantAllocatedToTaskMatch object.
   * 
   */
  public Collection<VariantAllocatedToTaskMatch> getAllMatches(final Task pT, final ResourceTypeVariant pRTV) {
    return rawGetAllMatches(new Object[]{pT, pRTV});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pT the fixed value of pattern parameter T, or null if not bound.
   * @param pRTV the fixed value of pattern parameter RTV, or null if not bound.
   * @return a match represented as a VariantAllocatedToTaskMatch object, or null if no match is found.
   * 
   */
  public VariantAllocatedToTaskMatch getOneArbitraryMatch(final Task pT, final ResourceTypeVariant pRTV) {
    return rawGetOneArbitraryMatch(new Object[]{pT, pRTV});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pT the fixed value of pattern parameter T, or null if not bound.
   * @param pRTV the fixed value of pattern parameter RTV, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Task pT, final ResourceTypeVariant pRTV) {
    return rawHasMatch(new Object[]{pT, pRTV});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pT the fixed value of pattern parameter T, or null if not bound.
   * @param pRTV the fixed value of pattern parameter RTV, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Task pT, final ResourceTypeVariant pRTV) {
    return rawCountMatches(new Object[]{pT, pRTV});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pT the fixed value of pattern parameter T, or null if not bound.
   * @param pRTV the fixed value of pattern parameter RTV, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Task pT, final ResourceTypeVariant pRTV, final IMatchProcessor<? super VariantAllocatedToTaskMatch> processor) {
    rawForEachMatch(new Object[]{pT, pRTV}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pT the fixed value of pattern parameter T, or null if not bound.
   * @param pRTV the fixed value of pattern parameter RTV, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Task pT, final ResourceTypeVariant pRTV, final IMatchProcessor<? super VariantAllocatedToTaskMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pT, pRTV}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pT the fixed value of pattern parameter T, or null if not bound.
   * @param pRTV the fixed value of pattern parameter RTV, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public VariantAllocatedToTaskMatch newMatch(final Task pT, final ResourceTypeVariant pRTV) {
    return VariantAllocatedToTaskMatch.newMatch(pT, pRTV);
  }
  
  /**
   * Retrieve the set of values that occur in matches for T.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Task> rawAccumulateAllValuesOfT(final Object[] parameters) {
    Set<Task> results = new HashSet<Task>();
    rawAccumulateAllValues(POSITION_T, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for T.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Task> getAllValuesOfT() {
    return rawAccumulateAllValuesOfT(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for T.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Task> getAllValuesOfT(final VariantAllocatedToTaskMatch partialMatch) {
    return rawAccumulateAllValuesOfT(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for T.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Task> getAllValuesOfT(final ResourceTypeVariant pRTV) {
    return rawAccumulateAllValuesOfT(new Object[]{
    null, 
    pRTV
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for RTV.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<ResourceTypeVariant> rawAccumulateAllValuesOfRTV(final Object[] parameters) {
    Set<ResourceTypeVariant> results = new HashSet<ResourceTypeVariant>();
    rawAccumulateAllValues(POSITION_RTV, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for RTV.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ResourceTypeVariant> getAllValuesOfRTV() {
    return rawAccumulateAllValuesOfRTV(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for RTV.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ResourceTypeVariant> getAllValuesOfRTV(final VariantAllocatedToTaskMatch partialMatch) {
    return rawAccumulateAllValuesOfRTV(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for RTV.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ResourceTypeVariant> getAllValuesOfRTV(final Task pT) {
    return rawAccumulateAllValuesOfRTV(new Object[]{
    pT, 
    null
    });
  }
  
  @Override
  protected VariantAllocatedToTaskMatch tupleToMatch(final Tuple t) {
    try {
    	return VariantAllocatedToTaskMatch.newMatch((Task) t.get(POSITION_T), (ResourceTypeVariant) t.get(POSITION_RTV));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected VariantAllocatedToTaskMatch arrayToMatch(final Object[] match) {
    try {
    	return VariantAllocatedToTaskMatch.newMatch((Task) match[POSITION_T], (ResourceTypeVariant) match[POSITION_RTV]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected VariantAllocatedToTaskMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return VariantAllocatedToTaskMatch.newMutableMatch((Task) match[POSITION_T], (ResourceTypeVariant) match[POSITION_RTV]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<VariantAllocatedToTaskMatcher> querySpecification() throws ViatraQueryException {
    return VariantAllocatedToTaskQuerySpecification.instance();
  }
}
