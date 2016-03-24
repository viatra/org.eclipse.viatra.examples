package org.eclipse.viatra.dse.examples.bpmn.patterns;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.viatra.dse.examples.bpmn.patterns.AbsenceOfResourceInstancesMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.AbsenceOfResourceInstancesQuerySpecification;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the org.eclipse.viatra.dse.examples.bpmn.patterns.absenceOfResourceInstances pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link AbsenceOfResourceInstancesMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern absenceOfResourceInstances(RTV : ResourceTypeVariant) {
 * 	neg find instanceOfVariant(_, RTV);
 * 	Task.variant(_, RTV);
 * }
 * </pre></code>
 * 
 * @see AbsenceOfResourceInstancesMatch
 * @see AbsenceOfResourceInstancesProcessor
 * @see AbsenceOfResourceInstancesQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class AbsenceOfResourceInstancesMatcher extends BaseMatcher<AbsenceOfResourceInstancesMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static AbsenceOfResourceInstancesMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    AbsenceOfResourceInstancesMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new AbsenceOfResourceInstancesMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_RTV = 0;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(AbsenceOfResourceInstancesMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private AbsenceOfResourceInstancesMatcher(final ViatraQueryEngine engine) throws ViatraQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRTV the fixed value of pattern parameter RTV, or null if not bound.
   * @return matches represented as a AbsenceOfResourceInstancesMatch object.
   * 
   */
  public Collection<AbsenceOfResourceInstancesMatch> getAllMatches(final ResourceTypeVariant pRTV) {
    return rawGetAllMatches(new Object[]{pRTV});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRTV the fixed value of pattern parameter RTV, or null if not bound.
   * @return a match represented as a AbsenceOfResourceInstancesMatch object, or null if no match is found.
   * 
   */
  public AbsenceOfResourceInstancesMatch getOneArbitraryMatch(final ResourceTypeVariant pRTV) {
    return rawGetOneArbitraryMatch(new Object[]{pRTV});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pRTV the fixed value of pattern parameter RTV, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final ResourceTypeVariant pRTV) {
    return rawHasMatch(new Object[]{pRTV});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRTV the fixed value of pattern parameter RTV, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final ResourceTypeVariant pRTV) {
    return rawCountMatches(new Object[]{pRTV});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pRTV the fixed value of pattern parameter RTV, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final ResourceTypeVariant pRTV, final IMatchProcessor<? super AbsenceOfResourceInstancesMatch> processor) {
    rawForEachMatch(new Object[]{pRTV}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRTV the fixed value of pattern parameter RTV, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final ResourceTypeVariant pRTV, final IMatchProcessor<? super AbsenceOfResourceInstancesMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pRTV}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRTV the fixed value of pattern parameter RTV, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public AbsenceOfResourceInstancesMatch newMatch(final ResourceTypeVariant pRTV) {
    return AbsenceOfResourceInstancesMatch.newMatch(pRTV);
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
  
  @Override
  protected AbsenceOfResourceInstancesMatch tupleToMatch(final Tuple t) {
    try {
    	return AbsenceOfResourceInstancesMatch.newMatch((ResourceTypeVariant) t.get(POSITION_RTV));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected AbsenceOfResourceInstancesMatch arrayToMatch(final Object[] match) {
    try {
    	return AbsenceOfResourceInstancesMatch.newMatch((ResourceTypeVariant) match[POSITION_RTV]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected AbsenceOfResourceInstancesMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return AbsenceOfResourceInstancesMatch.newMutableMatch((ResourceTypeVariant) match[POSITION_RTV]);
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
  public static IQuerySpecification<AbsenceOfResourceInstancesMatcher> querySpecification() throws ViatraQueryException {
    return AbsenceOfResourceInstancesQuerySpecification.instance();
  }
}
