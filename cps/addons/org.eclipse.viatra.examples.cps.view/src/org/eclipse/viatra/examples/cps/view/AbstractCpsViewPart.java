/*******************************************************************************
 * Copyright (c) 2014-2016 IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Akos Horvath, Abel Hegedus, Zoltan Ujhelyi - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.examples.cps.view;

import java.util.Collection;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gef.layout.ILayoutAlgorithm;
import org.eclipse.gef.layout.algorithms.SpaceTreeLayoutAlgorithm;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.viatra.addon.viewers.runtime.model.ViatraViewerDataModel;
import org.eclipse.viatra.addon.viewers.runtime.model.ViewerDataFilter;
import org.eclipse.viatra.addon.viewers.runtime.model.ViewerState;
import org.eclipse.viatra.addon.viewers.runtime.model.ViewerState.ViewerStateFeature;
import org.eclipse.viatra.addon.viewers.runtime.zest.ViatraGraphViewers;
import org.eclipse.viatra.examples.cps.cyberPhysicalSystem.presentation.CyberPhysicalSystemEditor;
import org.eclipse.viatra.integration.zest.viewer.ModifiableZestContentViewer;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.viatra.query.runtime.matchers.ViatraQueryRuntimeException;

import com.google.common.collect.ImmutableSet;


public abstract class AbstractCpsViewPart extends ViewPart implements IPartListener2 {

		private ModifiableZestContentViewer viewer;
		private ViatraQueryEngine engine = null;
		protected IEditorPart activeEditor;
		
		public AbstractCpsViewPart() {
			IWorkbenchPage workbenchPage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			workbenchPage.addPartListener(this);	
		}

		protected ViatraQueryEngine getEngine() {
			return engine;
		}
		
		protected abstract Collection<IQuerySpecification<?>> getSpecifications();
		
		@Override
		public void createPartControl(Composite parent) {
	        this.viewer = new ModifiableZestContentViewer();
	        viewer.createControl(parent, SWT.BORDER);
		}

		@Override
		public void setFocus() {
			viewer.getControl().setFocus();
		}
		
		protected void engineUpdated() {
			try {
				ViewerState state = ViatraViewerDataModel.newViewerState(getEngine(), getSpecifications(), ViewerDataFilter.UNFILTERED,
						ImmutableSet.of(ViewerStateFeature.EDGE, ViewerStateFeature.CONTAINMENT));
				ViatraGraphViewers.bind(viewer, state, true);
				viewer.setLayoutAlgorithm(getLayout());
			} catch (ViatraQueryRuntimeException e) {
				e.printStackTrace();
			}
		}

		protected ILayoutAlgorithm getLayout() {
			return new SpaceTreeLayoutAlgorithm();
		}
		
		@Override
		public void partActivated(IWorkbenchPartReference partRef) {
			activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			if (activeEditor instanceof CyberPhysicalSystemEditor) {
				CyberPhysicalSystemEditor edp = (CyberPhysicalSystemEditor) activeEditor;
				ResourceSet resourceSet = edp.getEditingDomain().getResourceSet();
				
				if(engine != null && resourceSet == engine.getScope())
					return;
				
	            try {
					engine = ViatraQueryEngine.on(new EMFScope(resourceSet));
				} catch (ViatraQueryRuntimeException e) {
					e.printStackTrace();
				} 
	            
	            engineUpdated();            
	        }
		}

		@Override
		public void partBroughtToTop(IWorkbenchPartReference partRef) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void partClosed(IWorkbenchPartReference partRef) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void partDeactivated(IWorkbenchPartReference partRef) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void partOpened(IWorkbenchPartReference partRef) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void partHidden(IWorkbenchPartReference partRef) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void partVisible(IWorkbenchPartReference partRef) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void partInputChanged(IWorkbenchPartReference partRef) {
			// TODO Auto-generated method stub
			
		}	
}
