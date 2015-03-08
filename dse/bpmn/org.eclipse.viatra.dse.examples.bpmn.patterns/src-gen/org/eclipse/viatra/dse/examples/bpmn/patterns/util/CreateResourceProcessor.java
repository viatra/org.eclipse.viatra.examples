package org.eclipse.viatra.dse.examples.bpmn.patterns.util;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.viatra.dse.examples.bpmn.patterns.CreateResourceMatch;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant;

/**
 * A match processor tailored for the org.eclipse.viatra.dse.examples.bpmn.patterns.createResource pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class CreateResourceProcessor implements IMatchProcessor<CreateResourceMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pRTV the value of pattern parameter RTV in the currently processed match
   * 
   */
  public abstract void process(final ResourceTypeVariant pRTV);
  
  @Override
  public void process(final CreateResourceMatch match) {
    process(match.getRTV());
  }
}
