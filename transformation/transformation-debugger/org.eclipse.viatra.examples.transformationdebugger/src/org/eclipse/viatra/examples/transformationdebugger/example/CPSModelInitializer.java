/**
 * Copyright (c) 2010-2016, Peter Lunk, IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Peter Lunk - initial API and implementation
 */
package org.eclipse.viatra.examples.transformationdebugger.example;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystem;
import org.eclipse.viatra.examples.cps.deployment.Deployment;
import org.eclipse.viatra.examples.cps.deployment.DeploymentFactory;
import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment;
import org.eclipse.viatra.examples.cps.traceability.TraceabilityFactory;

public class CPSModelInitializer {
    private DeploymentFactory depFactory = DeploymentFactory.eINSTANCE;
    private TraceabilityFactory traceFactory = TraceabilityFactory.eINSTANCE;

    public CPSModelInitializer(){
        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("cyberphysicalsystem", new XMIResourceFactoryImpl());
    }


    public CPSToDeployment loadModel(String location) {
        // Obtain a new resource set
        ResourceSet resSet = new ResourceSetImpl();
        
        // create a resource for the cps model
        Resource cpsRes = resSet.getResource(URI
                .createURI(location), true);
        
        //create a resource for the deployment model
        Resource depRes = resSet.createResource(URI.createURI("test.deployment"));
        
        //create a resource for the trace model
        Resource trcRes = resSet.createResource(URI.createURI("test.traceability"));
        
        CyberPhysicalSystem cps = (CyberPhysicalSystem) cpsRes.getContents().get(0);
        
        Deployment dep = depFactory.createDeployment();
        depRes.getContents().add(dep);
         
        CPSToDeployment cps2dep = traceFactory.createCPSToDeployment();
        cps2dep.setCps(cps);
        cps2dep.setDeployment(dep);
        trcRes.getContents().add(cps2dep);
        
        return cps2dep;
    }
}
