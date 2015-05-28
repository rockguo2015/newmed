package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.AllDeviceTypeContentProviderService")
public interface AllDeviceTypeContentProviderService extends RemoteService {
  public abstract Collection<RCDeviceTypeProxy> load();
}
