package controller;

import model.BeatModel;
import model.BeatModelInterface;
import model.HeartAdapter;
import model.HeartModel;
import model.HeartModelInterface;
import model.MusicalNotesModel;
import model.MusicalNotesModelInterface;
import view.DJView;

public class HeartController implements ControllerInterface {
	HeartModelInterface model;
	DJView view;	
	HeartModel heartModel;
    int nInst = 0; 
	public HeartController(HeartModelInterface model) {
		this.model = model;
	}
  
	public void start() {}
 
	public void stop() {}
    
	public void increaseBPM() {
		nInst++;
		heartModel = heartModel.getInstance();		
	}
	
	public int getnInst(){
		return nInst;
	}
    
	public void decreaseBPM() {}
  
 	public void setBPM(String bpm) {}
 	
 	@Override
	public void BeatView() {
		// TODO Auto-generated method stub
        BeatModelInterface model = new BeatModel();
		ControllerInterface controller = new BeatController(model);
		
	}

	@Override
	public void HeartView() {
		// TODO Auto-generated method stub
	}

	@Override
	public void MusicalView() {
		// TODO Auto-generated method stub
		MusicalNotesModelInterface notesModel = new MusicalNotesModel();
        ControllerInterface controller = new MusicalNotesController(notesModel);        
	}

	@Override
	public void on() {
		// TODO Auto-generated method stub
	
		view = new DJView(this, new HeartAdapter(model));
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.disableStartMenuItem();
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		///model.off();
		view.end();
	}
}



