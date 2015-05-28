package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.project.UIMaintenanceTeam;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface MaintenanceTeamManagementPresenterServiceAsync {
  public abstract void selectAsTeam(final RCOrganizationProxy org, final AsyncCallback<RCMaintenanceTeamProxy> callback);
  
  public abstract void removeFromTeam(final RCMaintenanceTeamProxy team, final AsyncCallback<RCOrganizationProxy> callback);
  
  public abstract void loadTeams(final AsyncCallback<Collection<UIMaintenanceTeam>> callback);
}
