package view;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.BeatController;
import controller.ControllerInterface;
import controller.HeartController;
import controller.MusicalNotesController;
import model.BeatModel;
import model.BeatModelInterface;
import model.HeartAdapter;
import model.HeartModel;
import model.MusicalNotesAdapter;
import model.MusicalNotesModel;

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
