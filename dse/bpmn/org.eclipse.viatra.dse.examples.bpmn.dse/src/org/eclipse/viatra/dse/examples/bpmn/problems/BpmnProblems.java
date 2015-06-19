/*******************************************************************************
 * Copyright (c) 2010-2015, Andras Szabolcs Nagy, Abel Hegedus, Akos Horvath, Zoltan Ujhelyi and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Andras Szabolcs Nagy - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.dse.examples.bpmn.problems;

import org.eclipse.viatra.dse.examples.simplifiedbpmn.EndEvent;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.Gateway;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ParallelGateway;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceType;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.StartEvent;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.Task;

/**
 * This class creates BPMN models with static methods.
 * 
 * @author Andras Szabolcs Nagy
 */
public class BpmnProblems {

    public static final String NOSQL = "NoSql";
    public static final String NOSQL_SLOW = "NoSqlSlow";
    public static final String NOSQL_MEDIUM = "NoSqlMedium";
    public static final String NOSQL_FAST = "NoSqlFast";
    public static final String SQL = "Sql";
    public static final String SQL_SLOW = "SqlSlow";
    public static final String SQL_MEDIUM = "SqlMedium";
    public static final String SQL_FAST = "SqlFast";
    public static final String WS = "WS";
    private static final String WS_FAST = "WsFast";
    private static final String WS_MEDIUM = "WsMedium";
    private static final String WS_SLOW = "WsSlow";

    public static SimplifiedBPMN createOneTaskProblem(boolean withResource) {
        SimplifiedBpmnBuilder builder = new SimplifiedBpmnBuilder();

        ResourceType rt = builder.createResourceTypeWithSimpleVariant(WS, withResource ? 2 : 0);

        StartEvent startEvent = builder.createStartEvent("StartEvent");
        Task task1 = builder.createTask("Task1", 12, rt);
        EndEvent endEvent = builder.createEndEvent("EndEvent");
        builder.createFlow(startEvent, task1);
        builder.createFlow(task1, endEvent);

        return builder.getRoot();
    }

    public static SimplifiedBPMN create3TaskProblem(boolean withResource) {
        SimplifiedBpmnBuilder builder = new SimplifiedBpmnBuilder();

        ResourceType nosql = builder.createResourceTypeWithSimpleVariant(NOSQL, withResource ? 2 : 0);
        ResourceType sql = builder.createResourceType(SQL);
        ResourceTypeVariant sqlFast = builder.createResourceTypeVariant(SQL_FAST, sql, 0.75d, withResource ? 1 : 0);
        ResourceTypeVariant sqlMedium = builder.createResourceTypeVariant(SQL_MEDIUM, sql, 1.0d, withResource ? 1 : 0);

        StartEvent startEvent = builder.createStartEvent("StartEvent");
        Task task1 = builder.createTask("Task1", 15, sql);
        Task taskSql = builder.createTask("TaskSQL", 30, sql);
        Task taskNoSql = builder.createTask("TaskNoSQL", 28, nosql);
        EndEvent endEvent = builder.createEndEvent("EndEvent");

        builder.createFlow(startEvent, task1);
        builder.createFlow(task1, taskSql, 2);
        builder.createFlow(task1, taskNoSql, 3);
        builder.createFlow(taskNoSql, endEvent);
        builder.createFlow(taskSql, endEvent);

        return builder.getRoot();
    }

    public static SimplifiedBPMN createWebShopProblem() {
        return createWebShopProblem(false, false);
    }

