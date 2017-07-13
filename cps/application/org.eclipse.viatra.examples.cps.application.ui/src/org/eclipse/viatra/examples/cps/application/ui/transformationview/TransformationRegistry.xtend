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
package org.eclipse.viatra.examples.cps.application.ui.transformationview

import java.util.HashMap
import java.util.HashSet
import java.util.Map
import java.util.Set
import org.eclipse.ui.IEditorPart
import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment
import org.eclipse.viatra.examples.cps.xform.m2m.launcher.TransformationType
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.viatra.examples.cps.application.ui.transformationview.util.TransformationConnector

/**
 * Stores the currently active transformations on {@link CPSToDeployment} models.
 * @author Marton Elekes
 */
class TransformationRegistry {
    
    /**
     * Protected constructor to prevent creating other instances of the singleton.
     */
    protected new() {
    }

    @Accessors
    TransformationType newTransformationType = TransformationType.BATCH_VIATRA_TRANSFORMATION
    
    def void setNewTransformationType(TransformationType newTransformationType) {
        this.newTransformationType = newTransformationType;
        listeners.forEach[transformationTypeChanged(newTransformationType)]
    }

    private static class LazyHolder {
        final static TransformationRegistry INSTANCE = new TransformationRegistry()
    }

    def static TransformationRegistry getInstance() {
        return LazyHolder.INSTANCE
    }

    Map<IEditorPart, TransformationConnector> transformationMap = new HashMap()

    def TransformationConnector get(IEditorPart part) {
        return transformationMap.get(part)
    }

    def boolean containsKey(IEditorPart part) {
        return transformationMap.containsKey(part)
    }

    def void put(IEditorPart part, TransformationConnector connector) {
        transformationMap.put(part, connector)
        listeners.forEach[transformationAdded(connector)]
    }

    def void remove(IEditorPart part) {
        val removed = transformationMap.remove(part)
        listeners.forEach[transformationRemoved(removed)]
    }

    val Set<ITransformationRegistryListener> listeners = new HashSet;

    def boolean addListener(ITransformationRegistryListener listener, boolean notifyForCurrentElements) {
        val added = listeners.add(listener)
        
        if (notifyForCurrentElements) {
            transformationMap.values.forEach[listener.transformationAdded(it)]
            listener.transformationTypeChanged(newTransformationType)
        }
            
        return added
    }

    def boolean removeListener(ITransformationRegistryListener listener) {
        listeners.remove(listener)
    }
}
