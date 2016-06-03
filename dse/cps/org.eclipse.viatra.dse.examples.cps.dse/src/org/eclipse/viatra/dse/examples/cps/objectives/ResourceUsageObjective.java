/*******************************************************************************
 * Copyright (c) 2010-2015, Andras Szabolcs Nagy and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Andras Szabolcs Nagy - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.dse.examples.cps.objectives;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.examples.cps.CyberPhysicalSystem;
import org.eclipse.viatra.dse.examples.cps.HostInstance;
import org.eclipse.viatra.dse.examples.cps.HostType;
import org.eclipse.viatra.dse.objectives.IObjective;
import org.eclipse.viatra.dse.objectives.impl.BaseObjective;

public final class ResourceUsageObjective extends BaseObjective {

    public ResourceUsageObjective() {
        super("ResourceUsage");
    }

    @Override
    public Double getFitness(ThreadContext context) {
        CyberPhysicalSystem root = (CyberPhysicalSystem) context.getModel();

        double sumUtil = 0;
//        EList<HostInstance> hosts = root.getHosts();
        List<HostInstance> hosts = new ArrayList<>();
        
        for (HostType hostTypes : root.getHostTypes()) {
            for (HostInstance hostInstance : hostTypes.getInstances()) {
                hosts.add(hostInstance);
            }
        }

        int computationServers = 0;
        for (HostInstance host : hosts) {
            if (host.getType().getId().equals("CS")) {
                ++computationServers;
                if (host.getAvailableMemory() == host.getTotalMemory()
                        && host.getAvailableHdd() == host.getTotalHdd()) {
                    sumUtil += 0;
                } else {
                    double memUtil = ((double) host.getTotalMemory() - host.getAvailableMemory())
                            / host.getTotalMemory();
                    double hddUtil = ((double) host.getTotalHdd() - host.getAvailableHdd()) / host.getTotalHdd();
                    sumUtil += Math.max(memUtil, hddUtil);
                }
            }
        }
        if (sumUtil == 0 || computationServers == 0) {
            return 0d;
        } else {
            return sumUtil / computationServers;
        }

    }

    @Override
    public IObjective createNew() {
        return this;
    }
}