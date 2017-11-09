package test.java.view;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import main.java.controller.BeatController;
import main.java.controller.ControllerInterface;
import main.java.controller.HeartController;
import main.java.controller.MusicalNotesController;
import main.java.model.BeatModel;
import main.java.model.BeatModelInterface;
import main.java.model.HeartAdapter;
import main.java.model.HeartModel;
import main.java.model.MusicalNotesAdapter;
import main.java.model.MusicalNotesModel;
import main.java.view.GeneralView;
import main.java.view.ViewInterface;

public class GeneralViewTest {
	
	ViewInterface view;
	MusicalNotesModel notesModel ;
	static HeartModel heartModel;
	BeatModelInterface modelBeat;
	ControllerInterface controllerBeat;
	ControllerInterface controllerHeart;
	ControllerInterface controllerNotes;
	BeatModelInterface model;
	ControllerInterface controller;

	@Before
	public void setUp() throws Exception {
		modelBeat = new BeatModel();
    	controllerBeat = new BeatController(modelBeat);
    	controller=controllerBeat;
    	heartModel = heartModel.getInstance();
        controllerHeart = new HeartController(heartModel);
        notesModel = new MusicalNotesModel();
        controllerNotes = new MusicalNotesController(notesModel);
        view=new GeneralView();
        //view.createView();
	}

	@Test
	public void testCreateView() {
		try{
		view.createView();
		assertTrue("Vista creada ", true);
		}
		catch(NullPointerException e ){
			assertTrue("No se pudo crear la vista",false);
		}
	}
	@Test
	public void testsetModelBeat() {
		try{
		view.setModel(modelBeat,controllerBeat);
		assertTrue("Vista Beat creada ", true);
		}
		catch(NullPointerException e ){
			assertTrue("No se pudo setear el modelo debido a que el modelo ingresado es nulo",false);
		}
	}
	@Test
	public void testsetModelHeart() {
		try{
		view.setModel(new HeartAdapter(heartModel),controllerHeart);
		assertTrue("Vista Heart creada ", true);
		}
		catch(NullPointerException e ){
			assertTrue("No se pudo setear el modelo debido a que el modelo ingresado es nulo",false);
		}
	}
	@Test
	public void testsetModelMusicalNotes() {
		try{
		view.setModel(new MusicalNotesAdapter(notesModel),controllerNotes);
		assertTrue("Vista Notes creada ", true);
		}
		catch(NullPointerException e ){
			assertTrue("No se pudo setear el modelo debido a que el modelo ingresado es nulo",false);
		}
	}
}
