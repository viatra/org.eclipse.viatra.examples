/*******************************************************************************
 * Copyright (c) 2010-2016, Andras Szabolcs Nagy and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Andras Szabolcs Nagy - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.dse.examples.bpmn.genetic;

import org.eclipse.viatra.dse.api.DSETransformationRule;
import org.eclipse.viatra.dse.api.DesignSpaceExplorer;
import org.eclipse.viatra.dse.evolutionary.EvolutionaryStrategyBuilder;
import org.eclipse.viatra.dse.evolutionary.EvolutionaryStrategyLogAdapter;
import org.eclipse.viatra.dse.examples.bpmn.dse.BpmnExamples.CostOfCreateResource;
import org.eclipse.viatra.dse.examples.bpmn.objectives.AvgResponseTimeSoftObjective;
import org.eclipse.viatra.dse.examples.bpmn.objectives.MinResourceUsageSoftObjective;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.AbsenceOfResourceInstancesQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.EnoughResourceInstancesQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.EveryTaskHasVariantQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.UnassignedTaskQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.UnrequiredResourceInstanceQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.problems.BpmnProblems;
import org.eclipse.viatra.dse.examples.bpmn.rules.AssignVariantToTaskRule;
import org.eclipse.viatra.dse.examples.bpmn.rules.CreateResourceRule;
import org.eclipse.viatra.dse.examples.bpmn.rules.MakeParallelRule;
import org.eclipse.viatra.dse.examples.bpmn.rules.MakeSequentialRule;
import org.eclipse.viatra.dse.examples.bpmn.statecoder.BpmnStateCoderFactory;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage;
import org.eclipse.viatra.dse.objectives.Comparators;
import org.eclipse.viatra.dse.objectives.impl.ConstraintsObjective;
import org.eclipse.viatra.dse.objectives.impl.ModelQueriesGlobalConstraint;
import org.eclipse.viatra.dse.objectives.impl.TrajectoryCostSoftObjective;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.junit.Test;

public class BpmnEvolutionaryExample {

    @Test
    public void test() throws ViatraQueryException {

        DesignSpaceExplorer dse = new DesignSpaceExplorer();

        SimplifiedBPMN model = BpmnProblems.createWebShopProblem();
        dse.setInitialModel(model);

        dse.setStateCoderFactory(new BpmnStateCoderFactory());

        // The built in general state coder is used if state coder is specified.
        // Then the following line is obligatory.
        dse.addMetaModelPackage(SimplifiedbpmnPackage.eINSTANCE);
        // Will be automatically called if no state coder is specified:
        // dse.setStateCoderFactory(new SimpleStateCoderFactory(dse.getMetaModelPackages()));

        DSETransformationRule<?, ?> allocateRule = AssignVariantToTaskRule.createRule();
        DSETransformationRule<?, ?> createResourceRule = CreateResourceRule.createRule();
        DSETransformationRule<?, ?> makeParallelRule = MakeParallelRule.createRule();
        DSETransformationRule<?, ?> makeSequentialRule = MakeSequentialRule.createRule();

        dse.addTransformationRule(allocateRule);
        dse.addTransformationRule(createResourceRule);
        dse.addTransformationRule(makeParallelRule);
        dse.addTransformationRule(makeSequentialRule);

        dse.addGlobalConstraint(new ModelQueriesGlobalConstraint()
                .withConstraint(UnrequiredResourceInstanceQuerySpecification.instance()));

        dse.addObjective(new ConstraintsObjective()
                .withHardConstraint(EnoughResourceInstancesQuerySpecification.instance())
                .withHardConstraint(EveryTaskHasVariantQuerySpecification.instance())
                .withSoftConstraint("LackOfResourceInstances", AbsenceOfResourceInstancesQuerySpecification.instance(), 1)
                .withSoftConstraint("UnassignedTask", UnassignedTaskQuerySpecification.instance(), 10)
                .withSoftConstraint("UnrequiredResources", UnrequiredResourceInstanceQuerySpecification.instance(), 100)
                .withComparator(Comparators.LOWER_IS_BETTER)
                .withLevel(0));
        CostOfCreateResource costOfCreateResource = new CostOfCreateResource();
        dse.addObjective(new TrajectoryCostSoftObjective()
                .withActivationCost(createResourceRule, costOfCreateResource)
                .withRuleCost(makeSequentialRule, 1)
                .withRuleCost(makeParallelRule, 1)
                .withComparator(Comparators.LOWER_IS_BETTER)
                .withLevel(1));
        dse.addObjective(new AvgResponseTimeSoftObjective()
                .withComparator(Comparators.LOWER_IS_BETTER)
                .withLevel(1));
        dse.addObjective(new MinResourceUsageSoftObjective()
                .withComparator(Comparators.HIGHER_IS_BETTER)
                .withLevel(1));

        dse.setMaxNumberOfThreads(1);

        EvolutionaryStrategyLogAdapter evolutionaryStrategyLogAdapter = new EvolutionaryStrategyLogAdapter();
        evolutionaryStrategyLogAdapter.setCsvFileName("bpmnEvolutionaryStrategyLog");

        EvolutionaryStrategyBuilder strategyBuilder = EvolutionaryStrategyBuilder.createNsga2BuilderFull(5);
        strategyBuilder.addStrategyAdapter(evolutionaryStrategyLogAdapter);

        dse.startExploration(strategyBuilder.build());

        System.out.println(dse.toStringSolutions());
    }
}
