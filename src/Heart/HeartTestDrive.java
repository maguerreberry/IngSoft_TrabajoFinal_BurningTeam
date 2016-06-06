package Heart;

import Beat.ControllerInterface;

public class HeartTestDrive {

	static HeartModel heartModel;
	
    public static void main (String[] args) {
		heartModel = heartModel.getInstance();
        ControllerInterface model = new HeartController(heartModel);
    }
}
