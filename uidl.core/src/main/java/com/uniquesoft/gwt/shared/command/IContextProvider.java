package com.uniquesoft.gwt.shared.command;

import com.uniquesoft.gwt.client.common.action.ActionContext;

public interface IContextProvider<T> {
	public ActionContext<T> getActionContext();

}
