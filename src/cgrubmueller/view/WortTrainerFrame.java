package cgrubmueller.view;

import java.awt.*;
import javax.swing.*;

import cgrubmueller.controller.WortTrainerController;

/**
 * In dieser Klasse erbt von einem JFrame und zeigt die WortTrainerLayout-Klasse an.
 * @author Christian
 * @version 2019-10-12
 */

public class WortTrainerFrame extends JFrame{
	
	private WortTrainerController c1;
	
	private JMenuBar menuBar;
	
	private JMenu spiel;
	private JMenu datei;

	private JMenu menuCheckBox;
	private JMenuItem menuSave;
	private JMenuItem menuLoad;
	private JMenuItem menuReset;
	private JMenuItem menuAddWort;
	
	private JFileChooser saveChooser;
	private JFileChooser loadChooser;
	private JCheckBoxMenuItem checkBoxBinaer;
	
	public WortTrainerFrame(String titel, WortTrainerLayout layout, WortTrainerController c) {
		this.c1 = c;
		
		this.setTitle(titel);
		this.setSize(new Dimension(500,600));
		//Eine MenuBar wird erstellt
		this.menuBar = new JMenuBar();
		
		//Ein Menu, das Spiel heiﬂt, wird erstellt
		this.spiel = new JMenu("Spiel");
//		this.spiel.setFont(layout.getFontButton());
		
		this.menuReset = new JMenuItem("Reset");
		this.menuReset.addActionListener(c1);
		
		this.menuAddWort = new JMenuItem("Add Wort");
		this.menuAddWort.addActionListener(c1);
		
		this.spiel.add(menuReset);
		this.spiel.add(menuAddWort);
		
		this.menuBar.add(spiel);
		
		
		//Ein Menu, das Datei heiﬂt, wird erstellt
		this.datei = new JMenu("Datei");
//		this.datei.setFont(layout.getFontButton());
		this.saveChooser = new JFileChooser();
		this.loadChooser = new JFileChooser();
		this.checkBoxBinaer = new JCheckBoxMenuItem("Bin‰re Speicherung");
		
		this.menuSave = new JMenuItem("Save");
		this.menuSave.addActionListener(c1);
		this.menuLoad = new JMenuItem("Load");
		this.menuLoad.addActionListener(c1);
		
//		this.menuSave.add(saveChooser);
//		this.menuLoad.add(loadChooser);
		
		this.datei.add(this.checkBoxBinaer);
		this.datei.add(menuSave);
		this.datei.add(menuLoad);
		
		this.menuCheckBox = new JMenu("");
		
		this.menuBar.add(datei);
		
		
		this.add(menuBar, BorderLayout.NORTH);
		
		this.add(layout);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public boolean getBinaerChecked() {
		return this.checkBoxBinaer.getState();
	}
}
