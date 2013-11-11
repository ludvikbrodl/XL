package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import util.XLException;

import model.Sheet;

@SuppressWarnings("serial")
public class SlotLabel extends ColoredLabel implements Observer {
	private CurrentSlot currentSlot;
	private String address;

	public SlotLabel(CurrentSlot currentSlot, String address) {
		super("                    ", Color.WHITE, RIGHT);
		this.currentSlot = currentSlot;
		this.address = address;
		addMouseListener(new ClickListener());
	}

	public String getAddress() {
		return address;
	}

	@Override
	public void update(Observable observable, Object arg) {
		if(observable.getClass().equals(Sheet.class)) {
			Sheet sheet = (Sheet) observable;
			if(sheet.isComment(address))
				setText(sheet.toString(address).substring(1));
			else {
				try {
					setText(String.valueOf(sheet.value(address)));
				} catch (XLException e) {
					setText("");
				}
			}
		}
		if(currentSlot.getAddress().equals(address)) {
			setBackground(Color.YELLOW);
		} else {
			setBackground(Color.WHITE);
			currentSlot.deleteObserver(this);
		}

	}

	private class ClickListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent event) {
			currentSlot.updateCurrent(SlotLabel.this);
		}

		@Override
		public void mouseEntered(MouseEvent event) {}

		@Override
		public void mouseExited(MouseEvent event) {}

		@Override
		public void mousePressed(MouseEvent event) {}

		@Override
		public void mouseReleased(MouseEvent event) {}	
	}
}