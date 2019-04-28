/*******************************************************************************
 * Copyright (c) 2004-2011 Abel Hegedus, Istvan Rath and Daniel Varro
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-v20.html.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.viatra.query.application.patternspecific;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.viatra.query.application.common.ViatraQueryHeadless;

/**
 * @author Abel Hegedus
 * @author Istvan Rath
 * 
 */
public class PatternSpecificViatraQueryApplication {

	private static String modelParam = "-m";

	public static void main(String[] args) {

		String model = null;
		if (args == null || args.length == 0) {
			displayHelp();
			return;
		}
		int i = 0;
		while (i < args.length) {
			if (args[i].equals(modelParam)) {
				model = args[i + 1];
				i += 2;
				continue;
			}
			else {
				i++;
				continue;
			}
		}

		if (model == null) {
		  System.out.println("Model parameter not set");
			displayHelp();
			return;
		}

		// Initializing metamodel        
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		
		ViatraQueryHeadless hl = new ViatraQueryHeadless();
		System.out.println(hl.executeDemo(model));
		System.out.println(hl.executeDemo_PatternGroups(model));
		System.out.println(hl.executeTrackChangesDemo(model));
		
		
		
	}

	private static void displayHelp() {
		System.out.println("Usage:\n<call> -m <modelFilePAth> \n  -m    :  Required, the model to match on.");
	}
}
