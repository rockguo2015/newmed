package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecord;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface WorkItemOutStockRecordListPresenterServiceAsync {
  public abstract void loadWorkItemOutStockRecordList(final RCWorkItemTaskProxy context, final AsyncCallback<Collection<UIWorkItemStockRecord>> callback);
}
