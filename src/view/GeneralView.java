package view;

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

import controller.BeatController;
import controller.ControllerInterface;
import controller.HeartController;
import controller.MusicalNotesController;
import model.BeatModel;
import model.BeatModelInterface;
import model.HeartModel;
import model.MusicalNotesModel;

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
    JMenuItem beatMenuItem;
    JMenuItem heartMenuItem;
    JMenuItem musicalNotesMenuItem;
    
    public	GeneralView(){
    	modelBeat = new BeatModel();
    	controllerBeat = new BeatController(modelBeat);
    	controller=controllerBeat;
    	heartModel = heartModel.getInstance();
        controllerHeart = new HeartController(heartModel);
        notesModel = new MusicalNotesModel();
        controllerNotes = new MusicalNotesController(notesModel);
        createView();
    }
    
	@Override
	public void setModel(BeatModelInterface newModel,ControllerInterface newController) {
		// TODO Auto-generated method stub
		model=newModel;
		controller=newController;
		end();
		controller.on();
	}

	@Override
	public void createView(){
    	JFrame.setDefaultLookAndFeelDecorated(true);
        controlFrame = new JFrame("Choose Model");
        controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlFrame.setSize(new Dimension(100, 80));
        controlPanel = new JPanel(new GridLayout(1, 2));
        menuBar = new JMenuBar();
        menu = new JMenu("Model Select");
        beatMenuItem = new JMenuItem("Beat");
        heartMenuItem = new JMenuItem("Heart");
        musicalNotesMenuItem = new JMenuItem("MusicalNotes");        
        menu.add(beatMenuItem);
        menu.add(heartMenuItem); 
        menu.add(musicalNotesMenuItem); 
        
        beatMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	try{
            	controller.off();
            	}
            	catch(NullPointerException e){}
            	beatMenuItem.setEnabled(false);
            	heartMenuItem.setEnabled(true);
            	musicalNotesMenuItem.setEnabled(true);
            	controller = controllerBeat;
            	controller.on();
            }
        });        
        
        heartMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	try{
                	controller.off();
                	}
                	catch(NullPointerException e){}
            	beatMenuItem.setEnabled(true);
            	heartMenuItem.setEnabled(false);
            	musicalNotesMenuItem.setEnabled(true);
            	controller=controllerHeart;
                controller.on();
            }
        });
        
        musicalNotesMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	try{
                	controller.off();
                	}
                	catch(NullPointerException e){}
            	beatMenuItem.setEnabled(true);
            	heartMenuItem.setEnabled(true);
            	musicalNotesMenuItem.setEnabled(false);
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
		controlFrame.setVisible(false);
	}

	
	
}
