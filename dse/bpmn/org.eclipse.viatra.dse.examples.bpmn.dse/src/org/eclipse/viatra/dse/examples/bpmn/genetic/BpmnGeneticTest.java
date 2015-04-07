package org.eclipse.viatra.dse.examples.bpmn.genetic;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Test;

public class BpmnGeneticTest {

    @Test
    public void test() throws Exception {
        BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.ERROR);
        Logger.getLogger(this.getClass()).setLevel(Level.ALL);
        
        new BpmnGeneticTestRunner() {

            @Override
            public int getNumberOfTokens() {
                return 100;
            }

            @Override
            public int getRateOfTokens() {
                return 20;
            }
        }.runTests();
    }

}
