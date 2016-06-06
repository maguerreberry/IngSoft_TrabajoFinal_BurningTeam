package MusicalNotes;

import Beat.ControllerInterface;

public class MyMusicalNotesTestDrive {

    public static void main (String[] args) {
		MusicalNotesModel musicalNotesModel = new MusicalNotesModel();
        ControllerInterface model = new MusicalNotesController(musicalNotesModel);
    }
}
