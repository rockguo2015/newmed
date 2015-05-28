package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.shared.warehouse.AllProductWarehouseStorageContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorage;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllProductWarehouseStorageContentProviderServiceAsync {
  public abstract void load(final AllProductWarehouseStorageContentProviderCriteria criteria, final AsyncCallback<Collection<UIProductWarehouseStorage>> callback);
}
