package com.uniquesoft.uidl.validation.rules;

import java.util.regex.Pattern;

import com.uniquesoft.uidl.validation.IRule;

/**
 * Check the phone number valid or not. It contains several numbers
 * and can be separated by some "-"
 *
 */
public class Phone implements IRule {

	private String value;
	private static final String PHONE_PATTERN = "^[0-9\\-]+$";
	private static final Pattern pattern = Pattern.compile(PHONE_PATTERN);

	public Phone(String value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see com.uniquesoft.uidl.validation.IRule#checkValid()
	 * Use java EI to check the phone number 
	 */
	@Override
	public Boolean checkValid() {
		if (value == null)
			return true;
		return pattern.matcher(value).matches();
	}

	/* (non-Javadoc)
	 * @see com.uniquesoft.uidl.validation.IRule#getMessage()
	 * return the error information if the phone number is in the wrong format
	 */
	@Override
	public String getMessage() {
		return "无效电话/传真号码格式";
	}

}
