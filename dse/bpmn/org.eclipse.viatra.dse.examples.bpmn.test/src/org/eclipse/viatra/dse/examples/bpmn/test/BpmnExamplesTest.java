/*******************************************************************************
 * Copyright (c) 2010-2015, Andras Szabolcs Nagy, Abel Hegedus, Akos Horvath, Zoltan Ujhelyi and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Andras Szabolcs Nagy - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.dse.examples.bpmn.test;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.dse.api.DesignSpaceExplorer;
import org.eclipse.viatra.dse.api.Solution;
import org.eclipse.viatra.dse.api.Strategies;
import org.eclipse.viatra.dse.api.strategy.impl.FixedPriorityStrategy;
import org.eclipse.viatra.dse.examples.bpmn.objectives.AvgResponseTimeSoftObjective;
import org.eclipse.viatra.dse.examples.bpmn.objectives.CostOfCreateResource;
import org.eclipse.viatra.dse.examples.bpmn.objectives.MinResourceUsageSoftObjective;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.AbsenceOfResourceInstancesQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.EnoughResourceInstancesQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.EveryTaskHasVariantQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.UnassignedTaskQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.UnrequiredResourceInstanceQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.problems.BpmnProblems;
import org.eclipse.viatra.dse.examples.bpmn.rules.BpmnRuleProvider;
import org.eclipse.viatra.dse.examples.bpmn.statecoder.BpmnStateCoderFactory;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage;
import org.eclipse.viatra.dse.objectives.Comparators;
import org.eclipse.viatra.dse.objectives.impl.ConstraintsObjective;
import org.eclipse.viatra.dse.objectives.impl.ModelQueriesGlobalConstraint;
import org.eclipse.viatra.dse.objectives.impl.TrajectoryCostSoftObjective;
import org.eclipse.viatra.dse.solutionstore.SolutionStore;
import org.eclipse.viatra.transformation.evm.specific.ConflictResolvers;
import org.eclipse.viatra.transformation.evm.specific.resolver.FixedPriorityConflictResolver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This class gives an example usage of the VIATRA-DSE framework. Use JUnit plug-in test run configuration to try it
 * out.
 * 
 * @author Andras Szabolcs Nagy
 *
 */
public class BpmnExamplesTest {

    private static final int NUM_OF_SOLUTIONS_TO_FIND = 50;
    /**
     * Variables are converted to fields only for easier usage. 
     */
    private BpmnRuleProvider ruleProvider;
    private DesignSpaceExplorer dse;
    private FixedPriorityStrategy fixedPriorityStrategy;
    private EObject model;

    @BeforeClass
    public static void setUpOnce() {
        Logger.getRootLogger().setLevel(Level.WARN);
    }

    /**
     * Configuration of the VIATRA-DSE framework
     */
    @Before
    public void setUp() {

        dse = new DesignSpaceExplorer();

        model = BpmnProblems.createWebShopProblem();
        dse.setInitialModel(model);

        dse.setStateCoderFactory(new BpmnStateCoderFactory());

        // The built in general state coder is used if state coder is specified.
        // Then the following line is obligatory.
        dse.addMetaModelPackage(SimplifiedbpmnPackage.eINSTANCE);
        // Will be automatically called if no state coder is specified:
        // dse.setStateCoderFactory(new SimpleStateCoderFactory(dse.getMetaModelPackages()));

        ruleProvider = new BpmnRuleProvider();

        dse.addTransformationRule(ruleProvider.allocateRule);
        dse.addTransformationRule(ruleProvider.createResourceRule);
        dse.addTransformationRule(ruleProvider.makeParallelRule);
        dse.addTransformationRule(ruleProvider.makeSequentialRule);

        dse.addGlobalConstraint(new ModelQueriesGlobalConstraint()
                .withConstraint(UnrequiredResourceInstanceQuerySpecification.instance()));
        
        // Guidance objective
        dse.addObjective(new ConstraintsObjective()
                .withHardConstraint(EnoughResourceInstancesQuerySpecification.instance())
                .withHardConstraint(EveryTaskHasVariantQuerySpecification.instance())
                .withSoftConstraint(AbsenceOfResourceInstancesQuerySpecification.instance(), 1)
                .withSoftConstraint(UnassignedTaskQuerySpecification.instance(), 10)
                .withComparator(Comparators.LOWER_IS_BETTER)
                .withLevel(0));

        // Costs objective
        dse.addObjective(new TrajectoryCostSoftObjective()
                .withActivationCost(ruleProvider.createResourceRule, new CostOfCreateResource())
                .withRuleCost(ruleProvider.makeSequentialRule, 1)
                .withRuleCost(ruleProvider.makeParallelRule, 1)
                .withComparator(Comparators.LOWER_IS_BETTER)
                .withLevel(1));
        
        // Adds two more custom objectives: response time and resource utilization. Both of them are evaluated by
        // simulating the BPMN model.
        // The actual simulation is run by the AvgResponseTimeSoftObjective and calculates both objectives.
        dse.addObjective(new AvgResponseTimeSoftObjective()
                .withComparator(Comparators.LOWER_IS_BETTER)
                .withLevel(1));
        dse.addObjective(new MinResourceUsageSoftObjective()
                .withComparator(Comparators.HIGHER_IS_BETTER)
                .withLevel(1));

        dse.setSolutionStore(new SolutionStore(NUM_OF_SOLUTIONS_TO_FIND).storeBestSolutionsOnly());

        dse.setMaxNumberOfThreads(1);
    }

    @Test
    public void fixedPrioritySearch() {
        fixedPriorityStrategy = new FixedPriorityStrategy()
            .withDepthLimit(10)
            .withRulePriority(ruleProvider.allocateRule, 10)
            .withRulePriority(ruleProvider.createResourceRule, 5)
            .withRulePriority(ruleProvider.makeParallelRule, 1)
            .withRulePriority(ruleProvider.makeSequentialRule, 1);
        
        dse.startExploration(fixedPriorityStrategy);
        assertFoundAnySolution();
    }

    @Test
    public void DfsWithFixedPriorityConflictResolver() {
        FixedPriorityConflictResolver conflictResolver = ConflictResolvers.createFixedPriorityResolver();
        conflictResolver.setPriority(ruleProvider.allocateRule.getRuleSpecification(), 1);
        conflictResolver.setPriority(ruleProvider.createResourceRule.getRuleSpecification(), 5);
        conflictResolver.setPriority(ruleProvider.makeParallelRule.getRuleSpecification(), 10);
        conflictResolver.setPriority(ruleProvider.makeSequentialRule.getRuleSpecification(), 10);
        dse.setConflictResolver(conflictResolver);
        dse.startExploration(Strategies.createDfsStrategy(10));
        assertFoundAnySolution();
    }

    @Test
    public void DFS() {
        dse.startExploration(Strategies.createDfsStrategy(12).continueIfHardObjectivesFulfilled());
        assertFoundAnySolution();
    }

    @Test
    public void BFS() {
        dse.startExploration(Strategies.createBfsStrategy(7));
    }

    @Test
    public void hillClimbing() {
        dse.startExploration(Strategies.creatHillClimbingStrategy());
        assertFoundAnySolution();
    }

    private void assertFoundAnySolution() {
        int numberOfSolutions = 0;
        
        for (Solution solution : dse.getSolutions()) {
            numberOfSolutions += solution.getTrajectories().size();
        }
        
        Assert.assertTrue("VIATRA-DSE failed to find any solutions." + numberOfSolutions, numberOfSolutions > 0);
    }
}
