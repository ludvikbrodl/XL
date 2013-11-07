package model;

import java.util.Observer;

import expr.Environment;

public interface Slot {
	public double value(Environment env);
    public String diplayValue(Environment env);
    public String toString();
}
