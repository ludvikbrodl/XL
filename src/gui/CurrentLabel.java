package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("serial")
public class CurrentLabel extends ColoredLabel implements Observer{
	private CurrentSlot currentSlot;
	
    public CurrentLabel(CurrentSlot currentSlot) {
        super("A1", Color.WHITE);
        this.currentSlot = currentSlot;
        currentSlot.addObserver(this);
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg0 instanceof CurrentSlot)
			setText(currentSlot.getAddress());
	}
}