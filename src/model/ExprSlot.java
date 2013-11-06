package model;

import java.util.Observable;
import java.util.Observer;

import expr.Expr;
import expr.Environment;

public class ExprSlot extends Observable implements Slot {
	private Expr expr;
	
	public ExprSlot(Expr expr) {
		this.expr = expr;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public double value(Environment env) {
		return expr.value(env);
	}
	@Override
	public String diplayValue(Environment env) {
		return expr.toString();
	}
	
}
