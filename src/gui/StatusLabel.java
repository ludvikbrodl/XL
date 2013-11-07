package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("serial")
public class StatusLabel extends ColoredLabel implements Observer {
    public StatusLabel() {
        super("", Color.WHITE);
    }

    public void update(Observable observable, Object object) {
        setText("");
    }

	public void updateStatus(String newStatusString) {
		setText(newStatusString);
		
	}
}