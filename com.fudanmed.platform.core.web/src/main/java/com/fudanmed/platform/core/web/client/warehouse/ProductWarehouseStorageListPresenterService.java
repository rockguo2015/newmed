package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageSummaryProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorage;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageListPresenterService")
public interface ProductWarehouseStorageListPresenterService extends RemoteService {
  public abstract Collection<UIProductWarehouseStorage> loadProductWarehouseStorageList(final RCProductWarehouseStorageSummaryProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
