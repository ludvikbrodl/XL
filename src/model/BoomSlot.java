package model;

import java.util.Observable;

import util.XLException;
import expr.Environment;

public class BoomSlot implements Slot {

	@Override
	public void update(Observable arg0, Object arg1) {

	}

	@Override
	public double value(Environment env) throws XLException {
		throw new XLException("Kaboom");
	}

	@Override
	public String diplayValue(Environment env) {
		return "";
	}

}
