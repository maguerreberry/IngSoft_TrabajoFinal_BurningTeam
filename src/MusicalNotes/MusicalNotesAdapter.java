package MusicalNotes;

import Beat.BeatModelInterface;
import Beat.BeatObserver;
import Heart.BPMObserver;
/*
 *  Transforma Lo que viene de la interfaz BeatModel a la MusicalNoteModelInterface. 
 */
public class MusicalNotesAdapter implements BeatModelInterface {
	MusicalNotesModelInterface note;

	public MusicalNotesAdapter(MusicalNotesModelInterface note) {
		this.note = note;
	}
	@Override
	public void initialize() {
		note.initialize();
	}

	@Override
	public void on() {
		note.on();
	}

	@Override
	public void off() {
		note.off();
	}

	@Override
	public void setBPM(int noteNew) {
		
		note.setNotes(noteNew);
	}

	@Override
	public int getBPM() {
		return note.getNotes();
	}

	@Override
	public void registerObserver(BeatObserver o) {
		// TODO Auto-generated method stub
		note.registerObserver(o);
	}

	@Override
	public void removeObserver(BeatObserver o) {
		// TODO Auto-generated method stub
		note.removeObserver(o);
	}

	@Override
	public void registerObserver(BPMObserver o) {
		// TODO Auto-generated method stub
		note.registerObserver(o);
	}

	@Override
	public void removeObserver(BPMObserver o) {
		// TODO Auto-generated method stub
		note.removeObserver(o);
	}

}
