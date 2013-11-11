package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import util.XLException;
import expr.Environment;

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
			throw e;
		}
		map.put(key, newSlot);
	}

	public void remove(String key) {
		Slot temp = map.get(key);
		map.put(key, new BoomSlot());
		try {
			Set<String> set = map.keySet();
			for (String k : set){
				if (k!=key){
					map.get(key).value(this);
				}
			}
		} catch (XLException e) {
			map.put(key, temp);
			throw e;
		}
		map.remove(key);
	}

	@Override
	public double value(String name) {
		try {
			return map.get(name).value(this);
		} catch (NullPointerException e) {
			throw new XLException("Uttrycket refererar på en tom ruta (" + name
					+ ")");
		}
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

	public String toString(String adress) {
		try {
			if (map.get(adress) instanceof CommentSlot) {
				return map.get(adress).toString().substring(1);
			}
			return String.valueOf(value(adress));
//			return map.get(adress).toString();
		} catch (NullPointerException e) {
			return "";
		}
	}

	public String exprString(String adress) {
		try {
			return map.get(adress).diplayValue(this);
		} catch (NullPointerException e) {
			return "";
		}// TODO Auto-generated method stub
		
	}

	public void clear() {
		map.clear();
		
	}
}
