package model;

import expr.Expr;
import expr.Environment;

public class ExprSlot implements Slot {
	private Expr expr;
	
	public ExprSlot(Expr expr) {
		this.expr = expr;
	}

	@Override
	public double value(Environment env) {
		return expr.value(env);
	}
	
	public String toString() {
		return expr.toString();
	}
	
}
