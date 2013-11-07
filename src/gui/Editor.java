package gui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

import model.Sheet;

public class Editor extends JTextField {
	private Sheet sheet;
	private CurrentSlot currentSlot;
	
    public Editor(Sheet sheet, CurrentSlot currentSlot) {
    	this.sheet = sheet;
    	this.currentSlot = currentSlot;
    	
        setBackground(Color.WHITE);
        addKeyListener(new KeyboardListener());
    }
    
    private static class KeyboardListener implements KeyListener {
    	
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == 10) //Enter
				System.out.println(e.getKeyCode());
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {

		}

		
    	
    	
    }
}