package com.uniquesoft.uidl.validation;

import org.springframework.stereotype.Component;

import com.uniquesoft.uidl.validation.rules.EMail;
import com.uniquesoft.uidl.validation.rules.StringLength;
import com.uniquesoft.uidl.validation.rules.Required;

/**
 * A factory about all kinds of validation styles.
 *
 */
@Component("com.uniquesoft.uidl.validation.RuleFactory")
public class RuleFactory {

	/**
	 * Check length of a String
	 * 
	 * @param value
	 * @return
	 */
	public StringLength StringLength(String value) {
		return new StringLength(value);
	}

	/**
	 * check whether it exists, if not, return related information
	 * @param value
	 * @return
	 */
	public Required Required(Object value) {
		return new Required(value);
	}

	/**
	 * Check the Email address valid or not
	 * @param value
	 * @return
	 */
	public EMail EMail(String value) {
		return new EMail(value);
	}

	/**
	 * check the phone number available or not 
	 * @param value
	 * @return
	 */
	public com.uniquesoft.uidl.validation.rules.Phone Phone(String value) {
		return new com.uniquesoft.uidl.validation.rules.Phone(value);
	}

	/**
	 * Check  whether the number is in the given range
	 * @param value
	 * @return
	 */
	public com.uniquesoft.uidl.validation.rules.NumberRange NumberRange(
			Number value) {
		return new com.uniquesoft.uidl.validation.rules.NumberRange(value);
	}

}
