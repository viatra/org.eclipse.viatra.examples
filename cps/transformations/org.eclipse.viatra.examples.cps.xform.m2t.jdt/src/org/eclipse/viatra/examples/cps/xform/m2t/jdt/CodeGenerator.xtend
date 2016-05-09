/*******************************************************************************
 * Copyright (c) 2014, 2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Zoltan Ujhelyi, Robert Doczi - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2t.jdt

import org.eclipse.viatra.examples.cps.deployment.Deployment
import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication
import org.eclipse.viatra.examples.cps.deployment.DeploymentBehavior
import org.eclipse.viatra.examples.cps.deployment.DeploymentHost
import org.eclipse.viatra.examples.cps.xform.m2t.api.ICPSGenerator
import org.eclipse.viatra.examples.cps.xform.m2t.exceptions.CPSGeneratorException
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.examples.cps.xform.m2t.util.FormatterUtil

class CodeGenerator implements ICPSGenerator {
	extension FormatterUtil util = new FormatterUtil
	val Generator generator;
	
	new (String projectName, ViatraQueryEngine engine) {
		generator = new Generator(projectName, engine);
	}
	
	override generateHostCode(DeploymentHost host) throws CPSGeneratorException {
		formatCode(generator.generateHostCode(host))
	}
	
	override generateApplicationCode(DeploymentApplication application) throws CPSGeneratorException {
		formatCode(generator.generateApplicationCode(application))
	}
	
	override generateBehaviorCode(DeploymentBehavior behavior) throws CPSGeneratorException {
		formatCode(generator.generateBehaviorCode(behavior))
	}
	
	override generateDeploymentCode(Deployment deployment) throws CPSGeneratorException {
		
	}
	
}