package org.eclipse.viatra.examples.cps.tests.util

import java.io.IOException
import java.io.InputStream
import java.util.Properties
import org.apache.log4j.Level
import org.apache.log4j.Logger

class PropertiesUtil {
	
	protected static Logger logger = Logger.getLogger("cps.xform.PropertyUtil")
	static Properties properties = loadPropertiesFile
	
	public static val GIT_CLONE_LOCATION_PROP_KEY = "git.clone.location"
	public static val CPS_XFORM_LOGLEVEL_PROP_KEY = "cps.xform.loglevel"
	public static val CPS_GENERATOR_LOGLEVEL_PROP_KEY = "cps.generator.loglevel"
	public static val INCQUERY_LOGLEVEL_PROP_KEY = "org.eclipse.viatra.query.loglevel"
	public static val PERSIST_RESULTS_PROP_KEY = "cps.persist.results"
	public static val DISABLED_M2M_XFORM_PROP_KEY = "cps.xform.m2m.disabled.alternatives"
	public static val DISABLED_GENERATOR_PROP_KEY = "cps.xform.m2t.disabled.alternatives"
	public static val ENABLED_SCALES_PROP_KEY = "cps.generator.enabled.scales"
	
	public static val BENCHMARK_RESULT_LOGLEVEL = "cps.mondosam.loglevel"
	public static val STATS_CSV_LOGLEVEL = "cps.stats.loglevel"
	
	private def static loadPropertiesFile() {
		val configPath = "cps2dep.properties"
		val properties = new Properties()
        var InputStream inputStream = null
    	try {
    		//load a properties file
            inputStream = PropertiesUtil.classLoader.getResourceAsStream(configPath)
            if(inputStream !== null){
	            properties.load(inputStream);
            } else {
	    		logger.debug('''Could not find properties at «configPath»''')
            }
    	} catch (IOException ex) {
    		logger.debug('''Could not load properties at «configPath»''')
        } finally {
            if (inputStream !== null) {
                try {
                    inputStream.close()
                } catch (IOException e) {
                    logger.fatal("Should never happen!",e)
                }
            }
        }
        properties
	}
	
	def static getPropertyValue(String propertyKey, String defaultValue) {
		if(properties !== null){
			properties.getProperty(propertyKey, defaultValue)
		}
	}
	
	def static getCPSXformLogLevel(){
		getLogLevel(CPS_XFORM_LOGLEVEL_PROP_KEY, "INFO")
	}
	
	def static getCPSGeneratorLogLevel(){
		getLogLevel(CPS_GENERATOR_LOGLEVEL_PROP_KEY, "INFO")
	}
	
	def static getIncQueryLogLevel(){
		getLogLevel(INCQUERY_LOGLEVEL_PROP_KEY, "WARN")
	}
	
	def static getBenchmarkLogLevel(){
		getLogLevel(BENCHMARK_RESULT_LOGLEVEL, "WARN")
	}
	
	def static getStatsLogLevel(){
		getLogLevel(STATS_CSV_LOGLEVEL, "WARN")
	}
	
	def static isPersistResults() {
		val persist = getPropertyValue(PERSIST_RESULTS_PROP_KEY, "false")
		Boolean.valueOf(persist)
	}
	
	def static getDisabledM2MTransformations() {
		val disabledXform = getPropertyValue(DISABLED_M2M_XFORM_PROP_KEY, "none")
		disabledXform.split(",").map[trim]
	}
	def static getDisabledGeneratorTypes() {
		val disabledGenerators = getPropertyValue(DISABLED_GENERATOR_PROP_KEY, "none")
		disabledGenerators.split(",").map[trim]
	}
	def static getEnabledScales() {
		val enabledScales = getPropertyValue(ENABLED_SCALES_PROP_KEY, "1")
		enabledScales.split(",").map[trim]
	}
	
	def static getLogLevel(String key, String defaultLevel) {
		val level = getPropertyValue(key, defaultLevel)
		Level.toLevel(level, Level.WARN)
	}
	
	def static getGitCloneLocation(){
		val location = getPropertyValue(GIT_CLONE_LOCATION_PROP_KEY, "my-git-location")
		System.getProperty(GIT_CLONE_LOCATION_PROP_KEY, location)		
	}
}