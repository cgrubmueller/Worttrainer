package cgrubmueller.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This Class creates a WortEintrag-Array and manages it.
 * @author Christian Grubm�ller
 * @version 2019-10-12
 */


public class WortListe implements Serializable {
	//attributes
	private ArrayList<WortEintrag> eintragListe;
	
	//constructor
	
	/**
	 * Die WortListe wird initialiesiert. Die im Parameter �bergebenen W�rter, werden
	 * als erster WortEintrag angelegt.
	 * @param wort ist das Wort des ersten Eintrags
	 * @param ulr ist die URL des ersten Eintrags 
	 */
	public WortListe (String wort, String url) { //damit mindestens ein Eintrag in der Liste ist
		this.eintragListe = new ArrayList<WortEintrag>();
		this.addEintrag(wort, url);
	}
	
	/**
	 * Gibt die Liste zur�ck
	 * @return gibt die Referenz auf das WortEintrag-Array zur�ck.
	 */
	public Object[] getListe() {
		Object[] s = (Object[]) eintragListe.toArray();
		return s;
	}
	
	/**
	 * Diese Methode gibt den WortEintrag am im Parameter �bergeben Index zur�ck.
	 * @param index legt fest welcher WortEintrag zur�ckgegeben wird.
	 * @return WortEintrag am �bergebenen Index
	 */
	public WortEintrag getEintrag(int index) {
		if (index < 0 || index >= eintragListe.size()) throw new IllegalArgumentException("Der Index muss gr��er als Null und kleiner als die Liste lang sein!");
		return eintragListe.get(index);
	}
	
	/**
	 * Ein neuer Eintrag wird mit den im Parameter �bergebenen Daten erstellt und dem Array hinzugef�gt.
	 * @param wort ist das Wort des neuen Eintrags
	 * @param url ist die URL des neuen Eintrags
	 */
	public void addEintrag(String wort, String url) {
		eintragListe.add(new WortEintrag(wort,url));
	}
	
	/**
	 * Diese Methode l�scht den Eintrag, dessen Wort mit dem im Parameter �bergeben Wort �bereinstimmt.
	 * @param wort ist das Wort, dessen Eintrag gel�scht werden soll.
	 * @return wenn erfolgreich gel�scht wurde, wird true zur�ckgegeben, falls nicht wird false zur�ckgegeben.
	 */
	public boolean delEintrag(String wort) {
		for (int i=0; i<eintragListe.size(); i++) {
			if (eintragListe.get(i).getWort().equals(wort)) {
				eintragListe.remove(i);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Diese Methode wandelt die WortListe in einen String um und liefert sie zur�ck.
	 * @return gibt den String, der aus dem WortListe-Objekt erzeugt wird zur�ck.
	 */
	public String toString() {
		String s = "";
		
		for (int i=0; i<this.eintragListe.size(); i++) s = s + this.eintragListe.get(i).toString() + '\n';
		
		return s;
	}
}
