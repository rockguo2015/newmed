package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllWarehouseContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<RCWarehouseProxy>> callback);
}
