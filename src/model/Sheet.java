package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
			if(temp != null)
				map.put(key, temp);
			else
				map.remove(key);
			throw e;
		}
		map.put(key, newSlot);
	}
	
	public void remove(String key) {
		Slot temp = map.get(key);
		map.put(key, new BoomSlot());
		try {
			for (String keyString : map.keySet()){
				if (keyString != key){
					map.get(keyString).value(this);
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
			throw new XLException("Uttrycket refererar till en tom ruta (" + name
					+ ")");
		}
	}

	public void saveSheetToFile(String fileName) throws FileNotFoundException {
		XLPrintStream stream = new XLPrintStream(fileName);
		stream.save(map.entrySet());
		stream.close();
	}
	
	public void loadSheetFromFile(String fileName) throws IOException {
		map.clear();
		XLBufferedReader reader = new XLBufferedReader(fileName);
		TreeMap<String, Slot> tempMap = new TreeMap<>(new StringSlotCompare());
		reader.load(tempMap);
		reader.close();
		try {
			for(String key: tempMap.keySet())
				add(key, tempMap.get(key).toString());
		} catch (XLException exception) {
			map.clear();
			throw new XLException("Fel i filen");
		}
	}
	
	public boolean isComment(String address) {
		if (map.get(address) instanceof CommentSlot)
			return true;
		return false;
	}

	public String toString(String address) {
		if(map.containsKey(address)) {
			return map.get(address).toString();
		}
		return "";
	}

	public void clear() {
		map.clear();
	}
}
