/*******************************************************************************
 * Copyright (c) 2014, 2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Akos Menyhert, Zoltan Ujhelyi - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.applications.statemachines;

import java.util.List;

import org.eclipse.viatra.examples.cps.m2t.proto.distributed.general.applications.Application;

public interface State<StateType extends State> {
	List<State<StateType>> possibleNextStates(Application app);
	StateType stepTo(StateType nextState, Application app);
}
