/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Marton Bur, Zoltan Ujhelyi, Robert Doczi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2t.monitor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import org.eclipse.viatra.examples.cps.deployment.BehaviorState;
import org.eclipse.viatra.examples.cps.deployment.BehaviorTransition;
import org.eclipse.viatra.examples.cps.deployment.Deployment;
import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication;
import org.eclipse.viatra.examples.cps.deployment.DeploymentElement;
import org.eclipse.viatra.examples.cps.deployment.DeploymentHost;
import org.eclipse.viatra.examples.cps.xform.m2t.monitor.ApplicationBehaviorCurrentStateChange;
import org.eclipse.viatra.examples.cps.xform.m2t.monitor.BehaviorChange;
import org.eclipse.viatra.examples.cps.xform.m2t.monitor.DeploymentHostIpChange;
import org.eclipse.viatra.examples.cps.xform.m2t.monitor.DeploymentHostsChange;
import org.eclipse.viatra.examples.cps.xform.m2t.monitor.HostApplicationsChange;
import org.eclipse.viatra.examples.cps.xform.m2t.monitor.HostIpChange;
import org.eclipse.viatra.examples.cps.xform.m2t.monitor.TransitionChange;
import org.eclipse.viatra.examples.cps.xform.m2t.monitor.TriggerChange;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.ViatraQueryMatcher;
import org.eclipse.viatra.transformation.evm.api.ExecutionSchema;
import org.eclipse.viatra.transformation.evm.api.Job;
import org.eclipse.viatra.transformation.evm.api.RuleSpecification;
import org.eclipse.viatra.transformation.evm.specific.ExecutionSchemas;
import org.eclipse.viatra.transformation.evm.specific.Jobs;
import org.eclipse.viatra.transformation.evm.specific.Lifecycles;
import org.eclipse.viatra.transformation.evm.specific.Rules;
import org.eclipse.viatra.transformation.evm.specific.Schedulers;
import org.eclipse.viatra.transformation.evm.specific.crud.CRUDActivationStateEnum;
import org.eclipse.viatra.transformation.evm.specific.job.EnableJob;
import org.eclipse.viatra.transformation.evm.specific.scheduler.UpdateCompleteBasedScheduler.UpdateCompleteBasedSchedulerFactory;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

@SuppressWarnings("unchecked")
public class DeploymentChangeMonitor extends AbstractDeploymentChangeMonitor {

	private Set<DeploymentElement> appearBetweenCheckpoints;
	private Set<DeploymentElement> updateBetweenCheckpoints;
	private Set<DeploymentElement> disappearBetweenCheckpoints;
	private Set<DeploymentElement> appearAccumulator;
	private Set<DeploymentElement> updateAccumulator;
	private Set<DeploymentElement> disappearAccumulator;
	private boolean deploymentBetweenCheckpointsChanged;
	private boolean deploymentChanged;
	private ExecutionSchema executionSchema;
	private HashMap<DeploymentApplication, String> appsToIDs;
	private HashMap<DeploymentHost, String> hostsToIPs;
	
	public DeploymentChangeMonitor(Deployment deployment, ViatraQueryEngine engine) {
		super(deployment, engine);
		this.appearBetweenCheckpoints = Sets.newHashSet();
		this.updateBetweenCheckpoints = Sets.newHashSet();
		this.disappearBetweenCheckpoints = Sets.newHashSet();
		this.appearAccumulator = Sets.newHashSet();
		this.updateAccumulator = Sets.newHashSet();
		this.disappearAccumulator = Sets.newHashSet();
		deploymentBetweenCheckpointsChanged = false;
		deploymentChanged = false;


		UpdateCompleteBasedSchedulerFactory schedulerFactory = Schedulers
				.getQueryEngineSchedulerFactory(engine);
		executionSchema = ExecutionSchemas
				.createViatraQueryExecutionSchema(engine, schedulerFactory);

		hostsToIPs = Maps.newHashMap();
		appsToIDs = Maps.newHashMap();
		for (DeploymentHost deploymentHost : deployment.getHosts()) {
			hostsToIPs.put(deploymentHost, deploymentHost.getIp());
			for (DeploymentApplication deploymentApplication : deploymentHost.getApplications()) {
				appsToIDs.put(deploymentApplication, deploymentApplication.getId());
			}
		}
		executionSchema.getContext().put(ChangeMonitorJob.HOSTS,hostsToIPs);
		executionSchema.getContext().put(ChangeMonitorJob.APPLICATIONS,Maps.newHashMap());
	}
	
