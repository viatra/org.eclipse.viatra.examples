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
import org.eclipse.viatra.dse.examples.bpmn.patterns.UnrequiredResourceInstanceMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.UnrequiredResourceInstanceQuerySpecification;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the org.eclipse.viatra.dse.examples.bpmn.patterns.unrequiredResourceInstance pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link UnrequiredResourceInstanceMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern unrequiredResourceInstance(RI : ResourceInstance) {
 * 	ResourceInstance.resourceTypeVariant(RI, RTV);
 * 	neg find taskNeedsVariant(_, RTV);
 * }
 * </pre></code>
 * 
 * @see UnrequiredResourceInstanceMatch
 * @see UnrequiredResourceInstanceProcessor
 * @see UnrequiredResourceInstanceQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class UnrequiredResourceInstanceMatcher extends BaseMatcher<UnrequiredResourceInstanceMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static UnrequiredResourceInstanceMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    UnrequiredResourceInstanceMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (UnrequiredResourceInstanceMatcher)engine.getMatcher(querySpecification());
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
  public static UnrequiredResourceInstanceMatcher create() throws ViatraQueryException {
    return new UnrequiredResourceInstanceMatcher();
  }
  
  private final static int POSITION_RI = 0;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(UnrequiredResourceInstanceMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private UnrequiredResourceInstanceMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRI the fixed value of pattern parameter RI, or null if not bound.
   * @return matches represented as a UnrequiredResourceInstanceMatch object.
   * 
   */
  public Collection<UnrequiredResourceInstanceMatch> getAllMatches(final ResourceInstance pRI) {
    return rawGetAllMatches(new Object[]{pRI});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRI the fixed value of pattern parameter RI, or null if not bound.
   * @return a match represented as a UnrequiredResourceInstanceMatch object, or null if no match is found.
   * 
   */
  public UnrequiredResourceInstanceMatch getOneArbitraryMatch(final ResourceInstance pRI) {
    return rawGetOneArbitraryMatch(new Object[]{pRI});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pRI the fixed value of pattern parameter RI, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final ResourceInstance pRI) {
    return rawHasMatch(new Object[]{pRI});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRI the fixed value of pattern parameter RI, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final ResourceInstance pRI) {
    return rawCountMatches(new Object[]{pRI});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pRI the fixed value of pattern parameter RI, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final ResourceInstance pRI, final IMatchProcessor<? super UnrequiredResourceInstanceMatch> processor) {
    rawForEachMatch(new Object[]{pRI}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRI the fixed value of pattern parameter RI, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final ResourceInstance pRI, final IMatchProcessor<? super UnrequiredResourceInstanceMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pRI}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRI the fixed value of pattern parameter RI, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public UnrequiredResourceInstanceMatch newMatch(final ResourceInstance pRI) {
    return UnrequiredResourceInstanceMatch.newMatch(pRI);
  }
  
  /**
   * Retrieve the set of values that occur in matches for RI.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<ResourceInstance> rawAccumulateAllValuesOfRI(final Object[] parameters) {
    Set<ResourceInstance> results = new HashSet<ResourceInstance>();
    rawAccumulateAllValues(POSITION_RI, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for RI.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ResourceInstance> getAllValuesOfRI() {
    return rawAccumulateAllValuesOfRI(emptyArray());
  }
  
  @Override
  protected UnrequiredResourceInstanceMatch tupleToMatch(final Tuple t) {
    try {
    	return UnrequiredResourceInstanceMatch.newMatch((ResourceInstance) t.get(POSITION_RI));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected UnrequiredResourceInstanceMatch arrayToMatch(final Object[] match) {
    try {
    	return UnrequiredResourceInstanceMatch.newMatch((ResourceInstance) match[POSITION_RI]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected UnrequiredResourceInstanceMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return UnrequiredResourceInstanceMatch.newMutableMatch((ResourceInstance) match[POSITION_RI]);
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
  public static IQuerySpecification<UnrequiredResourceInstanceMatcher> querySpecification() throws ViatraQueryException {
    return UnrequiredResourceInstanceQuerySpecification.instance();
  }
}
