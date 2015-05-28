package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCAcquireTypeProxy;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.AllAquireTypeContentProviderService")
public interface AllAquireTypeContentProviderService extends RemoteService {
  public abstract Collection<RCAcquireTypeProxy> load();
}
