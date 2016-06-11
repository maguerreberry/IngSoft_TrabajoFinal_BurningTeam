package Beat;

import Heart.HeartController;
import Heart.HeartModel;
import MusicalNotes.MusicalNotesController;
import MusicalNotes.MusicalNotesModel;
import MusicalNotes.MusicalNotesModelInterface;

public class BeatController implements ControllerInterface {
	BeatModelInterface model;
	ViewInterface view;
   
	public BeatController(BeatModelInterface model) {
		this.model = model;	
	}
  
	public void start() {
		model.on();
		view.disableStartMenuItem();
		view.enableStopMenuItem();
	}
  
	public void stop() {
		model.off();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
	}
    
	public void increaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm + 1);
	}
    
	public void decreaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm - 1);
  	}
  
 	public void setBPM(String bpm) {
 		int BPM = Integer.parseInt(bpm);
		model.setBPM(BPM);
	}

	@Override
	public int getnInst() {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
<<<<<<< HEAD
	public void BeatView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void HeartView() {
		// TODO Auto-generated method stub
		HeartModel heartModel;
		heartModel = HeartModel.getInstance();
        ControllerInterface model = new HeartController(heartModel);
	}

	@Override
	public void MusicalView() {
		// TODO Auto-generated method stub
		MusicalNotesModelInterface notesModel = new MusicalNotesModel();
        ControllerInterface controller = new MusicalNotesController(notesModel);        
=======
	public void on() {
		// TODO Auto-generated method stub
		view = new DJView(this, model);
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
		model.initialize();
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		model.off();
		view.end();
>>>>>>> funcionVistas
	}
}
