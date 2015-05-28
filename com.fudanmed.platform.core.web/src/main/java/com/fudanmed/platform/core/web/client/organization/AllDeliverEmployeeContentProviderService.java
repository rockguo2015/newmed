package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.shared.organization.AllDeliverEmployeeContentProviderCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.organization.AllDeliverEmployeeContentProviderService")
public interface AllDeliverEmployeeContentProviderService extends RemoteService {
  public abstract Collection<RCEmployeeProxy> load(final AllDeliverEmployeeContentProviderCriteria criteria);
}
