package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.TopLevelProductCategoryProviderService")
public interface TopLevelProductCategoryProviderService extends RemoteService {
  public abstract Collection<RCProductCategoryProxy> load();
}
