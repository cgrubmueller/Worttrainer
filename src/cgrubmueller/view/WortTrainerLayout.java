package cgrubmueller.view;

import java.awt.*;
import javax.swing.*;

import cgrubmueller.controller.WortTrainerController;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * Diese Klasse erbt von einem JPanel und zeigt alle wichtigen Labels, Textfields, Bilder und Button an.
 * Außerdem gibt es Funktionen um Das Bild zu änder und den Score anzuspassen.
 * @author Christian Grubmüller
 * @version 2019-10-12
 */

public class WortTrainerLayout extends JPanel{
	private final int BILDHOEHE = 300; //in Pixel
	
	private WortTrainerController c1;
	
	private Container north;
	private Container south;
	private Container southOben;
	private Container southUnten;
	
	private JLabel question;
	private JTextField guessText;
	
	private URL url;
	private JLabel imgLabel;
	private ImageIcon icon;
	private Image image;
	
	private JLabel richtigeWoerter;
	private JLabel anzRightWords;
	private JLabel anzahlWoerter;
	private JLabel anzWords;
	
	/**
	 * Der Konstrktor ist die Methode in dem alles erzeugt wird, das später hinzugefügt und angezeigt wird.
	 */
	public WortTrainerLayout(WortTrainerController c) {
		this.setLayout(new BorderLayout());
		
		this.c1 = c;
		
		Font fontDefault = new Font("Dialog" , Font.ITALIC + Font.BOLD, 14);
        Font fontButton = new Font(fontDefault.getFamily(), Font.BOLD, fontDefault.getSize());
        Font fontInput =  new Font(fontDefault.getFamily(), Font.BOLD, fontDefault.getSize() + 2);
		
		//*****NORTH*****
		this.north = new Container();
		this.north.setLayout(new GridLayout(2,1,0,5));
		
		
		this.question = new JLabel();
		this.question.setFont(fontDefault);
		this.question.setText("Welches Wort wird unten dargesetllt (Eingabe zum Überprüfen)?");
		
		this.north.add(this.question);
		
		
		this.guessText = new JTextField();
		this.guessText.setFont(fontInput);
		this.guessText.addActionListener(c1);
		this.guessText.setActionCommand("enter");
		this.north.add(this.guessText);
		
		this.add(north, BorderLayout.NORTH);
		
		//*****CENTER*****
		try {
			this.url = new URL(this.c1.getURL());
			this.icon = new ImageIcon(url);
		} catch (MalformedURLException e) {
			this.icon = new ImageIcon("","Error");
		} catch (NullPointerException n) {
			this.icon = new ImageIcon("","Error");
		}
		this.icon = new ImageIcon(url);
		this.image = this.icon.getImage();
		this.image = image.getScaledInstance(-1, BILDHOEHE, UNDEFINED_CONDITION);
		this.imgLabel = new JLabel(new ImageIcon(image));
		
		this.add(imgLabel, BorderLayout.CENTER);
		
		//*****SOUTH*****
		this.southOben = new Container();
		this.southOben.setLayout(new GridLayout(2,2,0,5));
		
		this.richtigeWoerter = new JLabel("Richtige Wörter:");
		this.richtigeWoerter.setFont(fontDefault);
		this.richtigeWoerter.setHorizontalAlignment(JLabel.CENTER);
		this.southOben.add(this.richtigeWoerter);
		
		this.anzRightWords = new JLabel(Integer.toString(c1.getAnzWortRight()));
		this.anzRightWords.setFont(fontDefault);
		this.anzRightWords.setHorizontalAlignment(JLabel.CENTER);
		this.southOben.add(this.anzRightWords);
		
		this.anzahlWoerter = new JLabel("Anzahl Wörter:");
		this.anzahlWoerter.setFont(fontDefault);
		this.anzahlWoerter.setHorizontalAlignment(JLabel.CENTER);
		this.southOben.add(this.anzahlWoerter);
		
		this.anzWords = new JLabel(Integer.toString(c1.getAnzWoerter()));
		this.anzWords.setFont(fontDefault);
		this.anzWords.setHorizontalAlignment(JLabel.CENTER);
		this.southOben.add(this.anzWords);
		
		
		this.southUnten = new Container();
		this.southUnten.setLayout(new GridLayout(1,2));
		
		
		this.south = new Container();
		this.south.setLayout(new BorderLayout());
		this.south.add(southOben, BorderLayout.NORTH);
		this.south.add(southUnten, BorderLayout.SOUTH);
		
		this.add(south, BorderLayout.SOUTH);
		
	}
	
	/**
	 * Diese Methode gibt den eingegebenen Text zurück, damit er in einer anderen Klasse verarbeitet werden kann.
	 * @return
	 */
	public String getGuessText() {
		return this.guessText.getText();
	}
	
	/**
	 * Diese Methode ändert die Anzahl der richtigen Wörter und die insgesamte Anzahl der Wörter.
	 * @param anzRightWords Anzahl der richtigen Wörter
	 * @param anzWords insgesamte Anzahl der Wörter
	 */
	public void refreshInt(int anzRightWords, int anzWords) {
			this.anzRightWords.setText(anzRightWords + "");
			this.anzWords.setText(anzWords + "");
	}
	
	/**
	 * Diese Methode ändert der Bild zu der als Parameter übergebene URL.
	 * Falls diese URL nicht richtig ist, wird als Bildbeschreibung "ERROR" übergeben.
	 * @param url
	 */
	public void refreshImg(String url) {
		System.out.println("refreshImg: " + url);
		if (this.url != null) {
			try {
				this.url = new URL(url);
				this.icon = new ImageIcon(this.url);
				this.image = this.icon.getImage();
				this.image = image.getScaledInstance(-1, BILDHOEHE, UNDEFINED_CONDITION);
				this.imgLabel.setIcon(new ImageIcon(image));
			} catch (MalformedURLException e) {
				this.url = null;
				this.imgLabel = new JLabel(new ImageIcon("","ERROR"));
			}
		}
	}
	
	public void message (String message, String title, int icon) {
		JOptionPane.showMessageDialog(null, message, title, icon);
	}
}
