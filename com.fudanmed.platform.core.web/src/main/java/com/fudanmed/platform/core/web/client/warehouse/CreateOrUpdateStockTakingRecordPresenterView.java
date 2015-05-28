package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateStockTakingRecordView;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecord;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = CreateOrUpdateStockTakingRecordView.class)
public interface CreateOrUpdateStockTakingRecordPresenterView extends ViewerWithValidation {
  public abstract UIStockTakingRecord getValue();
  
  public abstract void setValue(final UIStockTakingRecord value);
  
  public abstract void setHostWarehouse(final RCWarehouseProxy hw);
}
