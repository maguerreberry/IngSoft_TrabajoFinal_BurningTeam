package testDrive;

import controller.ControllerInterface;
import controller.MusicalNotesController;
import model.MusicalNotesAdapter;
import model.MusicalNotesModel;
import model.MusicalNotesModelInterface;
import view.GeneralView;
import view.ViewInterface;


public class MyMusicalNotesTestDrive {

    public static void main (String[] args) {
		MusicalNotesModelInterface notesModel = new MusicalNotesModel();
        ControllerInterface controller = new MusicalNotesController(notesModel);
    	ViewInterface vista = new GeneralView();
    	vista.setModel(new MusicalNotesAdapter(notesModel),controller);
    	
    }
}
