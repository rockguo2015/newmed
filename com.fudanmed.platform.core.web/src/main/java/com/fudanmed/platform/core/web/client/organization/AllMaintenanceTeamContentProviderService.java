package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.organization.AllMaintenanceTeamContentProviderService")
public interface AllMaintenanceTeamContentProviderService extends RemoteService {
  public abstract Collection<RCMaintenanceTeamProxy> load();
}
