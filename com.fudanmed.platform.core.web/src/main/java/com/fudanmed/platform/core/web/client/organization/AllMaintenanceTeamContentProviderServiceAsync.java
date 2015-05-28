package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllMaintenanceTeamContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<RCMaintenanceTeamProxy>> callback);
}
