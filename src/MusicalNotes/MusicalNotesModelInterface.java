package MusicalNotes;

import Beat.BeatObserver;
import Heart.BPMObserver;

public interface MusicalNotesModelInterface {
	
	void on();
	void off();
	void registerObserver(BeatObserver o);
	void removeObserver(BeatObserver o);
	void registerObserver(BPMObserver o);
	void removeObserver(BPMObserver o);
	int getNotes();
	void setNotes(int i);
	void initialize();
	
	
}
