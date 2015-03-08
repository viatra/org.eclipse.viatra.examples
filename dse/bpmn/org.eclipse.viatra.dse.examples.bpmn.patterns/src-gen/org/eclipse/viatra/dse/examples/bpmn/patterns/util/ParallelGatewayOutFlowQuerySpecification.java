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
 * A pattern-specific query specification that can instantiate ParallelGatewayOutFlowMatcher in a type-safe way.
 * 
 * @see ParallelGatewayOutFlowMatcher
 * @see ParallelGatewayOutFlowMatch
 * 
 */
@SuppressWarnings("all")
final class ParallelGatewayOutFlowQuerySpecification extends BaseGeneratedEMFQuerySpecification<IncQueryMatcher<IPatternMatch>> {
  private ParallelGatewayOutFlowQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ParallelGatewayOutFlowQuerySpecification instance() throws IncQueryException {
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
    private final static ParallelGatewayOutFlowQuerySpecification INSTANCE = make();
    
    public static ParallelGatewayOutFlowQuerySpecification make() {
      return new ParallelGatewayOutFlowQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ParallelGatewayOutFlowQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.dse.examples.bpmn.patterns.parallelGatewayOutFlow";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("PG","Flow");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("PG", "org.eclipse.viatra.dse.examples.simplifiedbpmn.ParallelGateway"),new PParameter("Flow", "org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_PG = body.getOrCreateVariableByName("PG");
      	PVariable var_Flow = body.getOrCreateVariableByName("Flow");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_PG, "PG"),
      				
      		new ExportedParameter(body, var_Flow, "Flow")
      	));
      	new TypeUnary(body, var_PG, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "ParallelGateway"), "org.eclipse.viatra.dse.examples.bpmn/ParallelGateway");
      	new TypeUnary(body, var_Flow, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "SequenceFlow"), "org.eclipse.viatra.dse.examples.bpmn/SequenceFlow");
      	new TypeUnary(body, var_PG, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "ParallelGateway"), "org.eclipse.viatra.dse.examples.bpmn/ParallelGateway");
      	new TypeBinary(body, CONTEXT, var_PG, var__virtual_0_, getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "BaseElement", "outFlows"), "org.eclipse.viatra.dse.examples.bpmn/BaseElement.outFlows");
      	new Equality(body, var__virtual_0_, var_Flow);
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
