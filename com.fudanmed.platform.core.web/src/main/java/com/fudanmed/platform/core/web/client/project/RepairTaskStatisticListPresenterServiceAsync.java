package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticCriteria;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticData;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface RepairTaskStatisticListPresenterServiceAsync {
  public abstract void loadRepairTaskList(final UIRepairTaskStatisticCriteria uicriteria, final AsyncCallback<Collection<UIRepairTaskStatisticData>> callback);
  
  public abstract void loadOrganization(final RCMaintenanceTeamProxy team, final AsyncCallback<RCOrganizationProxy> callback);
}
