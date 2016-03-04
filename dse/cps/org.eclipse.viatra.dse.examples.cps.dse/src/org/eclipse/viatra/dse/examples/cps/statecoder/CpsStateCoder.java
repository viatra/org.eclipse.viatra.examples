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
import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.viatra.dse.examples.cps.ApplicationInstance;
import org.eclipse.viatra.dse.examples.cps.CyberPhysicalSystem;
import org.eclipse.viatra.dse.examples.cps.HostInstance;
import org.eclipse.viatra.dse.examples.cps.HostType;
import org.eclipse.viatra.dse.examples.cps.Request;
import org.eclipse.viatra.dse.examples.cps.Requirement;
import org.eclipse.viatra.dse.examples.cps.patterns.AllocateMatch;
import org.eclipse.viatra.dse.examples.cps.patterns.CreateApplicationInstanceMatch;
import org.eclipse.viatra.dse.examples.cps.patterns.CreateHostInstanceMatch;
import org.eclipse.viatra.dse.examples.cps.patterns.DeleteAllocationMatch;
import org.eclipse.viatra.dse.examples.cps.patterns.MoveMatch;
import org.eclipse.viatra.dse.examples.cps.patterns.StartInstanceMatch;
import org.eclipse.viatra.dse.examples.cps.patterns.StopInstanceMatch;
import org.eclipse.viatra.dse.statecode.IStateCoder;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;

public class CpsStateCoder implements IStateCoder {

	private CyberPhysicalSystem model;
    private List<Requirement> requirements = new ArrayList<Requirement>();

    @Override
    public void init(Notifier notifier) {
        model = (CyberPhysicalSystem) notifier;
        
        for (Request request : model.getRequests()) {
            for (Requirement requirement : request.getRequirements()) {
                requirements.add(requirement);
            }
        }
    }
	
	@Override
	public Object createStateCode() {
		StringBuilder sb = new StringBuilder();

		List<String> apps = new ArrayList<String>();
		for (Requirement requirement : requirements) {
            for (ApplicationInstance app : requirement.getInstances()) {
                StringBuilder sbTemp = new StringBuilder();
                sbTemp.append(app.getId());
                sbTemp.append(app.getState().name());
                sbTemp.append(':');
                for (HostInstance host : app.getAllocatedTo()) {
                    sbTemp.append(host.getId());
                    sbTemp.append(',');
                }
                apps.add(sbTemp.toString());
            }
		}

		Collections.<String>sort(apps);
		for (String app : apps) {
            sb.append(app);
            sb.append('|');
        }
		
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
