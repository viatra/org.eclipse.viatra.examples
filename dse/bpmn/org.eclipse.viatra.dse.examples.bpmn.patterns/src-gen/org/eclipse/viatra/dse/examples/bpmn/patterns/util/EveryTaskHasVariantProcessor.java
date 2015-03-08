package org.eclipse.viatra.dse.examples.bpmn.patterns.util;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.viatra.dse.examples.bpmn.patterns.EveryTaskHasVariantMatch;

/**
 * A match processor tailored for the org.eclipse.viatra.dse.examples.bpmn.patterns.everyTaskHasVariant pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class EveryTaskHasVariantProcessor implements IMatchProcessor<EveryTaskHasVariantMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * 
   */
  public abstract void process();
  
  @Override
  public void process(final EveryTaskHasVariantMatch match) {
    process();
  }
}
