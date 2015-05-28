package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCOutStockRecordProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateOutStockRecordPresenterServiceAsync {
  public abstract void getProductSummaryByProductSid(final String sid, final RCWarehouseProxy store, final AsyncCallback<UIProductWarehouseStorageSummary> callback);
  
  public abstract void loadValue(final RCOutStockRecordProxy pvalue, final AsyncCallback<UIOutStockRecord> callback);
  
  public abstract void updateValue(final UIOutStockRecord uivalue, final AsyncCallback<Void> callback);
  
  public abstract void loadOrganization(final RCMaintenanceTeamProxy team, final AsyncCallback<RCOrganizationProxy> callback);
  
  public abstract void createValue(final UIOutStockRecord uivalue, final AsyncCallback<RCOutStockRecordProxy> callback);
  
  public abstract void getHostWarehouse(final AsyncCallback<RCWarehouseProxy> callback);
  
  public abstract void loadCurrentUser(final AsyncCallback<RCEmployeeProxy> callback);
  
  public abstract void generatePrintContents(final RCOutStockRecordProxy record, final AsyncCallback<String> callback);
}