	@Override 
	public DeploymentChangeDelta createCheckpoint() {
		// Save current values
	    appearBetweenCheckpoints = appearAccumulator;
		updateBetweenCheckpoints = updateAccumulator;
		disappearBetweenCheckpoints = disappearAccumulator;
		deploymentBetweenCheckpointsChanged = deploymentChanged;

		// Reset current values
		appearAccumulator = Sets.newHashSet();
		updateAccumulator = Sets.newHashSet();
		disappearAccumulator = Sets.newHashSet();
		deploymentChanged = false;
		
		Map<DeploymentElement, String> elementsUpdatedOrDeleted = (Map<DeploymentElement, String>) executionSchema.getContext().get(ChangeMonitorJob.OUTDATED_ELEMENTS);
		if(elementsUpdatedOrDeleted == null){
		    elementsUpdatedOrDeleted = Maps.newHashMap();
		}
		for (DeploymentElement deploymentElement : elementsUpdatedOrDeleted.keySet()) {
			// Refresh the list of host IP addresses and app identifiers
			if(deploymentElement instanceof DeploymentHost){
				hostsToIPs.put((DeploymentHost) deploymentElement, ((DeploymentHost) deploymentElement).getIp());
			}
			else if(deploymentElement instanceof DeploymentApplication){
				appsToIDs.put((DeploymentApplication) deploymentElement, ((DeploymentApplication) deploymentElement).getId());
			}
		}
		executionSchema.getContext().put(ChangeMonitorJob.OUTDATED_ELEMENTS,Maps.newHashMap());
		
		return new DeploymentChangeDelta(
				appearBetweenCheckpoints,
				updateBetweenCheckpoints, 
				disappearBetweenCheckpoints, 
				elementsUpdatedOrDeleted,
				deploymentBetweenCheckpointsChanged
				);
	}

	@Override
	public DeploymentChangeDelta getDeltaSinceLastCheckpoint() {
		return new DeploymentChangeDelta(
				appearAccumulator, 
				updateAccumulator,
				disappearAccumulator, 
				(Map<DeploymentElement, String>) executionSchema.getContext().get(ChangeMonitorJob.OUTDATED_ELEMENTS),
				deploymentChanged
				);
	}

	@Override
	public void startMonitoring() {
	    ModelChangeListenerQueries.instance().prepare(engine);
		Set<Job<?>> allJobs = Sets.newHashSet();

		Set<Job<IPatternMatch>> deploymentJobs = createDeploymentJobs();
		allJobs.addAll(deploymentJobs);

		IQuerySpecification<? extends ViatraQueryMatcher<IPatternMatch>> deploymentHostChangeQuerySpec = (IQuerySpecification<? extends ViatraQueryMatcher<IPatternMatch>>) DeploymentHostsChange
				.instance();
		IQuerySpecification<? extends ViatraQueryMatcher<IPatternMatch>> deploymentHostIpChangeQuerySpec = (IQuerySpecification<? extends ViatraQueryMatcher<IPatternMatch>>) DeploymentHostIpChange
				.instance();

		registerJobsForPattern(executionSchema, deploymentJobs,
				deploymentHostChangeQuerySpec);
		registerJobsForPattern(executionSchema, deploymentJobs,
				deploymentHostIpChangeQuerySpec);

		Map<IQuerySpecification<? extends ViatraQueryMatcher<IPatternMatch>>, Set<Job<IPatternMatch>>> querySpecificationsToJobs = getDeploymentElementChangeQuerySpecifications();

		for (IQuerySpecification<? extends ViatraQueryMatcher<IPatternMatch>> querySpec : querySpecificationsToJobs
				.keySet()) {
			registerJobsForPattern(executionSchema,
					querySpecificationsToJobs.get(querySpec), querySpec);
		}
		Collection<Set<Job<IPatternMatch>>> registeredJobs = querySpecificationsToJobs
				.values();
		for (Set<Job<IPatternMatch>> deploymentElementJobs : registeredJobs) {
			allJobs.addAll(deploymentElementJobs);
		}

		executionSchema.startUnscheduledExecution();

		// Enable the jobs to listen to changes
		for (Job<?> job : allJobs) {
			EnableJob<?> enableJob = (EnableJob<?>) job;
			enableJob.setEnabled(true);
		}

	}

