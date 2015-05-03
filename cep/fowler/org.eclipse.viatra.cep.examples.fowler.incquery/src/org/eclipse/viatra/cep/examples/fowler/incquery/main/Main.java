package org.eclipse.viatra.cep.examples.fowler.incquery.main;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.viatra.cep.core.api.helpers.DefaultApplication;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.core.streams.EventStream;
import org.eclipse.viatra.cep.examples.fowler.incquery.eventmodel.CepFactory;
import org.eclipse.viatra.cep.examples.fowler.incquery.eventmodel.mapping.QueryEngine2ViatraCep;
import org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Door;
import org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Drawer;
import org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.FowlerFactory;
import org.eclipse.viatra.cep.examples.fowler.incquery.model.fowler.Room;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Main extends DefaultApplication {

	/**
	 * The {@link QueryEngine2ViatraCep} mapping ensures the creation of atomic
	 * event instances upon graph pattern match appearance and disappearance.
	 */
	private QueryEngine2ViatraCep mapping;

	/**
	 * Attributes related to the underlying model.
	 */
	private Resource resource;
	private ResourceSet resourceSet;
	private Room room;
	private Door door;
	private Drawer drawer1;
	private Drawer drawer2;

	public Main() {
		super(EventContext.CHRONICLE);
	}

	/**
	 * Setting up the application requires preparing the model (standard EMF
	 * things, see {@link #prepareModel()}), and instantiating the mapping by
	 * registering the root graph pattern matching scope (e.g. a
	 * {@link ResourceSet}) to the {@link EventStream}.
	 */
	@Before
	public void setUp() {
		prepareModel();
		mapping = QueryEngine2ViatraCep.register(resourceSet, getEventStream());
	}

	@Override
	protected void configureRules() {
		getEngine().addRules(CepFactory.getInstance().allRules());
	}

	/**
	 * The {@link QueryEngine2ViatraCep} mapping is disposed properly by
	 * invoking the {@link QueryEngine2ViatraCep#dispose()} method.
	 */
	@After
	public void tearDown() {
		door = null;
		drawer1 = null;
		drawer2 = null;
		room = null;
		mapping.dispose();
		mapping = null;
	}

	/**
	 * Preparing the model by instantiating the required objects and putting the
	 * model into a {@link ResourceSet}.
	 */
	private void prepareModel() {
		room = FowlerFactory.eINSTANCE.createRoom();
		door = FowlerFactory.eINSTANCE.createDoor();
		room.setDoor(door);
		drawer1 = FowlerFactory.eINSTANCE.createDrawer();
		drawer1.setId("drawer1");
		drawer2 = FowlerFactory.eINSTANCE.createDrawer();
		drawer1.setId("drawer2");
		room.getDrawers().add(drawer1);
		room.getDrawers().add(drawer2);

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("fowler", new XMIResourceFactoryImpl());
		resourceSet = new ResourceSetImpl();
		resource = resourceSet.createResource(URI.createURI("fowler/model.fowler"));
		resource.getContents().add(room);
	}

	@Test
	public void main() {
		getEngine().getLogger().debug("Starting");
		// This series of events will generate the specified complex event.
		drawer1.setOpen(true);
		drawer1.setOpen(false);
		drawer1.setOpen(true);
		drawer1.setOpen(false);
		// This series of events will NOT generate the specified complex event,
		// since not the same drawer is opened and close twice, but two
		// different drawers.
		drawer1.setOpen(true);
		drawer1.setOpen(false);
		drawer2.setOpen(true);
		drawer2.setOpen(false);
		getEngine().getLogger().debug("Ending");
	}

}
