package MusicalNotes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Beat.BeatBar;
import Beat.BeatModelInterface;
import Beat.BeatObserver;
import Beat.ControllerInterface;
import Heart.BPMObserver;

public class MusicalNotesView implements ActionListener, BPMObserver {

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
	private JButton setBPMButtonDO;
	private JButton setBPMButtonRE;
	private JButton setBPMButtonMI;
	private JButton setBPMButtonFA;
	private JButton setBPMButtonSOL;
	private JButton setBPMButtonSI;
	private JButton setBPMButtonLA;

	public MusicalNotesView(ControllerInterface controller,
			MusicalNotesModelInterface model) {
		this.controller = controller;
		this.model = model;
		model.registerObserver((BPMObserver) this);

	}

	public void createView() {
		// Create all Swing components here
		viewPanel = new JPanel(new GridLayout(1, 2));
		viewFrame = new JFrame("Vista - NotasMusicales");
		viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewFrame.setSize(new Dimension(100, 80));
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
		controlFrame = new JFrame("Control - Notas Musicales");
		controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		controlFrame.setSize(new Dimension(250, 150));

		controlPanel = new JPanel(new GridLayout(1, 2));

		menuBar = new JMenuBar();
		menu = new JMenu("Notas Musicales Control");
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
		bpmLabel = new JLabel("Enter BPM:", SwingConstants.RIGHT);
		
		
		
		/*
		 * Creo titulo para los botones
		 */
		JLabel buttonsTitle = new JLabel("Estas son tus Notas Musicales");
		
		/*
		 * Creo botones para cada nota!!!
		 * Creo el Panel donde van estar los botones de las notas
		 */
		JPanel buttonPanelNotas = new JPanel(new GridLayout(8, 1));
		
		setBPMButtonDO = new JButton("DO");
		setBPMButtonDO.setSize(new Dimension(10, 40));
		setBPMButtonRE = new JButton("RE");
		setBPMButtonRE.setSize(new Dimension(10, 40));
		setBPMButtonMI = new JButton("MI");
		setBPMButtonMI.setSize(new Dimension(10, 40));
		setBPMButtonFA = new JButton("FA");
		setBPMButtonFA.setSize(new Dimension(10, 40));
		setBPMButtonSOL = new JButton("SOL");
		setBPMButtonSOL.setSize(new Dimension(10, 40));
		setBPMButtonLA = new JButton("LA");
		setBPMButtonLA.setSize(new Dimension(10, 40));
		setBPMButtonSI = new JButton("SI");
		setBPMButtonSI.setSize(new Dimension(10, 40));
		
		/*
		 * Agrego los botones al panel de notas
		 */
		buttonPanelNotas.add(setBPMButtonDO);
		buttonPanelNotas.add(setBPMButtonDO);
		buttonPanelNotas.add(setBPMButtonRE);
		buttonPanelNotas.add(setBPMButtonMI);
		buttonPanelNotas.add(setBPMButtonFA);
		buttonPanelNotas.add(setBPMButtonSOL);
		buttonPanelNotas.add(setBPMButtonLA);
		buttonPanelNotas.add(setBPMButtonSI);
		
		increaseBPMButton = new JButton(">>");
		decreaseBPMButton = new JButton("<<");
		
		/*
		 * Agrego Listeners a los botones!
		 */
		setBPMButtonDO.addActionListener(this);
		setBPMButtonRE.addActionListener(this);
		setBPMButtonMI.addActionListener(this);
		setBPMButtonFA.addActionListener(this);
		setBPMButtonSOL.addActionListener(this);
		setBPMButtonLA.addActionListener(this);
		setBPMButtonSI.addActionListener(this);
		
		increaseBPMButton.addActionListener(this);
		decreaseBPMButton.addActionListener(this);

		JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

		buttonPanel.add(decreaseBPMButton);
		buttonPanel.add(increaseBPMButton);

		//JPanel enterPanel = new JPanel(new GridLayout(1, 2));
		//enterPanel.add(bpmLabel);
		//enterPanel.add(bpmTextField);
		/*
		 * Creo Panel contenedor. Añado los distintos paneles
		 */
		JPanel insideControlPanel = new JPanel(new GridLayout(3, 1));
		//insideControlPanel.add(enterPanel);
		insideControlPanel.add(buttonPanelNotas);
		insideControlPanel.add(buttonPanel);
		
		
		controlPanel.add(insideControlPanel);

		bpmLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		bpmOutputLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		controlFrame.getRootPane().setDefaultButton(setBPMButtonDO);
		controlFrame.getContentPane().add(controlPanel, BorderLayout.CENTER);

		controlFrame.pack();
		controlFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == setBPMButtonDO) {
			// int bpm = Integer.parseInt(bpmTextField.getText());
			controller.setBPM("DO");
		} else if(event.getSource() == setBPMButtonRE){
			controller.setBPM("RE");
		} else if(event.getSource() == setBPMButtonMI){
			controller.setBPM("MI");
		} else if(event.getSource() == setBPMButtonFA){
			controller.setBPM("FA");
		} else if(event.getSource() == setBPMButtonSOL){
			controller.setBPM("SOL");
		} else if(event.getSource() == setBPMButtonLA){
			controller.setBPM("LA");
		} else if(event.getSource() == setBPMButtonSI){
			controller.setBPM("SI");
		}
		else if (event.getSource() == increaseBPMButton) {
			controller.increaseBPM();
		}
			
		 else if (event.getSource() == decreaseBPMButton) {
			controller.decreaseBPM();
		}

	}

	@Override
	public void updateBPM() {
		// TODO Auto-generated method stub
		if (model != null) {

			int bpm = model.getNotes();
			if (bpm == 0){

				if (bpmOutputLabel != null) { 
					bpmOutputLabel.setText("offline"); 
				} 
			} else { 
				if(bpmOutputLabel != null)	{
					bpmOutputLabel.setText("Nota: " + model.getNotes());

					
				}
			} 
		}

	}
	

}
