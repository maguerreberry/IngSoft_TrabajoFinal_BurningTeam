package Heart;

import Beat.ControllerInterface;
import Beat.DJView;

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
  
 	public void setBPM(int bpm) {}
}



