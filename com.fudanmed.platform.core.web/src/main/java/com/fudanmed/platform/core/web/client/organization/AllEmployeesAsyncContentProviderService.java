package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.shared.organization.AllEmployeesAsyncContentProviderCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.organization.AllEmployeesAsyncContentProviderService")
public interface AllEmployeesAsyncContentProviderService extends RemoteService {
  public abstract Collection<RCEmployeeProxy> load(final AllEmployeesAsyncContentProviderCriteria criteria);
}
