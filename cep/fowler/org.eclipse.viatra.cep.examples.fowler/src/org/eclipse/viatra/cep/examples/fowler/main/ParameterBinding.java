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
import org.eclipse.viatra.cep.examples.fowler.model.events.DWCL_2_Event;
import org.eclipse.viatra.cep.examples.fowler.model.events.DWOP_2_Event;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Example scenario demonstrating parameter bindings in the VEPL.
 * 
 * @see <a href="https://wiki.eclipse.org/VIATRA/CEP/Examples/SimpleEventProcessing">
 *      https://wiki.eclipse.org/VIATRA/CEP/Examples/SimpleEventProcessing</a>
 * 
 * @author Istvan David
 *
 */
public class ParameterBinding extends DefaultApplication {

    /**
     * The {@link DefaultRealm} is required to run the JUnit plug-in tests seamlessly. For details, see
     * https://wiki.eclipse.org/JFace_Data_Binding/Realm.
     */
    private DefaultRealm defaultRealm;

    public ParameterBinding() {
        super(EventContext.CHRONICLE, CepFactory.getInstance().rule_OpenSC3_2());
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
    public void test() throws InterruptedException {
        getEngine().setCepEngineDebugLevel(Level.DEBUG);

        getEngine().getLogger().info("staring");
        // Pushing events to the event stream which will deliver them to the engine.

        DWOP_2_Event dwop_Event_1 = CepFactory.getInstance().createDWOP_2_Event();
        dwop_Event_1.setId("dw_drawer#1");
        getEventStream().push(dwop_Event_1);
        Thread.sleep(1000l);

        DWCL_2_Event dwcl_Event_1 = CepFactory.getInstance().createDWCL_2_Event();
        dwcl_Event_1.setId("dw_drawer#1");
        getEventStream().push(dwcl_Event_1);
        Thread.sleep(1000l);

        DWOP_2_Event dwop_Event_2 = CepFactory.getInstance().createDWOP_2_Event();
        dwop_Event_2.setId("dw_drawer#1");
        getEventStream().push(dwop_Event_2);
        Thread.sleep(1000l);

        DWCL_2_Event dwcl_Event_2 = CepFactory.getInstance().createDWCL_2_Event();
        dwcl_Event_2.setId("dw_drawer#1");
        getEventStream().push(dwcl_Event_2);

        // Some debug information about the end of the process.
        getEngine().getLogger().info("ending");
    }
}
