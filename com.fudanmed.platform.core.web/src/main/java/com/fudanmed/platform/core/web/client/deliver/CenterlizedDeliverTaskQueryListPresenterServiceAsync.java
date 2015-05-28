package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTaskCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

public interface CenterlizedDeliverTaskQueryListPresenterServiceAsync {
  public abstract void filter(final UICenterlizedDeliverTaskCriteria uicriteria, final AsyncCallback<IPagedResult<UICenterlizedDeliverTask>> callback);
}