	private Set<Job<IPatternMatch>> createDeploymentJobs() {

		Set<Job<IPatternMatch>> jobs = Sets.newHashSet();

		Consumer<IPatternMatch> matchProcessor = match -> deploymentChanged = true;

		Job<IPatternMatch> appear = Jobs.newStatelessJob(
				CRUDActivationStateEnum.CREATED, matchProcessor);
		Job<IPatternMatch> disappear = Jobs.newStatelessJob(
				CRUDActivationStateEnum.DELETED, matchProcessor);
		Job<IPatternMatch> update = Jobs.newStatelessJob(
				CRUDActivationStateEnum.UPDATED,matchProcessor);
		
		jobs.add(Jobs.newEnableJob(appear));
		jobs.add(Jobs.newEnableJob(disappear));
		jobs.add(Jobs.newEnableJob(update));

		return jobs;
	}

	private void registerJobsForPattern(
			ExecutionSchema executionSchema,
			Set<Job<IPatternMatch>> deploymentElementJobs,
			IQuerySpecification<? extends ViatraQueryMatcher<IPatternMatch>> changeQuerySpecification) {
		RuleSpecification<IPatternMatch> applicationRules = Rules
				.newMatcherRuleSpecification(changeQuerySpecification,
						Lifecycles.getDefault(true, true),
						deploymentElementJobs);
		executionSchema.addRule(applicationRules);
	}

	private Map<IQuerySpecification<? extends ViatraQueryMatcher<IPatternMatch>>, Set<Job<IPatternMatch>>> getDeploymentElementChangeQuerySpecifications() {
		Map<IQuerySpecification<? extends ViatraQueryMatcher<IPatternMatch>>, Set<Job<IPatternMatch>>> querySpecifications = Maps
				.newHashMap();
		querySpecifications
				.put((IQuerySpecification<? extends ViatraQueryMatcher<IPatternMatch>>) HostApplicationsChange
						.instance(), hostChangeJobs());
		querySpecifications
				.put((IQuerySpecification<? extends ViatraQueryMatcher<IPatternMatch>>) HostIpChange
						.instance(), hostChangeJobs());
		querySpecifications
				.put((IQuerySpecification<? extends ViatraQueryMatcher<IPatternMatch>>) ApplicationIdChange
						.instance(), applicationChangeJobs());
		querySpecifications
				.put((IQuerySpecification<? extends ViatraQueryMatcher<IPatternMatch>>) ApplicationBehaviorCurrentStateChange
						.instance(), applicationChangeJobs());
		querySpecifications
				.put((IQuerySpecification<? extends ViatraQueryMatcher<IPatternMatch>>) BehaviorChange
						.instance(), behaviorChangeJobs());
		querySpecifications
				.put((IQuerySpecification<? extends ViatraQueryMatcher<IPatternMatch>>) TransitionChange
						.instance(), behaviorChangeJobs());
		querySpecifications
				.put((IQuerySpecification<? extends ViatraQueryMatcher<IPatternMatch>>) TriggerChange
						.instance(), behaviorChangeJobs());
		return querySpecifications;
	}

