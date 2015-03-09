package org.eclipse.viatra.dse.examples.bpmn.patterns;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.MakeParallelQuerySpecification;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.Task;

/**
 * Pattern-specific match representation of the org.eclipse.viatra.dse.examples.bpmn.patterns.makeParallel pattern,
 * to be used in conjunction with {@link MakeParallelMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see MakeParallelMatcher
 * @see MakeParallelProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class MakeParallelMatch extends BasePatternMatch {
  private Task fT1;
  
  private Task fT2;
  
  private SimplifiedBPMN fRoot;
  
  private static List<String> parameterNames = makeImmutableList("T1", "T2", "Root");
  
  private MakeParallelMatch(final Task pT1, final Task pT2, final SimplifiedBPMN pRoot) {
    this.fT1 = pT1;
    this.fT2 = pT2;
    this.fRoot = pRoot;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("T1".equals(parameterName)) return this.fT1;
    if ("T2".equals(parameterName)) return this.fT2;
    if ("Root".equals(parameterName)) return this.fRoot;
    return null;
  }
  
  public Task getT1() {
    return this.fT1;
  }
  
  public Task getT2() {
    return this.fT2;
  }
  
  public SimplifiedBPMN getRoot() {
    return this.fRoot;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("T1".equals(parameterName) ) {
    	this.fT1 = (org.eclipse.viatra.dse.examples.simplifiedbpmn.Task) newValue;
    	return true;
    }
    if ("T2".equals(parameterName) ) {
    	this.fT2 = (org.eclipse.viatra.dse.examples.simplifiedbpmn.Task) newValue;
    	return true;
    }
    if ("Root".equals(parameterName) ) {
    	this.fRoot = (org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN) newValue;
    	return true;
    }
    return false;
  }
  
  public void setT1(final Task pT1) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fT1 = pT1;
  }
  
  public void setT2(final Task pT2) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fT2 = pT2;
  }
  
  public void setRoot(final SimplifiedBPMN pRoot) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRoot = pRoot;
  }
  
  @Override
  public String patternName() {
    return "org.eclipse.viatra.dse.examples.bpmn.patterns.makeParallel";
  }
  
  @Override
  public List<String> parameterNames() {
    return MakeParallelMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fT1, fT2, fRoot};
  }
  
  @Override
  public MakeParallelMatch toImmutable() {
    return isMutable() ? newMatch(fT1, fT2, fRoot) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"T1\"=" + prettyPrintValue(fT1) + ", ");
    
    result.append("\"T2\"=" + prettyPrintValue(fT2) + ", ");
    
    result.append("\"Root\"=" + prettyPrintValue(fRoot)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fT1 == null) ? 0 : fT1.hashCode());
    result = prime * result + ((fT2 == null) ? 0 : fT2.hashCode());
    result = prime * result + ((fRoot == null) ? 0 : fRoot.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof MakeParallelMatch)) { // this should be infrequent
    	if (obj == null) {
    		return false;
    	}
    	if (!(obj instanceof IPatternMatch)) {
    		return false;
    	}
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    MakeParallelMatch other = (MakeParallelMatch) obj;
    if (fT1 == null) {if (other.fT1 != null) return false;}
    else if (!fT1.equals(other.fT1)) return false;
    if (fT2 == null) {if (other.fT2 != null) return false;}
    else if (!fT2.equals(other.fT2)) return false;
    if (fRoot == null) {if (other.fRoot != null) return false;}
    else if (!fRoot.equals(other.fRoot)) return false;
    return true;
  }
  
  @Override
  public MakeParallelQuerySpecification specification() {
    try {
    	return MakeParallelQuerySpecification.instance();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException (ex);
    }
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static MakeParallelMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pT1 the fixed value of pattern parameter T1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter T2, or null if not bound.
   * @param pRoot the fixed value of pattern parameter Root, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static MakeParallelMatch newMutableMatch(final Task pT1, final Task pT2, final SimplifiedBPMN pRoot) {
    return new Mutable(pT1, pT2, pRoot);
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
  public static MakeParallelMatch newMatch(final Task pT1, final Task pT2, final SimplifiedBPMN pRoot) {
    return new Immutable(pT1, pT2, pRoot);
  }
  
  private static final class Mutable extends MakeParallelMatch {
    Mutable(final Task pT1, final Task pT2, final SimplifiedBPMN pRoot) {
      super(pT1, pT2, pRoot);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends MakeParallelMatch {
    Immutable(final Task pT1, final Task pT2, final SimplifiedBPMN pRoot) {
      super(pT1, pT2, pRoot);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
