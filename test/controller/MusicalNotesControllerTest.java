package controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;


import model.MusicalNotesModel;
import model.MusicalNotesModelInterface;
import view.PianoView;
import view.ViewInterface;

public class MusicalNotesControllerTest {
	
	private MusicalNotesModelInterface model;
	private ViewInterface view;
	private MusicalNotesController controller; 

	@Before
	public void setUp()throws Exception{
		//model=new MusicalNotesModel();
		//model = new MusicalNotesModelInterface()
		model=new MusicalNotesModel();
		controller= new MusicalNotesController(model);
		view=null;
		model.initialize();
	}
	@Test
	public void testOn(){
		view = new PianoView(controller,model);
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
		assertFalse("Verifico la creacion de la vista",view==null);
	}
	@Test
	public void testSetBPMDO() {
		try{
		controller.setBPM("DO");
		assertEquals("Ingreso DO",model.getNotes(),60,0);}
		catch (NullPointerException e){
			assertTrue("NullPointerException: No se creò el modelo o controlador", false);
		}
		//fail("Not yet implemented");
	}
	
	@Test
	public void testSetBPMSOL() {
		try{
		controller.setBPM("SOL");
		assertEquals("Ingreso DO",model.getNotes(),67,0);}
		catch (NullPointerException e){
			assertTrue("NullPointerException: No se creò el modelo o controlador", false);
		}
		//fail("Not yet implemented");
	}
	
	@Test
	public void testOff() {
	try{
		model.off();
		assertTrue("Las ventanas se cerraron correctamente",view==null);
	}
		catch(NullPointerException e){
			assertTrue("Ocurrio un error en la ejecucion de las instrucciones", false);
	}
		
	}
	

}
