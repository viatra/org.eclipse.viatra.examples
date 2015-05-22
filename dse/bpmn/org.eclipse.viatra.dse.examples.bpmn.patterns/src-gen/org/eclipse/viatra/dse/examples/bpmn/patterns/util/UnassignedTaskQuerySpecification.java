package org.eclipse.viatra.dse.examples.bpmn.patterns.util;

import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;
import org.eclipse.viatra.dse.examples.bpmn.patterns.UnassignedTaskMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.UnassignedTaskMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.VariantAllocatedToTaskQuerySpecification;

/**
 * A pattern-specific query specification that can instantiate UnassignedTaskMatcher in a type-safe way.
 * 
 * @see UnassignedTaskMatcher
 * @see UnassignedTaskMatch
 * 
 */
@SuppressWarnings("all")
public final class UnassignedTaskQuerySpecification extends BaseGeneratedEMFQuerySpecification<UnassignedTaskMatcher> {
  private UnassignedTaskQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static UnassignedTaskQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected UnassignedTaskMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return UnassignedTaskMatcher.on(engine);
  }
  
  @Override
  public UnassignedTaskMatch newEmptyMatch() {
    return UnassignedTaskMatch.newEmptyMatch();
  }
  
  @Override
  public UnassignedTaskMatch newMatch(final Object... parameters) {
    return UnassignedTaskMatch.newMatch((org.eclipse.viatra.dse.examples.simplifiedbpmn.Task) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static UnassignedTaskQuerySpecification INSTANCE = make();
    
    public static UnassignedTaskQuerySpecification make() {
      return new UnassignedTaskQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static UnassignedTaskQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.dse.examples.bpmn.patterns.unassignedTask";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("T");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("T", "org.eclipse.viatra.dse.examples.simplifiedbpmn.Task"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_T = body.getOrCreateVariableByName("T");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_T, "T")
      	));
      	new TypeConstraint(body, new FlatTuple(var_T), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "Task")));
      	new NegativePatternCall(body, new FlatTuple(var_T, var___0_), VariantAllocatedToTaskQuerySpecification.instance().getInternalQueryRepresentation());
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
