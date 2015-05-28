package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCOutStockRecordProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecordItem;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface OutStockRecordItemDetailPresenterServiceAsync {
  public abstract void loadWorkItemStockRecordItemList(final RCOutStockRecordProxy context, final AsyncCallback<Collection<UIOutStockRecordItem>> callback);
  
  public abstract void loadValue(final RCOutStockRecordProxy context, final AsyncCallback<UIOutStockRecord> callback);
  
  public abstract void generatePrintContents(final RCOutStockRecordProxy record, final AsyncCallback<String> callback);
}
