package cgrubmueller.model;

import java.io.Serializable;

/**
 * Diese Klasse enhält eine WortListe und verwaltet die Überpfüfung der eingegebenen Wörter.
 * @author Christian Grubmüller
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
	 * Gibt die WortListe, die im WortTrainer gespeichert ist, zurück.
	 * @return gibt die Referenz zu der im WortTrainer gespeicherten WortListe zurück.
	 */
	public WortListe getWortListe() {
		return this.liste;
	}
	
	/**
	 * Diese Methode gibt den aktuell ausgewähltem Eintrag der Liste zurück.
	 * @return die Referenz zu dem aktuell ausgewähltem Eintrag.
	 */
	public int getAktEintrag() {
		return this.aktEintrag;
	}
	
	/**
	 * Der aktuell ausgewählte Eintrag wird zu dem im Parameter übergebenen Index gesetzt.
	 * @param newIndex
	 */
	public void setAktEintrag(int newIndex) {
		if (newIndex < 0 || newIndex >= this.liste.getListe().length) throw new IllegalArgumentException("Der neue Index muss größer als Null und kleiner als die Liste lang sein! "); 
		this.aktEintrag = newIndex;
		this.anzWortChecked++;
	}
	
	/**
	 * Setzt die Anzahl der bisher richtigen Antworten
	 * @param anzWortRight
	 */
	public void setAnzWortRight(int anzWortRight) {
		if (anzWortRight < 0 /*|| anzWortRight > this.getWortListe().getWortEintraege().length*/) throw new IllegalArgumentException("Die Anzahl muss größer als 0 und max. so groß wie die Wortliste sein.");
        this.anzWortRight = anzWortRight;
	}
	
	
	/**
	 * Diese Methoden überprüft ob das im Parameter übergeben Wort mit dem aktuell ausgewähltem Wort
	 * übereinstimmen.
	 * @param wort ist das Wort, das überprüft wird.
	 * @return wenn die zwei Wört übereinstimmen, wird true zurückgegeben. Falls nicht, wird false returnt.
	 */
	public boolean checkWort (String wort) {
		if (this.getWortListe().getEintrag(this.getAktEintrag()).getWort().equals(wort)) {
			this.setAnzWortRight(this.getAnzWortRight() + 1);
			return true;
		}
		return false;
	}
	
	/**
	 * Diese Methoden überprüft ob das im Parameter übergeben Wort mit dem aktuell ausgewähltem Wort
	 * übereinstimmt. Dabei ist Großschreibung egal.
	 * @param wort ist das Wort, das überprüft wird.
	 * @return wenn die zwei Wört übereinstimmen, wird true zurückgegeben. Falls nicht, wird false returnt.
	 */
	public boolean checkIgnoreWort(String wort) {
		if(this.getWortListe().getEintrag(this.getAktEintrag()).getWort().toLowerCase().equals(wort.toLowerCase())) {
			this.setAnzWortRight(this.getAnzWortRight() + 1);
			return true;
		}
		return false;
	}
	
	/**
	 * Gibt einen WortEintrag an einer zufälligen Stelle zurück.
	 * @return die Referenz zu einem WortEintrag an einer zufälligen Stelle.
	 */
	public int getRandEintrag() {
		int temp = (int) (Math.random() * (this.liste.getListe().length));
		return temp;
	}
	
	/**
	 * Gibt die Anzahl der bisher abgeprüften Wörter zurück.
	 * @return den Wert, der im Attribut "anzWortChecked" gespeichert.
	 */
	public int getAnzWortChecked () {
		this.anzWortChecked = aktEintrag;
		return this.anzWortChecked;
	}
	
	/**
	 * Gibt die Anzahl der richtig geratenen Wörter zurück.
	 * @return den im Attribut abgespeicherten Wert.
	 */
	public int getAnzWortRight () {
		return this.anzWortRight;
	}
}
