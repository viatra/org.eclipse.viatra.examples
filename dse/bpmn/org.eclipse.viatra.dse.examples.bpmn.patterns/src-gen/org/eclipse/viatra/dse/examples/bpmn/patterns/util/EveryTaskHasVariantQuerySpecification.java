package org.eclipse.viatra.dse.examples.bpmn.patterns.util;

import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;
import org.eclipse.viatra.dse.examples.bpmn.patterns.EveryTaskHasVariantMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.EveryTaskHasVariantMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.UnassignedTaskQuerySpecification;

/**
 * A pattern-specific query specification that can instantiate EveryTaskHasVariantMatcher in a type-safe way.
 * 
 * @see EveryTaskHasVariantMatcher
 * @see EveryTaskHasVariantMatch
 * 
 */
@SuppressWarnings("all")
public final class EveryTaskHasVariantQuerySpecification extends BaseGeneratedEMFQuerySpecification<EveryTaskHasVariantMatcher> {
  private EveryTaskHasVariantQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static EveryTaskHasVariantQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected EveryTaskHasVariantMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return EveryTaskHasVariantMatcher.on(engine);
  }
  
  @Override
  public EveryTaskHasVariantMatch newEmptyMatch() {
    return EveryTaskHasVariantMatch.newEmptyMatch();
  }
  
  @Override
  public EveryTaskHasVariantMatch newMatch(final Object... parameters) {
    return EveryTaskHasVariantMatch.newMatch();
  }
  
  private static class LazyHolder {
    private final static EveryTaskHasVariantQuerySpecification INSTANCE = make();
    
    public static EveryTaskHasVariantQuerySpecification make() {
      return new EveryTaskHasVariantQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static EveryTaskHasVariantQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.dse.examples.bpmn.patterns.everyTaskHasVariant";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList();
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList();
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		));
      		new NegativePatternCall(body, new FlatTuple(var___0_), UnassignedTaskQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	// to silence compiler error
      	if (false) throw new IncQueryException("Never", "happens");
      } catch (IncQueryException ex) {
      	throw processDependencyException(ex);
      }
      return bodies;
    }
  }
}
