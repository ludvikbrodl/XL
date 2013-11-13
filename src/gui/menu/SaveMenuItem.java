package gui.menu;

import gui.StatusLabel;
import gui.XL;

import java.io.FileNotFoundException;

import javax.swing.JFileChooser;

import model.Sheet;

@SuppressWarnings("serial")
class SaveMenuItem extends OpenMenuItem {
    private Sheet sheet;

	public SaveMenuItem(XL xl, StatusLabel statusLabel, Sheet sheet) {
        super(xl, statusLabel, "Save");
        this.sheet = sheet;
    }

    protected void action(String path) throws FileNotFoundException {
        sheet.saveSheetToFile(path);
        statusLabel.setText("Sheet saved to: " + path);
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}