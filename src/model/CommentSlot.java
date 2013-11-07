package model;

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
	public String diplayValue(Environment env) {
		return comment;
	}

}
