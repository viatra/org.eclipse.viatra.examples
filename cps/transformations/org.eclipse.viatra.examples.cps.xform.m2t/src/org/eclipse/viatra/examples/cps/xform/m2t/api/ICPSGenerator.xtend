/*******************************************************************************
 * Copyright (c) 2014-2016 Akos Horvath, Abel Hegedus, Marton Bur, Zoltan Ujhelyi, Robert Doczi, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2t.api

import org.eclipse.viatra.examples.cps.deployment.DeploymentHost
import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication
import org.eclipse.viatra.examples.cps.deployment.Deployment
import org.eclipse.viatra.examples.cps.deployment.DeploymentBehavior
import org.eclipse.viatra.examples.cps.xform.m2t.exceptions.CPSGeneratorException

interface ICPSGenerator {
	def CharSequence generateHostCode(DeploymentHost host) throws CPSGeneratorException
	def CharSequence generateApplicationCode(DeploymentApplication application) throws CPSGeneratorException
	def CharSequence generateBehaviorCode(DeploymentBehavior behavior) throws CPSGeneratorException
	def CharSequence generateDeploymentCode(Deployment deployment) throws CPSGeneratorException
}