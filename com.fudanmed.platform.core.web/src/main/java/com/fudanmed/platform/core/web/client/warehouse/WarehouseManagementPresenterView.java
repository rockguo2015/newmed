package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.WarehouseManagementView;
import com.fudanmed.platform.core.web.shared.warehouse.UIWarehouse;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import java.util.Collection;

@ImplementedBy(value = WarehouseManagementView.class)
public interface WarehouseManagementPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIWarehouse> results);
  
  public abstract void createWarehouseRequest(final RequestHandler requestHandler);
  
  public abstract void updateWarehouseRequest(final RequestHandler1<RCWarehouseProxy> requestHandler);
  
  public abstract void deleteWarehouseRequest(final RequestHandler1<RCWarehouseProxy> requestHandler);
}
