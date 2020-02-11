package cgrubmueller.model;

import java.io.*;
import java.util.Scanner;

/**
 * Diese Klasse verwaltet das serielle Speichern und Auslesen in der Datein für den WortTrainer.
 * @author Christian
 * @version 2019-10-12
 */

public class BinFilezugriff {
	/**
	 * Speichert die Daten, die im WortTrainer enthalten sind.
	 * @param filename ist der Name des Files, in dem gespeichert wird.
	 * @param trainer ist der WortTrainer, der gespeichert werden soll
	 * @throws IOException ist die Exception, die geworfen wir, falls es zu einem Fehlerfall kommt
	 */
	public static void saveWortTrainerObject(String filename, WortTrainer trainer) throws IOException {
		try(ObjectOutputStream outputStream= new ObjectOutputStream(new FileOutputStream(filename))) {
			 outputStream.writeObject(trainer);
		} catch(IOException e) {
				 System.err.println("Fehler beim Schreiben: " + e.toString());
		}
    }
	
	/**
	 * Es werden die Daten des angegbenen Files in den Übergebenen WortTrainer gespeichert.
	 * @param filename ist Name der Datei aus der gelesen wird.
	 * @param trainer ist der WortTrainer in den gespeichert wird.
	 * @throws IOException ist die Excpetion, die im Fehlerfall geworfen wird.
	 */
    public static WortTrainer loadWortTrainerObject(String filename, WortTrainer trainer) throws IOException {
    	try(ObjectInputStream inputStream= new ObjectInputStream(new FileInputStream(filename))) {
    		trainer = (WortTrainer) inputStream.readObject();
    		return trainer;
    	} catch(IOException e) {
    		System.err.println("Fehlerbeim Laden:"+ e.toString());
    	} catch(ClassNotFoundException e) {
    		System.err.println("Fehler beim Laden: "+e.toString());
    	}
    	return null;
    }
    
    /**
	 * Es werden die Daten des default Files("WortTrainer.txt") in den übergebenen WortTrainer gespeichert.
	 * @param trainer ist der WortTrainer in den gespeichert wird.
	 * @throws IOException ist die Excpetion, die im Fehlerfall geworfen wird.
	 */
    public static void saveWortTrainerObject(WortTrainer trainer) throws IOException {
        saveWortTrainerObject("WortTrainer.obj", trainer);
    }
    
    /**
	 * Es werden die Daten des default Files("WortTrainer.txt") in den übergebenen WortTrainer gespeichert.
	 * @param trainer ist der WortTrainer in den gespeichert wird.
	 * @throws IOException ist die Excpetion, die im Fehlerfall geworfen wird.
	 */
    public static WortTrainer loadWortTrainerObject(WortTrainer trainer) throws IOException {
        return loadWortTrainerObject("WortTrainer.obj", trainer);
    }
}
