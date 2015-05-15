package org.eclipse.viatra.dse.examples.bpmn.genetic;

import java.util.Arrays;
import java.util.List;

import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.api.DSETransformationRule;
import org.eclipse.viatra.dse.api.PatternWithCardinality;
import org.eclipse.viatra.dse.base.GlobalContext;
import org.eclipse.viatra.dse.examples.bpmn.dse.BpmnExamples;
import org.eclipse.viatra.dse.examples.bpmn.objectives.AvgResponseTimeHardObjective;
import org.eclipse.viatra.dse.examples.bpmn.objectives.MinResourceUsageSoftObjective;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.AbsenceOfResourceInstancesQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.EnoughResourceInstancesQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.EveryTaskHasVariantQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.UnassignedTaskQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.UnrequiredResourceInstanceQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.rules.AssignVariantToTaskRule;
import org.eclipse.viatra.dse.examples.bpmn.rules.CreateResourceRule;
import org.eclipse.viatra.dse.examples.bpmn.rules.MakeParallelRule;
import org.eclipse.viatra.dse.examples.bpmn.rules.MakeSequentialRule;
import org.eclipse.viatra.dse.examples.bpmn.statecoder.BpmnStateCoderFactory;
import org.eclipse.viatra.dse.genetic.api.GeneticDesignSpaceExplorer;
import org.eclipse.viatra.dse.genetic.core.GeneticSoftConstraintHardObjective;
import org.eclipse.viatra.dse.genetic.core.InstanceData;
import org.eclipse.viatra.dse.genetic.debug.GeneticDebugger;
import org.eclipse.viatra.dse.genetic.debug.GeneticTestRunner;
import org.eclipse.viatra.dse.genetic.debug.Row;
import org.eclipse.viatra.dse.genetic.selectors.NonDominatedAndCrowdingDistanceSelector;
import org.eclipse.viatra.dse.objectives.Comparators;
import org.eclipse.viatra.dse.objectives.impl.TrajectoryCostSoftObjective;

public abstract class BpmnGeneticTestRunner extends GeneticTestRunner {

    public static final int CONSTRAINT_WEIGHT = 10;
    public static final String MIN_RESOURCE_UTILIZATION = "MinResourceUtilization";
    public static final String AVG_RESPONSE_TIME = "AvgResponseTime";
    public static final String COST = "Cost";
    public static final String CONST_FULFILLMENT = "ConstFulfillment";
    private String modelPath;

    public abstract int getNumberOfTokens();

    public abstract int getRateOfTokens();
    
    public BpmnGeneticTestRunner() {
        super(getGoals());
    }

    private static List<PatternWithCardinality> getGoals(){
        try {
            return Arrays.asList(
                    new PatternWithCardinality(EnoughResourceInstancesQuerySpecification.instance()),
                    new PatternWithCardinality(EveryTaskHasVariantQuerySpecification.instance()));
        } catch (IncQueryException e) {
            return null;
        }
    }
    
    @Override
    public GeneticDesignSpaceExplorer createGdse(Row configRow) throws IncQueryException {
        modelPath = configRow.getValueAsString(GeneticTestRunner.MODEL_PATH);

        GeneticDesignSpaceExplorer gdse = new GeneticDesignSpaceExplorer();
        
        
        gdse.setStateCoderFactory(new BpmnStateCoderFactory());
        
        DSETransformationRule<?, ?> assignTaskRule = AssignVariantToTaskRule.createRule();
        DSETransformationRule<?, ?> createResourceRule = CreateResourceRule.createRule();
        DSETransformationRule<?, ?> makeParallelRule = MakeParallelRule.createRule();
        DSETransformationRule<?, ?> makeSequentialRule = MakeSequentialRule.createRule();
        gdse.addTransformationRule(assignTaskRule, 3);
        gdse.addTransformationRule(createResourceRule, 2);
        gdse.addTransformationRule(makeParallelRule, 1);
        gdse.addTransformationRule(makeSequentialRule, 1);

        gdse.setSelector(new NonDominatedAndCrowdingDistanceSelector());

        gdse.addObjective(new GeneticSoftConstraintHardObjective()
                .withConstraint("LackOfResourceInstances", AbsenceOfResourceInstancesQuerySpecification.instance(), 1)
                .withConstraint("UnassignedTask", UnassignedTaskQuerySpecification.instance(), 10)
                .withConstraint("UnrequiredResources", UnrequiredResourceInstanceQuerySpecification.instance(), 100));
        
        gdse.addObjective(new AvgResponseTimeHardObjective()
                .withComparator(Comparators.LOWER_IS_BETTER)
                .withLevel(2));
        gdse.addObjective(new MinResourceUsageSoftObjective()
                .withComparator(Comparators.HIGHER_IS_BETTER)
                .withLevel(2));
        
        gdse.addObjective(new TrajectoryCostSoftObjective()
                .withActivationCost(createResourceRule, new BpmnExamples.CostOfCreateResource())
                .withRuleCost(makeSequentialRule, 1)
                .withRuleCost(makeParallelRule, 1)
                .withComparator(Comparators.LOWER_IS_BETTER)
                .withLevel(2));
        
        return gdse;
    }

    @Override
    public void registerXMISerailizer() {
    }

    @Override
    public List<String> getCustomResultColumns() {
        return Arrays.asList(CONST_FULFILLMENT);
    }

    private int getNumOfTasksBasedOnProblem(String modelPath) {
        if (modelPath.contains("webshop")) {
            return 5;
        } else if (modelPath.contains("invoice")) {
            return 8;
        } else if (modelPath.contains("book")) {
            return 8;
        } else {
            return 100;
        }
    }
    
    @Override
    public void addResults(Row configRow, Row resultsRow) {
        double softConstraint = resultsRow.getValueAsDouble("AvgSoftConstraints");
        int numOfTasks = getNumOfTasksBasedOnProblem(modelPath);
        
        resultsRow.add(CONST_FULFILLMENT, 100 - (softConstraint/(numOfTasks*CONSTRAINT_WEIGHT)*100));
    }

    @Override
    public GeneticDebugger getGeneticDebugger(GlobalContext gc) {
        return new GeneticDebugger(true, gc) {
            @Override
            public List<String> getCustomColumns() {
                return Arrays.asList(CONST_FULFILLMENT);
            }
            @Override
            public void appendCustomResults(StringBuilder sb, InstanceData instanceData) {
                int numOfTasks = getNumOfTasksBasedOnProblem(modelPath);
                sb.append(100 - ((instanceData.objectives.get("SoftConstraints")-100*instanceData.violations.get("UnrequiredResources"))/(numOfTasks*CONSTRAINT_WEIGHT)*100));
            }
        };
    }

}
