/*******************************************************************************
 * Copyright (c) 2004-2015, Istvan David, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Istvan David - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.cep.examples.fowler.main;

import org.apache.log4j.Level;
import org.eclipse.viatra.cep.core.api.helpers.DefaultApplication;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.examples.fowler.internal.DefaultRealm;
import org.eclipse.viatra.cep.examples.fowler.model.CepFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Example scenario demonstrating basics of event processing in VIATRA-CEP.
 * 
 * @see <a href="https://wiki.eclipse.org/VIATRA/CEP/Examples/SimpleEventProcessing">
 *      https://wiki.eclipse.org/VIATRA/CEP/Examples/SimpleEventProcessing</a>
 * 
 * @author Istvan David
 *
 */
public class Basics extends DefaultApplication {

    /**
     * The {@link DefaultRealm} is required to run the JUnit plug-in tests seamlessly. For details, see
     * https://wiki.eclipse.org/JFace_Data_Binding/Realm.
     */
    private DefaultRealm defaultRealm;

    public Basics() {
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
