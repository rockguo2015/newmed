package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockRecordProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordItem;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import java.util.Collection;

public interface WorkItemStockRecordManagementPresenterServiceAsync {
  public abstract void filter(final UIWorkItemStockRecordCriteria uicriteria, final AsyncCallback<IPagedResult<UIWorkItemStockRecord>> callback);
  
  public abstract void loadDetail(final RCWorkItemStockRecordProxy value, final AsyncCallback<Collection<UIWorkItemStockRecordItem>> callback);
}
