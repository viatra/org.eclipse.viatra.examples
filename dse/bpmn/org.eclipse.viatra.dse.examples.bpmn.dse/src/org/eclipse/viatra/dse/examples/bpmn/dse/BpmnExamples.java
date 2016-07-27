/*******************************************************************************
 * Copyright (c) 2010-2015, Andras Szabolcs Nagy, Abel Hegedus, Akos Horvath, Zoltan Ujhelyi and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Andras Szabolcs Nagy - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.dse.examples.bpmn.dse;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.dse.api.DesignSpaceExplorer;
import org.eclipse.viatra.dse.api.Solution;
import org.eclipse.viatra.dse.api.SolutionTrajectory;
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
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.transformation.evm.specific.ConflictResolvers;
import org.eclipse.viatra.transformation.evm.specific.resolver.FixedPriorityConflictResolver;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.base.Stopwatch;

/**
 * This class gives an example usage of the VIATRA-DSE framework. Use JUnit plug-in test run configuration to try it
 * out.
 * 
 * @author Andras Szabolcs Nagy
 *
 */
public class BpmnExamples {

    /**
     * Variables are converted to fields only for easier usage. 
     */
    private BpmnRuleProvider ruleProvider;
    private DesignSpaceExplorer dse;
    private FixedPriorityStrategy fixedPriorityStrategy;
    private EObject model;
    private Stopwatch stopwatch;

    @BeforeClass
    public static void setUpOnce() {
        // Apache logger basic configuration
        Logger.getRootLogger().setLevel(Level.WARN);
        
        // For debugging you can either set the level to ALL,
        // Logger.getRootLogger().setLevel(Level.ALL);
        
        // or turn it on only for one class, e.g.
        // Logger.getLogger(DesignSpaceManager.class).setLevel(Level.ALL);
        // Logger.getLogger(HillClimbingStrategy.class).setLevel(Level.DEBUG);
        // Logger.getLogger(ParallelBFSStrategy.class).setLevel(Level.DEBUG);
        // Logger.getLogger(DepthFirstStrategy.class).setLevel(Level.DEBUG);
        // Logger.getLogger(FixedPriorityStrategy.class).setLevel(Level.DEBUG);
    }

    /**
     * Configuration of the VIATRA-DSE framework
     */
    @Before
    public void setUp() throws ViatraQueryException {

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

        dse.setSolutionStore(new SolutionStore(50).storeBestSolutionsOnly());

        dse.setMaxNumberOfThreads(1);
        
        stopwatch = Stopwatch.createStarted();
    }

    /**
     * Things you can do after the exploration
     */
    @After
    public void tearDown() throws ViatraQueryException {
        // Get an arbitrary solution trajectory
        SolutionTrajectory solutionTrajectory = dse.getArbitrarySolution();
        if (solutionTrajectory != null) {
            // Transform the initial model along the found solution
            solutionTrajectory.setModel(model);
            solutionTrajectory.doTransformation();
        }
        
        stopwatch.stop();
        System.out.println("States:" + dse.getNumberOfStates());
        System.out.println("Transitions:" + dse.getNumberOfTransitions());
        System.out.println("Milisecs: " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
        System.out.println(dse.toStringSolutions());
        
        // To get all of the solutions
        Collection<Solution> solutions = dse.getSolutions();
        
        SolutionTrajectory arbitrarySolution = dse.getArbitrarySolution();
    }

    @Test
    public void fixedPrioritySearch() throws ViatraQueryException {
        fixedPriorityStrategy = new FixedPriorityStrategy()
            .withDepthLimit(10)
            .withRulePriority(ruleProvider.allocateRule, 10)
            .withRulePriority(ruleProvider.createResourceRule, 5)
            .withRulePriority(ruleProvider.makeParallelRule, 1)
            .withRulePriority(ruleProvider.makeSequentialRule, 1);
        
        dse.startExploration(fixedPriorityStrategy);
    }

    @Test
    public void DfsWithFixedPriorityConflictResolver() throws ViatraQueryException {
        FixedPriorityConflictResolver conflictResolver = ConflictResolvers.createFixedPriorityResolver();
        conflictResolver.setPriority(ruleProvider.allocateRule.getRuleSpecification(), 1);
        conflictResolver.setPriority(ruleProvider.createResourceRule.getRuleSpecification(), 5);
        conflictResolver.setPriority(ruleProvider.makeParallelRule.getRuleSpecification(), 10);
        conflictResolver.setPriority(ruleProvider.makeSequentialRule.getRuleSpecification(), 10);
        dse.setConflictResolver(conflictResolver);
        dse.startExploration(Strategies.createDfsStrategy(10));
    }

    @Test
    public void DFS() throws ViatraQueryException {
        dse.startExploration(Strategies.createDfsStrategy(12).continueIfHardObjectivesFulfilled());
    }

    @Test
    public void BFS() throws ViatraQueryException {
        dse.startExploration(Strategies.createBfsStrategy(7));
    }

    @Test
    public void hillClimbing() throws ViatraQueryException {
        dse.startExploration(Strategies.creatHillClimbingStrategy());
    }

}
