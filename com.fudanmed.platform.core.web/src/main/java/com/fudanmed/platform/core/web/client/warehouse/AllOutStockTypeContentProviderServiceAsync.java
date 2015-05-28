package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.common.proxy.RCOutStockTypeProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllOutStockTypeContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<RCOutStockTypeProxy>> callback);
}
