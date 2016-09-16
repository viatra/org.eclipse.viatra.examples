package org.eclipse.viatra.examples.cps.xform.m2m.batch.eiq

import com.google.common.collect.Multimap
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition
import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint
import com.google.common.collect.HashMultimap

class BatchViatraQueryLocalSearchTransformation extends CPS2DeploymentBatchTransformationEiq {

    Multimap<Transition, Transition> transitions
    
    new(CPSToDeployment mapping, AdvancedViatraQueryEngine engine, QueryEvaluationHint hint, QueryEvaluationHint tracesHint) {
        super(mapping, engine, hint, tracesHint)
    }
    
    override protected transformActions() {
        
        transitions = HashMultimap.create
        
        engine.getMatcher(triggerPair, hint).forEachMatch[
            transitions.put(cpsTrigger, cpsTarget)
        ]
        
        super.transformActions()
        
    }
    
    override protected getWaitTransitionsForSendTransition(Transition cpsSendTransition) {
        transitions.get(cpsSendTransition)
    }
    
}