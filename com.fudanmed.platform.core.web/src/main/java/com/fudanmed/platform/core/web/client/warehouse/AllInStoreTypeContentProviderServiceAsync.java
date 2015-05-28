package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCInStoreTypeProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllInStoreTypeContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<RCInStoreTypeProxy>> callback);
}
