package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingRecordProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecord;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateStockTakingRecordPresenterServiceAsync {
  public abstract void loadValue(final RCStockTakingRecordProxy pvalue, final AsyncCallback<UIStockTakingRecord> callback);
  
  public abstract void updateValue(final UIStockTakingRecord uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIStockTakingRecord uivalue, final AsyncCallback<RCStockTakingRecordProxy> callback);
  
  public abstract void getHostWarehouse(final AsyncCallback<RCWarehouseProxy> callback);
  
  public abstract void generatePrintContents(final RCStockTakingRecordProxy record, final AsyncCallback<String> callback);
}
