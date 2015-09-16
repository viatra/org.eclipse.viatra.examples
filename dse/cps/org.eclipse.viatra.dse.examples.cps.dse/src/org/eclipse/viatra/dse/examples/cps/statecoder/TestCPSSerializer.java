/*******************************************************************************
 * Copyright (c) 2010-2015, Andras Szabolcs Nagy and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Andras Szabolcs Nagy - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.dse.examples.cps.statecoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.base.api.NavigationHelper;
import org.eclipse.incquery.runtime.emf.EMFScope;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.statecode.IStateCoder;
import org.eclipse.viatra.examples.dse.cps.CpsPackage;
import org.eclipse.viatra.examples.dse.cps.CyberPhysicalSystem;
import org.eclipse.viatra.examples.dse.cps.HostInstance;
import org.eclipse.viatra.examples.dse.cps.HostType;

import hu.bme.mit.inf.cps.patterns.AllocateMatch;
import hu.bme.mit.inf.cps.patterns.CreateApplicationInstanceMatch;
import hu.bme.mit.inf.cps.patterns.CreateHostInstanceMatch;
import hu.bme.mit.inf.cps.patterns.DeleteAllocationMatch;
import hu.bme.mit.inf.cps.patterns.MoveMatch;
import hu.bme.mit.inf.cps.patterns.StartInstanceMatch;
import hu.bme.mit.inf.cps.patterns.StopInstanceMatch;

public class TestCPSSerializer implements IStateCoder {

	private static final String classSeparator = "|";
    private static final String objectSeparator = ";";
    private CyberPhysicalSystem model;
    private IncQueryEngine queryEngine;

    private Map<EObject, String> codes = new HashMap<EObject, String>();
    private NavigationHelper baseIndex;
    
	public void init(Notifier cps) {
		this.model = (CyberPhysicalSystem) cps;
		
		try {
		    EMFScope scope = new EMFScope(model);
            queryEngine = IncQueryEngine.on(scope);
            baseIndex = EMFScope.extractUnderlyingEMFIndex(queryEngine);
        } catch (IncQueryException e) {
        }
		
		Set<EClass> classes = new HashSet<EClass>();
		classes.add(CpsPackage.Literals.APPLICATION_INSTANCE);
		classes.add(CpsPackage.Literals.APPLICATION_TYPE);
		classes.add(CpsPackage.Literals.HOST_INSTANCE);
		classes.add(CpsPackage.Literals.HOST_TYPE);
		classes.add(CpsPackage.Literals.IDENTIFIABLE);
		classes.add(CpsPackage.Literals.REQUEST);
		classes.add(CpsPackage.Literals.REQUIREMENT);
		classes.add(CpsPackage.Literals.RESOURCE_REQUIREMENT);
		
        baseIndex.registerEClasses(classes);

	}

	@Override
	public Object createStateCode() {
		StringBuilder sb = new StringBuilder();

		
		
		// host type
        sb.append("HT:");
        
        for (EObject eObject : baseIndex.getAllInstances(CpsPackage.Literals.HOST_TYPE)) {
            Object id = eObject.eGet(CpsPackage.Literals.IDENTIFIABLE__ID);
            codes.put(eObject, id.toString());
            sb.append(id.toString());
            sb.append(objectSeparator);
        }
        
        sb.append(classSeparator);
        
        // app type
        sb.append("AT:");
        
        for (EObject eObject : baseIndex.getAllInstances(CpsPackage.Literals.APPLICATION_TYPE)) {
            Object id = eObject.eGet(CpsPackage.Literals.IDENTIFIABLE__ID);
            codes.put(eObject, id.toString());
            sb.append(id.toString());
            sb.append(objectSeparator);
        }
        
        sb.append(classSeparator);
        
        // request
        sb.append("Request:");
        
        for (EObject eObject : baseIndex.getAllInstances(CpsPackage.Literals.REQUEST)) {
            Object id = eObject.eGet(CpsPackage.Literals.IDENTIFIABLE__ID);
            codes.put(eObject, id.toString());
            sb.append(id.toString());
            sb.append(objectSeparator);
        }
        
        sb.append(classSeparator);
        
        // resource requirement
        sb.append("RR:");
        
        for (EObject eObject : baseIndex.getAllInstances(CpsPackage.Literals.RESOURCE_REQUIREMENT)) {
            Object hostType = eObject.eGet(CpsPackage.Literals.RESOURCE_REQUIREMENT__HOST_TYPE);
            
            Set<EObject> inverseReferences = baseIndex.getInverseReferences(eObject, CpsPackage.Literals.APPLICATION_TYPE__REQUIREMENTS);
            EObject appType = inverseReferences.iterator().next();
            
            String hostTypeId = codes.get(hostType);
            String appTypeId = codes.get(appType);
            
            String id = appTypeId + "," + hostTypeId;
            codes.put(eObject, id);
            
            sb.append(id);
            sb.append(objectSeparator);
        }
        
        sb.append(classSeparator);
        
        // request
        sb.append("Requirement:");
        
        for (EObject eObject : baseIndex.getAllInstances(CpsPackage.Literals.REQUIREMENT)) {
            Object count = eObject.eGet(CpsPackage.Literals.REQUIREMENT__COUNT);
            Object request = eObject.eGet(CpsPackage.Literals.REQUIREMENT__REQUEST);
            Object appType = eObject.eGet(CpsPackage.Literals.REQUIREMENT__TYPE);
            
            String id = codes.get(request) + "," + codes.get(appType) + "," + count;
            codes.put(eObject, id);
            
            sb.append(id);
            sb.append(objectSeparator);
        }
        
        sb.append(classSeparator);
        
        // hot instance
        sb.append("HI:");
        
        for (EObject eObject : baseIndex.getAllInstances(CpsPackage.Literals.HOST_INSTANCE)) {
            Object count = eObject.eGet(CpsPackage.Literals.REQUIREMENT__COUNT);
            Object request = eObject.eGet(CpsPackage.Literals.REQUIREMENT__REQUEST);
            Object appType = eObject.eGet(CpsPackage.Literals.REQUIREMENT__TYPE);
            
            String id = codes.get(request) + "," + codes.get(appType) + "," + count;
            codes.put(eObject, id);
            
            sb.append(id);
            sb.append(objectSeparator);
        }
        
        sb.append(classSeparator);
		
		
//		ResourceRequirement
		
		
		
//		List<String> apps = new ArrayList<String>();
//		for (Requirement requirement : requirements) {
//            for (ApplicationInstance app : requirement.getInstances()) {
//                StringBuilder sbTemp = new StringBuilder();
//                sbTemp.append(app.getId());
//                sbTemp.append(app.getState().name());
//                sbTemp.append(':');
//                for (HostInstance host : app.getAllocatedTo()) {
//                    sbTemp.append(host.getId());
//                    sbTemp.append(',');
//                }
//                apps.add(sbTemp.toString());
//            }
//		}
//
//		Collections.<String>sort(apps);
//		for (String app : apps) {
//            sb.append(app);
//            sb.append('|');
//        }
		
		// hosts, which aren't hosting any app yet
		List<HostInstance> hosts = new ArrayList<HostInstance>();
		for (HostType hostType : model.getHostTypes()) {
            for (HostInstance host : hostType.getInstances()) {
                if (host.getApplications().isEmpty()) {
                    hosts.add(host);
                }
            }
        }
		Collections.<HostInstance>sort(hosts,new Comparator<HostInstance>() {
            @Override
            public int compare(HostInstance o1, HostInstance o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
		for (HostInstance host : hosts) {
		    sb.append(host.getId() + ",");
        }

		return sb.toString();
	}

	@Override
	public Object createActivationCode(IPatternMatch match) {
		String result = null;

		if (match instanceof AllocateMatch) {
			AllocateMatch m = (AllocateMatch) match;
			result = "Alloc:" + m.getAppInstance().getId() + "," + m.getHostInstance().getId();
		}
		else if (match instanceof DeleteAllocationMatch) {
			DeleteAllocationMatch m = (DeleteAllocationMatch) match;
			result = "Del:" + m.getAppInstance().getId() + "," + m.getHostInstance().getId();
		}
		else if (match instanceof MoveMatch) {
			MoveMatch m = (MoveMatch) match;
			result = "Move:" + m.getAppInstance().getId() + "," + m.getFrom().getId() + "," + m.getTo().getId();
		}
		
		else if (match instanceof StartInstanceMatch) {
			StartInstanceMatch m = (StartInstanceMatch) match;
			result = "Start:" + m.getAppInstance().getId();
		}
		else if (match instanceof StopInstanceMatch) {
			StopInstanceMatch m = (StopInstanceMatch) match;
			result = "Stop:" + m.getAppInstance().getId();
		}
	
		else if (match instanceof CreateApplicationInstanceMatch) {
			CreateApplicationInstanceMatch m = (CreateApplicationInstanceMatch) match;
			result = "CreateApp:" + m.getReq().getId();
		}
		else if (match instanceof CreateHostInstanceMatch) {
			CreateHostInstanceMatch m = (CreateHostInstanceMatch) match;
			result = "CreateHost:" + m.getHostType().getId();
		}
		else {
			throw new UnsupportedOperationException("The rule with " + match.patternName() + "LHS is not supported in RequestSatisfierCPSSerializer");
		}

		return result.intern();
	}

}
