/*******************************************************************************
 * Copyright (c) 2014-2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Tamas Borbas, Marton Bur, Zoltan Ujhelyi - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.xform.m2m.util

import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.HostInstance
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Identifiable
import org.eclipse.viatra.examples.cps.deployment.DeploymentApplication
import org.eclipse.viatra.examples.cps.deployment.DeploymentElement
import org.eclipse.viatra.examples.cps.deployment.DeploymentHost
import org.eclipse.viatra.examples.cps.traceability.CPS2DeploymentTrace

class NamingUtil {

	static dispatch def name(HostInstance cpsHost) {
		cpsHost.nodeIp
	}

	static dispatch def name(Identifiable cpsIdentifiable) {
		cpsIdentifiable.identifier
	}

	static dispatch def name(DeploymentHost depHost) {
		depHost.ip
	}

	static dispatch def name(DeploymentApplication depApplication) {
		depApplication.id
	}

	static dispatch def name(DeploymentElement depElement) {
		depElement.description
	}

	static dispatch def String name(CPS2DeploymentTrace trace) {
		'''[«FOR ce : trace.cpsElements SEPARATOR ", "»«ce.name»«ENDFOR»]->[«FOR de : trace.deploymentElements SEPARATOR ", "»«de.
			name»«ENDFOR»]'''
	}
}
