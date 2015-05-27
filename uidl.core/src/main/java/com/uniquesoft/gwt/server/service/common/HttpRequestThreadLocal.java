package com.uniquesoft.gwt.server.service.common;

import javax.servlet.http.HttpServletRequest;

/**
 * This class thread-local {@link HttpServletRequest}. These variables differ from
 * their normal counterparts in that each thread that accesses one (via its
 * <tt>get</tt> or <tt>set</tt> method) has its own, independently initialized
 * copy of the variable.  <tt>HttpRequestThreadLocal</tt> instances are typically private
 * static fields in classes that wish to associate state with a thread .
 *
 *
 */
public class HttpRequestThreadLocal {

	public static final ThreadLocal<HttpServletRequest> userThreadLocal = new ThreadLocal<HttpServletRequest>();

	/**
	 * 
	 * @param request the HttpServletRequest of this thread-local copy 
	 */
	public static void set(HttpServletRequest request) {
		userThreadLocal.set(request);
	}
	/**
	 * 
	 * @return the current thread's HttpServletRequest of this thread-local copy
	 */
	public static HttpServletRequest get() {
		return userThreadLocal.get();
	}

}