	private Set<Job<IPatternMatch>> hostChangeJobs() {
		Consumer<IPatternMatch> appearProcessor = match -> registerAppear(match);
		Consumer<IPatternMatch> disappearProcessor = match -> {
            	DeploymentHost host = (DeploymentHost) match.get(0);
            	if (host.eContainer() != null) {
            		registerUpdate(match);
            	} else {
            		registerDisappear(match);
            	}
        };
		Consumer<IPatternMatch> updateProcessor = match -> registerUpdate(match);

		return createDeploymentElementJobs(appearProcessor, disappearProcessor,
				updateProcessor);
	}

	/**
	 * @return specific jobs for applicationChanges
	 */
	private Set<Job<IPatternMatch>> applicationChangeJobs() {
		Consumer<IPatternMatch> appearProcessor = match -> registerAppear(match);
		Consumer<IPatternMatch> disappearProcessor = match -> registerDisappear(match);
		Consumer<IPatternMatch> updateProcessor = match -> registerUpdate(match);

		return createDeploymentElementJobs(appearProcessor, disappearProcessor,
				updateProcessor);
	}

	private Set<Job<IPatternMatch>> behaviorChangeJobs() {
		Consumer<IPatternMatch> appearProcessor = match -> registerAppear(match);
		Consumer<IPatternMatch> disappearProcessor = match -> {
            	if (match.get("state") != null) {
            		BehaviorState state = ((BehaviorState) match.get("state"));
            		if (state.eContainer() == null) {
            			registerUpdate(match);
            		}
            	} else if (match.get("transition") != null) {
            		BehaviorTransition transition = ((BehaviorTransition) match
            				.get("transition"));
            		if (transition.eContainer() == null) {
            			registerUpdate(match);
            		}
            	} else {
            		registerDisappear(match);
            	}
        };
		Consumer<IPatternMatch> updateProcessor = match -> registerUpdate(match);

		return createDeploymentElementJobs(appearProcessor, disappearProcessor,
				updateProcessor);
	}

	private void registerUpdate(IPatternMatch match) {
		DeploymentElement deploymentElement = (DeploymentElement) match.get(0);
		if (!appearAccumulator.contains(deploymentElement)) {
			updateAccumulator.add(deploymentElement);
		}
	}

	private void registerAppear(IPatternMatch match) {
		DeploymentElement deploymentElement = (DeploymentElement) match.get(0);

		disappearAccumulator.remove(deploymentElement);
		updateAccumulator.remove(deploymentElement);

		appearAccumulator.add(deploymentElement);
	}

	private void registerDisappear(IPatternMatch match) {
		DeploymentElement deploymentElement = (DeploymentElement) match.get(0);

		appearAccumulator.remove(deploymentElement);
		updateAccumulator.remove(deploymentElement);

		disappearAccumulator.add(deploymentElement);
	}

	private Set<Job<IPatternMatch>> createDeploymentElementJobs(
			Consumer<IPatternMatch> appearProcessor,
			Consumer<IPatternMatch> disappearProcessor,
			Consumer<IPatternMatch> updateProcessor) {
		Set<Job<IPatternMatch>> jobs = Sets.newHashSet();

		Job<IPatternMatch> appear = new ChangeMonitorJob<IPatternMatch>(
				CRUDActivationStateEnum.CREATED, appearProcessor);
		Job<IPatternMatch> disappear = new ChangeMonitorJob<IPatternMatch>(
				CRUDActivationStateEnum.DELETED, disappearProcessor);
		Job<IPatternMatch> update = new ChangeMonitorJob<IPatternMatch>(
				CRUDActivationStateEnum.UPDATED, updateProcessor);

		jobs.add(Jobs.newEnableJob(appear));
		jobs.add(Jobs.newEnableJob(disappear));
		jobs.add(Jobs.newEnableJob(update));

		return jobs;
	}

}
