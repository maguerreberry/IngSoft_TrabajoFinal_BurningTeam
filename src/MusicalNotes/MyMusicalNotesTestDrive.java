package MusicalNotes;

import Beat.ControllerInterface;

public class MyMusicalNotesTestDrive {

    public static void main (String[] args) {
		MusicalNotesModel notesModel = new MusicalNotesModel();
        ControllerInterface controller = new MusicalNotesController(notesModel);
    }
}
