/*******************************************************************************
 * Copyright (c) 2014, 2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Zoltan Ujhelyi, Peter Lunk - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.integration;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowComponent;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;
import org.eclipse.viatra.examples.cps.generator.CPSPlanBuilder;
import org.eclipse.viatra.examples.cps.generator.dtos.AppClass;
import org.eclipse.viatra.examples.cps.generator.dtos.BuildableCPSConstraint;
import org.eclipse.viatra.examples.cps.generator.dtos.CPSFragment;
import org.eclipse.viatra.examples.cps.generator.dtos.CPSGeneratorInput;
import org.eclipse.viatra.examples.cps.generator.dtos.GeneratorPlan;
import org.eclipse.viatra.examples.cps.generator.dtos.HostClass;
import org.eclipse.viatra.examples.cps.generator.dtos.MinMaxData;
import org.eclipse.viatra.examples.cps.generator.dtos.Percentage;
import org.eclipse.viatra.examples.cps.generator.exceptions.ModelGeneratorException;
import org.eclipse.viatra.examples.cps.generator.interfaces.ICPSConstraints;
import org.eclipse.viatra.examples.cps.generator.queries.Validation;
import org.eclipse.viatra.examples.cps.generator.utils.CPSModelBuilderUtil;
import org.eclipse.viatra.examples.cps.planexecutor.PlanExecutor;
import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment;
import org.eclipse.viatra.examples.cps.xform.serializer.DefaultSerializer;
import org.eclipse.viatra.examples.cps.xform.serializer.javaio.JavaIOBasedFileAccessor;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class InitializerComponent implements IWorkflowComponent {
    protected int modelSize;
    private int seed = 11111;
    private String modelDir;
    private String modelName = "MWE_TEST";
    private String outputProjectName;
    private String outputProjectLocation;

    public int getModelSize() {
        return modelSize;
    }

    public void setModelSize(String modelSize) {
        try {
            this.modelSize = Integer.parseInt(modelSize);
        } catch (Exception e) {
            this.modelSize = 4;
        }

    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        try {
            this.seed = Integer.parseInt(seed);
        } catch (Exception e) {
            this.seed = 4;
        }

    }

    public String getOutputProjectLocation() {
        return outputProjectLocation;
    }

    public void setOutputProjectLocation(String outputProjectLocation) {
        this.outputProjectLocation = outputProjectLocation;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelDir() {
        return modelDir;
    }

    public void setModelDir(String modelDir) {
        this.modelDir = modelDir;
    }

    public String getOutputProjectName() {
        return outputProjectName;
    }

    public void setOutputProjectName(String outputProjectName) {
        this.outputProjectName = outputProjectName;
    }

    @Override
    public void preInvoke() {

    }

    @Override
    public void invoke(IWorkflowContext ctx) {
        CPSModelBuilderUtil modelBuilderUtil = new CPSModelBuilderUtil();
        DefaultSerializer serializer = new DefaultSerializer();
        
        String locationString = (String) ctx.get("projectLocation");
        if(locationString != null){
            outputProjectLocation = locationString;
        }
        modelDir = outputProjectLocation+"\\"+outputProjectName+"\\"+"model";
        
        
        // //////////////////////////////////
        // //// EMF initialization phase
        // //////////////////////////////////

        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,
                new XMIResourceFactoryImpl());

        CPSToDeployment cps2dep = modelBuilderUtil.preparePersistedCPSModel(modelDir + "/" + modelName, modelName);

        // //////////////////////////////////
        // //// Generation phase
        // //////////////////////////////////
        if (ctx.get("modelsize") != null) {
            modelSize = (Integer) ctx.get("modelsize");
        }

        AdvancedViatraQueryEngine engine = null;
        try {

            CPSGeneratorInput input = new CPSGeneratorInput(seed, getConstraints(modelSize), cps2dep.getCps());
            GeneratorPlan plan = CPSPlanBuilder.buildCharacteristicBasedPlan();
            PlanExecutor<CPSFragment, CPSGeneratorInput> generator = new PlanExecutor<CPSFragment, CPSGeneratorInput>();

            CPSFragment fragment = generator.process(plan, input);

            Validation.instance().prepare(fragment.getEngine());

            fragment.getEngine().dispose();

            engine = AdvancedViatraQueryEngine.createUnmanagedEngine(new EMFScope(cps2dep.eResource().getResourceSet()));
        } catch (ViatraQueryException e) {
            e.printStackTrace();
        }

        serializer.createProject(outputProjectLocation, outputProjectName, new JavaIOBasedFileAccessor());
        File project = new File(outputProjectLocation, outputProjectName);
        File srcFolder = new File(project.getAbsolutePath(), "src");
        for (File file : srcFolder.listFiles()) {
            file.delete();
        }

        ctx.put("engine", engine);
        ctx.put("model", cps2dep);
        ctx.put("projectname", outputProjectName);
        ctx.put("projectPath", project.getAbsolutePath());
        ctx.put("folder", srcFolder.getAbsolutePath());
    }

    @Override
    public void postInvoke() {
    }

    protected ICPSConstraints getConstraints(int scale) {
        List<HostClass> classList = createHostClassList(scale);

        int signalCount = 143;
        BuildableCPSConstraint cons = new BuildableCPSConstraint("Statistics-based Case", new MinMaxData<Integer>(
                signalCount, signalCount), createAppClassList(scale, classList), classList);

        return cons;
    }

    private List<HostClass> createHostClassList(int scale) {
        List<HostClass> hostClasses = Lists.newArrayList();

        // 1 for the empty, and scale for the host instances with allocated application instances
        int instEmptyCount = scale * 22;
        int instAppContainerCount = scale * 4;
        int comCount = instAppContainerCount - 1;

        // TODO should we randomize the number of host communication for the hosts without allocated applications
        int emptyHostCommunicationCount = scale * 2;

        Map<HostClass, Integer> emptyHostConnection = Maps.newHashMap();
        HostClass emptyHostClass = new HostClass("HC_empty", // name
                new MinMaxData<Integer>(1, 1), // Type
                new MinMaxData<Integer>(instEmptyCount, instEmptyCount), // Instance
                new MinMaxData<Integer>(emptyHostCommunicationCount, emptyHostCommunicationCount), // ComLines
                emptyHostConnection);
        hostClasses.add(emptyHostClass);

        List<HostClass> appContainerClasses = Lists.newArrayList();
        for (int i = 0; i < scale; i++) {

            // The application container host instances of the same type will form a complete graph of 4
            // when only taking the communicatesWith relation
            Map<HostClass, Integer> appContainerConnection = Maps.newHashMap();
            HostClass appContainerHostClass = new HostClass("HC_appContainer" + i, // name
                    new MinMaxData<Integer>(1, 1), // Type
                    new MinMaxData<Integer>(instAppContainerCount, instAppContainerCount), // Instance
                    new MinMaxData<Integer>(comCount, comCount), // ComLines
                    appContainerConnection);
            appContainerConnection.put(appContainerHostClass, 1);

            hostClasses.add(appContainerHostClass);
            appContainerClasses.add(appContainerHostClass);
        }

        // Communications:
        // App containers only communicate with each other, the empty hosts might communicate with any instance
        emptyHostConnection.put(emptyHostClass, 1);
        for (HostClass appContainerClass : appContainerClasses) {
            emptyHostConnection.put(appContainerClass, 1);
        }

        return hostClasses;
    }

    private List<AppClass> createAppClassList(int scale, List<HostClass> hostClasses) {
        List<AppClass> appClasses = Lists.newArrayList();

        double expectedValueOfTypes = scale * 52;

        // Every class will have 1 or 2 types, so that the expected value of the appTypes will be the
        // expectedValueOfTypes using the formula below
        double appClassCount = 2 * expectedValueOfTypes / 3;

        // alloc ratios - allocate only to the second host type
        Map<HostClass, Integer> allocRatios = Maps.newHashMap();
        List<HostClass> hostClassesList = hostClasses;
        HostClass emptyHostClass = hostClassesList.get(0);

        // The first in the list is the empty host class, the instances of the others should contain app instances
        for (HostClass hostClass : hostClasses) {
            if (hostClass.equals(emptyHostClass)) {
                allocRatios.put(hostClass, 0);
            } else {
                allocRatios.put(hostClass, 1);
            }
        }

        int appTypeMinCount = 1;
        int appTypeMaxCount = 2;

        // Each app type will have 1 instance to have an assignment between AppType and HostInstance
        int appInstCount = 1;

        try {
            // Half of the app types will not have state machine, the other half will have
            for (int i = 0; i < appClassCount / 2; i++) {
                appClasses.add(new AppClass("AC_withoutStateMachine" + i, new MinMaxData<Integer>(appTypeMinCount,
                        appTypeMaxCount), // AppTypes
                        new MinMaxData<Integer>(appInstCount, appInstCount), // AppInstances
                        new MinMaxData<Integer>(0, 0), // States
                        new MinMaxData<Integer>(0, 0), // Transitions
                        new Percentage(100), // Alloc
                        allocRatios, new Percentage(0), // Action
                        new Percentage(0) // Send
                        ));
            }
            for (int i = 0; i < appClassCount / 2; i++) {
                appClasses.add(new AppClass("AC_withStateMachine" + i, new MinMaxData<Integer>(appTypeMinCount,
                        appTypeMaxCount), // AppTypes
                        new MinMaxData<Integer>(appInstCount, appInstCount), // AppInstances
                        new MinMaxData<Integer>(3, 3), // States
                        new MinMaxData<Integer>(7, 8), // Transitions
                        new Percentage(100), // Alloc
                        allocRatios, new Percentage(50), // Action
                        new Percentage(50) // Send
                        ));
            }
        } catch (ModelGeneratorException e) {
            e.printStackTrace();
        }

        return appClasses;
    }

}
