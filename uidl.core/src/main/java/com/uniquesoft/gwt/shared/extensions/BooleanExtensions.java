package com.uniquesoft.gwt.shared.extensions;

import javax.annotation.Nullable;

/**
 * Deal with the null value for Boolean type.
 *
 */
public class BooleanExtensions {
	
	/**
	 * @param value an boolean value,including true, false, null
	 * @return 	 null or False means logic false, otherwise, logic true
	 */
	public static boolean isLogicTrue(@Nullable Boolean value) {
		return value != null && value;
	}
}
