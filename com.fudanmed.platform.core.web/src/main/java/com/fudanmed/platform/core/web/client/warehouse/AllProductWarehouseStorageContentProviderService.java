package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.shared.warehouse.AllProductWarehouseStorageContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorage;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.AllProductWarehouseStorageContentProviderService")
public interface AllProductWarehouseStorageContentProviderService extends RemoteService {
  public abstract Collection<UIProductWarehouseStorage> load(final AllProductWarehouseStorageContentProviderCriteria criteria);
}
