/*******************************************************************************
 * Copyright (c) 2010-2013, Abel Hegedus, Istvan Rath and Daniel Varro
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.transformation.evm.proto;

import org.eclipse.viatra.transformation.evm.api.RuleInstance;
import org.eclipse.viatra.transformation.evm.api.event.AbstractRuleInstanceBuilder;
import org.eclipse.viatra.transformation.evm.api.event.EventFilter;
import org.eclipse.viatra.transformation.evm.api.event.EventRealm;
import org.eclipse.viatra.transformation.evm.api.event.EventSourceSpecification;

/**
 * @author Abel Hegedus
 *
 */
public class ProtoEventSourceSpecification implements EventSourceSpecification<String> {

    private String prefix;

    @Override
    public EventFilter<String> createEmptyFilter() {
        return new ProtoEventFilter(prefix);
    }

    @Override
    public AbstractRuleInstanceBuilder<String> getRuleInstanceBuilder(final EventRealm realm) {
        return new AbstractRuleInstanceBuilder<String>() {
            
            @Override
            public void prepareRuleInstance(RuleInstance<String> ruleInstance, EventFilter<? super String> filter) {
                ProtoEventSource source = new ProtoEventSource(ProtoEventSourceSpecification.this, (ProtoRealm) realm);
                ProtoEventHandler handler = new ProtoEventHandler(source, (ProtoEventFilter) filter, ruleInstance);
                source.addHandler(handler);
            }
        };
    }
    
    /**
     * 
     */
    public ProtoEventSourceSpecification(String prefix) {
        this.prefix = prefix;
    }

}
