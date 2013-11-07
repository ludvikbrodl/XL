package gui.menu;

import gui.XL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

@SuppressWarnings("serial")
class ClearAllMenuItem extends JMenuItem implements ActionListener {
    private XL xl;

	public ClearAllMenuItem(XL xl) {
        super("Clear all");
        this.xl = xl;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        xl.clearAllSlots();
    }
}