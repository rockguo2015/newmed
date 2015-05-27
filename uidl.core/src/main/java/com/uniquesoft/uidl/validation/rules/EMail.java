package com.uniquesoft.uidl.validation.rules;

import java.util.regex.Pattern;

import com.uniquesoft.uidl.validation.IRule;

/**
 * Check the email address, it must be in accordance with the email address standard
 *
 */
public class EMail implements IRule {

	private String value;
	/**
	 * Email Check,use the express pattern:XXX@XX.XX
	 */
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

	public EMail(String value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see com.uniquesoft.uidl.validation.IRule#checkValid()
	 * Use the regular to check the Email address.
	 */
	@Override
	public Boolean checkValid() {
		if (value == null)
			return true;
		return pattern.matcher(value).matches();
	}

	/* (non-Javadoc)
	 * @see com.uniquesoft.uidl.validation.IRule#getMessage()
	 * If the email address is not valid. return the error message 
	 */
	@Override
	public String getMessage() {
		return "无效邮件格式";
	}

}
