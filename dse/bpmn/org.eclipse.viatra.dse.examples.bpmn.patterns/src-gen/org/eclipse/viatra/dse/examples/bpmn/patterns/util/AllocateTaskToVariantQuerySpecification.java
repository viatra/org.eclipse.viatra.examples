package org.eclipse.viatra.dse.examples.bpmn.patterns.util;

import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.dse.examples.bpmn.patterns.AllocateTaskToVariantMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.AllocateTaskToVariantMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.VariantAllocatedToTaskQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

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
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static AllocateTaskToVariantQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected AllocateTaskToVariantMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
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
  
  /**
   * Inner class allowing the singleton instance of {@link AllocateTaskToVariantQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link AllocateTaskToVariantQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static AllocateTaskToVariantQuerySpecification INSTANCE = new AllocateTaskToVariantQuerySpecification();
    
    /**
     * Statically initializes the query specification <b>after</b> the field {@link #INSTANCE} is assigned.
     * This initialization order is required to support indirect recursion.
     * 
     * <p> The static initializer is defined using a helper field to work around limitations of the code generator.
     * 
     */
    private final static Object STATIC_INITIALIZER = ensureInitialized();
    
    public static Object ensureInitialized() {
      INSTANCE.ensureInitializedInternalSneaky();
      return null;					
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
      		new TypeConstraint(body, new FlatTuple(var_T), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "Task")));
      		new TypeConstraint(body, new FlatTuple(var_RTV), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "ResourceTypeVariant")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_T, "T"),
      		   new ExportedParameter(body, var_RTV, "RTV")
      		));
      		// 	neg find variantAllocatedToTask(T, _)
      		new NegativePatternCall(body, new FlatTuple(var_T, var___0_), VariantAllocatedToTaskQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Task.resourceNeeded(T, RT)
      		new TypeConstraint(body, new FlatTuple(var_T), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "Task")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_T, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "Task", "resourceNeeded")));
      		new Equality(body, var__virtual_0_, var_RT);
      		// 	ResourceType.variants(RT, RTV)
      		new TypeConstraint(body, new FlatTuple(var_RT), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "ResourceType")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_RT, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "ResourceType", "variants")));
      		new Equality(body, var__virtual_1_, var_RTV);
      		bodies.add(body);
      	}
      	// to silence compiler error
      	if (false) throw new ViatraQueryException("Never", "happens");
      } catch (ViatraQueryException ex) {
      	throw processDependencyException(ex);
      }
      return bodies;
    }
  }
}
