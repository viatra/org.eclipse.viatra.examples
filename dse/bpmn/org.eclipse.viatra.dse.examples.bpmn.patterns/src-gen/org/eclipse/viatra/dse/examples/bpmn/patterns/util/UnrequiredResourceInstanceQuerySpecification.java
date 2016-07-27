/**
 * 
 *   Copyright (c) 2010-2015, Andras Szabolcs Nagy, Abel Hegedus, Akos Horvath, Zoltan Ujhelyi and Daniel Varro
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *   Contributors:
 *     Andras Szabolcs Nagy - initial API and implementation
 *  
 */
package org.eclipse.viatra.dse.examples.bpmn.patterns.util;

import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.dse.examples.bpmn.patterns.UnrequiredResourceInstanceMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.UnrequiredResourceInstanceMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.TaskNeedsVariantQuerySpecification;
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
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static UnrequiredResourceInstanceQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected UnrequiredResourceInstanceMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
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
  
  /**
   * Inner class allowing the singleton instance of {@link UnrequiredResourceInstanceQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link UnrequiredResourceInstanceQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static UnrequiredResourceInstanceQuerySpecification INSTANCE = new UnrequiredResourceInstanceQuerySpecification();
    
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
      return Arrays.asList(
      			 new PParameter("RI", "org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("org.eclipse.viatra.dse.examples.bpmn", "ResourceInstance")))
      			);
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_RI = body.getOrCreateVariableByName("RI");
      		PVariable var_RTV = body.getOrCreateVariableByName("RTV");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		new TypeConstraint(body, new FlatTuple(var_RI), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "ResourceInstance")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_RI, "RI")
      		));
      		// 	ResourceInstance.resourceTypeVariant(RI, RTV)
      		new TypeConstraint(body, new FlatTuple(var_RI), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "ResourceInstance")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_RI, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "ResourceInstance", "resourceTypeVariant")));
      		new Equality(body, var__virtual_0_, var_RTV);
      		// 	neg find taskNeedsVariant(_, RTV)
      		new NegativePatternCall(body, new FlatTuple(var___0_, var_RTV), TaskNeedsVariantQuerySpecification.instance().getInternalQueryRepresentation());
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
