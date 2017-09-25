/*******************************************************************************
 * Copyright (c) 2014-2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Akos Menyhert, Zoltan Ujhelyi - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.generator.utils

import java.util.Collection
import org.eclipse.emf.ecore.EObject
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystem
import org.eclipse.viatra.examples.cps.deployment.Deployment
import org.eclipse.viatra.examples.cps.generator.dtos.CPSStats
import org.eclipse.viatra.examples.cps.generator.dtos.DeploymentStats
import org.eclipse.viatra.examples.cps.generator.dtos.TraceabilityStats
import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException

class StatsUtil {
	
	def static generateStatsForCPS(ViatraQueryEngine engine, CyberPhysicalSystem model){
		return new CPSStats(engine, model);
	}
	
	def static generateStatsForDeployment(ViatraQueryEngine engine, Deployment model){
		return new DeploymentStats(engine, model);
	}
	
	def static generateStatsForTraceability(ViatraQueryEngine engine, CPSToDeployment model){
		return new TraceabilityStats(engine, model);
	}
	
	def static size(EObject eobject){
		 eobject?.eAllContents.size
	}
	
	def static int countEdges(EObject model) throws ViatraQueryException {
		val Collection<EObject> eObjects = model.eAllContents.toList

		var int countTriples = 0;
		for (EObject eObject : eObjects) {
			for(feature : eObject.eClass.EAllReferences){
				val value = eObject.eGet(feature);
				if (feature.isMany()) {
					countTriples += (value as Collection<?>).size
				} else {
					if (value!== null) {
						countTriples++;
					}
				}
			}
		}
		return countTriples;
	}
}