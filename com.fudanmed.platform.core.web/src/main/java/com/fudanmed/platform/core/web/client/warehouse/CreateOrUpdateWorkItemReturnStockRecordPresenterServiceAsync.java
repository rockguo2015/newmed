package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemReturnStockRecordProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemReturnStockRecord;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateWorkItemReturnStockRecordPresenterServiceAsync {
  public abstract void loadValue(final RCWorkItemReturnStockRecordProxy pvalue, final AsyncCallback<UIWorkItemReturnStockRecord> callback);
  
  public abstract void createValue(final UIWorkItemReturnStockRecord uivalue, final AsyncCallback<RCWorkItemReturnStockRecordProxy> callback);
  
  public abstract void getRepairTask(final RCWorkItemTaskProxy workItem, final AsyncCallback<RCRepairTaskProxy> callback);
  
  public abstract void getCurrentUser(final AsyncCallback<RCEmployeeProxy> callback);
  
  public abstract void generatePrintContents(final RCWorkItemReturnStockRecordProxy record, final AsyncCallback<String> callback);
}
