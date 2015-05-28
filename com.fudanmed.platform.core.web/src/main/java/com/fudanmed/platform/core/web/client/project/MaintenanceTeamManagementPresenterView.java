package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenter;
import com.fudanmed.platform.core.web.client.project.MaintenanceTeamManagementView;
import com.fudanmed.platform.core.web.shared.project.UIMaintenanceTeam;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import java.util.Collection;

@ImplementedBy(value = MaintenanceTeamManagementView.class)
public interface MaintenanceTeamManagementPresenterView extends Viewer {
  public abstract void showTeams(final Collection<UIMaintenanceTeam> teams);
  
  public abstract void selectAsTeam(final RequestHandler1<RCOrganizationProxy> requestHandler);
  
  public abstract void removeFromTeam(final RequestHandler1<RCMaintenanceTeamProxy> requestHandler);
  
  public abstract void setOrganizationOutlinePresenter(final OrganizationOutlinePresenter organizationOutlinePresenter);
}
