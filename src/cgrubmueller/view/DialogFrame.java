package cgrubmueller.view;

import java.awt.*;
import javax.swing.*;

import cgrubmueller.controller.WortTrainerController;

public class DialogFrame extends JDialog{
	private AddWortLayout layout;
	
	public DialogFrame(AddWortLayout layout, WortTrainerController c) {
		this.layout = layout;
		this.layout = new AddWortLayout(c);
		this.setTitle("Wort hinzufügen");
		this.setSize(new Dimension(300,200));
		this.add(this.layout);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
