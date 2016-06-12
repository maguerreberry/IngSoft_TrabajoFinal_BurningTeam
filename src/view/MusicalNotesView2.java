package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

import java.awt.color.*;

import controller.ControllerInterface;
import model.MusicalNotesModelInterface;

public class MusicalNotesView2 implements ActionListener, BPMObserver, ViewInterface {

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
		private JButton setBPMButtonDO_;
		private JButton setBPMButtonRE_;
		private JButton setBPMButtonLA_;
		private JButton setBPMButtonFA_;
		private JButton setBPMButtonSOL_;

		public MusicalNotesView2(ControllerInterface controller,MusicalNotesModelInterface model) {
			this.controller = controller;
			this.model = model;
			model.registerObserver((BPMObserver) this);

		}

		public void createView() {
			// Create all Swing components here
			viewPanel = new JPanel(new GridLayout(1, 1));
			viewFrame = new JFrame("Vista - NotasMusicales");
			viewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			viewFrame.setSize(new Dimension(250, 150));
			//bpmOutputLabel = new JLabel("offline", SwingConstants.CENTER);
			beatBar = new BeatBar();
			beatBar.setValue(0);
			JPanel bpmPanel = new JPanel(new GridLayout(2, 1));
			bpmPanel.add(beatBar);
			//bpmPanel.add(bpmOutputLabel);
			viewPanel.add(bpmPanel);
			viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
			viewFrame.pack();
			viewFrame.setVisible(true);
			
			
		}

