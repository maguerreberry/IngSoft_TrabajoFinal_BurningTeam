package main.java.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.java.controller.ControllerInterface;
import main.java.model.BeatModelInterface;
import main.java.model.MusicalNotesModelInterface;

public class PianoView implements ViewInterface,ActionListener,  BeatObserver, BPMObserver {
	/** GUI frame.*/
	private JFrame frame;
	/** The total number of notes.*/
	public static final int NUM_KEYS = 7;
	/** How many octaves should be created.*/
	public static final int NUM_OCTAVES = 1;
	/** Holds the possible notes.*/
	private String[] notes = {"DO","RE","MI","FA","SOL","LA","SI"};
	/** Holds the possible sharps.*/
	private String[] sharps = {"DO#","RE#","FA#","SOL#","LA#"};
	/** Holds the octave numbers.*/
	//private String[] octave = {"6"};
//	private Color customColor = new Color(170,180,254);
	/** Border for entry fields*/
	//private Border border = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
	MusicalNotesModelInterface model;
	ControllerInterface controller;
	JMenuItem startMenuItem;
    JMenuItem stopMenuItem;
    JFrame viewFrame;
    JPanel viewPanel;
	BeatBar beatBar;
	JLabel bpmOutputLabel;
	JLabel bpmLabel;
    JTextField bpmTextField;
	JMenuBar menuBar;
	JMenu menu;

	public PianoView(ControllerInterface controller,MusicalNotesModelInterface model){
		this.controller = controller;
		this.model = model;
		model.registerObserver((BeatObserver)this);
		model.registerObserver((BPMObserver)this);
		
		// ------------ Create GUI -----------

		frame = new JFrame("Piano GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		// Create the mainPanel
		Container mainPanel = frame.getContentPane();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		//	mainPanel.setForeground(Color.WHITE);
		mainPanel.setBackground(Color.BLACK);
		mainPanel.add(Box.createRigidArea(new Dimension(0,10)));


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

		frame.setJMenuBar(menuBar);


		// -------- piano keys panel --------

		// Call the make keys method
		JLayeredPane pianoKeyPanel = makeKeys();
		mainPanel.add(pianoKeyPanel); 
		bpmTextField = new JTextField(2);
	    bpmLabel = new JLabel("Enter Note:", SwingConstants.RIGHT);
        bpmLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        
        
		// Show the window
		frame.setVisible(false);
		frame.setResizable(false);
		frame.setSize(380,250);

	}
	public JLayeredPane makeKeys(){
		// Initialize
		String name = "";
		int x = 55;
		int y = 0;

		// Create layerPane
		JLayeredPane keyBoard = new JLayeredPane();
		keyBoard.setPreferredSize(new Dimension(450,162));
		keyBoard.add(Box.createRigidArea(new Dimension(x, 0)));

		// Add the white key buttons
		for(int i=0; i< NUM_OCTAVES; i++){
			for(int j=0; j<NUM_KEYS; j++){
				//ImageIcon img = new ImageIcon("images/"+notes[j]+".png");
				JButton jb = new JButton();
				jb.setBackground(Color.white);
				name = notes[j];
				jb.setName(name);
				jb.setActionCommand(name);
				jb.addActionListener(this);
				jb.setBounds(x,y,35,162);
				keyBoard.add(jb,new Integer(1));
				keyBoard.add(Box.createRigidArea(new Dimension(2, 0)));
				x += 37;
			}
		}

		// Reinitialize
		x = 0;

		for(int i=0; i< NUM_OCTAVES; i++){


			JButton jb0 = new JButton();
			name = sharps[0];

			jb0.setName(name);
			jb0.setBackground(Color.black);
			jb0.setActionCommand(name);
			jb0.addActionListener(this);

			JButton jb1 = new JButton();
			name = sharps[1];
			jb1.setName(name);
			jb1.setBackground(Color.black);
			jb1.setActionCommand(name);
			jb1.addActionListener(this);

			JButton jb2 = new JButton();
			name = sharps[2];
			jb2.setName(name);
			jb2.setActionCommand(name);
			jb2.setBackground(Color.black);
			jb2.addActionListener(this);

			JButton jb3 = new JButton();
			name = sharps[3];
			jb3.setName(name);
			jb3.setBackground(Color.black);
			jb3.setActionCommand(name);
			jb3.addActionListener(this);

			JButton jb4 = new JButton();
			name = sharps[4];
			jb4.setName(name);
			jb4.setBackground(Color.black);
			jb4.setActionCommand(name);
			jb4.addActionListener(this);

			// Place the 5 keys 
			jb0.setBounds(77+(260*i),y,25,95);
			keyBoard.add(jb0,new Integer(2));

			jb1.setBounds(115+(260*i),y,25,95);
			keyBoard.add(jb1,new Integer(2));

			jb2.setBounds(188+(260*i),y,25,95);
			keyBoard.add(jb2,new Integer(2));

			jb3.setBounds(226+(260*i),y,25,95);
			keyBoard.add(jb3,new Integer(2));

			jb4.setBounds(264+(260*i),y,25,95);
			keyBoard.add(jb4,new Integer(2));
		}
		// Return the keyboard
		return keyBoard;
	}
	public void updateBPM() {
		// TODO Auto-generated method stub
		try{
			bpmOutputLabel.setText("Current Note: " + model.getNotes());
		}
		catch(NullPointerException e){}
	}

	@Override
	public void updateBeat() {
		// TODO Auto-generated method stub
		if (beatBar != null) {
			 beatBar.setValue(100);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = "";
		JButton jb = null;
		String name = "";

		Object obj = e.getSource();
		jb = (JButton)obj;
		name = jb.getName();
		controller.setBPM(name);
	}

	@Override
	public void createView() {
		// TODO Auto-generated method stub
		// Create all Swing components here
		viewPanel = new JPanel(new GridLayout(1, 1));
		viewFrame = new JFrame("Vista - NotasMusicales");
		viewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		viewFrame.setSize(new Dimension(250, 150));
		bpmOutputLabel = new JLabel("", SwingConstants.CENTER);
		bpmOutputLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
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

	@Override
	public void createControls() {
		// TODO Auto-generated method stub
		frame.setVisible(true);
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
	
	@Override
	public void end() {
		// TODO Auto-generated method stub
		frame.setVisible(false);
    	viewFrame.setVisible(false);
	}

	@Override
	public void setModel(BeatModelInterface beat, ControllerInterface controller) {
		// TODO Auto-generated method stub

	}

}
