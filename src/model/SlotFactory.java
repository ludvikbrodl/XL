package model;

import java.io.IOException;

import expr.ExprParser;
import util.XLException;

public class SlotFactory {
	private static ExprParser exprParser = new ExprParser();
	
	public SlotFactory() {
		
	}
	
	public Slot createSlot(String text) throws XLException {
		if (text.charAt(0) == '#') {
			return new CommentSlot(text);
		} else {
			ExprParser xp = new ExprParser();
			try {
				return new ExprSlot(xp.build(text));
			} catch (IOException e) {
				throw new XLException("Trailing garbabe in expression");
			}
		}
	}
}
