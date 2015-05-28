package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceIndicatorProxy;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.AllDeviceIndicatorContentProviderService")
public interface AllDeviceIndicatorContentProviderService extends RemoteService {
  public abstract Collection<RCDeviceIndicatorProxy> load();
}
