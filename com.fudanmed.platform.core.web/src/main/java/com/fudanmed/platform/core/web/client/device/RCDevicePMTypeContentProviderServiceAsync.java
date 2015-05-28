package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface RCDevicePMTypeContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<RCDevicePMTypeProxy>> callback);
}
