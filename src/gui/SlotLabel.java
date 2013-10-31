package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SlotLabel extends ColoredLabel implements MouseListener{
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
}