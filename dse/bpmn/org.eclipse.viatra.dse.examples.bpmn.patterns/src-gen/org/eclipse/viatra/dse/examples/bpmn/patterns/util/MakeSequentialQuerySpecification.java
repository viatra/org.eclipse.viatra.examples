package org.eclipse.viatra.dse.examples.bpmn.patterns.util;

import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.dse.examples.bpmn.patterns.MakeSequentialMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.MakeSequentialMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.ParallelGatewayOutFlowQuerySpecification;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate MakeSequentialMatcher in a type-safe way.
 * 
 * @see MakeSequentialMatcher
 * @see MakeSequentialMatch
 * 
 */
@SuppressWarnings("all")
public final class MakeSequentialQuerySpecification extends BaseGeneratedEMFQuerySpecification<MakeSequentialMatcher> {
  private MakeSequentialQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static MakeSequentialQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected MakeSequentialMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return MakeSequentialMatcher.on(engine);
  }
  
  @Override
  public MakeSequentialMatch newEmptyMatch() {
    return MakeSequentialMatch.newEmptyMatch();
  }
  
  @Override
  public MakeSequentialMatch newMatch(final Object... parameters) {
    return MakeSequentialMatch.newMatch((org.eclipse.viatra.dse.examples.simplifiedbpmn.Task) parameters[0], (org.eclipse.viatra.dse.examples.simplifiedbpmn.Task) parameters[1], (org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link MakeSequentialQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link MakeSequentialQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static MakeSequentialQuerySpecification INSTANCE = new MakeSequentialQuerySpecification();
    
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
    private final static MakeSequentialQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.eclipse.viatra.dse.examples.bpmn.patterns.makeSequential";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("T1","T2","Root");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("T1", "org.eclipse.viatra.dse.examples.simplifiedbpmn.Task"),new PParameter("T2", "org.eclipse.viatra.dse.examples.simplifiedbpmn.Task"),new PParameter("Root", "org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN"));
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
      		PVariable var_pg = body.getOrCreateVariableByName("pg");
      		PVariable var_N = body.getOrCreateVariableByName("N");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		PVariable var_pg2 = body.getOrCreateVariableByName("pg2");
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
      		// 	ParallelGateway.outFlows.target(pg, T1)
      		new TypeConstraint(body, new FlatTuple(var_pg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "ParallelGateway")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_pg, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "BaseElement", "outFlows")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var__virtual_0_, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "SequenceFlow", "target")));
      		new Equality(body, var__virtual_1_, var_T1);
      		// 	ParallelGateway.outFlows.target(pg, T2)
      		new TypeConstraint(body, new FlatTuple(var_pg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "ParallelGateway")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_pg, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "BaseElement", "outFlows")));
      		PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      		new TypeConstraint(body, new FlatTuple(var__virtual_2_, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "SequenceFlow", "target")));
      		new Equality(body, var__virtual_3_, var_T2);
      		// 	T1 != T2
      		new Inequality(body, var_T1, var_T2);
      		// 	N == count find parallelGatewayOutFlow(pg, _)
      		PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
      		new PatternMatchCounter(body, new FlatTuple(var_pg, var___0_), ParallelGatewayOutFlowQuerySpecification.instance().getInternalQueryRepresentation(), var__virtual_4_);
      		new Equality(body, var_N, var__virtual_4_);
      		// 	N == 2
      		PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
      		new ConstantValue(body, var__virtual_5_, 2);
      		new Equality(body, var_N, var__virtual_5_);
      		// 	Task.outFlows.target(T1, pg2)
      		new TypeConstraint(body, new FlatTuple(var_T1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "Task")));
      		PVariable var__virtual_6_ = body.getOrCreateVariableByName(".virtual{6}");
      		new TypeConstraint(body, new FlatTuple(var_T1, var__virtual_6_), new EStructuralFeatureInstancesKey(getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "BaseElement", "outFlows")));
      		PVariable var__virtual_7_ = body.getOrCreateVariableByName(".virtual{7}");
      		new TypeConstraint(body, new FlatTuple(var__virtual_6_, var__virtual_7_), new EStructuralFeatureInstancesKey(getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "SequenceFlow", "target")));
      		new Equality(body, var__virtual_7_, var_pg2);
      		// 	Task.outFlows.target(T2, pg2)
      		new TypeConstraint(body, new FlatTuple(var_T2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "Task")));
      		PVariable var__virtual_8_ = body.getOrCreateVariableByName(".virtual{8}");
      		new TypeConstraint(body, new FlatTuple(var_T2, var__virtual_8_), new EStructuralFeatureInstancesKey(getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "BaseElement", "outFlows")));
      		PVariable var__virtual_9_ = body.getOrCreateVariableByName(".virtual{9}");
      		new TypeConstraint(body, new FlatTuple(var__virtual_8_, var__virtual_9_), new EStructuralFeatureInstancesKey(getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "SequenceFlow", "target")));
      		new Equality(body, var__virtual_9_, var_pg2);
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
