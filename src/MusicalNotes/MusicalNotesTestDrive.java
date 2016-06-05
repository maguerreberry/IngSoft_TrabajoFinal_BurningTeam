package MusicalNotes;

import Beat.ControllerInterface;

public class MusicalNotesTestDrive {

    public static void main (String[] args) {
		MusicalNotesModel musicalNotesModel = new MusicalNotesModel();
        ControllerInterface model = new MusicalNotesController(musicalNotesModel);
    }
}
