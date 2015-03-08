package org.eclipse.viatra.dse.examples.bpmn.patterns.util;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.viatra.dse.examples.bpmn.patterns.InstanceOfVariantMatch;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant;

/**
 * A match processor tailored for the org.eclipse.viatra.dse.examples.bpmn.patterns.instanceOfVariant pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class InstanceOfVariantProcessor implements IMatchProcessor<InstanceOfVariantMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pRI the value of pattern parameter RI in the currently processed match
   * @param pRTV the value of pattern parameter RTV in the currently processed match
   * 
   */
  public abstract void process(final ResourceInstance pRI, final ResourceTypeVariant pRTV);
  
  @Override
  public void process(final InstanceOfVariantMatch match) {
    process(match.getRI(), match.getRTV());
  }
}
