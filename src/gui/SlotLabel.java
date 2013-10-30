package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SlotLabel extends ColoredLabel implements ActionListener{
    public SlotLabel() {
        super("                    ", Color.WHITE, RIGHT);
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		System.out.println("Hey, Listen!");
		
	}
}