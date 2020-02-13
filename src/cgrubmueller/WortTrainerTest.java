package cgrubmueller;

import java.io.IOException;

import cgrubmueller.controller.WortTrainerController;
import cgrubmueller.model.BinFilezugriff;
import cgrubmueller.model.Filezugriff;
import cgrubmueller.model.WortEintrag;
import cgrubmueller.model.WortListe;
import cgrubmueller.model.WortTrainer;
import cgrubmueller.view.WortTrainerFrame;
import cgrubmueller.view.WortTrainerLayout;

/**
 * This class tests all the methods.
 * @author Christian Grubmüller
 * @version 2019-10-09
 */

public class WortTrainerTest {
	public static void main(String[] args) {
		System.out.println("***** WortEintrag - Test *****");
		
		WortEintrag e1 = new WortEintrag("Wort","http://www.wort.at");
		
		System.out.println("Vor der Bearbeitung:");
		System.out.println(e1.toString());
		
		System.out.println("___________");
		
		try {
			e1.setWort("e1");
		} catch (IllegalArgumentException e) {
			System.out.println("Fehler bei e1.setWort()");
		}
		try {
			e1.setURL("bla bla");
		} catch (IllegalArgumentException e) {
			System.out.println("Fehler be e1.setURL()");
		}
		
		System.out.println("\nNach fehlerhafter Bearbeitung:");
		System.out.println(e1.toString());
		
		try {
			e1.setWort("Hund");
		} catch (IllegalArgumentException e) {
			System.out.println("Fehler bei e1.setWort()");
		}
		try {
			e1.setURL("https://www.orf.at");
		} catch (IllegalArgumentException e) {
			System.out.println("Fehler be e1.setURL()");
		}
		
		System.out.println("\nNach richtiger Bearbeitung");
		System.out.println(e1.toString());
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("***** WortListe *****");
		
		WortListe l1 = new WortListe("Laptop", "https://s.to");
		
		System.out.println("Vor dem Hinzufügen:");
		System.out.println(l1.toString());
		
		l1.addEintrag("bla", "https://elearning.tgm.ac.at");
		l1.addEintrag("WTF", "http://owa.tgm.ac.at");
		l1.addEintrag("Hamster", "http://stpl.tgm.ac.at");
		
		System.out.println("Nach dem Hinzufügen & vor der Bearbeitung:");
		System.out.println(l1.toString());

		System.out.println();
		
		try {
			System.out.println("Worteintrag mit dem Index: 2");
			System.out.println(l1.getEintrag(2) + "" + '\n');
		} catch (IllegalArgumentException e) {
			System.out.println("Fehler bei der Ausgabe mit dem Index");
		}
		
		l1.delEintrag("WTF");
		System.out.println("Nach der Löschung von WTF:");
		System.out.println(l1.toString() + '\n');
		
		System.out.println("Durchschnittliche Wörtlänge:");
		System.out.println(l1.averageWordLength());
		System.out.println();
		
		l1.filter(3);
		System.out.println("Nach dem Filtern auf Wörter mit 3 Zeichen:");
		System.out.println(l1.toString() + '\n');
		
		System.out.println("***** WortTest *****");
		
		WortTrainer t1 = new WortTrainer("Meerschweinchen", "http://www.atom.com");
		
		t1.getWortListe().addEintrag("Maus", "http://eclipse.org");
		t1.getWortListe().addEintrag("Geldboerse", "http://ezb.eu");
		t1.getWortListe().addEintrag("Maus", "http://www.atom.org");
		System.out.println("Bisherige Wortliste:");
		System.out.println(t1.getWortListe().toString());
		
		t1.setAktEintrag(1);
		
		System.out.println("Überprüft ob das Wort 'Maus' dem aktuell ausgewähltem Eintrag entspricht.");
		if (t1.checkWort("Maus") == true) System.out.println("Maus stimmt.\n"); 
		
		System.out.println("Überprüft ob das Wort 'MaUS' dem aktuell ausgewähltem Eintrag entspricht");
		if (t1.checkIgnoreWort("MaUS") == true) System.out.println("MaUS stimmt.\n"); 
		
		System.out.println("Wortliste:");
		System.out.println(t1.getWortListe().toString());
		System.out.println("Ausgewaehlter Eintrag:");
		System.out.println(t1.getAktEintrag());
		System.out.println("Anzahl der abgefragten Woerter");
		System.out.println(t1.getAnzWortChecked());
		System.out.println("Anzahl der richtigen Woerter:");
		System.out.println(t1.getAnzWortRight());
	

		System.out.println("***** FileZugriff ******");
		
		try {
			Filezugriff.saveWortTrainer(t1);
		} catch (IOException e) {
			System.out.println("Fehler beim Speicher der Trainers");
		}
		
		WortTrainer t2 = new WortTrainer("Trainer", "http://bla.sew.bla");
		try {
			Filezugriff.loadWortTrainer(t2);
		} catch (IOException e) {
			System.out.println("Fehler beim Laden des Trainers");
		}
		
		System.out.println("Geladene Wortliste:");
		System.out.println(t2.getWortListe().toString());
		System.out.println("Geladene ausgewaehlter Eintrag:");
		System.out.println(t2.getAktEintrag());
		System.out.println("Geladene Anzahl der abgefragten Woerter");
		System.out.println(t2.getAnzWortChecked());
		System.out.println("Geladene Anzahl der richtigen Woerter:");
		System.out.println(t2.getAnzWortRight());
		
		System.out.println();
		System.out.println("Geladener Trainer .toString(): ");
		System.out.println(t2.toString()+ "\n\n");
		
		
		System.out.println("***** BinFilezugriff ******\n");
		
		try {
			BinFilezugriff.saveWortTrainerObject(t1);
		} catch (IOException e) {
			System.out.println("Fehler beim Speicher der Trainers");
		}
		
		WortTrainer t3 = new WortTrainer("Trainer", "http://bla.sew.bla");
		try {
			t3 = BinFilezugriff.loadWortTrainerObject(t3);
		} catch (IOException e) {
			System.out.println("Fehler beim Laden des Trainers");
		}
		
		System.out.println("seriell Geladene Wortliste:");
		System.out.println(t3.getWortListe().toString());
		System.out.println("seriell Geladene ausgewaehlter Eintrag:");
		System.out.println(t3.getAktEintrag());
		System.out.println("seriell Geladene Anzahl der abgefragten Woerter");
		System.out.println(t3.getAnzWortChecked());
		System.out.println("seriell Geladene Anzahl der richtigen Woerter:");
		System.out.println(t3.getAnzWortRight());
		
		System.out.println();
		System.out.println("Geladener Trainer .toString(): ");
		System.out.println(t3.toString() + "\n\n");
		
		System.out.println("***** GUI *****");
		System.out.println("NUR die GUI OHNE Funktionalität");
		System.out.println("Für Funktionalität führe 'WortTrainerControllerTest.java' aus");
		
		WortTrainerLayout l2 = new WortTrainerLayout(new WortTrainerController());
		WortTrainerFrame f1 = new WortTrainerFrame("WortTrainer", l2, new WortTrainerController());
		System.out.println("GUI geladen");
	}
}