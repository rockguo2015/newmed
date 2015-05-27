package com.uniquesoft.gwt.client.common;

import java.util.Collection;

import javax.annotation.Nullable;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.gwt.shared.validation.ValidationException;

/**
 * When communicate with the server side, the server side will give a validation
 * for the data, if there is some exceptions ,it will show the error
 * information.
 * 
 * @param <T>
 */
public abstract class ServiceCallback<T> implements AsyncCallback<T> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.gwt.user.client.rpc.AsyncCallback#onFailure(java.lang.Throwable
	 * ) Do different things for different validation exception
	 */
	@Override
	public void onFailure(Throwable caught) {
		if (caught instanceof ValidationException) {
			onValidationException(((ValidationException) caught).getErrors());
		} else if (caught instanceof DataBaseConstraintException) {
			onDataBaseConstraintException((DataBaseConstraintException) caught);
		} else if (caught instanceof SessionTimeOutException) {
			onSessionTimeOutException();
		} else
			Window.alert(caught.getMessage());
	}

	/**
	 * method to deal with ValidationErrorItem
	 * 
	 * @param errors
	 *            the exceptions belong to ValidationErrorItem
	 */
	protected void onValidationException(Collection<ValidationErrorItem> errors) {
		Iterable<String> messages = IterableExtensions.map(errors, new Function1<ValidationErrorItem, String>() {
			@Override
			@Nullable
			public String apply(@Nullable ValidationErrorItem item) {
				return item.getMessage();
			}
		});
		Window.alert("输入项目错误:"+IterableExtensions.join(messages));
	}

	/**
	 * method to deal with DataBaseConstraintException
	 * 
	 * @param caught
	 *            dataBase error
	 */
	protected void onDataBaseConstraintException(
			DataBaseConstraintException caught) {
		throw caught;
	}

	protected void onSessionTimeOutException() {
		throw new SessionTimeOutException();
	}

}
