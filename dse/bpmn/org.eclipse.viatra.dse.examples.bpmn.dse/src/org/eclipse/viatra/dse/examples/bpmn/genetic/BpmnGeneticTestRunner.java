package org.eclipse.viatra.dse.examples.bpmn.genetic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.api.PatternWithCardinality;
import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.AbsenceOfResourceInstancesQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.EnoughResourceInstancesQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.EveryTaskHasVariantQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.UnassignedTaskQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.UnrequiredResourceInstanceQuerySpecification;
import org.eclipse.viatra.dse.examples.bpmn.rules.AssignVariantToTaskRule;
import org.eclipse.viatra.dse.examples.bpmn.rules.CreateResourceRule;
import org.eclipse.viatra.dse.examples.bpmn.rules.MakeParallelRule;
import org.eclipse.viatra.dse.examples.bpmn.rules.MakeSequentialRule;
import org.eclipse.viatra.dse.examples.bpmn.serializer.BpmnSerializerFactory;
import org.eclipse.viatra.dse.examples.bpmn.simulator.Simulator;
import org.eclipse.viatra.dse.examples.bpmn.simulator.Simulator.ResourceInstanceData;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN;
import org.eclipse.viatra.dse.genetic.api.GeneticDesignSpaceExplorer;
import org.eclipse.viatra.dse.genetic.core.InstanceData;
import org.eclipse.viatra.dse.genetic.core.SoftConstraint;
import org.eclipse.viatra.dse.genetic.debug.GeneticDebugger;
import org.eclipse.viatra.dse.genetic.debug.GeneticTestRunner;
import org.eclipse.viatra.dse.genetic.debug.Row;
import org.eclipse.viatra.dse.genetic.interfaces.ICalculateModelObjectives;
import org.eclipse.viatra.dse.genetic.selectors.NonDominatedAndCrowdingDistanceSelector;

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
        
        
        gdse.setStateCoderFactory(new BpmnSerializerFactory());
        
        gdse.addTransformationRule(AssignVariantToTaskRule.createRule(), 3);
        gdse.addTransformationRule(CreateResourceRule.createRule(), 2);
        gdse.addTransformationRule(MakeParallelRule.createRule(), 1);
        gdse.addTransformationRule(MakeSequentialRule.createRule(), 1);

        gdse.setSelector(new NonDominatedAndCrowdingDistanceSelector());

        gdse.addSoftConstraint(new SoftConstraint("LackOfResourceInstances", AbsenceOfResourceInstancesQuerySpecification.instance(), 1));
        gdse.addSoftConstraint(new SoftConstraint("UnassignedTask", UnassignedTaskQuerySpecification.instance(), 10));
        gdse.addSoftConstraint(new SoftConstraint("UnrequiredResources", UnrequiredResourceInstanceQuerySpecification.instance(), 100));
        
        gdse.setModelObjectiveCalculator(new ICalculateModelObjectives() {
            
            @Override
            public Map<String, Double> calculate(ThreadContext context) {
                
                HashMap<String, Double> result = new HashMap<String, Double>();
                
                SimplifiedBPMN root = (SimplifiedBPMN) context.getModelRoot();
                
                Simulator simulator = new Simulator(root, getNumberOfTokens(), getRateOfTokens());
                if (simulator.canSimulate()) {
                    simulator.simulate();
                    int sumResponseTimes = 0;
                    for (Simulator.Token token : simulator.getTokens()) {
                        sumResponseTimes += token.endTime - token.startTime;
                    }
                    result.put(AVG_RESPONSE_TIME, (double) (sumResponseTimes / simulator.getTokens().size()));
                    HashMap<ResourceTypeVariant, Integer> sumBusyTime = new HashMap<ResourceTypeVariant,Integer>();
                    for (ResourceInstanceData resource : simulator.getResourceDatas().values()) {
                        ResourceTypeVariant rtv = resource.resource.getResourceTypeVariant();
                        Integer sum = sumBusyTime.get(rtv);
                        if (sum == null) {
                            sum = new Integer(0);
                        }
                        sumBusyTime.put(rtv, sum+resource.timeUsed);
                    }
                    double minUtilization = Double.MAX_VALUE;
                    for (ResourceTypeVariant key : sumBusyTime.keySet()) {
                        double utilization = sumBusyTime.get(key).doubleValue() / (simulator.getElapsedTime() * key.getInstances().size());
                        if (utilization < minUtilization) {
                            minUtilization = utilization;
                        }
                    }
                    result.put(MIN_RESOURCE_UTILIZATION, minUtilization);
                }
                else {
                    result.put(AVG_RESPONSE_TIME, Double.POSITIVE_INFINITY);
                    result.put(MIN_RESOURCE_UTILIZATION, 0d);
                }
                
                return result;
            }
        });
        
        gdse.addObjectiveComparator(AVG_RESPONSE_TIME, new Comparator<InstanceData>() {
            @Override
            public int compare(InstanceData o1, InstanceData o2) {
                return -o1.getFitnessValue(AVG_RESPONSE_TIME).compareTo(o2.getFitnessValue(AVG_RESPONSE_TIME));
            }
        });

        gdse.addObjectiveComparator(COST, new Comparator<InstanceData>() {
            @Override
            public int compare(InstanceData o1, InstanceData o2) {
                return -o1.getFitnessValue(COST).compareTo(o2.getFitnessValue(COST));
            }
        });
        
        gdse.addObjectiveComparator(MIN_RESOURCE_UTILIZATION, new Comparator<InstanceData>() {
            @Override
            public int compare(InstanceData o1, InstanceData o2) {
                return o1.getFitnessValue(MIN_RESOURCE_UTILIZATION).compareTo(o2.getFitnessValue(MIN_RESOURCE_UTILIZATION));
            }
        });
        
        return gdse;
    }

    @Override
    public void registerXMISerailizer() {
        // TODO Auto-generated method stub
        
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
        double softConstraint = resultsRow.getValueAsDouble(GeneticTestRunner.SOFT_CONSTRAINT);
        int numOfTasks = getNumOfTasksBasedOnProblem(modelPath);
        
        resultsRow.add(CONST_FULFILLMENT, 100 - (softConstraint/(numOfTasks*CONSTRAINT_WEIGHT)*100));
    }

    @Override
    public GeneticDebugger getGeneticDebugger() {
        return new GeneticDebugger(true) {
            @Override
            public List<String> getCustomColumns() {
                return Arrays.asList(CONST_FULFILLMENT);
            }
            @Override
            public void appendCustomResults(StringBuilder sb, InstanceData instanceData) {
                int numOfTasks = getNumOfTasksBasedOnProblem(modelPath);
                sb.append(100 - (instanceData.sumOfConstraintViolationMeauserement/(numOfTasks*CONSTRAINT_WEIGHT)*100));
            }
        };
    }

}
