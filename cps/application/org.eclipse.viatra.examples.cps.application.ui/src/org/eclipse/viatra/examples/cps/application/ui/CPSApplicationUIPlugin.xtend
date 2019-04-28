/*******************************************************************************
 * Copyright (c) 2010-2017, Marton Elekes, IncQuery Labs Ltd.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.application.ui

import org.eclipse.core.runtime.ILog
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Status
import org.eclipse.jface.resource.ImageRegistry
import org.eclipse.ui.plugin.AbstractUIPlugin
import org.osgi.framework.BundleContext

/**
 * The activator class controls the plug-in life cycle
 * @author Marton Elekes
 */
class CPSApplicationUIPlugin extends AbstractUIPlugin {

    public static val String PLUGIN_ID = "org.eclipse.viatra.examples.cps.application.ui"

    private static CPSApplicationUIPlugin plugin

    public static val ICON_LOAD_QUERY = "load_query"
    public static val ICON_STOP = "stop"
    public static val CPS_NEW = "NewCyberPhysicalSystem"
    public static val LOAD_XFORM_W_DEBUGGER = "load_xform_w_debugger"

    public override void start(BundleContext context) throws Exception {
        super.start(context)
        plugin = this
    }

    public override void stop(BundleContext context) throws Exception {
        plugin = null
        super.stop(context)
    }

    public def static CPSApplicationUIPlugin getDefault() {
        return plugin
    }

    protected override void initializeImageRegistry(ImageRegistry reg) {
        super.initializeImageRegistry(reg)
        reg => [
            put(ICON_LOAD_QUERY,
                imageDescriptorFromPlugin("org.eclipse.viatra.query.tooling.ui.browser", "/icons/load_query.png"))
            put(ICON_STOP, imageDescriptorFromPlugin("org.eclipse.viatra.query.tooling.ui", "/icons/unload.gif"))
            put(CPS_NEW, imageDescriptorFromPlugin("org.eclipse.viatra.examples.cps.model.editor",
                "/icons/full/wizban/NewCyberPhysicalSystem.gif"))
            put(LOAD_XFORM_W_DEBUGGER, imageDescriptorFromPlugin(PLUGIN_ID, "/icons/load_xform_w_debugger.png"))
        ]
    }

    def void logException(String message, Throwable exception) {
        var ILog logger = getLog()
        logger.log(new Status(IStatus.ERROR, PLUGIN_ID, message, exception))
    }
}
