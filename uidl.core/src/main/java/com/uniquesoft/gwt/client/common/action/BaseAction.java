package com.uniquesoft.gwt.client.common.action;



public abstract class BaseAction<VT> implements ObjectContextAwareAction<VT> {
	@Override
	public boolean checkEnable() {
		return true;
	}
}
