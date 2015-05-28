package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.CurrentUserStockTeamProviderService")
public interface CurrentUserStockTeamProviderService extends RemoteService {
  public abstract Collection<RCMaintenanceTeamProxy> load();
}
