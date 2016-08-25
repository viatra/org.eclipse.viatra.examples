/*******************************************************************************
 * Copyright (c) 2014-2016, IncQuery Labs Ltd. 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Akos Horvath, Abel Hegedus, Tamas Borbas, Marton Bur, Zoltan Ujhelyi, Robert Doczi, Daniel Segesdi, Peter Lunk - initial API and implementation
 *******************************************************************************/

package org.eclipse.viatra.examples.cps.xform.m2m.tests.wrappers;

import org.eclipse.viatra.query.runtime.localsearch.matcher.integration.LocalSearchHints;
import org.eclipse.viatra.query.runtime.localsearch.planner.cost.impl.VariableBindingBasedCostFunction;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.rete.matcher.ReteBackendFactory;

import com.google.common.collect.ImmutableMap;

public enum TransformationType {
    BATCH_SIMPLE {public CPSTransformationWrapper getWrapper() {return new BatchSimple();} public boolean isIncremental(){return false;}},
    BATCH_OPTIMIZED {public CPSTransformationWrapper getWrapper() {return new BatchOptimized();} public boolean isIncremental(){return false;}},
    BATCH_VIATRA_QUERY_RETE {
    	public CPSTransformationWrapper getWrapper() {
    		QueryEvaluationHint hint = new QueryEvaluationHint(new ReteBackendFactory(), ImmutableMap.<String, Object>of());
	    	return new BatchQueryOnly(hint);
	    }
    	public boolean isIncremental(){return false;}
    },
    BATCH_VIATRA_QUERY_LOCAL_SEARCH {
    	public CPSTransformationWrapper getWrapper() {
	    	return new BatchQueryOnly(LocalSearchHints.getDefaultFlatten().build());
	    }
    	public boolean isIncremental(){return false;}
    },
    BATCH_VIATRA_QUERY_LOCAL_SEARCH_NO_FLAT {
        public CPSTransformationWrapper getWrapper() {
            return new BatchQueryOnly(LocalSearchHints.getDefault().build());
        }
        public boolean isIncremental(){return false;}
    },
    BATCH_VIATRA_QUERY_LOCAL_SEARCH_DUMB_PLANNER {
        public CPSTransformationWrapper getWrapper() {
            return new BatchQueryOnly(LocalSearchHints.getDefaultFlatten().setCostFunction(new VariableBindingBasedCostFunction()).build());
        }
        public boolean isIncremental(){return false;}
    },
    BATCH_VIATRA_QUERY_LOCAL_SEARCH_STATISTICS {
    	public CPSTransformationWrapper getWrapper() {
    		QueryEvaluationHint hint = new QueryEvaluationHint(LocalSearchBackendFactory.INSTANCE, ImmutableMap.<String, Object>of(
    				LocalSearchHintKeys.ALLOW_INVERSE_NAVIGATION, Boolean.FALSE,
    				LocalSearchHintKeys.USE_BASE_INDEX, Boolean.FALSE
    				));
    		return new BatchQueryOnly(hint);
    	}
    	public boolean isIncremental(){return false;}
    },
    BATCH_VIATRA_QUERY_LOCAL_SEARCH_WO_INDEXER {
        public CPSTransformationWrapper getWrapper() {
            return new BatchQueryOnly(LocalSearchHints.getDefaultNoBase().build());
        }
        public boolean isIncremental(){return false;}
    },
    BATCH_VIATRA_TRANSFORMATION {public CPSTransformationWrapper getWrapper() {return new BatchViatra();} public boolean isIncremental(){return false;}},
    INCR_VIATRA_QUERY_RESULT_TRACEABILITY {public CPSTransformationWrapper getWrapper() {return new QueryResultTraceability();} public boolean isIncremental(){return true;}},
    INCR_VIATRA_EXPLICIT_TRACEABILITY {public CPSTransformationWrapper getWrapper() {return new ExplicitTraceability();} public boolean isIncremental(){return true;}},
    INCR_VIATRA_AGGREGATED {public CPSTransformationWrapper getWrapper() {return new PartialBatch();} public boolean isIncremental(){return true;}},
    INCR_VIATRA_TRANSFORMATION {public CPSTransformationWrapper getWrapper() {return new ViatraTransformation();} public boolean isIncremental(){return true;}};
    
    public abstract CPSTransformationWrapper getWrapper();
    public abstract boolean isIncremental();
}
