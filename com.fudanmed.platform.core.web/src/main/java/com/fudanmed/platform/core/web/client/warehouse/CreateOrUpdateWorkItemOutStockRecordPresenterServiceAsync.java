package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemOutStockRecordProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemOutStockRecord;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateWorkItemOutStockRecordPresenterServiceAsync {
  public abstract void getProductSummaryByProductSid(final String sid, final RCWarehouseProxy store, final AsyncCallback<UIProductWarehouseStorageSummary> callback);
  
  public abstract void loadValue(final RCWorkItemOutStockRecordProxy pvalue, final AsyncCallback<UIWorkItemOutStockRecord> callback);
  
  public abstract void createValue(final UIWorkItemOutStockRecord uivalue, final AsyncCallback<RCWorkItemOutStockRecordProxy> callback);
  
  public abstract void getRepairTask(final RCWorkItemTaskProxy workItem, final AsyncCallback<RCRepairTaskProxy> callback);
  
  public abstract void generateFitPrintContents(final RCWorkItemOutStockRecordProxy record, final AsyncCallback<String> callback);
  
  public abstract void generatePrintContents(final RCWorkItemOutStockRecordProxy record, final AsyncCallback<String> callback);
  
  public abstract void getCurrentUser(final AsyncCallback<RCEmployeeProxy> callback);
}
