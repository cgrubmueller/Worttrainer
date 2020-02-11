package cgrubmueller.view;

import java.awt.*;
import javax.swing.*;
import cgrubmueller.controller.WortTrainerController;

public class AddWortLayout extends JPanel{
	private WortTrainerController c1;
	
	private JLabel newWortText;
	private JLabel newURLText;
	private JTextField newURL;
	private JTextField newWort;
	private JButton bAdd;
	
	private Container north;
	
	public AddWortLayout(WortTrainerController c) {
		this.c1 = c;
		this.setLayout(new BorderLayout());
		this.north = new Container();
		this.north.setLayout(new GridLayout(4,1));
		
		this.newWort = new JTextField("neues Wort");
		this.newWort.setText("Standard Wort");
		this.newWortText = new JLabel("Geben Sie das neue Wort ein!");
		
		this.newURL = new JTextField("neue URL");
		this.newURL.setText("Standard URL");
		this.newURLText = new JLabel("Geben Sie die neue URL zu dem Wort ein!");
		
		this.north.add(newWortText, BorderLayout.NORTH);
		this.north.add(newWort, BorderLayout.NORTH);

		this.north.add(newURLText, BorderLayout.NORTH);
		this.north.add(newURL, BorderLayout.NORTH);
		

		this.bAdd = new JButton("Wort hinzufügen");
		this.bAdd.addActionListener(c1);
		
		this.add(north, BorderLayout.NORTH);
		this.add(bAdd, BorderLayout.SOUTH);
	}
	
	public String getNewWort() {
		System.out.println(this.newWort.getText());
		this.newWort.select(0,4/*this.newWort.getText().length()*/);
		return this.newWort.getSelectedText();
	}
	
	public String getNewURL() {
		System.out.println(this.newURL.getText());
		return this.newURL.getText();
	}
}
