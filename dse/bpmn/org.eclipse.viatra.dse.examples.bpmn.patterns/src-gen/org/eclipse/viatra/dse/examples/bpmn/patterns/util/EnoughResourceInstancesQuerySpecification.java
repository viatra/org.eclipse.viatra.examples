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
import org.eclipse.viatra.dse.examples.bpmn.patterns.EnoughResourceInstancesMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.EnoughResourceInstancesMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.AbsenceOfResourceInstancesQuerySpecification;

/**
 * A pattern-specific query specification that can instantiate EnoughResourceInstancesMatcher in a type-safe way.
 * 
 * @see EnoughResourceInstancesMatcher
 * @see EnoughResourceInstancesMatch
 * 
 */
@SuppressWarnings("all")
public final class EnoughResourceInstancesQuerySpecification extends BaseGeneratedEMFQuerySpecification<EnoughResourceInstancesMatcher> {
  private EnoughResourceInstancesQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static EnoughResourceInstancesQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected EnoughResourceInstancesMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return EnoughResourceInstancesMatcher.on(engine);
  }
  
  @Override
  public EnoughResourceInstancesMatch newEmptyMatch() {
    return EnoughResourceInstancesMatch.newEmptyMatch();
  }
  
  @Override
  public EnoughResourceInstancesMatch newMatch(final Object... parameters) {
    return EnoughResourceInstancesMatch.newMatch();
  }
  
  private static class LazyHolder {
    private final static EnoughResourceInstancesQuerySpecification INSTANCE = make();
    
    public static EnoughResourceInstancesQuerySpecification make() {
      return new EnoughResourceInstancesQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static EnoughResourceInstancesQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.dse.examples.bpmn.patterns.enoughResourceInstances";
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
      	new NegativePatternCall(body, new FlatTuple(var___0_), AbsenceOfResourceInstancesQuerySpecification.instance().getInternalQueryRepresentation());
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
