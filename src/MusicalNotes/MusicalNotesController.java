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
	public void setBPM(String note) {
		// TODO Auto-generated method stub
		int Note=0;
		switch(note){
			case "DO":
				Note=60;
				break;
			case "RE":
				Note=62;
				break;
			case "MI":
				Note=64;
				break;
			case "FA":
				Note=65;
				break;
			case "SOL":
				Note=67;
				break;
			case "LA":
				Note=69;
				break;
			case "SI":
				Note=71;
				break;
			default:
				Note=0;
		}
		model.setNotes(Note);
	}

	@Override
	public int getnInst() {
		// TODO Auto-generated method stub
		return 0;
	}

}
