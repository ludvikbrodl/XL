package gui;

import java.awt.Color;
import java.util.Observable;

public class CurrentSlot extends Observable {
	private SlotLabel slotLabel;
	
	public CurrentSlot() {
		
	}
	
	public void setSlotLabel(SlotLabel slotLabel) {
		this.slotLabel = slotLabel;
	}
	
	public void updateCurrent(SlotLabel newSlot) {
		slotLabel.setBackground(Color.WHITE);
		newSlot.setBackground(Color.YELLOW);
		slotLabel=newSlot;
		setChanged();
		notifyObservers();
	}
	
	public String getAdress() {
		return slotLabel.getAddress();
	}
	
	
}
