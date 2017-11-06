package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MusicalNotesModelTest {
	MusicalNotesModelInterface model;
	@Before
	public void setUp() throws Exception {
		model=new MusicalNotesModel();
		testInitialize();
	}

	@Test
	public void testInitialize() {
		try{
			model.initialize();
			assertTrue("Modelo correctamente inicializado",true);
		}
		catch(Exception e){
			assertTrue("No se pudo iniiciar el modelo",false);
		}
	}

	@Test
	public void testOn() {
		try{
			model.on();
			assertTrue("La funcion se ejecuta correctamente",true);
		}
		catch(Exception e){
			assertTrue("No se pudo ejecutar la funcion",false);
		}
	}
	
	@Test
	public void testOff() {
		try{
			model.off();
			assertTrue("La funcion se ejecuta correctamente",true);
		}
		catch(Exception e){
			assertTrue("No se pudo ejecutar la funcion",false);
		}
	}
	@Test
	public void testSetNotes() {
		try{
			model.setNotes(60);
			assertEquals("La funcion se ejecuta correctamente",60,model.getNotes(),0);
		}
		catch(Exception e){
			assertTrue("No se pudo ejecutar la funcion",false);
		}
	}
}
