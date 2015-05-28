package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.AllWarehouseByManagerContentProviderCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllWarehouseByManagerContentProviderServiceAsync {
  public abstract void load(final AllWarehouseByManagerContentProviderCriteria criteria, final AsyncCallback<Collection<RCWarehouseProxy>> callback);
}
