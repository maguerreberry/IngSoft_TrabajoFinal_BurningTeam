/*
 * Este test crea un modelo, un controlador y una vista, la finalidad del mismo es fijarse si el modelo responde 
 * correctamente a estumulos del controlador y si se crea el objeto vista  
 */
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
			assertTrue("NullPointerException: No se creò controlador", false);
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
	public void testSetBPMRE() {
		try{
		controller.setBPM("RE");
		assertEquals("Ingreso RE",model.getNotes(),62,0);}
		catch (NullPointerException e){
			assertTrue("NullPointerException: No se creò controlador", false);
		}
	}
	@Test
	public void testSetBPMDO_() {
		try{
		controller.setBPM("DO#");
		assertEquals("Ingreso DO#",model.getNotes(),61,0);}
		catch (NullPointerException e){
			assertTrue("NullPointerException: No se creò controlador", false);
		}
	}
	@Test
	public void testSetBPMRE_() {
		try{
		controller.setBPM("RE#");
		assertEquals("Ingreso RE#",model.getNotes(),63,0);}
		catch (NullPointerException e){
			assertTrue("NullPointerException: No se creò controlador", false);
		}
	}
	@Test
	public void testSetBPMMI() {
		try{
		controller.setBPM("MI");
		assertEquals("Ingreso MI",model.getNotes(),64,0);}
		catch (NullPointerException e){
			assertTrue("NullPointerException: No se creò controlador", false);
		}
	}


}
