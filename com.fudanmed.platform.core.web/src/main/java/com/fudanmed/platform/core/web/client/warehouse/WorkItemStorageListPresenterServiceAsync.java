package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStorage;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface WorkItemStorageListPresenterServiceAsync {
  public abstract void loadWorkItemStorageList4GroupTask(final RCGroupTaskProxy context, final AsyncCallback<Collection<UIWorkItemStorage>> callback);
  
  public abstract void loadWorkItemStorageList4RepairTask(final RCRepairTaskProxy context, final AsyncCallback<Collection<UIWorkItemStorage>> callback);
  
  public abstract void loadWorkItemStorageList4WorkItemTask(final RCWorkItemTaskProxy context, final AsyncCallback<Collection<UIWorkItemStorage>> callback);
}
