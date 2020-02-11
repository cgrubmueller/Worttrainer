package cgrubmueller.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import cgrubmueller.model.*;
import cgrubmueller.view.*;

public class WortTrainerController implements ActionListener {

	private WortTrainerLayout l1;
	private AddWortLayout l2;
	private WortTrainerFrame f1;
	private DialogFrame f2;
	private WortTrainer t1;
	
	public WortTrainerController() {
		this.t1 = new WortTrainer("Hund", "https://www.zooroyal.de/magazin/wp-content/uploads/2017/06/hund-im-sommer-760x560.jpg");
		this.l1 = new WortTrainerLayout(this);
		this.f1 = new WortTrainerFrame("Worttrainer", this.l1, this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String ac = e.getActionCommand();
        if (ac.equals("enter")) {
            try {
            	if (this.t1.checkWort(this.l1.getGuessText())) {
	            	this.l1.refreshInt(this.t1.getAnzWortRight(), this.t1.getWortListe().getListe().length);
	            }
	        	this.t1.setAktEintrag(this.t1.getRandEintrag());
	            this.l1.refreshImg(this.t1.getWortListe().getEintrag(this.t1.getAktEintrag()).getURL());
	            
            } catch (IllegalArgumentException e1) {
            	this.l1.message("Fehler bei der Abfrage", "Fehler", JOptionPane.ERROR_MESSAGE);
            }
            
        } else if (ac.equals("Reset")) {
        	this.t1.setAnzWortRight(0);
        	this.l1.refreshInt(this.t1.getAnzWortRight(), this.t1.getWortListe().getListe().length);
        	
        } else if (ac.equals("Add Wort")) {
        	String newWort = JOptionPane.showInputDialog("Geben Sie ein neues Wort ein!");
        	String newURL = JOptionPane.showInputDialog("Geben Sie eine neue URL ein!");
        	this.t1.getWortListe().addEintrag(newWort, newURL);
        	
        	/*this.l2 = new AddWortLayout(this);
        	this.f2 = new DialogFrame(this.l2, this);*/
        	
        } else if (ac.equals("Wort hinzufügen")) {
        	System.out.println(this.l2.getNewWort() + " " + this.l2.getNewURL());
        	this.t1.getWortListe().addEintrag("Wort"/*this.l2.getNewWort()*/,"https://www.oracle.com/splash/1577756.png" /*this.l2.getNewURL()*/);
        	this.l1.refreshInt(this.t1.getAnzWortRight(), this.t1.getWortListe().getListe().length);
        	System.out.println("Button gedrückt");
        	this.f2.dispose();
        	
        } else if (ac.equals("Save")) {
        	System.out.println("save method");
        	try {
	        	if (f1.getBinaerChecked() == true) {
	        		cgrubmueller.model.BinFilezugriff.saveWortTrainerObject(t1);
	        		System.out.println("Saved Binär");
	        	} else {
	        		cgrubmueller.model.Filezugriff.saveWortTrainer(t1);
	        		System.out.println("Saved");
	        	}
        	} catch (IOException io1) {
        		 
        	}
        } else if (ac.equals("Load")) {
        	System.out.println("load method");
        	try {
	        	if (f1.getBinaerChecked() == true) {
	        		this.t1 = cgrubmueller.model.BinFilezugriff.loadWortTrainerObject(t1);
	        		System.out.println("laod binär");
	        	} else {
	        		cgrubmueller.model.Filezugriff.loadWortTrainer(t1);
	        		System.out.println("load");
	        	}
        	} catch (IOException io2) {
        		
        	}
        }
	}
	
	public int getAnzWoerter() {
		return this.t1.getWortListe().getListe().length;
	}
	
	public int getAnzWortRight() {
		return this.t1.getAnzWortRight();
	}
	
	public String getURL() {
		return this.t1.getWortListe().getEintrag(this.t1.getAktEintrag()).getURL();
	}
}
