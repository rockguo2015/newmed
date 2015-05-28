package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWarehouse;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateWarehousePresenterServiceAsync {
  public abstract void loadValue(final RCWarehouseProxy pvalue, final AsyncCallback<UIWarehouse> callback);
  
  public abstract void updateValue(final UIWarehouse uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIWarehouse uivalue, final AsyncCallback<Void> callback);
}
