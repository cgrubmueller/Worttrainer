package cgrubmueller.model;

import java.io.Serializable;

/**
 * This class creates a WortEintrag which contains the attributes wort(String and URL(String).
 * It also manages the changes of the attributes and checks if they have a plausible value.
 * @author Christian Grubmüller
 * @version 2019-10-12
 */


public class WortEintrag implements Serializable {
	
	//attributes
	private String wort;
	private String url;
	
	
	//constructor
	/**
	 * Alle Attribute werden durch übergebene Parameter initialisiert.
	 * @param wort
	 * @param url
	 */
	public WortEintrag(String wort, String url) {
		try {
			this.setWort(wort);
		} catch (IllegalArgumentException e) {
			this.wort = "ERROR: Wort fehlerhaft";
		}
		
		try {
			this.setURL(url);
		} catch (IllegalArgumentException e) {
			this.url = "ERROR: URL fehlerhaft";
		}
	}
	
	//methods

	/**
	 * Mit dieser Methode kann man das Attribut "wort" ändern. D
	 * @param wort muss mindesetens 2 Buchstaben haben und darf keine Zahlen und Sonderzeichen enthalten.
	 * @throws IllegalArgumentException wenn die oben angeführten Kriterien nicht erfüllt werden.
	 */
	public void setWort(String wort) throws IllegalArgumentException {
		
		String valid = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQURSTUVWXYZ";
		if (wort.length() >= 2) {
			for (int i=0; i<wort.length(); i++) {
				if (valid.indexOf(wort.charAt(i)) == -1) throw new IllegalArgumentException("Das Wort darf nur Groß - und Kleinbuchstaben enthalten!");
			}
			this.wort = wort;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Der Wert von "wort" wird zurückgegeben
	 * @return gibt den wert vom Attribut "wort" zurück.
	 */
	public String getWort() {
		return this.wort;
	}
	
	/**
	 * Diese Methode ändert den Wert der "url" auf den im Parameter übergebenen Wert, vorausgesetzt es die
	 * "checkURL()"-Methode liefert den wert true zurück.
	 * @param url ist der Wert der überprüft wird und gesetzt wird.
	 * @throws wenn checkURL() mit dem übergebenen Wert false zurückgibt, wird diese Exception geworfen.
	 */
	public void setURL(String url) throws IllegalArgumentException{
		if (checkURL(url) == false) throw new IllegalArgumentException("Die URL muss die richtige Syntax aufweisen");
		this.url = url;
	}
	
	/**
	 * Gibt die URL zurück
	 * @return den Wert, der im Attribut "url" gespeichert ist.
	 */
	public String getURL() {
		return this.url;
	}
	
	/**
	 * Es wird die Übergebene URL überprüft. 
	 * Die URL muss am Anfang "http://" oder "https://" stehen haben.
	 * Anschließend muss ein wird überprüft ob in der Addresse for dem letzten Punkt
	 * nur zulässige Zeichen (auch Zahlen) stehen und danach ob nur Buchstaben sind.
	 * @param url ist der übergebene String der überprüft werden soll.
	 * @return return true if it is plausible and false if it isn't
	 */
	/*public boolean checkURL(String url) {
		
		String valid1 ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQURSTUVWXYZ0123456789-._~";
		String valid2 ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQURSTUVWXYZ";
		
		//checking if the url is long enough 
		if (url.length() >= 10) {  //min "http://s.t"
			
			//checking if there is http:// and https://
			if ((url.substring(0,8).equals("https://") || url.substring(0,7).equals("http://")) == true && url.indexOf('.') != -1) {
				
				//checking the letters after the last point
				for (int i=url.lastIndexOf('.') + 1; ; i++) {
					//if the end of the url is reached the loop stops
					if (i == url.length() - 1) {
						//if there is only 1 letter after the point
						if (i - url.lastIndexOf('.') == 1) return false;
						break;
					}
					//if the checked character is not in valid2 the url is wrong
					if (valid2.indexOf(url.charAt(i)) == -1) return false;
					//checks if there are more than 3 letter after the point
					if (i > url.lastIndexOf('.') + 2) return false;
				}
				
				//checking the letter before the point
				for (int i=url.lastIndexOf('.') - 1; ; i--) {
					
					if (i == url.indexOf(':') + 2 && url.lastIndexOf('.') > url.indexOf(':') + 3) break; //url.indexOf(':') is the second / from https://
					//if the checked character is not in valid1 the url is wrong
					if (valid1.indexOf(url.charAt(i)) == -1) return false;
					if (i < url.indexOf(':') + 2) return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}*/
	public boolean checkURL(String url) {
        String valid1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜabcdefghijklmnopqrstuvwxyzäöü-._~0123456789";
        String valid2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        if (url.length() >= 10) {
            if ((url.substring(0, 8).equals("https://") || url.substring(0, 7).equals("http://")) && url.indexOf('.') != -1) {
                for (int i = url.lastIndexOf('.') + 1; ; i++) {
                    if (i == url.length() - 1) {
                        if (i - url.lastIndexOf('.') == 1) return false;
                        break;
                    }
                    if (valid2.indexOf(url.charAt(i)) == -1) return false;
                    if (i > url.lastIndexOf('.') + 3) return false;
                }

                for (int i = url.lastIndexOf('.') - 1; ; i--) {
                    if (valid1.indexOf(url.charAt(i)) == -1) return false;
                    if (i > url.indexOf(':') + 2) break;
                }

                return true;
            }
        }
        return false;
    }
	
	/**
	 * @return gibt die Werte, die in den Attributen von WortEintrag gespeichert sind, zurück
	 */
	public String toString() {
		return this.wort + "; " + this.url;
	}
}
