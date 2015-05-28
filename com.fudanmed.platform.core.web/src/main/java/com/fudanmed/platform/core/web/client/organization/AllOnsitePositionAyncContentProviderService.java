package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.shared.organization.AllOnsitePositionAyncContentProviderCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.organization.AllOnsitePositionAyncContentProviderService")
public interface AllOnsitePositionAyncContentProviderService extends RemoteService {
  public abstract Collection<RCOnsitePositionProxy> load(final AllOnsitePositionAyncContentProviderCriteria criteria);
}
