package org.eclipse.viatra.examples.cps.generator.operations

import org.eclipse.viatra.examples.cps.generator.dtos.CPSFragment
import org.eclipse.viatra.examples.cps.generator.dtos.constraints.ICPSConstraints
import org.eclipse.viatra.examples.cps.generator.utils.RandomUtils
import org.eclipse.viatra.examples.cps.planexecutor.api.IOperation

class SignalCalculationOperation implements IOperation<CPSFragment> {
	
	private extension RandomUtils randUtil
	
	new(){
		randUtil = new RandomUtils;
	}
	
	override execute(CPSFragment fragment) {
		var constraints = fragment.input.constraints as ICPSConstraints;
		var numberOfSignals = constraints.numberOfSignals.randInt(fragment.random);
		fragment.setNumberOfSignals(numberOfSignals);
		return true;
	}
	
}