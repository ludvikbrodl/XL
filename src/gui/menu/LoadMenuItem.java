package gui.menu;

import gui.StatusLabel;
import gui.XL;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;

@SuppressWarnings("serial")
class LoadMenuItem extends OpenMenuItem {
 
    public LoadMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Load");
    }

    protected void action(String path) throws FileNotFoundException {
    	try {
			xl.loadFromFile(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
        statusLabel.setText("Sheet loaded from: " + path);
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}