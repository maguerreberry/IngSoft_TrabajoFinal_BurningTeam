package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controller.ControllerInterface;
import model.BeatModelInterface;
import model.MusicalNotesModelInterface;

public class MusicalNotesView implements ViewInterface,ActionListener,  BeatObserver, BPMObserver {
	MusicalNotesModelInterface model;
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
	private JMenuItem beatMenuItem;
	private JMenu menu2;
	private JMenuItem heartMenuItem;
	private JMenuItem musicalMenuItem;
	private JButton doButton;
	private JButton reButton;
	private JButton miButton;
	private JButton faButton;
	private JButton solButton;
	private JButton laButton;
	private JButton siButton;
	
	 public MusicalNotesView(ControllerInterface controller, MusicalNotesModelInterface model) {	
			this.controller = controller;
			this.model = model;
			model.registerObserver((BeatObserver)this);
			model.registerObserver((BPMObserver)this);
	    }
	
	 public void createView() {
			// Create all Swing components here
	        viewPanel = new JPanel(new GridLayout(1, 2));
	        viewFrame = new JFrame("View");
	        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        viewFrame.setSize(new Dimension(100, 120));
	        bpmOutputLabel = new JLabel("offline", SwingConstants.CENTER);
			beatBar = new BeatBar();
			beatBar.setValue(0);
	        JPanel bpmPanel = new JPanel(new GridLayout(2, 1));
			bpmPanel.add(beatBar);
	        bpmPanel.add(bpmOutputLabel);
	        viewPanel.add(bpmPanel);
	        viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
	        viewFrame.pack();
	        viewFrame.setVisible(true);
		}
	 
	 public void createControls() {
			// Create all Swing components here
	        JFrame.setDefaultLookAndFeelDecorated(true);
	        controlFrame = new JFrame("Control");
	        controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        controlFrame.setSize(new Dimension(100, 80));

	        controlPanel = new JPanel(new GridLayout(1, 2));

	        menuBar = new JMenuBar();
	        menu = new JMenu("Musical Notes");
	        startMenuItem = new JMenuItem("Start");
	        menu.add(startMenuItem);
	        startMenuItem.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent event) {
	                controller.start();
	            }
	        });
	        stopMenuItem = new JMenuItem("Stop");
	        menu.add(stopMenuItem); 
	        stopMenuItem.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent event) {
	                controller.stop();
	            }
	        });
	        JMenuItem exit = new JMenuItem("Quit");
	        exit.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent event) {
	                System.exit(0);
	            }
	        });

	        menu.add(exit);
	        menuBar.add(menu);
	        
	        controlFrame.setJMenuBar(menuBar);

	        bpmTextField = new JTextField(2);
	        bpmLabel = new JLabel("Enter Note:", SwingConstants.RIGHT);
	        setBPMButton = new JButton("GO!");
	        setBPMButton.setSize(new Dimension(10,40));
	        doButton = new JButton("DO");
	        reButton = new JButton("RE");
	        miButton = new JButton("MI");
	        faButton = new JButton("FA");
	        solButton = new JButton("SOL");
	        laButton = new JButton("LA");
	        siButton = new JButton("SI");
	        setBPMButton.addActionListener(this);
	        doButton.addActionListener(this);
	        reButton.addActionListener(this);
	        miButton.addActionListener(this);
	        faButton.addActionListener(this);
	        solButton.addActionListener(this);
	        laButton.addActionListener(this);
	        siButton.addActionListener(this);
	        
	        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

			buttonPanel.add(doButton);
			buttonPanel.add(reButton);
			buttonPanel.add(miButton);
			buttonPanel.add(faButton);
			buttonPanel.add(solButton);
			buttonPanel.add(laButton);
			buttonPanel.add(siButton);
	        JPanel enterPanel = new JPanel(new GridLayout(1, 2));
	        enterPanel.add(bpmLabel);
	        enterPanel.add(bpmTextField);
	        JPanel insideControlPanel = new JPanel(new GridLayout(3, 1));
	        insideControlPanel.add(enterPanel);
	        insideControlPanel.add(setBPMButton);
	        insideControlPanel.add(buttonPanel);
	        controlPanel.add(insideControlPanel);
	        
	        bpmLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	        bpmOutputLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

	        controlFrame.getRootPane().setDefaultButton(setBPMButton);
	        controlFrame.getContentPane().add(controlPanel, BorderLayout.CENTER);

	        controlFrame.pack();
	        controlFrame.setVisible(true);
	    }
	 
	 	public void enableStopMenuItem() {
	    	stopMenuItem.setEnabled(true);
		}

		public void disableStopMenuItem() {
	    	stopMenuItem.setEnabled(false);
		}

		public void enableStartMenuItem() {
	    	startMenuItem.setEnabled(true);
		}

		public void disableStartMenuItem() {
	    	startMenuItem.setEnabled(false);
		}
		
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == setBPMButton) {
				//int bpm = Integer.parseInt(bpmTextField.getText());
	        	controller.setBPM(bpmTextField.getText());
			} else if (event.getSource() == doButton) {
				controller.setBPM("DO");
			} else if (event.getSource() == reButton) {
				controller.setBPM("RE");
			} else if (event.getSource() == miButton) {
				controller.setBPM("MI");
			} else if (event.getSource() == faButton) {
				controller.setBPM("FA");
			} else if (event.getSource() == solButton) {
				controller.setBPM("SOL");
			} else if (event.getSource() == laButton) {
				controller.setBPM("LA");
			} else if (event.getSource() == siButton) {
				controller.setBPM("SI");
			} 
	    }
	
		public void updateBPM() {
			if (model != null) {
				int bpm = model.getNotes();
				if (bpm == 0) {
					if (bpmOutputLabel != null) {
	        			bpmOutputLabel.setText("offline");
					}
				} else {
					if (bpmOutputLabel != null) {
						if(controller.getnInst()==-1){
							bpmOutputLabel.setText("Current BPM: " + model.getNotes());
						}
						else{
							bpmOutputLabel.setText("Intentos de creacion: " + controller.getnInst());
						}
							
	        		}
				}
			}
		}
	  
		public void updateBeat() {
			if (beatBar != null) {
				 beatBar.setValue(100);
			}
		}


		@Override
		public void end() {
			// TODO Auto-generated method stub
			controlFrame.setVisible(false);
	    	viewFrame.setVisible(false);
		}

		@Override
		public void setModel(BeatModelInterface beat, ControllerInterface controller) {
			// TODO Auto-generated method stub
			
		}

}
