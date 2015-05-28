package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWarehouse;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface WarehouseManagementPresenterServiceAsync {
  public abstract void loadWarehouseList(final AsyncCallback<Collection<UIWarehouse>> callback);
  
  public abstract void deleteWarehouse(final RCWarehouseProxy value, final AsyncCallback<Void> callback);
}
