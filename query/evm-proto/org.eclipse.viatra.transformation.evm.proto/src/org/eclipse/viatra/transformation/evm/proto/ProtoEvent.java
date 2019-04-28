/*******************************************************************************
 * Copyright (c) 2010-2013, Abel Hegedus, Istvan Rath and Daniel Varro
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.transformation.evm.proto;

import org.eclipse.viatra.transformation.evm.api.event.Event;
import org.eclipse.viatra.transformation.evm.api.event.EventType;

/**
 * @author Abel Hegedus
 *
 */
public class ProtoEvent implements Event<String> {

    private ProtoEventType type;
    private String atom;
    
    @Override
    public EventType getEventType() {
        return type;
    }

    @Override
    public String getEventAtom() {
        return atom;
    }

    /**
     * 
     */
    public ProtoEvent(ProtoEventType type, String atom) {
        this.type = type;
        this.atom = atom;
    }
    
}
