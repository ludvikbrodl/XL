package gui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import util.XLException;
import model.Sheet;

@SuppressWarnings("serial")
public class Editor extends JTextField implements KeyListener {
	private Sheet sheet;
	private CurrentSlot currentSlot;
	private StatusLabel statusLabel;

	public Editor(Sheet sheet, CurrentSlot currentSlot, StatusLabel statusLabel) {
		this.sheet = sheet;
		this.currentSlot = currentSlot;
		this.statusLabel = statusLabel;
		setBackground(Color.WHITE);
		addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			try {
				sheet.add(currentSlot.getAdress(), getText());
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

}