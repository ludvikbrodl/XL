package gui.menu;

import gui.XL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

@SuppressWarnings("serial")
class ClearMenuItem extends JMenuItem implements ActionListener {
	private XL xl;
    public ClearMenuItem(XL xl) {
        super("Clear");
        this.xl = xl;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        xl.clearSelectedSlot();
    }
}