package model;

import expr.Environment;
import expr.Expr;

public class Comment extends Expr {
	public String comment;
	
	public Comment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString(int prec) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double value(Environment env) {
		// TODO Auto-generated method stub
		return 0;
	}

}
