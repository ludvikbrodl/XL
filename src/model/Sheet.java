package model;

import java.util.HashMap;
import java.util.Map;

import expr.Environment;
import expr.Expr;

public class Sheet {
	private Map<String,Slot> map;
	
	public Sheet() {
		map = new HashMap<String,Slot>();
	}
	
	public Expr getValue(String key) {
		return map.get(key).getExpr();
	}
	
	public void add(String key, Slot value) {
		map.put(key, value);
	}
}
