package org.eclipse.viatra.dse.examples.bpmn.patterns.util;

import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.dse.examples.bpmn.patterns.AbsenceOfResourceInstancesMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.AbsenceOfResourceInstancesMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.InstanceOfVariantQuerySpecification;
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
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static AbsenceOfResourceInstancesQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected AbsenceOfResourceInstancesMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
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
  
  /**
   * Inner class allowing the singleton instance of {@link AbsenceOfResourceInstancesQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link AbsenceOfResourceInstancesQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static AbsenceOfResourceInstancesQuerySpecification INSTANCE = new AbsenceOfResourceInstancesQuerySpecification();
    
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
      		new TypeConstraint(body, new FlatTuple(var_RTV), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "ResourceTypeVariant")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_RTV, "RTV")
      		));
      		// 	neg find instanceOfVariant(_, RTV)
      		new NegativePatternCall(body, new FlatTuple(var___0_, var_RTV), InstanceOfVariantQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Task.variant(_, RTV)
      		new TypeConstraint(body, new FlatTuple(var___1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "Task")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var___1_, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "Task", "variant")));
      		new Equality(body, var__virtual_0_, var_RTV);
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
