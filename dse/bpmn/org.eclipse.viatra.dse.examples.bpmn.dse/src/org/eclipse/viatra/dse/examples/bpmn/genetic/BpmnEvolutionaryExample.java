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

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.viatra.dse.api.DesignSpaceExplorer;
import org.eclipse.viatra.dse.evolutionary.EvolutionaryStrategyBuilder;
import org.eclipse.viatra.dse.evolutionary.EvolutionaryStrategyLogAdapter;
import org.eclipse.viatra.dse.examples.bpmn.objectives.AvgResponseTimeSoftObjective;
import org.eclipse.viatra.dse.examples.bpmn.objectives.CostOfCreateResource;
import org.eclipse.viatra.dse.examples.bpmn.objectives.MinResourceUsageSoftObjective;
import org.eclipse.viatra.dse.examples.bpmn.patterns.AbsenceOfResourceInstances;
import org.eclipse.viatra.dse.examples.bpmn.patterns.EnoughResourceInstances;
import org.eclipse.viatra.dse.examples.bpmn.patterns.EveryTaskHasVariant;
import org.eclipse.viatra.dse.examples.bpmn.patterns.UnassignedTask;
import org.eclipse.viatra.dse.examples.bpmn.patterns.UnrequiredResourceInstance;
import org.eclipse.viatra.dse.examples.bpmn.problems.BpmnProblems;
import org.eclipse.viatra.dse.examples.bpmn.rules.BpmnRuleProvider;
import org.eclipse.viatra.dse.examples.bpmn.statecoder.BpmnStateCoderFactory;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage;
import org.eclipse.viatra.dse.objectives.Comparators;
import org.eclipse.viatra.dse.objectives.impl.ConstraintsObjective;
import org.eclipse.viatra.dse.objectives.impl.ModelQueriesGlobalConstraint;
import org.eclipse.viatra.dse.objectives.impl.TrajectoryCostSoftObjective;
import org.junit.Test;

public class BpmnEvolutionaryExample {

    @Test
    public void test() {

        Logger.getRootLogger().setLevel(Level.WARN);

        DesignSpaceExplorer dse = new DesignSpaceExplorer();

        SimplifiedBPMN model = BpmnProblems.createWebShopProblem();
        dse.setInitialModel(model);

        dse.setStateCoderFactory(new BpmnStateCoderFactory());

        // The built in general state coder is used if state coder is specified.
        // Then the following line is obligatory.
        dse.addMetaModelPackage(SimplifiedbpmnPackage.eINSTANCE);
        // Will be automatically called if no state coder is specified:
        // dse.setStateCoderFactory(new SimpleStateCoderFactory(dse.getMetaModelPackages()));

        BpmnRuleProvider ruleProvider = new BpmnRuleProvider();

        dse.addTransformationRule(ruleProvider.allocateRule);
        dse.addTransformationRule(ruleProvider.createResourceRule);
        dse.addTransformationRule(ruleProvider.makeParallelRule);
        dse.addTransformationRule(ruleProvider.makeSequentialRule);

        dse.addGlobalConstraint(new ModelQueriesGlobalConstraint()
                .withConstraint(UnrequiredResourceInstance.instance()));

        dse.addObjective(new ConstraintsObjective()
                .withHardConstraint(EnoughResourceInstances.instance())
                .withHardConstraint(EveryTaskHasVariant.instance())
                .withSoftConstraint("LackOfResourceInstances", AbsenceOfResourceInstances.instance(), 1)
                .withSoftConstraint("UnassignedTask", UnassignedTask.instance(), 10)
                .withSoftConstraint("UnrequiredResources", UnrequiredResourceInstance.instance(), 100)
                .withComparator(Comparators.LOWER_IS_BETTER)
                .withLevel(0));

        dse.addObjective(new TrajectoryCostSoftObjective()
                .withActivationCost(ruleProvider.createResourceRule, new CostOfCreateResource())
                .withRuleCost(ruleProvider.makeSequentialRule, 1)
                .withRuleCost(ruleProvider.makeParallelRule, 1)
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
