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
	public double getValue(Environment enviroment) {
		return expr.value(enviroment);
	}
	public Expr getExpr() {
		return expr;
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public double value(Environment env) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String diplayValue(Environment env) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
