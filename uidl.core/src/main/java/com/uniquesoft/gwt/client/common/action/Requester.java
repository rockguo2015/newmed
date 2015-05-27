package com.uniquesoft.gwt.client.common.action;

import com.google.gwt.user.client.ui.Widget;
import com.uniquesoft.gwt.client.common.RequestHandler;


public interface Requester {

	Widget asWidget();

	void setRequestHandler(RequestHandler requestHandler);

	void disable();

	void enable();
}
