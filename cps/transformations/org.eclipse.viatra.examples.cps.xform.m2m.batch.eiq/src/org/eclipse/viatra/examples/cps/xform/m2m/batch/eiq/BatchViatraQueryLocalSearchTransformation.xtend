package org.eclipse.viatra.examples.cps.xform.m2m.batch.eiq

import java.util.Map
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationInstance
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.ApplicationType
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.Transition
import org.eclipse.viatra.examples.cps.deployment.DeploymentHost
import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint

class BatchViatraQueryLocalSearchTransformation extends CPS2DeploymentBatchTransformationEiq {

    Map<String, ApplicationType> appTypes
    
    new(CPSToDeployment mapping, AdvancedViatraQueryEngine engine, QueryEvaluationHint hint, QueryEvaluationHint tracesHint) {
        super(mapping, engine, hint, tracesHint)
    }
    
    override execute() {
        appTypes = newHashMap
        super.execute()
        appTypes = null
    }
    
    override protected transform(ApplicationInstance cpsInstance, DeploymentHost depHost) {
        val appType = cpsInstance.type
        val appTypeIdId = appType.identifier
        if(!appTypes.containsKey(appTypeIdId)){
            appTypes.put(appTypeIdId, appType)
        }
        
        super.transform(cpsInstance, depHost)
    }
    
    override protected getWaitTransitionsForSendTransition(Transition cpsSendTransition) {
        val sendTransitionMatch = engine.getMatcher(sendTransitionAppSignal, hint).getOneArbitraryMatch(cpsSendTransition, null, null)
        if(sendTransitionMatch == null){
            return emptySet
        }
        val app = appTypes.get(sendTransitionMatch.app)
        if(app == null){
            return emptySet
        }
        return engine.getMatcher(waitTransitionAppSignal, hint).getAllValuesOftransition(app, sendTransitionMatch.signal)
    }
    
}