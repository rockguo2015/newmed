package com.uniquesoft.uidl.validation.rules;

import com.uniquesoft.uidl.validation.IRule;

/**
 * Check the length of a string.
 * The string length must be in a established length range
 *
 */
public class StringLength implements IRule {

	private String value;
	private int maxLength;
	private int minLength = 0;

	public StringLength(String value) {
		this.value = value;
	}

	public Boolean checkValid() {
		if (value == null)
			return true;
		return value.length() >= minLength && value.length() <= maxLength;
	}

	/**
	 * @return get the maximum length of a string
	 */
	public int getMaxLength() {
		return maxLength;
	}

	/**
	 * Set the maximum length of a string
	 * @param maxLength a integer
	 */
	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	/**
	 * @return get the minimum length of a string
	 */
	public int getMinLength() {
		return minLength;
	}

	/**
	 * Set the minimum length of a string
	 * @param minLength
	 */
	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}

	/* (non-Javadoc)
	 * @see com.uniquesoft.uidl.validation.IRule#getMessage()
	 * Give a error message if the string length is not allowed
	 */
	@Override
	public String getMessage() {
		return String.format("字符串长度必须在 %d 和 %d之间",
				minLength, maxLength);
	}

}
