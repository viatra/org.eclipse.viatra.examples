/*******************************************************************************
 * Copyright (c) 2010-2015, Andras Szabolcs Nagy, Abel Hegedus, Akos Horvath, Zoltan Ujhelyi and Daniel Varro
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.dse.examples.bpmn.simulator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.BaseElement;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.EndEvent;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.Gateway;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ParallelGateway;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceInstance;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceType;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SequenceFlow;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.Task;

public class Simulator {

    public static class Token {
        public int startTime = 0;
        public int endTime = 0;
        public Task task;
    }
    
    public static class MultiToken extends Token {
        public Token originalToken;
    }
    
    public static class ResourceInstanceData {
        public int timeUsed = 0;
        public int timeRemaining = 0;
        public Token tokenProcessing;
        public ResourceInstance resource;
        public ResourceInstanceData(ResourceInstance resource) {
            this.resource = resource;
        }
    }

    // Configuration
    private SimplifiedBPMN model;
    private int numberOfTokens;
    private int timeBetweenTokens;

    // Inner use
    private int currentTime = 0;
    private int timeToNextToken;
    private Random random = new Random();
    private Map<ParallelGateway, Map<Token, Integer>> arrivedTokens = new HashMap<ParallelGateway, Map<Token, Integer>>();
    private int tokensFinished = 0;
    private Logger logger = Logger.getLogger(getClass().getSimpleName());
    private Map<ResourceInstance,ResourceInstanceData> resourceDatas = new HashMap<ResourceInstance, Simulator.ResourceInstanceData>();
    private Map<ResourceTypeVariant,List<Token>> tokensWaiting = new HashMap<ResourceTypeVariant, List<Token>>();
    private List<Token> tokens = new ArrayList<Simulator.Token>();
    

    public Simulator(SimplifiedBPMN model, int numberOfTokens, int timeBetweenTokens) {
        this.model = model;
        this.numberOfTokens = numberOfTokens;
        this.timeBetweenTokens = timeBetweenTokens;
        timeToNextToken = timeBetweenTokens;

        for (ResourceType resourceType : model.getResourceTypes()) {
            for (ResourceTypeVariant rtv : resourceType.getVariants()) {
                tokensWaiting.put(rtv, new ArrayList<Simulator.Token>());
                for (ResourceInstance resource : rtv.getInstances()) {
                    resourceDatas.put(resource, new ResourceInstanceData(resource));
                }
            }
        }
        
        for (ParallelGateway pGateways : model.getParallelGateways()) {
            arrivedTokens.put(pGateways, new HashMap<Token, Integer>());
        }

    }

    public boolean canSimulate() {
        for (Task task : model.getTasks()) {
            ResourceTypeVariant variant = task.getVariant();
            if (variant == null || variant.getInstances().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public void simulate() {

        newToken(model, currentTime);

        startProcessingTokens();

        boolean simulationEnded = false;

        while (!simulationEnded) {
            logger.debug("------- Next step -------");
            simulateStep();
            simulationEnded = checkIfSimulationEnded();
        }
        logger.debug("------- Ended -------");
    }

    private boolean checkIfSimulationEnded() {
        if (tokens.size() == numberOfTokens && tokensFinished == tokens.size()) {
            return true;
        }
        return false;
    }

    private void simulateStep() {
        ResourceInstanceData resource = getFastestResource();

        int timeInterval;
        boolean newToken = false;

        if (tokens.size() < numberOfTokens && (
                (resource != null && timeToNextToken < resource.timeRemaining) ||
                resource == null)) {
            timeInterval = timeToNextToken;
            timeToNextToken = this.timeBetweenTokens;
            newToken = true;
        }
        else if (resource == null) {
            throw new RuntimeException("The simulation should have stopped by now.");
        } else {
            timeInterval = resource.timeRemaining;
            timeToNextToken -= timeInterval;
        }
        
        currentTime += timeInterval;

        for (ResourceInstanceData resourceData : resourceDatas.values()) {
            if (resourceData.tokenProcessing != null) {
                resourceData.timeRemaining -= timeInterval;
                resourceData.timeUsed += timeInterval;
                if (resourceData.timeRemaining == 0) {
                    Token token = resourceData.tokenProcessing;
                    logger.debug(token.task.getName() + " finished processing a token.");
                    
                    resourceData.tokenProcessing = null;
                    chooseTokenFlow(token.task, token);
                }
            }
        }

        if (newToken) {
            newToken(model, currentTime);
        }

        startProcessingTokens();

    }

    private void startProcessingTokens() {
        for (ResourceType resourceType : model.getResourceTypes()) {
            for (ResourceTypeVariant rtv : resourceType.getVariants()) {
                List<Token> t = tokensWaiting.get(rtv);
                if (!t.isEmpty()) {
                    for (ResourceInstance resource : rtv.getInstances()) {
                        ResourceInstanceData resourceData = resourceDatas.get(resource);
                        if (resourceData.tokenProcessing == null && !t.isEmpty()) {
                            Token token = t.remove(0);
                            resourceData.tokenProcessing = token;
                            resourceData.timeRemaining = (int) Math.round(token.task.getExecutionTime() * rtv.getEfficiency());
                            logger.debug(token.task.getName() + " started processing a token.");
                        }
                    }
                }
            }
        }

    }

    private BaseElement nextElement;

    private void chooseTokenFlow(BaseElement element, Token token) {
        chooseTokenFlow(element, token, false);
    }
    
    private void chooseTokenFlow(BaseElement element, Token token, boolean processElementItself) {

        if (processElementItself) {
            nextElement = element;
        }
        else {
            if (element.getOutFlows().size() > 1) {
                chooseFlowBasedOnPropablity(element, new IChoosenFlow() {
                    @Override
                    public void process(SequenceFlow flow) {
                        nextElement = flow.getTarget();
                    }
                });
            } else {
                nextElement = element.getOutFlows().get(0).getTarget();
            }
        }
        
        logger.debug("Chosen flow: " + nextElement.getName());

        if (nextElement instanceof Task) {
            Task targetTask = (Task) nextElement;
            token.task = targetTask;
            ResourceTypeVariant resourceTypeVariant = targetTask.getVariant();
            tokensWaiting.get(resourceTypeVariant).add(token);
        } else if (nextElement instanceof Gateway) {
            chooseTokenFlow(nextElement, token);
        } else if (nextElement instanceof ParallelGateway) {
            ParallelGateway parallelGateway = (ParallelGateway) nextElement;
            if (parallelGateway.isDiverging()) {
                for (SequenceFlow flow : parallelGateway.getOutFlows()) {
                    MultiToken subToken = new MultiToken();
                    subToken.originalToken = token;
                    chooseTokenFlow(flow.getTarget(), subToken, true);
                }
            } else {
                Map<Token, Integer> arrivedTokensMap = arrivedTokens.get(parallelGateway);
                Token originalToken = ((MultiToken)token).originalToken;
                Integer arrivedTokensNumber = arrivedTokensMap.get(originalToken);
                if (arrivedTokensNumber == null) {
                    arrivedTokensNumber = Integer.valueOf(0);
                }
                if (arrivedTokensNumber == parallelGateway.getInFlows().size() - 1) {
                    chooseTokenFlow(parallelGateway, originalToken);
                } else {
                    arrivedTokensMap.put(originalToken, arrivedTokensNumber + 1);
                }
            }
        } else if (nextElement instanceof EndEvent) {
            token.endTime = currentTime;
            tokensFinished++;
            logger.debug(tokensFinished + ". token finished at " + currentTime + " in "
                    + (token.endTime - token.startTime));
        }
    }

    private void chooseFlowBasedOnPropablity(BaseElement baseElement, IChoosenFlow choosenFlowImpl) {
        int sum = 0;
        for (SequenceFlow flow : baseElement.getOutFlows()) {
            sum += flow.getPropability();
        }
        int rnd = random.nextInt(sum);
        sum = 0;
        for (SequenceFlow flow : baseElement.getOutFlows()) {
            sum += flow.getPropability();
            if (rnd < sum) {
                choosenFlowImpl.process(flow);
                return;
            }
        }
    }

    private ResourceInstanceData getFastestResource() {

        int minTimeRemaining = Integer.MAX_VALUE;
        ResourceInstanceData result = null;
        for (ResourceInstanceData resourceData : resourceDatas.values()) {
            if (resourceData.tokenProcessing != null && resourceData.timeRemaining < minTimeRemaining) {
                result = resourceData;
                minTimeRemaining = result.timeRemaining;
            }
        }

        return result;
    }

    private void newToken(SimplifiedBPMN model, int currentTime) {
        Token token = new Token();
        token.startTime = currentTime;
        tokens.add(token);
        logger.debug("New token " + tokens.size());
        BaseElement firstStartEvent = model.getStartEvents().get(0);
        chooseTokenFlow(firstStartEvent, token);
    }

    public int getElapsedTime() {
        return currentTime;
    }
    
    public List<Token> getTokens() {
        return tokens;
    }

    public Map<ResourceInstance, ResourceInstanceData> getResourceDatas() {
        return resourceDatas;
    }
}
