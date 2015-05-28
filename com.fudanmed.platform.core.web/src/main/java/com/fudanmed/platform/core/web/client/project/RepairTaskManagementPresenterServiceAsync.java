package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

public interface RepairTaskManagementPresenterServiceAsync {
  public abstract void isDirty(final AsyncCallback<Boolean> callback);
  
  public abstract void filter(final UIRepairTaskCriteria uicriteria, final AsyncCallback<IPagedResult<UIRepairTask>> callback);
  
  public abstract void delete(final RCRepairTaskProxy value, final AsyncCallback<Void> callback);
  
  public abstract void cancel(final RCRepairTaskProxy value, final AsyncCallback<Void> callback);
  
  public abstract void close(final RCRepairTaskProxy value, final AsyncCallback<Void> callback);
}
