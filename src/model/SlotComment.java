package model;

import java.util.Observable;
import expr.Environment;

public class SlotComment implements Slot {
	public String comment;
	
	public SlotComment(String comment) {
		this.comment = comment;
	}

	@Override
	public double value(Environment env) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String diplayValue(Environment env) {
		// TODO Auto-generated method stub
		return null;
	}

}