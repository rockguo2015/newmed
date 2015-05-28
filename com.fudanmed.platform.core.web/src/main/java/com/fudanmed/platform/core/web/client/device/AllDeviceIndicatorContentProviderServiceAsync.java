package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceIndicatorProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllDeviceIndicatorContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<RCDeviceIndicatorProxy>> callback);
}
