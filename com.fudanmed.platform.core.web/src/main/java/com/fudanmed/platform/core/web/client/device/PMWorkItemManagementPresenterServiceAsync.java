package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

public interface PMWorkItemManagementPresenterServiceAsync {
  public abstract void filter(final UIPMWorkItemCriteria uicriteria, final AsyncCallback<IPagedResult<UIPMWorkItem>> callback);
  
  public abstract void finishWorkItem(final RCPMWorkItemProxy value, final AsyncCallback<Void> callback);
  
  public abstract void delete(final RCPMWorkItemProxy value, final AsyncCallback<Void> callback);
}
