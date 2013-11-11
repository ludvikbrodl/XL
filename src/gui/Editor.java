package gui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Editor extends JTextField implements Observer {
	private XL xl;
	private CurrentSlot currentSlot;

	public Editor(XL xl, CurrentSlot currentSlot, StatusLabel statusLabel) {
		this.xl = xl;
		this.currentSlot = currentSlot;
		setBackground(Color.WHITE);
		addKeyListener(new EnterListener());
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		setText(xl.getStringOfAddress(currentSlot.getAddress()));
	}
	
	private class EnterListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent event) {
			if (event.getKeyCode() == KeyEvent.VK_ENTER) {
				xl.add(currentSlot.getAddress(), getText());
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {}

		@Override
		public void keyTyped(KeyEvent arg0) {}	
	}
}