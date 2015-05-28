package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.fudanmed.platform.core.web.shared.deliver.CheckOrgContentProviderCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.deliver.CheckOrgContentProviderService")
public interface CheckOrgContentProviderService extends RemoteService {
  public abstract Collection<DLCheckOrganizationProxy> load(final CheckOrgContentProviderCriteria criteria);
}