    public static SimplifiedBPMN createWebShopProblem(boolean withResource, boolean withVariants) {
        SimplifiedBpmnBuilder builder = new SimplifiedBpmnBuilder();

        ResourceType ws = builder.createResourceTypeWithSimpleVariant(WS, withResource ? 2 : 0);
        ResourceType sql = builder.createResourceType(SQL);
        ResourceTypeVariant sqlFast = builder.createResourceTypeVariant(SQL_FAST, sql, 0.75d, withResource ? 1 : 0);
        ResourceTypeVariant sqlMedium = builder.createResourceTypeVariant(SQL_MEDIUM, sql, 1.0d, withResource ? 1 : 0);
        ResourceType nosql = builder.createResourceType(NOSQL);
        ResourceTypeVariant nosqlFast = builder.createResourceTypeVariant(NOSQL_FAST, nosql, 0.75d, withResource ? 1 : 0);
        ResourceTypeVariant nosqlMedium = builder.createResourceTypeVariant(NOSQL_MEDIUM, nosql, 1.0d, withResource ? 1 : 0);

        StartEvent startElement = builder.createStartEvent("StartEvent");
        EndEvent endElement = builder.createEndEvent("EndEvent");

        Task taskAuthorize = builder.createTask("Authorize", 12, ws);
        builder.createFlow(startElement, taskAuthorize);

        Gateway gw = builder.createGateway("Gateway");
        builder.createFlow(taskAuthorize, gw);

        Task taskPurchase = builder.createTask("Purchase", 24, sql);
        builder.createFlow(gw, taskPurchase, 33);
        builder.createFlow(taskPurchase, endElement);

        Task taskRecommend = builder.createTask("Recommend", 15, nosql);
        Task taskFetchData = builder.createTask("FetchData", 10, sql);

        ParallelGateway pgw = builder.createParallelGateway(taskRecommend, taskFetchData, true);
        builder.createFlow(gw, pgw, 66);

        Task taskLog = builder.createTask("Log", 12, nosql);
        ParallelGateway pgw2 = builder.createParallelGateway(taskRecommend, taskLog, false);
        builder.createFlow(pgw, taskRecommend);
        builder.createFlow(pgw, taskFetchData);
        builder.createFlow(taskRecommend, pgw2);
        builder.createFlow(taskFetchData, taskLog);
        builder.createFlow(taskLog, pgw2);
        builder.createFlow(pgw2, endElement);

        if (withVariants) {
            taskAuthorize.setVariant(ws.getVariants().get(0));
            taskPurchase.setVariant(sqlMedium);
            taskFetchData.setVariant(sqlMedium);
            taskRecommend.setVariant(nosqlMedium);
            taskLog.setVariant(nosqlMedium);
        }

        return builder.getRoot();
    }

    public static SimplifiedBPMN createInvoiceProblem(boolean withResource) {

        // based on workflow:
        // http://www.workflowpatterns.com/patterns/presentation/concretesyntax/csm1.php

        SimplifiedBpmnBuilder builder = new SimplifiedBpmnBuilder();

        ResourceType ws = builder.createResourceTypeWithSimpleVariant(WS, withResource ? 2 : 0);
        ResourceType sql = builder.createResourceType(SQL);
        ResourceTypeVariant sqlFast = builder.createResourceTypeVariant(SQL_FAST, sql, 0.75d, withResource ? 1 : 0);
        ResourceTypeVariant sqlMedium = builder.createResourceTypeVariant(SQL_MEDIUM, sql, 1.0d, withResource ? 1 : 0);
        ResourceTypeVariant sqlSlow = builder.createResourceTypeVariant(SQL_SLOW, sql, 1.2d, withResource ? 1 : 0);

        Task inTask = builder.createTask("Invoice In", 11, ws);
        Task checkInvoiceTask = builder.createTask("Check invoice", 5, ws);
        Task createEntryTask = builder.createTask("Create new entry", 15, sql);
        Task insertInvoiceTask = builder.createTask("Insert invoice", 17, sql);
        Task insertCustomerTask = builder.createTask("Insert  customer", 17, sql);
        Task mismatchCheckTask = builder.createTask("Mismatch checking", 12, sql);
        Task blockInvoiceTask = builder.createTask("Block invoice", 11, sql);
        Task invoiceOutTask = builder.createTask("Invoice out", 6, ws);

        EndEvent endEvent = builder.createEndEvent("EndEvent");
        StartEvent startEvent = builder.createStartEvent("StartEvent");

        Gateway invoicePresentGW = builder.createGateway("Is invoice Present");
        Gateway mismatchChackingGW = builder.createGateway("Mismach checking");
        Gateway dummy = builder.createGateway("Dummy");

        ParallelGateway divPgw = builder.createParallelGateway(insertInvoiceTask, insertCustomerTask, true);
        ParallelGateway convPgw = builder.createParallelGateway(insertInvoiceTask, insertCustomerTask, false);

        builder.createFlow(startEvent, inTask);
        builder.createFlow(inTask, checkInvoiceTask);
        builder.createFlow(checkInvoiceTask, invoicePresentGW);
        builder.createFlow(invoicePresentGW, createEntryTask, 40);
        builder.createFlow(invoicePresentGW, mismatchCheckTask, 60);

        builder.createFlow(createEntryTask, dummy);
        builder.createFlow(dummy, divPgw);
        builder.createFlow(divPgw, insertInvoiceTask);
        builder.createFlow(divPgw, insertCustomerTask);
        builder.createFlow(insertInvoiceTask, convPgw);
        builder.createFlow(insertCustomerTask, convPgw);
        builder.createFlow(convPgw, invoiceOutTask);

        builder.createFlow(mismatchCheckTask, mismatchChackingGW);
        builder.createFlow(mismatchChackingGW, blockInvoiceTask, 30);
        builder.createFlow(mismatchChackingGW, invoiceOutTask, 70);
        builder.createFlow(blockInvoiceTask, invoiceOutTask);

        builder.createFlow(invoiceOutTask, endEvent);

        return builder.getRoot();
    }

