package Heart;

import Beat.BeatController;
import Beat.BeatModel;
import Beat.BeatModelInterface;
import Beat.ControllerInterface;
import Beat.DJView;
import MusicalNotes.MusicalNotesController;
import MusicalNotes.MusicalNotesModel;
import MusicalNotes.MusicalNotesModelInterface;

public class HeartController implements ControllerInterface {
	HeartModelInterface model;
	DJView view;	
	HeartModel heartModel;
    int nInst = -1; //arranco en -1 para no contar la primera vez como intento de creacion
	
	public HeartController(HeartModelInterface model) {
		this.model = model;
		view = new DJView(this, new HeartAdapter(model));
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.disableStartMenuItem();
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
}



