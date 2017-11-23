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

package org.eclipse.viatra.examples.cps.xform.m2m.launcher;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemPackage;
import org.eclipse.viatra.examples.cps.deployment.DeploymentPackage;
import org.eclipse.viatra.examples.cps.traceability.TraceabilityPackage;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.localsearch.matcher.integration.LocalSearchHints;
import org.eclipse.viatra.query.runtime.localsearch.planner.cost.IConstraintEvaluationContext;
import org.eclipse.viatra.query.runtime.localsearch.planner.cost.impl.StatisticsBasedConstraintCostFunction;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.context.IInputKey;
import org.eclipse.viatra.query.runtime.matchers.tuple.TupleMask;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;
import org.eclipse.viatra.query.runtime.rete.matcher.ReteBackendFactory;

import com.google.common.collect.Maps;

public enum TransformationType {
    BATCH_SIMPLE {
        public CPSTransformationWrapper getWrapper() {return new BatchSimple();}
    },
    BATCH_OPTIMIZED {
        public CPSTransformationWrapper getWrapper() {return new BatchOptimized();}
    },
    BATCH_VIATRA_QUERY_RETE {
    	    public CPSTransformationWrapper getWrapper() {
    		    QueryEvaluationHint hint = new QueryEvaluationHint(null, new ReteBackendFactory());
    		    return new BatchQueryOnly(hint, hint);
	    }
    },
    BATCH_VIATRA_QUERY_LOCAL_SEARCH {
        public CPSTransformationWrapper getWrapper() {
			QueryEvaluationHint hint = LocalSearchHints.getDefaultFlatten().build();
			QueryEvaluationHint traceHint = LocalSearchHints.getDefaultFlatten().setCostFunction(new EndOfTransformationCostFunction()).build();
			return new BatchQueryLocalSearch(hint, traceHint);
	    }
    },
    BATCH_VIATRA_QUERY_LOCAL_SEARCH_GENERIC {
        public CPSTransformationWrapper getWrapper() {
            QueryEvaluationHint hint = LocalSearchHints.getDefaultGeneric().setCostFunction(new EndOfTransformationCostFunction()).build();
            return new BatchQueryLocalSearch(hint, hint);
        }
    },
    BATCH_VIATRA_QUERY_LOCAL_SEARCH_WO_INDEXER {
        public CPSTransformationWrapper getWrapper() {
            QueryEvaluationHint hint = LocalSearchHints.getDefaultNoBase().build();
			return new BatchQueryLocalSearch(hint, hint);
        }
    },
    BATCH_VIATRA_TRANSFORMATION {
        public CPSTransformationWrapper getWrapper() {return new BatchViatra();}

        @Override
        public boolean isDebuggable() {
            return true;
        }
    },
    INCR_VIATRA_QUERY_RESULT_TRACEABILITY {
        public CPSTransformationWrapper getWrapper() {return new QueryResultTraceability();}
    },
    INCR_VIATRA_EXPLICIT_TRACEABILITY {
        public CPSTransformationWrapper getWrapper() {return new ExplicitTraceability();}
    },
    INCR_VIATRA_AGGREGATED {
        public CPSTransformationWrapper getWrapper() {return new PartialBatch();}
    },
    INCR_VIATRA_TRANSFORMATION {
        public CPSTransformationWrapper getWrapper() {return new ViatraTransformation();}

        @Override
        public boolean isDebuggable() {
            return true;
        }
    };

    private final class EndOfTransformationCostFunction extends StatisticsBasedConstraintCostFunction {
        final Map<IInputKey, IInputKey> substitutions;

        public EndOfTransformationCostFunction() {
            super();
            substitutions = Maps.newHashMap();
            substitutions.put(new EClassTransitiveInstancesKey(TraceabilityPackage.Literals.CPS2_DEPLOYMENT_TRACE), new EClassTransitiveInstancesKey(CyberPhysicalSystemPackage.Literals.IDENTIFIABLE));
            substitutions.put(new EClassTransitiveInstancesKey(DeploymentPackage.Literals.DEPLOYMENT_ELEMENT), new EClassTransitiveInstancesKey(CyberPhysicalSystemPackage.Literals.IDENTIFIABLE));
            substitutions.put(new EStructuralFeatureInstancesKey(TraceabilityPackage.Literals.CPS2_DEPLOYMENT_TRACE__CPS_ELEMENTS), new EClassTransitiveInstancesKey(CyberPhysicalSystemPackage.Literals.IDENTIFIABLE));
            substitutions.put(new EStructuralFeatureInstancesKey(TraceabilityPackage.Literals.CPS2_DEPLOYMENT_TRACE__DEPLOYMENT_ELEMENTS), new EClassTransitiveInstancesKey(CyberPhysicalSystemPackage.Literals.IDENTIFIABLE));
            substitutions.put(new EStructuralFeatureInstancesKey(TraceabilityPackage.Literals.CPS_TO_DEPLOYMENT__TRACES), new EClassTransitiveInstancesKey(CyberPhysicalSystemPackage.Literals.IDENTIFIABLE));
        }

        @Override
        public long countTuples(IConstraintEvaluationContext input, IInputKey supplierKey) {
            if (supplierKey instanceof EClassTransitiveInstancesKey){
                EClass eclass = ((EClassTransitiveInstancesKey) supplierKey).getEmfKey();
                if (TraceabilityPackage.Literals.CPS_TO_DEPLOYMENT.equals(eclass)){
                    return 1l;
                }
            }
            if (substitutions.containsKey(supplierKey)){
                return input.getRuntimeContext().countTuples(substitutions.get(supplierKey), TupleMask.empty(supplierKey.getArity()), Tuples.staticArityFlatTupleOf());
            }
            
            return input.getRuntimeContext().countTuples(supplierKey, TupleMask.empty(supplierKey.getArity()), Tuples.staticArityFlatTupleOf());
        }
    }

    public abstract CPSTransformationWrapper getWrapper();

    public boolean isDebuggable() {
        return false;
    }
}
