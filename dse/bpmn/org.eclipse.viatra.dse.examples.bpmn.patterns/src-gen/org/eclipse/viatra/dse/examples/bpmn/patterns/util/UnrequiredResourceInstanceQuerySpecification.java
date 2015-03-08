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
import org.eclipse.viatra.dse.examples.bpmn.patterns.UnrequiredResourceInstanceMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.UnrequiredResourceInstanceMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.TaskNeedsVariantQuerySpecification;

/**
 * A pattern-specific query specification that can instantiate UnrequiredResourceInstanceMatcher in a type-safe way.
 * 
 * @see UnrequiredResourceInstanceMatcher
 * @see UnrequiredResourceInstanceMatch
 * 
 */
@SuppressWarnings("all")
public final class UnrequiredResourceInstanceQuerySpecification extends BaseGeneratedEMFQuerySpecification<UnrequiredResourceInstanceMatcher> {
  private UnrequiredResourceInstanceQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static UnrequiredResourceInstanceQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected UnrequiredResourceInstanceMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return UnrequiredResourceInstanceMatcher.on(engine);
  }
  
  @Override
  public UnrequiredResourceInstanceMatch newEmptyMatch() {
    return UnrequiredResourceInstanceMatch.newEmptyMatch();
  }
  
  @Override
  public UnrequiredResourceInstanceMatch newMatch(final Object... parameters) {
    return UnrequiredResourceInstanceMatch.newMatch((org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static UnrequiredResourceInstanceQuerySpecification INSTANCE = make();
    
    public static UnrequiredResourceInstanceQuerySpecification make() {
      return new UnrequiredResourceInstanceQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static UnrequiredResourceInstanceQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.dse.examples.bpmn.patterns.unrequiredResourceInstance";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("RI");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("RI", "org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance"));
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
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_RI, "RI")
      	));
      	new TypeUnary(body, var_RI, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "ResourceInstance"), "org.eclipse.viatra.dse.examples.bpmn/ResourceInstance");
      	new TypeUnary(body, var_RI, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "ResourceInstance"), "org.eclipse.viatra.dse.examples.bpmn/ResourceInstance");
      	new TypeBinary(body, CONTEXT, var_RI, var__virtual_0_, getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "ResourceInstance", "resourceTypeVariant"), "org.eclipse.viatra.dse.examples.bpmn/ResourceInstance.resourceTypeVariant");
      	new Equality(body, var__virtual_0_, var_RTV);
      	new NegativePatternCall(body, new FlatTuple(var___0_, var_RTV), TaskNeedsVariantQuerySpecification.instance().getInternalQueryRepresentation());
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
