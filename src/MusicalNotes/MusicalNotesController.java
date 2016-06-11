package MusicalNotes;

<<<<<<< HEAD
import Beat.BeatController;
import Beat.BeatModel;
import Beat.BeatModelInterface;
import Beat.ControllerInterface;
import Heart.HeartController;
import Heart.HeartModel;


public class MusicalNotesController implements ControllerInterface {
	MusicalNotesModelInterface model;
	MusicalView view;
=======
import Beat.BeatModelInterface;
import Beat.ControllerInterface;
import Beat.DJView;
import Beat.ViewInterface;

public class MusicalNotesController implements ControllerInterface {
	MusicalNotesModelInterface model;
	ViewInterface view;
>>>>>>> funcionVistas
	MusicalNotesModel NotesModel;
	
	public MusicalNotesController(MusicalNotesModelInterface model) {
		this.model=model;
<<<<<<< HEAD
		view = new MusicalView(this, new MusicalNotesAdapter(model));
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
		model.initialize();
=======
>>>>>>> funcionVistas
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		model.on();
		view.disableStartMenuItem();
		view.enableStopMenuItem();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		model.off();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
	}

	@Override
	public void increaseBPM() {
		// TODO Auto-generated method stub
		int note = model.getNotes();
        model.setNotes(note + 1);
	}

	@Override
	public void decreaseBPM() {
		// TODO Auto-generated method stub
		int note = model.getNotes();
        model.setNotes(note - 1);
	}

	@Override
	public void setBPM(String note) {
		// TODO Auto-generated method stub
		int Note=0;
		switch(note){
			case "DO":
				Note=60;
				break;
			case "DO#":
				Note=61;
				break;
			case "RE":
				Note=62;
				break;
			case "RE#":
				Note=63;
				break;
			case "MI":
				Note=64;
				break;
			case "FA":
				Note=65;
				break;
			case "FA#":
				Note=66;
				break;
			case "SOL":
				Note=67;
				break;
			case "SOL#":
				Note=68;
				break;
			case "LA":
				Note=69;
				break;
			case "LA#":
				Note=70;
				break;
			case "SI":
				Note=71;
				break;
			default:
				Note=0;
		}
		model.setNotes(Note);
	}

	@Override
	public int getnInst() {
		// TODO Auto-generated method stub
		return -1;
	}
	
	@Override
	public void BeatView() {
		// TODO Auto-generated method stub
        BeatModelInterface model = new BeatModel();
		ControllerInterface controller = new BeatController(model);
		
	}

	@Override
	public void HeartView() {
		// TODO Auto-generated method stub
		HeartModel heartModel;
		heartModel = HeartModel.getInstance();
        ControllerInterface model = new HeartController(heartModel);
	}

	@Override
	public void MusicalView() {
		// TODO Auto-generated method stub       
	}

	@Override
	public void on() {
		// TODO Auto-generated method stub
		view = new MusicalNotesView2(this,model);
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
		model.initialize();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		model.off();
		view.end();	
	}


}
