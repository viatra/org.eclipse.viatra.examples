package org.eclipse.viatra.dse.examples.bpmn.patterns;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.viatra.dse.examples.bpmn.patterns.MakeSequentialMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.MakeSequentialQuerySpecification;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.Task;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the org.eclipse.viatra.dse.examples.bpmn.patterns.makeSequential pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link MakeSequentialMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern makeSequential(T1 : Task, T2 : Task, Root : SimplifiedBPMN) {
 * 	SimplifiedBPMN(Root);
 * 	ParallelGateway.outFlows.target(pg, T1);
 * 	ParallelGateway.outFlows.target(pg, T2);
 * 	T1 != T2;
 * 	N == count find parallelGatewayOutFlow(pg, _);
 * 	N == 2;
 * 	Task.outFlows.target(T1, pg2);
 * 	Task.outFlows.target(T2, pg2);
 * }
 * </pre></code>
 * 
 * @see MakeSequentialMatch
 * @see MakeSequentialProcessor
 * @see MakeSequentialQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class MakeSequentialMatcher extends BaseMatcher<MakeSequentialMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static MakeSequentialMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    MakeSequentialMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new MakeSequentialMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_T1 = 0;
  
  private final static int POSITION_T2 = 1;
  
  private final static int POSITION_ROOT = 2;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(MakeSequentialMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private MakeSequentialMatcher(final ViatraQueryEngine engine) throws ViatraQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pT1 the fixed value of pattern parameter T1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter T2, or null if not bound.
   * @param pRoot the fixed value of pattern parameter Root, or null if not bound.
   * @return matches represented as a MakeSequentialMatch object.
   * 
   */
  public Collection<MakeSequentialMatch> getAllMatches(final Task pT1, final Task pT2, final SimplifiedBPMN pRoot) {
    return rawGetAllMatches(new Object[]{pT1, pT2, pRoot});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pT1 the fixed value of pattern parameter T1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter T2, or null if not bound.
   * @param pRoot the fixed value of pattern parameter Root, or null if not bound.
   * @return a match represented as a MakeSequentialMatch object, or null if no match is found.
   * 
   */
  public MakeSequentialMatch getOneArbitraryMatch(final Task pT1, final Task pT2, final SimplifiedBPMN pRoot) {
    return rawGetOneArbitraryMatch(new Object[]{pT1, pT2, pRoot});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pT1 the fixed value of pattern parameter T1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter T2, or null if not bound.
   * @param pRoot the fixed value of pattern parameter Root, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Task pT1, final Task pT2, final SimplifiedBPMN pRoot) {
    return rawHasMatch(new Object[]{pT1, pT2, pRoot});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pT1 the fixed value of pattern parameter T1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter T2, or null if not bound.
   * @param pRoot the fixed value of pattern parameter Root, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Task pT1, final Task pT2, final SimplifiedBPMN pRoot) {
    return rawCountMatches(new Object[]{pT1, pT2, pRoot});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pT1 the fixed value of pattern parameter T1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter T2, or null if not bound.
   * @param pRoot the fixed value of pattern parameter Root, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Task pT1, final Task pT2, final SimplifiedBPMN pRoot, final IMatchProcessor<? super MakeSequentialMatch> processor) {
    rawForEachMatch(new Object[]{pT1, pT2, pRoot}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pT1 the fixed value of pattern parameter T1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter T2, or null if not bound.
   * @param pRoot the fixed value of pattern parameter Root, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Task pT1, final Task pT2, final SimplifiedBPMN pRoot, final IMatchProcessor<? super MakeSequentialMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pT1, pT2, pRoot}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pT1 the fixed value of pattern parameter T1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter T2, or null if not bound.
   * @param pRoot the fixed value of pattern parameter Root, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public MakeSequentialMatch newMatch(final Task pT1, final Task pT2, final SimplifiedBPMN pRoot) {
    return MakeSequentialMatch.newMatch(pT1, pT2, pRoot);
  }
  
  /**
   * Retrieve the set of values that occur in matches for T1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Task> rawAccumulateAllValuesOfT1(final Object[] parameters) {
    Set<Task> results = new HashSet<Task>();
    rawAccumulateAllValues(POSITION_T1, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for T1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Task> getAllValuesOfT1() {
    return rawAccumulateAllValuesOfT1(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for T1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Task> getAllValuesOfT1(final MakeSequentialMatch partialMatch) {
    return rawAccumulateAllValuesOfT1(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for T1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Task> getAllValuesOfT1(final Task pT2, final SimplifiedBPMN pRoot) {
    return rawAccumulateAllValuesOfT1(new Object[]{
    null, 
    pT2, 
    pRoot
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for T2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Task> rawAccumulateAllValuesOfT2(final Object[] parameters) {
    Set<Task> results = new HashSet<Task>();
    rawAccumulateAllValues(POSITION_T2, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for T2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Task> getAllValuesOfT2() {
    return rawAccumulateAllValuesOfT2(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for T2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Task> getAllValuesOfT2(final MakeSequentialMatch partialMatch) {
    return rawAccumulateAllValuesOfT2(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for T2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Task> getAllValuesOfT2(final Task pT1, final SimplifiedBPMN pRoot) {
    return rawAccumulateAllValuesOfT2(new Object[]{
    pT1, 
    null, 
    pRoot
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for Root.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<SimplifiedBPMN> rawAccumulateAllValuesOfRoot(final Object[] parameters) {
    Set<SimplifiedBPMN> results = new HashSet<SimplifiedBPMN>();
    rawAccumulateAllValues(POSITION_ROOT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for Root.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimplifiedBPMN> getAllValuesOfRoot() {
    return rawAccumulateAllValuesOfRoot(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Root.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimplifiedBPMN> getAllValuesOfRoot(final MakeSequentialMatch partialMatch) {
    return rawAccumulateAllValuesOfRoot(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Root.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimplifiedBPMN> getAllValuesOfRoot(final Task pT1, final Task pT2) {
    return rawAccumulateAllValuesOfRoot(new Object[]{
    pT1, 
    pT2, 
    null
    });
  }
  
  @Override
  protected MakeSequentialMatch tupleToMatch(final Tuple t) {
    try {
    	return MakeSequentialMatch.newMatch((Task) t.get(POSITION_T1), (Task) t.get(POSITION_T2), (SimplifiedBPMN) t.get(POSITION_ROOT));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MakeSequentialMatch arrayToMatch(final Object[] match) {
    try {
    	return MakeSequentialMatch.newMatch((Task) match[POSITION_T1], (Task) match[POSITION_T2], (SimplifiedBPMN) match[POSITION_ROOT]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MakeSequentialMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return MakeSequentialMatch.newMutableMatch((Task) match[POSITION_T1], (Task) match[POSITION_T2], (SimplifiedBPMN) match[POSITION_ROOT]);
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
  public static IQuerySpecification<MakeSequentialMatcher> querySpecification() throws ViatraQueryException {
    return MakeSequentialQuerySpecification.instance();
  }
}
