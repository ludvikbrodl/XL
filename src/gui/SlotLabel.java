package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("serial")
public class SlotLabel extends ColoredLabel implements MouseListener, Observer{
	private CurrentSlot currentSlot;
	private String address;
	
    public SlotLabel(CurrentSlot currentSlot, String address) {
        super("                    ", Color.WHITE, RIGHT);
        this.currentSlot = currentSlot;
        this.address = address;
        addMouseListener(this);
    }

    public String getAddress() {
    	return address;
    }

	@Override
	public void mouseClicked(MouseEvent arg0) {
		currentSlot.updateCurrent(this);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Observable o, Object arg) {
		if(currentSlot.getAdress().equals(address)) {
			setBackground(Color.YELLOW);
		} else {
			setBackground(Color.WHITE);
			currentSlot.deleteObserver(this);
		}
			
	}
}