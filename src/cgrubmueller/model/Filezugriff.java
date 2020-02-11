package cgrubmueller.model;

import java.io.*;
import java.util.Scanner;

/**
 * Diese Klasse verwaltet das Speichern und Auslesen in der Datein für den WortTrainer.
 * @author Christian
 * @version 2019-10-12
 */

public class Filezugriff {
	/**
	 * Speichert die Daten, die im WortTrainer enthalten sind.
	 * @param filename ist der Name des Files, in dem gespeichert wird.
	 * @param trainer ist der WortTrainer, der gespeichert werden soll
	 * @throws IOException ist die Exception, die geworfen wir, falls es zu einem Fehlerfall kommt
	 */
	public static void saveWortTrainer(String filename, WortTrainer trainer) throws IOException {
        File f = new File(filename);
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(f);
            for (int i = 0; i < trainer.getWortListe().getListe().length; i++) {
                outputStream.println(trainer.getWortListe().getEintrag(i));
            }
            outputStream.println(trainer.getAktEintrag() + "; " + trainer.getAnzWortChecked() + "; " + trainer.getAnzWortRight());
        } finally {
            if (outputStream != null) outputStream.close();
        }
    }
	
	/**
	 * Es werden die Daten des angegbenen Files in den Übergebenen WortTrainer gespeichert.
	 * @param filename ist Name der Datei aus der gelesen wird.
	 * @param trainer ist der WortTrainer in den gespeichert wird.
	 * @throws IOException ist die Excpetion, die im Fehlerfall geworfen wird.
	 */
    public static void loadWortTrainer(String filename, WortTrainer trainer) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = null;
        Scanner s = null;
        String[] cache;
        try {
            br = new BufferedReader(fr);
            s = new Scanner(br);
            s.useDelimiter("; ");
            trainer.getWortListe().delEintrag(trainer.getWortListe().getEintrag(0).getWort());
            while (s.hasNextLine()) {
                cache = s.nextLine().split("; ");
                if (cache[0].matches("[0-9]+")) {
                    trainer.setAktEintrag(Integer.parseInt(cache[0]));
                    trainer.setAnzWortRight(Integer.parseInt(cache[2]));
                } else {
                    trainer.getWortListe().addEintrag(cache[0], cache[1]);
                }
            }
        } finally {
            if (br != null) br.close();
            if (s != null) s.close();
        }
    }
    
    /**
	 * Es werden die Daten des default Files("WortTrainer.txt") in den übergebenen WortTrainer gespeichert.
	 * @param trainer ist der WortTrainer in den gespeichert wird.
	 * @throws IOException ist die Excpetion, die im Fehlerfall geworfen wird.
	 */
    public static void saveWortTrainer(WortTrainer trainer) throws IOException {
        saveWortTrainer("WortTrainer.txt", trainer);
    }
    
    /**
	 * Es werden die Daten des default Files("WortTrainer.txt") in den übergebenen WortTrainer gespeichert.
	 * @param trainer ist der WortTrainer in den gespeichert wird.
	 * @throws IOException ist die Excpetion, die im Fehlerfall geworfen wird.
	 */
    public static void loadWortTrainer(WortTrainer trainer) throws IOException {
        loadWortTrainer("WortTrainer.txt", trainer);
    }
}
