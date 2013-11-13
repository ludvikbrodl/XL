package gui.menu;

import gui.CurrentSlot;
import gui.StatusLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import util.XLException;
import model.Sheet;

@SuppressWarnings("serial")
class ClearMenuItem extends JMenuItem implements ActionListener {
	private Sheet sheet;
	private CurrentSlot currentSlot;
	private StatusLabel statusLabel;
	
    public ClearMenuItem(CurrentSlot currentSlot, StatusLabel statusLabel, Sheet sheet) {
        super("Clear");
        this.sheet = sheet;
        this.currentSlot = currentSlot;
        this.statusLabel = statusLabel;
        addActionListener(this);
        
    }

    public void actionPerformed(ActionEvent event) {
        try {
			sheet.remove(currentSlot.getAddress());
		} catch (XLException e) {
			statusLabel.setText(currentSlot.getAddress() + " referas till av en annan ruta! Andra den forst");
		}
    }
}