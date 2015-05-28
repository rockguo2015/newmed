package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.RCMaterialBrandContentProviderService")
public interface RCMaterialBrandContentProviderService extends RemoteService {
  public abstract Collection<RCMaterialBrandProxy> load();
}