    public static SimplifiedBPMN createBookProblem(boolean withResource) {

        // based on workflow:
        // http://training-course-material.com/training/BPMN_2.0_Process,_Collaboration,_Choreography_and_Conversation

        SimplifiedBpmnBuilder builder = new SimplifiedBpmnBuilder();

        ResourceType ws = builder.createResourceType(WS);
        ResourceTypeVariant wsFast = builder.createResourceTypeVariant(WS_FAST, ws, 0.75d, withResource ? 1 : 0);
        ResourceTypeVariant wsMedium = builder.createResourceTypeVariant(WS_MEDIUM, ws, 1.0d, withResource ? 1 : 0);
        ResourceTypeVariant wsSlow = builder.createResourceTypeVariant(WS_SLOW, ws, 1.2d, withResource ? 1 : 0);
        ResourceType sql = builder.createResourceType(SQL);
        ResourceTypeVariant sqlFast = builder.createResourceTypeVariant(SQL_FAST, sql, 0.75d, withResource ? 1 : 0);
        ResourceTypeVariant sqlMedium = builder.createResourceTypeVariant(SQL_MEDIUM, sql, 1.0d, withResource ? 1 : 0);
        ResourceTypeVariant sqlSlow = builder.createResourceTypeVariant(SQL_SLOW, sql, 1.2d, withResource ? 1 : 0);

        Task inTask = builder.createTask("Receive book request", 11, ws);
        Task bookStatusTask = builder.createTask("Get book status", 8, sql);
        Task onLoanTask = builder.createTask("On loan reply", 11, ws);
        Task cancelRequestTask = builder.createTask("Cancel request", 13, ws);
        Task requestHoldTask = builder.createTask("Request hold", 17, sql);
        Task holdReplyTask = builder.createTask("Hold reply", 12, ws);
        Task checkoutBookTask = builder.createTask("Checkout book", 18, sql);
        Task checkoutReplyTask = builder.createTask("Checkout reply", 12, ws);

        EndEvent endEvent = builder.createEndEvent("EndEvent");
        StartEvent startEvent = builder.createStartEvent("StartEvent");

        Gateway isBookOnLoanGW = builder.createGateway("Is book on loan");
        Gateway cancelRequestGW = builder.createGateway("Cancel request");

        builder.createDataFlow(startEvent, inTask);
        builder.createDataFlow(inTask, bookStatusTask);
        builder.createDataFlow(bookStatusTask, isBookOnLoanGW);
        builder.createDataFlow(isBookOnLoanGW, onLoanTask, 25);
        builder.createDataFlow(isBookOnLoanGW, checkoutBookTask, 75);

        builder.createDataFlow(checkoutBookTask, checkoutReplyTask);
        builder.createDataFlow(checkoutReplyTask, endEvent);

        builder.createDataFlow(onLoanTask, cancelRequestGW);
        builder.createDataFlow(cancelRequestGW, cancelRequestTask, 90);
        builder.createDataFlow(cancelRequestGW, requestHoldTask, 10);

        builder.createDataFlow(cancelRequestTask, endEvent);

        builder.createDataFlow(requestHoldTask, holdReplyTask);
        builder.createDataFlow(holdReplyTask, bookStatusTask);

        return builder.getRoot();

    }
}
