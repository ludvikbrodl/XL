package model;

import java.util.HashMap;
import java.util.Map;

import expr.Environment;
import expr.Expr;

public class Sheet implements Environment {
	private Map<String, Slot> map;
	private static SlotFactory slotFactory = new SlotFactory();

	public Sheet() {
		map = new HashMap<String, Slot>();
	}

	public void add(String key, String text) {
		map.put(key, slotFactory.createSlot(text));
	}

	@Override
	public double value(String name) {
		return map.get(name).value(this);
	}
}
