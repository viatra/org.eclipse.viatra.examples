/*******************************************************************************
 * Copyright (c) 2010-2013, Abel Hegedus, Istvan Rath and Daniel Varro
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.transformation.evm.proto;

import java.util.Set;

import org.eclipse.viatra.transformation.evm.api.event.EventRealm;

import com.google.common.collect.Sets;

/**
 * @author Abel Hegedus
 *
 */
public class ProtoRealm implements EventRealm {

    private Set<ProtoEventSource> sources = Sets.newHashSet();
    
    /**
     * 
     */
    public ProtoRealm() {
    }
    
    public void pushString(String push) {
        for (ProtoEventSource source : sources) {
            source.pushString(push);
        }
    }

    protected void addSource(ProtoEventSource source) {
        sources.add(source);
    }
}
