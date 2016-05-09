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

import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication;
import org.eclipse.viatra.examples.cps.deployment.DeploymentBehavior;
import org.eclipse.viatra.examples.cps.deployment.DeploymentElement;
import org.eclipse.viatra.examples.cps.deployment.DeploymentHost;
import org.eclipse.viatra.examples.cps.xform.m2t.exceptions.CPSGeneratorException;
import org.eclipse.viatra.examples.cps.xform.m2t.monitor.DeploymentChangeDelta;

import com.google.common.collect.Lists;

public class ChangeM2TOutputProvider implements IM2TOutputProvider {
    DeploymentChangeDelta delta;
    ICPSGenerator generator;
    String folder;

    @Override
    public List<M2TOutputRecord> getOutput() {

        return generateChanges();
    }

    public ChangeM2TOutputProvider(DeploymentChangeDelta delta, ICPSGenerator generator, String folder) {
        super();
        this.delta = delta;
        this.generator = generator;
        this.folder = folder;
    }

    public List<M2TOutputRecord> generateChanges() {
        List<M2TOutputRecord> ret = Lists.newArrayList();
        try {
            for (DeploymentElement depElem : delta.getDisappeared()) {
                if (depElem instanceof DeploymentApplication) {
                    DeploymentApplication app = ((DeploymentApplication) depElem);
                    String filename = purify(app.getId()) + "Application.java";
                    ret.add(new M2TOutputRecord(folder, filename, null, true));
                } else if (depElem instanceof DeploymentHost) {
                    DeploymentHost host = ((DeploymentHost) depElem);
                    String filename = "Host" + purify(host.getIp()) + ".java";
                    ret.add(new M2TOutputRecord(folder, filename, null, true));
                }
            }

            for (DeploymentElement appeared : delta.getAppeared()) {
                if (appeared instanceof DeploymentApplication) {
                    DeploymentApplication app = ((DeploymentApplication) appeared);
                    CharSequence content = generator.generateApplicationCode(app);
                    String filename = purify(app.getId()) + "Application.java";
                    ret.add(new M2TOutputRecord(folder, filename, content, false));
                }
                if (appeared instanceof DeploymentHost) {
                    DeploymentHost host = ((DeploymentHost) appeared);
                    CharSequence content = generator.generateHostCode(host);
                    String filename = "Host" + purify(host.getIp()) + ".java";
                    ret.add(new M2TOutputRecord(folder, filename, content, false));
                }
                if (appeared instanceof DeploymentBehavior) {
                    DeploymentBehavior behavior = ((DeploymentBehavior) appeared);
                    CharSequence content = generator.generateBehaviorCode(behavior);
                    String filename = "Behavior" + purify(behavior.getDescription()) + ".java";
                    ret.add(new M2TOutputRecord(folder, filename, content, false));
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
