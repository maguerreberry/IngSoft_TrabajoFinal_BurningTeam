package view;

import controller.ControllerInterface;
import model.BeatModelInterface;

public interface ViewInterface {
	void createView();
	void createControls();
	void enableStopMenuItem();
	void disableStopMenuItem();
	void enableStartMenuItem();
	void disableStartMenuItem();
	void end();
	void setModel(BeatModelInterface beat, ControllerInterface controller);
	
}
