package org.eclipse.viatra.examples.cps.tests

import java.io.OutputStreamWriter
import org.apache.log4j.ConsoleAppender
import org.apache.log4j.FileAppender
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.log4j.PatternLayout
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage
import org.eclipse.viatra.examples.cps.deployment.DeploymentPackage
import org.eclipse.viatra.examples.cps.generator.dtos.ModelStats
import org.eclipse.viatra.examples.cps.traceability.TraceabilityPackage
import org.junit.BeforeClass

class CPSTestBase {
	
	protected val instancesDirPath = "file://" + PropertiesUtil.getGitCloneLocation + "/models/org.eclipse.viatra.examples.cps.instances/"
	
	val static STATS_LAYOUT = "%c{1}" + ModelStats.DELIMITER + "%m%n";
	val static COMMON_LAYOUT = "%c{1} - %m%n";
	val static FILE_LOG_LAYOUT_PREFIX = "[%d{MMM/dd HH:mm:ss}] ";
	
	@BeforeClass
	def static setupRootLogger() {
		doStandaloneEMFSetup()
		
		Logger.getLogger("cps.xform").level = PropertiesUtil.getCPSXformLogLevel
		Logger.getLogger("cps.generator").initLoggerForLevel(PropertiesUtil.getCPSGeneratorLogLevel, COMMON_LAYOUT)
		Logger.getLogger("cps.performance.generator.Tests").initLoggerForLevel(PropertiesUtil.getCPSGeneratorLogLevel, COMMON_LAYOUT)
		Logger.getLogger("org.eclipse.viatra.query").level = PropertiesUtil.getIncQueryLogLevel
		Logger.getLogger("cps.mondosam").initLoggerForLevel(PropertiesUtil.getBenchmarkLogLevel, COMMON_LAYOUT)
		Logger.getLogger("cps.stats").initLoggerForLevel(PropertiesUtil.getStatsLogLevel, STATS_LAYOUT)
		Logger.getLogger("cps.proto").initLoggerForLevel(PropertiesUtil.getCPSGeneratorLogLevel, COMMON_LAYOUT)
	}
	
	def static doStandaloneEMFSetup() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		
		CyberPhysicalSystemPackage.eINSTANCE.eClass
		DeploymentPackage.eINSTANCE.eClass
		TraceabilityPackage.eINSTANCE.eClass
	}
	
	def static initLoggerForLevel(Logger logger, Level level, String patternLayout) {
		var ConsoleAppender ca = new ConsoleAppender();
		val logFilePath = "./results/log/log.log";
		val fileAppender = new FileAppender(new PatternLayout(patternLayout+FILE_LOG_LAYOUT_PREFIX),logFilePath,true);
		fileAppender.threshold = Level.DEBUG;
		ca.setWriter(new OutputStreamWriter(System.out));
		ca.setLayout(new PatternLayout(patternLayout));
		logger.setAdditivity(false);
		logger.removeAllAppenders();
		logger.addAppender(ca);
		logger.addAppender(fileAppender);
		logger.setLevel(level);
	}
}
