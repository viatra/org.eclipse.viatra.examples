/*******************************************************************************
 * Copyright (c) 2010-2017, Marton Elekes, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.application.ui.cpsgenerator;

import java.util.Random;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.viatra.examples.cps.generator.dtos.constraints.ICPSConstraints;
import org.eclipse.viatra.examples.cps.generator.dtos.constraints.impl.AllocationCPSConstraints;
import org.eclipse.viatra.examples.cps.generator.dtos.constraints.impl.DemoCPSConstraints;
import org.eclipse.viatra.examples.cps.generator.dtos.constraints.impl.HostClassesCPSConstraints;
import org.eclipse.viatra.examples.cps.generator.dtos.constraints.impl.LargeCPSConstraints;
import org.eclipse.viatra.examples.cps.generator.dtos.constraints.impl.OnlyHostTypesCPSConstraints;
import org.eclipse.viatra.examples.cps.generator.dtos.constraints.impl.SimpleCPSConstraints;
import org.eclipse.viatra.examples.cps.generator.dtos.scenario.impl.BasicScenario;

/**
 * A wizardpage to enter constraints for the model generation
 * 
 * @author Marton Elekes
 */
public class ConstraintTypePage extends WizardPage {
    private Button detailedRadioButton;
    private Button simpleRadioButton;
    private Label simpleTypeLabel;
    private ComboViewer simpleType;
    private Button scalableRadioButton;
    private Label scalableTypeLabel;
    private ComboViewer scalableType;
    private Label scaleLabel;
    private Text scaleText;
    private Button openModelCheckButton;
    private Label seedLabel;
    private Text seedText;

