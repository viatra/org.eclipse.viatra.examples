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
import org.eclipse.viatra.dse.examples.bpmn.patterns.AbsenceOfResourceInstancesMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.AbsenceOfResourceInstancesMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.InstanceOfVariantQuerySpecification;

/**
 * A pattern-specific query specification that can instantiate AbsenceOfResourceInstancesMatcher in a type-safe way.
 * 
 * @see AbsenceOfResourceInstancesMatcher
 * @see AbsenceOfResourceInstancesMatch
 * 
 */
@SuppressWarnings("all")
public final class AbsenceOfResourceInstancesQuerySpecification extends BaseGeneratedEMFQuerySpecification<AbsenceOfResourceInstancesMatcher> {
  private AbsenceOfResourceInstancesQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static AbsenceOfResourceInstancesQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected AbsenceOfResourceInstancesMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return AbsenceOfResourceInstancesMatcher.on(engine);
  }
  
  @Override
  public AbsenceOfResourceInstancesMatch newEmptyMatch() {
    return AbsenceOfResourceInstancesMatch.newEmptyMatch();
  }
  
  @Override
  public AbsenceOfResourceInstancesMatch newMatch(final Object... parameters) {
    return AbsenceOfResourceInstancesMatch.newMatch((org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static AbsenceOfResourceInstancesQuerySpecification INSTANCE = make();
    
    public static AbsenceOfResourceInstancesQuerySpecification make() {
      return new AbsenceOfResourceInstancesQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static AbsenceOfResourceInstancesQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.dse.examples.bpmn.patterns.absenceOfResourceInstances";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("RTV");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("RTV", "org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_RTV = body.getOrCreateVariableByName("RTV");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_RTV, "RTV")
      	));
      	new TypeUnary(body, var_RTV, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "ResourceTypeVariant"), "org.eclipse.viatra.dse.examples.bpmn/ResourceTypeVariant");
      	new NegativePatternCall(body, new FlatTuple(var___0_, var_RTV), InstanceOfVariantQuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeUnary(body, var___1_, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "Task"), "org.eclipse.viatra.dse.examples.bpmn/Task");
      	new TypeBinary(body, CONTEXT, var___1_, var__virtual_0_, getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "Task", "variant"), "org.eclipse.viatra.dse.examples.bpmn/Task.variant");
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
