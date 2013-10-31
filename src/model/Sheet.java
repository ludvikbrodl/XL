package model;

import java.util.HashMap;
import java.util.Map;

import expr.Environment;
import expr.Expr;

public class Sheet implements Environment {
	private Map<String, Slot> map;

	public Sheet() {
		map = new HashMap<String, Slot>();
	}

	public void add(String key, ExprSlot value) {
		map.put(key, value);
	}

	@Override
	public double value(String name) {
		return map.get(name).value(this);
	}
}
