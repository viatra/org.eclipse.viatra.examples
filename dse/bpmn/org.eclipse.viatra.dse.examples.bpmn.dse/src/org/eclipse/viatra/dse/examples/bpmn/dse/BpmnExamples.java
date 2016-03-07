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

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.dse.api.DSETransformationRule;
import org.eclipse.viatra.dse.api.DesignSpaceExplorer;
import org.eclipse.viatra.dse.api.Solution;
import org.eclipse.viatra.dse.api.SolutionTrajectory;
import org.eclipse.viatra.dse.api.Strategies;
import org.eclipse.viatra.dse.api.strategy.impl.FixedPriorityStrategy;
import org.eclipse.viatra.dse.api.strategy.impl.HillClimbingStrategy;
import org.eclipse.viatra.dse.examples.bpmn.objectives.AvgResponseTimeSoftObjective;
import org.eclipse.viatra.dse.examples.bpmn.objectives.MinResourceUsageSoftObjective;
import org.eclipse.viatra.dse.examples.bpmn.patterns.CreateResourceMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.AbsenceOfResourceInstancesQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.UnassignedTaskQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.UnrequiredResourceInstanceQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.problems.BpmnProblems;
import org.eclipse.viatra.dse.examples.bpmn.rules.AssignVariantToTaskRule;
import org.eclipse.viatra.dse.examples.bpmn.rules.CreateResourceRule;
import org.eclipse.viatra.dse.examples.bpmn.rules.MakeParallelRule;
import org.eclipse.viatra.dse.examples.bpmn.rules.MakeSequentialRule;
import org.eclipse.viatra.dse.examples.bpmn.statecoder.BpmnStateCoderFactory;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedbpmnPackage;
import org.eclipse.viatra.dse.objectives.ActivationFitnessProcessor;
import org.eclipse.viatra.dse.objectives.Comparators;
import org.eclipse.viatra.dse.objectives.impl.ModelQueriesGlobalConstraint;
import org.eclipse.viatra.dse.objectives.impl.TrajectoryCostSoftObjective;
import org.eclipse.viatra.dse.objectives.impl.WeightedQueriesSoftObjective;
import org.eclipse.viatra.dse.solutionstore.SimpleSolutionStore;
import org.eclipse.viatra.dse.solutionstore.StrategyDependentSolutionStore;
import org.eclipse.viatra.dse.visualizer.GraphmlDesignSpaceVisualizer;
import org.junit.After;
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
public class BpmnExamples {

    /**
     * Costs of the different resource instances.
     */
    public static final class CostOfCreateResource implements ActivationFitnessProcessor {
        @Override
        public double process(IPatternMatch match) {
            CreateResourceMatch m = (CreateResourceMatch) match;
            String name = m.getRTV().getName();
            Double result;
            if (name.equals(BpmnProblems.NOSQL_FAST)) {
                result = 5d;
            } else if (name.equals(BpmnProblems.NOSQL_MEDIUM)) {
                result = 3d;
            } else if (name.equals(BpmnProblems.NOSQL_SLOW)) {
                result = 1.5d;
            } else if (name.equals(BpmnProblems.SQL_FAST)) {
                result = 5d;
            } else if (name.equals(BpmnProblems.SQL_MEDIUM)) {
                result = 3d;
            } else if (name.equals(BpmnProblems.SQL_SLOW)) {
                result = 1.5d;
            } else if (name.equals(BpmnProblems.WS)) {
                result = 1d;
            } else
                result = 0d;
            return result;
        }
    }

    /**
     * Variables are converted to fields only for easier usage. 
     */
    private DSETransformationRule<?, ?> allocateRule;
    private DSETransformationRule<?, ?> createResourceRule;
    private DSETransformationRule<?, ?> makeParallelRule;
    private DSETransformationRule<?, ?> makeSequentialRule;
    private DesignSpaceExplorer dse;
    private FixedPriorityStrategy fixedPriorityStrategy;
    private EObject model;
    private GraphmlDesignSpaceVisualizer visualizer;
    private ActivationFitnessProcessor costOfCreateResource;

    @BeforeClass
    public static void setUpOnce() {
        // Apache logger basic configuration
        // BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.ERROR);
        
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

        allocateRule = AssignVariantToTaskRule.createRule();
        createResourceRule = CreateResourceRule.createRule();
        makeParallelRule = MakeParallelRule.createRule();
        makeSequentialRule = MakeSequentialRule.createRule();

        dse.addTransformationRule(allocateRule);
        dse.addTransformationRule(createResourceRule);
        dse.addTransformationRule(makeParallelRule);
        dse.addTransformationRule(makeSequentialRule);

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

        costOfCreateResource = new CostOfCreateResource();

        // Costs objective
        dse.addObjective(new TrajectoryCostSoftObjective()
                .withActivationCost(createResourceRule, costOfCreateResource)
                .withRuleCost(makeSequentialRule, 1)
                .withRuleCost(makeParallelRule, 1)
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

        // Stop at first valid solution
        dse.setSolutionStore(new SimpleSolutionStore(1));

        dse.setMaxNumberOfThreads(1);
        
        // The trace of the strategy can be visualized with these lines of code,
        // visualizer.save(); should be called after the exploration - tearDown() method
        // visualizer = new GraphmlDesignSpaceVisualizer("BPMNDesignSpace.graphml");
        // dse.addDesignSpaceVisulaizer(visualizer);

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
        
        System.out.println(dse.toStringSolutions());
        
        // To get all of the solutions
        Collection<Solution> solutions = dse.getSolutions();
        
        // visualizer.save();
    }

    @Test
    public void fixedPrioritySearch() throws ViatraQueryException {
        fixedPriorityStrategy = new FixedPriorityStrategy()
            .withRulePriority(allocateRule, 10)
            .withRulePriority(createResourceRule, 5)
            .withRulePriority(makeParallelRule, 1)
            .withRulePriority(makeSequentialRule, 1);
        
        dse.startExploration(fixedPriorityStrategy);
    }

    @Test
    public void DFS() throws ViatraQueryException {
        dse.startExploration(Strategies.createDFSStrategy(4));
    }

    @Test
    public void BFS() throws ViatraQueryException {
        dse.startExploration(Strategies.createBFSStrategy(4));
    }

    @Test
    public void hillClimbing() throws ViatraQueryException {
        dse.setSolutionStore(new StrategyDependentSolutionStore());
        dse.startExploration(new HillClimbingStrategy());
    }

}
