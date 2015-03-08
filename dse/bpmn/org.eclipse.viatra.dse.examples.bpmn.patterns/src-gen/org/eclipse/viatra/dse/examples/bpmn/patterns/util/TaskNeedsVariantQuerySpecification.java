package org.eclipse.viatra.dse.examples.bpmn.patterns.util;

import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;

/**
 * A pattern-specific query specification that can instantiate TaskNeedsVariantMatcher in a type-safe way.
 * 
 * @see TaskNeedsVariantMatcher
 * @see TaskNeedsVariantMatch
 * 
 */
@SuppressWarnings("all")
final class TaskNeedsVariantQuerySpecification extends BaseGeneratedEMFQuerySpecification<IncQueryMatcher<IPatternMatch>> {
  private TaskNeedsVariantQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TaskNeedsVariantQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected IncQueryMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public IPatternMatch newEmptyMatch() {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public IPatternMatch newMatch(final Object... parameters) {
    throw new UnsupportedOperationException();
  }
  
  private static class LazyHolder {
    private final static TaskNeedsVariantQuerySpecification INSTANCE = make();
    
    public static TaskNeedsVariantQuerySpecification make() {
      return new TaskNeedsVariantQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static TaskNeedsVariantQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.dse.examples.bpmn.patterns.taskNeedsVariant";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("T","RTV");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("T", "org.eclipse.viatra.dse.examples.simplifiedbpmn.Task"),new PParameter("RTV", "org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_T = body.getOrCreateVariableByName("T");
      	PVariable var_RTV = body.getOrCreateVariableByName("RTV");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_T, "T"),
      				
      		new ExportedParameter(body, var_RTV, "RTV")
      	));
      	new TypeUnary(body, var_T, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "Task"), "org.eclipse.viatra.dse.examples.bpmn/Task");
      	new TypeUnary(body, var_RTV, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "ResourceTypeVariant"), "org.eclipse.viatra.dse.examples.bpmn/ResourceTypeVariant");
      	new TypeUnary(body, var_T, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "Task"), "org.eclipse.viatra.dse.examples.bpmn/Task");
      	new TypeBinary(body, CONTEXT, var_T, var__virtual_0_, getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "Task", "variant"), "org.eclipse.viatra.dse.examples.bpmn/Task.variant");
      	new Equality(body, var__virtual_0_, var_RTV);
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
