package model;

import expr.Environment;

public class XLEnvironment implements Environment {
	private Sheet ourSheet;
	
	public XLEnvironment(Sheet sheet) {
		ourSheet = sheet;
	}
	@Override
	public double value(String name) {
		return ourSheet.getValue(name).value(this);
	}

}
