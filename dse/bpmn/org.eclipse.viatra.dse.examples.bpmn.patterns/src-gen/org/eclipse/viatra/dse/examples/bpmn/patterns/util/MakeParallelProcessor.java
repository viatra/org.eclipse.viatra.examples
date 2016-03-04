package org.eclipse.viatra.dse.examples.bpmn.patterns.util;

import org.eclipse.viatra.dse.examples.bpmn.patterns.MakeParallelMatch;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.Task;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the org.eclipse.viatra.dse.examples.bpmn.patterns.makeParallel pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class MakeParallelProcessor implements IMatchProcessor<MakeParallelMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pT1 the value of pattern parameter T1 in the currently processed match
   * @param pT2 the value of pattern parameter T2 in the currently processed match
   * @param pRoot the value of pattern parameter Root in the currently processed match
   * 
   */
  public abstract void process(final Task pT1, final Task pT2, final SimplifiedBPMN pRoot);
  
  @Override
  public void process(final MakeParallelMatch match) {
    process(match.getT1(), match.getT2(), match.getRoot());
  }
}
