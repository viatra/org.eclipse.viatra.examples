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
 * A pattern-specific query specification that can instantiate InFlowMatcher in a type-safe way.
 * 
 * @see InFlowMatcher
 * @see InFlowMatch
 * 
 */
@SuppressWarnings("all")
final class InFlowQuerySpecification extends BaseGeneratedEMFQuerySpecification<IncQueryMatcher<IPatternMatch>> {
  private InFlowQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static InFlowQuerySpecification instance() throws IncQueryException {
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
    private final static InFlowQuerySpecification INSTANCE = make();
    
    public static InFlowQuerySpecification make() {
      return new InFlowQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static InFlowQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.dse.examples.bpmn.patterns.inFlow";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("Element","Flow");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("Element", "org.eclipse.viatra.dse.examples.simplifiedbpmn.BaseElement"),new PParameter("Flow", "org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_Element = body.getOrCreateVariableByName("Element");
      	PVariable var_Flow = body.getOrCreateVariableByName("Flow");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_Element, "Element"),
      				
      		new ExportedParameter(body, var_Flow, "Flow")
      	));
      	new TypeUnary(body, var_Element, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "BaseElement"), "org.eclipse.viatra.dse.examples.bpmn/BaseElement");
      	new TypeUnary(body, var_Flow, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "SequenceFlow"), "org.eclipse.viatra.dse.examples.bpmn/SequenceFlow");
      	new TypeUnary(body, var_Element, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "BaseElement"), "org.eclipse.viatra.dse.examples.bpmn/BaseElement");
      	new TypeBinary(body, CONTEXT, var_Element, var__virtual_0_, getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "BaseElement", "inFlows"), "org.eclipse.viatra.dse.examples.bpmn/BaseElement.inFlows");
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
