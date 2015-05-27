package com.uniquesoft.uidl.validation.rules;

import com.uniquesoft.uidl.validation.IRule;

/**
 * Check whether the number value is in the range
 * 
 */
public class NumberRange implements IRule {

	private Number max;
	private Number min = 0;
	private Number value;

	/**
	 * @return the maximum value for a number
	 */
	public Number getMax() {
		return max;
	}

	/**
	 * Set the maximum number
	 * 
	 * @param max
	 */
	public void setMax(Number max) {
		this.max = max;
	}

	/**
	 * @return get the minimum value of the valid number
	 */
	public Number getMin() {
		return min;
	}

	/**
	 * Set the minimum value of a valid number
	 * 
	 * @param min
	 */
	public void setMin(Number min) {
		this.min = min;
	}

	public NumberRange(Number value) {
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.uniquesoft.uidl.validation.IRule#checkValid() Check the number
	 * value valid or not
	 */
	@Override
	public Boolean checkValid() {
		if (value == null)
			return true;
		return value.doubleValue() >= min.doubleValue()
				&& value.doubleValue() <= max.doubleValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.uniquesoft.uidl.validation.IRule#getMessage() If the number is
	 * not in the valid range, return a error information.
	 */
	@Override
	public String getMessage() {
		return String.format("数值必须在  " + min + " 和  " + max + "之间");
	}

}
