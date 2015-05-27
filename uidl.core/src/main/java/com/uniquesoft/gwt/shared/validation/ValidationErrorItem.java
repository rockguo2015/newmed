package com.uniquesoft.gwt.shared.validation;

import java.util.ArrayList;
import java.util.Collection;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Validate the UI logic, and if something is wrong ,give a message about the
 * error.
 * 
 */
public class ValidationErrorItem implements IsSerializable {

	private Collection<String> keys = new ArrayList<String>();

	private String message;

	private String title;

	public ValidationErrorItem() {

	}

	/**
	 * Create a ValidationErrorItem
	 * 
	 * @param message
	 *            prompt information
	 * @param keys
	 */
	public ValidationErrorItem(String message, String... keys) {
		this.message = message;
		for (String key : keys) {
			this.keys.add(key);
		}
	}

	public ValidationErrorItem(String title, String message,
			Collection<String> keys) {
		this.title = title;
		this.message = message;
		for (String key : keys) {
			this.keys.add(key);
		}
	}

	/**
	 * @return the promt information about this kind of error.
	 */
	public String getMessage() {
		return message;
	}

	public String getMessageWithTitle() {
		if (title != null)
			return title + ":" + message;
		else
			return message;
	}

	public Collection<String> getKeys() {
		return keys;
	}

}
