package gui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import util.XLException;

@SuppressWarnings("serial")
public class Editor extends JTextField implements KeyListener, Observer {
	private XL xl;
	private CurrentSlot currentSlot;
	private StatusLabel statusLabel;

	public Editor(XL xl, CurrentSlot currentSlot, StatusLabel statusLabel) {
		this.xl = xl;
		this.currentSlot = currentSlot;
		this.statusLabel = statusLabel;
		setBackground(Color.WHITE);
		addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			try {
				xl.add(currentSlot.getAdress(), getText());
				xl.updateGuiFromModelData();
			} catch (XLException e) {
				statusLabel.updateStatus(e.getMessage());
			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		setText(xl.getStringOfAdress(currentSlot.getAdress()));
	}

}