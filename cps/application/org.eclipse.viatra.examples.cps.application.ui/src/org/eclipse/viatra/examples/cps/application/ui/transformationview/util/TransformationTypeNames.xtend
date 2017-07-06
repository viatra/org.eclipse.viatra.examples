/*******************************************************************************
 * Copyright (c) 2010-2017, Marton Elekes, IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Marton Elekes - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.application.ui.transformationview.util

import org.eclipse.viatra.examples.cps.xform.m2m.launcher.TransformationType

/**
 * Utility class to get friendly names and filter for the transformations in {@linkplain org.eclipse.viatra.examples.cps.xform.m2m.tests.wrappers.TransformationType TransformationType}.
 * @author Marton Elekes
 * 
 */
class TransformationTypeNames {
    /**
     * Returns friendly name if available, otherwise, uses the {@linkplain Enum#toString toString} method.
     */
    static def String getFriendlyName(TransformationType type) {
        switch (type) {
            case BATCH_SIMPLE: "Xtend"
            case BATCH_OPTIMIZED: "Xtend (optimized)"
            case BATCH_VIATRA_QUERY_RETE: "Xtend + VIATRA Query (Rete)"
            case BATCH_VIATRA_QUERY_LOCAL_SEARCH: "Xtend + VIATRA Query (local search)"
            case BATCH_VIATRA_TRANSFORMATION: "VIATRA Batch API"
            case INCR_VIATRA_QUERY_RESULT_TRACEABILITY: "Query result traceability (incr.)"
            case INCR_VIATRA_EXPLICIT_TRACEABILITY: "Explicit traceability (incr.)"
            case INCR_VIATRA_AGGREGATED: "Partial batch (incr.)"
            case INCR_VIATRA_TRANSFORMATION: "VIATRA EMF-based API (incr.)"
            default: type.toString
        }
    }

    /**
     * Returns true if the selected transformation should be shown on the UI, otherwise, false.
     */
    static def boolean shouldShowOnUi(TransformationType type) {
        switch (type) {
            case BATCH_SIMPLE,
            case BATCH_OPTIMIZED,
            case BATCH_VIATRA_QUERY_RETE,
            case BATCH_VIATRA_QUERY_LOCAL_SEARCH,
            case BATCH_VIATRA_TRANSFORMATION,
            case INCR_VIATRA_QUERY_RESULT_TRACEABILITY,
            case INCR_VIATRA_EXPLICIT_TRACEABILITY,
            case INCR_VIATRA_AGGREGATED,
            case INCR_VIATRA_TRANSFORMATION: true
            default: false
        }
    }
}
