package model;

import java.util.Observable;
import expr.Environment;

public class CommentSlot implements Slot {
	public String comment;
	
	public CommentSlot(String comment) {
		this.comment = comment;
	}

	@Override
	public double value(Environment env) {
		return 0;
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String diplayValue(Environment env) {
		return comment;
	}

}
