/*******************************************************************************
 * Copyright (c) 2014-2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Akos Menyhert, Tamas Borbas, Marton Bur, Zoltan Ujhelyi, Daniel Segesdi - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.tests;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.viatra.query.runtime.localsearch.matcher.integration.LocalSearchBackendFactory;
import org.eclipse.viatra.query.runtime.localsearch.matcher.integration.LocalSearchHintKeys;
import org.eclipse.viatra.query.runtime.matchers.backend.IQueryBackendFactory;
import org.eclipse.viatra.query.runtime.matchers.backend.IQueryBackendHintProvider;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.rewriters.IFlattenCallPredicate;
import org.eclipse.viatra.query.runtime.rete.matcher.ReteBackendFactory;

import com.google.common.collect.Maps;

public enum BackendType {
    Rete, LocalSearch,
    
    LocalSearch_NoFlat;
    
    public IQueryBackendFactory getNewBackendInstance() {
        switch(this) {
            case Rete: return new ReteBackendFactory();
            case LocalSearch_NoFlat:
            case LocalSearch: 
                return LocalSearchBackendFactory.INSTANCE;
            default: return null;
        }
    }
    
    public QueryEvaluationHint getHints(){
        Map<String, Object> hints = new HashMap<>();
        switch(this){
        case LocalSearch_NoFlat:
            hints.put(LocalSearchHintKeys.FLATTEN_CALL_PREDICATE, new IFlattenCallPredicate() {
                
                @Override
                public boolean shouldFlatten(PositivePatternCall positivePatternCall) {
                    return false;
                }
            });
            break;
        default:
            break;
        }
        return new QueryEvaluationHint(getNewBackendInstance(), Collections.<String, Object>emptyMap());
    }
}
