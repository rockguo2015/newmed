package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.shared.deliver.UITask;
import com.fudanmed.platform.core.web.shared.deliver.UITaskCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

public interface TaskQueryListPresenterServiceAsync {
  public abstract void filter(final UITaskCriteria uicriteria, final AsyncCallback<IPagedResult<UITask>> callback);
}
