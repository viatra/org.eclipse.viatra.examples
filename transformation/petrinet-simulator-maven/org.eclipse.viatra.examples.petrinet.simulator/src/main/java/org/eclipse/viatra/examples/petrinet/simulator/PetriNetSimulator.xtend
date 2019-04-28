/*******************************************************************************
 * Copyright (c) 2010-2015, Zoltan Ujhelyi, Gabor Szarnyas
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.petrinet.simulator

import org.apache.log4j.Level
import org.eclipse.viatra.examples.petrinet.model.PetriNetPackage
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine
import org.eclipse.viatra.transformation.evm.api.RuleEngine
import org.eclipse.viatra.transformation.evm.specific.RuleEngines
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.SimpleModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformationStatements
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformation
import org.eclipse.viatra.transformation.evm.specific.event.ViatraQueryEventRealm

import static extension org.eclipse.viatra.transformation.runtime.emf.transformation.TransformationExtensions.*

class PetriNetSimulator {
	extension BatchTransformationRuleFactory factory = new BatchTransformationRuleFactory
	extension BatchTransformation transformation
	extension BatchTransformationStatements statements
	extension IModelManipulations manipulation

	extension PetriNetPackage pnPackage = PetriNetPackage::eINSTANCE
	extension PetriNetSimulatorQueries queries = PetriNetSimulatorQueries::instance
	val AdvancedViatraQueryEngine engine
	
	new(AdvancedViatraQueryEngine engine) {
	    this.engine = engine
		transformation = BatchTransformation.forEngine(engine).build
        statements = transformation.transformationStatements
        manipulation = new SimpleModelManipulations(engine)

        transformation.ruleEngine.logger.level = Level::DEBUG
	}
	
	
	val removeTokenRule = createRule.precondition(sourcePlace).action [
		pl.tokens.findFirst[true].remove
	].build
	
	val addTokenRule = createRule.precondition(targetPlace).action [
		createChild(pl, place_Tokens, token)
	].build
	
	val fireTransitionRule = createRule.precondition(fireableTransition).action [
		//Remove tokens from source places
		fireAllCurrent(removeTokenRule, "t" -> t)

		//Add tokens to target places
		fireAllCurrent(addTokenRule, "t" -> t)
	].build
	
	def fire(int maxCount) {
		var count = 0
		while (count < maxCount) {
			engine.fireableTransition.forEachMatch[println(it.prettyPrint)]
			fireTransitionRule.fireOne
			Thread.sleep(1000)
			count = count + 1
		}
	}
}