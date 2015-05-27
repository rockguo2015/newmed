package com.uniquesoft.gwt.client.common.action;


public interface MutilObjectAction<VT> extends
		ObjectContextAwareAction<VT> {

	void setSelectedObject(Iterable<VT> selectedObjects);

}
