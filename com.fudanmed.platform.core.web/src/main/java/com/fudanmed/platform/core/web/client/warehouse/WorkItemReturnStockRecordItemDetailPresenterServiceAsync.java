package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemReturnStockRecordProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemReturnStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordItem;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface WorkItemReturnStockRecordItemDetailPresenterServiceAsync {
  public abstract void loadWorkItemStockRecordItemList(final RCWorkItemReturnStockRecordProxy context, final AsyncCallback<Collection<UIWorkItemStockRecordItem>> callback);
  
  public abstract void loadValue(final RCWorkItemReturnStockRecordProxy context, final AsyncCallback<UIWorkItemReturnStockRecord> callback);
}
