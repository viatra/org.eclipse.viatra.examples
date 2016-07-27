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
import org.eclipse.viatra.dse.examples.bpmn.patterns.MakeParallelMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.MakeParallelMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.InFlowQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.OutFlowQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.TaskOrderQuerySpecification;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.PatternMatchCounter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate MakeParallelMatcher in a type-safe way.
 * 
 * @see MakeParallelMatcher
 * @see MakeParallelMatch
 * 
 */
@SuppressWarnings("all")
public final class MakeParallelQuerySpecification extends BaseGeneratedEMFQuerySpecification<MakeParallelMatcher> {
  private MakeParallelQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static MakeParallelQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected MakeParallelMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return MakeParallelMatcher.on(engine);
  }
  
  @Override
  public MakeParallelMatch newEmptyMatch() {
    return MakeParallelMatch.newEmptyMatch();
  }
  
  @Override
  public MakeParallelMatch newMatch(final Object... parameters) {
    return MakeParallelMatch.newMatch((org.eclipse.viatra.dse.examples.simplifiedbpmn.Task) parameters[0], (org.eclipse.viatra.dse.examples.simplifiedbpmn.Task) parameters[1], (org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link MakeParallelQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link MakeParallelQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static MakeParallelQuerySpecification INSTANCE = new MakeParallelQuerySpecification();
    
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
    private final static MakeParallelQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.dse.examples.bpmn.patterns.makeParallel";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("T1","T2","Root");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(
      			 new PParameter("T1", "org.eclipse.viatra.dse.examples.simplifiedbpmn.Task", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("org.eclipse.viatra.dse.examples.bpmn", "Task"))),
      			 new PParameter("T2", "org.eclipse.viatra.dse.examples.simplifiedbpmn.Task", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("org.eclipse.viatra.dse.examples.bpmn", "Task"))),
      			 new PParameter("Root", "org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("org.eclipse.viatra.dse.examples.bpmn", "SimplifiedBPMN")))
      			);
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_T1 = body.getOrCreateVariableByName("T1");
      		PVariable var_T2 = body.getOrCreateVariableByName("T2");
      		PVariable var_Root = body.getOrCreateVariableByName("Root");
      		PVariable var_out = body.getOrCreateVariableByName("out");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
      		new TypeConstraint(body, new FlatTuple(var_T1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "Task")));
      		new TypeConstraint(body, new FlatTuple(var_T2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "Task")));
      		new TypeConstraint(body, new FlatTuple(var_Root), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "SimplifiedBPMN")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_T1, "T1"),
      		   new ExportedParameter(body, var_T2, "T2"),
      		   new ExportedParameter(body, var_Root, "Root")
      		));
      		// 	SimplifiedBPMN(Root)
      		new TypeConstraint(body, new FlatTuple(var_Root), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "SimplifiedBPMN")));
      		// 	Task.outFlows(T1, out)
      		new TypeConstraint(body, new FlatTuple(var_T1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "Task")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_T1, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "BaseElement", "outFlows")));
      		new Equality(body, var__virtual_0_, var_out);
      		// 	SequenceFlow.isDataFlow(out, false)
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new ConstantValue(body, var__virtual_1_, false);
      		new TypeConstraint(body, new FlatTuple(var_out), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "SequenceFlow")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_out, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "SequenceFlow", "isDataFlow")));
      		new Equality(body, var__virtual_2_, var__virtual_1_);
      		// 	SequenceFlow.target(out, T2)
      		new TypeConstraint(body, new FlatTuple(var_out), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "SequenceFlow")));
      		PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      		new TypeConstraint(body, new FlatTuple(var_out, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "SequenceFlow", "target")));
      		new Equality(body, var__virtual_3_, var_T2);
      		// 	T1 != T2
      		new Inequality(body, var_T1, var_T2);
      		// 	find taskOrder(T1,T2)
      		new PositivePatternCall(body, new FlatTuple(var_T1, var_T2), TaskOrderQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	1 == count find inFlow(T2, _)
      		PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
      		new ConstantValue(body, var__virtual_4_, 1);
      		PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
      		new PatternMatchCounter(body, new FlatTuple(var_T2, var___0_), InFlowQuerySpecification.instance().getInternalQueryRepresentation(), var__virtual_5_);
      		new Equality(body, var__virtual_4_, var__virtual_5_);
      		// 	1 == count find outFlow(T1, _)
      		PVariable var__virtual_6_ = body.getOrCreateVariableByName(".virtual{6}");
      		new ConstantValue(body, var__virtual_6_, 1);
      		PVariable var__virtual_7_ = body.getOrCreateVariableByName(".virtual{7}");
      		new PatternMatchCounter(body, new FlatTuple(var_T1, var___1_), OutFlowQuerySpecification.instance().getInternalQueryRepresentation(), var__virtual_7_);
      		new Equality(body, var__virtual_6_, var__virtual_7_);
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
