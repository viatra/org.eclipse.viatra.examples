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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;
import org.eclipse.viatra.dse.examples.bpmn.patterns.AllocateTaskToVariantMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.AllocateTaskToVariantMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.VariantAllocatedToTaskQuerySpecification;

/**
 * A pattern-specific query specification that can instantiate AllocateTaskToVariantMatcher in a type-safe way.
 * 
 * @see AllocateTaskToVariantMatcher
 * @see AllocateTaskToVariantMatch
 * 
 */
@SuppressWarnings("all")
public final class AllocateTaskToVariantQuerySpecification extends BaseGeneratedEMFQuerySpecification<AllocateTaskToVariantMatcher> {
  private AllocateTaskToVariantQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static AllocateTaskToVariantQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected AllocateTaskToVariantMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return AllocateTaskToVariantMatcher.on(engine);
  }
  
  @Override
  public AllocateTaskToVariantMatch newEmptyMatch() {
    return AllocateTaskToVariantMatch.newEmptyMatch();
  }
  
  @Override
  public AllocateTaskToVariantMatch newMatch(final Object... parameters) {
    return AllocateTaskToVariantMatch.newMatch((org.eclipse.viatra.dse.examples.simplifiedbpmn.Task) parameters[0], (org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static AllocateTaskToVariantQuerySpecification INSTANCE = make();
    
    public static AllocateTaskToVariantQuerySpecification make() {
      return new AllocateTaskToVariantQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static AllocateTaskToVariantQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.dse.examples.bpmn.patterns.allocateTaskToVariant";
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
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	PVariable var_RT = body.getOrCreateVariableByName("RT");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_T, "T"),
      				
      		new ExportedParameter(body, var_RTV, "RTV")
      	));
      	new TypeUnary(body, var_T, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "Task"), "org.eclipse.viatra.dse.examples.bpmn/Task");
      	new TypeUnary(body, var_RTV, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "ResourceTypeVariant"), "org.eclipse.viatra.dse.examples.bpmn/ResourceTypeVariant");
      	new NegativePatternCall(body, new FlatTuple(var_T, var___0_), VariantAllocatedToTaskQuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeUnary(body, var_T, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "Task"), "org.eclipse.viatra.dse.examples.bpmn/Task");
      	new TypeBinary(body, CONTEXT, var_T, var__virtual_0_, getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "Task", "resourceNeeded"), "org.eclipse.viatra.dse.examples.bpmn/Task.resourceNeeded");
      	new Equality(body, var__virtual_0_, var_RT);
      	new TypeUnary(body, var_RT, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "ResourceType"), "org.eclipse.viatra.dse.examples.bpmn/ResourceType");
      	new TypeBinary(body, CONTEXT, var_RT, var__virtual_1_, getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "ResourceType", "variants"), "org.eclipse.viatra.dse.examples.bpmn/ResourceType.variants");
      	new Equality(body, var__virtual_1_, var_RTV);
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
