package org.eclipse.viatra.dse.examples.bpmn.genetic;

import java.util.Arrays;
import java.util.List;

import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.api.DSETransformationRule;
import org.eclipse.viatra.dse.api.DesignSpaceExplorer;
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
import org.eclipse.viatra.dse.genetic.api.GeneticStrategyBuilder;
import org.eclipse.viatra.dse.genetic.core.GeneticSoftConstraintHardObjective;
import org.eclipse.viatra.dse.genetic.core.InstanceData;
import org.eclipse.viatra.dse.genetic.debug.GeneticDebugger;
import org.eclipse.viatra.dse.genetic.debug.GeneticTestRunner;
import org.eclipse.viatra.dse.genetic.debug.Row;
import org.eclipse.viatra.dse.objectives.Comparators;
import org.eclipse.viatra.dse.objectives.impl.TrajectoryCostSoftObjective;

public class BpmnGeneticTestRunner extends GeneticTestRunner {

    public static final int CONSTRAINT_WEIGHT = 10;
    public static final String MIN_RESOURCE_UTILIZATION = "MinResourceUtilization";
    public static final String AVG_RESPONSE_TIME = "AvgResponseTime";
    public static final String COST = "Cost";
    public static final String CONST_FULFILLMENT = "ConstFulfillment";
    private String modelPath;

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
    public void configDSE(Row configRow, DesignSpaceExplorer dse, GeneticStrategyBuilder builder) throws IncQueryException {
        modelPath = configRow.getValueAsString(GeneticTestRunner.MODEL_PATH);

        dse.setStateCoderFactory(new BpmnStateCoderFactory());
        
        DSETransformationRule<?, ?> assignTaskRule = AssignVariantToTaskRule.createRule();
        DSETransformationRule<?, ?> createResourceRule = CreateResourceRule.createRule();
        DSETransformationRule<?, ?> makeParallelRule = MakeParallelRule.createRule();
        DSETransformationRule<?, ?> makeSequentialRule = MakeSequentialRule.createRule();
        builder.setRulePriority(assignTaskRule, 3);
        builder.setRulePriority(createResourceRule, 2);
        builder.setRulePriority(makeParallelRule, 1);
        builder.setRulePriority(makeSequentialRule, 1);
        dse.addTransformationRule(assignTaskRule);
        dse.addTransformationRule(createResourceRule);
        dse.addTransformationRule(makeParallelRule);
        dse.addTransformationRule(makeSequentialRule);

        dse.addObjective(new GeneticSoftConstraintHardObjective()
                .withConstraint("LackOfResourceInstances", AbsenceOfResourceInstancesQuerySpecification.instance(), 1)
                .withConstraint("UnassignedTask", UnassignedTaskQuerySpecification.instance(), 10)
                .withConstraint("UnrequiredResources", UnrequiredResourceInstanceQuerySpecification.instance(), 100));
        
        dse.addObjective(new AvgResponseTimeHardObjective()
                .withComparator(Comparators.LOWER_IS_BETTER)
                .withLevel(2));
        dse.addObjective(new MinResourceUsageSoftObjective()
                .withComparator(Comparators.HIGHER_IS_BETTER)
                .withLevel(2));
        
        dse.addObjective(new TrajectoryCostSoftObjective()
                .withActivationCost(createResourceRule, new BpmnExamples.CostOfCreateResource())
                .withRuleCost(makeSequentialRule, 1)
                .withRuleCost(makeParallelRule, 1)
                .withComparator(Comparators.LOWER_IS_BETTER)
                .withLevel(2));
        
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
