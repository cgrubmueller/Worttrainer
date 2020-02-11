package cgrubmueller.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import cgrubmueller.controller.WortTrainerController;

public class FileChooserLayout extends JPanel{
	
	private WortTrainerController c1;
	private JFileChooser chooser;

	public FileChooserLayout(WortTrainerController c) {
		this.chooser = new JFileChooser();
	    this.c1 = new WortTrainerController();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text-Datein", "txt");
	    chooser.setFileFilter(filter);
	    int returnVal = chooser.showOpenDialog(null);
	    this.chooser.addActionListener(c1);
	    
	    this.add(chooser);
	    
	    
	    /*if (chooser.getSelectedFile() == null) {
	    	this.remove(this.chooser);
	    	JOptionPane.showMessageDialog(null, "Fehler: Sie haben keine Datei ausgewählt!", "Fehler", JOptionPane.ERROR_MESSAGE, null);
	    	System.exit(0);
	    } else {
		    this.c1.setPath(chooser.getSelectedFile().getPath());
		    
	    }*/
	}
}
