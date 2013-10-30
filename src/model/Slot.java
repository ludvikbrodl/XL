package model;

import java.util.Observable;
import java.util.Observer;

import expr.Expr;
import expr.Environment;

public class Slot extends Observable implements Observer {
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
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}
