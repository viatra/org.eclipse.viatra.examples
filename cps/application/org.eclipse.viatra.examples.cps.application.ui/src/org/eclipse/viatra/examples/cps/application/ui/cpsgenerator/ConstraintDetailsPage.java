/*******************************************************************************
 * Copyright (c) 2010-2017, Marton Elekes, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.application.ui.cpsgenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.viatra.examples.cps.generator.dtos.AppClass;
import org.eclipse.viatra.examples.cps.generator.dtos.HostClass;
import org.eclipse.viatra.examples.cps.generator.dtos.MinMaxData;
import org.eclipse.viatra.examples.cps.generator.dtos.Percentage;
import org.eclipse.viatra.examples.cps.generator.exceptions.ModelGeneratorException;
import org.eclipse.viatra.examples.cps.generator.dtos.constraints.ICPSConstraints;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * A wizardpage to enter detailed constraints for model generation
 * 
 * @author Marton Elekes
 */
public class ConstraintDetailsPage extends WizardPage {
    private Composite container;
    private Text hostTypesMin;
    private Text hostTypesMax;
    private Text hostInstancesMin;
    private Text hostInstancesMax;
    private Text commLinesMin;
    private Text commLinesMax;
    private Text appTypesMin;
    private Text appTypesMax;
    private Text appInstancesMin;
    private Text appInstancesMax;
    private Text statesMin;
    private Text statesMax;
    private Text transitionsMin;
    private Text transitionsMax;
    private Text allocatedInstances;
    private Text actionGeneration;
    private Text sendAction;
    private Text signalsMin;
    private Text signalsMax;

    public ConstraintDetailsPage() {
        super("wizardPage");
        setDescription("Set the parameters of model generation");
    }

