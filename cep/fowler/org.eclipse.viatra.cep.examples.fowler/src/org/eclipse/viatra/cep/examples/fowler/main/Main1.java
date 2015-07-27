package org.eclipse.viatra.cep.examples.fowler.main;

import org.apache.log4j.Level;
import org.eclipse.viatra.cep.core.api.helpers.DefaultApplication;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.examples.fowler.internal.DefaultRealm;
import org.eclipse.viatra.cep.examples.fowler.model.CepFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Main1 extends DefaultApplication {

    /**
     * The {@link DefaultRealm} is required to run the JUnit plug-in tests seamlessly. For details, see
     * https://wiki.eclipse.org/JFace_Data_Binding/Realm.
     */
    private DefaultRealm defaultRealm;

    public Main1() {
        super(EventContext.CHRONICLE, CepFactory.getInstance().rule_OpenSC1());
    }

    @Before
    public void setUp() {
        defaultRealm = new DefaultRealm();
    }

    @After
    public void tearDown() {
        defaultRealm.dispose();
    }

    @Test
    public void test() {
        getEngine().setCepEngineDebugLevel(Level.DEBUG);

        getEngine().getLogger().info("staring");
        // Pushing events to the event stream which will deliver them to the
        // engine.
        getEventStream().push(CepFactory.getInstance().createDOOP_Event());
        getEventStream().push(CepFactory.getInstance().createLION_Event());
        getEventStream().push(CepFactory.getInstance().createDWOP_Event());

        // Some debug information about the end of the process.
        getEngine().getLogger().info("ending");
    }
}
