package com.uniquesoft.gwt.server.service.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * Simple HttpAware and BeanFactoryAware implementation,
 * only simple getter, setter mothods
 *
 */
public abstract class BaseService implements HttpAware,BeanFactoryAware {
	
	
	protected BeanFactory beanFactory;

	private HttpServletRequest request;

	private HttpServletResponse response;	

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihealthcare.server.RequestAware#getRequest()
	 */
	@Override
	public HttpServletRequest getRequest() {
		return request;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihealthcare.server.RequestAware#setRequest(javax.servlet.http.
	 * HttpServletRequest)
	 */
	@Override
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihealthcare.server.HttpAware#getResponse()
	 */
	@Override
	public HttpServletResponse getResponse() {
		return response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeihealthcare.server.HttpAware#setResponse(javax.servlet.http.
	 * HttpServletResponse)
	 */
	@Override
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * Set the {@code beanFactory}
	 */
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;		
	}

}
