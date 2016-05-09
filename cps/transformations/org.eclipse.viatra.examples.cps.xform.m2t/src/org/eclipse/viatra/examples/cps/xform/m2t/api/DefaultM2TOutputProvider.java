/*******************************************************************************
 * Copyright (c) 2014, 2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Akos Horvath, Abel Hegedus, Marton Bur, Zoltan Ujhelyi, Robert Doczi - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2t.api;

import java.util.List;

import org.eclipse.viatra.examples.cps.deployment.Deployment;
import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication;
import org.eclipse.viatra.examples.cps.deployment.DeploymentBehavior;
import org.eclipse.viatra.examples.cps.deployment.DeploymentHost;
import org.eclipse.viatra.examples.cps.xform.m2t.exceptions.CPSGeneratorException;

import com.google.common.collect.Lists;

public class DefaultM2TOutputProvider implements IM2TOutputProvider {
    Deployment deployment;
    ICPSGenerator generator;
    String folder;
    
    @Override
    public List<M2TOutputRecord> getOutput() {
        
        return generateAll();
    }
    

    public DefaultM2TOutputProvider(Deployment deployment, ICPSGenerator generator, String folder) {
        super();
        this.deployment = deployment;
        this.generator = generator;
        this.folder = folder;
    }


    public List<M2TOutputRecord> generateAll() {
        List<M2TOutputRecord> ret = Lists.newArrayList();
        try {
            for (DeploymentHost host : deployment.getHosts()) {
                ret.add(new M2TOutputRecord(folder, "Host" + purify(host.getIp()) + ".java", generator
                        .generateHostCode(host), false));
                for (DeploymentApplication app : host.getApplications()) {
                    ret.add(new M2TOutputRecord(folder, purify(app.getId()) + "Application.java", generator
                            .generateApplicationCode(app), false));
                    DeploymentBehavior behavior = app.getBehavior();
                    if (behavior != null) {
                        ret.add(new M2TOutputRecord(folder, "Behavior" + purify(behavior.getDescription()) + ".java",
                                generator.generateBehaviorCode(behavior), false));
                    }

                }
            }
        } catch (CPSGeneratorException e) {
            e.printStackTrace();
        }

        return ret;
    }

    private String purify(String string) {
        return string.replaceAll("[^A-Za-z0-9]", "");
    }

}