    public ConstraintTypePage() {
        super("wizardPage");
        setDescription("Choose the type of model to generate");
    }

    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);

        setControl(container);
        container.setLayout(new GridLayout(2, false));

        RadioButtonSelectionListener radioButtonListener = new RadioButtonSelectionListener();

        simpleRadioButton = new Button(container, SWT.RADIO);
        simpleRadioButton.setSelection(true);
        simpleRadioButton.setText("Simple Test Models");
        new Label(container, SWT.NONE);

        simpleTypeLabel = new Label(container, SWT.NONE);
        simpleTypeLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        simpleTypeLabel.setText("Type:");

        simpleType = new ComboViewer(container, SWT.READ_ONLY);
        simpleType.setContentProvider(ArrayContentProvider.getInstance());
        simpleType.setInput(new ICPSConstraints[] { new AllocationCPSConstraints(), new DemoCPSConstraints(),
                new HostClassesCPSConstraints(), new LargeCPSConstraints(), new OnlyHostTypesCPSConstraints(),
                new SimpleCPSConstraints() });
        simpleType.setLabelProvider(new LabelProvider() {
            @Override
            public String getText(Object element) {
                return element.getClass().getSimpleName();
            }
        });
        Combo simpleTypeCombo = simpleType.getCombo();
        simpleTypeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        simpleType.getCombo().select(0);

        scalableRadioButton = new Button(container, SWT.RADIO);
        scalableRadioButton.addSelectionListener(radioButtonListener);
        scalableRadioButton.setText("Scalable Models");
        new Label(container, SWT.NONE);

        scalableTypeLabel = new Label(container, SWT.NONE);
        scalableTypeLabel.setText("Type:");
        scalableTypeLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));

        scalableType = new ComboViewer(container, SWT.READ_ONLY);
        scalableType.setContentProvider(ArrayContentProvider.getInstance());
        scalableType.setInput(
                new ScalableConstraints[] { new ScalableConstraints("BasicScenario (scale between 100 and 10 k)",
                        (scale, rand) -> new BasicScenario(rand).getConstraintsFor(scale)) });
        Combo scalableTypeCombo = scalableType.getCombo();
        scalableTypeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        scalableType.getCombo().select(0);

        scaleLabel = new Label(container, SWT.NONE);
        scaleLabel.setText("Scale:");
        scaleLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));

        scaleText = new Text(container, SWT.BORDER);
        scaleText.addModifyListener((e) -> getWizard().getContainer().updateButtons());
        scaleText.setText("1000");
        scaleText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        detailedRadioButton = new Button(container, SWT.RADIO);
        detailedRadioButton.addSelectionListener(radioButtonListener);
        detailedRadioButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
        detailedRadioButton.setText("Model by Detailed Constraints");

        Label separator = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
        separator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
        
        seedLabel = new Label(container, SWT.NONE);
        seedLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        seedLabel.setText("Random seed:");
        
        seedText = new Text(container, SWT.BORDER);
        seedText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        seedText.addModifyListener((e) -> getWizard().getContainer().updateButtons());
        seedText.setText(Long.toString(System.nanoTime()));

        openModelCheckButton = new Button(container, SWT.CHECK);
        openModelCheckButton.setSelection(true);
        openModelCheckButton.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, false, 2, 1));
        openModelCheckButton.setText("Open model after generation ");

        initDataBindings();
    }

    public ICPSConstraints getConstraints() {
        if (simpleRadioButton.getSelection())
            return (ICPSConstraints) simpleType.getStructuredSelection().getFirstElement();
        if (scalableRadioButton.getSelection()) {
            ScalableConstraints constraints = (ScalableConstraints) scalableType.getStructuredSelection()
                    .getFirstElement();
            return constraints.getConstraints(Integer.parseInt(scaleText.getText()), new Random(getSeed()));
        }

        return null;
    }
    
    public long getSeed() {
        return Long.parseLong(seedText.getText());
    }

    public boolean shouldOpenModel() {
        return openModelCheckButton.getSelection();
    }

    @Override
    public IWizardPage getNextPage() {
        if (detailedRadioButton.getSelection())
            return super.getNextPage();
        else
            return null;
    }

    @Override
    public boolean isPageComplete() {
        return super.isPageComplete() && validate();
    }

    private boolean isScaleValid() {
        try {
            return Integer.parseInt(scaleText.getText()) >= 1;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isSeedValid() {
        try {
            Long.parseLong(seedText.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean validate() {
        // If validation happens before the control was created
        if (scalableRadioButton == null || seedText == null)
            return false;

        if (scalableRadioButton.getSelection() && !isScaleValid()) {
            setErrorMessage("Enter a positive integer as scaling factor");
            return false;
        }

        if (!isSeedValid()) {
            setErrorMessage("Enter an integer as seed");
            return false;
        }

        setErrorMessage(null);
        return true;
    }

    private class RadioButtonSelectionListener extends SelectionAdapter {
        @Override
        public void widgetSelected(SelectionEvent e) {
            getWizard().getContainer().updateButtons();
        }
    }

    private DataBindingContext initDataBindings() {
        DataBindingContext bindingContext = new DataBindingContext();

        IObservableValue<?> observeEnabledLblSimpleTypeObserveWidget = WidgetProperties.enabled()
                .observe(simpleTypeLabel);
        IObservableValue<?> observeSelectionSimpleRadioButtonObserveWidget = WidgetProperties.selection()
                .observe(simpleRadioButton);
        bindingContext.bindValue(observeEnabledLblSimpleTypeObserveWidget,
                observeSelectionSimpleRadioButtonObserveWidget, null, null);

        IObservableValue<?> observeEnabledSimpleTypeComboObserveWidget = WidgetProperties.enabled()
                .observe(simpleType.getCombo());
        bindingContext.bindValue(observeEnabledSimpleTypeComboObserveWidget,
                observeSelectionSimpleRadioButtonObserveWidget, null, null);

        IObservableValue<?> observeEnabledScalableTypeComboObserveWidget = WidgetProperties.enabled()
                .observe(scalableType.getCombo());
        IObservableValue<?> observeSelectionScalableRadioButtonObserveWidget = WidgetProperties.selection()
                .observe(scalableRadioButton);
        bindingContext.bindValue(observeEnabledScalableTypeComboObserveWidget,
                observeSelectionScalableRadioButtonObserveWidget, null, null);

        IObservableValue<?> observeEnabledScaleTextObserveWidget = WidgetProperties.enabled().observe(scaleText);
        bindingContext.bindValue(observeEnabledScaleTextObserveWidget, observeSelectionScalableRadioButtonObserveWidget,
                null, null);

        IObservableValue<?> observeEnabledLblScalableTypeObserveWidget = WidgetProperties.enabled()
                .observe(scalableTypeLabel);
        bindingContext.bindValue(observeEnabledLblScalableTypeObserveWidget,
                observeSelectionScalableRadioButtonObserveWidget, null, null);

        IObservableValue<?> observeEnabledLblScaleObserveWidget = WidgetProperties.enabled().observe(scaleLabel);
        bindingContext.bindValue(observeEnabledLblScaleObserveWidget, observeSelectionScalableRadioButtonObserveWidget,
                null, null);

        return bindingContext;
    }
}
