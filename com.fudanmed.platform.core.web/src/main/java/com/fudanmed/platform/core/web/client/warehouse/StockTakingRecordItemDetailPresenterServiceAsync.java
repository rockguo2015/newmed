package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingRecordProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecordItem;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface StockTakingRecordItemDetailPresenterServiceAsync {
  public abstract void loadWorkItemStockRecordItemList(final RCStockTakingRecordProxy context, final AsyncCallback<Collection<UIStockTakingRecordItem>> callback);
  
  public abstract void loadValue(final RCStockTakingRecordProxy context, final AsyncCallback<UIStockTakingRecord> callback);
  
  public abstract void generatePrintContents(final RCStockTakingRecordProxy record, final AsyncCallback<String> callback);
}
