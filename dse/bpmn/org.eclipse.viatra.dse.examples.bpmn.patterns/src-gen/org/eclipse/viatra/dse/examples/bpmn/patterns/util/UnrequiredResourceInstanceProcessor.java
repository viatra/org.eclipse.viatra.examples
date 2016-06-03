/**
 * 
 *   Copyright (c) 2010-2015, Andras Szabolcs Nagy, Abel Hegedus, Akos Horvath, Zoltan Ujhelyi and Daniel Varro
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *   Contributors:
 *     Andras Szabolcs Nagy - initial API and implementation
 *  
 */
package org.eclipse.viatra.dse.examples.bpmn.patterns.util;

import org.eclipse.viatra.dse.examples.bpmn.patterns.UnrequiredResourceInstanceMatch;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the org.eclipse.viatra.dse.examples.bpmn.patterns.unrequiredResourceInstance pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class UnrequiredResourceInstanceProcessor implements IMatchProcessor<UnrequiredResourceInstanceMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pRI the value of pattern parameter RI in the currently processed match
   * 
   */
  public abstract void process(final ResourceInstance pRI);
  
  @Override
  public void process(final UnrequiredResourceInstanceMatch match) {
    process(match.getRI());
  }
}
