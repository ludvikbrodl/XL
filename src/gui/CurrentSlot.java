package gui;

import java.util.Observable;

public class CurrentSlot extends Observable {
	private String address;
	
	public CurrentSlot() {
		
	}
	
	public void updateCurrent(String address) {
		this.address = address;
		setChanged();
		notifyObservers();
	}
	
	public String getAddress() {
		return address;
	}
	
}
