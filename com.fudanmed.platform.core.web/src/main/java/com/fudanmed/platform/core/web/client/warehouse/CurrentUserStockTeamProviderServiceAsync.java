package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface CurrentUserStockTeamProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<RCMaintenanceTeamProxy>> callback);
}
