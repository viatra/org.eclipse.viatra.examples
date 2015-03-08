package org.eclipse.viatra.dse.examples.bpmn.patterns;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.CreateResourceQuerySpecification;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant;

/**
 * Pattern-specific match representation of the org.eclipse.viatra.dse.examples.bpmn.patterns.createResource pattern,
 * to be used in conjunction with {@link CreateResourceMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see CreateResourceMatcher
 * @see CreateResourceProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class CreateResourceMatch extends BasePatternMatch {
  private ResourceTypeVariant fRTV;
  
  private static List<String> parameterNames = makeImmutableList("RTV");
  
  private CreateResourceMatch(final ResourceTypeVariant pRTV) {
    this.fRTV = pRTV;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("RTV".equals(parameterName)) return this.fRTV;
    return null;
  }
  
  public ResourceTypeVariant getRTV() {
    return this.fRTV;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("RTV".equals(parameterName) ) {
    	this.fRTV = (org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant) newValue;
    	return true;
    }
    return false;
  }
  
  public void setRTV(final ResourceTypeVariant pRTV) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRTV = pRTV;
  }
  
  @Override
  public String patternName() {
    return "org.eclipse.viatra.dse.examples.bpmn.patterns.createResource";
  }
  
  @Override
  public List<String> parameterNames() {
    return CreateResourceMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fRTV};
  }
  
  @Override
  public CreateResourceMatch toImmutable() {
    return isMutable() ? newMatch(fRTV) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"RTV\"=" + prettyPrintValue(fRTV)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fRTV == null) ? 0 : fRTV.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof CreateResourceMatch)) { // this should be infrequent
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
    CreateResourceMatch other = (CreateResourceMatch) obj;
    if (fRTV == null) {if (other.fRTV != null) return false;}
    else if (!fRTV.equals(other.fRTV)) return false;
    return true;
  }
  
  @Override
  public CreateResourceQuerySpecification specification() {
    try {
    	return CreateResourceQuerySpecification.instance();
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
  public static CreateResourceMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pRTV the fixed value of pattern parameter RTV, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static CreateResourceMatch newMutableMatch(final ResourceTypeVariant pRTV) {
    return new Mutable(pRTV);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRTV the fixed value of pattern parameter RTV, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static CreateResourceMatch newMatch(final ResourceTypeVariant pRTV) {
    return new Immutable(pRTV);
  }
  
  private static final class Mutable extends CreateResourceMatch {
    Mutable(final ResourceTypeVariant pRTV) {
      super(pRTV);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends CreateResourceMatch {
    Immutable(final ResourceTypeVariant pRTV) {
      super(pRTV);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
