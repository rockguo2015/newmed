package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy;
import com.fudanmed.platform.core.web.shared.warehouse.AllProductTypeContentProviderCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.AllProductTypeContentProviderService")
public interface AllProductTypeContentProviderService extends RemoteService {
  public abstract Collection<RCProductTypeProxy> load(final AllProductTypeContentProviderCriteria criteria);
}
