package model;

import java.io.IOException;

import expr.ExprParser;
import util.XLException;

public class SlotFactory {
	private static ExprParser exprParser = new ExprParser();

	public SlotFactory() {

	}

	public Slot createSlot(String text) throws XLException {
		if (text.isEmpty()) {
			throw new XLException("String is empty");
		} else if (text.charAt(0) == '#') {
			return new CommentSlot(text);
		} else {
			try {
				return new ExprSlot(exprParser.build(text));
			} catch (IOException e) {
				throw new XLException("Trailing garbabe in expression");
			}
		}
	}
}
