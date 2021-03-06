/*******************************************************************************
 * Copyright (c) 2010-2015, Andras Szabolcs Nagy, Abel Hegedus, Akos Horvath, Zoltan Ujhelyi and Daniel Varro
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.dse.examples.bpmn.problems;

import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN;
import org.eclipse.viatra.dse.util.EMFHelper;
import org.junit.Test;

/**
 * This class saves the BPMN models into .sbpmn files.
 * 
 * @author Andras Szabolcs Nagy
 */
public class BpmnProblemSaver {

    @Test
    public void run() {

        SimplifiedBPMN root;

        root = BpmnProblems.createOneTaskProblem(false);
        EMFHelper.saveModel(root, "onetask.sbpmn");

        root = BpmnProblems.create3TaskProblem(false);
        EMFHelper.saveModel(root, "threetask.sbpmn");

        root = BpmnProblems.createWebShopProblem();
        EMFHelper.saveModel(root, "webshop.sbpmn");

        root = BpmnProblems.createInvoiceProblem(false);
        EMFHelper.saveModel(root, "invoice.sbpmn");

        root = BpmnProblems.createBookProblem(false);
        EMFHelper.saveModel(root, "book.sbpmn");

    }

}
