package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCPrimaryTypeProxy;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.PrimaryTypeContentProviderService")
public interface PrimaryTypeContentProviderService extends RemoteService {
  public abstract Collection<RCPrimaryTypeProxy> load();
}
