package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemOutStockRecordProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemOutStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordItem;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface WorkItemOutStockRecordItemDetailPresenterServiceAsync {
  public abstract void loadWorkItemStockRecordItemList(final RCWorkItemOutStockRecordProxy context, final AsyncCallback<Collection<UIWorkItemStockRecordItem>> callback);
  
  public abstract void loadValue(final RCWorkItemOutStockRecordProxy context, final AsyncCallback<UIWorkItemOutStockRecord> callback);
  
  public abstract void generatePrintContents(final RCWorkItemOutStockRecordProxy record, final AsyncCallback<String> callback);
}
