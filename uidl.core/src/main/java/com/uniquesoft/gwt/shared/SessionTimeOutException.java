package com.uniquesoft.gwt.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Validation exception for session time out
 *
 */
public class SessionTimeOutException extends RuntimeException implements IsSerializable {

	private static final long serialVersionUID = 1L;

	public SessionTimeOutException(){
	}
	
	
}
