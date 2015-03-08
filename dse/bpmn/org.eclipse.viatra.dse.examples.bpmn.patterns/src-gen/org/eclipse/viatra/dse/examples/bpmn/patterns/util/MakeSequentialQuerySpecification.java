package org.eclipse.viatra.dse.examples.bpmn.patterns.util;

import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.PatternMatchCounter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;
import org.eclipse.viatra.dse.examples.bpmn.patterns.MakeSequentialMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.MakeSequentialMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.ParallelGatewayOutFlowQuerySpecification;

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
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static MakeSequentialQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected MakeSequentialMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return MakeSequentialMatcher.on(engine);
  }
  
  @Override
  public MakeSequentialMatch newEmptyMatch() {
    return MakeSequentialMatch.newEmptyMatch();
  }
  
  @Override
  public MakeSequentialMatch newMatch(final Object... parameters) {
    return MakeSequentialMatch.newMatch((org.eclipse.viatra.dse.examples.simplifiedbpmn.Task) parameters[0], (org.eclipse.viatra.dse.examples.simplifiedbpmn.Task) parameters[1], (SimplifiedBPMN) parameters[2]);
  }
  
  private static class LazyHolder {
    private final static MakeSequentialQuerySpecification INSTANCE = make();
    
    public static MakeSequentialQuerySpecification make() {
      return new MakeSequentialQuerySpecification();					
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
      return Arrays.asList(new PParameter("T1", "org.eclipse.viatra.dse.examples.simplifiedbpmn.Task"),new PParameter("T2", "org.eclipse.viatra.dse.examples.simplifiedbpmn.Task"),new PParameter("Root", ""));
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
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      	PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      	PVariable var_N = body.getOrCreateVariableByName("N");
      	PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
      	PVariable var_pg2 = body.getOrCreateVariableByName("pg2");
      	PVariable var__virtual_6_ = body.getOrCreateVariableByName(".virtual{6}");
      	PVariable var__virtual_7_ = body.getOrCreateVariableByName(".virtual{7}");
      	PVariable var__virtual_8_ = body.getOrCreateVariableByName(".virtual{8}");
      	PVariable var__virtual_9_ = body.getOrCreateVariableByName(".virtual{9}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_T1, "T1"),
      				
      		new ExportedParameter(body, var_T2, "T2"),
      				
      		new ExportedParameter(body, var_Root, "Root")
      	));
      	new TypeUnary(body, var_T1, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "Task"), "org.eclipse.viatra.dse.examples.bpmn/Task");
      	new TypeUnary(body, var_T2, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "Task"), "org.eclipse.viatra.dse.examples.bpmn/Task");
      	new TypeUnary(body, var_Root, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "SimplifiedBPMN"), "org.eclipse.viatra.dse.examples.bpmn/SimplifiedBPMN");
      	new TypeUnary(body, var_Root, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "SimplifiedBPMN"), "org.eclipse.viatra.dse.examples.bpmn/SimplifiedBPMN");
      	new TypeUnary(body, var_pg, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "ParallelGateway"), "org.eclipse.viatra.dse.examples.bpmn/ParallelGateway");
      	new TypeBinary(body, CONTEXT, var_pg, var__virtual_0_, getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "BaseElement", "outFlows"), "org.eclipse.viatra.dse.examples.bpmn/BaseElement.outFlows");
      	new TypeBinary(body, CONTEXT, var__virtual_0_, var__virtual_1_, getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "SequenceFlow", "target"), "org.eclipse.viatra.dse.examples.bpmn/SequenceFlow.target");
      	new Equality(body, var__virtual_1_, var_T1);
      	new TypeUnary(body, var_pg, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "ParallelGateway"), "org.eclipse.viatra.dse.examples.bpmn/ParallelGateway");
      	new TypeBinary(body, CONTEXT, var_pg, var__virtual_2_, getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "BaseElement", "outFlows"), "org.eclipse.viatra.dse.examples.bpmn/BaseElement.outFlows");
      	new TypeBinary(body, CONTEXT, var__virtual_2_, var__virtual_3_, getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "SequenceFlow", "target"), "org.eclipse.viatra.dse.examples.bpmn/SequenceFlow.target");
      	new Equality(body, var__virtual_3_, var_T2);
      	new Inequality(body, var_T1, var_T2);
      	new PatternMatchCounter(body, new FlatTuple(var_pg, var___0_), ParallelGatewayOutFlowQuerySpecification.instance().getInternalQueryRepresentation(), var__virtual_4_);
      	new Equality(body, var_N, var__virtual_4_);
      	new ConstantValue(body, var__virtual_5_, 2);
      	new Equality(body, var_N, var__virtual_5_);
      	new TypeUnary(body, var_T1, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "Task"), "org.eclipse.viatra.dse.examples.bpmn/Task");
      	new TypeBinary(body, CONTEXT, var_T1, var__virtual_6_, getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "BaseElement", "outFlows"), "org.eclipse.viatra.dse.examples.bpmn/BaseElement.outFlows");
      	new TypeBinary(body, CONTEXT, var__virtual_6_, var__virtual_7_, getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "SequenceFlow", "target"), "org.eclipse.viatra.dse.examples.bpmn/SequenceFlow.target");
      	new Equality(body, var__virtual_7_, var_pg2);
      	new TypeUnary(body, var_T2, getClassifierLiteral("org.eclipse.viatra.dse.examples.bpmn", "Task"), "org.eclipse.viatra.dse.examples.bpmn/Task");
      	new TypeBinary(body, CONTEXT, var_T2, var__virtual_8_, getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "BaseElement", "outFlows"), "org.eclipse.viatra.dse.examples.bpmn/BaseElement.outFlows");
      	new TypeBinary(body, CONTEXT, var__virtual_8_, var__virtual_9_, getFeatureLiteral("org.eclipse.viatra.dse.examples.bpmn", "SequenceFlow", "target"), "org.eclipse.viatra.dse.examples.bpmn/SequenceFlow.target");
      	new Equality(body, var__virtual_9_, var_pg2);
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
