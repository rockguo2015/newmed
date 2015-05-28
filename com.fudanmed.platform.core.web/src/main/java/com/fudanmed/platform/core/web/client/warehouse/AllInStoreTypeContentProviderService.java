package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCInStoreTypeProxy;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.AllInStoreTypeContentProviderService")
public interface AllInStoreTypeContentProviderService extends RemoteService {
  public abstract Collection<RCInStoreTypeProxy> load();
}
