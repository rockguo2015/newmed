package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageSummaryProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorage;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface ProductWarehouseStorageListPresenterServiceAsync {
  public abstract void loadProductWarehouseStorageList(final RCProductWarehouseStorageSummaryProxy context, final AsyncCallback<Collection<UIProductWarehouseStorage>> callback);
}
