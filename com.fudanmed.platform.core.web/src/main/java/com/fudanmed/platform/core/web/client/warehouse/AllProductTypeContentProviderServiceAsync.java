package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy;
import com.fudanmed.platform.core.web.shared.warehouse.AllProductTypeContentProviderCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllProductTypeContentProviderServiceAsync {
  public abstract void load(final AllProductTypeContentProviderCriteria criteria, final AsyncCallback<Collection<RCProductTypeProxy>> callback);
}
