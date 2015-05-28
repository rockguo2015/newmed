package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.common.proxy.RCFaultEmergencyLevelProxy;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.organization.AllFaultEmergencyLevelContentProviderService")
public interface AllFaultEmergencyLevelContentProviderService extends RemoteService {
  public abstract Collection<RCFaultEmergencyLevelProxy> load();
}
