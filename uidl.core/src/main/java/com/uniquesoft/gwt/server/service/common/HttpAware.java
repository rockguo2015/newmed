package com.uniquesoft.gwt.server.service.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interface to be implemented by class that wish to set, get 
 * {@link HttpServletRequest} and {@link HttpServletResponse}. 
 * 
 */
public interface HttpAware {

	/**
	 * Set HttpServletRequest.
	 * 
	 * @param request {@link HttpServletRequest}
	 */
	void setRequest(HttpServletRequest request);

	/**
	 * Get HttpServletRequest.
	 * 
	 * @return
	 */
	HttpServletRequest getRequest();

	/**
	 * Set HttpServletResponse.
	 * 
	 * @param response {@link HttpServletResponse}
	 */
	void setResponse(HttpServletResponse response);

	/**
	 * Get HttpServletResponse.
	 * 
	 * @return
	 */
	HttpServletResponse getResponse();
}
