package org.eclipse.viatra.dse.examples.bpmn.patterns;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.InstanceOfVariantQuerySpecification;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant;

/**
 * Pattern-specific match representation of the org.eclipse.viatra.dse.examples.bpmn.patterns.instanceOfVariant pattern,
 * to be used in conjunction with {@link InstanceOfVariantMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see InstanceOfVariantMatcher
 * @see InstanceOfVariantProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class InstanceOfVariantMatch extends BasePatternMatch {
  private ResourceInstance fRI;
  
  private ResourceTypeVariant fRTV;
  
  private static List<String> parameterNames = makeImmutableList("RI", "RTV");
  
  private InstanceOfVariantMatch(final ResourceInstance pRI, final ResourceTypeVariant pRTV) {
    this.fRI = pRI;
    this.fRTV = pRTV;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("RI".equals(parameterName)) return this.fRI;
    if ("RTV".equals(parameterName)) return this.fRTV;
    return null;
  }
  
  public ResourceInstance getRI() {
    return this.fRI;
  }
  
  public ResourceTypeVariant getRTV() {
    return this.fRTV;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("RI".equals(parameterName) ) {
    	this.fRI = (org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance) newValue;
    	return true;
    }
    if ("RTV".equals(parameterName) ) {
    	this.fRTV = (org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant) newValue;
    	return true;
    }
    return false;
  }
  
  public void setRI(final ResourceInstance pRI) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRI = pRI;
  }
  
  public void setRTV(final ResourceTypeVariant pRTV) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRTV = pRTV;
  }
  
  @Override
  public String patternName() {
    return "org.eclipse.viatra.dse.examples.bpmn.patterns.instanceOfVariant";
  }
  
  @Override
  public List<String> parameterNames() {
    return InstanceOfVariantMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fRI, fRTV};
  }
  
  @Override
  public InstanceOfVariantMatch toImmutable() {
    return isMutable() ? newMatch(fRI, fRTV) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"RI\"=" + prettyPrintValue(fRI) + ", ");
    
    result.append("\"RTV\"=" + prettyPrintValue(fRTV)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fRI == null) ? 0 : fRI.hashCode());
    result = prime * result + ((fRTV == null) ? 0 : fRTV.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof InstanceOfVariantMatch)) { // this should be infrequent
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
    InstanceOfVariantMatch other = (InstanceOfVariantMatch) obj;
    if (fRI == null) {if (other.fRI != null) return false;}
    else if (!fRI.equals(other.fRI)) return false;
    if (fRTV == null) {if (other.fRTV != null) return false;}
    else if (!fRTV.equals(other.fRTV)) return false;
    return true;
  }
  
  @Override
  public InstanceOfVariantQuerySpecification specification() {
    try {
    	return InstanceOfVariantQuerySpecification.instance();
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
  public static InstanceOfVariantMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pRI the fixed value of pattern parameter RI, or null if not bound.
   * @param pRTV the fixed value of pattern parameter RTV, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static InstanceOfVariantMatch newMutableMatch(final ResourceInstance pRI, final ResourceTypeVariant pRTV) {
    return new Mutable(pRI, pRTV);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRI the fixed value of pattern parameter RI, or null if not bound.
   * @param pRTV the fixed value of pattern parameter RTV, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static InstanceOfVariantMatch newMatch(final ResourceInstance pRI, final ResourceTypeVariant pRTV) {
    return new Immutable(pRI, pRTV);
  }
  
  private static final class Mutable extends InstanceOfVariantMatch {
    Mutable(final ResourceInstance pRI, final ResourceTypeVariant pRTV) {
      super(pRI, pRTV);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends InstanceOfVariantMatch {
    Immutable(final ResourceInstance pRI, final ResourceTypeVariant pRTV) {
      super(pRI, pRTV);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
