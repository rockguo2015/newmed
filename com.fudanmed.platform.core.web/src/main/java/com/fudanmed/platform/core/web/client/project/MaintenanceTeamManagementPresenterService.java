package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.project.UIMaintenanceTeam;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.MaintenanceTeamManagementPresenterService")
public interface MaintenanceTeamManagementPresenterService extends RemoteService {
  public abstract RCMaintenanceTeamProxy selectAsTeam(final RCOrganizationProxy org) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCOrganizationProxy removeFromTeam(final RCMaintenanceTeamProxy team) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<UIMaintenanceTeam> loadTeams() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
