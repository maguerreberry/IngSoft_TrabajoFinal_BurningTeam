package testDrive;

import controller.BeatController;
import controller.ControllerInterface;
import controller.HeartController;
import controller.MusicalNotesController;
import model.BeatModel;
import model.BeatModelInterface;
import model.HeartAdapter;
import model.HeartModel;
import model.MusicalNotesAdapter;
import model.MusicalNotesModel;
import model.MusicalNotesModelInterface;
import view.GeneralView;
import view.ViewInterface;

public class AllModelsTestDrive {
	static HeartModel heartModel;

	 public static void main (String[] args) {
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