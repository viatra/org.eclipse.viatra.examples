package org.eclipse.viatra.dse.examples.bpmn.patterns;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;
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

/**
 * A pattern group formed of all patterns defined in patterns.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare
 * an EMF-IncQuery engine for matching all patterns originally defined in file patterns.eiq,
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
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Patterns instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new Patterns();
    }
    return INSTANCE;
  }
  
  private static Patterns INSTANCE;
  
  private Patterns() throws IncQueryException {
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
  
  public CreateResourceQuerySpecification getCreateResource() throws IncQueryException {
    return CreateResourceQuerySpecification.instance();
  }
  
  public CreateResourceMatcher getCreateResource(final IncQueryEngine engine) throws IncQueryException {
    return CreateResourceMatcher.on(engine);
  }
  
  public VariantAllocatedToTaskQuerySpecification getVariantAllocatedToTask() throws IncQueryException {
    return VariantAllocatedToTaskQuerySpecification.instance();
  }
  
  public VariantAllocatedToTaskMatcher getVariantAllocatedToTask(final IncQueryEngine engine) throws IncQueryException {
    return VariantAllocatedToTaskMatcher.on(engine);
  }
  
  public AllocateTaskToVariantQuerySpecification getAllocateTaskToVariant() throws IncQueryException {
    return AllocateTaskToVariantQuerySpecification.instance();
  }
  
  public AllocateTaskToVariantMatcher getAllocateTaskToVariant(final IncQueryEngine engine) throws IncQueryException {
    return AllocateTaskToVariantMatcher.on(engine);
  }
  
  public MakeParallelQuerySpecification getMakeParallel() throws IncQueryException {
    return MakeParallelQuerySpecification.instance();
  }
  
  public MakeParallelMatcher getMakeParallel(final IncQueryEngine engine) throws IncQueryException {
    return MakeParallelMatcher.on(engine);
  }
  
  public MakeSequentialQuerySpecification getMakeSequential() throws IncQueryException {
    return MakeSequentialQuerySpecification.instance();
  }
  
  public MakeSequentialMatcher getMakeSequential(final IncQueryEngine engine) throws IncQueryException {
    return MakeSequentialMatcher.on(engine);
  }
  
  public UnassignedTaskQuerySpecification getUnassignedTask() throws IncQueryException {
    return UnassignedTaskQuerySpecification.instance();
  }
  
  public UnassignedTaskMatcher getUnassignedTask(final IncQueryEngine engine) throws IncQueryException {
    return UnassignedTaskMatcher.on(engine);
  }
  
  public InstanceOfVariantQuerySpecification getInstanceOfVariant() throws IncQueryException {
    return InstanceOfVariantQuerySpecification.instance();
  }
  
  public InstanceOfVariantMatcher getInstanceOfVariant(final IncQueryEngine engine) throws IncQueryException {
    return InstanceOfVariantMatcher.on(engine);
  }
  
  public AbsenceOfResourceInstancesQuerySpecification getAbsenceOfResourceInstances() throws IncQueryException {
    return AbsenceOfResourceInstancesQuerySpecification.instance();
  }
  
  public AbsenceOfResourceInstancesMatcher getAbsenceOfResourceInstances(final IncQueryEngine engine) throws IncQueryException {
    return AbsenceOfResourceInstancesMatcher.on(engine);
  }
  
  public UnrequiredResourceInstanceQuerySpecification getUnrequiredResourceInstance() throws IncQueryException {
    return UnrequiredResourceInstanceQuerySpecification.instance();
  }
  
  public UnrequiredResourceInstanceMatcher getUnrequiredResourceInstance(final IncQueryEngine engine) throws IncQueryException {
    return UnrequiredResourceInstanceMatcher.on(engine);
  }
  
  public EnoughResourceInstancesQuerySpecification getEnoughResourceInstances() throws IncQueryException {
    return EnoughResourceInstancesQuerySpecification.instance();
  }
  
  public EnoughResourceInstancesMatcher getEnoughResourceInstances(final IncQueryEngine engine) throws IncQueryException {
    return EnoughResourceInstancesMatcher.on(engine);
  }
  
  public EveryTaskHasVariantQuerySpecification getEveryTaskHasVariant() throws IncQueryException {
    return EveryTaskHasVariantQuerySpecification.instance();
  }
  
  public EveryTaskHasVariantMatcher getEveryTaskHasVariant(final IncQueryEngine engine) throws IncQueryException {
    return EveryTaskHasVariantMatcher.on(engine);
  }
}
