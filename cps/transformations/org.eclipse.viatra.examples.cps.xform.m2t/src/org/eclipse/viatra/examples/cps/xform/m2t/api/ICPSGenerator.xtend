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