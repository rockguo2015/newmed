package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCAcquireTypeProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllAquireTypeContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<RCAcquireTypeProxy>> callback);
}
