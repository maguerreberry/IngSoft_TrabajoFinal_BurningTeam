package MusicalNotes;

import Beat.ControllerInterface;
import Beat.DJView;

public class MusicalNotesController implements ControllerInterface {
	MusicalNotesModelInterface model;
	DJView view;
	MusicalNotesModel NotesModel;
	
	public MusicalNotesController(MusicalNotesModelInterface model) {
		this.model=model;
		view = new DJView(this, new MusicalNotesAdapter(model));
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
		model.initialize();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		model.on();
		view.disableStartMenuItem();
		view.enableStopMenuItem();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		model.off();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
	}

	@Override
	public void increaseBPM() {
		// TODO Auto-generated method stub
		int note = model.getNotes();
        model.setNotes(note + 1);
	}

	@Override
	public void decreaseBPM() {
		// TODO Auto-generated method stub
		int note = model.getNotes();
        model.setNotes(note + 1);
	}

	@Override
	public void setBPM(int note) {
		// TODO Auto-generated method stub
		model.setNotes(note);
	}

	@Override
	public int getnInst() {
		// TODO Auto-generated method stub
		return 0;
	}

}
