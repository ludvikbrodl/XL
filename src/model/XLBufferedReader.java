package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import util.XLException;

//TODO move to another package
public class XLBufferedReader extends BufferedReader {
    public XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }

    // TODO Change Object to something appropriate
    public void load(Map<String, Slot> map) {
        try {
        	SlotFactory sf = new SlotFactory();
            while (ready()) {
                String string = readLine();
                int i = string.indexOf('=');
                map.put(string.substring(0,i-1), (sf.createSlot(string.substring(i+1))));
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }
}
