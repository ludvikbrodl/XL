package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import util.XLException;

import expr.Environment;
import expr.Expr;

public class Sheet implements Environment {
	private Map<String, Slot> map;
	private static SlotFactory slotFactory = new SlotFactory();

	public Sheet() {
		map = new HashMap<String, Slot>();
	}

	public void add(String key, String text) throws XLException {
		Slot temp = map.get(key);
		Slot newSlot = slotFactory.createSlot(text);
		map.put(key, new BoomSlot());
		try {
			newSlot.value(this);
		} catch (XLException e) {
			map.put(key, temp);
			throw new XLException("Cirkulärt beroende introducerat");
		}
		map.put(key, newSlot);
	}

	@Override
	public double value(String name) {
		return map.get(name).value(this);
	}

	public void saveSheetToFile(String fileName) throws FileNotFoundException {
		XLPrintStream stream = new XLPrintStream(fileName);
		stream.save(map.entrySet());
		stream.close();
	}
	
	public void loadSheetFromFile(String fileName) throws IOException {
		XLBufferedReader reader = new XLBufferedReader(fileName);
		reader.load(map);
		reader.close();
	}
}
