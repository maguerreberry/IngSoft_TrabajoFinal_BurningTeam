package main.java.testDrive;

import main.java.controller.BeatController;
import main.java.controller.ControllerInterface;
import main.java.model.BeatModel;
import main.java.model.BeatModelInterface;
import main.java.view.GeneralView;
import main.java.view.ViewInterface;

public class DJTestDrive {

    public static void main (String[] args) {
        BeatModelInterface model = new BeatModel();
    	ControllerInterface controller = new BeatController(model);
    	ViewInterface vista = new GeneralView();
    	vista.setModel(model,controller);
    	
    }
}
