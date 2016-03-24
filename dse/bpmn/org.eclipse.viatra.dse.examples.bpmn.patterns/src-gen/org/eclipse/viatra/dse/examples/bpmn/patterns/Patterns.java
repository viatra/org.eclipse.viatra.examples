package org.eclipse.viatra.dse.examples.bpmn.patterns;

import org.eclipse.viatra.dse.examples.bpmn.patterns.AbsenceOfResourceInstancesMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.AllocateTaskToVariantMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.CreateResourceMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.EnoughResourceInstancesMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.EveryTaskHasVariantMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.InstanceOfVariantMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.MakeParallelMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.MakeSequentialMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.UnassignedTaskMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.UnrequiredResourceInstanceMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.VariantAllocatedToTaskMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.AbsenceOfResourceInstancesQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.AllocateTaskToVariantQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.CreateResourceQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.EnoughResourceInstancesQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.EveryTaskHasVariantQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.InstanceOfVariantQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.MakeParallelQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.MakeSequentialQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.UnassignedTaskQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.UnrequiredResourceInstanceQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.VariantAllocatedToTaskQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * A pattern group formed of all patterns defined in patterns.vql.
 * 
 * <p>Use the static instance as any {@link org.eclipse.viatra.query.runtime.api.IPatternGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file patterns.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package org.eclipse.viatra.dse.examples.bpmn.patterns, the group contains the definition of the following patterns: <ul>
 * <li>createResource</li>
 * <li>variantAllocatedToTask</li>
 * <li>allocateTaskToVariant</li>
 * <li>inFlow</li>
 * <li>outFlow</li>
 * <li>makeParallel</li>
 * <li>parallelGatewayOutFlow</li>
 * <li>makeSequential</li>
 * <li>unassignedTask</li>
 * <li>instanceOfVariant</li>
 * <li>absenceOfResourceInstances</li>
 * <li>unrequiredResourceInstance</li>
 * <li>taskNeedsVariant</li>
 * <li>enoughResourceInstances</li>
 * <li>everyTaskHasVariant</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class Patterns extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Patterns instance() throws ViatraQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new Patterns();
    }
    return INSTANCE;
  }
  
  private static Patterns INSTANCE;
  
  private Patterns() throws ViatraQueryException {
    querySpecifications.add(CreateResourceQuerySpecification.instance());
    querySpecifications.add(VariantAllocatedToTaskQuerySpecification.instance());
    querySpecifications.add(AllocateTaskToVariantQuerySpecification.instance());
    querySpecifications.add(MakeParallelQuerySpecification.instance());
    querySpecifications.add(MakeSequentialQuerySpecification.instance());
    querySpecifications.add(UnassignedTaskQuerySpecification.instance());
    querySpecifications.add(InstanceOfVariantQuerySpecification.instance());
    querySpecifications.add(AbsenceOfResourceInstancesQuerySpecification.instance());
    querySpecifications.add(UnrequiredResourceInstanceQuerySpecification.instance());
    querySpecifications.add(EnoughResourceInstancesQuerySpecification.instance());
    querySpecifications.add(EveryTaskHasVariantQuerySpecification.instance());
  }
  
  public CreateResourceQuerySpecification getCreateResource() throws ViatraQueryException {
    return CreateResourceQuerySpecification.instance();
  }
  
  public CreateResourceMatcher getCreateResource(final ViatraQueryEngine engine) throws ViatraQueryException {
    return CreateResourceMatcher.on(engine);
  }
  
  public VariantAllocatedToTaskQuerySpecification getVariantAllocatedToTask() throws ViatraQueryException {
    return VariantAllocatedToTaskQuerySpecification.instance();
  }
  
  public VariantAllocatedToTaskMatcher getVariantAllocatedToTask(final ViatraQueryEngine engine) throws ViatraQueryException {
    return VariantAllocatedToTaskMatcher.on(engine);
  }
  
  public AllocateTaskToVariantQuerySpecification getAllocateTaskToVariant() throws ViatraQueryException {
    return AllocateTaskToVariantQuerySpecification.instance();
  }
  
  public AllocateTaskToVariantMatcher getAllocateTaskToVariant(final ViatraQueryEngine engine) throws ViatraQueryException {
    return AllocateTaskToVariantMatcher.on(engine);
  }
  
  public MakeParallelQuerySpecification getMakeParallel() throws ViatraQueryException {
    return MakeParallelQuerySpecification.instance();
  }
  
  public MakeParallelMatcher getMakeParallel(final ViatraQueryEngine engine) throws ViatraQueryException {
    return MakeParallelMatcher.on(engine);
  }
  
  public MakeSequentialQuerySpecification getMakeSequential() throws ViatraQueryException {
    return MakeSequentialQuerySpecification.instance();
  }
  
  public MakeSequentialMatcher getMakeSequential(final ViatraQueryEngine engine) throws ViatraQueryException {
    return MakeSequentialMatcher.on(engine);
  }
  
  public UnassignedTaskQuerySpecification getUnassignedTask() throws ViatraQueryException {
    return UnassignedTaskQuerySpecification.instance();
  }
  
  public UnassignedTaskMatcher getUnassignedTask(final ViatraQueryEngine engine) throws ViatraQueryException {
    return UnassignedTaskMatcher.on(engine);
  }
  
  public InstanceOfVariantQuerySpecification getInstanceOfVariant() throws ViatraQueryException {
    return InstanceOfVariantQuerySpecification.instance();
  }
  
  public InstanceOfVariantMatcher getInstanceOfVariant(final ViatraQueryEngine engine) throws ViatraQueryException {
    return InstanceOfVariantMatcher.on(engine);
  }
  
  public AbsenceOfResourceInstancesQuerySpecification getAbsenceOfResourceInstances() throws ViatraQueryException {
    return AbsenceOfResourceInstancesQuerySpecification.instance();
  }
  
  public AbsenceOfResourceInstancesMatcher getAbsenceOfResourceInstances(final ViatraQueryEngine engine) throws ViatraQueryException {
    return AbsenceOfResourceInstancesMatcher.on(engine);
  }
  
  public UnrequiredResourceInstanceQuerySpecification getUnrequiredResourceInstance() throws ViatraQueryException {
    return UnrequiredResourceInstanceQuerySpecification.instance();
  }
  
  public UnrequiredResourceInstanceMatcher getUnrequiredResourceInstance(final ViatraQueryEngine engine) throws ViatraQueryException {
    return UnrequiredResourceInstanceMatcher.on(engine);
  }
  
  public EnoughResourceInstancesQuerySpecification getEnoughResourceInstances() throws ViatraQueryException {
    return EnoughResourceInstancesQuerySpecification.instance();
  }
  
  public EnoughResourceInstancesMatcher getEnoughResourceInstances(final ViatraQueryEngine engine) throws ViatraQueryException {
    return EnoughResourceInstancesMatcher.on(engine);
  }
  
  public EveryTaskHasVariantQuerySpecification getEveryTaskHasVariant() throws ViatraQueryException {
    return EveryTaskHasVariantQuerySpecification.instance();
  }
  
  public EveryTaskHasVariantMatcher getEveryTaskHasVariant(final ViatraQueryEngine engine) throws ViatraQueryException {
    return EveryTaskHasVariantMatcher.on(engine);
  }
}
