package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import util.XLException;
import expr.Environment;

public class Sheet extends Observable implements Environment {
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
		setChanged();
		notifyObservers();
	}

	public void remove(String key) {
		Slot temp = map.get(key);
		map.put(key, new BoomSlot());
		try {
			for (String keyString : map.keySet()){
				if (key != keyString){
					map.get(keyString).value(this);
				}
			}
		} catch (XLException e) {
			map.put(key, temp);
			throw e;
		}
		map.remove(key);
		
		setChanged();
		notifyObservers();
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
		XLBufferedReader reader = new XLBufferedReader(fileName);
		reader.load(map);
		reader.close();
		
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
		
		setChanged();
		notifyObservers();
	}
}
