package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllDeviceTypeContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<RCDeviceTypeProxy>> callback);
}
