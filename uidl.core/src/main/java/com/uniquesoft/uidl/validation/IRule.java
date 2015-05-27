package com.uniquesoft.uidl.validation;

/**
 * There are two things to do to validate a object,
 * first to check whether it is right,
 * otherwise return a message about the error information
 *
 */
public interface IRule {
	/**
	 * Check whether it is valid
	 * @return true or false about whether it is valid
	 */
	public Boolean checkValid();
	
	/**
	 * get the error information about the check result.
	 * @return error information
	 */
	public String getMessage();
}
