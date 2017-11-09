package main.java.testDrive;

import main.java.controller.ControllerInterface;
import main.java.controller.HeartController;
import main.java.model.HeartAdapter;
import main.java.model.HeartModel;
import main.java.view.GeneralView;
import main.java.view.ViewInterface;

public class HeartTestDrive {

		static HeartModel heartModel;
	
    public static void main (String[] args) {
		heartModel = HeartModel.getInstance();
        ControllerInterface controller = new HeartController(heartModel);
    	ViewInterface vista = new GeneralView();
    	vista.setModel(new HeartAdapter(heartModel),controller);
    }
}
