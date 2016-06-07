package MusicalNotes;

import java.util.ArrayList;

import javax.sound.midi.*;

import Beat.BeatObserver;
import Heart.BPMObserver;

public class MusicalNotesModel implements MusicalNotesModelInterface, MetaEventListener {
	Thread thread;
	Sequencer sequencer;
	ArrayList beatObservers = new ArrayList();
	ArrayList bpmObservers = new ArrayList();
	int note = 46;
	int bpm =90;
	Sequence sequence;
	Track track;



	public void initialize() {
		setUpMidi();
		buildTrackAndStart();
	}

	public void on() {
		sequencer.start();
		//setBPM(90);
		setNotes(getNotes());
	}

	public void off() {
		//setNote(0);
		sequencer.stop();
	}

	public void setNotes(int note) {
		sequencer.stop();
		this.note = note;
		initialize();
		sequencer.start();

		//FIX
		//sequencer.setMicrosecondPosition(0);
		//sequencer.setTickPosition(0) ; 

		//sequencer.setTempoInBPM(getBPM());
		notifyBPMObservers();
	}

	public int getNotes() {
		return note;
	}

	void beatEvent() {
		notifyBeatObservers();
	}


	public void registerObserver(BeatObserver o) {
		beatObservers.add(o);
	}

	public void notifyBeatObservers() {
		for(int i = 0; i < beatObservers.size(); i++) {
			BeatObserver observer = (BeatObserver)beatObservers.get(i);
			observer.updateBeat();
		}
	}

	public void registerObserver(BPMObserver o) {
		bpmObservers.add(o);
	}

	public void notifyBPMObservers() {
		for(int i = 0; i < bpmObservers.size(); i++) {
			BPMObserver observer = (BPMObserver)bpmObservers.get(i);
			observer.updateBPM();
		}
	}


	public void removeObserver(BeatObserver o) {
		int i = beatObservers.indexOf(o);
		if (i >= 0) {
			beatObservers.remove(i);
		}
	}



	public void removeObserver(BPMObserver o) {
		int i = bpmObservers.indexOf(o);
		if (i >= 0) {
			bpmObservers.remove(i);
		}
	}


	public void meta(MetaMessage message) {
		//	        if (message.getType() == 47) {
		//				beatEvent();
		//	        	sequencer.start();
		//	        	setBPM(getBPM());
		//	        }

		//FIX
		if (message.getType() == 0x2F ) {
			beatEvent();
			sequencer.setMicrosecondPosition(0);
			sequencer.setTickPosition(0) ; 
			sequencer.start(); 
			setNotes(getNotes());	
		}
	}

	public void setUpMidi() {
		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			//sequencer.addMetaEventListener(this);

			//Fix
			//sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);

			sequence = new Sequence(Sequence.PPQ,1);
			track = sequence.createTrack();
			sequencer.setTempoInBPM(bpm);
		} catch(Exception e) {
			e.printStackTrace();
		}
	} 

	public void buildTrackAndStart() {
		int[] trackList = {note, 0};

		sequence.deleteTrack(null);
		track = sequence.createTrack();
		
		makeTracks(trackList);
		track.add(makeEvent(192,1,41,0,1)); 
		
		try {
			sequencer.setSequence(sequence);                    
		} catch(Exception e) {
			e.printStackTrace();
		}
	} 

	public void makeTracks(int[] list) {        

		for (int i = 0; i < list.length; i++) {
			int key = list[i];

			if (key != 0) {
				
				track.add(makeEvent(144,1,key, 100, i));
				track.add(makeEvent(128,1,key, 100, i+1));
			}
		}
	}

	public  MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, one, two);
			event = new MidiEvent(a, tick);

		} catch(Exception e) {
			e.printStackTrace(); 
		}
		return event;
	}

}
