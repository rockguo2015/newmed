package com.uniquesoft.gwt.shared.command;

import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.shared.IGWTEntity;

public interface IContextConsumer<T> {
	
	public void setContext(ActionContext<T> actionContext);

	
}
