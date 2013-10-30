package model;

import expr.Expr;
import expr.Environment;

public class Slot {
	private Expr expr;
	
	public Slot(Expr expr) {
		this.expr = expr;
	}
	public double getValue(Environment enviroment) {
		return expr.value(enviroment);
	}
	public Expr getExpr() {
		return expr;
	}
	
}
