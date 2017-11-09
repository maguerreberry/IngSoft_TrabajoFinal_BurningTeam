package main.java.model;

import main.java.view.BPMObserver;
import main.java.view.BeatObserver;

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
