package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverOrganizationProxy;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.organization.AllDeliverOrganizationContentProviderService")
public interface AllDeliverOrganizationContentProviderService extends RemoteService {
  public abstract Collection<DLDeliverOrganizationProxy> load();
}
