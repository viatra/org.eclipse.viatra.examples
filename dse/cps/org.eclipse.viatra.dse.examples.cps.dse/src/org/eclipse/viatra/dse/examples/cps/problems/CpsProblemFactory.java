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

import org.eclipse.viatra.examples.dse.cps.CyberPhysicalSystem;
import org.eclipse.viatra.examples.dse.cps.Request;

public class CpsProblemFactory {

	private RoomServiceCpsDomain domain = new RoomServiceCpsDomain();
	
	public CyberPhysicalSystem simple() {

		CyberPhysicalSystem cps = domain.createRootWithTypes();
		
		Request req = domain.factory.createRequest();
		req.setId("simple");
		
		domain.addRequirement(req, "req", domain.motionCheck, 1);
		
		cps.getRequests().add(req);

		return cps;
	}
	
	public CyberPhysicalSystem basicPackage() {

		CyberPhysicalSystem cps = domain.createRootWithTypes();
		
		Request request = domain.createBasicPackageRequest("basic");
		cps.getRequests().add(request);

		return cps;
	}
	
	public CyberPhysicalSystem twoBasicPackage() {

		CyberPhysicalSystem cps = domain.createRootWithTypes();
		
		Request request1 = domain.createBasicPackageRequest("basic1");
		cps.getRequests().add(request1);

		Request request2 = domain.createBasicPackageRequest("basic1");
		cps.getRequests().add(request2);
		
		return cps;
	}
	
	public CyberPhysicalSystem basicAndSecurePackage() {

		CyberPhysicalSystem cps = domain.createRootWithTypes();
		
		Request request1 = domain.createBasicPackageRequest("basic");
		cps.getRequests().add(request1);

		Request request2 = domain.createBasicPackageRequest("secure");
		cps.getRequests().add(request2);
		
		return cps;
	}
	
	public CyberPhysicalSystem comfortAndSecure() {

		CyberPhysicalSystem cps = domain.createRootWithTypes();
		
		Request comfortRequest = domain.createComfortPackageRequest("IB413");
		cps.getRequests().add(comfortRequest);
		
		Request secureRequest = domain.createSecurePackageRequest("IB028");
		cps.getRequests().add(secureRequest);

		return cps;
	}
	
	public CyberPhysicalSystem all() {
		return allXTimes(1);
	}
	
	public CyberPhysicalSystem allAndMore() {

		CyberPhysicalSystem cps = domain.createRootWithTypes();
		
		Request comfortRequest = domain.createComfortPackageRequest("comfort");
		cps.getRequests().add(comfortRequest);
		
		Request secureRequest = domain.createSecurePackageRequest("secure");
		cps.getRequests().add(secureRequest);
		
		Request secureRequest2 = domain.createSecurePackageRequest("secure2");
		cps.getRequests().add(secureRequest2);
		
		Request maxRequest = domain.createMaxPackageRequest("max");
		cps.getRequests().add(maxRequest);
		
		Request maxRequest2 = domain.createMaxPackageRequest("max2");
		cps.getRequests().add(maxRequest2);
		
		Request basicRequest = domain.createBasicPackageRequest("basic");
		cps.getRequests().add(basicRequest);

		return cps;
	}

	public RoomServiceCpsDomain getDomain() {
		return domain;
	}

	public CyberPhysicalSystem allXTimes(int count) {
		
		CyberPhysicalSystem cps = domain.createRootWithTypes();
		
		for( int i= 0; i<count; ++i) {
			Request comfortRequest = domain.createComfortPackageRequest("comfort" + i);
			cps.getRequests().add(comfortRequest);
			
			Request secureRequest = domain.createSecurePackageRequest("secure" + i);
			cps.getRequests().add(secureRequest);
			
			Request maxRequest = domain.createMaxPackageRequest("max" + i);
			cps.getRequests().add(maxRequest);
			
			Request basicRequest = domain.createBasicPackageRequest("basic" + i);
			cps.getRequests().add(basicRequest);
		}
		
		return cps;
	}

}
