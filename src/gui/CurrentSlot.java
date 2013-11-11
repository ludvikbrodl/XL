package gui;

import java.util.Observable;

public class CurrentSlot extends Observable {
	private String address;
	
	public CurrentSlot() {
		
	}
	
	public void updateCurrent(SlotLabel newSlot) {
		address = newSlot.getAddress();
		addObserver(newSlot);
		setChanged();
		notifyObservers();
	}
	
	public String getAddress() {
		return address;
	}
	
}
