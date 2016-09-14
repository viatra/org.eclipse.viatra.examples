package org.eclipse.viatra.examples.cps.xform.m2m.tests.wrappers;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.examples.cps.traceability.TraceabilityPackage;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.localsearch.planner.cost.IConstraintEvaluationContext;
import org.eclipse.viatra.query.runtime.localsearch.planner.cost.impl.StatisticsBasedConstraintCostFunction;
import org.eclipse.viatra.query.runtime.matchers.context.IInputKey;

final class TraceabilitySubstitutingStatisticsBasedConstraintCostFunction extends StatisticsBasedConstraintCostFunction {
	private final Map<IInputKey, IInputKey> substitutions;

	TraceabilitySubstitutingStatisticsBasedConstraintCostFunction(Map<IInputKey, IInputKey> substitutions) {
		this.substitutions = substitutions;
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
	        return input.getRuntimeContext().countTuples(substitutions.get(supplierKey), null);
	    }
	    
	    return input.getRuntimeContext().countTuples(supplierKey, null);
	}
}