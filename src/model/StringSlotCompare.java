package model;

import java.io.Serializable;
import java.util.Comparator;

public class StringSlotCompare implements Comparator<String>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int compare(String s0, String s1) {
		if(s0 == s1)
			return 0;
		if(s0.charAt(0) == s1.charAt(0)) {
			int i0 = Integer.valueOf(s0.substring(1));
			int i1 = Integer.valueOf(s1.substring(1));
			return Integer.compare(i0, i1);
		}
		return s0.substring(0,1).compareTo(s1.substring(0,1));
	}

}
