package MusicalNotes;

import Beat.ControllerInterface;

public class MyMusicalNotesTestDrive {

    public static void main (String[] args) {
		MusicalNotesModelInterface notesModel = new MusicalNotesModel();
        ControllerInterface controller = new MusicalNotesController(notesModel);
    }
}
