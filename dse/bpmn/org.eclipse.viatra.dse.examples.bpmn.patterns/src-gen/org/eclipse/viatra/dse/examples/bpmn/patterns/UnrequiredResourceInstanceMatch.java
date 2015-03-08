package org.eclipse.viatra.dse.examples.bpmn.patterns;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.UnrequiredResourceInstanceQuerySpecification;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance;

/**
 * Pattern-specific match representation of the org.eclipse.viatra.dse.examples.bpmn.patterns.unrequiredResourceInstance pattern,
 * to be used in conjunction with {@link UnrequiredResourceInstanceMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see UnrequiredResourceInstanceMatcher
 * @see UnrequiredResourceInstanceProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class UnrequiredResourceInstanceMatch extends BasePatternMatch {
  private ResourceInstance fRI;
  
  private static List<String> parameterNames = makeImmutableList("RI");
  
  private UnrequiredResourceInstanceMatch(final ResourceInstance pRI) {
    this.fRI = pRI;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("RI".equals(parameterName)) return this.fRI;
    return null;
  }
  
  public ResourceInstance getRI() {
    return this.fRI;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("RI".equals(parameterName) ) {
    	this.fRI = (org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance) newValue;
    	return true;
    }
    return false;
  }
  
  public void setRI(final ResourceInstance pRI) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRI = pRI;
  }
  
  @Override
  public String patternName() {
    return "org.eclipse.viatra.dse.examples.bpmn.patterns.unrequiredResourceInstance";
  }
  
  @Override
  public List<String> parameterNames() {
    return UnrequiredResourceInstanceMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fRI};
  }
  
  @Override
  public UnrequiredResourceInstanceMatch toImmutable() {
    return isMutable() ? newMatch(fRI) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"RI\"=" + prettyPrintValue(fRI)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fRI == null) ? 0 : fRI.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof UnrequiredResourceInstanceMatch)) { // this should be infrequent
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
    UnrequiredResourceInstanceMatch other = (UnrequiredResourceInstanceMatch) obj;
    if (fRI == null) {if (other.fRI != null) return false;}
    else if (!fRI.equals(other.fRI)) return false;
    return true;
  }
  
  @Override
  public UnrequiredResourceInstanceQuerySpecification specification() {
    try {
    	return UnrequiredResourceInstanceQuerySpecification.instance();
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
  public static UnrequiredResourceInstanceMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pRI the fixed value of pattern parameter RI, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static UnrequiredResourceInstanceMatch newMutableMatch(final ResourceInstance pRI) {
    return new Mutable(pRI);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRI the fixed value of pattern parameter RI, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static UnrequiredResourceInstanceMatch newMatch(final ResourceInstance pRI) {
    return new Immutable(pRI);
  }
  
  private static final class Mutable extends UnrequiredResourceInstanceMatch {
    Mutable(final ResourceInstance pRI) {
      super(pRI);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends UnrequiredResourceInstanceMatch {
    Immutable(final ResourceInstance pRI) {
      super(pRI);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
