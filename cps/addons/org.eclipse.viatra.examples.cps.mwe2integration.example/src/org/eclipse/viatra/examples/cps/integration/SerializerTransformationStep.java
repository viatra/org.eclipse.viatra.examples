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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;
import org.eclipse.viatra.examples.cps.xform.m2t.api.IM2TOutputProvider;
import org.eclipse.viatra.examples.cps.xform.m2t.api.M2TOutputRecord;
import org.eclipse.viatra.examples.cps.xform.serializer.DefaultSerializer;
import org.eclipse.viatra.examples.cps.xform.serializer.javaio.JavaIOBasedFileAccessor;
import org.eclipse.viatra.integration.mwe2.mwe2impl.TransformationStep;

public class SerializerTransformationStep extends TransformationStep {
    public DefaultSerializer serializer;
    public String sourceFolder;
    public List<M2TOutputRecord> m2tOutput;
        
    @Override
    public void doInitialize(IWorkflowContext ctx) {
        System.out.println("Initialized serializer");
        serializer = new DefaultSerializer();
        sourceFolder = (String) ctx.get("folder");
    }

    @Override
    public void doExecute() {
        ListBasedOutputProvider provider = new ListBasedOutputProvider(m2tOutput);
        serializer.serialize(sourceFolder, provider, new JavaIOBasedFileAccessor());

        System.out.println("Serialization completed");
    }
    
    @Override
    public void dispose() {
        System.out.println("Disposed serializer");
    }
    
    public class ListBasedOutputProvider implements IM2TOutputProvider{
        private List<M2TOutputRecord> records = new ArrayList<M2TOutputRecord>();
        
        public ListBasedOutputProvider(List<M2TOutputRecord> records) {
            super();
            this.records = records;
        }
        
        @Override
        public List<M2TOutputRecord> getOutput() {
            return records;
        }
       
        public void setRecords(List<M2TOutputRecord> records) {
            this.records = records;
        }
    }
}
