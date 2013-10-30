package model;

import java.util.HashMap;
import java.util.Map;
import expr.Expr;

public class Sheet {
	private Map<String,Expr> map;
	
	public Sheet() {
		map = new HashMap<String,Expr>();
	}
	
	public Expr getValue(String key) {
		return map.get(key);
	}
	
	public void add(String key, Expr value) {
		map.put(key, value);
	}
}
