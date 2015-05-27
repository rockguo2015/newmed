package com.uniquesoft.gwt.server.service.common;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gwt.user.client.rpc.RemoteService;

/**
 * This class contains static utility methods that get the {@link RemoteService}
 * by different parameters.
 * 
 */
public final class ServiceUtils {


	/**
	 * Determine a service bean to handle request based on request URL, e.g. a
	 * request ending in "gwt/myService" will be handled by bean with name
	 * "myService".
	 * 
	 * @param request
	 * @return service bean
	 */
	public static RemoteService getService(HttpServletRequest request) {
		String serviceName = getServiceName(request);
		Object service = getService(serviceName, request.getSession()
				.getServletContext());
		if (service instanceof RemoteService) {
			if (service instanceof HttpAware) {
				((HttpAware) service).setRequest(request);
			}
			return (RemoteService) service;
		} else {
			throw new IllegalArgumentException(
					"Spring bean is not a GWT RemoteService: " + serviceName
							+ " (" + service + ")");
		}
	}

	/**
	 * Parse the service name from the request URL.
	 * 
	 * @param request
	 * @return service name
	 */
	public static String getServiceName(HttpServletRequest request) {
		String url = request.getRequestURI();
		String serviceName = url.substring(url.lastIndexOf("/") + 1);
		return serviceName;
	}

	static Boolean listenerInitialized = false;

	/**
	 * Look up a service bean with the specified name in the servlet context.
	 * 
	 * @param name service name
	 * @param servletContext servlet context
	 * @return the service
	 */
	public static Object getService(String name, ServletContext servletContext) {
		WebApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		if (applicationContext == null) {
			throw new IllegalStateException(
					"No Spring web application context found");
		}
		if (!applicationContext.containsBean(name)) {
			throw new IllegalArgumentException("Spring bean not found: " + name);
		}
		Object service = applicationContext.getBean(name);

		return service;
	}

}
