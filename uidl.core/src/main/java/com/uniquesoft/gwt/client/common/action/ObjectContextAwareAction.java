package com.uniquesoft.gwt.client.common.action;

import com.uniquesoft.gwt.client.common.RequestHandler;


public interface ObjectContextAwareAction<VT> extends RequestHandler {

	boolean checkEnable();
	
}
