/*******************************************************************************
 * Copyright (c) 2010-2015, Andras Szabolcs Nagy, Abel Hegedus, Akos Horvath, Zoltan Ujhelyi and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Andras Szabolcs Nagy - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.dse.examples.bpmn.objectives;

import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.objectives.IObjective;
import org.eclipse.viatra.dse.objectives.impl.BaseObjective;

/**
 * This class represents the min. resource usage objective, but the actual calculation happens in the
 * {@link AvgResponseTimeHardObjective}.
 * 
 * @author Andras Szabolcs Nagy
 *
 */
public class MinResourceUsageSoftObjective extends BaseObjective {

    protected static final String DEFAUL_NAME = "MinResourceUsage";

    private Double fitness = Double.NaN;

    public MinResourceUsageSoftObjective() {
        super(DEFAUL_NAME);
    }

    public void setFitness(Double fitness) {
        this.fitness = fitness;
    }

    @Override
    public Double getFitness(ThreadContext context) {
        if (fitness.isNaN()) {
            throw new RuntimeException("getFitness was called on " + DEFAUL_NAME + " objective, before "
                    + AvgResponseTimeHardObjective.DEFAULT_NAME
                    + " objective getFitness. Please change the order of the two objectives.");
        }
        return fitness;
    }

    @Override
    public void init(ThreadContext context) {
    }

    @Override
    public IObjective createNew() {
        return new MinResourceUsageSoftObjective();
    }

    @Override
    public boolean isHardObjective() {
        return false;
    }

    @Override
    public boolean satisifiesHardObjective(Double fitness) {
        return true;
    }

}