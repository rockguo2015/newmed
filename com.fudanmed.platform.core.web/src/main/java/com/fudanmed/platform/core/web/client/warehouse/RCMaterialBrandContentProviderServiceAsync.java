package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface RCMaterialBrandContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<RCMaterialBrandProxy>> callback);
}
