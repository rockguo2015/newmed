package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceUsageTypeProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllDeviceUsageTypeContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<RCDeviceUsageTypeProxy>> callback);
}
