package model;

import util.XLException;
import expr.Environment;

public class BoomSlot implements Slot {

	@Override
	public double value(Environment env) throws XLException {
		throw new XLException("Kaboom! Cirkulart beroende!");
	}

}