		public void createControls() {
			// Create all Swing components here
			JFrame.setDefaultLookAndFeelDecorated(true);
			controlFrame = new JFrame("Control - Notas Musicales");
			controlFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
					end();
				}
			});

			menu.add(exit);
			menuBar.add(menu);
			controlFrame.setJMenuBar(menuBar);

			bpmTextField = new JTextField(2);
			bpmLabel = new JLabel("Enter BPM:", SwingConstants.RIGHT);
			
	JLabel buttonsTitle = new JLabel("Estas son tus Notas Musicales");
			
			/*
			 * Creo botones para cada nota!!!
			 * Creo el Panel donde van estar los botones de las notas
			 */
			
			JPanel buttonPanelNotas = new JPanel(null);
			
			buttonPanelNotas.setLayout(null);
			
			setBPMButtonDO = new JButton("DO");
			setBPMButtonDO.setBackground(Color.WHITE);
			setBPMButtonDO.setLocation(0 * 40, 0);
			setBPMButtonDO.setSize(new Dimension(40, 280));
		
			
			
			setBPMButtonRE = new JButton("RE");
			setBPMButtonRE.setBackground(Color.WHITE);
			setBPMButtonRE.setLocation(1 * 40, 0);
			setBPMButtonRE.setSize(new Dimension(40, 280));
					
			
			setBPMButtonMI = new JButton("MI");
			setBPMButtonMI.setBackground(Color.WHITE); 
			setBPMButtonMI.setLocation(2 * 40, 0);
			setBPMButtonMI.setSize(new Dimension(40, 280));
			
			
			setBPMButtonFA = new JButton("FA");
			setBPMButtonFA.setBackground(Color.WHITE); 
			setBPMButtonFA.setLocation(3 * 40, 0);
			setBPMButtonFA.setSize(new Dimension(40, 280));
			
			setBPMButtonSOL = new JButton("SOL");
			setBPMButtonSOL.setBackground(Color.WHITE); 
			setBPMButtonSOL.setLocation(4 * 40, 0);
			setBPMButtonSOL.setSize(new Dimension(40, 280));
			
			setBPMButtonLA = new JButton("LA");
			setBPMButtonLA.setBackground(Color.WHITE); 
			setBPMButtonLA.setLocation(5 * 40, 0);
			setBPMButtonLA.setSize(new Dimension(40, 280));
			
			setBPMButtonSI = new JButton("SI");
			setBPMButtonSI.setBackground(Color.WHITE); 
			setBPMButtonSI.setLocation(6 * 40, 0);
			setBPMButtonSI.setSize(new Dimension(40, 280));
			
			setBPMButtonDO_ = new JButton("DO#");
			setBPMButtonDO_.setBackground(Color.BLACK);
			setBPMButtonDO_.setLocation(0 * 40 + 24, 0);
			setBPMButtonDO_.setSize(new Dimension(32, 200));
		
			
			setBPMButtonRE_ = new JButton("RE");
			setBPMButtonRE_.setBackground(Color.BLACK);
			setBPMButtonRE_.setLocation(1 * 40 + 24, 0);
			setBPMButtonRE_.setSize(new Dimension(32, 200));
			
			setBPMButtonLA_ = new JButton("LA#");
			setBPMButtonLA_.setBackground(Color.BLACK);
			setBPMButtonLA_.setLocation(5 * 40 + 24, 0);
			setBPMButtonLA_.setSize(new Dimension(32, 200));
		
			
			setBPMButtonFA_ = new JButton("FA#");
			setBPMButtonFA_.setBackground(Color.BLACK);
			setBPMButtonFA_.setLocation(3 * 40 + 24, 0);
			setBPMButtonFA_.setSize(new Dimension(32, 200));
			
			setBPMButtonSOL_ = new JButton("SOL#");
			setBPMButtonSOL_.setBackground(Color.BLACK);
			setBPMButtonSOL_.setLocation(4 * 40 + 24, 0);
			setBPMButtonSOL_.setSize(new Dimension(32, 200));
			
			/*
			 * Agrego los botones al panel de notas
			 */
			buttonPanelNotas.add(setBPMButtonDO);
			buttonPanelNotas.setComponentZOrder(setBPMButtonDO, 0);
			//setBPMButtonDO.moveToBack();
			buttonPanelNotas.add(setBPMButtonDO_);
			buttonPanelNotas.setComponentZOrder(setBPMButtonDO_, 1);
			buttonPanelNotas.add(setBPMButtonRE);
			buttonPanelNotas.setComponentZOrder(setBPMButtonRE, 2);
			buttonPanelNotas.add(setBPMButtonRE_);
			buttonPanelNotas.setComponentZOrder(setBPMButtonRE_, 3);
			buttonPanelNotas.add(setBPMButtonMI);
			buttonPanelNotas.setComponentZOrder(setBPMButtonMI, 4);
			buttonPanelNotas.add(setBPMButtonFA);
			buttonPanelNotas.setComponentZOrder(setBPMButtonFA, 5);
			buttonPanelNotas.add(setBPMButtonFA_);
			buttonPanelNotas.setComponentZOrder(setBPMButtonFA_, 6);
			buttonPanelNotas.add(setBPMButtonSOL);
			buttonPanelNotas.setComponentZOrder(setBPMButtonSOL, 7);
			buttonPanelNotas.add(setBPMButtonSOL_);
			buttonPanelNotas.setComponentZOrder(setBPMButtonSOL_, 8);
			buttonPanelNotas.add(setBPMButtonLA);
			buttonPanelNotas.setComponentZOrder(setBPMButtonLA, 9);
			buttonPanelNotas.add(setBPMButtonLA_);
			buttonPanelNotas.setComponentZOrder(setBPMButtonLA_, 10);
			buttonPanelNotas.add(setBPMButtonSI);
			buttonPanelNotas.setComponentZOrder(setBPMButtonSI, 11);
			
			increaseBPMButton = new JButton(">>");
			decreaseBPMButton = new JButton("<<");
			
			/*
			 * Agrego Listeners a los botones!
			 */
			setBPMButtonDO.addActionListener(this);
			setBPMButtonRE.addActionListener(this);
			setBPMButtonDO_.addActionListener(this);
			setBPMButtonRE_.addActionListener(this);
			setBPMButtonMI.addActionListener(this);
			setBPMButtonFA.addActionListener(this);
			setBPMButtonSOL.addActionListener(this);
			setBPMButtonLA.addActionListener(this);
			setBPMButtonFA_.addActionListener(this);
			setBPMButtonSOL_.addActionListener(this);
			setBPMButtonLA_.addActionListener(this);
			setBPMButtonSI.addActionListener(this);
			
			controlPanel.add(buttonPanelNotas);
			
			/*
			 * Creo titulo para los botones
			 */
			//JLabel buttonsTitle = new JLabel("Estas son tus Notas Musicales");
			
			/*
			 * Creo botones para cada nota!!!
			 * Creo el Panel donde van estar los botones de las notas
			 */
			/*
			
			increaseBPMButton.addActionListener(this);
			decreaseBPMButton.addActionListener(this);

			JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
			
			buttonPanel.add(decreaseBPMButton);
			buttonPanel.add(increaseBPMButton);
			
			
			JPanel titlePanel = new JPanel(new GridLayout(1, 2));
			JLabel IDTitle = new JLabel("Subí o Bajá Semitonos!" , SwingConstants.CENTER);
			titlePanel.add(IDTitle);
			*/
			
			//JPanel enterPanel = new JPanel(new GridLayout(1, 2));
			//enterPanel.add(bpmLabel);
			//enterPanel.add(bpmTextField);
			/*
			 * Creo Panel contenedor. Añado los distintos paneles
			 */
			JPanel insideControlPanel = new JPanel(new GridLayout(3, 1));
			//insideControlPanel.add(enterPanel);
			//insideControlPanel.add(buttonPanelNotas);
			//insideControlPanel.add(titlePanel);
			//insideControlPanel.add(buttonPanel);
			
			
			controlPanel.add(insideControlPanel);
			

			bpmLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			//bpmOutputLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

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
			} else if(event.getSource() == setBPMButtonRE_){
				controller.setBPM("RE#");
			} else if(event.getSource() == setBPMButtonFA_){
				controller.setBPM("FA#");
			} else if(event.getSource() == setBPMButtonSOL_){
				controller.setBPM("SOL#");
			} else if(event.getSource() == setBPMButtonDO_){
				controller.setBPM("DO#");
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

		@Override
		public void setModel() {
			// TODO Auto-generated method stub
			
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
		

	}

