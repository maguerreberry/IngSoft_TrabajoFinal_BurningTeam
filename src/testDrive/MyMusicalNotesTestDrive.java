package testDrive;

import controller.ControllerInterface;
import controller.MusicalNotesController;
import model.MusicalNotesModel;
import model.MusicalNotesModelInterface;

public class MyMusicalNotesTestDrive {

    public static void main (String[] args) {
		MusicalNotesModelInterface notesModel = new MusicalNotesModel();
        ControllerInterface controller = new MusicalNotesController(notesModel);
    }
}
