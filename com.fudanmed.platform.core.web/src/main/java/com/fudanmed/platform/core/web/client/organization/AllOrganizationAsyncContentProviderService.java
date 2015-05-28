package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.organization.AllOrganizationAsyncContentProviderCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.organization.AllOrganizationAsyncContentProviderService")
public interface AllOrganizationAsyncContentProviderService extends RemoteService {
  public abstract Collection<RCOrganizationProxy> load(final AllOrganizationAsyncContentProviderCriteria criteria);
}
