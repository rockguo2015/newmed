package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.web.shared.organization.AllDeviceSupplierContentProviderCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.organization.AllDeviceSupplierContentProviderService")
public interface AllDeviceSupplierContentProviderService extends RemoteService {
  public abstract Collection<RCSupplierProxy> load(final AllDeviceSupplierContentProviderCriteria criteria);
}
