package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWarehouse;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.WarehouseManagementPresenterService")
public interface WarehouseManagementPresenterService extends RemoteService {
  public abstract Collection<UIWarehouse> loadWarehouseList() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void deleteWarehouse(final RCWarehouseProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
