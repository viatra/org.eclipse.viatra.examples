/*******************************************************************************
 * Copyright (c) 2010-2015, Andras Szabolcs Nagy and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Andras Szabolcs Nagy - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.dse.examples.cps.problems;

import org.eclipse.emf.common.util.EList;
import org.eclipse.viatra.dse.examples.cps.ApplicationType;
import org.eclipse.viatra.dse.examples.cps.CpsFactory;
import org.eclipse.viatra.dse.examples.cps.CyberPhysicalSystem;
import org.eclipse.viatra.dse.examples.cps.HostInstance;
import org.eclipse.viatra.dse.examples.cps.HostType;
import org.eclipse.viatra.dse.examples.cps.Request;
import org.eclipse.viatra.dse.examples.cps.Requirement;
import org.eclipse.viatra.dse.examples.cps.ResourceRequirement;

public class RoomServiceCpsDomain {

	public CpsFactory factory;
	public ApplicationType smokeDetect;
	public ApplicationType measureTemperature;
	public ApplicationType setTemperature;
	public ApplicationType heatMap;
	public ApplicationType motionCheck;
	public ApplicationType videoRecord;
	public HostType smokeSensor;
	public HostType temperatureSensor;
	public HostType infraCam;
	public HostType computeServer;
	public HostType videoCam;

	public RoomServiceCpsDomain() {

		factory = CpsFactory.eINSTANCE;

		// ***** Application Types ******
		smokeDetect = factory.createApplicationType();
		smokeDetect.setId("SD");

		measureTemperature = factory.createApplicationType();
		measureTemperature.setId("MT");

		setTemperature = factory.createApplicationType();
		setTemperature.setId("ST");

		heatMap = factory.createApplicationType();
		heatMap.setId("HM");

		motionCheck = factory.createApplicationType();
		motionCheck.setId("MC");

		videoRecord = factory.createApplicationType();
		videoRecord.setId("VR");

		// ***** Host Types ******

		smokeSensor = factory.createHostType();
		smokeSensor.setId("SS");
		smokeSensor.setDefaultCpu(0);
		smokeSensor.setDefaultHdd(1);
		smokeSensor.setDefaultMemory(1);

		temperatureSensor = factory.createHostType();
		temperatureSensor.setId("TS");
		temperatureSensor.setDefaultCpu(0);
		temperatureSensor.setDefaultHdd(1);
		temperatureSensor.setDefaultMemory(1);

		infraCam = factory.createHostType();
		infraCam.setId("IC");
		infraCam.setDefaultCpu(0);
		infraCam.setDefaultHdd(1);
		infraCam.setDefaultMemory(1);

		computeServer = factory.createHostType();
		computeServer.setId("CS");
		computeServer.setDefaultCpu(0);
		computeServer.setDefaultHdd(128);
		computeServer.setDefaultMemory(32);

		videoCam = factory.createHostType();
		videoCam.setId("VC");
		videoCam.setDefaultCpu(0);
		videoCam.setDefaultHdd(1);
		videoCam.setDefaultMemory(1);

		// ***** Resource Requirements ****** //

		addResourceRequirement(smokeDetect, smokeSensor, 0, 1, 1);

		addResourceRequirement(measureTemperature, temperatureSensor, 0, 1, 1);

		addResourceRequirement(heatMap, infraCam, 0, 1, 1);
		addResourceRequirement(heatMap, computeServer, 0, 5, 3);

		addResourceRequirement(setTemperature, computeServer, 0, 2, 2);

		addResourceRequirement(motionCheck, computeServer, 0, 8, 6);

		addResourceRequirement(videoRecord, computeServer, 0, 3, 32);
		addResourceRequirement(videoRecord, videoCam, 0, 1, 1);
	}

	public void addResourceRequirement(ApplicationType appType, HostType hostType, int cpu, int memory, int hdd) {
		ResourceRequirement requirement = factory.createResourceRequirement();
		requirement.setHostType(hostType);
		requirement.setRequiredCpu(cpu);
		requirement.setRequiredHdd(hdd);
		requirement.setRequiredMemory(memory);
		appType.getRequirements().add(requirement);
	}

	public void addRequirement(Request request, String id, ApplicationType appType, int count) {
	    for (Requirement requirement : request.getRequirements()) {
            if (requirement.getId().equals(id)) {
                requirement.setCount(requirement.getCount()+count);
                return;
            }
        }
		Requirement req = factory.createRequirement();
		req.setCount(count);
		req.setId(id);
		req.setType(appType);
		request.getRequirements().add(req);
	}

	public void addFireAlarm(Request request) {
		addRequirement(request, request.getId() + "SD", smokeDetect, 1);
		addRequirement(request, request.getId() + "MT", measureTemperature, 1);
	}

	public void addAirCond(Request request) {
		addRequirement(request, request.getId() + "ST", setTemperature, 1);
		addRequirement(request, request.getId() + "MT", measureTemperature, 1);
	}

	public void addSecurity(Request request) {
		addRequirement(request, request.getId() + "MC", motionCheck, 1);
		addRequirement(request, request.getId() + "VC", videoRecord, 1);
	}

	public void addHeatMap(Request request) {
		addRequirement(request, request.getId() + "HM", heatMap, 1);
	}

	public Request createBasicPackageRequest(String id) {
		Request request = factory.createRequest();
		request.setId(id);
		addFireAlarm(request);
		return request;
	}

	public Request createComfortPackageRequest(String id) {
		Request request = factory.createRequest();
		request.setId(id);
		addFireAlarm(request);
		addAirCond(request);
		return request;
	}

	public Request createSecurePackageRequest(String id) {
		Request request = factory.createRequest();
		request.setId(id);
		addFireAlarm(request);
		addAirCond(request);
		addSecurity(request);
		return request;
	}

	public Request createMaxPackageRequest(String id) {
		Request request = factory.createRequest();
		request.setId(id);
		addFireAlarm(request);
		addAirCond(request);
		addSecurity(request);
		addHeatMap(request);
		return request;
	}

	public HostInstance createHostInstance(HostType type, String id, int cpu, int memory, int hdd) {
		HostInstance instance = factory.createHostInstance();
		instance.setAvailableCpu(cpu);
		instance.setAvailableHdd(hdd);
		instance.setAvailableMemory(memory);
		instance.setId(id);
		instance.setTotalCpu(cpu);
		instance.setTotalHdd(hdd);
		instance.setTotalMemory(memory);
		instance.setType(type);
		return instance;
	}

	public CyberPhysicalSystem createRootWithTypes() {
		CyberPhysicalSystem cps = factory.createCyberPhysicalSystem();
		EList<ApplicationType> applicationTypes = cps.getApplicationTypes();
		applicationTypes.add(heatMap);
		applicationTypes.add(measureTemperature);
		applicationTypes.add(motionCheck);
		applicationTypes.add(setTemperature);
		applicationTypes.add(smokeDetect);
		applicationTypes.add(videoRecord);
		EList<HostType> hostTypes = cps.getHostTypes();
		hostTypes.add(computeServer);
		hostTypes.add(smokeSensor);
		hostTypes.add(temperatureSensor);
		hostTypes.add(videoCam);
		hostTypes.add(infraCam);
		return cps;
	}

}
