package main.java.testDrive;

import main.java.controller.ControllerInterface;
import main.java.controller.MusicalNotesController;
import main.java.model.MusicalNotesAdapter;
import main.java.model.MusicalNotesModel;
import main.java.model.MusicalNotesModelInterface;
import main.java.view.GeneralView;
import main.java.view.ViewInterface;


public class MyMusicalNotesTestDrive {

	public static void main(String[] args) {
		MusicalNotesModelInterface notesModel = new MusicalNotesModel();
		ControllerInterface controller = new MusicalNotesController(notesModel);
		ViewInterface vista = new GeneralView();
		vista.setModel(new MusicalNotesAdapter(notesModel),controller);    	
	}
}