    public void createControl(Composite parent) {
        container = new Composite(parent, SWT.NULL);

        setControl(container);
        container.setLayout(new GridLayout(5, false));

        Label lblNewLabel_1 = new Label(container, SWT.NONE);
        lblNewLabel_1.setText("Hosts");

        Label lblMin = new Label(container, SWT.NONE);
        lblMin.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblMin.setText("min");
        new Label(container, SWT.NONE);

        Label lblMax = new Label(container, SWT.NONE);
        lblMax.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 2, 1));
        lblMax.setText("max");

        Label lblNewLabel = new Label(container, SWT.NONE);
        lblNewLabel.setText("# of Types");

        hostTypesMin = new Text(container, SWT.BORDER);
        hostTypesMin.setText("1");
        hostTypesMin.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        Label lblTempppp = new Label(container, SWT.NONE);
        lblTempppp.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblTempppp.setText("..");

        hostTypesMax = new Text(container, SWT.BORDER);
        hostTypesMax.setText("3");
        hostTypesMax.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

        Label lblNewLabel_2 = new Label(container, SWT.NONE);
        lblNewLabel_2.setText("# of Instances / Types");

        hostInstancesMin = new Text(container, SWT.BORDER);
        hostInstancesMin.setText("2");
        hostInstancesMin.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        Label label_1 = new Label(container, SWT.NONE);
        label_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        label_1.setText("..");

        hostInstancesMax = new Text(container, SWT.BORDER);
        hostInstancesMax.setText("5");
        hostInstancesMax.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

        Label lblCommunicationLin = new Label(container, SWT.NONE);
        lblCommunicationLin.setAlignment(SWT.RIGHT);
        lblCommunicationLin.setText("# of communication lines\r\nfrom an Instance");

        commLinesMin = new Text(container, SWT.BORDER);
        commLinesMin.setText("1");
        commLinesMin.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        Label label = new Label(container, SWT.NONE);
        label.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        label.setText("..");

        commLinesMax = new Text(container, SWT.BORDER);
        commLinesMax.setText("2");
        commLinesMax.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

        Label label_2 = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
        label_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1));

        Label lblNewLabel_4 = new Label(container, SWT.NONE);
        lblNewLabel_4.setText("# of Signals");

        signalsMin = new Text(container, SWT.BORDER);
        signalsMin.setText("1");
        signalsMin.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        Label label_3 = new Label(container, SWT.NONE);
        label_3.setText("..");
        label_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));

        signalsMax = new Text(container, SWT.BORDER);
        signalsMax.setText("10");
        signalsMax.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

        Label label_8 = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
        label_8.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1));

        Label lblApplications = new Label(container, SWT.NONE);
        lblApplications.setText("Applications");
        new Label(container, SWT.NONE);
        new Label(container, SWT.NONE);

        Label lblNewLabel_5 = new Label(container, SWT.NONE);
        lblNewLabel_5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        new Label(container, SWT.NONE);

        Label lblNewLabel_3 = new Label(container, SWT.NONE);
        lblNewLabel_3.setText("# of Types");

        appTypesMin = new Text(container, SWT.BORDER);
        appTypesMin.setText("1");
        appTypesMin.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        Label label_4 = new Label(container, SWT.NONE);
        label_4.setText("..");
        label_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));

        appTypesMax = new Text(container, SWT.BORDER);
        appTypesMax.setText("3");
        appTypesMax.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

        Label label_9 = new Label(container, SWT.NONE);
        label_9.setText("# of Instances / Types");

        appInstancesMin = new Text(container, SWT.BORDER);
        appInstancesMin.setText("1");
        appInstancesMin.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        Label label_5 = new Label(container, SWT.NONE);
        label_5.setText("..");
        label_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));

        appInstancesMax = new Text(container, SWT.BORDER);
        appInstancesMax.setText("2");
        appInstancesMax.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

        Label lblOfStates = new Label(container, SWT.NONE);
        lblOfStates.setText("# of States");

        statesMin = new Text(container, SWT.BORDER);
        statesMin.setText("2");
        statesMin.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        Label label_6 = new Label(container, SWT.NONE);
        label_6.setText("..");
        label_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));

        statesMax = new Text(container, SWT.BORDER);
        statesMax.setText("4");
        statesMax.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

        Label lblOfTransitions = new Label(container, SWT.NONE);
        lblOfTransitions.setText("# of Transitions");

        transitionsMin = new Text(container, SWT.BORDER);
        transitionsMin.setText("1");
        transitionsMin.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        Label label_7 = new Label(container, SWT.NONE);
        label_7.setText("..");
        label_7.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));

        transitionsMax = new Text(container, SWT.BORDER);
        transitionsMax.setText("2");
        transitionsMax.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

        Label lblOfAllocated = new Label(container, SWT.NONE);
        lblOfAllocated.setText("Allocated Instances");

        allocatedInstances = new Text(container, SWT.BORDER);
        allocatedInstances.setText("100");
        allocatedInstances.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));

        Label label_10 = new Label(container, SWT.NONE);
        label_10.setAlignment(SWT.RIGHT);
        label_10.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        label_10.setText("%");

        Label lblProbOfAction = new Label(container, SWT.NONE);
        lblProbOfAction.setText("Prob. of Action Gen.");

        actionGeneration = new Text(container, SWT.BORDER);
        actionGeneration.setText("95");
        actionGeneration.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
        Label label_11 = new Label(container, SWT.NONE);
        label_11.setAlignment(SWT.RIGHT);
        label_11.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        label_11.setToolTipText("");
        label_11.setText("%");

        Label lblProbOfSend = new Label(container, SWT.NONE);
        lblProbOfSend.setText("Prob. of Send Action");

        sendAction = new Text(container, SWT.BORDER);
        sendAction.setText("60");
        sendAction.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
        Label label_12 = new Label(container, SWT.NONE);
        label_12.setAlignment(SWT.RIGHT);
        label_12.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        label_12.setText("%");

        Arrays.stream(container.getChildren()).filter(Text.class::isInstance).map(ctrl -> (Text) ctrl).forEach(text -> {
            text.addModifyListener((e) -> getWizard().getContainer().updateButtons());
        });
    }

    @Override
    public boolean isPageComplete() {
        return super.isPageComplete() && validate();
    }

    private boolean validate() {
        List<Text> percentTexts = Arrays.asList(allocatedInstances, actionGeneration, sendAction);

        // If validation happens before the control was created
        if (container == null)
            return false;

        Optional<String> errorMsg = Arrays.stream(container.getChildren()).filter(Text.class::isInstance).map(ctrl -> {
            Text text = (Text) ctrl;
            if (percentTexts.contains(text))
                return containsPercent(text) ? null : "Enter percentage";
            else
                return containsNonNegativeNumber(text) ? null : "Enter a non-negative integer";
        }).filter(msg -> msg != null).findFirst();

        setErrorMessage(errorMsg.orElse(null));
        return !errorMsg.isPresent();
    }

    private static boolean containsNonNegativeNumber(Text text) {
        try {
            return Integer.parseInt(text.getText()) >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean containsPercent(Text text) {
        try {
            int num = Integer.parseInt(text.getText());
            return 0 <= num && num <= 100;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public ICPSConstraints getConstraints() {
        return new ICPSConstraints() {

            @Override
            public MinMaxData<Integer> getNumberOfSignals() {
                return new MinMaxData<Integer>(Integer.valueOf(signalsMin.getText()),
                        Integer.valueOf(signalsMax.getText()));
            }

            @Override
            public String getName() {
                return "WizardConstraints";
            }

            private List<HostClass> hostClasses;
            private List<AppClass> appClasses;

            private List<HostClass> getHostClassesWithInit() {
                if (hostClasses == null) {
                    HostClass hostClass = new HostClass("h",
                            new MinMaxData<Integer>(Integer.valueOf(hostTypesMin.getText()),
                                    Integer.valueOf(hostTypesMax.getText())),
                            new MinMaxData<Integer>(Integer.valueOf(hostInstancesMin.getText()),
                                    Integer.valueOf(hostInstancesMax.getText())),
                            new MinMaxData<Integer>(Integer.valueOf(commLinesMin.getText()),
                                    Integer.valueOf(commLinesMax.getText())),
                            new HashMap<HostClass, Integer>());
                    hostClass.communicationRatios.put(hostClass, 1);

                    hostClasses = new ArrayList<HostClass>();
                    hostClasses.add(hostClass);
                }

                return hostClasses;
            }

            @Override
            public Iterable<HostClass> getHostClasses() {
                return getHostClassesWithInit();
            }

            @Override
            public Iterable<AppClass> getApplicationClasses() {
                try {
                    if (appClasses == null) {
                        Map<HostClass, Integer> allocationsMap = new HashMap<>();
                        allocationsMap.put(getHostClassesWithInit().get(0), 1);

                        AppClass appClass = new AppClass("a",
                                new MinMaxData<Integer>(Integer.valueOf(appTypesMin.getText()),
                                        Integer.valueOf(appTypesMax.getText())),
                                new MinMaxData<Integer>(Integer.valueOf(appInstancesMin.getText()),
                                        Integer.valueOf(appInstancesMax.getText())),
                                new MinMaxData<Integer>(Integer.valueOf(statesMin.getText()),
                                        Integer.valueOf(statesMax.getText())),
                                new MinMaxData<Integer>(Integer.valueOf(transitionsMin.getText()),
                                        Integer.valueOf(transitionsMax.getText())),
                                new Percentage(Integer.valueOf(allocatedInstances.getText())), allocationsMap,
                                new Percentage(Integer.valueOf(actionGeneration.getText())),
                                new Percentage(Integer.valueOf(sendAction.getText())));

                        appClasses = new ArrayList<>();
                        appClasses.add(appClass);
                    }

                    return appClasses;
                } catch (ModelGeneratorException _e) {
                    throw Exceptions.sneakyThrow(_e);
                }
            }
        };
    }
}
