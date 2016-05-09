/*******************************************************************************
 * Copyright (c) 2014, 2016, IncQuery Labs Ltd. 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Akos Horvath, Abel Hegedus, Tamas Borbas, Marton Bur, Zoltan Ujhelyi, Robert Doczi, Daniel Segesdi, Peter Lunk - initial API and implementation
 *******************************************************************************/

package org.eclipse.viatra.examples.cps.xform.m2m.tests.wrappers;

import org.eclipse.viatra.examples.cps.xform.m2m.tests.wrappers.BatchIncQuery;
import org.eclipse.viatra.examples.cps.xform.m2m.tests.wrappers.BatchOptimized;
import org.eclipse.viatra.examples.cps.xform.m2m.tests.wrappers.BatchSimple;
import org.eclipse.viatra.examples.cps.xform.m2m.tests.wrappers.BatchViatra;
import org.eclipse.viatra.examples.cps.xform.m2m.tests.wrappers.CPSTransformationWrapper;
import org.eclipse.viatra.examples.cps.xform.m2m.tests.wrappers.ExplicitTraceability;
import org.eclipse.viatra.examples.cps.xform.m2m.tests.wrappers.PartialBatch;
import org.eclipse.viatra.examples.cps.xform.m2m.tests.wrappers.QueryResultTraceability;
import org.eclipse.viatra.examples.cps.xform.m2m.tests.wrappers.ViatraTransformation;

public enum TransformationType {
    BATCH_SIMPLE {public CPSTransformationWrapper getWrapper() {return new BatchSimple();} public boolean isIncremental(){return false;}},
    BATCH_OPTIMIZED {public CPSTransformationWrapper getWrapper() {return new BatchOptimized();} public boolean isIncremental(){return false;}},
    BATCH_INCQUERY {public CPSTransformationWrapper getWrapper() {return new BatchIncQuery();} public boolean isIncremental(){return false;}},
    BATCH_VIATRA {public CPSTransformationWrapper getWrapper() {return new BatchViatra();} public boolean isIncremental(){return false;}},
    INCR_QUERY_RESULT_TRACEABILITY {public CPSTransformationWrapper getWrapper() {return new QueryResultTraceability();} public boolean isIncremental(){return true;}},
    INCR_EXPLICIT_TRACEABILITY {public CPSTransformationWrapper getWrapper() {return new ExplicitTraceability();} public boolean isIncremental(){return true;}},
    INCR_AGGREGATED {public CPSTransformationWrapper getWrapper() {return new PartialBatch();} public boolean isIncremental(){return true;}},
    INCR_VIATRA {public CPSTransformationWrapper getWrapper() {return new ViatraTransformation();} public boolean isIncremental(){return true;}};
    
    public abstract CPSTransformationWrapper getWrapper();
    public abstract boolean isIncremental();
}
