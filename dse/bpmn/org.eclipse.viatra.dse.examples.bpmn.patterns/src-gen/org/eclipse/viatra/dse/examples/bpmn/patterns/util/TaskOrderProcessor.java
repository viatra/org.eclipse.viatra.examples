package org.eclipse.viatra.dse.examples.bpmn.patterns.util;

import org.eclipse.viatra.dse.examples.bpmn.patterns.TaskOrderMatch;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.Task;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the org.eclipse.viatra.dse.examples.bpmn.patterns.taskOrder pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class TaskOrderProcessor implements IMatchProcessor<TaskOrderMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pT1 the value of pattern parameter T1 in the currently processed match
   * @param pT2 the value of pattern parameter T2 in the currently processed match
   * 
   */
  public abstract void process(final Task pT1, final Task pT2);
  
  @Override
  public void process(final TaskOrderMatch match) {
    process(match.getT1(), match.getT2());
  }
}
