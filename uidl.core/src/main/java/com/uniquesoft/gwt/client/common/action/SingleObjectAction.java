package com.uniquesoft.gwt.client.common.action;


public interface SingleObjectAction<VT> extends
		ObjectContextAwareAction<VT> {

	void setSelectedObject(VT selectedObject);

}
