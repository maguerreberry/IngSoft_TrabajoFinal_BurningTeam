package testDrive;

import controller.ControllerInterface;
import controller.HeartController;
import model.HeartModel;

public class HeartTestDrive {

		static HeartModel heartModel;
	
    public static void main (String[] args) {
		heartModel = HeartModel.getInstance();
        ControllerInterface model = new HeartController(heartModel);
    }
}
