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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.dse.examples.bpmn.patterns.InstanceOfVariantMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.InstanceOfVariantMatcher;

/**
 * A pattern-specific query specification that can instantiate InstanceOfVariantMatcher in a type-safe way.
 * 
 * @see InstanceOfVariantMatcher
 * @see InstanceOfVariantMatch
 * 
 */
@SuppressWarnings("all")
public final class InstanceOfVariantQuerySpecification extends BaseGeneratedEMFQuerySpecification<InstanceOfVariantMatcher> {
  private InstanceOfVariantQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static InstanceOfVariantQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected InstanceOfVariantMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return InstanceOfVariantMatcher.on(engine);
  }
  
  @Override
  public InstanceOfVariantMatch newEmptyMatch() {
    return InstanceOfVariantMatch.newEmptyMatch();
  }
  
  @Override
  public InstanceOfVariantMatch newMatch(final Object... parameters) {
    return InstanceOfVariantMatch.newMatch((org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance) parameters[0], (org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static InstanceOfVariantQuerySpecification INSTANCE = make();
    
    public static InstanceOfVariantQuerySpecification make() {
      return new InstanceOfVariantQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static InstanceOfVariantQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.dse.examples.bpmn.patterns.instanceOfVariant";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("RI","RTV");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("RI", "org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance"),new PParameter("RTV", "org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_RI = body.getOrCreateVariableByName("RI");
      	PVariable var_RTV = body.getOrCreateVariableByName("RTV");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_RI, "RI"),
      				
      		new ExportedParameter(body, var_RTV, "RTV")
      	));
      	new TypeUnary(body, var_RI, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "ResourceInstance"), "org.eclipse.viatra.dse.examples.bpmn/ResourceInstance");
      	new TypeUnary(body, var_RTV, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "ResourceTypeVariant"), "org.eclipse.viatra.dse.examples.bpmn/ResourceTypeVariant");
      	new TypeUnary(body, var_RI, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "ResourceInstance"), "org.eclipse.viatra.dse.examples.bpmn/ResourceInstance");
      	new TypeBinary(body, CONTEXT, var_RI, var__virtual_0_, getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "ResourceInstance", "resourceTypeVariant"), "org.eclipse.viatra.dse.examples.bpmn/ResourceInstance.resourceTypeVariant");
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
