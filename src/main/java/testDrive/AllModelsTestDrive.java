package main.java.testDrive;

import main.java.controller.BeatController;
import main.java.controller.ControllerInterface;
import main.java.controller.HeartController;
import main.java.controller.MusicalNotesController;
import main.java.model.BeatModel;
import main.java.model.BeatModelInterface;
import main.java.model.HeartAdapter;
import main.java.model.HeartModel;
import main.java.model.MusicalNotesAdapter;
import main.java.model.MusicalNotesModel;
import main.java.model.MusicalNotesModelInterface;
import main.java.view.GeneralView;
import main.java.view.ViewInterface;

public class AllModelsTestDrive {
	static HeartModel heartModel;

	public static void main(String[] args) {
			heartModel = HeartModel.getInstance();
					ControllerInterface controllerH = new HeartController(heartModel);
			    ViewInterface vistaH = new GeneralView();
			vistaH.setModel(new HeartAdapter(heartModel),controllerH);

			BeatModelInterface modelB = new BeatModel();
			ControllerInterface controllerB = new BeatController(modelB);
			ViewInterface vistaB = new GeneralView();
			vistaB.setModel(modelB,controllerB);

			MusicalNotesModelInterface notesModel = new MusicalNotesModel();
			ControllerInterface controllerN = new MusicalNotesController(notesModel);
			ViewInterface vistaN = new GeneralView();
			vistaN.setModel(new MusicalNotesAdapter(notesModel),controllerN);
	}
}