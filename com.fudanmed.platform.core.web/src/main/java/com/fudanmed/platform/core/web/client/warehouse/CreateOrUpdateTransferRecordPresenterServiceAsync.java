package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCTransferRecordProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecord;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateTransferRecordPresenterServiceAsync {
  public abstract void getProductSummaryByProductSid(final String sid, final RCWarehouseProxy store, final AsyncCallback<UIProductWarehouseStorageSummary> callback);
  
  public abstract void loadValue(final RCTransferRecordProxy pvalue, final AsyncCallback<UITransferRecord> callback);
  
  public abstract void updateValue(final UITransferRecord uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UITransferRecord uivalue, final AsyncCallback<RCTransferRecordProxy> callback);
  
  public abstract void getCurrentUser(final AsyncCallback<RCEmployeeProxy> callback);
  
  public abstract void generatePrintContents(final RCTransferRecordProxy record, final AsyncCallback<String> callback);
}
