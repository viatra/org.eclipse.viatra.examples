/*******************************************************************************
 * Copyright (c) 2014, 2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Akos Menyhert, Tamas Borbas, Zoltan Ujhelyi - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.generator.tests

import com.google.common.base.Stopwatch
import java.util.concurrent.TimeUnit
import org.apache.log4j.Logger
import org.eclipse.viatra.examples.cps.generator.CPSPlans
import org.eclipse.viatra.examples.cps.generator.dtos.CPSFragment
import org.eclipse.viatra.examples.cps.generator.interfaces.ICPSConstraints
import org.eclipse.viatra.examples.cps.generator.queries.AppTypesMatcher
import org.eclipse.viatra.examples.cps.generator.queries.HostTypesMatcher
import org.eclipse.viatra.examples.cps.generator.queries.Validation
import org.eclipse.viatra.examples.cps.generator.utils.CPSGeneratorBuilder
import org.eclipse.viatra.examples.cps.generator.utils.PersistenceUtil
import org.eclipse.viatra.examples.cps.generator.utils.StatsUtil
import org.eclipse.viatra.examples.cps.tests.CPSTestBase
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.query.runtime.emf.EMFScope

import static org.junit.Assert.*

abstract class TestBase extends CPSTestBase{
	protected extension Logger logger = Logger.getLogger("cps.generator.Tests")
	
	def assertInRangeAppTypes(ICPSConstraints constraints, ViatraQueryEngine engine) {
		val appTypesMatcher = AppTypesMatcher.on(engine);
		var int minApp = 0;
		var int maxApp = 0;
		for(appClass : constraints.applicationClasses){
			minApp += appClass.numberOfAppTypes.minValue;
			maxApp += appClass.numberOfAppTypes.maxValue;
		}
		
		assertInRange("AppTypeCount", appTypesMatcher.countMatches, minApp, maxApp)
	}
	
	protected def assertInRangeHostTypes(ICPSConstraints constraints, ViatraQueryEngine engine) {
		val hostTypesMatcher = HostTypesMatcher.on(engine);
		var int minHost = 0;
		var int maxHost = 0;
		for(appClass : constraints.hostClasses){
			minHost += appClass.numberOfHostTypes.minValue;
			maxHost += appClass.numberOfHostTypes.maxValue;
		}
		
		assertInRange("HostTypeCount", hostTypesMatcher.countMatches, minHost, maxHost)
	}
	
	protected def assertInRange(String variableName, int actualValue, int minExpected, int maxExpected){
		assertTrue(variableName +  " is out of range: "+actualValue+" --> [" +minExpected + ", "+ maxExpected + "]" , minExpected <= actualValue && actualValue <= maxExpected);
	}
	
	def runGeneratorOn(ICPSConstraints constraints, long seed) {
		return runGeneratorOn(constraints, seed, false);
	}
	def runGeneratorOn(ICPSConstraints constraints, long seed, boolean persist) {
		runGeneratorOn(constraints,seed,persist,CPSPlans.DEFAULT)
	}
	def runGeneratorOn(ICPSConstraints constraints, long seed, boolean persist, CPSPlans cpsplan) {
		var Stopwatch fullTime = Stopwatch.createStarted;
		
		val out = CPSGeneratorBuilder.buildAndGenerateModel(seed, constraints, cpsplan);		
		
		// Assertions
		assertNotNull("The output fragment is null", out);
		assertNotNull("The output model is null", out.modelRoot);

		assertInRange("NumberOfSignals", out.numberOfSignals, constraints.numberOfSignals.minValue, constraints.numberOfSignals.maxValue);
		
		val ViatraQueryEngine engine = ViatraQueryEngine.on(new EMFScope(out.modelRoot));
		Validation.instance.prepare(engine);
		
		assertNotNull("ViatraQueryEngine is null", engine);
		
		//Show stats
		var Stopwatch statTime = Stopwatch.createStarted;
		StatsUtil.generateStatsForCPS(engine, out.modelRoot).log
		info("  Stat time: " + statTime.elapsed(TimeUnit.MILLISECONDS) + " ms");
		
		assertInRangeAppTypes(constraints, engine);
		assertInRangeHostTypes(constraints, engine);
		
		// Persist model
		if(persist){
			persistModel(out);
		}
		
		fullTime.stop;
		info("Full Execution time: " + fullTime.elapsed(TimeUnit.MILLISECONDS) + " ms");
		
		
		return out;
	}
	
	def persistModel(CPSFragment out) {
		var Stopwatch persistTime = Stopwatch.createStarted;
		val filePath = "C:/output/model_"+System.nanoTime+".cyberphysicalsystem";
		PersistenceUtil.saveCPSModelToFile(out.modelRoot, filePath);
		info("  Generated Model is saved to \"" + filePath+"\"");
		persistTime.stop;
		info("  Persisting time: " + persistTime.elapsed(TimeUnit.MILLISECONDS) + " ms")
	}
}