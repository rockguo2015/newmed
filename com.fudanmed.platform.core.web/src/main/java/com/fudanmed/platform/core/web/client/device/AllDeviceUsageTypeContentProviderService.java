package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceUsageTypeProxy;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.AllDeviceUsageTypeContentProviderService")
public interface AllDeviceUsageTypeContentProviderService extends RemoteService {
  public abstract Collection<RCDeviceUsageTypeProxy> load();
}
