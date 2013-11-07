package gui.menu;

import gui.StatusLabel;
import gui.XL;

import java.io.FileNotFoundException;

import javax.swing.JFileChooser;

@SuppressWarnings("serial")
class SaveMenuItem extends OpenMenuItem {
    public SaveMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Save");
    }

    protected void action(String path) throws FileNotFoundException {
        xl.saveToFile(path);
        statusLabel.setText("Sheet saved to: " + path);
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}