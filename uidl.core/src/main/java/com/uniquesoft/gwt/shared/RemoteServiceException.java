package com.uniquesoft.gwt.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Validation for remote service
 *
 */
public class RemoteServiceException extends RuntimeException implements
		IsSerializable {

	private static final long serialVersionUID = 1L;

	public RemoteServiceException() {
		super();
	}

	public RemoteServiceException(String message) {
		super(message);
	}

}
