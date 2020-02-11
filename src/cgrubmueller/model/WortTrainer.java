package cgrubmueller.model;

import java.io.Serializable;

/**
 * Diese Klasse enh�lt eine WortListe und verwaltet die �berpf�fung der eingegebenen W�rter.
 * @author Christian Grubm�ller
 * @version 2019-10-12
 */


public class WortTrainer implements Serializable {
	
	//attributes
	private WortListe liste;
	private int aktEintrag;
	private int anzWortChecked;
	private int anzWortRight;
	
	//Constructor
	/**
	 * Initialisiert alle Attribute.
	 * @param wort ist das erste Wort
	 * @param url ist die URL zu dem ersten Wort
	 */
	public WortTrainer(String wort, String url) {
		this.liste = new WortListe(wort, url);
		this.aktEintrag = 0;
		this.anzWortChecked = this.aktEintrag;
		this.anzWortRight = 0;
	}
	
	//methoden
	
	/**
	 * Gibt die WortListe, die im WortTrainer gespeichert ist, zur�ck.
	 * @return gibt die Referenz zu der im WortTrainer gespeicherten WortListe zur�ck.
	 */
	public WortListe getWortListe() {
		return this.liste;
	}
	
	/**
	 * Diese Methode gibt den aktuell ausgew�hltem Eintrag der Liste zur�ck.
	 * @return die Referenz zu dem aktuell ausgew�hltem Eintrag.
	 */
	public int getAktEintrag() {
		return this.aktEintrag;
	}
	
	/**
	 * Der aktuell ausgew�hlte Eintrag wird zu dem im Parameter �bergebenen Index gesetzt.
	 * @param newIndex
	 */
	public void setAktEintrag(int newIndex) {
		if (newIndex < 0 || newIndex >= this.liste.getListe().length) throw new IllegalArgumentException("Der neue Index muss gr��er als Null und kleiner als die Liste lang sein! "); 
		this.aktEintrag = newIndex;
		this.anzWortChecked++;
	}
	
	/**
	 * Setzt die Anzahl der bisher richtigen Antworten
	 * @param anzWortRight
	 */
	public void setAnzWortRight(int anzWortRight) {
		if (anzWortRight < 0 /*|| anzWortRight > this.getWortListe().getWortEintraege().length*/) throw new IllegalArgumentException("Die Anzahl muss gr��er als 0 und max. so gro� wie die Wortliste sein.");
        this.anzWortRight = anzWortRight;
	}
	
	
	/**
	 * Diese Methoden �berpr�ft ob das im Parameter �bergeben Wort mit dem aktuell ausgew�hltem Wort
	 * �bereinstimmen.
	 * @param wort ist das Wort, das �berpr�ft wird.
	 * @return wenn die zwei W�rt �bereinstimmen, wird true zur�ckgegeben. Falls nicht, wird false returnt.
	 */
	public boolean checkWort (String wort) {
		if (this.getWortListe().getEintrag(this.getAktEintrag()).getWort().equals(wort)) {
			this.setAnzWortRight(this.getAnzWortRight() + 1);
			return true;
		}
		return false;
	}
	
	/**
	 * Diese Methoden �berpr�ft ob das im Parameter �bergeben Wort mit dem aktuell ausgew�hltem Wort
	 * �bereinstimmt. Dabei ist Gro�schreibung egal.
	 * @param wort ist das Wort, das �berpr�ft wird.
	 * @return wenn die zwei W�rt �bereinstimmen, wird true zur�ckgegeben. Falls nicht, wird false returnt.
	 */
	public boolean checkIgnoreWort(String wort) {
		if(this.getWortListe().getEintrag(this.getAktEintrag()).getWort().toLowerCase().equals(wort.toLowerCase())) {
			this.setAnzWortRight(this.getAnzWortRight() + 1);
			return true;
		}
		return false;
	}
	
	/**
	 * Gibt einen WortEintrag an einer zuf�lligen Stelle zur�ck.
	 * @return die Referenz zu einem WortEintrag an einer zuf�lligen Stelle.
	 */
	public int getRandEintrag() {
		int temp = (int) (Math.random() * (this.liste.getListe().length));
		return temp;
	}
	
	/**
	 * Gibt die Anzahl der bisher abgepr�ften W�rter zur�ck.
	 * @return den Wert, der im Attribut "anzWortChecked" gespeichert.
	 */
	public int getAnzWortChecked () {
		this.anzWortChecked = aktEintrag;
		return this.anzWortChecked;
	}
	
	/**
	 * Gibt die Anzahl der richtig geratenen W�rter zur�ck.
	 * @return den im Attribut abgespeicherten Wert.
	 */
	public int getAnzWortRight () {
		return this.anzWortRight;
	}
}
