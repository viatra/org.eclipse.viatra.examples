package org.eclipse.viatra.dse.examples.bpmn.patterns.util;

import org.eclipse.viatra.dse.examples.bpmn.patterns.AbsenceOfResourceInstancesMatch;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the org.eclipse.viatra.dse.examples.bpmn.patterns.absenceOfResourceInstances pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class AbsenceOfResourceInstancesProcessor implements IMatchProcessor<AbsenceOfResourceInstancesMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pRTV the value of pattern parameter RTV in the currently processed match
   * 
   */
  public abstract void process(final ResourceTypeVariant pRTV);
  
  @Override
  public void process(final AbsenceOfResourceInstancesMatch match) {
    process(match.getRTV());
  }
}
