package Beat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Heart.BPMObserver;
import Heart.HeartController;
import Heart.HeartModel;
import MusicalNotes.MusicalNotesController;
import MusicalNotes.MusicalNotesModel;

public class GeneralView implements ViewInterface {
	MusicalNotesModel notesModel ;
	static HeartModel heartModel;
	BeatModelInterface modelBeat;
	ControllerInterface controllerBeat;
	ControllerInterface controllerHeart;
	ControllerInterface controllerNotes;
	BeatModelInterface model;
	ControllerInterface controller;
    JFrame viewFrame;
    JPanel viewPanel;
	BeatBar beatBar;
	JLabel bpmOutputLabel;
    JFrame controlFrame;
    JPanel controlPanel;
    JLabel bpmLabel;
    JTextField bpmTextField;
    JButton setBPMButton;
    JButton increaseBPMButton;
    JButton decreaseBPMButton;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem startMenuItem;
    JMenuItem stopMenuItem;
    JMenuItem notesItem;
    
    public	GeneralView(){
    	modelBeat = new BeatModel();
    	controllerBeat = new BeatController(modelBeat);
    	controller=controllerBeat;
    	heartModel = heartModel.getInstance();
        controllerHeart = new HeartController(heartModel);
        notesModel = new MusicalNotesModel();
        controllerNotes = new MusicalNotesController(notesModel);
    }
    
	@Override
	public void createView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setModel(){
    	JFrame.setDefaultLookAndFeelDecorated(true);
        controlFrame = new JFrame("Control Model");
        controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlFrame.setSize(new Dimension(100, 80));

        controlPanel = new JPanel(new GridLayout(1, 2));

        menuBar = new JMenuBar();
        menu = new JMenu("Model Select");
        startMenuItem = new JMenuItem("Beat");
        menu.add(startMenuItem);
        startMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	try{
            	controller.off();
            	}
            	catch(NullPointerException e){}
            	model = modelBeat;
            	controller = controllerBeat;
            	controller.on();
            }
        });
        stopMenuItem = new JMenuItem("Heart");
        menu.add(stopMenuItem); 
        stopMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	try{
                	controller.off();
                	}
                	catch(NullPointerException e){}
            	controller=controllerHeart;
                controller.on();
            }
        });
        notesItem = new JMenuItem("MusicalNotes");
        menu.add(notesItem); 
        notesItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	try{
                	controller.off();
                	}
                	catch(NullPointerException e){}
            	controller=controllerNotes;
                controller.on();
            }
        });
        menuBar.add(menu);
        controlFrame.setJMenuBar(menuBar);

       // bpmLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        //bpmOutputLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        controlFrame.getRootPane().setDefaultButton(setBPMButton);
        controlFrame.getContentPane().add(controlPanel, BorderLayout.CENTER);

        controlFrame.pack();
        controlFrame.setVisible(true);
    }

	@Override
	public void createControls() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enableStopMenuItem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableStopMenuItem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enableStartMenuItem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableStartMenuItem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

	
	
}
