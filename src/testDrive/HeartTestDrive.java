package testDrive;

import controller.ControllerInterface;
import controller.HeartController;
import model.HeartAdapter;
import model.HeartModel;
import view.GeneralView;
import view.ViewInterface;

public class HeartTestDrive {

		static HeartModel heartModel;
	
    public static void main (String[] args) {
		heartModel = HeartModel.getInstance();
        ControllerInterface model = new HeartController(heartModel);
    	ViewInterface vista = new GeneralView();
    	vista.setModel(new HeartAdapter(heartModel),model);
    }
}
