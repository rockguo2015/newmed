package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCInStockRecordProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.CreateOrUpdateInStockRecordInitData;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateInStockRecordPresenterServiceAsync {
  public abstract void loadValue(final RCInStockRecordProxy pvalue, final AsyncCallback<UIInStockRecord> callback);
  
  public abstract void updateValue(final UIInStockRecord uivalue, final AsyncCallback<RCInStockRecordProxy> callback);
  
  public abstract void getProductSpecByProductSid(final String productSid, final AsyncCallback<UIProductSpecification> callback);
  
  public abstract void createValue(final UIInStockRecord uivalue, final AsyncCallback<RCInStockRecordProxy> callback);
  
  public abstract void loadCreateOrUpdateInStockRecordInitData(final AsyncCallback<CreateOrUpdateInStockRecordInitData> callback);
  
  public abstract void loadStoreManager(final RCWarehouseProxy store, final AsyncCallback<RCEmployeeProxy> callback);
  
  public abstract void generatePrintContent(final RCInStockRecordProxy inStockRecord, final AsyncCallback<String> callback);
}
