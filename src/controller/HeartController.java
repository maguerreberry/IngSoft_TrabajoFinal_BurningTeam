package controller;

import model.HeartAdapter;
import model.HeartModel;
import model.HeartModelInterface;
import view.HeartView;

public class HeartController implements ControllerInterface {
	HeartModelInterface model;
	HeartView view;	
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
	public void on() {
		// TODO Auto-generated method stub
	
		view = new HeartView(this, new HeartAdapter(model),"Heart Control");
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



