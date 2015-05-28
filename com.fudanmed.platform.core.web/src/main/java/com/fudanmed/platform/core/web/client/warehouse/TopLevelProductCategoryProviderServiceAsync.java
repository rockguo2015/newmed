package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface TopLevelProductCategoryProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<RCProductCategoryProxy>> callback);
}
