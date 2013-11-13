package gui.menu;

import gui.StatusLabel;
import gui.XL;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;

import util.XLException;
import model.Sheet;

@SuppressWarnings("serial")
class LoadMenuItem extends OpenMenuItem {
 
    private Sheet sheet;

	public LoadMenuItem(XL xl, StatusLabel statusLabel, Sheet sheet) {
        super(xl, statusLabel, "Load");
        this.sheet = sheet;
    }

    protected void action(String path) throws FileNotFoundException {
    	statusLabel.setText("File successfully loaded from: " + path);
    	try {
			sheet.loadSheetFromFile(path);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XLException e) {
			statusLabel.setText(e.getMessage());
		}
//        statusLabel.setText("Sheet loaded from: " + path);
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}